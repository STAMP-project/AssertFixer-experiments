package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.service.AccessTokenService;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CacheableClientTest {

    private AccessTokenService accessTokenService = mock(AccessTokenService.class);
    private final CacheableClient sut = new CacheableClient(accessTokenService) {
        @Override
        Object mapToInternalEntity(Object body) {
            return body;
        }

        @Override
        protected String getClientId() {
            return "clientId";
        }

        @Override
        ResponseEntity doCall(int characterId, String eTag, String accessToken) {
            return ResponseEntity.ok().header("Expires","Fri, 15 Jul 2118 10:35:02 GMT").body("123");
        }
    };

    @Test
    public void get_whenCacheIsNotExpired_returnsResultFromCache() {
        Object expected = "123";
        sut.putIntoCache(1, expected);
        Map<String, List<String>> headers = createHeader("Expires", "Fri, 15 Jul 2118 10:35:02 GMT");
        sut.setExpiresIfPresent(1, headers);

        final Object actual = sut.get(1);
        assertEquals(expected, actual);

        verify(accessTokenService, never()).getAccessToken(1, "clientId");
    }

    @Test
    public void setExpires_withoutExpiresHeader_makesItExpired() {
        Map<String, List<String>> headers = createHeader("Expires", "Fri, 15 Jul 2118 10:35:02 GMT");
        sut.setExpiresIfPresent(1, headers);
        assertFalse(sut.isCacheExpired(1));

        sut.setExpiresIfPresent(1, new HashMap<>());
        assertTrue(sut.isCacheExpired(1));
    }

    @Test
    public void setAndRetrieveETag() {
        assertEquals("", sut.getETag(1));

        final String eTagValue = "ao8bsdft9n88asbdf9";
        sut.setETagIfPresent(1, createHeader("ETag", eTagValue));

        assertEquals(eTagValue, sut.getETag(1));
    }

    @Test
    public void getWithUpdateCache() {
        final Object result = sut.get(2);
        assertEquals("123", result);

        final Object result2 = sut.get(2);
        assertEquals("123", result2);

        // should be cached for the second call
        verify(accessTokenService, times(1)).getAccessToken(2, "clientId");
    }

    @Test
    public void callEsi_clearsCacheAndETagsUponException() {
        CacheableClient sut = new CacheableClient(accessTokenService) {
            @Override
            Object mapToInternalEntity(Object body) {
                return null;
            }

            @Override
            protected String getClientId() {
                return "clientId";
            }

            @Override
            ResponseEntity doCall(int characterId, String eTag, String accessToken) {
                throw new HttpClientErrorException(HttpStatus.FORBIDDEN);
            }
        };

        sut.setETagIfPresent(1, createHeader("ETag", "ao8bsdft9n88asbdf9"));
        sut.setExpiresIfPresent(1, createHeader("Expires", "Fri, 15 Jul 2118 10:35:02 GMT"));

        try {
            sut.callEsi(1, "eTag", "accessToken");
            fail("Should have thrown exception.");
        } catch (HttpClientErrorException ex) {
            // expected
        }

        assertTrue(sut.isCacheExpired(1));
        assertEquals("", sut.getETag(1));
    }

    private Map<String, List<String>> createHeader(final String key, final String value) {
        Map<String, List<String>> headers = new HashMap<>();
        final ArrayList<String> list = new ArrayList<>();
        list.add(value);
        headers.put(key, list);
        return headers;
    }
}
