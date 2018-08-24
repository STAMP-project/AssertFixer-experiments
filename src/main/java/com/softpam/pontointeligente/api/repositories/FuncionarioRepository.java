package com.softpam.pontointeligente.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.softpam.pontointeligente.api.entities.Funcionario;

@Transactional(readOnly = true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
	Funcionario findByCpf(String cpf);
	Funcionario findByEmail(String email);
	//Funcionario finByCpfOrEmail(String cpf, String email);
}
