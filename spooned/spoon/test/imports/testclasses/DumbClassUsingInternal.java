package spoon.test.imports.testclasses;


import spoon.test.imports.testclasses.internal.*;
import spoon.test.imports.testclasses.internal.ChildClass;
import spoon.test.imports.testclasses.internal.PublicInterface2;
import spoon.test.imports.testclasses.internal.PublicSuperClass;


public class DumbClassUsingInternal {
    ChildClass childClass = new ChildClass();

    PublicInterface2 publicInterface2;

    PublicSuperClass superClass = new PublicSuperClass();
}

