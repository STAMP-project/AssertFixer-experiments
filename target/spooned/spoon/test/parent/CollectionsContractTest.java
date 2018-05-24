package spoon.test.parent;


@org.junit.runner.RunWith(org.junit.runners.Parameterized.class)
public class CollectionsContractTest<T extends spoon.reflect.visitor.CtVisitable> {
    private static spoon.reflect.factory.Factory factory = spoon.testing.utils.ModelUtils.createFactory();

    private static final java.util.List<spoon.reflect.declaration.CtType<? extends spoon.reflect.declaration.CtElement>> allInstantiableMetamodelInterfaces = spoon.test.SpoonTestHelpers.getAllInstantiableMetamodelInterfaces();

    @org.junit.runners.Parameterized.Parameters(name = "{0}")
    public static java.util.Collection<java.lang.Object[]> data() throws java.lang.Exception {
        return spoon.test.parent.CollectionsContractTest.createReceiverList();
    }

    public static java.util.Collection<java.lang.Object[]> createReceiverList() throws java.lang.Exception {
        spoon.test.parent.CollectionsContractTest.metamodel = new spoon.test.metamodel.SpoonMetaModel(new java.io.File("src/main/java"));
        spoon.test.parent.CollectionsContractTest.allProblems = new java.util.ArrayList<>();
        java.util.List<java.lang.Object[]> values = new java.util.ArrayList<>();
        for (spoon.test.metamodel.MetamodelConcept mmC : spoon.test.parent.CollectionsContractTest.metamodel.getConcepts()) {
            if ((mmC.getKind()) == (spoon.test.metamodel.MMTypeKind.LEAF)) {
                values.add(new java.lang.Object[]{ mmC });
            }
        }
        return values;
    }

    @org.junit.AfterClass
    public static void reportAllProblems() {
        java.lang.System.out.println("Expected collection handling:");
        java.lang.System.out.println(spoon.test.parent.CollectionsContractTest.allExpected.stream().sorted().collect(java.util.stream.Collectors.joining("\n")));
        if ((spoon.test.parent.CollectionsContractTest.allProblems.size()) > 0) {
            java.lang.System.out.println("-----------------------------");
            java.lang.System.out.println("Wrong collection handling:");
            java.lang.System.out.println(spoon.test.parent.CollectionsContractTest.allProblems.stream().sorted().collect(java.util.stream.Collectors.joining("\n")));
        }
    }

    private static spoon.test.metamodel.SpoonMetaModel metamodel;

    @org.junit.runners.Parameterized.Parameter(0)
    public spoon.test.metamodel.MetamodelConcept mmConcept;

    enum CollectionKind {
        READ_ONLY, MUTABLE_DETACHED, MUTABLE_ATTACHED_INCORRECT, MUTABLE_ATTACHED_CORRECT;}

    static java.util.Set<spoon.reflect.path.CtRole> ignoredRoles = new java.util.HashSet<>(java.util.Arrays.asList(spoon.reflect.path.CtRole.POSITION, spoon.reflect.path.CtRole.MODIFIER));

    static java.util.List<java.lang.String> allProblems = new java.util.ArrayList<>();

    static java.util.List<java.lang.String> allExpected = new java.util.ArrayList<>();

    @org.junit.Test
    public void testContract() throws java.lang.Throwable {
        java.lang.Class<? extends spoon.reflect.declaration.CtElement> elementClass = ((java.lang.Class<? extends spoon.reflect.declaration.CtElement>) (mmConcept.getModelInterface().getActualClass()));
        spoon.reflect.declaration.CtElement testedElement = spoon.test.parent.CollectionsContractTest.factory.Core().create(elementClass);
        if (elementClass.equals(spoon.reflect.reference.CtTypeReference.class)) {
            testedElement = spoon.test.parent.CollectionsContractTest.factory.Type().createReference(java.util.ArrayList.class);
        }
        java.util.List<java.lang.String> problems = new java.util.ArrayList<>();
        java.util.List<java.lang.String> expected = new java.util.ArrayList<>();
        for (spoon.test.metamodel.MetamodelProperty mmProperty : mmConcept.getRoleToProperty().values()) {
            if (((mmProperty.getValueContainerType()) == (spoon.reflect.meta.ContainerKind.SINGLE)) || (spoon.test.parent.CollectionsContractTest.ignoredRoles.contains(mmProperty.getRole()))) {
                continue;
            }
            java.lang.Object argument = spoon.test.parent.ParentContractTest.createCompatibleObject(mmProperty.getItemValueType());
            spoon.reflect.meta.RoleHandler roleHandler = spoon.reflect.meta.impl.RoleHandlerHelper.getRoleHandler(elementClass, mmProperty.getRole());
            spoon.test.parent.CollectionsContractTest.CollectionKind colKind = detectCollectionKind(roleHandler, testedElement, ((spoon.reflect.declaration.CtElement) (argument)));
            if (colKind != null) {
                if (mmProperty.isDerived()) {
                    if (colKind != (spoon.test.parent.CollectionsContractTest.CollectionKind.READ_ONLY)) {
                        problems.add(((((("derived;" + (mmConcept)) + "#") + (mmProperty.getName())) + ";") + (colKind.name())));
                    }else {
                        expected.add(((((("derived;" + (mmConcept)) + "#") + (mmProperty.getName())) + ";") + (colKind.name())));
                    }
                }else {
                    if (colKind != (spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_ATTACHED_CORRECT)) {
                        problems.add(((((("normal;" + (mmConcept)) + "#") + (mmProperty.getName())) + ";") + (colKind.name())));
                    }else {
                        expected.add(((((("normal;" + (mmConcept)) + "#") + (mmProperty.getName())) + ";") + (colKind.name())));
                    }
                }
            }else {
                problems.add(((("Failed check of;" + (mmConcept)) + "#") + (mmProperty.getName())));
            }
        }
        spoon.test.parent.CollectionsContractTest.allExpected.addAll(expected);
        if ((problems.size()) > 0) {
            spoon.test.parent.CollectionsContractTest.allProblems.addAll(problems);
            org.junit.Assert.fail(java.lang.String.join("\n", problems));
        }
    }

    private spoon.test.parent.CollectionsContractTest.CollectionKind detectCollectionKind(spoon.reflect.meta.RoleHandler roleHandler, spoon.reflect.declaration.CtElement testedElement, spoon.reflect.declaration.CtElement argument) {
        switch (roleHandler.getContainerKind()) {
            case MAP :
                return detectCollectionKindOfMap(roleHandler, testedElement, argument);
            case LIST :
            case SET :
                return detectCollectionKindOfCollection(roleHandler, testedElement, argument);
            case SINGLE :
                return null;
        }
        throw new spoon.SpoonException(("Unexpected container kind " + (roleHandler.getContainerKind())));
    }

    static class ChangeListener extends spoon.experimental.modelobs.ActionBasedChangeListenerImpl {
        java.util.List<spoon.experimental.modelobs.action.Action> actions = new java.util.ArrayList<>();

        @java.lang.Override
        public void onAction(spoon.experimental.modelobs.action.Action action) {
            actions.add(action);
        }
    }

    private spoon.test.parent.CollectionsContractTest.CollectionKind detectCollectionKindOfCollection(spoon.reflect.meta.RoleHandler roleHandler, spoon.reflect.declaration.CtElement testedElement, spoon.reflect.declaration.CtElement argument) {
        spoon.test.parent.CollectionsContractTest.ChangeListener changeListener = new spoon.test.parent.CollectionsContractTest.ChangeListener();
        testedElement.getFactory().getEnvironment().setModelChangeListener(changeListener);
        java.util.Collection col;
        try {
            col = ((java.util.Collection) (roleHandler.getValue(testedElement)));
        } catch (java.lang.Exception e) {
            return null;
        }
        try {
            col.add(argument);
        } catch (java.lang.UnsupportedOperationException e) {
            return spoon.test.parent.CollectionsContractTest.CollectionKind.READ_ONLY;
        }
        java.util.Collection col2 = ((java.util.Collection) (roleHandler.getValue(testedElement)));
        if ((col2.contains(argument)) == false) {
            return spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_DETACHED;
        }
        if ((argument.isParentInitialized()) && ((argument.getParent()) == testedElement)) {
            if ((changeListener.actions.size()) > 0) {
                return spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_ATTACHED_CORRECT;
            }
        }
        return spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_ATTACHED_INCORRECT;
    }

    private spoon.test.parent.CollectionsContractTest.CollectionKind detectCollectionKindOfMap(spoon.reflect.meta.RoleHandler roleHandler, spoon.reflect.declaration.CtElement testedElement, spoon.reflect.declaration.CtElement argument) {
        spoon.test.parent.CollectionsContractTest.ChangeListener changeListener = new spoon.test.parent.CollectionsContractTest.ChangeListener();
        testedElement.getFactory().getEnvironment().setModelChangeListener(changeListener);
        java.util.Map<java.lang.String, spoon.reflect.declaration.CtElement> col = ((java.util.Map) (roleHandler.getValue(testedElement)));
        try {
            col.put("x", argument);
        } catch (java.lang.UnsupportedOperationException e) {
            return spoon.test.parent.CollectionsContractTest.CollectionKind.READ_ONLY;
        }
        java.util.Map<java.lang.String, spoon.reflect.declaration.CtElement> col2 = ((java.util.Map<java.lang.String, spoon.reflect.declaration.CtElement>) (roleHandler.getValue(testedElement)));
        if ((col2.get("x")) != argument) {
            return spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_DETACHED;
        }
        if ((argument.isParentInitialized()) && ((argument.getParent()) == testedElement)) {
            if ((changeListener.actions.size()) > 0) {
                return spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_ATTACHED_CORRECT;
            }
        }
        return spoon.test.parent.CollectionsContractTest.CollectionKind.MUTABLE_ATTACHED_INCORRECT;
    }
}

