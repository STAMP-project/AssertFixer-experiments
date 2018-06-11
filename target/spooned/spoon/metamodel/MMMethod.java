package spoon.metamodel;


public class MMMethod {
    private final spoon.metamodel.MetamodelProperty ownerField;

    private final spoon.reflect.declaration.CtMethod<?> method;

    private final java.util.List<spoon.reflect.declaration.CtMethod<?>> ownMethods = new java.util.ArrayList<>();

    private final java.lang.String signature;

    private final spoon.metamodel.MMMethodKind methodKind;

    MMMethod(spoon.metamodel.MetamodelProperty field, spoon.reflect.declaration.CtMethod<?> method) {
        this.ownerField = field;
        spoon.support.visitor.MethodTypingContext mtc = new spoon.support.visitor.MethodTypingContext().setClassTypingContext(field.getOwner().getTypeContext()).setMethod(method);
        this.method = ((spoon.reflect.declaration.CtMethod<?>) (mtc.getAdaptationScope()));
        signature = this.method.getSignature();
        methodKind = spoon.metamodel.MMMethodKind.kindOf(this.method);
        this.addRelatedMethod(method);
    }

    public spoon.reflect.declaration.CtMethod<?> getActualCtMethod() {
        return method;
    }

    public java.lang.String getName() {
        return method.getSimpleName();
    }

    public java.lang.String getSignature() {
        return signature;
    }

    public spoon.metamodel.MMMethodKind getKind() {
        return methodKind;
    }

    spoon.reflect.declaration.CtMethod<?> getCompatibleMethod(spoon.metamodel.MetamodelConcept targetType) {
        for (spoon.reflect.declaration.CtMethod<?> ctMethod : ownMethods) {
            if (targetType.getTypeContext().isSubtypeOf(ctMethod.getDeclaringType().getReference())) {
                return ctMethod;
            }
        }
        throw new spoon.SpoonException(("No own method exists in type " + (ownerField)));
    }

    public boolean overrides(spoon.reflect.declaration.CtMethod<?> method) {
        return ownerField.getOwner().getTypeContext().isOverriding(this.method, method);
    }

    public spoon.metamodel.MetamodelProperty getProperty() {
        return ownerField;
    }

    public spoon.metamodel.MetamodelConcept getOwner() {
        return getProperty().getOwner();
    }

    public java.util.List<spoon.reflect.declaration.CtMethod<?>> getDeclaredMethods() {
        return java.util.Collections.unmodifiableList(ownMethods);
    }

    void addRelatedMethod(spoon.reflect.declaration.CtMethod<?> method) {
        if (method.getDeclaringType().getSimpleName().endsWith("Impl")) {
            throw new spoon.SpoonException("the metametamodel should be entirely specified in the Spoon interfaces");
        }
        ownMethods.add(method);
    }

    public spoon.reflect.reference.CtTypeReference<?> getReturnType() {
        return method.getType();
    }

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

