package br.com.smartpoint.controller.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/api/funcionario")
@CrossOrigin(origins = "*")
public class FuncionarioController {
	
	private static final Logger LOG  = LoggerFactory.getLogger(FuncionarioController.class);
	
	
	
	

}
