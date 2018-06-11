package spoon.reflect.reference;


public interface CtWildcardReference extends spoon.reflect.reference.CtTypeParameterReference {
    @java.lang.Override
    spoon.reflect.reference.CtWildcardReference clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <C extends spoon.reflect.reference.CtReference> C setSimpleName(java.lang.String simpleName);
}

