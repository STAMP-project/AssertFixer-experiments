package com.brave.tradebravely.service.jobs;

import com.brave.tradebravely.domain.EsiProperties;
import com.brave.tradebravely.domain.Journal;
import com.brave.tradebravely.domain.Tax;
import com.brave.tradebravely.service.EsiTokenService;
import com.brave.tradebravely.service.TaxService;
import com.brave.tradebravely.service.esi.CharacterJournalClient;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class TaxPullerTest {

    private final EsiTokenService tokenService = mock(EsiTokenService.class);
    private final EsiProperties esiProperties = new EsiProperties();
    private final TaxService taxService = mock(TaxService.class);
    private final CharacterJournalClient journalClient = mock(CharacterJournalClient.class);
    private final TaxPuller sut = new TaxPuller(tokenService, esiProperties, taxService, journalClient);

    @Test
    public void pullTaxes() {
        final int characterId = 1245123;
        when(tokenService.findCharacterIdsForClientId(esiProperties.getTradingClientId()))
            .thenReturn(Collections.singletonList(characterId));
        final List<Journal> journals = generateJournals(5, "broker_fee");
        journals.addAll(generateJournals(3, "docking_fee"));
        when(journalClient.get(characterId)).thenReturn(journals);

        sut.pullTaxes();

        verify(journalClient).get(characterId);
        final ArgumentCaptor<List<Tax>> captor = ArgumentCaptor.forClass(List.class);
        verify(taxService, times(1)).persistIfNew(captor.capture());
        assertEquals(5, captor.getValue().size());
    }

    @Test
    public void isTax_withTaxEntry() {
        Journal j = new Journal();
        j.setRefType("broker_fee");

        assertTrue(sut.isTax(j));
    }

    @Test
    public void isTax_withNonTaxEntry() {
        Journal j = new Journal();
        j.setRefType("docking_fee");

        assertFalse(sut.isTax(j));
    }


    private List<Journal> generateJournals(int quantity, String refType) {
        final List<Journal> result = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            final Journal journal = new Journal();
            journal.setRefType(refType);
            result.add(journal);
        }
        return result;
    }

}
