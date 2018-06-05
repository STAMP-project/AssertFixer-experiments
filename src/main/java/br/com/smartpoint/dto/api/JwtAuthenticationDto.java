package br.com.smartpoint.dto.api;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class JwtAuthenticationDto {

	private String email;
	private String password;

	@NotEmpty(message = "email cannot be empty")
	@Email
	public String getEmail() {
		return email;
	}

	@NotEmpty(message = "password cannot be empty")
	public String getPassword() {
		return password;
	}

}
