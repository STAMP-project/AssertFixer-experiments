package psidev.psi.mi.jami.enricher.impl.full;


import psidev.psi.mi.jami.bridges.fetcher.OrganismFetcher;
import psidev.psi.mi.jami.enricher.CvTermEnricher;
import psidev.psi.mi.jami.enricher.exception.EnricherException;
import psidev.psi.mi.jami.enricher.impl.minimal.MinimalOrganismUpdater;
import psidev.psi.mi.jami.enricher.util.EnricherUtils;
import psidev.psi.mi.jami.model.CvTerm;
import psidev.psi.mi.jami.model.Organism;
import psidev.psi.mi.jami.utils.comparator.cv.DefaultCvTermComparator;

/**
 * Provides full update of a Organism.
 *
 * - update minimal properties of organism. See details in MinimalOrganismUpdater
 * - if cvTermEnricher is not null, will update cellType, tissue and compartment.
 * It will override cellType, tissue and compartment with the ones loaded with the fetched organism if
 * they are different from the ones in the fetched organism. (See DefaultCvTermComparator)
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since  24/05/13

 */
public class FullOrganismUpdater extends MinimalOrganismUpdater {

    private CvTermEnricher<CvTerm> cvEnricher;

    /**
     * <p>Constructor for FullOrganismUpdater.</p>
     *
     * @param organismFetcher a {@link psidev.psi.mi.jami.bridges.fetcher.OrganismFetcher} object.
     */
    public FullOrganismUpdater(OrganismFetcher organismFetcher) {
        super(organismFetcher);
    }

    /**
     * <p>getCvTermEnricher.</p>
     *
     * @return a {@link psidev.psi.mi.jami.enricher.CvTermEnricher} object.
     */
    public CvTermEnricher<CvTerm> getCvTermEnricher() {
        return cvEnricher;
    }

    /** {@inheritDoc} */
    public void setCvTermEnricher(CvTermEnricher<CvTerm> cvEnricher) {
        this.cvEnricher = cvEnricher;
    }

    /** {@inheritDoc} */
    @Override
    protected void processOtherProperties(Organism organismToEnrich, Organism organismFetched) throws EnricherException {
        processAliases(organismToEnrich, organismFetched);

        processCellType(organismToEnrich, organismFetched);
        processTissue(organismToEnrich, organismFetched);
        processCompartment(organismToEnrich, organismFetched);
    }

    /**
     * <p>processAliases.</p>
     *
     * @param organismToEnrich a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param organismFetched a {@link psidev.psi.mi.jami.model.Organism} object.
     * @throws psidev.psi.mi.jami.enricher.exception.EnricherException if any.
     */
    protected void processAliases(Organism organismToEnrich, Organism organismFetched) throws EnricherException{
        EnricherUtils.mergeAliases(organismToEnrich, organismToEnrich.getAliases(), organismFetched.getAliases(), false, getOrganismEnricherListener());
    }

    /**
     * <p>processCellType.</p>
     *
     * @param entityToEnrich a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param fetched a {@link psidev.psi.mi.jami.model.Organism} object.
     * @throws psidev.psi.mi.jami.enricher.exception.EnricherException if any.
     */
    protected void processCellType(Organism entityToEnrich, Organism fetched) throws EnricherException {
        if (!DefaultCvTermComparator.areEquals(entityToEnrich.getCellType(),fetched.getCellType())){
            CvTerm old = entityToEnrich.getCellType();
            entityToEnrich.setCellType(fetched.getCellType());
            if (getOrganismEnricherListener() != null){
                getOrganismEnricherListener().onCellTypeUpdate(entityToEnrich, old);
            }
        }
        else if (getCvTermEnricher() != null
                && entityToEnrich.getCellType() != fetched.getCellType()){
            getCvTermEnricher().enrich(entityToEnrich.getCellType(), fetched.getCellType());
        }
        if (getCvTermEnricher() != null && entityToEnrich.getCellType() != null){
            getCvTermEnricher().enrich(entityToEnrich.getCellType());
        }
    }

    /**
     * <p>processTissue.</p>
     *
     * @param entityToEnrich a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param fetched a {@link psidev.psi.mi.jami.model.Organism} object.
     * @throws psidev.psi.mi.jami.enricher.exception.EnricherException if any.
     */
    protected void processTissue(Organism entityToEnrich, Organism fetched) throws EnricherException {
        if (!DefaultCvTermComparator.areEquals(entityToEnrich.getTissue(), fetched.getTissue())){
            CvTerm old = entityToEnrich.getTissue();
            entityToEnrich.setTissue(fetched.getTissue());
            if (getOrganismEnricherListener() != null){
                getOrganismEnricherListener().onTissueUpdate(entityToEnrich, old);
            }
        }
        else if (getCvTermEnricher() != null
                && entityToEnrich.getTissue() != fetched.getTissue()){
            getCvTermEnricher().enrich(entityToEnrich.getTissue(), fetched.getTissue());
        }
        if (getCvTermEnricher() != null && entityToEnrich.getTissue() != null){
            getCvTermEnricher().enrich(entityToEnrich.getTissue());
        }
    }

    /**
     * <p>processCompartment.</p>
     *
     * @param entityToEnrich a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param fetched a {@link psidev.psi.mi.jami.model.Organism} object.
     * @throws psidev.psi.mi.jami.enricher.exception.EnricherException if any.
     */
    protected void processCompartment(Organism entityToEnrich, Organism fetched) throws EnricherException {
        if (!DefaultCvTermComparator.areEquals(entityToEnrich.getCompartment(),fetched.getCompartment())){
            CvTerm old = entityToEnrich.getCompartment();
            entityToEnrich.setCompartment(fetched.getCompartment());
            if (getOrganismEnricherListener() != null){
                getOrganismEnricherListener().onCompartmentUpdate(entityToEnrich, old);
            }
        }
        else if (getCvTermEnricher() != null
                && entityToEnrich.getCompartment() != fetched.getCompartment()){
            getCvTermEnricher().enrich(entityToEnrich.getCompartment(), fetched.getCompartment());
        }
        if (getCvTermEnricher() != null && entityToEnrich.getCompartment() != null){
            getCvTermEnricher().enrich(entityToEnrich.getCompartment());
        }
    }
}
