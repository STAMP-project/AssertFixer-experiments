package br.com.falcao.PontoInteligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.falcao.PontoInteligente.api.entitys.Funcionario;
import br.com.falcao.PontoInteligente.api.repositorys.FuncionarioRepository;
import br.com.falcao.PontoInteligente.api.services.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService{

	private static final Logger log = LoggerFactory.getLogger(FuncionarioServiceImpl.class);
	
	@Autowired
	private FuncionarioRepository fr;
	
	@Override
	public Funcionario persistir(Funcionario funcionario) {
		// TODO Auto-generated method stub
		log.info("Salvando Funcionario no banco de dados: {}", funcionario);
		return this.fr.save(funcionario);
	}

	@Override
	public Optional<Funcionario> buscarPorCpf(String cpf) {
		// TODO Auto-generated method stub
		log.info("Procurando Funcionario no banco de dados pelo CPF {}", cpf);
		return Optional.ofNullable(this.fr.findByCpf(cpf));
	}

	@Override
	public Optional<Funcionario> buscarPorEmail(String email) {
		// TODO Auto-generated method stub
		log.info("Procurando Funcionario no banco de dados pelo E-mail {}", email);
		return Optional.ofNullable(this.fr.findByEmail(email));
	}

	@Override
	public Optional<Funcionario> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		log.info("Procurando Funcionario no banco de dados pelo Id {}", id);
		return this.fr.findById(id);
	}

}
