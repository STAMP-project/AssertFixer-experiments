package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EveCharacter;
import com.brave.tradebravely.repository.EveCharacterRepository;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    private final EveCharacterRepository repository;

    public CharacterService(EveCharacterRepository repository) {
        this.repository = repository;
    }

    public void createIfNotExists(EveCharacter character) {
        if (0 == repository.countById(character.getId())) {
            repository.save(character);
        }
    }
}
