package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.EveCharacter;
import com.brave.tradebravely.repository.EveCharacterRepository;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CharacterServiceTest {

    private final EveCharacterRepository repository = mock(EveCharacterRepository.class);
    private final CharacterService sut = new CharacterService(repository);

    @Test
    public void createNewCharacterIfItDoesntExist_shouldPersistNewUser() {
        EveCharacter character = new EveCharacter(1, "name");

        sut.createIfNotExists(character);

        verify(repository).save(character);
    }

    @Test
    public void createNewCharacterIfItDoesntExist_shouldNotOverwriteExistingUser() {
        EveCharacter character = new EveCharacter(1, "name");
        when(repository.countById(character.getId())).thenReturn(1);

        sut.createIfNotExists(character);

        verify(repository, never()).save(character);
    }
}
