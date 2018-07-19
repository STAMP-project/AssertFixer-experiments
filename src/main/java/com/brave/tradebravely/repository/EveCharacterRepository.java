package com.brave.tradebravely.repository;

import com.brave.tradebravely.domain.EveCharacter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EveCharacterRepository extends MongoRepository<EveCharacter, String> {

    Optional<EveCharacter> findById(Integer id);

    int countById(Integer id);
}
