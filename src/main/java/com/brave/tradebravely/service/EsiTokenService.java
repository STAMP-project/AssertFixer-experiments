package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EsiToken;
import com.brave.tradebravely.repository.EsiTokenRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EsiTokenService {

    private final EsiTokenRepository repository;

    public EsiTokenService(EsiTokenRepository repository) {
        this.repository = repository;
    }

    public void save(Integer characterId, String refreshToken, String clientId) {
        repository.save(new EsiToken(characterId, refreshToken, clientId));
    }

    public Optional<EsiToken> find(int characterId, String clientId) {
        return repository.findByCharacterIdAndClientId(characterId, clientId);
    }

    public List<EsiToken> findAllForClientId(String clientId) {
        return repository.findByClientId(clientId);
    }

    public List<Integer> findCharacterIdsForClientId(String clientId) {
        return findAllForClientId(clientId).stream()
            .map(EsiToken::getCharacterId)
            .collect(Collectors.toList());
    }

}
