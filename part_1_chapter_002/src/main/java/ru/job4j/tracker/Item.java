package ru.job4j.tracker;
/**
 * @author Egor Novikov (e.novikov@yahoo.com)
 * @version 1
 * @since 14/06/2018
 */

public class Item {

    private String id;
    private String name;
    private String description;
    private long create;


    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreate() {
        return this.create;
    }

    public void  setCreate(long create) {
        this.create = create;
    }


    public String toString() {
        return String.format("%s %s %s", this.id, this.name, this.description);
    }

}