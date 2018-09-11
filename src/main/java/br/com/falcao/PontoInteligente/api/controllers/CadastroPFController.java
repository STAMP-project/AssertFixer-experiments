package br.com.falcao.PontoInteligente.api.controllers;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.falcao.PontoInteligente.api.dtos.CadastroPFDto;
import br.com.falcao.PontoInteligente.api.entitys.Empresa;
import br.com.falcao.PontoInteligente.api.entitys.Funcionario;
import br.com.falcao.PontoInteligente.api.enums.PerfilEnum;
import br.com.falcao.PontoInteligente.api.responses.Response;
import br.com.falcao.PontoInteligente.api.services.EmpresaService;
import br.com.falcao.PontoInteligente.api.services.FuncionarioService;
import br.com.falcao.PontoInteligente.api.utils.PasswordUtils;

@RestController
@RequestMapping("/api/cadastrar-pf")
@CrossOrigin(origins="*")
public class CadastroPFController {

	private static final Logger log = LoggerFactory.getLogger(CadastroPJController.class);
	
	@Autowired
	private FuncionarioService fs;

	@Autowired
	private EmpresaService es;
	
	/* Construtor */
	public CadastroPFController() {}
	
	/**
	 * 
	 * Cadastra um funcionário pessoa Física no sistema
	 * 
	 * @param cadastroPFDto
	 * @param result
	 * @return ResponseEntity<Response<CadastroPFDto>>
	 * @throws NoSuchAlgorithmException
	 * 
	 * 
	 * */
	
	@PostMapping
	public ResponseEntity<Response<CadastroPFDto>> cadastrar(
			@Valid @RequestBody CadastroPFDto cadastroPFDto,
			BindingResult result
			) throws NoSuchAlgorithmException {
		
		log.info("Cadastrando Pessoa Física: {}", cadastroPFDto.toString());
		
		Response<CadastroPFDto> response = new Response<CadastroPFDto>();
		
		validarDadosExistentes(cadastroPFDto, result);
		
		/* Convertendo cadastroPFDto para funcionario */
		Funcionario funcionario = this.converterParaFuncionario(cadastroPFDto, result);
		
		if(result.hasErrors()) {
			log.info("Erro ao validar dados da Pessoa Física: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<Empresa> empresa = this.es.buscarPorCnpj(cadastroPFDto.getCnpj());
		empresa.ifPresent(emp -> funcionario.setEmpresa(emp));
		this.fs.persistir(funcionario);
		
		response.setData(this.converterCadastroPFDto(funcionario));
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * 
	 * Verifica se a empresa está cadastrada e se o funcionário não existe no banco de dados
	 * 
	 * @param cadastroPFDto
	 * @param result
	 * 
	 * */
	
	public void validarDadosExistentes(CadastroPFDto cadastroPFDto, BindingResult result){
		
		Optional<Empresa> empresa = this.es.buscarPorCnpj(cadastroPFDto.getCnpj());
		if(!empresa.isPresent()) {
			result.addError(new ObjectError("empresa", "Empresa não cadastrada."));
		}
		
		this.fs.buscarPorCpf(cadastroPFDto.getCpf())
			.ifPresent(func -> result.addError(new ObjectError("funcionario", "Cpf já cadastrado.")));
		
		this.fs.buscarPorEmail(cadastroPFDto.getEmail())
			.ifPresent(func -> result.addError(new ObjectError("funcionario", "E-mail já cadastrado.")));
		
	}
	
	/**
	 * 
	 * Converte os dados CadastroPFDto para funcionário
	 * 
	 * @param cadastroPFDto
	 * @param result
	 * 
	 * @return funcionario
	 * 
	 * */
	
	public Funcionario converterParaFuncionario(CadastroPFDto cadastroPFDto, BindingResult result) 
			throws NoSuchAlgorithmException{
		
		Funcionario funcionario = new Funcionario();
		
		funcionario.setNome(cadastroPFDto.getNome());
		funcionario.setEmail(cadastroPFDto.getEmail());
		funcionario.setPerfil(PerfilEnum.ROLE_USUARIO);
		funcionario.setCpf(cadastroPFDto.getCpf());
		funcionario.setCpf(cadastroPFDto.getCpf());
		funcionario.setSenha(PasswordUtils.gerarBCrypt(cadastroPFDto.getSenha()));
		cadastroPFDto.getQtdHorasAlmoco()
			.ifPresent(qtdHorasAlmoco -> funcionario.setQtdHorasAlmoco(Float.valueOf(qtdHorasAlmoco)));
		cadastroPFDto.getQtdHorasTrabalhoDia()
			.ifPresent(qtdHorasTrabDia -> funcionario.setQtdHorasTrabalhoDia(Float.valueOf(qtdHorasTrabDia)));
		cadastroPFDto.getValorHora().ifPresent(valorHora -> funcionario.setValorHora(new BigDecimal(valorHora)));
		
		return funcionario;
		
	}
	
	/**
	 * 
	 * Popula o DTO de cadastro com os dados do funcionário e empresa
	 * 
	 * @param funcionario
	 * @return cadastroPFDto
	 * 
	 * */
	
	public CadastroPFDto converterCadastroPFDto(Funcionario funcionario) {
		
		CadastroPFDto cadastroPFDto = new CadastroPFDto();
		
		cadastroPFDto.setId(funcionario.getId());
		cadastroPFDto.setNome(funcionario.getNome());
		cadastroPFDto.setEmail(funcionario.getEmail());
		cadastroPFDto.setCpf(funcionario.getCpf());
		cadastroPFDto.setCnpj(funcionario.getEmpresa().getCnpj());
		funcionario.getQdtHorasAlmocoOpt()
			.ifPresent(
					qtdHorasAlmoco -> cadastroPFDto.setQtdHorasAlmoco(Optional.of(Float.toString(qtdHorasAlmoco))));
		funcionario.getQtdHorasTrabalhoDiaOpt()
			.ifPresent(
				qtdHorasTrabDia -> cadastroPFDto.setQtdHorasTrabalhoDia(Optional.of(Float.toString(qtdHorasTrabDia))));
		funcionario.getValorHoraOpt()
				.ifPresent(valorHora -> cadastroPFDto.setValorHora(Optional.of(valorHora.toString())));
		
		return cadastroPFDto;
		
	}
	
}
