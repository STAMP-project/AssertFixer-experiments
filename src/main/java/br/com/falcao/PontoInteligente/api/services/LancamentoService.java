package br.com.falcao.PontoInteligente.api.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.falcao.PontoInteligente.api.entitys.Lancamento;

public interface LancamentoService {

	/**
	 * 
	 * Retorna uma lista paginada de lançamentos de um determinado funcionário
	 * 
	 * @param funcionarioId
	 * @param pageRequest
	 * 
	 * @return Page<Lancamento>
	 * 
	 * */
	
	Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest);
	
	/**
	 * 
	 * Retorna um Lançamento por Id
	 * 
	 * @param id
	 * 
	 * @return Optional<Lancamento>
	 * 
	 * */
	
	Optional<Lancamento> buscarPorId(Long id);
	
	/**
	 * 
	 * Persiste um Lançamento no banco de dados
	 * 
	 * @param lancamento
	 * 
	 * @return lancamento
	 * 
	 * */
	
	Lancamento persistir(Lancamento lancamento);
	
	/**
	 * 
	 * Remove um Lançamento do vanco de dados pelo id
	 * 
	 * @param id
	 * 
	 * 
	 * */
	
	void remover(Long id);
	
}
