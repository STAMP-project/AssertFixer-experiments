package br.com.smartpoint.repositories.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.smartpoint.entities.api.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{
	
	@Transactional(readOnly  = true)
	Empresa findByCnpj(String cnpj);

}
