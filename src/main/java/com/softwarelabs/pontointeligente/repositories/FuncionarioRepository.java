package com.softwarelabs.pontointeligente.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.softwarelabs.pontointeligente.entity.Funcionario;

@Transactional(readOnly=true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	Funcionario FindByCpf(String cpf);
	
	Funcionario FindByEmail(String email);
	
	Funcionario FindByCpforEmail(String cpf, String email);

}
