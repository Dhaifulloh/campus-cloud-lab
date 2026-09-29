package id.ac.upnvj.fik.cloudlab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "processed_event")
public class ProcessedEvent extends PanacheEntityBase {
    @Id
    @Column(name = "event_id")
    public String eventId;

    @Column(name = "processed_at", insertable = false, updatable = false)
    public Instant processedAt;
}
