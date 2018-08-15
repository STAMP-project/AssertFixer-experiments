package psidev.psi.mi.jami.enricher;

import psidev.psi.mi.jami.bridges.fetcher.InteractorFetcher;
import psidev.psi.mi.jami.enricher.listener.InteractorEnricherListener;
import psidev.psi.mi.jami.model.CvTerm;
import psidev.psi.mi.jami.model.Interactor;

/**
 * Interface for interactor enrichers.
 * It does not require a fetcher in all interactor enrichers, only for some proteins, genes and
 * bioactive entities enrichers.
 *
 * Sub enrichers:
 * - organism enricher
 * - cv term enricher
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>01/10/13</pre>
 */
public interface InteractorEnricher<T extends Interactor> extends MIEnricher<T>{

    /**
     * Returns the current fetcher which is being used to collect information about entities for enrichment.
     *
     * @return  The current fetcher.
     */
    public InteractorFetcher<T> getInteractorFetcher();

    /**
     * The current listener of changes to the bioactiveEntities.
     *
     * @return  The current listener. Can be null.
     */
    public InteractorEnricherListener<T> getListener();

    /**
     * <p>getCvTermEnricher.</p>
     *
     * @return a {@link psidev.psi.mi.jami.enricher.CvTermEnricher} object.
     */
    public CvTermEnricher<CvTerm> getCvTermEnricher();

    /**
     * <p>getOrganismEnricher.</p>
     *
     * @return a {@link psidev.psi.mi.jami.enricher.OrganismEnricher} object.
     */
    public OrganismEnricher getOrganismEnricher();

    /**
     * <p>setListener.</p>
     *
     * @param listener a {@link psidev.psi.mi.jami.enricher.listener.InteractorEnricherListener} object.
     */
    public void setListener(InteractorEnricherListener<T> listener);

    /**
     * <p>setCvTermEnricher.</p>
     *
     * @param enricher a {@link psidev.psi.mi.jami.enricher.CvTermEnricher} object.
     */
    public void setCvTermEnricher(CvTermEnricher<CvTerm> enricher);

    /**
     * <p>setOrganismEnricher.</p>
     *
     * @param enricher a {@link psidev.psi.mi.jami.enricher.OrganismEnricher} object.
     */
    public void setOrganismEnricher(OrganismEnricher enricher);
}
