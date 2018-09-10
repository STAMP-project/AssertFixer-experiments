package br.com.falcao.PontoInteligente.api.repositorys;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import br.com.falcao.PontoInteligente.api.entitys.Lancamento;

@Transactional
@NamedQueries({
	@NamedQuery(
				name="LancamentoRepository.findByFuncionarioId",
				query="SELECT lanc FROM Lancamento lan where lanc.funcionario.id = :funcionarioId"
			)
})
public interface LancamentoRepository extends JpaRepository<Lancamento, Long>{

	/*
	 * 
	 * Esse método retorna todos os funcionario levando em consideração o Id!
	 * 
	 * */
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	/*
	 * 
	 * O objeto Pageable é para paginar os resultados. Logo, esse método retorna todos os funcionário
	 * levando em consideração o Id, de uma forma paginada
	 * 
	 * */
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
	
}
