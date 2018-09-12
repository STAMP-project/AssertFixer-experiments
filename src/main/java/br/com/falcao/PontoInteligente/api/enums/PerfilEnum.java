package br.com.falcao.PontoInteligente.api.enums;

public enum PerfilEnum {
	
	/* A nescessidado do prefixo "ROLE" é pq esse enum vai estar associoano ao Spring Security,
	no qual o mesmo exige que o enum tenho esse prefixo.
	 */
	
	ROLE_ADMIN,
	ROLE_USUARIO;
}
