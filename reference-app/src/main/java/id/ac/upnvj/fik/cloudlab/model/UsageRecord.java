package id.ac.upnvj.fik.cloudlab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "usage_record")
// public class UsageRecord extends PanacheEntity {
public class UsageRecord extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "tenant_code", nullable = false)
    public String tenantCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "laboratory_id")
    public Laboratory laboratory;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    public Reservation reservation;

    @Column(name = "started_at", nullable = false)
    public Instant startedAt;

    @Column(name = "ended_at")
    public Instant endedAt;

    public Integer attendees;
    public String note;
}
