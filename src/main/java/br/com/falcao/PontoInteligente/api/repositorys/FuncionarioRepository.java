package br.com.falcao.PontoInteligente.api.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.falcao.PontoInteligente.api.entitys.Funcionario;

/*
 * 
 * O @Transactional foi coloca aqui porque tem várias assinaturas de métodos
 * , assim, o @Transactional é reaproveitado em todas as assinaturas!
 * 
 * */
@Transactional(readOnly=true)
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

	Funcionario findByCpf(String cpf);
	
	Funcionario findByEmail(String email);
	
	Funcionario findByCpfOrEmail(String cpf, String email);
	
}
