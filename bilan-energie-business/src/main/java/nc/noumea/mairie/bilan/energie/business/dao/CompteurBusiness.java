package nc.noumea.mairie.bilan.energie.business.dao;

import nc.noumea.mairie.bilan.energie.business.entities.CompteurEntity;
import nc.noumea.mairie.bilan.energie.contract.dto.Compteur;
import nc.noumea.mairie.bilan.energie.contract.dto.Periodique;
import nc.noumea.mairie.bilan.energie.contract.dto.Police;
import nc.noumea.mairie.bilan.energie.contract.exceptions.BusinessValidationException;
import nc.noumea.mairie.bilan.energie.contract.exceptions.ValidatorException;
import nc.noumea.mairie.bilan.energie.contract.service.CompteurService;
import nc.noumea.mairie.bilan.energie.contract.service.PoliceService;
import nc.noumea.mairie.bilan.energie.core.converter.ConvertManager;
import nc.noumea.mairie.bilan.energie.core.exception.BusinessException;
import nc.noumea.mairie.bilan.energie.core.exception.TechnicalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service de gestion des compteurs
 *
 * @author Greg Dujardin
 *
 */
@Service("compteurService")
@Scope(value = "singleton", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CompteurBusiness extends
		AbstractCrudBusiness<Compteur, CompteurEntity> implements
		CompteurService {

	/** Moteur de conversion */
	@Autowired
	private ConvertManager cm;

	@Autowired
	private PoliceService policeService;


	/**
	 * Recherche des compteurs par numéro de compteur exact
	 * @param numeroCompteur Numéro de compteur
	 *
	 * @return Liste des compteurs
     * @throws TechnicalException Exception technique
	 * @throws BusinessException Exception métier
	 */
	@Override
	public List<Compteur> getAllByNumeroCompteurExact(String numeroCompteur)
			throws TechnicalException, BusinessException {

		String numeroCompteurParam = numeroCompteur.toUpperCase() ;

		@SuppressWarnings("unchecked")
		List<CompteurEntity> listeCompteurEntity = (List<CompteurEntity>) sessionFactory
				.getCurrentSession()
				.createQuery(
						"from " + getEntityClass().getName()
								+ " where upper(num_compteur) = :numeroCompteurParam")
				.setParameter("numeroCompteurParam", numeroCompteurParam).list();


		return cm.convertList(listeCompteurEntity, getDtoClass());
	}

	/** Récupération de la class de l'entité */
	@Override
	public Class<CompteurEntity> getEntityClass() {
		return CompteurEntity.class;
	}

	/** Récupération de la class du DTO */
	@Override
	public Class<Compteur> getDtoClass() {
		return Compteur.class;
	}

	@Override
	public void validate(Compteur compteur) throws BusinessException, TechnicalException {
		super.validate(compteur);
		Police police = getPolice(compteur);
		validateNumeroDoublon(compteur, police);
		validateDates(compteur);
		validateDatePolice(compteur, police);
	}

	@Override
	public void validateFromPolice(Compteur compteur, Police police) throws BusinessException {
		validateNumeroDoublon(compteur, police);
		validateDates(compteur);
		validateDatePolice(compteur, police);
	}

	private void validateDatePolice(Compteur compteur, Police police) throws BusinessException {
		if (compteur.getDateFin() == null && police.getDateFin() != null){
			throw new BusinessValidationException(CompteurService.ERROR_DATE_FIN_NON_RENSEIGNEE);
		}
		if (!Periodique.isInPeriode(compteur, police)){
			throw new BusinessValidationException(CompteurService.ERROR_HORS_PERIODE_POLICE);
		}
	}

	private void validateDates(Compteur compteur) throws  BusinessException {
		if (compteur.getDateFin() != null && compteur.getDateFin().before(compteur.getDateDebut())){
			throw new BusinessValidationException(CompteurService.ERROR_DATE_FIN_NOK);
		}
	}

	private void validateNumeroDoublon(Compteur compteur, Police police) throws BusinessException {
		List<Compteur> listeCompteur = police.getListeCompteur();
		if (listeCompteur != null && !listeCompteur.isEmpty()) {
			for (Compteur compteurExistant : listeCompteur){
				if (!compteurExistant.equals(compteur) && compteurExistant.getNumCompteur().equals(compteur.getNumCompteur())) {
					throw new BusinessValidationException(CompteurService.ERROR_NUMERO_DOUBLON_POLICE);
				}
			}
		}
	}

	private Police getPolice(Compteur compteur) throws TechnicalException, BusinessException {
		return policeService.read(compteur.getIdPolice());
	}


}
