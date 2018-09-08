package com.softwarelabs.pontointeligente.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger(PasswordUtils.class);

	public PasswordUtils() {
		
	}
	
	/*Gerar  rash com Bcrypt
	 * @param senha
	 * @retun String
	 */
	
	public static String gerarBCript(String senha) {
		if(senha == null) {
		return senha;
		}
		
		log.info("Gerando hash com BCript");
		BCryptPasswordEncoder bCryptEncoder = new BCryptPasswordEncoder();
		return bCryptEncoder.encode(senha);
	};
	
	

}
