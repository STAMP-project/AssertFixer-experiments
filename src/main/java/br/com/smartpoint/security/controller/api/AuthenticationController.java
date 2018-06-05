package br.com.smartpoint.security.controller.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.smartpoint.dto.api.JwtAuthenticationDto;
import br.com.smartpoint.dto.api.TokenDto;
import br.com.smartpoint.response.api.Response;
import br.com.smartpoint.security.utils.api.JwtTokenUtil;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {

	private static final Logger LOG = LoggerFactory.getLogger(AuthenticationController.class);
	private static final String TOKEN_HEADER = "Authorization";
	private static final String BEARER_PREFIX = "Bearer ";

	@Autowired
	private AuthenticationManager authenticationmanager;
	@Autowired
	private JwtTokenUtil tokenUtil;
	@Autowired
	private UserDetailsService userDetailsService;

	@PostMapping
	public ResponseEntity<Response<TokenDto>> generateToken(@Valid @RequestBody JwtAuthenticationDto authenticationDto,
			BindingResult bindingResult) {

		Response<TokenDto> responsedto = new Response<>();

		if (bindingResult.hasErrors()) {
			LOG.error("error on generate token value {} ", bindingResult.hasErrors());
			bindingResult.getAllErrors().forEach(error -> responsedto.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(responsedto);
		}

		LOG.info("Create token from User {} ", authenticationDto.getEmail());
		Authentication authentication = authenticationmanager.authenticate(
				new UsernamePasswordAuthenticationToken(authenticationDto.getEmail(), authenticationDto.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationDto.getEmail());
		String token = tokenUtil.getToken(userDetails);
		responsedto.setData(new TokenDto(token));

		return ResponseEntity.ok(responsedto);
	}

}
