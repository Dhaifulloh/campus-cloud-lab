package id.ac.upnvj.fik.cloudlab.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.upnvj.fik.cloudlab.model.Reservation;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public class ReservationEventPublisher {

    @Inject
    ObjectMapper mapper;

    @Channel("reservation-events")
    Emitter<String> emitter;

    public String publishCreated(Reservation reservation) {
        String eventId = UUID.randomUUID().toString();
        try {
            Map<String, Object> event = new LinkedHashMap<>();
            event.put("eventId", eventId);
            event.put("eventType", "ReservationCreated");
            event.put("version", 1);
            event.put("tenantId", reservation.tenantCode);
            event.put("reservationId", reservation.id);
            event.put("laboratoryId", reservation.laboratory.id);
            event.put("occurredAt", java.time.Instant.now().toString());

            emitter.send(mapper.writeValueAsString(event));
            return eventId;
        } catch (Exception e) {
            throw new IllegalStateException("Unable to publish reservation event", e);
        }
    }
}
