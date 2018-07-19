package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.esi.AuthVerificationResponse;
import com.brave.tradebravely.domain.esi.CharacterDetailsResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.brave.tradebravely.security.jwt.JWTConfigurer.AUTHORIZATION_HEADER;
import static com.brave.tradebravely.service.util.EncodingUtil.getBasicAuth;

@Service
public class SsoService {

    static final String LOGIN_EVE = "https://login.eveonline.com/oauth/";

    private final RestTemplate restTemplate;
    private final EsiProperties properties;

    public SsoService(final RestTemplate restTemplate, final EsiProperties properties) {
        this.restTemplate = restTemplate;
        this.properties = properties;
    }

    public CharacterDetailsResponse getCharacterDetails(final String accessToken) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add(AUTHORIZATION_HEADER, "Bearer " + accessToken);

        final HttpEntity<Void> request = new HttpEntity<>(null, headers);
        return restTemplate.exchange(LOGIN_EVE + "verify", HttpMethod.GET, request, CharacterDetailsResponse.class).getBody();
    }

    public AuthVerificationResponse verifyAuthentication(final String code) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        headers.add(AUTHORIZATION_HEADER, getBasicAuth(properties.getLoginClientId(), properties.getLoginClientSecret()));

        final MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", "authorization_code");
        map.add("code", code);

        final HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        return restTemplate.exchange(LOGIN_EVE + "token",
            HttpMethod.POST, request, AuthVerificationResponse.class).getBody();
    }
}
