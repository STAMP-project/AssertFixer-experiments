package test.nc.noumea.mairie.bilan.energie.contract.service;

import nc.noumea.mairie.bilan.energie.business.entities.PoliceEntity;
import nc.noumea.mairie.bilan.energie.contract.dto.*;
import nc.noumea.mairie.bilan.energie.contract.enumeration.EtatFichier;
import nc.noumea.mairie.bilan.energie.contract.exceptions.BusinessValidationException;
import nc.noumea.mairie.bilan.energie.contract.service.FichierFactureService;
import nc.noumea.mairie.bilan.energie.contract.service.PoliceService;
import nc.noumea.mairie.bilan.energie.core.exception.BusinessException;
import nc.noumea.mairie.bilan.energie.core.exception.TechnicalException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.nc.noumea.mairie.bilan.energie.business.dao.BilanBusinessTestNG;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Test des méthodes de PoliceBusiness
 *
 * @author Josselin PEYRON
 */
public class FichierFactureServiceTest extends BilanBusinessTestNG {


    @Autowired
    private FichierFactureService fichierFactureService;

    /**
     * SessionFactory
     */
    @Autowired
    protected SessionFactory sessionFactory;


    @BeforeMethod
    protected void init() {
        super.init();
        createUtilisateur();
    }

    @AfterMethod
    protected void destroy() {
        super.destroy();
    }

    public FichierFactureSimple createFichierFactureSimple(String nom, String md5, EtatFichier etatFichier) throws TechnicalException, BusinessException {
        FichierFactureSimple fichierFacture = new FichierFactureSimple();
        fichierFacture.setNom(nom);
        fichierFacture.setMd5(md5);
        fichierFacture.setEtat(etatFichier);
        return fichierFactureService.create(fichierFacture);
    }

    @Test
    public void testGetAllSimilaire() throws TechnicalException, BusinessException {
        FichierFactureSimple fichierFacture1 = createFichierFactureSimple("toto","md5", EtatFichier.INTEGRE);
        FichierFactureSimple fichierFacture2 = createFichierFactureSimple("toto","md5", EtatFichier.ANOMALIE_IMPORT);
        getCurrentSession().flush();

        Assert.assertNotNull(fichierFacture1.getId());
        List<FichierFactureSimple> fichierFactureSimpleList1 = fichierFactureService.getAllSimilaire(fichierFacture1);
        Assert.assertNotNull(fichierFactureSimpleList1);
        Assert.assertEquals(fichierFactureSimpleList1.size(), 1);
        Assert.assertEquals(fichierFactureSimpleList1.get(0).getId(), fichierFacture2.getId());

        List<FichierFactureSimple> fichierFactureSimpleList2 = fichierFactureService.getAllSimilaire(fichierFacture2);
        Assert.assertNotNull(fichierFactureSimpleList2);
        Assert.assertEquals(fichierFactureSimpleList2.size(), 1);
        Assert.assertEquals(fichierFactureSimpleList2.get(0).getId(), fichierFacture1.getId());

    }

}
