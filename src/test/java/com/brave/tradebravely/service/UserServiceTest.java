package com.brave.tradebravely.service;

import com.brave.tradebravely.domain.User;
import com.brave.tradebravely.repository.AuthorityRepository;
import com.brave.tradebravely.repository.UserRepository;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private AuthorityRepository authorityRepository = mock(AuthorityRepository.class);
    private UserService sut = new UserService(userRepository, authorityRepository);

    @Test
    public void createIfNotExists_whenExists_shouldNotSave() {
        when(userRepository.findOneByLogin("name"))
            .thenReturn(Optional.of(new User(1, "name", null)));

        sut.createIfNotExists(1, "name");

        verify(userRepository, never()).save(isA(User.class));
    }

    @Test
    public void createIfNotExists_whenNew_shouldSave() {
        when(userRepository.findOneByLogin("name"))
            .thenReturn(Optional.empty());
        final ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        when(userRepository.save(captor.capture()))
            .thenReturn(new User(1, "name", null));

        sut.createIfNotExists(1, "name");

        verify(userRepository).save(isA(User.class));

        final User savedUser = captor.getValue();
        assertEquals(1, savedUser.getId().intValue());
        assertEquals("name", savedUser.getLogin());
        assertEquals(1, savedUser.getAuthorities().size());
    }
}
