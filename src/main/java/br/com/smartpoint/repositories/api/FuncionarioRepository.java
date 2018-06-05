package br.com.smartpoint.repositories.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.smartpoint.entities.api.Funcionario;

@Transactional (readOnly = true )
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Funcionario fyndBycpf (String cpf );
	
	Funcionario fyndByEmail (String email);
	
	Funcionario fyndByEmailOrCpf (String cpf, String email);
	
	Funcionario fyndById(Long id);
	

}
