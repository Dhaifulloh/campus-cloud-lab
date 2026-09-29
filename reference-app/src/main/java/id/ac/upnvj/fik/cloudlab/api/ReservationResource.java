package id.ac.upnvj.fik.cloudlab.api;

import id.ac.upnvj.fik.cloudlab.model.Laboratory;
import id.ac.upnvj.fik.cloudlab.model.Reservation;
import id.ac.upnvj.fik.cloudlab.model.ReservationStatus;
import id.ac.upnvj.fik.cloudlab.service.ReservationEventPublisher;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/reservations")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReservationResource {

    @Inject
    ReservationEventPublisher events;

    @GET
    public List<Reservation> list(@HeaderParam("X-Tenant-ID") String tenantId) {
        requireTenant(tenantId);
        return Reservation.list("tenantCode = ?1 order by startTime desc", tenantId);
    }

    @POST
    @Transactional
    public Response create(@HeaderParam("X-Tenant-ID") String tenantId,
                           CreateReservationRequest request) {
        requireTenant(tenantId);
        if (request == null || request.laboratoryId() == null || request.startTime() == null || request.endTime() == null) {
            throw new BadRequestException("laboratoryId, startTime, and endTime are required");
        }
        if (!request.endTime().isAfter(request.startTime())) {
            throw new BadRequestException("endTime must be after startTime");
        }

        Laboratory lab = Laboratory.findById(request.laboratoryId());
        if (lab == null || !tenantId.equals(lab.tenantCode)) {
            throw new NotFoundException("Laboratory not found in this tenant");
        }

        Reservation reservation = new Reservation();
        reservation.tenantCode = tenantId;
        reservation.laboratory = lab;
        reservation.startTime = request.startTime();
        reservation.endTime = request.endTime();
        reservation.status = ReservationStatus.REQUESTED;
        reservation.purpose = request.purpose();
        reservation.persist();

        String eventId = events.publishCreated(reservation);

        return Response.status(Response.Status.CREATED)
            .header("X-Event-ID", eventId)
            .entity(reservation)
            .build();
    }

    private static void requireTenant(String tenantId) {
        if (tenantId == null || tenantId.isBlank()) {
            throw new BadRequestException("X-Tenant-ID is required");
        }
    }
}
