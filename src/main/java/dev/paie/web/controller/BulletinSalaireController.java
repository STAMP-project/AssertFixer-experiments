package dev.paie.web.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalairerepository;
import dev.paie.repository.PeriodeRepository;
import dev.paie.services.EmployeService;

@Controller
@RequestMapping("/bulletins")
public class BulletinSalaireController {

	@Autowired
	private EmployeService employeService;

	@Autowired
	private PeriodeRepository perioderepository;

	@Autowired
	private BulletinSalairerepository bulletinSalairerepository;

	@RequestMapping(method = RequestMethod.GET, path = "/creerBulletin")
	@Secured("ROLE_ADMINISTRATEUR")
	public ModelAndView creerEmploye() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/creerBulletin");
		mv.addObject("employes", employeService.getLesEmploye());
		mv.addObject("periodes", perioderepository.findAll());
		mv.addObject("bulletin", new BulletinSalaire());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST, path = "/creerBulletin")
	@Secured("ROLE_ADMINISTRATEUR")
	public String submitForm(@ModelAttribute("bulletin") BulletinSalaire bulletin) {
		bulletin.setDateCreation(LocalDateTime.now());
		bulletinSalairerepository.save(bulletin);
		return "redirect:/mvc/bulletins/listeBulletin";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/listeBulletin")
	@Secured({"ROLE_UTILISATEUR", "ROLE_ADMINISTRATEUR"})
	public ModelAndView listerEmploye() {
		List<BulletinSalaire> bulletins = bulletinSalairerepository.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bulletins/listeBulletin");
		mv.addObject("bulletins", bulletins);
		return mv;
	}
}