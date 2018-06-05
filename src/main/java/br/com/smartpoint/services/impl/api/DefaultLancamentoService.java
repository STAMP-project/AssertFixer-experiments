package br.com.smartpoint.services.impl.api;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import br.com.smartpoint.entities.api.Lancamento;
import br.com.smartpoint.repositories.api.LancamentoRepository;
import br.com.smartpoint.services.api.LancamentoService;

@Service
public class DefaultLancamentoService implements LancamentoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;
	private static final Logger LOG = LoggerFactory.getLogger(DefaultLancamentoService.class);

	@Override
	public Page<Lancamento> findForEmployeId(Long id, PageRequest request) {
		LOG.info("find for id {} ", id);
		//return this.lancamentoRepository.findByFuncionarioIdPageAble(id, request);
		return null;
	}

	@Override
	@Cacheable("lancamentoForId")
	public Optional<Lancamento> findForIdLong(Long id) {
		LOG.info("find for ID pk {} ", id);
		return this.lancamentoRepository.findForId(id);
	}

	@Override
	public void remove(Long id) {
		LOG.info("remove entity for ID");
		this.lancamentoRepository.delete(id);

	}

	@Override
	@CachePut("lancamentoPut")
	public Lancamento saveLancament(Lancamento lancamento) {
		LOG.info("save entity  lancamento ", lancamento);
		return this.lancamentoRepository.save(lancamento);
	}

}
