package dev.controller.api.concours;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dev.controller.api.viewModels.passageConcours.PassageConcoursReturnVm;
import dev.controller.api.viewModels.passageConcours.PassageConcoursVm;
import dev.controller.api.viewModels.passageConcours.ResultatConcoursVm;
import dev.metiers.PassageConcoursService;

@Controller
@RequestMapping("/api/passage_concours")
public class PassageConcoursController {
	
	private PassageConcoursService passageConcoursService;
	
	public PassageConcoursController(PassageConcoursService passageConcoursService){
		this.passageConcoursService = passageConcoursService;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/start")
	public ResponseEntity<?> startConcours(@RequestBody PassageConcoursVm passageConcoursVm) {
		

		return ResponseEntity.status(HttpStatus.CREATED).body(new PassageConcoursReturnVm(passageConcoursService.createPassage(passageConcoursVm)));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/resultat")
	public ResponseEntity<?> getResultatByStagiaire(@RequestParam(value="id_stagiaire") Long stagiaireId) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new ResultatConcoursVm(2L, "Non implemented", 100));
	}

}
