package com.brave.tradebravely.service.jobs;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.service.EsiTokenService;
import com.brave.tradebravely.service.TransactionService;
import com.brave.tradebravely.service.esi.CharacterTransactionsClient;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class TransactionPullerTest {

    private final EsiTokenService tokenService = mock(EsiTokenService.class);
    private final CharacterTransactionsClient transactionClient = mock(CharacterTransactionsClient.class);
    private final EsiProperties esiProperties = new EsiProperties();
    private final TransactionService transactionService = mock(TransactionService.class);
    private final TransactionPuller sut = new TransactionPuller(tokenService, transactionClient, esiProperties, transactionService);

    @Test
    public void pullTransactions() {
        final int characterId = 1245123;
        when(tokenService.findCharacterIdsForClientId(esiProperties.getTradingClientId()))
            .thenReturn(Collections.singletonList(characterId));
        final List<Transaction> transactions = generateTransactions(characterId, 5);
        when(transactionClient.get(characterId)).thenReturn(transactions);

        sut.pullTransactions();

        verify(transactionClient).get(characterId);
        verify(transactionService, times(1)).persistIfNew(transactions);
    }

    private List<Transaction> generateTransactions(int clientId, int size) {
        List<Transaction> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final Transaction t = new Transaction();
            t.setOtherParty(clientId);
            result.add(t);
        }
        return result;
    }
}
