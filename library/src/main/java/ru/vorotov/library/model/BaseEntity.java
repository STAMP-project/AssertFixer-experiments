package ru.vorotov.library.model;

public interface BaseEntity {

    String getId();

    void setId(String id);

    default boolean isNew() {
        return getId() == null;
    }
}
