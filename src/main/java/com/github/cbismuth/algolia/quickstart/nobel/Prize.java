package com.github.cbismuth.algolia.quickstart.nobel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prize {

    private final Integer year;
    private final String category;
    private final String overallMotivation;
    private final Integer share;
    private final String motivation;
    private final List<Affiliation> affiliations = new ArrayList<>();

    @JsonCreator
    Prize(@JsonProperty("year") final Integer year,
          @JsonProperty("category") final String category,
          @JsonProperty("overallMotivation") final String overallMotivation,
          @JsonProperty("share") final Integer share,
          @JsonProperty("motivation") final String motivation,
          @JsonProperty("affiliations") final List<Affiliation> affiliations) {
        this.year = year;
        this.category = category;
        this.overallMotivation = overallMotivation;
        this.share = share;
        this.motivation = motivation;
        if (affiliations != null) {
            this.affiliations.addAll(affiliations);
        }
    }

    public Integer getYear() {
        return year;
    }

    public String getCategory() {
        return category;
    }

    public String getOverallMotivation() {
        return overallMotivation;
    }

    public Integer getShare() {
        return share;
    }

    public String getMotivation() {
        return motivation;
    }

    public List<Affiliation> getAffiliations() {
        return Collections.unmodifiableList(affiliations);
    }
}
