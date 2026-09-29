package id.ac.upnvj.fik.cloudlab.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "laboratory")
// public class Laboratory extends PanacheEntity {
public class Laboratory extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;
    @Column(name = "tenant_code", nullable = false)
    public String tenantCode;
    public String code;
    public String name;
    public int capacity;
    public String location;
    public boolean active;
}
