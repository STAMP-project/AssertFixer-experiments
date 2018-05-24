package com.github.cbismuth.algolia.quickstart.nobel;

import java.util.List;

public class PrizeBuilder {

    public static PrizeBuilder createBuilder() {
        return new PrizeBuilder();
    }

    private Integer year;
    private String category;
    private String overallMotivation;
    private Integer share;
    private String motivation;
    private List<Affiliation> affiliations;

    private PrizeBuilder() {
        // NOP
    }

    public PrizeBuilder setYear(final Integer year) {
        this.year = year;
        return this;
    }

    public PrizeBuilder setCategory(final String category) {
        this.category = category;
        return this;
    }

    public PrizeBuilder setOverallMotivation(final String overallMotivation) {
        this.overallMotivation = overallMotivation;
        return this;
    }

    public PrizeBuilder setShare(final Integer share) {
        this.share = share;
        return this;
    }

    public PrizeBuilder setMotivation(final String motivation) {
        this.motivation = motivation;
        return this;
    }

    public PrizeBuilder setAffiliations(final List<Affiliation> affiliations) {
        this.affiliations = affiliations;
        return this;
    }

    public Prize build() {
        return new Prize(year, category, overallMotivation, share, motivation, affiliations);
    }
}
