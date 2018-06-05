package br.com.smartpoint.security.api;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.smartpoint.entities.api.Funcionario;
import br.com.smartpoint.enums.api.PerfilEnum;

public class JwtUserFactory {

	public JwtUserFactory() {

	}

	public static JwtUser create(Funcionario funcionario) {
		return new JwtUser(funcionario.getId(), funcionario.getEmail(), funcionario.getSenha(),
				maptoGrantedAuthorities(funcionario.getPerfil()));

	}

	private static Collection<? extends GrantedAuthority> maptoGrantedAuthorities(PerfilEnum perfil) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(perfil.toString()));
		return authorities;
	}
}
