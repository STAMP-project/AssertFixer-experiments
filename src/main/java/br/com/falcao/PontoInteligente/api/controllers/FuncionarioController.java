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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.falcao.PontoInteligente.api.dtos.FuncionarioDto;
import br.com.falcao.PontoInteligente.api.entitys.Funcionario;
import br.com.falcao.PontoInteligente.api.responses.Response;
import br.com.falcao.PontoInteligente.api.services.FuncionarioService;
import br.com.falcao.PontoInteligente.api.utils.PasswordUtils;

@RestController
@RequestMapping("/api/funcionarios")
@CrossOrigin(origins="*")
public class FuncionarioController {

	private static final Logger log = LoggerFactory.getLogger(CadastroPJController.class);
	
	@Autowired
	private FuncionarioService fs;
	
	/* Construtor */
	public FuncionarioController() {}
	
	/**
	 * 
	 * Atualiza os dados de um funcionário
	 * 
	 * @param id
	 * @param funcionarioDto
	 * @param result
	 * @return ResponseEntity<Response<FuncionarioDto>>
	 * @throws NoSuchAlgorithmException
	 * 
	 * 
	 * */
	
	@PutMapping(path="/{id}")
	public ResponseEntity<Response<FuncionarioDto>> atualizar(
			@PathVariable Long id,
			@Valid @RequestBody FuncionarioDto funcionarioDto,
			BindingResult result
			) throws NoSuchAlgorithmException {
		log.info("Atualizando Funcionario: {}", funcionarioDto.toString());
		
		Response<FuncionarioDto> response = new Response<FuncionarioDto>();
		Optional<Funcionario> funcionario = this.fs.buscarPorId(id);
		
		if(!funcionario.isPresent()) {
			log.info("Não foram encontrados funcionários com o Id: {}", id);
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));;
			
			return ResponseEntity.badRequest().body(response);
		}
		
		this.atualizarDadosFuncionario(funcionario.get(), funcionarioDto, result);
		
		if(result.hasErrors()) {
			log.info("Erro ao validar o funcionário: {}", result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			
			return ResponseEntity.badRequest().body(response);
		}
		
		this.fs.persistir(funcionario.get());
		response.setData(this.converterFuncionarioDto(funcionario.get()));
		
		return ResponseEntity.ok().body(response);
		
	}
	
	/**
	 *
	 * Atualiza os dados do funcionário com base nos dados encontrados no DTO.
	 * 
	 *
	 * @param funcionario
	 * @param funcionarioDto
	 * @param result
	 * @throws NoSuchAlgorithmException
	 * 
	 * */
	
	private void atualizarDadosFuncionario(Funcionario funcionario, FuncionarioDto funcionarioDto, BindingResult result) {
		
		funcionario.setNome(funcionarioDto.getNome());
		
		if(!funcionario.getEmail().equals(funcionarioDto.getEmail())) {
			this.fs.buscarPorEmail(funcionarioDto.getEmail())
				.ifPresent(func -> result.addError(new ObjectError("email", "E-mail já existe.")));
			funcionario.setEmail(funcionarioDto.getEmail());
		}
	
		/* Para previnir qualquer erro */
		funcionario.setQtdHorasAlmoco(null);
		funcionarioDto.getQtdHorasAlmoco()
			.ifPresent(qtdHorasAlmoco -> funcionario.setQtdHorasAlmoco(Float.valueOf(qtdHorasAlmoco)));
		
		funcionario.setQtdHorasTrabalhoDia(null);
		funcionarioDto.getQtdHorasTrabalhoDia()
				.ifPresent(qtdHorasTrabDia -> funcionario.setQtdHorasTrabalhoDia(Float.valueOf(qtdHorasTrabDia)));

		funcionario.setValorHora(null);
		funcionarioDto.getValorHora().ifPresent(valorHora -> funcionario.setValorHora(new BigDecimal(valorHora)));

		if (funcionarioDto.getSenha().isPresent()) {
			funcionario.setSenha(PasswordUtils.gerarBCrypt(funcionarioDto.getSenha().get()));
		}
		
	}
	
	/**
	 * 
	 * Retorna um DTO com os dados de um funcionário
	 * 
	 * @param funcionario
	 * @return funcionarioDto
	 * 
	 * 
	 * */
	
	private FuncionarioDto converterFuncionarioDto(Funcionario funcionario) {
		
		FuncionarioDto funcionarioDto = new FuncionarioDto();
		
		funcionarioDto.setId(funcionario.getId());
		funcionarioDto.setEmail(funcionario.getEmail());
		funcionarioDto.setNome(funcionario.getNome());
		funcionario.getQtdHorasAlmocoOpt().ifPresent(
				qtdHorasAlmoco -> funcionarioDto.setQtdHorasAlmoco(Optional.of(Float.toString(qtdHorasAlmoco))));
		funcionario.getQtdHorasTrabalhoDiaOpt().ifPresent(
				qtdHorasTrabDia -> funcionarioDto.setQtdHorasTrabalhoDia(Optional.of(Float.toString(qtdHorasTrabDia))));
		funcionario.getValorHoraOpt()
				.ifPresent(valorHora -> funcionarioDto.setValorHora(Optional.of(valorHora.toString())));
		
		return funcionarioDto;
		
	}
	
}
