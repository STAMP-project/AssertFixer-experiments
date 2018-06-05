package br.com.smartpoint.utils.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	private static final Logger LOG = LoggerFactory.getLogger(PasswordUtils.class);

	public PasswordUtils() {
		// TODO Auto-generated constructor stub
	}

	public static String generateCryptPassword(String password) {
		if (password == null) {
			return password;
		}
		LOG.info("generate password encode ");
		BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
		return bcryptEncoder.encode(password);
	}

}
