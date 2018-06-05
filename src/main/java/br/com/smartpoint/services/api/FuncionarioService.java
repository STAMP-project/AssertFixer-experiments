package br.com.smartpoint.services.api;

import java.util.Optional;

import br.com.smartpoint.entities.api.Funcionario;

public interface FuncionarioService {

	/**
	 * Save a new Employe on database
	 * @param funcionario
	 * @return {@link Funcionario}
	 */
	Funcionario persist(Funcionario funcionario);

	/**
	 * Find a Employe with cpf parameter
	 * @param cpf
	 * @return {@link Optional} of {@link Funcionario}
	 */
	Optional<Funcionario> findForCpf(String cpf);

	/**
	 * Find a Employe with a email parameters
	 * @param email
	 * @return {@link Optional}  of {@link Funcionario}
	 */
	Optional<Funcionario> findForEmail(String email);
	

	/**
	 * Find a Employe for id long  PK
	 * @param id
	 * @return {@link Optional}  of {@link Funcionario}
	 */
	Optional<Funcionario> findForId(Long id);

}
