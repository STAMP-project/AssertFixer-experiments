package com.brave.tradebravely.repository;

import com.brave.tradebravely.domain.AccessToken;
import com.brave.tradebravely.domain.AccessTokenType;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessTokenRepository extends MongoRepository<AccessToken, String> {

    AccessToken findTop1ByCharacterIdAndTypeOrderByCreatedDesc(final int characterId, final AccessTokenType type);

    List<AccessToken> findAllByCharacterIdAndType(final int characterId, final AccessTokenType type);
}
