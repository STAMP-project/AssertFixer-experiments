package psidev.psi.mi.jami.xml.cache;

import psidev.psi.mi.jami.model.*;

import java.util.Set;

/**
 * Index that can assign/retrieve an id for a given MI object in a compact XML environment
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>12/11/13</pre>
 */
public interface PsiXmlObjectCache {

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param av a {@link java.lang.String} object.
     * @return the id assigned to this object
     */
    public int extractIdForAvailability(String av);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.Experiment} object.
     * @return the id assigned to this object
     */
    public int extractIdForExperiment(Experiment o);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @return the id assigned to this object
     */
    public int extractIdForInteractor(Interactor o);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.Interaction} object.
     * @return the id assigned to this object
     */
    public int extractIdForInteraction(Interaction o);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.Entity} object.
     * @return the id assigned to this object
     */
    public int extractIdForParticipant(Entity o);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.VariableParameterValue} object.
     * @return the id assigned to this object
     */
    public int extractIdForVariableParameterValue(VariableParameterValue o);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.Feature} object.
     * @return the id assigned to this object
     */
    public int extractIdForFeature(Feature o);

    /**
     * This method will extract the id for this object if it is already registered,
     * assign an id and register the object if not already registered
     *
     * @param o a {@link psidev.psi.mi.jami.model.Complex} object.
     * @return the id assigned to this object
     */
    public int extractIdForComplex(Complex o);

    /**
     * Clear registered complexes and object ids
     */
    public void clear();

    /**
     * Close cache
     */
    public void close();

    /**
     * True if it contains this object
     *
     * @param o a {@link java.lang.Object} object.
     * @return a boolean.
     */
    public boolean contains(Object o);

    /**
     * This method will register a complex that is used as an interactor
     *
     * @param c a {@link psidev.psi.mi.jami.model.ModelledInteraction} object.
     */
    public void registerSubComplex(ModelledInteraction c);

    /**
     * This method will return all registered complexes and clear them from the index
     *
     * @return a {@link java.util.Set} object.
     */
    public Set<ModelledInteraction> clearRegisteredSubComplexes();

    /**
     * <p>hasRegisteredSubComplexes.</p>
     *
     * @return true if the index has registered som sub complexes, fasle otherwise
     */
    public boolean hasRegisteredSubComplexes();

    /**
     * <p>removeObject.</p>
     *
     * @param o a {@link java.lang.Object} object.
     */
    public void removeObject(Object o);

    /**
     * <p>getLastGeneratedId.</p>
     *
     * @return the last generated id
     */
    public int getLastGeneratedId();

    /**
     * Reset the last generated id to a specific value
     *
     * @param id a int.
     */
    public void resetLastGeneratedIdTo(int id);
}
