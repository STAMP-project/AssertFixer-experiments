package dev.paie.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@RestController
public class cotisations {

	@Autowired
	private CotisationRepository cotisationRepository;

	@RequestMapping(value = "api/cotisations", method = RequestMethod.GET)
	public List<Cotisation> lesCotisations() {
		return cotisationRepository.findAll();
	}

	@RequestMapping(value = "api/cotisations/{cotCode}", method = RequestMethod.GET)
	public ResponseEntity<?> laCotisation(@PathVariable String cotCode) {
		if (cotisationRepository.findByCode(cotCode) == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Code de cotisations non trouvé");
		return ResponseEntity.status(HttpStatus.OK).body(cotisationRepository.findByCode(cotCode));
	}

	@RequestMapping(value = "api/cotisations", method = RequestMethod.POST)
	public void sauvCot(@RequestBody Cotisation cot) {
		cotisationRepository.save(cot);
	}

	@RequestMapping(value = "api/cotisations/{cotCode}", method = RequestMethod.PUT)
	public void modifCot(@RequestBody Cotisation cot, @PathVariable String cotCode) {
		cot.setCode(cotCode);
		cotisationRepository.save(cot);
	}

	@RequestMapping(value = "api/cotisations/{cotCode}", method = RequestMethod.DELETE)
	public void supprCot(@PathVariable String cotCode) {
		cotisationRepository.delete(cotisationRepository.findByCode(cotCode));
	}

}
