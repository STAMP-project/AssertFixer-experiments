package br.com.smartpoint.services.impl.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smartpoint.entities.api.Funcionario;
import br.com.smartpoint.repositories.api.FuncionarioRepository;
import br.com.smartpoint.services.api.FuncionarioService;

@Service
public class DefaultFuncionarioService implements FuncionarioService {

	private static final Logger LOG = LoggerFactory.getLogger(DefaultFuncionarioService.class);

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Override
	public Optional<Funcionario> findForCpf(String cpf) {
		LOG.info("find for cpf");
		return Optional.ofNullable(this.funcionarioRepository.fyndBycpf(cpf));
	}

	@Override
	public Optional<Funcionario> findForEmail(String email) {
		LOG.info("find for email");
		return Optional.ofNullable(this.funcionarioRepository.fyndByEmail(email));
	}

	@Override
	public Optional<Funcionario> findForId(Long id) {
		LOG.info("find for ID pk");
		return Optional.ofNullable(this.funcionarioRepository.fyndById(id));
	}

	@Override
	public Funcionario persist(Funcionario funcionario) {
		LOG.info(" save for ID{}", funcionario);
		return this.funcionarioRepository.save(funcionario);
	}

}
