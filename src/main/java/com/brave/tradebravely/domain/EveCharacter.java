package com.brave.tradebravely.domain;

import org.springframework.data.annotation.Id;

public class EveCharacter {
    @Id
    private Integer id;
    private String name;

    public EveCharacter(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
