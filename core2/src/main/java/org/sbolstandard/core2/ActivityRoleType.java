package org.sbolstandard.core2;

import java.net.URI;

/**
 * Represents the roles used in Associations and Usages in Activities for Design-Build-Test-Learn workflow.
 *
 * @author Chris Myers
 * @version 2.1
 */

public enum ActivityRoleType {
	/**
	 * Design describes the process by which a conceptual representation of an engineer’s imagined 
	 * and intended design for a biological system is derived, possibly from a predictive model or by 
	 * modifying a pre-existing design. In the context of an Association, the term design indicates that 
	 * the agent performed the parent Activity to generate a design. In the context of a Usage, the term 
	 * indicates that the referenced entity was generated by some previous design Activity and was used 
	 * by the present Activity as a design for a new object.
	 */
	DESIGN("design"),
	/**
	 * Build describes the process by which a biological construct, sample, or clone is implemented in 
	 * the laboratory. In the context of an Association, the term build indicates that the agent 
	 * performed the parent Activity to implement a design. More generally, the term may represent any 
	 * kind of experimental manipulation of a biological sample, including propagating, passaging, or 
	 * evolving cell lines. In the context of a Usage, the term indicates that the referenced entity was 
	 * generated by some previous build Activity and was used by the present Activity as a built object.
	 */
	BUILD("build"), 
	/**
	 * Test describes the process of performing experimental measurements to characterize a synthetic 
	 * biological construct. In the context of an Association, the Agent performed the parent Activity 
	 * to perform experimental measurements resulting in raw data represented by Attachments. In the 
	 * context of a Usage, the term indicates that the referenced entity was generated by some previous 
	 * test Activity and is used as test data in the present Activity.
	 */
	TEST("test"),
	/**
	 * Learn describes the process of analyzing experimental measurements to produce a new entity that 
	 * represents biological knowledge. In the context of an Association, the Agent processed raw 
	 * experimental data to produce an analysis. This process generates a new entity that represents 
	 * biological knowledge, including tables or graphs contained by Attachment, a Model produced by a
	 * fitting process, a consensus Sequence derived from sequencing results, etc. In the context of a
	 * Usage, the term indicates that the referenced entity was generated by some previous learn Activity 
	 * and is used in the present Activity as a source of scientifically verified knowledge.
	 */
	LEARN("learn");
	private final String activityRoleType;

	ActivityRoleType(String activityRoleType) {
		this.activityRoleType = activityRoleType;
	}

	@Override
	public String toString() {
		return activityRoleType;
	}

	/**
	 * Convert the specified URI to its corresponding ActivityRoleType instance. 
	 * @return the corresponding ActivityRoleType instance
	 * @throws SBOLValidationException 
	 */
	static ActivityRoleType convertToRefinementType(URI activityRole) throws SBOLValidationException {
		if (activityRole != null) {
			if (activityRole.equals(design)) {
				return ActivityRoleType.DESIGN;
			} 
			else if (activityRole.equals(build)) {
				return ActivityRoleType.BUILD;
			}
			else if (activityRole.equals(test)) {
				return ActivityRoleType.TEST;
			}
			else if (activityRole.equals(learn)) {
				return ActivityRoleType.LEARN;
			}
			else {
				throw new SBOLValidationException("sbol-XXXXX");
			}
		} else {
			throw new SBOLValidationException("sbol-XXXXX");
		}
	}

	/**
	 * Returns the activityRole type in URI.
	 * @return activityRole type in URI
	 */
	static URI convertToURI(ActivityRoleType activityRole) {
		if (activityRole != null) {
			if (activityRole.equals(ActivityRoleType.DESIGN)) {
				return design;
			}
			else if (activityRole.equals(ActivityRoleType.BUILD)) {
				return build;
			}
			else if (activityRole.equals(ActivityRoleType.TEST)) {
				return test;
			}
			else if (activityRole.equals(ActivityRoleType.LEARN)) {
				return learn;
			}				
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}
	
	private static final URI design = URI.create(Sbol2Terms.sbol2.getNamespaceURI() + "design");
	private static final URI build = URI.create(Sbol2Terms.sbol2.getNamespaceURI() + "build");
	private static final URI test = URI.create(Sbol2Terms.sbol2.getNamespaceURI() + "test");
	private static final URI learn = URI.create(Sbol2Terms.sbol2.getNamespaceURI() + "learn");

}