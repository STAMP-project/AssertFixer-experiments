package br.com.falcao.PontoInteligente.api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.falcao.PontoInteligente.api.dtos.EmpresaDto;
import br.com.falcao.PontoInteligente.api.entitys.Empresa;
import br.com.falcao.PontoInteligente.api.responses.Response;
import br.com.falcao.PontoInteligente.api.services.EmpresaService;

@RestController
@RequestMapping("/api/empresas")
@CrossOrigin(origins="*")
public class EmpresaController {

	private static final Logger log = LoggerFactory.getLogger(CadastroPJController.class);
	
	@Autowired
	private EmpresaService es;
	
	/* Construtor */
	public EmpresaController(){}
	
	/**
	 * 
	 * Retorna uma empresa dado um Cnpj
	 * 
	 * @param String cnpj
	 * @return ResponseEntity<Response<EmpresaDto>>
	 * 
	 * */
	
	@GetMapping(path="/cnpj/{cnpj}")
	public ResponseEntity<Response<EmpresaDto>> buscarPorCnpj(@PathVariable String cnpj){
		log.info("Buscando Empresa pelo CNPJ: {}", cnpj);
		Response<EmpresaDto> response = new Response<EmpresaDto>();
		
		Optional<Empresa> empresa = es.buscarPorCnpj(cnpj);
		
		if(!empresa.isPresent()) {
			log.info("Buscando Empresa pelo CNPJ: {}", cnpj);
			response.getErrors().add("Empresa não encontrada para o CNPJ: " + cnpj);
			
			return ResponseEntity.badRequest().body(response);
		}
		response.setData(this.converterEmpresaDto(empresa.get()));
		
		return ResponseEntity.ok().body(response);
		
	}
	
	/**
	 * Popula o DTO com os dados da empresa
	 * 
	 * @param empresa
	 * @return EmpresaDto
	 * 
	 * */
	
	private EmpresaDto converterEmpresaDto(Empresa empresa) {
		EmpresaDto empresaDto = new EmpresaDto();
		
		empresaDto.setId(empresa.getId());
		empresaDto.setNome(empresa.getNome());
		empresaDto.setCnpj(empresa.getCnpj());
		empresaDto.setRazaoSocial(empresa.getRazaoSocial());
		
		return empresaDto;
		
	}
	
}
