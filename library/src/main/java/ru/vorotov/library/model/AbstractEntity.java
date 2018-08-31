package ru.vorotov.library.model;

import org.hibernate.Hibernate;
import org.springframework.data.annotation.Id;


public abstract class AbstractEntity implements BaseEntity{

    @Id
    private String id;

    protected AbstractEntity() {
    }

    protected AbstractEntity(String id) {
        this.id = id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("AbstractEntity %s (%s)", getClass().getName(), getId());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || !getClass().equals(Hibernate.getClass(o))) {
            return false;
        }
        AbstractEntity that = (AbstractEntity) o;
        return getId() != null && getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return (getId() == null) ? 0 : getId().hashCode();
    }
}
