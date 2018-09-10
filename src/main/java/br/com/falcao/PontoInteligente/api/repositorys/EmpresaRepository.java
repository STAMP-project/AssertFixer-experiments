package br.com.falcao.PontoInteligente.api.repositorys;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.falcao.PontoInteligente.api.entitys.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

	/*
	 * 
	 * @Transactional = É para quando o método for chamado e a consulta estiver sendo executado, 
	 * o banco de dados não ficara bloqueado para outras consultas simultâneas,
	 * assim, influenciando diretamente na performânce da aplicação de forma possitiva.
	 * 
	 * */
	@Transactional(readOnly=true)
	Empresa findByCnpj(String cnpj);
	
}
