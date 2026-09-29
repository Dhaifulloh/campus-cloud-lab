package id.ac.upnvj.fik.cloudlab.api;

import id.ac.upnvj.fik.cloudlab.model.Laboratory;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/laboratories")
@Produces(MediaType.APPLICATION_JSON)
public class LaboratoryResource {

    @GET
    public List<Laboratory> list(@HeaderParam("X-Tenant-ID") String tenantId) {
        requireTenant(tenantId);
        return Laboratory.list("tenantCode = ?1 and active = true order by code", tenantId);
    }

    private static void requireTenant(String tenantId) {
        if (tenantId == null || tenantId.isBlank()) {
            throw new BadRequestException("X-Tenant-ID is required");
        }
    }
}
