package com.brave.tradebravely.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "esi")
@Component
public class EsiProperties {

    private String loginClientId;
    private String loginClientSecret;
    private String tradingClientId;
    private String tradingClientSecret;
    private String baseUrl;


    public void setLoginClientId(String loginClientId) {
        this.loginClientId = loginClientId;
    }

    public void setLoginClientSecret(String loginClientSecret) {
        this.loginClientSecret = loginClientSecret;
    }

    public String getLoginClientId() {
        return loginClientId;
    }

    public String getLoginClientSecret() {
        return loginClientSecret;
    }

    public String getSecretForClientId(String clientId) {
        if (clientId.equals(loginClientId)) {
            return loginClientSecret;
        } else if (clientId.equals(tradingClientId)) {
            return tradingClientSecret;
        }

        throw new RuntimeException("No client defined for id " + clientId);
    }

    public String getTradingClientId() {
        return tradingClientId;
    }

    public void setTradingClientId(String tradingClientId) {
        this.tradingClientId = tradingClientId;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getTradingClientSecret() {
        return tradingClientSecret;
    }

    public void setTradingClientSecret(String tradingClientSecret) {
        this.tradingClientSecret = tradingClientSecret;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
}
