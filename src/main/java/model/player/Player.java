package model.player;

import java.util.UUID;

public class Player {
    private String id;
    private String name;

    public Player(String name) {
        this.id = UUID.randomUUID().toString();//make random id
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
