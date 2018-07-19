package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.service.AccessTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.brave.tradebravely.service.util.DateHelper.parseInstant;

abstract class CacheableClient<T, R> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final Map<Integer, R> cache = new HashMap<>();
    private final Map<Integer, String> eTags = new HashMap<>();
    private final Map<Integer, Instant> localCacheExpiry = new HashMap<>();

    private final AccessTokenService tokenService;

    CacheableClient(final AccessTokenService tokenService) {
        this.tokenService = tokenService;
    }

    boolean isCacheExpired(final int characterId) {
        return localCacheExpiry.getOrDefault(characterId, Instant.EPOCH).isBefore(Instant.now());
    }

    void setExpiresIfPresent(final int characterId, final Map<String, List<String>> headers) {
        if (headers.containsKey("Expires")) {
            localCacheExpiry.put(characterId, parseInstant(headers.get("Expires").get(0)));
        } else {
            localCacheExpiry.put(characterId, Instant.EPOCH);
        }
    }

    String getETag(final int characterId) {
        return eTags.getOrDefault(characterId, "");
    }

    void setETagIfPresent(final int characterId, final Map<String, List<String>> headers) {
        if (headers.containsKey("ETag")) {
            eTags.put(characterId, headers.get("ETag").get(0));
        }
    }

    public R get(final int characterId) {
        return isCacheExpired(characterId) ?
               updateCache(characterId, getETag(characterId)) :
               cache.get(characterId);
    }

    R updateCache(final int characterId, final String eTag) {
        final String accessToken = tokenService.getAccessToken(characterId, getClientId());

        final ResponseEntity<T> response = callEsi(characterId, eTag, accessToken);

        setExpiresIfPresent(characterId, response.getHeaders());

        if (HttpStatus.NOT_MODIFIED == response.getStatusCode()) {
            return cache.get(characterId);
        } else {
            final T body = response.getBody();
            log.debug("Body for {}: {}", characterId, body);
            if (null != body) {
                setETagIfPresent(characterId, response.getHeaders());
                R result = mapToInternalEntity(body);
                putIntoCache(characterId, result);
                return result;
            } else {
                return null;
            }
        }
    }

    abstract R mapToInternalEntity(T body);

    void putIntoCache(int characterId, R item) {
        cache.put(characterId, item);
    }

    ResponseEntity<T> callEsi(int characterId, String eTag, String accessToken) {
        try {
            return doCall(characterId, eTag, accessToken);
        } catch (final HttpClientErrorException | HttpServerErrorException ex) {
            eTags.remove(characterId);
            localCacheExpiry.remove(characterId);
            throw ex;
        }
    }

    protected abstract String getClientId();

    abstract ResponseEntity<T> doCall(final int characterId, final String eTag, final String accessToken);
}
