package com.brave.tradebravely.service;

import org.junit.Test;
import org.springframework.http.HttpHeaders;

import static com.brave.tradebravely.service.EsiDelayService.LIMIT_REMAIN;
import static com.brave.tradebravely.service.EsiDelayService.LIMIT_RESET;
import static org.junit.Assert.*;

public class EsiDelayServiceTest {

    private final EsiDelayService sut = new EsiDelayService();

    @Test
    public void enhanceYourCalm_withoutChill() {
        assertFalse(sut.shouldIChill());

        final HttpHeaders headers = new HttpHeaders();
        headers.add(LIMIT_RESET, "100");
        headers.add(LIMIT_REMAIN, "50");
        sut.enhanceYourCalm(headers);

        assertFalse(sut.shouldIChill());
    }

    @Test
    public void enhanceYourCalm_withChill() {
        assertFalse(sut.shouldIChill());

        final HttpHeaders headers = new HttpHeaders();
        headers.add(LIMIT_RESET, "100");
        headers.add(LIMIT_REMAIN, "49");
        sut.enhanceYourCalm(headers);

        assertTrue(sut.shouldIChill());
    }

    @Test
    public void shouldIChill() {
        assertFalse(sut.shouldIChill());

        sut.setExpirySeconds(10);

        assertTrue(sut.shouldIChill());
    }
}
