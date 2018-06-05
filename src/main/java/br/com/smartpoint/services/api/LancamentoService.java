package br.com.smartpoint.services.api;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import br.com.smartpoint.entities.api.Lancamento;

public interface LancamentoService {

	/**
	 * Find an employe for id Pageable
	 * 
	 * @param id
	 * @param request
	 * @return Page<Lancamento>
	 */
	Page<Lancamento> findForEmployeId(Long id, PageRequest request);

	/**
	 * Find Employe for id PK
	 * 
	 * @param id
	 * @return Optional<Lancamento>
	 */
	Optional<Lancamento> findForIdLong(Long id);

	/**
	 * Persist database Lancamento
	 * 
	 * @param lancamento
	 * @return just sabe Lancamento
	 */
	Lancamento saveLancament(Lancamento lancamento);

	/**
	 * 
	 * remove Lancamento for ID (PK)
	 * 
	 * @param id
	 */
	void remove(Long id);

}
