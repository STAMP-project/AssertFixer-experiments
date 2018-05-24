package com.github.cbismuth.algolia.quickstart.nobel;

import java.util.Date;
import java.util.List;

public class LaureateBuilder {

    public static LaureateBuilder createBuilder() {
        return new LaureateBuilder();
    }

    private String objectId;
    private String firstName;
    private String surname;
    private Date born;
    private Date died;
    private String bornCountry;
    private String bornCountryCode;
    private String bornCity;
    private String diedCountry;
    private String diedCountryCode;
    private String diedCity;
    private String gender;
    private List<Prize> prizes;

    private LaureateBuilder() {
        // NOP
    }

    public LaureateBuilder setObjectId(final String objectId) {
        this.objectId = objectId;
        return this;
    }

    public LaureateBuilder setFirstName(final String firstName) {
        this.firstName = firstName;
        return this;
    }

    public LaureateBuilder setSurname(final String surname) {
        this.surname = surname;
        return this;
    }

    public LaureateBuilder setBorn(final Date born) {
        this.born = born;
        return this;
    }

    public LaureateBuilder setDied(final Date died) {
        this.died = died;
        return this;
    }

    public LaureateBuilder setBornCountry(final String bornCountry) {
        this.bornCountry = bornCountry;
        return this;
    }

    public LaureateBuilder setBornCountryCode(final String bornCountryCode) {
        this.bornCountryCode = bornCountryCode;
        return this;
    }

    public LaureateBuilder setBornCity(final String bornCity) {
        this.bornCity = bornCity;
        return this;
    }

    public LaureateBuilder setDiedCountry(final String diedCountry) {
        this.diedCountry = diedCountry;
        return this;
    }

    public LaureateBuilder setDiedCountryCode(final String diedCountryCode) {
        this.diedCountryCode = diedCountryCode;
        return this;
    }

    public LaureateBuilder setDiedCity(final String diedCity) {
        this.diedCity = diedCity;
        return this;
    }

    public LaureateBuilder setGender(final String gender) {
        this.gender = gender;
        return this;
    }

    public LaureateBuilder setPrizes(final List<Prize> prizes) {
        this.prizes = prizes;
        return this;
    }

    public Laureate build() {
        return new Laureate(objectId, firstName, surname, born, died, bornCountry, bornCountryCode, bornCity, diedCountry, diedCountryCode, diedCity, gender, prizes);
    }
}
