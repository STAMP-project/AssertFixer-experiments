package com.github.cbismuth.algolia.quickstart.nobel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Laureate {

    private final String objectId;
    private final String firstName;
    private final String surname;
    private final Date born;
    private final Date died;
    private final String bornCountry;
    private final String bornCountryCode;
    private final String bornCity;
    private final String diedCountry;
    private final String diedCountryCode;
    private final String diedCity;
    private final String gender;
    private final List<Prize> prizes = new ArrayList<>();

    @JsonCreator
    Laureate(@JsonProperty("objectID") final String objectId,
             @JsonProperty("firstname") final String firstName,
             @JsonProperty("surname") final String surname,
             @JsonProperty("born") final Date born,
             @JsonProperty("died") final Date died,
             @JsonProperty("bornCountry") final String bornCountry,
             @JsonProperty("bornCountryCode") final String bornCountryCode,
             @JsonProperty("bornCity") final String bornCity,
             @JsonProperty("diedCountry") final String diedCountry,
             @JsonProperty("diedCountryCode") final String diedCountryCode,
             @JsonProperty("diedCity") final String diedCity,
             @JsonProperty("gender") final String gender,
             @JsonProperty("prizes") final List<Prize> prizes) {
        this.objectId = objectId;
        this.firstName = firstName;
        this.surname = surname;
        this.born = born;
        this.died = died;
        this.bornCountry = bornCountry;
        this.bornCountryCode = bornCountryCode;
        this.bornCity = bornCity;
        this.diedCountry = diedCountry;
        this.diedCountryCode = diedCountryCode;
        this.diedCity = diedCity;
        this.gender = gender;
        if (prizes != null) {
            this.prizes.addAll(prizes);
        }
    }

    public String getObjectId() {
        return objectId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBorn() {
        return born;
    }

    public Date getDied() {
        return died;
    }

    public String getBornCountry() {
        return bornCountry;
    }

    public String getBornCountryCode() {
        return bornCountryCode;
    }

    public String getBornCity() {
        return bornCity;
    }

    public String getDiedCountry() {
        return diedCountry;
    }

    public String getDiedCountryCode() {
        return diedCountryCode;
    }

    public String getDiedCity() {
        return diedCity;
    }

    public String getGender() {
        return gender;
    }

    public List<Prize> getPrizes() {
        return Collections.unmodifiableList(prizes);
    }
}
