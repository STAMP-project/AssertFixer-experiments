package ru.vorotov.library.model;


public class Author extends AbstractEntity {

    public Author() {}

    private String fullName;

    public Author(String id, String fullName) {
        super(id);//
        this.fullName = fullName;
    }


    public Author(String fullName) {
        this.fullName = fullName;
    }


    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + getId() +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}