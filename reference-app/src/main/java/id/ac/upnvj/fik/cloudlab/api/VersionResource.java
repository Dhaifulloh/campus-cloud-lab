package id.ac.upnvj.fik.cloudlab.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/version")
public class VersionResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String version() {
        return "campus-cloud-app v2";
    }
}