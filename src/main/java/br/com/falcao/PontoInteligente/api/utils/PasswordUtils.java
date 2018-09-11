package br.com.falcao.PontoInteligente.api.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/* Essa classe é responsável por criptografar a senha do usuário! */
public class PasswordUtils {

	/* É uma boa prática adicionar log durante qualquer procedimento! */
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);
	
	public PasswordUtils() {}
	
	/**
	 * Gera um hash utilizando o BCrypt.
	 * 
	 * @param senha
	 * @return String
	 */
	
	public static String gerarBCrypt(String senha) {
		if(senha == null || senha == "") {
			return senha;
		}else {
			log.info("Gerando hash com BRcypt!");
			BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
			
			return bCryptEncoder.encode(senha);
		}
	}
	
}
