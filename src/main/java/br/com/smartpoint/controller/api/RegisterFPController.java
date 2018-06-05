package br.com.smartpoint.controller.api;

import java.math.BigDecimal;
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

import br.com.smartpoint.dto.api.RegisterFPDto;
import br.com.smartpoint.entities.api.Empresa;
import br.com.smartpoint.entities.api.Funcionario;
import br.com.smartpoint.enums.api.PerfilEnum;
import br.com.smartpoint.response.api.Response;
import br.com.smartpoint.services.api.EmpresaService;
import br.com.smartpoint.services.api.FuncionarioService;
import br.com.smartpoint.utils.api.PasswordUtils;

@RestController
@RequestMapping(value = "/register/api-fp")
@CrossOrigin(value = "*")
public class RegisterFPController {

	private static final Logger LOG = LoggerFactory.getLogger(RegisterFPController.class);

	@Autowired
	private EmpresaService empresaService;
	@Autowired
	private FuncionarioService funcionarioservice;

	@PostMapping
	public ResponseEntity<Response<RegisterFPDto>> register(@Valid @RequestBody RegisterFPDto registerFPDto,
			BindingResult bindingResult)  {
		LOG.info("Registering PF {} ", registerFPDto.toString());

		Response<RegisterFPDto> response = new Response<RegisterFPDto>();

		this.validateValuesRequest(registerFPDto, bindingResult);

		Funcionario funcionario = this.converterFuncionario(registerFPDto);

		if (bindingResult.hasErrors()) {
			LOG.error("error on register {} " , bindingResult.getAllErrors());
			bindingResult.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		Optional<Empresa> optioncompany = this.empresaService.findForCompany(registerFPDto.getCnpj());		
		optioncompany.ifPresent(x ->  funcionario.setEmpresa(x));
		this.funcionarioservice.persist(funcionario);		
		response.setData(this.convertertoDto(funcionario));

		return ResponseEntity.ok(response);
	}

	
	private RegisterFPDto convertertoDto(Funcionario funcionario)
	
	{ 
	  RegisterFPDto  dto = new RegisterFPDto(funcionario.getNome(),funcionario.getEmail(),funcionario.getCpf());
	  dto.setCnpj(funcionario.getEmpresa().getCnpj());		
		return dto;
	}


	private Funcionario converterFuncionario(RegisterFPDto registerFPDto) {
		Funcionario funcionario = new Funcionario();

		funcionario.setCpf(registerFPDto.getCpf());
		funcionario.setEmail(registerFPDto.getEmail());
		funcionario.setPerfil(PerfilEnum.ROLE_USER);
		funcionario.setNome(registerFPDto.getName());
		funcionario.setSenha(PasswordUtils.generateCryptPassword(registerFPDto.getPassword()));

		/**
		 * here are values that dont persist on database 
		 * registerFPDto.getHourvalue()
		 * registerFPDto.getQtyLunch() 
		 * registerFPDto.getQuantityHourOfDay()
		 * 
		 * are dynamics attributes *
		 */
		registerFPDto.getHourvalue().ifPresent(x -> funcionario.setValorHora(new BigDecimal(x)));
		registerFPDto.getQtyLunch().ifPresent(x -> funcionario.setQtdHorasAlmoco(Float.valueOf(x)));
		registerFPDto.getQuantityHourOfDay().ifPresent(x -> funcionario.setQtdHorasTrabalhoDia(Float.valueOf(x)));

		return null;
	}

	private void validateValuesRequest(@Valid RegisterFPDto registerFPDto, BindingResult bindingResult)

	{
		Optional<Empresa> optionCompany = empresaService.findForCompany(registerFPDto.getCnpj());

		if (!optionCompany.isPresent()) {
			bindingResult.addError(new ObjectError("empresa", "this company don't exists "));
		}

		this.funcionarioservice.findForCpf(registerFPDto.getCpf())
				.ifPresent(employe -> bindingResult.addError(new ObjectError("cpf", "this cpf also exists ")));

		this.funcionarioservice.findForEmail(registerFPDto.getEmail())
				.ifPresent(employe -> bindingResult.addError(new ObjectError("email", " this email also exists")));

	}

}
