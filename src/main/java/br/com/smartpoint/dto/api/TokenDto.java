package br.com.smartpoint.dto.api;

public class TokenDto {

	private String token;

	public TokenDto() {

	}

	public TokenDto(String token) {
		this.token = token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

}
