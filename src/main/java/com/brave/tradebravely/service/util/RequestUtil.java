package com.brave.tradebravely.service.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

public final class RequestUtil {

    private RequestUtil() {
    }

    public static HttpEntity<Object> authorizedRequest(final String etag, final String accessToken) {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + accessToken);
        if (null != etag) {
            headers.add("If-None-Match", etag);
        }
        return new HttpEntity<>(null, headers);
    }
}
