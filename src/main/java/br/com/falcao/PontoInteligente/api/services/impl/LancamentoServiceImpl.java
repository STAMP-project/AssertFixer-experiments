package br.com.falcao.PontoInteligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.falcao.PontoInteligente.api.entitys.Lancamento;
import br.com.falcao.PontoInteligente.api.repositorys.LancamentoRepository;
import br.com.falcao.PontoInteligente.api.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService{

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private LancamentoRepository lr;
	
	@Override
	public Page<Lancamento> buscarPorFuncionarioId(Long funcionarioId, PageRequest pageRequest) {
		// TODO Auto-generated method stub
		log.info("Buscando um lançamento para o funcionario de Id {}", funcionarioId);
		return this.lr.findByFuncionarioId(funcionarioId, pageRequest);
	}

	@Override
	public Optional<Lancamento> buscarPorId(Long id) {
		// TODO Auto-generated method stub
		log.info("Buscando um lançamento pelo Id {}", id);
		return this.lr.findById(id);
	}

	@Override
	public Lancamento persistir(Lancamento lancamento) {
		// TODO Auto-generated method stub
		log.info("Salvando lançamento: {}", lancamento);
		return this.lr.save(lancamento);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		log.info("Deletando um lançamento pelo Id {}", id);
		this.lr.deleteById(id);
	}

}
