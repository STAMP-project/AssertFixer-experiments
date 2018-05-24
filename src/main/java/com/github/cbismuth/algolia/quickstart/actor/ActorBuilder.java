package com.github.cbismuth.algolia.quickstart.actor;

public final class ActorBuilder {

    public static ActorBuilder createBuilder() {
        return new ActorBuilder();
    }

    private String objectId;
    private String name;
    private String rating;
    private String alternativeName;
    private String imagePath;

    private ActorBuilder() {
        // NOP
    }

    public ActorBuilder setObjectId(final String objectId) {
        this.objectId = objectId;
        return this;
    }

    public ActorBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public ActorBuilder setRating(final String rating) {
        this.rating = rating;
        return this;
    }

    public ActorBuilder setAlternativeName(final String alternativeName) {
        this.alternativeName = alternativeName;
        return this;
    }

    public ActorBuilder setImagePath(final String imagePath) {
        this.imagePath = imagePath;
        return this;
    }

    public Actor build() {
        return new Actor(objectId, name, rating, alternativeName, imagePath);
    }
}
