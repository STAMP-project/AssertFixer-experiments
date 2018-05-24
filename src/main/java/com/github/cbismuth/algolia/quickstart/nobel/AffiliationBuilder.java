package com.github.cbismuth.algolia.quickstart.nobel;

public class AffiliationBuilder {

    public static AffiliationBuilder createBuilder() {
        return new AffiliationBuilder();
    }

    private String name;
    private String city;
    private String country;

    private AffiliationBuilder() {
        // NOP
    }

    public AffiliationBuilder setName(final String name) {
        this.name = name;
        return this;
    }

    public AffiliationBuilder setCity(final String city) {
        this.city = city;
        return this;
    }

    public AffiliationBuilder setCountry(final String country) {
        this.country = country;
        return this;
    }

    public Affiliation build() {
        return new Affiliation(name, city, country);
    }
}
