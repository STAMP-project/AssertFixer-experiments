package com.brave.tradebravely.web.rest;

import com.brave.tradebravely.domain.Authority;
import com.brave.tradebravely.domain.EveCharacter;
import com.brave.tradebravely.domain.User;
import com.brave.tradebravely.domain.esi.AuthVerificationResponse;
import com.brave.tradebravely.domain.esi.CharacterDetailsResponse;
import com.brave.tradebravely.security.AuthoritiesConstants;
import com.brave.tradebravely.security.jwt.TokenProvider;
import com.brave.tradebravely.service.CharacterService;
import com.brave.tradebravely.service.SsoService;
import com.brave.tradebravely.service.EsiTokenService;
import com.brave.tradebravely.service.UserService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletResponse;

import java.util.HashSet;

import static com.brave.tradebravely.security.jwt.JWTConfigurer.AUTHORIZATION_HEADER;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserJWTControllerTest {

    private TokenProvider tokenProvider = mock(TokenProvider.class);
    private UserService userService = mock(UserService.class);
    private SsoService ssoService = mock(SsoService.class);
    private final CharacterService characterService = mock(CharacterService.class);
    private final EsiTokenService esiTokenService = mock(EsiTokenService.class);
    private final UserJWTController sut = spy(new UserJWTController(tokenProvider, userService, ssoService, characterService, esiTokenService));

    @Test
    public void authorizeWithInvalidCode() {
        final ResponseEntity response = sut.authorize("code", "state", null);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void authorizeWithInvalidAccessToken() {
        when(ssoService.verifyAuthentication("code"))
            .thenReturn(new AuthVerificationResponse());
        final ResponseEntity response = sut.authorize("code", "state", null);
        assertEquals(HttpStatus.UNAUTHORIZED, response.getStatusCode());
    }

    @Test
    public void authorize() {
        final AuthVerificationResponse authVerificationResponse = new AuthVerificationResponse();
        authVerificationResponse.setRefreshToken("refreshToken");
        when(ssoService.verifyAuthentication("code")).thenReturn(authVerificationResponse);
        final CharacterDetailsResponse characterDetailsResponse = new CharacterDetailsResponse();
        characterDetailsResponse.setCharacterId(1);
        characterDetailsResponse.setCharacterName("name");
        when(ssoService.getCharacterDetails(null))
            .thenReturn(characterDetailsResponse);
        when(userService.createIfNotExists(1, "name"))
            .thenReturn(new User(1, "login", new HashSet<>()));
        doReturn("token").when(sut).generateJwt(isA(User.class));

        final HttpServletResponse mockResponse = new MockHttpServletResponse();

        final ResponseEntity response = sut.authorize("code", "state", mockResponse);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Bearer token", mockResponse.getHeader(AUTHORIZATION_HEADER));
        final UserJWTController.JWTToken body = (UserJWTController.JWTToken) response.getBody();
        assertEquals("token", body.getIdToken());
        verify(characterService).createIfNotExists(isA(EveCharacter.class));
        verify(esiTokenService).save(1, "refreshToken", "state");
    }

    @Test
    public void generateJwt() {
        final User user = new User(1, "name", new HashSet<>());
        final Authority authority = new Authority();
        authority.setName(AuthoritiesConstants.USER);
        user.getAuthorities().add(authority);

        final ArgumentCaptor<Authentication> captor = ArgumentCaptor.forClass(Authentication.class);
        when(tokenProvider.createToken(captor.capture(), eq(true)))
            .thenReturn("token");

        final String token = sut.generateJwt(user);

        assertEquals("token", token);
    }
}
