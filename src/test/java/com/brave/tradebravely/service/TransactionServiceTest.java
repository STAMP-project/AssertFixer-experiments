package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.Transaction;
import com.brave.tradebravely.repository.TransactionRepository;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class TransactionServiceTest {

    private final TransactionRepository repo = mock(TransactionRepository.class);
    private final TransactionService sut = new TransactionService(repo);

    @Test
    public void persistIfNew() {
        final int existingTransactions = ThreadLocalRandom.current().nextInt(5);
        final int transactionCount = ThreadLocalRandom.current().nextInt(1,5) + existingTransactions;
        when(repo.findAllByTransactionIdIn(anyCollection()))
            .thenReturn(generateTransactions(existingTransactions));
        List<Transaction> transactions = generateTransactions(transactionCount);

        sut.persistIfNew(transactions);

        final ArgumentCaptor<List<Transaction>> captor = ArgumentCaptor.forClass(List.class);
        verify(repo).saveAll(captor.capture());

        final List<Transaction> persistedTransactions = captor.getValue();
        assertEquals(transactionCount - existingTransactions, persistedTransactions.size());
    }

    @Test
    public void persistIfNew_withNoNewTransactions() {
        final int existingTransactions = ThreadLocalRandom.current().nextInt(5);
        when(repo.findAllByTransactionIdIn(anyCollection()))
            .thenReturn(generateTransactions(existingTransactions));
        List<Transaction> transactions = generateTransactions(existingTransactions);

        sut.persistIfNew(transactions);

        verify(repo, never()).saveAll(any());
    }

    private List<Transaction> generateTransactions(int count) {
        List<Transaction> list = new ArrayList<>();
        for (long i = 0; i < count; i++) {
            final Transaction t = new Transaction();
            t.setTransactionId(i);
            list.add(t);
        }
        return list;
    }
}
