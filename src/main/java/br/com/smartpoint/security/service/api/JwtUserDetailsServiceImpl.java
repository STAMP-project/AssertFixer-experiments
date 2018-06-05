package br.com.smartpoint.security.service.api;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.smartpoint.entities.api.Funcionario;
import br.com.smartpoint.security.api.JwtUserFactory;
import br.com.smartpoint.services.api.FuncionarioService;

public class JwtUserDetailsServiceImpl implements UserDetailsService {

	private FuncionarioService funcionarioService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		Optional<Funcionario> funcionario = funcionarioService.findForEmail(username);

		if (funcionario.isPresent())
			return JwtUserFactory.create(funcionario.get());

		throw new UsernameNotFoundException("Email cannot be searching ");
	}

}
