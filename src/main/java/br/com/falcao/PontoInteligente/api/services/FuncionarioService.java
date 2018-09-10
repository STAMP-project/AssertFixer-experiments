package br.com.falcao.PontoInteligente.api.services;

import java.util.Optional;

import br.com.falcao.PontoInteligente.api.entitys.Funcionario;

public interface FuncionarioService {

	/**
	 * 
	 * Persiste um funcionario na base de dados
	 * 
	 * @param	funcionario
	 * @return funcionario
	 * 
	 * */
	
	Funcionario persistir(Funcionario funcionario);
	
	/**
	 * 
	 * Busca e retorna um funcionario pelo CPF
	 * 
	 * @param cpf
	 * @return Optional<Funcionario>
	 * 
	 * */
	
	Optional<Funcionario> buscarPorCpf(String cpf);
	
	/**
	 * 
	 * Busca e retorna um funcionario pelo E-mail
	 * 
	 * @param email
	 * @return Optional<Funcionario>
	 * 
	 * */
	
	Optional<Funcionario> buscarPorEmail(String email);
	
	/**
	 * 
	 * Busca e retorna um funcionario pelo Id
	 * 
	 * @param id
	 * @return Optional<Funcionario>
	 * 
	 * */
	
	Optional<Funcionario> buscarPorId(Long id);
}
