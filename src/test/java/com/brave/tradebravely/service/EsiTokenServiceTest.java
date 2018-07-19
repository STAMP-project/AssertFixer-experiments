package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EsiToken;
import com.brave.tradebravely.repository.EsiTokenRepository;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class EsiTokenServiceTest {

    private final EsiTokenRepository repository = mock(EsiTokenRepository.class);
    private final EsiTokenService sut = new EsiTokenService(repository);

    @Test
    public void save() {
        sut.save(11524123, "refreshToken", "aClientId");

        ArgumentCaptor<EsiToken> captor = ArgumentCaptor.forClass(EsiToken.class);
        verify(repository).save(captor.capture());

        final EsiToken esiToken = captor.getValue();
        assertEquals("aClientId", esiToken.getClientId());
        assertEquals(11524123, esiToken.getCharacterId());
        assertEquals("refreshToken", esiToken.getRefreshToken());
    }

    @Test
    public void find() {
        when(repository.findByCharacterIdAndClientId(1, "clientId"))
            .thenReturn(Optional.of(new EsiToken(1, "refreshToken", "clientId")));
        final Optional<EsiToken> result = sut.find(1, "clientId");
        assertTrue(result.isPresent());
    }

    @Test
    public void findAllForClientId() {
        final String clientId = "clientId";
        final EsiToken expectedToken = new EsiToken(1, "refreshToken", clientId);
        when(repository.findByClientId(clientId))
            .thenReturn(Collections.singletonList(expectedToken));

        final List<EsiToken> tokens = sut.findAllForClientId(clientId);

        assertEquals(1, tokens.size());
        assertEquals(expectedToken, tokens.get(0));
    }

    @Test
    public void findCharacterIdsForClientId() {
        final String clientId = "clientId";
        final EsiToken expectedToken = new EsiToken(12525253, "refreshToken", clientId);
        when(repository.findByClientId(clientId))
            .thenReturn(Collections.singletonList(expectedToken));

        final List<Integer> tokens = sut.findCharacterIdsForClientId(clientId);

        assertEquals(1, tokens.size());
        assertEquals(12525253, tokens.get(0).intValue());
    }
}
