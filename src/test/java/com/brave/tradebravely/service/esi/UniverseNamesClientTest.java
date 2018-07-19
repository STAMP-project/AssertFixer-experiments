package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.esi.UniverseName;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UniverseNamesClientTest {

    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final EsiProperties esiProperties = new EsiProperties();
    private final UniverseNamesClient sut = new UniverseNamesClient(restTemplate, esiProperties);

    @Before
    public void setUp() throws Exception {
        esiProperties.setBaseUrl("test/");
    }

    @Test
    public void get() {

        final ArgumentCaptor<HttpEntity<Integer[]>> captor = ArgumentCaptor.forClass(HttpEntity.class);
        final UniverseName[] names = { new UniverseName(1, "testName") };
        when(restTemplate.exchange(eq("test/v2/universe/names/"), eq(HttpMethod.POST), captor.capture(), eq(UniverseName[].class)))
            .thenReturn(new ResponseEntity<>(names, HttpStatus.OK));

        final String result = sut.get(1);
        assertEquals("testName", result);
    }

    @Test
    public void getNextChunkSize_withLessThan1000() {
        final int nextChunkSize = sut.getNextChunkSize(500, 0, 1000);
        assertEquals(500, nextChunkSize);
    }

    @Test
    public void getNextChunkSize_withMoreThan1000_inBetween() {
        final int nextChunkSize = sut.getNextChunkSize(3500, 1000, 1000);
        assertEquals(1000, nextChunkSize);
    }

    @Test
    public void getNextChunkSize_withMoreThan1000_atTheEnd() {
        final int nextChunkSize = sut.getNextChunkSize(3000, 2000, 1000);
        assertEquals(1000, nextChunkSize);
    }

    @Test
    public void addNames() {
        // given
        final UniverseName[] names = { new UniverseName(1, "testName") };
        when(restTemplate.exchange(anyString(), any(), any(), eq(UniverseName[].class)))
            .thenReturn(new ResponseEntity<>(names, HttpStatus.OK));
        final List<Integer> ids = new ArrayList<>();
        for (int j = 0; j < 2500; j++) {
            ids.add(j);
        }
        final Map<Integer, String> map = new HashMap<>();

        // when
        sut.addNames(ids, map);

        // then
        verify(restTemplate, times(3)).exchange(anyString(), any(), any(), eq(UniverseName[].class));

    }
}
