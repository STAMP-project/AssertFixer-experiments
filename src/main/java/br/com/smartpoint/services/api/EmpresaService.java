package br.com.smartpoint.services.api;

import java.util.Optional;

import br.com.smartpoint.entities.api.Empresa;

public interface EmpresaService {
	
	/**
	 * Return a company  with cnpj parameter
	 * @param cnpj
	 * @return {@link Optional}
	 */
	Optional<Empresa>  findForCompany(String cnpj);
	
	/**
	 * Register a new Company 0
	 * @param cnpj
	 * @return {@link Empresa}
	 */
	Empresa persist(Empresa cnpj);

}
