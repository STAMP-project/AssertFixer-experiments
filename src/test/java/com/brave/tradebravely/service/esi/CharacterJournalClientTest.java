package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Journal;
import com.brave.tradebravely.domain.esi.CharacterWalletJournal;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CharacterJournalClientTest {
    private final EsiProperties esiProperties = new EsiProperties();
    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final CharacterJournalClient sut = new CharacterJournalClient(null, esiProperties, restTemplate);

    @Before
    public void setUp() throws Exception {
        esiProperties.setTradingClientId("123");
        esiProperties.setBaseUrl("https://esi.evetech.net/");
    }

    @Test
    public void getClientId() {
        assertEquals(esiProperties.getTradingClientId(), sut.getClientId());
    }

    @Test
    public void doCall() {
        ResponseEntity expected = ResponseEntity.ok("test");
        String expectedUrl = "https://esi.evetech.net/v4/characters/1/wallet/journal/";
        final ArgumentCaptor<HttpEntity> captor = ArgumentCaptor.forClass(HttpEntity.class);
        when(restTemplate.exchange(eq(expectedUrl), eq(HttpMethod.GET), captor.capture(), eq(CharacterWalletJournal[].class)))
            .thenReturn(expected);

        final ResponseEntity result = sut.doCall(1, "eTag", "accessToken");
        assertEquals(expected, result);

        final HttpEntity requestEntity = captor.getValue();
        assertEquals("Bearer accessToken", requestEntity.getHeaders().getFirst("Authorization"));
        assertEquals("eTag", requestEntity.getHeaders().getFirst("If-None-Match"));
    }

    @Test
    public void mapToInternalEntity() {
        final CharacterWalletJournal[] array = new CharacterWalletJournal[1];
        final CharacterWalletJournal responseJournal = new CharacterWalletJournal();
        responseJournal.setFirstPartyId(1);
        responseJournal.setId(2L);
        responseJournal.setDate("2016-10-24T09:00:00Z");
        responseJournal.setRefType("broker_fee");

        array[0] = responseJournal;

        final List<Journal> transactions = sut.mapToInternalEntity(array);

        assertEquals(1, transactions.size());
        final Journal transaction = transactions.get(0);
        assertNotNull(transaction.getDate());
        assertEquals(1, transaction.getFirstPartyId().intValue());
        assertEquals(2L, transaction.getId().longValue());
        assertEquals("broker_fee", transaction.getRefType());
    }
}
