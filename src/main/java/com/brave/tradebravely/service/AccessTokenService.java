package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.esi.AccessTokenResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

import static com.brave.tradebravely.service.util.EncodingUtil.getBasicAuth;

@CacheConfig(cacheNames = {"accessTokens"})
@Service
public class AccessTokenService {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final RestTemplate restTemplate;
    private final EsiProperties esiProperties;
    private final EsiTokenService esiTokenService;

    public AccessTokenService(final RestTemplate restTemplate, EsiProperties esiProperties, EsiTokenService esiTokenService) {
        this.restTemplate = restTemplate;
        this.esiProperties = esiProperties;
        this.esiTokenService = esiTokenService;
    }

    @Cacheable(key = "{#characterId + '' + #clientId}")
    public String getAccessToken(final int characterId, final String clientId) {
        log.info("Generating new access token for user={} and clientId={}.", characterId, clientId);

        return esiTokenService.find(characterId, clientId)
            .map(esiToken -> createAccessTokenWithRefreshToken(esiToken.getRefreshToken(), clientId, esiProperties.getSecretForClientId(clientId)))
            .orElse(null);
    }

    String createAccessTokenWithRefreshToken(final String refreshToken, final String clientId,
                                             final String clientSecret) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        final String authHeader = getBasicAuth(clientId, clientSecret);
        headers.add("Authorization", authHeader);

        final MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "refresh_token");
        map.add("refresh_token", refreshToken);

        final HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        return restTemplate.exchange("https://login.eveonline.com/oauth/token", HttpMethod.POST, request,
            AccessTokenResponse.class, new HashMap<>()).getBody().getAccessToken();
    }
}
