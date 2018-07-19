package com.brave.tradebravely.service.esi;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.domain.esi.CharacterWalletTransaction;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CharacterTransactionsClientTest {

    private final EsiProperties esiProperties = new EsiProperties();
    private final RestTemplate restTemplate = mock(RestTemplate.class);
    private final UniverseNamesClient namesClient = mock(UniverseNamesClient.class);
    private final CharacterTransactionsClient sut = new CharacterTransactionsClient(null, esiProperties, restTemplate, namesClient);

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
        String expectedUrl = "https://esi.evetech.net/v1/characters/1/wallet/transactions/";
        final ArgumentCaptor<HttpEntity> captor = ArgumentCaptor.forClass(HttpEntity.class);
        when(restTemplate.exchange(eq(expectedUrl), eq(HttpMethod.GET), captor.capture(), eq(CharacterWalletTransaction[].class)))
            .thenReturn(expected);

        final ResponseEntity result = sut.doCall(1, "eTag", "accessToken");
        assertEquals(expected, result);

        final HttpEntity requestEntity = captor.getValue();
        assertEquals("Bearer accessToken", requestEntity.getHeaders().getFirst("Authorization"));
        assertEquals("eTag", requestEntity.getHeaders().getFirst("If-None-Match"));
    }

    @Test
    public void mapToInternalEntity() {
        Map<Integer, String> typeNames = new HashMap<>();
        typeNames.put(1, "typeName");
        when(namesClient.get(Collections.singletonList(1)))
            .thenReturn(typeNames);

        final CharacterWalletTransaction[] array = new CharacterWalletTransaction[1];
        final CharacterWalletTransaction responseTransaction = new CharacterWalletTransaction();
        responseTransaction.setTypeId(1);
        responseTransaction.setTransactionId(2L);
        responseTransaction.setDate("2016-10-24T09:00:00Z");

        array[0] = responseTransaction;

        final List<Transaction> transactions = sut.mapToInternalEntity(array);

        assertEquals(1, transactions.size());
        final Transaction transaction = transactions.get(0);
        // see description in tested method
        assertNull(transaction.getCharacterId());
        assertNotNull(transaction.getDate());
        assertEquals(1, transaction.getTypeId().intValue());
        assertEquals(2L, transaction.getTransactionId().longValue());
        assertEquals("typeName", transaction.getTypeName());
    }

    @Test
    public void getTypeNames() {
        final CharacterWalletTransaction[] array = new CharacterWalletTransaction[2];
        array[0] = createNewTransaction(1);
        array[1] = createNewTransaction(2);

        sut.getTypeNames(array);

        verify(namesClient).get(Arrays.asList(1, 2));
    }

    private CharacterWalletTransaction createNewTransaction(int typeId) {
        final CharacterWalletTransaction transaction = new CharacterWalletTransaction();
        transaction.setTypeId(typeId);
        return transaction;
    }
}
