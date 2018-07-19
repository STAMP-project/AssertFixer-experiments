package com.brave.tradebravely.service.util;

import org.junit.Test;
import org.junit.runner.Request;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import static org.junit.Assert.*;

public class RequestUtilTest {

    @Test
    public void authorizedRequest() {
        final HttpEntity<Object> request = RequestUtil.authorizedRequest("eTag", "accessToken");
        final HttpHeaders headers = request.getHeaders();
        assertEquals("eTag", headers.getFirst("If-None-Match"));
        assertEquals("Bearer accessToken", headers.getFirst("Authorization"));
    }

    @Test
    public void authorizedRequest_withoutETag() {
        final HttpEntity<Object> request = RequestUtil.authorizedRequest(null, "accessToken");
        final HttpHeaders headers = request.getHeaders();
        assertFalse(headers.containsKey("If-None-Match"));
        assertEquals("Bearer accessToken", headers.getFirst("Authorization"));
    }
}
