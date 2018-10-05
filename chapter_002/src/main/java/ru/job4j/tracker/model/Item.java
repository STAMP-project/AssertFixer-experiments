package ru.job4j.tracker.model;

public class Item {
    private String id;
    public String name;
    private String description;

    public Item() {
    }
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name; }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

}