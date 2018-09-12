package br.com.falcao.PontoInteligente.api.services;

import java.util.Optional;

import br.com.falcao.PontoInteligente.api.entitys.Empresa;

public interface EmpresaService {

	/*
	 * 
	 * Retorna uma empresa dado um CNPJ
	 * 
	 * */
	
	Optional<Empresa> buscarPorCnpj(String cnpj);
	
	/*
	 * 
	 * Cadastra uma nova empresa no banco de dados
	 * 
	 * 
	 * */
	
	Empresa persistir(Empresa empresa);
	
}
