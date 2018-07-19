package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.esi.AuthVerificationResponse;
import com.brave.tradebravely.domain.esi.CharacterDetailsResponse;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import static com.brave.tradebravely.security.jwt.JWTConfigurer.AUTHORIZATION_HEADER;
import static com.brave.tradebravely.service.SsoService.LOGIN_EVE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

public class SsoServiceTest {

    private final EsiProperties properties = new EsiProperties();
    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final SsoService sut = new SsoService(restTemplate, properties);

    @Test
    public void getCharacterDetails() {
        final ArgumentCaptor<HttpEntity> captor = ArgumentCaptor.forClass(HttpEntity.class);
        final String someAccessToken = "someAccessToken";
        when(restTemplate.exchange(eq(LOGIN_EVE + "verify"), eq(HttpMethod.GET), captor.capture(), eq(CharacterDetailsResponse.class)))
            .thenReturn(new ResponseEntity<>(new CharacterDetailsResponse(), HttpStatus.OK));

        final CharacterDetailsResponse result = sut.getCharacterDetails(someAccessToken);
        assertNotNull(result);

        final HttpEntity submittedRequest = captor.getValue();
        assertEquals("Bearer " + someAccessToken, submittedRequest.getHeaders().get(AUTHORIZATION_HEADER).get(0));
    }

    @Test
    public void verifyAuthentication() {
        final ArgumentCaptor<HttpEntity> captor = ArgumentCaptor.forClass(HttpEntity.class);
        when(restTemplate.exchange(eq(LOGIN_EVE + "token"), eq(HttpMethod.POST), captor.capture(), eq(AuthVerificationResponse.class)))
            .thenReturn(new ResponseEntity<>(new AuthVerificationResponse(), HttpStatus.OK));

        final AuthVerificationResponse result = sut.verifyAuthentication("someCode");
        assertNotNull(result);

        final HttpEntity submittedRequest = captor.getValue();
        assertFalse(submittedRequest.getHeaders().get(AUTHORIZATION_HEADER).isEmpty());
        final LinkedMultiValueMap body = (LinkedMultiValueMap) submittedRequest.getBody();
        assertEquals("authorization_code", body.get("grant_type").get(0));
        assertEquals("someCode", body.get("code").get(0));

    }
}
