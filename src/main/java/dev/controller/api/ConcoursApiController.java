package dev.controller.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.entites.Concours;
import dev.metiers.ConcoursService;

@RestController
@RequestMapping("/api/concours")
public class ConcoursApiController {
	
	private ConcoursService concourService;
	
	public ConcoursApiController(ConcoursService concourService){
		this.concourService = concourService;
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Concours>> lister() {

		List<Concours> returnArray = new ArrayList<>();
		returnArray = concourService.list();
		return ResponseEntity.ok(returnArray);

	}

}
