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
 * Represents a method used to get or set a {@link MetamodelProperty} of a {@link MetamodelConcept}.
 */
public class MMMethod {
    private final spoon.metamodel.MetamodelProperty ownerField;

    private final spoon.reflect.declaration.CtMethod<?> method;

    /**
     * methods with the same role and same signature in the type hierarchy
     */
    private final java.util.List<spoon.reflect.declaration.CtMethod<?>> ownMethods = new java.util.ArrayList<>();

    private final java.lang.String signature;

    private final spoon.metamodel.MMMethodKind methodKind;

    /**
     * Creates a {@link MMMethod} of a {@link MetamodelProperty}
     *
     * @param field
     * 		a owner field
     * @param method
     * 		a method from ownerType or nearest super type
     */
    MMMethod(spoon.metamodel.MetamodelProperty field, spoon.reflect.declaration.CtMethod<?> method) {
        this.ownerField = field;
        // adapt method to scope of field.ownType
        spoon.support.visitor.MethodTypingContext mtc = new spoon.support.visitor.MethodTypingContext().setClassTypingContext(field.getOwner().getTypeContext()).setMethod(method);
        this.method = ((spoon.reflect.declaration.CtMethod<?>) (mtc.getAdaptationScope()));
        signature = this.method.getSignature();
        methodKind = spoon.metamodel.MMMethodKind.kindOf(this.method);
        this.addRelatedMethod(method);
    }

    /**
     *
     *
     * @return a {@link CtMethod}, which represents this {@link MMMethod}
     */
    public spoon.reflect.declaration.CtMethod<?> getActualCtMethod() {
        return method;
    }

    /**
     *
     *
     * @return name of this {@link MMMethod}. It is equal to simple name of related {@link CtMethod}
     */
    public java.lang.String getName() {
        return method.getSimpleName();
    }

    /**
     *
     *
     * @return signature of this method, without the declaring type
     */
    public java.lang.String getSignature() {
        return signature;
    }

    /**
     *
     *
     * @return kind of this method. Getter, setter, ...
     */
    public spoon.metamodel.MMMethodKind getKind() {
        return methodKind;
    }

    /**
     *
     *
     * @return first own method in super type hierarchy of `targetType`
     */
    spoon.reflect.declaration.CtMethod<?> getCompatibleMethod(spoon.metamodel.MetamodelConcept targetType) {
        for (spoon.reflect.declaration.CtMethod<?> ctMethod : ownMethods) {
            if (targetType.getTypeContext().isSubtypeOf(ctMethod.getDeclaringType().getReference())) {
                return ctMethod;
            }
        }
        throw new spoon.SpoonException(("No own method exists in type " + (ownerField)));
    }

    /**
     *
     *
     * @param method
     * 		
     * @return true of this {@link MMMethod} overrides `method`. In different words, if it represents the same method
     */
    public boolean overrides(spoon.reflect.declaration.CtMethod<?> method) {
        return ownerField.getOwner().getTypeContext().isOverriding(this.method, method);
    }

    /**
     *
     *
     * @return the {@link MetamodelProperty} which is get or set by this {@link MMMethod}
     */
    public spoon.metamodel.MetamodelProperty getProperty() {
        return ownerField;
    }

    /**
     *
     *
     * @return {@link MetamodelConcept} where this {@link MMMethod} belongs to
     */
    public spoon.metamodel.MetamodelConcept getOwner() {
        return getProperty().getOwner();
    }

    /**
     *
     *
     * @return {@link CtMethod}s, which are declared in the {@link MetamodelConcept} or in the hierarchy, that have the same role and {@link MMMethodKind}.
     */
    public java.util.List<spoon.reflect.declaration.CtMethod<?>> getDeclaredMethods() {
        return java.util.Collections.unmodifiableList(ownMethods);
    }

    void addRelatedMethod(spoon.reflect.declaration.CtMethod<?> method) {
        if (method.getDeclaringType().getSimpleName().endsWith("Impl")) {
            throw new spoon.SpoonException("the metametamodel should be entirely specified in the Spoon interfaces");
        }
        ownMethods.add(method);
    }

    /**
     *
     *
     * @return the type returned by this method
     */
    public spoon.reflect.reference.CtTypeReference<?> getReturnType() {
        return method.getType();
    }

    /**
     *
     *
     * @return a value type of this method
     */
    public spoon.reflect.reference.CtTypeReference<?> getValueType() {
        if (method.getParameters().isEmpty()) {
            return method.getType();
        }
        return method.getParameters().get(((method.getParameters().size()) - 1)).getType();
    }

    @java.lang.Override
    public java.lang.String toString() {
        return ((getOwner().getName()) + "#") + (getSignature());
    }
}

