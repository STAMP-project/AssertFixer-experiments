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
 * Represents a property of the Spoon metamodel.
 * A property:
 *   - is an abstraction of a concrete field in an implementation class
 *   - the {@link MetamodelConcept} is the owner of this role, it models the implementation class that contains the field.
 *   - encapsulates a pair ({@link CtRole}, {@link MetamodelConcept}).
 *   - captures both the type of the field (eg list) and the type of items (eg String).
 */
public class MetamodelProperty {
    /**
     * Name of the field
     */
    private final java.lang.String name;

    /**
     * {@link CtRole} of the field
     */
    private final spoon.reflect.path.CtRole role;

    /**
     * The list of {@link MetamodelConcept}s which contains this field
     */
    private final spoon.metamodel.MetamodelConcept ownerConcept;

    /**
     * Type of value container [single, list, set, map]
     */
    private spoon.reflect.meta.ContainerKind valueContainerType;

    /**
     * The type of value of this property - can be Set, List, Map or any non collection type
     */
    private spoon.reflect.reference.CtTypeReference<?> valueType;

    /**
     * The item type of value of this property - can be non collection type
     */
    private spoon.reflect.reference.CtTypeReference<?> itemValueType;

    private java.lang.Boolean derived;

    private java.lang.Boolean unsettable;

    private java.util.Map<spoon.metamodel.MMMethodKind, java.util.List<spoon.metamodel.MMMethod>> methodsByKind = new java.util.HashMap<>();

    /**
     * methods of this field defined directly on ownerType.
     * There is PropertyGetter or PropertySetter annotation with `role` of this {@link MetamodelProperty}
     */
    private final java.util.List<spoon.metamodel.MMMethod> roleMethods = new java.util.ArrayList<>();

    /**
     * methods of this field grouped by signature defined directly on ownerType.
     * There is PropertyGetter or PropertySetter annotation with `role` of this {@link MetamodelProperty}
     * note: There can be up to 2 methods in this list. 1) declaration from interface, 2) implementation from class
     */
    private final java.util.Map<java.lang.String, spoon.metamodel.MMMethod> roleMethodsBySignature = new java.util.HashMap<>();

    /**
     * List of {@link MetamodelProperty} with same `role`, from super type of `ownerConcept` {@link MetamodelConcept}
     */
    private final java.util.List<spoon.metamodel.MetamodelProperty> superProperties = new java.util.ArrayList<>();

    private java.util.List<spoon.metamodel.MMMethodKind> ambiguousMethodKinds = new java.util.ArrayList<>();

    MetamodelProperty(java.lang.String name, spoon.reflect.path.CtRole role, spoon.metamodel.MetamodelConcept ownerConcept) {
        super();
        this.name = name;
        this.role = role;
        this.ownerConcept = ownerConcept;
    }

    void addMethod(spoon.reflect.declaration.CtMethod<?> method) {
        spoon.metamodel.MMMethod mmMethod = addMethod(method, true);
    }

    /**
     *
     *
     * @param method
     * 		
     * @param createIfNotExist
     * 		
     * @return existing {@link MMMethod}, which overrides `method` or creates and registers new one if `createIfNotExist`==true
     */
    spoon.metamodel.MMMethod addMethod(spoon.reflect.declaration.CtMethod<?> method, boolean createIfNotExist) {
        for (spoon.metamodel.MMMethod mmMethod : roleMethods) {
            if (mmMethod.overrides(method)) {
                // linking this ctMethod to this mmMethod
                mmMethod.addRelatedMethod(method);
                return mmMethod;
            }
        }
        if (createIfNotExist) {
            spoon.metamodel.MMMethod mmMethod = new spoon.metamodel.MMMethod(this, method);
            roleMethods.add(mmMethod);
            spoon.metamodel.Metamodel.getOrCreate(methodsByKind, mmMethod.getKind(), () -> new java.util.ArrayList<>()).add(mmMethod);
            spoon.metamodel.MMMethod conflict = roleMethodsBySignature.put(mmMethod.getSignature(), mmMethod);
            if (conflict != null) {
                throw new spoon.SpoonException(((((("Conflict on " + (getOwner().getName())) + ".") + (name)) + " method signature: ") + (mmMethod.getSignature())));
            }
            return mmMethod;
        }
        return null;
    }

    void addSuperField(spoon.metamodel.MetamodelProperty superMMField) {
        if (spoon.metamodel.Metamodel.addUniqueObject(superProperties, superMMField)) {
            // we copy all methods of the super property
            for (spoon.metamodel.MMMethod superMethod : superMMField.getRoleMethods()) {
                spoon.reflect.declaration.CtMethod<?> method;
                // we want the super method that is compatible with this property
                method = superMethod.getCompatibleMethod(getOwner());
                // we add this CtMethod to this property
                addMethod(method, true);
            }
        }
    }

    public java.lang.String getName() {
        return name;
    }

    public spoon.reflect.path.CtRole getRole() {
        return role;
    }

    /**
     * returns the concept that holds this property
     */
    public spoon.metamodel.MetamodelConcept getOwner() {
        return ownerConcept;
    }

    /**
     * returns the kind of property (list, value, etc)
     */
    public spoon.reflect.meta.ContainerKind getContainerKind() {
        return valueContainerType;
    }

    spoon.reflect.reference.CtTypeReference<?> detectValueType() {
        spoon.metamodel.MMMethod mmGetMethod = getMethod(spoon.metamodel.MMMethodKind.GET);
        if (mmGetMethod == null) {
            throw new spoon.SpoonException(((("No getter exists for " + (getOwner().getName())) + ".") + (getName())));
        }
        spoon.metamodel.MMMethod mmSetMethod = getMethod(spoon.metamodel.MMMethodKind.SET);
        if (mmSetMethod == null) {
            return mmGetMethod.getReturnType();
        }
        spoon.reflect.reference.CtTypeReference<?> getterValueType = mmGetMethod.getReturnType();
        spoon.reflect.reference.CtTypeReference<?> setterValueType = mmSetMethod.getValueType();
        if (getterValueType.equals(setterValueType)) {
            return mmGetMethod.getReturnType();
        }
        if ((spoon.metamodel.MetamodelProperty.containerKindOf(getterValueType.getActualClass())) != (spoon.reflect.meta.ContainerKind.SINGLE)) {
            getterValueType = spoon.metamodel.MetamodelProperty.getTypeofItems(getterValueType);
            setterValueType = spoon.metamodel.MetamodelProperty.getTypeofItems(setterValueType);
        }
        if (getterValueType.equals(setterValueType)) {
            return mmGetMethod.getReturnType();
        }
        if (getterValueType.isSubtypeOf(setterValueType)) {
            /* Getter and setter have different type
            For example:
            CtBlock CtCatch#getBody
            and
            CtCatch#setBody(CtStatement)
            In current metamodel we take type of setter to keep it simple
             */
            return mmSetMethod.getValueType();
        }
        throw new spoon.SpoonException(((("Incompatible getter and setter for " + (getOwner().getName())) + ".") + (getName())));
    }

    void setValueType(spoon.reflect.reference.CtTypeReference<?> valueType) {
        spoon.reflect.factory.Factory f = valueType.getFactory();
        if (valueType instanceof spoon.reflect.reference.CtTypeParameterReference) {
            valueType = ((spoon.reflect.reference.CtTypeParameterReference) (valueType)).getBoundingType();
            if (valueType == null) {
                valueType = f.Type().OBJECT;
            }
        }
        if (valueType.isImplicit()) {
            valueType = valueType.clone();
            // never return type  with implicit==true, such type is then not pretty printed
            valueType.setImplicit(false);
        }
        this.valueType = valueType;
        this.valueContainerType = spoon.metamodel.MetamodelProperty.containerKindOf(valueType.getActualClass());
        if ((valueContainerType) != (spoon.reflect.meta.ContainerKind.SINGLE)) {
            itemValueType = spoon.metamodel.MetamodelProperty.getTypeofItems(valueType);
        }else {
            itemValueType = valueType;
        }
    }

    /**
     * Return the type of the field
     * for List&lt;String&gt; field the ValueType is List
     * for String field the ValueType is String
     */
    public spoon.reflect.reference.CtTypeReference<?> getTypeOfField() {
        if ((valueType) == null) {
            throw new spoon.SpoonException("Model is not initialized yet");
        }
        return valueType;
    }

    /**
     * Returns the type of the property
     * for List&lt;String&gt; field the ValueType is String
     * for String field the ValueType is String (when getContainerKind == {@link ContainerKind#SINGLE}, {@link #getTypeofItems()} == {@link #getTypeOfField()}.
     */
    public spoon.reflect.reference.CtTypeReference<?> getTypeofItems() {
        if ((itemValueType) == null) {
            getTypeOfField();
        }
        return itemValueType;
    }

    public spoon.metamodel.MMMethod getMethod(spoon.metamodel.MMMethodKind kind) {
        java.util.List<spoon.metamodel.MMMethod> ms = getMethods(kind);
        return (ms.size()) > 0 ? ms.get(0) : null;
    }

    public java.util.List<spoon.metamodel.MMMethod> getMethods(spoon.metamodel.MMMethodKind kind) {
        java.util.List<spoon.metamodel.MMMethod> ms = methodsByKind.get(kind);
        return ms == null ? java.util.Collections.emptyList() : java.util.Collections.unmodifiableList(ms);
    }

    void sortByBestMatch() {
        // resolve conflicts using value type. Move the most matching method to 0 index
        // in order GET, SET and others
        for (spoon.metamodel.MMMethodKind mk : spoon.metamodel.MMMethodKind.values()) {
            sortByBestMatch(mk);
        }
    }

    void sortByBestMatch(spoon.metamodel.MMMethodKind key) {
        java.util.List<spoon.metamodel.MMMethod> methods = methodsByKind.get(key);
        if ((methods != null) && ((methods.size()) > 1)) {
            int idx = getIdxOfBestMatch(methods, key);
            if (idx >= 0) {
                if (idx > 0) {
                    // move the matching to the beginning
                    methods.add(0, methods.remove(idx));
                }
            }else {
                // add all methods as ambiguous
                ambiguousMethodKinds.add(key);
            }
        }
    }

    /**
     *
     *
     * @param methods
     * 		
     * @param key
     * 		
     * @return index of the method which best matches the `key` accessor of this field
     * -1 if it cannot be resolved
     */
    private int getIdxOfBestMatch(java.util.List<spoon.metamodel.MMMethod> methods, spoon.metamodel.MMMethodKind key) {
        spoon.metamodel.MMMethod mmMethod = methods.get(0);
        if ((mmMethod.getActualCtMethod().getParameters().size()) == 0) {
            return getIdxOfBestMatchByReturnType(methods, key);
        }else {
            spoon.metamodel.MMMethod mmGetMethod = getMethod(spoon.metamodel.MMMethodKind.GET);
            if (mmGetMethod == null) {
                // we have no getter so we do not know the expected value type. Setters are ambiguous
                return -1;
            }
            return getIdxOfBestMatchByInputParameter(methods, key, mmGetMethod.getReturnType());
        }
    }

    private int getIdxOfBestMatchByReturnType(java.util.List<spoon.metamodel.MMMethod> methods, spoon.metamodel.MMMethodKind key) {
        if ((methods.size()) > 2) {
            throw new spoon.SpoonException(("Resolving of more then 2 conflicting getters is not supported. There are: " + (methods.toString())));
        }
        // There is no input parameter. We are resolving getter field.
        // choose the getter whose return value is a collection
        // of second one
        spoon.reflect.reference.CtTypeReference<?> returnType1 = methods.get(0).getActualCtMethod().getType();
        spoon.reflect.reference.CtTypeReference<?> returnType2 = methods.get(1).getActualCtMethod().getType();
        spoon.reflect.factory.Factory f = returnType1.getFactory();
        boolean is1Iterable = returnType1.isSubtypeOf(f.Type().ITERABLE);
        boolean is2Iterable = returnType2.isSubtypeOf(f.Type().ITERABLE);
        if (is1Iterable != is2Iterable) {
            // they are not some. Only one of them is iterable
            if (is1Iterable) {
                if (isIterableOf(returnType1, returnType2)) {
                    // use 1st method, which is multivalue
                    // representation of 2nd method
                    return 0;
                }
            }else {
                if (isIterableOf(returnType2, returnType1)) {
                    // use 2nd method, which is multivalue
                    // representation of 1st method
                    return 1;
                }
            }
        }
        // else report ambiguity
        return -1;
    }

    /**
     *
     *
     * @return true if item type of `iterableType` is super type of `itemType`
     */
    private boolean isIterableOf(spoon.reflect.reference.CtTypeReference<?> iterableType, spoon.reflect.reference.CtTypeReference<?> itemType) {
        spoon.reflect.reference.CtTypeReference<?> iterableItemType = spoon.metamodel.MetamodelProperty.getTypeofItems(iterableType);
        if (iterableItemType != null) {
            return itemType.isSubtypeOf(iterableItemType);
        }
        return false;
    }

    private int getIdxOfBestMatchByInputParameter(java.util.List<spoon.metamodel.MMMethod> methods, spoon.metamodel.MMMethodKind key, spoon.reflect.reference.CtTypeReference<?> expectedValueType) {
        int idx = -1;
        spoon.metamodel.MetamodelProperty.MatchLevel maxMatchLevel = null;
        spoon.reflect.reference.CtTypeReference<?> newValueType = null;
        if (key.isMulti()) {
            expectedValueType = spoon.metamodel.MetamodelProperty.getTypeofItems(expectedValueType);
        }
        for (int i = 0; i < (methods.size()); i++) {
            spoon.metamodel.MMMethod mMethod = methods.get(i);
            spoon.metamodel.MetamodelProperty.MatchLevel matchLevel = getMatchLevel(expectedValueType, mMethod.getValueType());
            if (matchLevel != null) {
                // it is matching
                if (idx == (-1)) {
                    idx = i;
                    maxMatchLevel = matchLevel;
                    newValueType = mMethod.getValueType();
                }else {
                    // both methods have matching value type. Use the better match
                    // there is conflict
                    if ((maxMatchLevel.ordinal()) < (matchLevel.ordinal())) {
                        idx = i;
                        maxMatchLevel = matchLevel;
                        newValueType = mMethod.getValueType();
                    }// there is conflict
                    // else OK, we already have better match
                    else
                        if (maxMatchLevel == matchLevel) {
                            return -1;
                        }
                    // else OK, we already have better match

                }
            }
        }
        return idx;
    }

    private static spoon.reflect.reference.CtTypeReference<?> getTypeofItems(spoon.reflect.reference.CtTypeReference<?> valueType) {
        spoon.reflect.meta.ContainerKind valueContainerType = spoon.metamodel.MetamodelProperty.containerKindOf(valueType.getActualClass());
        if (valueContainerType == (spoon.reflect.meta.ContainerKind.SINGLE)) {
            return null;
        }
        spoon.reflect.reference.CtTypeReference<?> itemValueType;
        if (valueContainerType == (spoon.reflect.meta.ContainerKind.MAP)) {
            if ((java.lang.String.class.getName().equals(valueType.getActualTypeArguments().get(0).getQualifiedName())) == false) {
                throw new spoon.SpoonException(("Unexpected container of type: " + (valueType.toString())));
            }
            itemValueType = valueType.getActualTypeArguments().get(1);
        }else {
            // List or Set
            itemValueType = valueType.getActualTypeArguments().get(0);
        }
        if (itemValueType instanceof spoon.reflect.reference.CtTypeParameterReference) {
            itemValueType = ((spoon.reflect.reference.CtTypeParameterReference) (itemValueType)).getBoundingType();
            if (itemValueType == null) {
                itemValueType = valueType.getFactory().Type().OBJECT;
            }
        }
        return itemValueType;
    }

    private enum MatchLevel {
        SUBTYPE, ERASED_EQUALS, EQUALS;}

    /**
     * Checks whether expectedType and realType are matching.
     *
     * @param expectedType
     * 		
     * @param realType
     * 		
     * @return new expectedType or null if it is not matching
     */
    private spoon.metamodel.MetamodelProperty.MatchLevel getMatchLevel(spoon.reflect.reference.CtTypeReference<?> expectedType, spoon.reflect.reference.CtTypeReference<?> realType) {
        if (expectedType.equals(realType)) {
            return spoon.metamodel.MetamodelProperty.MatchLevel.EQUALS;
        }
        if (expectedType.getTypeErasure().equals(realType.getTypeErasure())) {
            return spoon.metamodel.MetamodelProperty.MatchLevel.ERASED_EQUALS;
        }
        if (expectedType.isSubtypeOf(realType)) {
            /* CtFieldReference<T> CtFieldAccess#getVariable() CtFieldAccess
            inherits from CtVariableAccess which has
            #setVariable(CtVariableReference<T>) it is OK to use expected
            type CtFieldReference<T>, when setter has CtVariableReference<T>
             */
            return spoon.metamodel.MetamodelProperty.MatchLevel.SUBTYPE;
        }
        return null;
    }

    /**
     *
     *
     * @param valueType
     * 		whose Map value type is needed
     * @return Map value type If valueType is an Map. null if it is not
     */
    private spoon.reflect.reference.CtTypeReference<?> getMapValueType(spoon.reflect.reference.CtTypeReference<?> valueType) {
        if (valueType != null) {
            spoon.reflect.factory.Factory f = valueType.getFactory();
            if ((valueType.isSubtypeOf(f.Type().MAP)) && ((valueType.getActualTypeArguments().size()) == 2)) {
                return valueType.getActualTypeArguments().get(1);
            }
        }
        return null;
    }

    /**
     *
     *
     * @return true if this {@link MetamodelProperty} is derived in owner concept, ig has the annotation @{@link DerivedProperty}.
     */
    public boolean isDerived() {
        if ((derived) == null) {
            // by default it's derived
            derived = java.lang.Boolean.FALSE;
            // if DerivedProperty is found on any getter of this type, then this field is derived
            spoon.metamodel.MMMethod getter = getMethod(spoon.metamodel.MMMethodKind.GET);
            if (getter == null) {
                throw new spoon.SpoonException(("No getter defined for " + (this)));
            }
            spoon.reflect.reference.CtTypeReference<spoon.support.DerivedProperty> derivedProperty = getter.getActualCtMethod().getFactory().createCtTypeReference(spoon.support.DerivedProperty.class);
            for (spoon.reflect.declaration.CtMethod<?> ctMethod : getter.getDeclaredMethods()) {
                if ((ctMethod.getAnnotation(derivedProperty)) != null) {
                    derived = java.lang.Boolean.TRUE;
                    return derived;
                }
            }
            // inherit derived property from super type
            // if DerivedProperty annotation is not found on any get method, then it is not derived
            // check all super fields. If any of them is derived then this field is derived too
            for (spoon.metamodel.MetamodelProperty superField : superProperties) {
                if (superField.isDerived()) {
                    derived = java.lang.Boolean.TRUE;
                    return derived;
                }
            }
        }
        return derived;
    }

    /**
     *
     *
     * @return true if this {@link MetamodelProperty} is unsettable in owner concept
     * ie. if the property has the annotation @{@link UnsettableProperty}
     */
    public boolean isUnsettable() {
        if ((unsettable) == null) {
            // by default it's unsettable
            unsettable = java.lang.Boolean.FALSE;
            // if UnsettablePropertyis found on any setter of this type, then this field is unsettable
            spoon.metamodel.MMMethod setter = getMethod(spoon.metamodel.MMMethodKind.SET);
            if (setter == null) {
                unsettable = java.lang.Boolean.TRUE;
                return unsettable;
            }
            spoon.reflect.reference.CtTypeReference<spoon.support.UnsettableProperty> unsettableProperty = setter.getActualCtMethod().getFactory().createCtTypeReference(spoon.support.UnsettableProperty.class);
            for (spoon.reflect.declaration.CtMethod<?> ctMethod : setter.getDeclaredMethods()) {
                if ((ctMethod.getAnnotation(unsettableProperty)) != null) {
                    unsettable = java.lang.Boolean.TRUE;
                    return unsettable;
                }
            }
        }
        return unsettable;
    }

    private java.util.List<spoon.metamodel.MMMethod> getRoleMethods() {
        return java.util.Collections.unmodifiableList(roleMethods);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return (((((ownerConcept.getName()) + "#") + (getName())) + "<") + (valueType)) + ">";
    }

    /**
     *
     *
     * @return the super {@link MetamodelProperty} which has same valueType and which is upper in the metamodel hierarchy
     * For example:
     * The super property of {@link CtField}#NAME is {@link CtNamedElement}#NAME
     * This method can be used to optimize generated code.
     */
    public spoon.metamodel.MetamodelProperty getSuperProperty() {
        java.util.List<spoon.metamodel.MetamodelProperty> potentialRootSuperFields = new java.util.ArrayList<>();
        if ((roleMethods.size()) > 0) {
            potentialRootSuperFields.add(this);
        }
        superProperties.forEach(( superField) -> {
            spoon.metamodel.Metamodel.addUniqueObject(potentialRootSuperFields, superField.getSuperProperty());
        });
        int idx = 0;
        if ((potentialRootSuperFields.size()) > 1) {
            boolean needsSetter = (getMethod(spoon.metamodel.MMMethodKind.SET)) != null;
            spoon.reflect.reference.CtTypeReference<?> expectedValueType = this.getTypeOfField().getTypeErasure();
            for (int i = 1; i < (potentialRootSuperFields.size()); i++) {
                spoon.metamodel.MetamodelProperty superField = potentialRootSuperFields.get(i);
                if ((superField.getTypeOfField().getTypeErasure().equals(expectedValueType)) == false) {
                    break;
                }
                if (needsSetter && ((superField.getMethod(spoon.metamodel.MMMethodKind.SET)) == null)) {
                    // this field has setter but the superField has no setter. We cannot used it as super
                    break;
                }
                idx = i;
            }
        }
        return potentialRootSuperFields.get(idx);
    }

    private static spoon.reflect.meta.ContainerKind containerKindOf(java.lang.Class<?> valueClass) {
        if (java.util.List.class.isAssignableFrom(valueClass)) {
            return spoon.reflect.meta.ContainerKind.LIST;
        }
        if (java.util.Map.class.isAssignableFrom(valueClass)) {
            return spoon.reflect.meta.ContainerKind.MAP;
        }
        if (java.util.Set.class.isAssignableFrom(valueClass)) {
            return spoon.reflect.meta.ContainerKind.SET;
        }
        return spoon.reflect.meta.ContainerKind.SINGLE;
    }
}

