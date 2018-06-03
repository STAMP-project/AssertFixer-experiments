package spoon.test.method_overriding.testclasses2;


public class Foo {
    public void useLambda() {
        spoon.test.method_overriding.testclasses2.ObjectInterface objectInterface = () -> {
        };
        objectInterface.doSomething();
    }
}

