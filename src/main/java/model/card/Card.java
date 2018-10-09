package model.card;

import java.util.UUID;

public class Card {

    private Type type;
    private String id;

    enum Type {
        Infantry(0), Cavalry(1), Artillery(2);
        private int value;

        Type(int value) {
            this.value = value;
        }
    }

    public Card(Type type) {
        this.id = UUID.randomUUID().toString();
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
