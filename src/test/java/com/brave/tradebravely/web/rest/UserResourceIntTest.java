package com.brave.tradebravely.web.rest;

import com.brave.tradebravely.TradebravelyApp;
import com.brave.tradebravely.domain.Authority;
import com.brave.tradebravely.domain.User;
import com.brave.tradebravely.repository.UserRepository;
import com.brave.tradebravely.security.AuthoritiesConstants;
import com.brave.tradebravely.service.UserService;
import com.brave.tradebravely.service.dto.UserDTO;
import com.brave.tradebravely.service.mapper.UserMapper;
import com.brave.tradebravely.web.rest.errors.ExceptionTranslator;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.Instant;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the UserResource REST controller.
 *
 * @see UserResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TradebravelyApp.class)
public class UserResourceIntTest {

    private static final String DEFAULT_LOGIN = "johndoe";
    private static final String UPDATED_LOGIN = "jhipster";

    private static final int DEFAULT_ID = 1;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    private MockMvc restUserMockMvc;

    private User user;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        UserResource userResource = new UserResource(userService, userRepository);
        this.restUserMockMvc = MockMvcBuilders.standaloneSetup(userResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setMessageConverters(jacksonMessageConverter)
            .build();
    }

    /**
     * Create a User.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which has a required relationship to the User entity.
     */
    public static User createEntity() {
        return new User(DEFAULT_ID, DEFAULT_LOGIN, null);
    }

    @Before
    public void initTest() {
        userRepository.deleteAll();
        user = createEntity();
    }

    @Test
    public void getAllUsers() throws Exception {
        // Initialize the database
        userRepository.save(user);

        // Get all the users
        restUserMockMvc.perform(get("/api/users")
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].login").value(hasItem(DEFAULT_LOGIN)));
    }

    @Test
    public void getUser() throws Exception {
        // Initialize the database
        userRepository.save(user);

        // Get the user
        restUserMockMvc.perform(get("/api/users/{login}", user.getLogin()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.login").value(user.getLogin()));
    }

    @Test
    public void getNonExistingUser() throws Exception {
        restUserMockMvc.perform(get("/api/users/unknown"))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateUser() throws Exception {
        // Initialize the database
        userRepository.save(user);
        int databaseSizeBeforeUpdate = userRepository.findAll().size();

        // Update the user
        User updatedUser = userRepository.findById(user.getId()).get();

        UserDTO userDto = new UserDTO();
        userDto.setId(updatedUser.getId());
        userDto.setLogin(updatedUser.getLogin());
        userDto.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));
        userDto.setCreatedBy(updatedUser.getCreatedBy());
        userDto.setCreatedDate(updatedUser.getCreatedDate());
        userDto.setLastModifiedBy(updatedUser.getLastModifiedBy());
        userDto.setLastModifiedDate(updatedUser.getLastModifiedDate());

        restUserMockMvc.perform(put("/api/users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDto)))
            .andExpect(status().isOk());

        // Validate the User in the database
        List<User> userList = userRepository.findAll();
        assertThat(userList).hasSize(databaseSizeBeforeUpdate);
        User testUser = userList.get(userList.size() - 1);
    }

    @Test
    public void updateUserLogin() throws Exception {
        // Initialize the database
        userRepository.save(user);
        int databaseSizeBeforeUpdate = userRepository.findAll().size();

        // Update the user
        User updatedUser = userRepository.findById(user.getId()).get();

        UserDTO userDto = new UserDTO();
        userDto.setId(updatedUser.getId());
        userDto.setLogin(UPDATED_LOGIN);
        userDto.setCreatedBy(updatedUser.getCreatedBy());
        userDto.setCreatedDate(updatedUser.getCreatedDate());
        userDto.setLastModifiedBy(updatedUser.getLastModifiedBy());
        userDto.setLastModifiedDate(updatedUser.getLastModifiedDate());
        userDto.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

        restUserMockMvc.perform(put("/api/users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDto)))
            .andExpect(status().isOk());

        // Validate the User in the database
        List<User> userList = userRepository.findAll();
        assertThat(userList).hasSize(databaseSizeBeforeUpdate);
        User testUser = userList.get(userList.size() - 1);
        assertThat(testUser.getLogin()).isEqualTo(UPDATED_LOGIN);
    }

    @Test
    public void updateUserExistingLogin() throws Exception {
        // Initialize the database
        userRepository.save(user);

        User anotherUser = new User(2, "jhipster", null);
        userRepository.save(anotherUser);

        // Update the user
        User updatedUser = userRepository.findById(user.getId()).get();

        UserDTO userDto = new UserDTO();
        userDto.setId(updatedUser.getId());
        userDto.setLogin("jhipster");// this login should already be used by anotherUser
        userDto.setCreatedBy(updatedUser.getCreatedBy());
        userDto.setCreatedDate(updatedUser.getCreatedDate());
        userDto.setLastModifiedBy(updatedUser.getLastModifiedBy());
        userDto.setLastModifiedDate(updatedUser.getLastModifiedDate());
        userDto.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

        restUserMockMvc.perform(put("/api/users")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(userDto)))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void deleteUser() throws Exception {
        // Initialize the database
        userRepository.save(user);
        int databaseSizeBeforeDelete = userRepository.findAll().size();

        // Delete the user
        restUserMockMvc.perform(delete("/api/users/{login}", user.getLogin())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<User> userList = userRepository.findAll();
        assertThat(userList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void getAllAuthorities() throws Exception {
        restUserMockMvc.perform(get("/api/users/authorities")
            .accept(TestUtil.APPLICATION_JSON_UTF8)
            .contentType(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").value(containsInAnyOrder(AuthoritiesConstants.USER, AuthoritiesConstants.ADMIN)));
    }

    @Test
    public void testUserFromId() {
        assertThat(userMapper.userFromId(DEFAULT_ID).getId()).isEqualTo(DEFAULT_ID);
        assertThat(userMapper.userFromId(null)).isNull();
    }

    @Test
    public void testUserDTOtoUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(DEFAULT_ID);
        userDTO.setLogin(DEFAULT_LOGIN);
        userDTO.setCreatedBy(DEFAULT_LOGIN);
        userDTO.setLastModifiedBy(DEFAULT_LOGIN);
        userDTO.setAuthorities(Collections.singleton(AuthoritiesConstants.USER));

        User user = userMapper.userDTOToUser(userDTO);
        assertThat(user.getId()).isEqualTo(DEFAULT_ID);
        assertThat(user.getLogin()).isEqualTo(DEFAULT_LOGIN);
        assertThat(user.getCreatedBy()).isNull();
        assertThat(user.getCreatedDate()).isNotNull();
        assertThat(user.getLastModifiedBy()).isNull();
        assertThat(user.getLastModifiedDate()).isNotNull();
        assertThat(user.getAuthorities()).extracting("name").containsExactly(AuthoritiesConstants.USER);
    }

    @Test
    public void testUserToUserDTO() {
        user.setId(DEFAULT_ID);
        user.setCreatedBy(DEFAULT_LOGIN);
        user.setCreatedDate(Instant.now());
        user.setLastModifiedBy(DEFAULT_LOGIN);
        user.setLastModifiedDate(Instant.now());
        Set<Authority> authorities = new HashSet<>();
        Authority authority = new Authority();
        authority.setName(AuthoritiesConstants.USER);
        authorities.add(authority);
        user.setAuthorities(authorities);

        UserDTO userDTO = userMapper.userToUserDTO(user);

        assertThat(userDTO.getId()).isEqualTo(DEFAULT_ID);
        assertThat(userDTO.getLogin()).isEqualTo(DEFAULT_LOGIN);
        assertThat(userDTO.getCreatedBy()).isEqualTo(DEFAULT_LOGIN);
        assertThat(userDTO.getCreatedDate()).isEqualTo(user.getCreatedDate());
        assertThat(userDTO.getLastModifiedBy()).isEqualTo(DEFAULT_LOGIN);
        assertThat(userDTO.getLastModifiedDate()).isEqualTo(user.getLastModifiedDate());
        assertThat(userDTO.getAuthorities()).containsExactly(AuthoritiesConstants.USER);
        assertThat(userDTO.toString()).isNotNull();
    }

    @Test
    public void testAuthorityEquals() throws Exception {
        Authority authorityA = new Authority();
        assertThat(authorityA).isEqualTo(authorityA);
        assertThat(authorityA).isNotEqualTo(null);
        assertThat(authorityA).isNotEqualTo(new Object());
        assertThat(authorityA.hashCode()).isEqualTo(0);
        assertThat(authorityA.toString()).isNotNull();

        Authority authorityB = new Authority();
        assertThat(authorityA).isEqualTo(authorityB);

        authorityB.setName(AuthoritiesConstants.ADMIN);
        assertThat(authorityA).isNotEqualTo(authorityB);

        authorityA.setName(AuthoritiesConstants.USER);
        assertThat(authorityA).isNotEqualTo(authorityB);

        authorityB.setName(AuthoritiesConstants.USER);
        assertThat(authorityA).isEqualTo(authorityB);
        assertThat(authorityA.hashCode()).isEqualTo(authorityB.hashCode());
    }
}
