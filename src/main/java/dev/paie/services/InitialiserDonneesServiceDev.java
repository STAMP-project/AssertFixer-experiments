package dev.paie.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Cotisation;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.Periode;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.Utilisateur;
import dev.paie.entite.Utilisateur.ROLES;

@Service
public class InitialiserDonneesServiceDev implements InitialiserDonneesService {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	CotisationService cotisationServiceJpa;
	@Autowired
	GradeServiceJdbcTemplate gradeService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void initialiser() {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("cotisations-imposables.xml",
				"cotisations-non-imposables.xml", "entreprises.xml", "grades.xml", "profils-remuneration.xml");
		Map<String, Cotisation> cots = context.getBeansOfType(Cotisation.class);
		for (Cotisation cot : cots.values()) {
			cotisationServiceJpa.sauvegarder(cot);
		}

		Map<String, Grade> grades = context.getBeansOfType(Grade.class);
		for (Grade g : grades.values()) {
			gradeService.sauvegarder(g);
		}

		Map<String, Entreprise> entreprises = context.getBeansOfType(Entreprise.class);
		for (Entreprise e : entreprises.values()) {
			em.persist(e);
		}

		Map<String, ProfilRemuneration> profils = context.getBeansOfType(ProfilRemuneration.class);
		for (ProfilRemuneration p : profils.values()) {
			em.persist(p);
		}

		int annee = LocalDateTime.now().getYear();
		for (int i = 1; i < 13; i++) {
			Periode p = new Periode();
			LocalDate date = LocalDate.of(annee, i, 1);
			p.setDateDebut(date);
			date = LocalDate.of(annee, i, date.getMonth().minLength());
			p.setDateFin(date);
			em.persist(p);
		}

		Utilisateur user1 = new Utilisateur("admin", this.passwordEncoder.encode("admin"), true,
				ROLES.ROLE_ADMINISTRATEUR);
		Utilisateur user2 = new Utilisateur("user", this.passwordEncoder.encode("user"), true, ROLES.ROLE_UTILISATEUR);
		em.persist(user1);
		em.persist(user2);

		context.close();
	}

}
