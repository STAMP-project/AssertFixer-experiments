package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.EsiToken;
import com.brave.tradebravely.domain.esi.AccessTokenResponse;
import com.brave.tradebravely.service.util.EncodingUtil;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.*;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class AccessTokenServiceTest {

    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final EsiProperties esiProperties = new EsiProperties();
    private final EsiTokenService esiTokenService = mock(EsiTokenService.class);
    private final AccessTokenService sut = new AccessTokenService(restTemplate, esiProperties, esiTokenService);

    @Test
    public void createAccessTokenWithRefreshToken() {
        ArgumentCaptor<HttpEntity> requestCaptor = ArgumentCaptor.forClass(HttpEntity.class);

        final AccessTokenResponse responseBody = new AccessTokenResponse();
        responseBody.setAccessToken("test");
        when(restTemplate.exchange(eq("https://login.eveonline.com/oauth/token"), eq(HttpMethod.POST), requestCaptor.capture(), eq(AccessTokenResponse.class), isA(HashMap.class)))
            .thenReturn(ResponseEntity.ok(responseBody));

        final String accessToken = sut.createAccessTokenWithRefreshToken("refreshToken", "clientId", "clientSecret");
        assertEquals("test", accessToken);

        final HttpEntity request = requestCaptor.getValue();
        final HttpHeaders headers = request.getHeaders();
        assertEquals(2, headers.size());
        assertEquals(MediaType.APPLICATION_FORM_URLENCODED, headers.getContentType());
        assertEquals(EncodingUtil.getBasicAuth("clientId", "clientSecret"), headers.get("Authorization").get(0));

        final MultiValueMap<String, String> body = (MultiValueMap<String, String>) request.getBody();
        assertEquals("refresh_token", body.getFirst("grant_type"));
        assertEquals("refreshToken", body.getFirst("refresh_token"));
    }

    @Test
    public void getAccessToken() {
        esiProperties.setLoginClientId("aClientId");
        esiProperties.setLoginClientSecret("aClientSecret");

        when(esiTokenService.find(1, "aClientId"))
            .thenReturn(Optional.of(new EsiToken(1, "refreshToken","aClientId")));

        final AccessTokenResponse responseBody = new AccessTokenResponse();
        responseBody.setAccessToken("test");
        when(restTemplate.exchange(eq("https://login.eveonline.com/oauth/token"), eq(HttpMethod.POST), isA(HttpEntity.class), eq(AccessTokenResponse.class), isA(HashMap.class)))
            .thenReturn(ResponseEntity.ok(responseBody));


        final String result = sut.getAccessToken(1, "aClientId");

        assertEquals("test", result);
        verify(esiTokenService).find(1, "aClientId");
    }

    @Test(expected = RuntimeException.class)
    public void getAccessToken_failsForInvalidClientId() {
        when(esiTokenService.find(1, "invalidClientId"))
            .thenReturn(Optional.of(new EsiToken(1, "refreshToken","aClientId")));

        sut.getAccessToken(1, "invalidClientId");
    }

    @Test
    public void getAccessToken_whenCharacterHasNoToken_returnsNull() {
        when(esiTokenService.find(1, "clientId"))
            .thenReturn(Optional.empty());

        final String result = sut.getAccessToken(1, "clientId");
        assertNull(result);
    }
}
