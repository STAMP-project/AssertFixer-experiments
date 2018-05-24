package com.github.cbismuth.algolia.quickstart.actor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Actor {

    private final String objectId;
    private final String name;
    private final String rating;
    private final String alternativeName;
    private final String imagePath;

    @JsonCreator
    Actor(@JsonProperty("objectID") final String objectId,
          @JsonProperty("name") final String name,
          @JsonProperty("rating") final String rating,
          @JsonProperty("alternative_name") final String alternativeName,
          @JsonProperty("image_path") final String imagePath) {
        this.objectId = objectId;
        this.name = name;
        this.rating = rating;
        this.alternativeName = alternativeName;
        this.imagePath = imagePath;
    }

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public String getRating() {
        return rating;
    }

    public String getAlternativeName() {
        return alternativeName;
    }

    public String getImagePath() {
        return imagePath;
    }
}
