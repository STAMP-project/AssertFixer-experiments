package psidev.psi.mi.jami.model.impl;

import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.utils.CvTermUtils;
import psidev.psi.mi.jami.utils.XrefUtils;
import psidev.psi.mi.jami.utils.collection.AbstractListHavingProperties;

import java.util.*;

/**
 * Default implementation for a Publication
 *
 * Notes: The equals and hashcode methods have NOT been overridden because the Publication object is a complex object.
 * To compare Publication objects, you can use some comparators provided by default:
 * - DefaultPublicationComparator
 * - UnambiguousPublicationComparator
 * - DefaultCuratedPublicationComparator
 * - UnambiguousCuratedPublicationComparator
 * - PublicationComparator
 * - CuratedPublicationComparator
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>22/01/13</pre>
 */
public class DefaultPublication implements Publication {

    private String title;
    private String journal;
    private Date publicationDate;
    private List<String> authors;
    private Collection<Xref> identifiers;
    private Collection<Xref> xrefs;
    private Collection<Annotation> annotations;
    private Collection<Experiment> experiments;
    private CurationDepth curationDepth;
    private Date releasedDate;
    private Source source;

    private Xref pubmedId;
    private Xref doi;
    private Xref imexId;

    /**
     * <p>Constructor for DefaultPublication.</p>
     */
    public DefaultPublication(){
        this.curationDepth = CurationDepth.undefined;
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param identifier a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultPublication(Xref identifier){
        this();

        if (identifier != null){
            getIdentifiers().add(identifier);
        }
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param identifier a {@link psidev.psi.mi.jami.model.Xref} object.
     * @param curationDepth a {@link psidev.psi.mi.jami.model.CurationDepth} object.
     * @param source a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public DefaultPublication(Xref identifier, CurationDepth curationDepth, Source source){
        this(identifier);
        if (curationDepth != null){
            this.curationDepth = curationDepth;
        }
        this.source = source;
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param identifier a {@link psidev.psi.mi.jami.model.Xref} object.
     * @param imexId a {@link java.lang.String} object.
     * @param source a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public DefaultPublication(Xref identifier, String imexId, Source source){
        this(identifier, CurationDepth.IMEx, source);
        assignImexId(imexId);
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param pubmed a {@link java.lang.String} object.
     */
    public DefaultPublication(String pubmed){
        this.curationDepth = CurationDepth.undefined;

        if (pubmed != null){
            setPubmedId(pubmed);
        }
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param pubmed a {@link java.lang.String} object.
     * @param curationDepth a {@link psidev.psi.mi.jami.model.CurationDepth} object.
     * @param source a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public DefaultPublication(String pubmed, CurationDepth curationDepth, Source source){
        this(pubmed);
        if (curationDepth != null){
            this.curationDepth = curationDepth;
        }
        this.source = source;
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param pubmed a {@link java.lang.String} object.
     * @param imexId a {@link java.lang.String} object.
     * @param source a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public DefaultPublication(String pubmed, String imexId, Source source){
        this(pubmed, CurationDepth.IMEx, source);
        assignImexId(imexId);
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param title a {@link java.lang.String} object.
     * @param journal a {@link java.lang.String} object.
     * @param publicationDate a {@link java.util.Date} object.
     */
    public DefaultPublication(String title, String journal, Date publicationDate){
        this.title = title;
        this.journal = journal;
        this.publicationDate = publicationDate;
        this.curationDepth = CurationDepth.undefined;
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param title a {@link java.lang.String} object.
     * @param journal a {@link java.lang.String} object.
     * @param publicationDate a {@link java.util.Date} object.
     * @param curationDepth a {@link psidev.psi.mi.jami.model.CurationDepth} object.
     * @param source a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public DefaultPublication(String title, String journal, Date publicationDate, CurationDepth curationDepth, Source source){
        this(title, journal, publicationDate);
        if (curationDepth != null){
            this.curationDepth = curationDepth;
        }
        this.source = source;
    }

    /**
     * <p>Constructor for DefaultPublication.</p>
     *
     * @param title a {@link java.lang.String} object.
     * @param journal a {@link java.lang.String} object.
     * @param publicationDate a {@link java.util.Date} object.
     * @param imexId a {@link java.lang.String} object.
     * @param source a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public DefaultPublication(String title, String journal, Date publicationDate, String imexId, Source source){
        this(title, journal, publicationDate, CurationDepth.IMEx, source);
        assignImexId(imexId);
    }

    /**
     * <p>initialiseAuthors</p>
     */
    protected void initialiseAuthors(){
        this.authors = new ArrayList<String>();
    }

    /**
     * <p>initialiseXrefs</p>
     */
    protected void initialiseXrefs(){
        this.xrefs = new PublicationXrefList();
    }

    /**
     * <p>initialiseAnnotations</p>
     */
    protected void initialiseAnnotations(){
        this.annotations = new ArrayList<Annotation>();
    }

    /**
     * <p>initialiseExperiments</p>
     */
    protected void initialiseExperiments(){
        this.experiments = new ArrayList<Experiment>();
    }

    /**
     * <p>initialiseIdentifiers</p>
     */
    protected void initialiseIdentifiers(){
        this.identifiers = new PublicationIdentifierList();
    }

    /**
     * <p>initialiseAuthorsWith</p>
     *
     * @param authors a {@link java.util.List} object.
     */
    protected void initialiseAuthorsWith(List<String> authors){
        if (authors == null){
            this.authors = Collections.EMPTY_LIST;
        }
        else {
            this.authors = authors;
        }
    }

    /**
     * <p>initialiseXrefsWith</p>
     *
     * @param xrefs a {@link java.util.Collection} object.
     */
    protected void initialiseXrefsWith(Collection<Xref> xrefs){
        if (xrefs == null){
            this.xrefs = Collections.EMPTY_LIST;
        }
        else {
            this.xrefs = xrefs;
        }
    }

    /**
     * <p>initialiseAnnotationsWith</p>
     *
     * @param annotations a {@link java.util.Collection} object.
     */
    protected void initialiseAnnotationsWith(Collection<Annotation> annotations){
        if (annotations == null){
            this.annotations = Collections.EMPTY_LIST;
        }
        else {
            this.annotations = annotations;
        }
    }

    /**
     * <p>initialiseExperimentsWith</p>
     *
     * @param experiments a {@link java.util.Collection} object.
     */
    protected void initialiseExperimentsWith(Collection<Experiment> experiments){
        if (experiments == null){
            this.experiments = Collections.EMPTY_LIST;
        }
        else {
            this.experiments = experiments;
        }
    }

    /**
     * <p>initialiseIdentifiersWith</p>
     *
     * @param identifiers a {@link java.util.Collection} object.
     */
    protected void initialiseIdentifiersWith(Collection<Xref> identifiers){
        if (identifiers == null){
            this.identifiers = Collections.EMPTY_LIST;
        }
        else {
            this.identifiers = identifiers;
        }
    }

    /**
     * <p>Getter for the field <code>pubmedId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getPubmedId() {
        return this.pubmedId != null ? this.pubmedId.getId() : null;
    }

    /** {@inheritDoc} */
    public void setPubmedId(String pubmedId) {
        PublicationIdentifierList identifiers = (PublicationIdentifierList)getIdentifiers();

        // add new pubmed if not null
        if (pubmedId != null){
            CvTerm pubmedDatabase = CvTermUtils.createPubmedDatabase();
            CvTerm identityQualifier = CvTermUtils.createIdentityQualifier();
            // first remove old pubmed if not null
            if (this.pubmedId != null){
                identifiers.removeOnly(this.pubmedId);
            }
            this.pubmedId = new DefaultXref(pubmedDatabase, pubmedId, identityQualifier);
            identifiers.addOnly(this.pubmedId);
        }
        // remove all pubmed if the collection is not empty
        else if (!identifiers.isEmpty()) {
            XrefUtils.removeAllXrefsWithDatabase(identifiers, Xref.PUBMED_MI, Xref.PUBMED);
            this.pubmedId = null;
        }
    }

    /**
     * <p>Getter for the field <code>doi</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getDoi() {
        return this.doi != null ? this.doi.getId() : null;
    }

    /** {@inheritDoc} */
    public void setDoi(String doi) {
        PublicationIdentifierList identifiers = (PublicationIdentifierList)getIdentifiers();
        // add new doi if not null
        if (doi != null){
            CvTerm doiDatabase = CvTermUtils.createDoiDatabase();
            CvTerm identityQualifier = CvTermUtils.createIdentityQualifier();
            // first remove old doi if not null
            if (this.doi != null){
                identifiers.removeOnly(this.doi);
            }
            this.doi = new DefaultXref(doiDatabase, doi, identityQualifier);
            identifiers.addOnly(this.doi);
        }
        // remove all doi if the collection is not empty
        else if (!identifiers.isEmpty()) {
            XrefUtils.removeAllXrefsWithDatabase(identifiers, Xref.DOI_MI, Xref.DOI);
            this.doi = null;
        }
    }

    /**
     * <p>Getter for the field <code>identifiers</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<Xref> getIdentifiers() {
        if (identifiers == null){
            initialiseIdentifiers();
        }
        return this.identifiers;
    }

    /**
     * <p>Getter for the field <code>imexId</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getImexId() {
        return this.imexId != null ? this.imexId.getId() : null;
    }

    /** {@inheritDoc} */
    public void assignImexId(String identifier) {
        PublicationXrefList xrefs = (PublicationXrefList)getXrefs();
        // add new imex if not null
        if (identifier != null){
            CvTerm imexDatabase = CvTermUtils.createImexDatabase();
            CvTerm imexPrimaryQualifier = CvTermUtils.createImexPrimaryQualifier();
            // first remove old imex if not null
            if (this.imexId != null){
                xrefs.removeOnly(this.imexId);
            }
            this.imexId = new DefaultXref(imexDatabase, identifier, imexPrimaryQualifier);
            xrefs.addOnly(this.imexId);

            this.curationDepth = CurationDepth.IMEx;
        }
        else if (this.imexId != null){
            throw new IllegalArgumentException("The imex id has to be non null.");
        }
    }

    /**
     * <p>Getter for the field <code>title</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getTitle() {
        return this.title;
    }

    /** {@inheritDoc} */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * <p>Getter for the field <code>journal</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getJournal() {
        return this.journal;
    }

    /** {@inheritDoc} */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     * <p>Getter for the field <code>publicationDate</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getPublicationDate() {
        return this.publicationDate;
    }

    /** {@inheritDoc} */
    public void setPublicationDate(Date date) {
        this.publicationDate = date;
    }

    /**
     * <p>Getter for the field <code>authors</code>.</p>
     *
     * @return a {@link java.util.List} object.
     */
    public List<String> getAuthors() {
        if (authors == null){
           initialiseAuthors();
        }
        return this.authors;
    }

    /**
     * <p>Getter for the field <code>xrefs</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<Xref> getXrefs() {
        if (xrefs == null){
           initialiseXrefs();
        }
        return this.xrefs;
    }

    /**
     * <p>Getter for the field <code>annotations</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<Annotation> getAnnotations() {
        if (annotations == null){
            initialiseAnnotations();
        }
        return this.annotations;
    }

    /**
     * <p>Getter for the field <code>experiments</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<Experiment> getExperiments() {
        if (experiments == null){
            initialiseExperiments();
        }
        return this.experiments;
    }

    /**
     * <p>Getter for the field <code>curationDepth</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.model.CurationDepth} object.
     */
    public CurationDepth getCurationDepth() {
        return this.curationDepth;
    }

    /** {@inheritDoc} */
    public void setCurationDepth(CurationDepth curationDepth) {

        if (imexId != null && curationDepth != null && !curationDepth.equals(CurationDepth.IMEx)){
            throw new IllegalArgumentException("The curationDepth " + curationDepth.toString() + " is not allowed because the publication has an IMEx id so it has IMEx curation depth.");
        }
        else if (imexId != null && curationDepth == null){
            throw new IllegalArgumentException("The curationDepth cannot be null/not specified because the publication has an IMEx id so it has IMEx curation depth.");
        }

        if (curationDepth == null) {
            this.curationDepth = CurationDepth.undefined;
        }
        else {
            this.curationDepth = curationDepth;
        }
    }

    /**
     * <p>Getter for the field <code>releasedDate</code>.</p>
     *
     * @return a {@link java.util.Date} object.
     */
    public Date getReleasedDate() {
        return this.releasedDate;
    }

    /** {@inheritDoc} */
    public void setReleasedDate(Date released) {
        this.releasedDate = released;
    }

    /**
     * <p>Getter for the field <code>source</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.model.Source} object.
     */
    public Source getSource() {
        return this.source;
    }

    /** {@inheritDoc} */
    public void setSource(Source source) {
        this.source = source;
    }

    /** {@inheritDoc} */
    public boolean addExperiment(Experiment exp) {
        if (exp == null){
            return false;
        }
        else {
            if (getExperiments().add(exp)){
                exp.setPublication(this);
                return true;
            }
            return false;
        }
    }

    /** {@inheritDoc} */
    public boolean removeExperiment(Experiment exp) {
        if (exp == null){
            return false;
        }
        else {
            if (getExperiments().remove(exp)){
                exp.setPublication(null);
                return true;
            }
            return false;
        }
    }

    /** {@inheritDoc} */
    public boolean addAllExperiments(Collection<? extends Experiment> exps) {
        if (exps == null){
            return false;
        }
        else {
            boolean added = false;

            for (Experiment exp : exps){
                if (addExperiment(exp)){
                    added = true;
                }
            }
            return added;
        }
    }

    /** {@inheritDoc} */
    public boolean removeAllExperiments(Collection<? extends Experiment> exps) {
        if (exps == null){
            return false;
        }
        else {
            boolean removed = false;

            for (Experiment exp : exps){
                if (removeExperiment(exp)){
                    removed = true;
                }
            }
            return removed;
        }
    }

    /**
     * <p>processAddedIdentifierEvent</p>
     *
     * @param added a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    protected void processAddedIdentifierEvent(Xref added) {

        // the added identifier is pubmed and it is not the current pubmed identifier
        if (pubmedId != added && XrefUtils.isXrefFromDatabase(added, Xref.PUBMED_MI, Xref.PUBMED)){
            // the current pubmed identifier is not identity, we may want to set pubmed Identifier
            if (!XrefUtils.doesXrefHaveQualifier(pubmedId, Xref.IDENTITY_MI, Xref.IDENTITY) && !XrefUtils.doesXrefHaveQualifier(pubmedId, Xref.PRIMARY_MI, Xref.PRIMARY)){
                // the pubmed identifier is not set, we can set the pubmed
                if (pubmedId == null){
                    pubmedId = added;
                }
                else if (XrefUtils.doesXrefHaveQualifier(added, Xref.IDENTITY_MI, Xref.IDENTITY) || XrefUtils.doesXrefHaveQualifier(added, Xref.PRIMARY_MI, Xref.PRIMARY)){
                    pubmedId = added;
                }
                // the added xref is secondary object and the current pubmed is not a secondary object, we reset pubmed identifier
                else if (!XrefUtils.doesXrefHaveQualifier(pubmedId, Xref.SECONDARY_MI, Xref.SECONDARY)
                        && XrefUtils.doesXrefHaveQualifier(added, Xref.SECONDARY_MI, Xref.SECONDARY)){
                    pubmedId = added;
                }
            }
        }
        // the added identifier is doi and it is not the current doi identifier
        else if (doi != added && XrefUtils.isXrefFromDatabase(added, Xref.DOI_MI, Xref.DOI)){
            // the current doi identifier is not identity, we may want to set doi
            if (!XrefUtils.doesXrefHaveQualifier(doi, Xref.IDENTITY_MI, Xref.IDENTITY) && !XrefUtils.doesXrefHaveQualifier(doi, Xref.PRIMARY_MI, Xref.PRIMARY)){
                // the doi is not set, we can set the doi
                if (doi == null){
                    doi = added;
                }
                else if (XrefUtils.doesXrefHaveQualifier(added, Xref.IDENTITY_MI, Xref.IDENTITY) || XrefUtils.doesXrefHaveQualifier(added, Xref.PRIMARY_MI, Xref.PRIMARY)){
                    doi = added;
                }
                // the added xref is secondary object and the current doi is not a secondary object, we reset doi
                else if (!XrefUtils.doesXrefHaveQualifier(doi, Xref.SECONDARY_MI, Xref.SECONDARY)
                        && XrefUtils.doesXrefHaveQualifier(added, Xref.SECONDARY_MI, Xref.SECONDARY)){
                    doi = added;
                }
            }
        }
    }

    /**
     * <p>processRemovedIdentifierEvent</p>
     *
     * @param removed a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    protected void processRemovedIdentifierEvent(Xref removed) {
        // the removed identifier is pubmed
        if (pubmedId != null && pubmedId.equals(removed)){
            pubmedId = XrefUtils.collectFirstIdentifierWithDatabase(getIdentifiers(), Xref.PUBMED_MI, Xref.PUBMED);
        }
        // the removed identifier is doi
        else if (doi != null && doi.equals(removed)){
            doi = XrefUtils.collectFirstIdentifierWithDatabase(getIdentifiers(), Xref.DOI_MI, Xref.DOI);
        }
    }

    /**
     * <p>clearPropertiesLinkedToIdentifiers</p>
     */
    protected void clearPropertiesLinkedToIdentifiers() {
        pubmedId = null;
        doi = null;
    }

    /**
     * <p>processAddedXrefEvent</p>
     *
     * @param added a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    protected void processAddedXrefEvent(Xref added) {

        // the added identifier is imex and the current imex is not set
        if (imexId == null && XrefUtils.isXrefFromDatabase(added, Xref.IMEX_MI, Xref.IMEX)){
            // the added xref is imex-primary
            if (XrefUtils.doesXrefHaveQualifier(added, Xref.IMEX_PRIMARY_MI, Xref.IMEX_PRIMARY)){
                imexId = added;
            }
        }
    }

    /**
     * <p>processRemovedXrefEvent</p>
     *
     * @param removed a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    protected void processRemovedXrefEvent(Xref removed) {
        // the removed identifier is pubmed
        if (imexId != null && imexId.equals(removed)){
            Collection<Xref> existingImex = XrefUtils.collectAllXrefsHavingDatabaseAndQualifier(getXrefs(), Xref.IMEX_MI, Xref.IMEX, Xref.IMEX_PRIMARY_MI, Xref.IMEX_PRIMARY);
            if (!existingImex.isEmpty()){
                imexId = existingImex.iterator().next();
            }
        }
    }

    /**
     * <p>clearPropertiesLinkedToXrefs</p>
     */
    protected void clearPropertiesLinkedToXrefs() {
        imexId = null;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Publication: "+
                (getImexId() != null ? getImexId() :
                        (getPubmedId() != null ? getPubmedId() :
                                (getDoi() != null ? getDoi() :
                                        (getTitle() != null ? getTitle() : "-"))));
    }

    private class PublicationIdentifierList extends AbstractListHavingProperties<Xref> {
        public PublicationIdentifierList(){
            super();
        }

        @Override
        protected void processAddedObjectEvent(Xref added) {

            processAddedIdentifierEvent(added);
        }

        @Override
        protected void processRemovedObjectEvent(Xref removed) {
            processRemovedIdentifierEvent(removed);
        }

        @Override
        protected void clearProperties() {
            clearPropertiesLinkedToIdentifiers();
        }
    }

    private class PublicationXrefList extends AbstractListHavingProperties<Xref> {
        public PublicationXrefList(){
            super();
        }

        @Override
        protected void processAddedObjectEvent(Xref added) {

            processAddedXrefEvent(added);
        }

        @Override
        protected void processRemovedObjectEvent(Xref removed) {
            processRemovedXrefEvent(removed);
        }

        @Override
        protected void clearProperties() {
            clearPropertiesLinkedToXrefs();
        }
    }
}
