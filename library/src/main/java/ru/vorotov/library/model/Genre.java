package ru.vorotov.library.model;

public class Genre extends AbstractEntity {

    public Genre() {
    }

    public Genre(String genreName) {
        this.name = genreName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Genre(String id, String name) {
        super(id);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                '}';
    }
}
