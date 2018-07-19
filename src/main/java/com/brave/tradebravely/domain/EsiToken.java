package com.brave.tradebravely.domain;

import org.springframework.data.annotation.Id;

import java.util.Set;

public class EsiToken {
    @Id
    private String id;
    private int characterId;
    private String refreshToken;
    // clientId is the id of the eve client (https://developers.eveonline.com/applications)
    private String clientId;

    // required for spring data
    public EsiToken() {
    }

    public EsiToken(Integer characterId, String refreshToken, String clientId) {
        this.characterId = characterId;
        this.refreshToken = refreshToken;
        this.clientId = clientId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCharacterId() {
        return characterId;
    }

    public void setCharacterId(int characterId) {
        this.characterId = characterId;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
