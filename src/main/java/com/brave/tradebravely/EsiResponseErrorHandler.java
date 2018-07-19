package com.brave.tradebravely;

import com.brave.tradebravely.service.EsiDelayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class EsiResponseErrorHandler implements ResponseErrorHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final EsiDelayService esiDelayService;

    public EsiResponseErrorHandler(final EsiDelayService esiDelayService) {
        this.esiDelayService = esiDelayService;
    }

    @Override
    public void handleError(final URI url, final HttpMethod method, final ClientHttpResponse response)
            throws IOException {
        logger.warn("{} for path={}", response.getRawStatusCode(), url.getPath());
        esiDelayService.enhanceYourCalm(response.getHeaders());
        handleError(response);
    }

    @Override
    public boolean hasError(final ClientHttpResponse response) throws IOException {
        return response.getRawStatusCode() >= 400;
    }

    String convertStreamToString(java.io.InputStream is) {
        try (java.util.Scanner s = new java.util.Scanner(is).useDelimiter("\\A")) {
            return s.hasNext() ? s.next() : "";
        }
    }

    @Override
    public void handleError(final ClientHttpResponse response) throws IOException {
        final String body = convertStreamToString(response.getBody());
        logger.warn("{}: Body: {}, Headers: {}", response.getRawStatusCode(), body, getHeaders(response));
        String statusText = response.getStatusText();
        if (response.getRawStatusCode() == 520) {
            // 520 may be MailStopSpamming, HttpStatus can't handle 520 though
            throw new HttpClientErrorException(HttpStatus.resolve(420), statusText,
                                               body.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        } else if (response.getRawStatusCode() >= 500) {
            throw new HttpServerErrorException(HttpStatus.resolve(response.getRawStatusCode()),
                                               statusText,
                                               body.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        } else if (response.getRawStatusCode() >= 400) {
            // invalid_token appears if the user has revoked the app's permissions through the eve support website
            if (body.contains("invalid_token")) {
                statusText = "invalid_token";
            }
            throw new HttpClientErrorException(HttpStatus.resolve(response.getRawStatusCode()), statusText,
                                               body.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
        }
    }

    private String getHeaders(final ClientHttpResponse response) {
        return response.getHeaders().entrySet().stream()
                .map(entry -> entry.getKey() + ":" + entry.getValue())
                .collect(Collectors.joining(", "));
    }
}
