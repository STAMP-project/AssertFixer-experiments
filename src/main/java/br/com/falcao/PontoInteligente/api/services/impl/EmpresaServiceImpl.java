package br.com.falcao.PontoInteligente.api.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.falcao.PontoInteligente.api.entitys.Empresa;
import br.com.falcao.PontoInteligente.api.repositorys.EmpresaRepository;
import br.com.falcao.PontoInteligente.api.services.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService{

	private static final Logger log = LoggerFactory.getLogger(EmpresaServiceImpl.class);
	
	@Autowired
	private EmpresaRepository er;
	
	@Override
	public Optional<Empresa> buscarPorCnpj(String cnpj) {
		// TODO Auto-generated method stub
		log.info("Buscando uma empresa pelo CNPJ {}", cnpj);
		return Optional.ofNullable(this.er.findByCnpj(cnpj));
	}

	@Override
	public Empresa persistir(Empresa empresa) {
		// TODO Auto-generated method stub
		log.info("Adicionando a empresa no banco de dados: {}", empresa);
		return this.er.save(empresa);
	}

}
