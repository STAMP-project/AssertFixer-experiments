package com.brave.tradebravely.web.rest;

import com.brave.tradebravely.TradebravelyApp;
import com.brave.tradebravely.repository.AuthorityRepository;
import com.brave.tradebravely.repository.UserRepository;
import com.brave.tradebravely.service.UserService;
import com.brave.tradebravely.web.rest.errors.ExceptionTranslator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test class for the AccountResource REST controller.
 *
 * @see AccountResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradebravelyApp.class)
public class AccountResourceIntTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private HttpMessageConverter<?>[] httpMessageConverters;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Mock
    private UserService mockUserService;

    private MockMvc restMvc;

    private MockMvc restUserMockMvc;

    @Before
    public void setup() {
        userRepository.deleteAll();
        MockitoAnnotations.initMocks(this);
        AccountResource accountResource =
            new AccountResource(userRepository, userService);

        AccountResource accountUserMockResource =
            new AccountResource(userRepository, mockUserService);
        this.restMvc = MockMvcBuilders.standaloneSetup(accountResource)
            .setMessageConverters(httpMessageConverters)
            .setControllerAdvice(exceptionTranslator)
            .build();
        this.restUserMockMvc = MockMvcBuilders.standaloneSetup(accountUserMockResource)
            .setControllerAdvice(exceptionTranslator)
            .build();
    }

    @Test
    public void testNonAuthenticatedUser() throws Exception {
        restUserMockMvc.perform(get("/api/authenticate")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string(""));
    }

    @Test
    public void testAuthenticatedUser() throws Exception {
        restUserMockMvc.perform(get("/api/authenticate")
            .with(request -> {
                request.setRemoteUser("test");
                return request;
            })
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("test"));
    }

    @Test
    public void testGetUnknownAccount() throws Exception {
        when(mockUserService.getUserWithAuthorities()).thenReturn(Optional.empty());

        restUserMockMvc.perform(get("/api/account")
            .accept(MediaType.APPLICATION_PROBLEM_JSON))
            .andExpect(status().isInternalServerError());
    }
}
