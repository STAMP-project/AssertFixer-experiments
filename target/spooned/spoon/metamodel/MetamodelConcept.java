/**
 * Copyright (C) 2006-2017 INRIA and contributors
 * Spoon - http://spoon.gforge.inria.fr/
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */
package spoon.metamodel;


/**
 * Represents a concept of the Spoon metamodel (eg {@link CtClass}).
 */
public class MetamodelConcept {
    /**
     * Kind of this concept
     */
    private spoon.metamodel.ConceptKind kind;

    /**
     * Name of the concept
     */
    private final java.lang.String name;

    /**
     * Map of {@link CtRole} to {@link MetamodelProperty}s with values ordered same like CtScanner scans these properties when visiting this {@link MetamodelConcept}
     */
    private final java.util.Map<spoon.reflect.path.CtRole, spoon.metamodel.MetamodelProperty> role2Property = new java.util.LinkedHashMap<>();

    /**
     * List of super concepts of this concept
     */
    private final java.util.List<spoon.metamodel.MetamodelConcept> superConcepts = new java.util.ArrayList<>();

    /**
     * List of sub concepts of this concept
     */
    private final java.util.List<spoon.metamodel.MetamodelConcept> subConcepts = new java.util.ArrayList<>();

    /**
     * The {@link CtClass} linked to this {@link MetamodelConcept}. Is null in case of class without interface
     */
    private spoon.reflect.declaration.CtClass<?> modelClass;

    /**
     * The {@link CtInterface} linked to this {@link MetamodelConcept}. Is null in case of interface without class
     */
    private spoon.reflect.declaration.CtInterface<?> modelInterface;

    /**
     * {@link ClassTypingContext} of this concept used to adapt methods from super type implementations to this {@link MetamodelConcept}
     */
    private spoon.support.visitor.ClassTypingContext typeContext;

    /**
     * own methods of {@link MetamodelConcept}, which does not belong to any role
     */
    final java.util.List<spoon.reflect.declaration.CtMethod<?>> otherMethods = new java.util.ArrayList<>();

    MetamodelConcept(java.lang.String name) {
        super();
        this.name = name;
    }

    /**
     *
     *
     * @return interface name of {@link MetamodelConcept}. For example CtClass, CtForEach, ...
     * It is never followed by xxxImpl
     */
    public java.lang.String getName() {
        return name;
    }

    spoon.metamodel.MetamodelProperty getOrCreateMMField(spoon.reflect.path.CtRole role) {
        return spoon.metamodel.Metamodel.getOrCreate(role2Property, role, () -> new spoon.metamodel.MetamodelProperty(role.getCamelCaseName(), role, this));
    }

    /**
     *
     *
     * @return kind of this {@link MetamodelConcept}.
     */
    public spoon.metamodel.ConceptKind getKind() {
        if ((kind) == null) {
            if (((modelClass) == null) && ((modelInterface) == null)) {
                return null;
            }else {
                // we first consider interface
                if ((modelClass) == null) {
                    this.kind = spoon.metamodel.ConceptKind.ABSTRACT;
                }else {
                    if (modelClass.hasModifier(spoon.reflect.declaration.ModifierKind.ABSTRACT)) {
                        this.kind = spoon.metamodel.ConceptKind.ABSTRACT;
                    }else {
                        this.kind = spoon.metamodel.ConceptKind.LEAF;
                    }
                }
            }
        }
        return kind;
    }

    /**
     *
     *
     * @return map of {@link MetamodelProperty}s by their {@link CtRole}
     */
    public java.util.Map<spoon.reflect.path.CtRole, spoon.metamodel.MetamodelProperty> getRoleToProperty() {
        return java.util.Collections.unmodifiableMap(role2Property);
    }

    /**
     *
     *
     * @return super types
     */
    public java.util.List<spoon.metamodel.MetamodelConcept> getSuperConcepts() {
        return superConcepts;
    }

    void addSuperConcept(spoon.metamodel.MetamodelConcept superType) {
        if (superType == (this)) {
            throw new spoon.SpoonException("Cannot add supertype to itself");
        }
        if (spoon.metamodel.Metamodel.addUniqueObject(superConcepts, superType)) {
            superType.subConcepts.add(this);
            superType.role2Property.forEach(( role, superMMField) -> {
                spoon.metamodel.MetamodelProperty mmField = getOrCreateMMField(role);
                mmField.addSuperField(superMMField);
            });
        }
    }

    /**
     *
     *
     * @return {@link CtClass} which represents this {@link MetamodelConcept}
     */
    public spoon.reflect.declaration.CtClass<?> getImplementationClass() {
        return modelClass;
    }

    void setModelClass(spoon.reflect.declaration.CtClass<?> modelClass) {
        this.modelClass = modelClass;
    }

    /**
     *
     *
     * @return {@link CtInterface} which represents this {@link MetamodelConcept}
     */
    public spoon.reflect.declaration.CtInterface<?> getMetamodelInterface() {
        return modelInterface;
    }

    void setModelInterface(spoon.reflect.declaration.CtInterface<?> modelInterface) {
        this.modelInterface = modelInterface;
    }

    /**
     *
     *
     * @return {@link ClassTypingContext}, which can be used to adapt super type methods to this {@link MetamodelConcept}
     * 
     * (package protected, not in the public API)
     */
    spoon.support.visitor.ClassTypingContext getTypeContext() {
        if ((typeContext) == null) {
            typeContext = new spoon.support.visitor.ClassTypingContext(((modelClass) != null ? modelClass : modelInterface));
        }
        return typeContext;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return getName();
    }
}

