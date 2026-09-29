package id.ac.upnvj.fik.cloudlab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import java.time.Instant;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

// @Entity
// @Table(name = "reservation")
// public class Reservation extends PanacheEntity {
@Entity
@Table(name = "reservation")
public class Reservation extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "tenant_code", nullable = false)
    public String tenantCode;

    @ManyToOne(optional = false)
    @JoinColumn(name = "laboratory_id")
    public Laboratory laboratory;

    @Column(name = "start_time", nullable = false)
    public Instant startTime;

    @Column(name = "end_time", nullable = false)
    public Instant endTime;

    @Enumerated(EnumType.STRING)
    public ReservationStatus status;

    public String purpose;

    @Column(name = "created_at", insertable = false, updatable = false)
    public Instant createdAt;
}
