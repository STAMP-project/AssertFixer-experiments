package spoon.reflect.declaration;


public interface CtEnumValue<T> extends spoon.reflect.declaration.CtField<T> {
    @java.lang.Override
    spoon.reflect.declaration.CtEnumValue clone();

    @java.lang.Override
    @spoon.support.UnsettableProperty
    <U extends spoon.reflect.code.CtRHSReceiver<T>> U setAssignment(spoon.reflect.code.CtExpression<T> assignment);
}

