package tech.spring.structure.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class StructureEntity implements Serializable, Comparable<StructureEntity> {

    private static final long serialVersionUID = 764498621264849366L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    protected Long id;

    @Column(nullable = false)
    protected boolean active;

    public StructureEntity() {
        this.active = true;
    }

    public StructureEntity(boolean active) {
        this();
        this.active = active;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object entity) {
        boolean equals = false;
        if (entity != null && entity.getClass().equals(this.getClass())) {
            Long entityId = ((StructureEntity) entity).getId();
            if (entityId != null) {
                equals = entityId.equals(this.getId());
            } else {
                equals = this.getId() == null;
            }
        }
        return equals;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public int compareTo(StructureEntity o) {
        return this.getId().compareTo(o.getId());
    }

}