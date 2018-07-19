package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.Tax;
import com.brave.tradebravely.repository.TaxRepository;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyCollection;
import static org.mockito.Mockito.*;

public class TaxServiceTest {

    private final TaxRepository repo = mock(TaxRepository.class);
    private final TaxService sut = new TaxService(repo);
    
    @Test
    public void persistIfNew() {
        final int existingTaxes = ThreadLocalRandom.current().nextInt(5);
        final int taxCount = ThreadLocalRandom.current().nextInt(1,5) + existingTaxes;
        when(repo.findAllByJournalIdIn(anyCollection()))
            .thenReturn(generateTaxes(existingTaxes));
        List<Tax> taxes = generateTaxes(taxCount);

        sut.persistIfNew(taxes);

        final ArgumentCaptor<List<Tax>> captor = ArgumentCaptor.forClass(List.class);
        verify(repo).saveAll(captor.capture());

        final List<Tax> persistedTaxes = captor.getValue();
        assertEquals(taxCount - existingTaxes, persistedTaxes.size());
    }

    @Test
    public void persistIfNew_withNoNewTaxes() {
        final int existingTaxes = ThreadLocalRandom.current().nextInt(5);
        when(repo.findAllByJournalIdIn(anyCollection()))
            .thenReturn(generateTaxes(existingTaxes));
        List<Tax> taxes = generateTaxes(existingTaxes);

        sut.persistIfNew(taxes);

        verify(repo, never()).saveAll(any());
    }

    private List<Tax> generateTaxes(int count) {
        List<Tax> list = new ArrayList<>();
        for (long i = 0; i < count; i++) {
            final Tax t = new Tax();
            t.setJournalId(i);
            list.add(t);
        }
        return list;
    }
}
