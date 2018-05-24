package com.github.cbismuth.algolia.quickstart.nobel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Affiliation {

    private final String name;
    private final String city;
    private final String country;

    @JsonCreator
    Affiliation(@JsonProperty("name") final String name,
                @JsonProperty("city") final String city,
                @JsonProperty("country") final String country) {
        this.name = name;
        this.city = city;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
