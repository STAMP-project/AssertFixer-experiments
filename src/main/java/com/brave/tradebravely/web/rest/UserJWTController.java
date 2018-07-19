package com.brave.tradebravely.web.rest;

import com.brave.tradebravely.domain.EveCharacter;
import com.brave.tradebravely.domain.User;
import com.brave.tradebravely.domain.esi.AuthVerificationResponse;
import com.brave.tradebravely.domain.esi.CharacterDetailsResponse;
import com.brave.tradebravely.security.jwt.TokenProvider;
import com.brave.tradebravely.service.CharacterService;
import com.brave.tradebravely.service.SsoService;
import com.brave.tradebravely.service.EsiTokenService;
import com.brave.tradebravely.service.UserService;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.brave.tradebravely.security.jwt.JWTConfigurer.AUTHORIZATION_HEADER;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class UserJWTController {

    private static final String AUTHENTICATION_EXCEPTION = "AuthenticationException";
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final TokenProvider tokenProvider;
    private final UserService userService;
    private final SsoService ssoService;
    private final CharacterService characterService;
    private final EsiTokenService esiTokenService;

    public UserJWTController(TokenProvider tokenProvider, UserService userService, SsoService ssoService, CharacterService characterService, EsiTokenService esiTokenService) {
        this.tokenProvider = tokenProvider;
        this.userService = userService;
        this.ssoService = ssoService;
        this.characterService = characterService;
        this.esiTokenService = esiTokenService;
    }

    @GetMapping("/authenticate/sso")
    @Timed
    public ResponseEntity<?> authorize(@RequestParam("code") String code, @RequestParam("state") String state, HttpServletResponse response) {

        final AuthVerificationResponse authResponse = ssoService.verifyAuthentication(code);
        if (authResponse == null) {
            log.warn("VerifyAuthentication returned null.");
            return new ResponseEntity<>(AUTHENTICATION_EXCEPTION, HttpStatus.UNAUTHORIZED);
        }
        final CharacterDetailsResponse characterDetails = ssoService.getCharacterDetails(authResponse.getAccessToken());
        if (null == characterDetails) {
            log.warn("GetCharacterDetails returned null.");
            return new ResponseEntity<>(AUTHENTICATION_EXCEPTION, HttpStatus.UNAUTHORIZED);
        }

        final User user = userService.createIfNotExists(characterDetails.getCharacterId(), characterDetails.getCharacterName());

        characterService.createIfNotExists(new EveCharacter(characterDetails.getCharacterId(), characterDetails.getCharacterName()));

        if (!"login".equals(state)) {
            esiTokenService.save(characterDetails.getCharacterId(), authResponse.getRefreshToken(), state);
        }

        return createResponseWithToken(response, user);
    }

    private ResponseEntity<?> createResponseWithToken(HttpServletResponse response, User user) {
        try {
            final String jwt = generateJwt(user);
            response.addHeader(AUTHORIZATION_HEADER, "Bearer " + jwt);
            return ResponseEntity.ok(new JWTToken(jwt));
        } catch (AuthenticationException ae) {
            log.trace("Authentication exception trace: {}", ae);
            return new ResponseEntity<>(Collections.singletonMap(AUTHENTICATION_EXCEPTION,
                ae.getLocalizedMessage()), HttpStatus.UNAUTHORIZED);
        }
    }

    String generateJwt(User user) {
        final List<SimpleGrantedAuthority> authorities = user.getAuthorities().stream().map(
            a -> new SimpleGrantedAuthority(a.getName())).collect(Collectors.toList());
        final Authentication authentication = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getLogin(), authorities);
        final String jwt = tokenProvider.createToken(authentication, true);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return jwt;
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class JWTToken {

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() {
            return idToken;
        }

        void setIdToken(String idToken) {
            this.idToken = idToken;
        }
    }
}
