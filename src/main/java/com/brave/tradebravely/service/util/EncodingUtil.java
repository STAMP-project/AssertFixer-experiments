package com.brave.tradebravely.service.util;

import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

public final class EncodingUtil {

    private EncodingUtil() {
    }

    public static String getBasicAuth(final String clientId, final String clientSecret) {
        final String auth = clientId + ":" + clientSecret;
        final byte[] encodedAuth = Base64.encodeBase64(
            auth.getBytes(Charset.forName("UTF-8")));
        return "Basic " + new String(encodedAuth);
    }
}
