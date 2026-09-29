package id.ac.upnvj.fik.cloudlab.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.ac.upnvj.fik.cloudlab.model.ProcessedEvent;
import io.smallrye.reactive.messaging.annotations.Blocking;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

@ApplicationScoped
public class ReservationEventConsumer {

    private static final Logger LOG = Logger.getLogger(ReservationEventConsumer.class);

    @Inject
    ObjectMapper mapper;

    @Incoming("reservation-events-in")
    @Blocking
    @Transactional
    public void consume(String json) throws Exception {
        JsonNode root = mapper.readTree(json);
        String eventId = root.path("eventId").asText();

        if (eventId == null || eventId.isBlank()) {
            throw new IllegalArgumentException("eventId is required");
        }

        if (ProcessedEvent.findById(eventId) != null) {
            LOG.infov("Duplicate event ignored: {0}", eventId);
            return;
        }

        ProcessedEvent marker = new ProcessedEvent();
        marker.eventId = eventId;
        marker.persist();

        LOG.infov("Processed event {0} for tenant {1}", eventId, root.path("tenantId").asText());
    }
}
