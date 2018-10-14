package com.cryptoeagle.entity.crypto;

import com.cryptoeagle.entity.BaseEntity;
import com.cryptoeagle.entity.Ico;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



@Embeddable
public class IcoData {

    @Column(length = 1024)
    private String intro;

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> links = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> finance = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Map<String, String> categories = new HashMap<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Team> crew = new HashSet<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Exchange> exchanges = new HashSet<>();



    public void setCrew(Team team) {
        crew.add(team);
    }

    public Set<Team> getCrew() {
        return crew;
    }

    public void setLink(String link, String value) {
        links.put(link, value);
    }

    public void setFinance(String link, String value) {
        finance.put(link, value);
    }

    public void setCategories(String link, String value) {
        categories.put(link, value);
    }

    public String getLink(String link) {
        return links.get(link);
    }

    public String getFinance(String link) {
        return finance.get(link);
    }

    public String getCategories(String link) {
        return categories.get(link);
    }

    public void setEchanges(Exchange exchange) {
        exchanges.add(exchange);
    }

    public Set<Exchange> getEchanges() {
        return exchanges;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }
}