package com.brave.tradebravely.domain;

import org.springframework.data.annotation.Id;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class AccessToken {

    @Id
    private String id;
    private int characterId;
    private AccessTokenType type;
    private Instant created;
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(final String token) {
        this.token = token;
    }

    public boolean isAccessTokenExpired() {
        if (null == created) {
            return true;
        }
        return Instant.now().minus(15, ChronoUnit.MINUTES).isAfter(created);
    }

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(final int characterId) {
        this.characterId = characterId;
    }

    public AccessTokenType getType() {
        return type;
    }

    public void setType(final AccessTokenType type) {
        this.type = type;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(final Instant created) {
        this.created = created;
    }
}
