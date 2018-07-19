package com.brave.tradebravely.repository;

import com.brave.tradebravely.domain.EsiToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EsiTokenRepository extends MongoRepository<EsiToken, String> {
    Optional<EsiToken> findByCharacterIdAndClientId(int characterId, String clientId);

    List<EsiToken> findByClientId(String clientId);
}
