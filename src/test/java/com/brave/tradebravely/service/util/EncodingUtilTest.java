package com.brave.tradebravely.service.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class EncodingUtilTest {

    @Test
    public void getBasicAuth() {
        final String basicAuth = EncodingUtil.getBasicAuth("clientId", "clientSecret");
        assertEquals("Basic Y2xpZW50SWQ6Y2xpZW50U2VjcmV0", basicAuth);
    }
}
