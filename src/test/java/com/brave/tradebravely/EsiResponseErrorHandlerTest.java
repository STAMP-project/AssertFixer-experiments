package com.brave.tradebravely;

import com.brave.tradebravely.service.EsiDelayService;
import org.apache.commons.io.input.CharSequenceInputStream;
import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.mock.http.client.MockClientHttpResponse;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EsiResponseErrorHandlerTest {

    private final EsiDelayService esiDelayService = mock(EsiDelayService.class);
    private final EsiResponseErrorHandler sut = new EsiResponseErrorHandler(esiDelayService);

    @Test
    public void handleError_shouldDelegateToDelayService() throws IOException {
        // no exception should be thrown with an OK code
        ClientHttpResponse response = new MockClientHttpResponse(new byte[0], HttpStatus.OK);
        response.getHeaders().add("test", "test");
        URI url = URI.create("https://github.com");

        sut.handleError(url, HttpMethod.POST, response);

        verify(esiDelayService).enhanceYourCalm(response.getHeaders());
    }

    @Test
    public void hasError_whenErrorCode400AndGreater_returnsTrue() throws IOException {
        byte[] body = new byte[0];
        assertTrue(sut.hasError(new MockClientHttpResponse(body, HttpStatus.BAD_REQUEST)));
        assertTrue(sut.hasError(new MockClientHttpResponse(body, HttpStatus.FORBIDDEN)));
        assertTrue(sut.hasError(new MockClientHttpResponse(body, HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    @Test
    public void hasError_whenErrorCodeLessThan400_returnsFalse() throws IOException {
        byte[] body = new byte[0];
        assertFalse(sut.hasError(new MockClientHttpResponse(body, HttpStatus.PERMANENT_REDIRECT)));
        assertFalse(sut.hasError(new MockClientHttpResponse(body, HttpStatus.OK)));
        assertFalse(sut.hasError(new MockClientHttpResponse(body, HttpStatus.CREATED)));
    }

    @Test
    public void convertStreamToString() {
        final String result = sut.convertStreamToString(new CharSequenceInputStream("test\nnewline", "UTF-8"));
        assertEquals("test\nnewline", result);
    }

    @Test(expected = HttpClientErrorException.class)
    public void handleError_withClientError_shouldThrowClientException() throws IOException {
        ClientHttpResponse response = new MockClientHttpResponse(new byte[0], HttpStatus.FORBIDDEN);
        sut.handleError(response);
    }

    @Test(expected = HttpServerErrorException.class)
    public void handleError_withServerError_shouldThrowServerException() throws IOException {
        ClientHttpResponse response = new MockClientHttpResponse(new byte[0], HttpStatus.INTERNAL_SERVER_ERROR);
        sut.handleError(response);
    }

    @Test
    public void handleError_with520StatusCode_shouldMapTo420() throws IOException {
        // the response can't handle the 520 status code, so we have to mock the class
        ClientHttpResponse response = mock(ClientHttpResponse.class);
        when(response.getRawStatusCode()).thenReturn(520);
        when(response.getBody()).thenReturn(new CharSequenceInputStream("", "UTF-8"));
        when(response.getHeaders()).thenReturn(new HttpHeaders());

        try {
            sut.handleError(response);
            fail("Exception not found.");
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (HttpClientErrorException e) {
            assertEquals(420, e.getRawStatusCode());
        }
    }

    @Test
    public void handleError_withInvalidToken_shouldMapStatusTest() {
        InputStream is = new CharSequenceInputStream("{invalid_token: test}", "UTF-8");
        ClientHttpResponse response = new MockClientHttpResponse(is, HttpStatus.UNAUTHORIZED);
        try {
            sut.handleError(response);
            fail("Exception not found.");
        } catch (IOException e) {
            fail(e.getMessage());
        } catch (HttpClientErrorException e) {
            assertEquals("invalid_token", e.getStatusText());
        }
    }



}
