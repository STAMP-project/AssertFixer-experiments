package br.com.smartpoint.services.impl.api;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.smartpoint.entities.api.Empresa;
import br.com.smartpoint.repositories.api.EmpresaRepository;
import br.com.smartpoint.services.api.EmpresaService;

@Service
public class DefaultEmpresaService implements EmpresaService {
	private static final Logger LOG = LoggerFactory.getLogger(DefaultEmpresaService.class);

	@Autowired
	private EmpresaRepository empresaRepository;

	@Override
	public Optional<Empresa> findForCompany(String cnpj) {
		LOG.info("find for cnpj {} ", cnpj);
		return Optional.ofNullable(this.empresaRepository.findByCnpj(cnpj));
	}

	@Override
	public Empresa persist(Empresa cnpj) {
		LOG.info("save entity emprepsa {} ", cnpj);
		return this.empresaRepository.save(cnpj);
	}

}
