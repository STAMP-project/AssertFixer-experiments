package com.brave.tradebravely.security;

import com.brave.tradebravely.TradebravelyApp;
import com.brave.tradebravely.domain.User;
import com.brave.tradebravely.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for DomainUserDetailsService.
 *
 * @see DomainUserDetailsService
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradebravelyApp.class)
public class DomainUserDetailsServiceIntTest {

    private static final String USER_ONE_LOGIN = "test-user-one";
    private static final String USER_TWO_LOGIN = "test-user-two";
    private static final String USER_THREE_LOGIN = "test-user-three";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailsService domainUserDetailsService;

    private User userOne;
    private User userTwo;
    private User userThree;

    @Before
    public void init() {
        userRepository.deleteAll();

        userOne = new User(1, USER_ONE_LOGIN, null);
        userRepository.save(userOne);

        userTwo = new User(2, USER_TWO_LOGIN, null);
        userRepository.save(userTwo);

        userThree = new User(3, USER_THREE_LOGIN, null);
        userRepository.save(userThree);
    }

    @Test
    public void assertThatUserCanBeFoundByLogin() {
        UserDetails userDetails = domainUserDetailsService.loadUserByUsername(USER_ONE_LOGIN);
        assertThat(userDetails).isNotNull();
        assertThat(userDetails.getUsername()).isEqualTo(USER_ONE_LOGIN);
    }

}
