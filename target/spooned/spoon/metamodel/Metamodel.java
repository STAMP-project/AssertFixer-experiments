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
 * Represents the Spoon metamodel (incl. at runtime)
 */
public class Metamodel {
    /**
     * Returns all interfaces of the Spoon metamodel.
     * This method is stateless for sake of maintenance.
     * If you need to call it several times, you should store the result.
     */
    public static java.util.Set<spoon.reflect.declaration.CtType<?>> getAllMetamodelInterfaces() {
        java.util.Set<spoon.reflect.declaration.CtType<?>> result = new java.util.HashSet<>();
        spoon.reflect.factory.Factory factory = new spoon.reflect.factory.FactoryImpl(new spoon.support.DefaultCoreFactory(), new spoon.support.StandardEnvironment());
        // avoid debug messages: Some annotations might be unreachable from the shadow element:
        // which causes bad meta model creation performance
        factory.getEnvironment().setLevel("INFO");
        result.add(factory.Type().get(spoon.reflect.code.BinaryOperatorKind.class));
        result.add(factory.Type().get(spoon.reflect.code.CtAbstractInvocation.class));
        result.add(factory.Type().get(spoon.reflect.code.CtAnnotationFieldAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtArrayAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtArrayRead.class));
        result.add(factory.Type().get(spoon.reflect.code.CtArrayWrite.class));
        result.add(factory.Type().get(spoon.reflect.code.CtAssert.class));
        result.add(factory.Type().get(spoon.reflect.code.CtAssignment.class));
        result.add(factory.Type().get(spoon.reflect.code.CtBinaryOperator.class));
        result.add(factory.Type().get(spoon.reflect.code.CtBlock.class));
        result.add(factory.Type().get(spoon.reflect.code.CtBodyHolder.class));
        result.add(factory.Type().get(spoon.reflect.code.CtBreak.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCFlowBreak.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCase.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCatch.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCatchVariable.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCodeElement.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCodeSnippetExpression.class));
        result.add(factory.Type().get(spoon.reflect.code.CtCodeSnippetStatement.class));
        result.add(factory.Type().get(spoon.reflect.code.CtComment.class));
        result.add(factory.Type().get(spoon.reflect.code.CtConditional.class));
        result.add(factory.Type().get(spoon.reflect.code.CtConstructorCall.class));
        result.add(factory.Type().get(spoon.reflect.code.CtContinue.class));
        result.add(factory.Type().get(spoon.reflect.code.CtDo.class));
        result.add(factory.Type().get(spoon.reflect.code.CtExecutableReferenceExpression.class));
        result.add(factory.Type().get(spoon.reflect.code.CtExpression.class));
        result.add(factory.Type().get(spoon.reflect.code.CtFieldAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtFieldRead.class));
        result.add(factory.Type().get(spoon.reflect.code.CtFieldWrite.class));
        result.add(factory.Type().get(spoon.reflect.code.CtFor.class));
        result.add(factory.Type().get(spoon.reflect.code.CtForEach.class));
        result.add(factory.Type().get(spoon.reflect.code.CtIf.class));
        result.add(factory.Type().get(spoon.reflect.code.CtInvocation.class));
        result.add(factory.Type().get(spoon.reflect.code.CtJavaDoc.class));
        result.add(factory.Type().get(spoon.reflect.code.CtJavaDocTag.class));
        result.add(factory.Type().get(spoon.reflect.code.CtLabelledFlowBreak.class));
        result.add(factory.Type().get(spoon.reflect.code.CtLambda.class));
        result.add(factory.Type().get(spoon.reflect.code.CtLiteral.class));
        result.add(factory.Type().get(spoon.reflect.code.CtLocalVariable.class));
        result.add(factory.Type().get(spoon.reflect.code.CtLoop.class));
        result.add(factory.Type().get(spoon.reflect.code.CtNewArray.class));
        result.add(factory.Type().get(spoon.reflect.code.CtNewClass.class));
        result.add(factory.Type().get(spoon.reflect.code.CtOperatorAssignment.class));
        result.add(factory.Type().get(spoon.reflect.code.CtRHSReceiver.class));
        result.add(factory.Type().get(spoon.reflect.code.CtReturn.class));
        result.add(factory.Type().get(spoon.reflect.code.CtStatement.class));
        result.add(factory.Type().get(spoon.reflect.code.CtStatementList.class));
        result.add(factory.Type().get(spoon.reflect.code.CtSuperAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtSwitch.class));
        result.add(factory.Type().get(spoon.reflect.code.CtSynchronized.class));
        result.add(factory.Type().get(spoon.reflect.code.CtTargetedExpression.class));
        result.add(factory.Type().get(spoon.reflect.code.CtThisAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtThrow.class));
        result.add(factory.Type().get(spoon.reflect.code.CtTry.class));
        result.add(factory.Type().get(spoon.reflect.code.CtTryWithResource.class));
        result.add(factory.Type().get(spoon.reflect.code.CtTypeAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtUnaryOperator.class));
        result.add(factory.Type().get(spoon.reflect.code.CtVariableAccess.class));
        result.add(factory.Type().get(spoon.reflect.code.CtVariableRead.class));
        result.add(factory.Type().get(spoon.reflect.code.CtVariableWrite.class));
        result.add(factory.Type().get(spoon.reflect.code.CtWhile.class));
        result.add(factory.Type().get(spoon.reflect.code.UnaryOperatorKind.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtAnnotatedElementType.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtAnnotation.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtAnnotationMethod.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtAnnotationType.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtAnonymousExecutable.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtClass.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtCodeSnippet.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtConstructor.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtElement.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtEnum.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtEnumValue.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtExecutable.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtField.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtFormalTypeDeclarer.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtInterface.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtMethod.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtModifiable.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtMultiTypedElement.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtNamedElement.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtPackage.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtParameter.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtShadowable.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtType.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtTypeInformation.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtTypeMember.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtTypeParameter.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtTypedElement.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtVariable.class));
        result.add(factory.Type().get(spoon.reflect.declaration.ModifierKind.class));
        result.add(factory.Type().get(spoon.reflect.declaration.ParentNotInitializedException.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtActualTypeContainer.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtArrayTypeReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtCatchVariableReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtExecutableReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtFieldReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtIntersectionTypeReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtLocalVariableReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtPackageReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtParameterReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtTypeParameterReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtTypeReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtUnboundVariableReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtVariableReference.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtWildcardReference.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtImport.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtImportKind.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtModule.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtModuleRequirement.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtPackageExport.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtProvidedService.class));
        result.add(factory.Type().get(spoon.reflect.reference.CtModuleReference.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtUsedService.class));
        result.add(factory.Type().get(spoon.reflect.declaration.CtModuleDirective.class));
        return result;
    }

    private static final java.lang.String CLASS_SUFFIX = "Impl";

    /**
     * qualified names of packages which contains interfaces of spoon model
     */
    public static final java.util.Set<java.lang.String> MODEL_IFACE_PACKAGES = new java.util.HashSet<>(java.util.Arrays.asList("spoon.reflect.code", "spoon.reflect.declaration", "spoon.reflect.reference"));

    /**
     * {@link MetamodelConcept}s by name
     */
    private final java.util.Map<java.lang.String, spoon.metamodel.MetamodelConcept> nameToConcept = new java.util.HashMap<>();

    private static spoon.metamodel.Metamodel instance;

    /**
     *
     *
     * @return Spoon {@link Metamodel}, which is built once and then returns cached version
     */
    public static spoon.metamodel.Metamodel getInstance() {
        if ((spoon.metamodel.Metamodel.instance) == null) {
            spoon.metamodel.Metamodel.instance = new spoon.metamodel.Metamodel();
        }
        return spoon.metamodel.Metamodel.instance;
    }

    /**
     * Not in the public API.
     *
     * Parses spoon sources and creates factory with spoon model.
     *
     * @param spoonJavaSourcesDirectory
     * 		the root directory of java sources of spoon model.
     * 		The directory must contain "spoon" directory.
     */
    public Metamodel(java.io.File spoonJavaSourcesDirectory) {
        this(spoon.metamodel.Metamodel.createFactory(spoonJavaSourcesDirectory));
    }

    /**
     *
     *
     * @param factory
     * 		already loaded factory with all Spoon model types
     */
    private Metamodel(spoon.reflect.factory.Factory factory) {
        for (java.lang.String apiPackage : spoon.metamodel.Metamodel.MODEL_IFACE_PACKAGES) {
            if ((factory.Package().get(apiPackage)) == null) {
                throw new spoon.SpoonException(("Spoon Factory model is missing API package " + apiPackage));
            }
            java.lang.String implPackage = spoon.metamodel.Metamodel.replaceApiToImplPackage(apiPackage);
            if ((factory.Package().get(implPackage)) == null) {
                throw new spoon.SpoonException(("Spoon Factory model is missing implementation package " + implPackage));
            }
        }
        // search for all interfaces of spoon model and create MetamodelConcepts for them
        factory.getModel().filterChildren(new spoon.reflect.visitor.filter.TypeFilter<>(spoon.reflect.declaration.CtInterface.class)).forEach((spoon.reflect.declaration.CtInterface<?> iface) -> {
            if (spoon.metamodel.Metamodel.MODEL_IFACE_PACKAGES.contains(iface.getPackage().getQualifiedName())) {
                getOrCreateConcept(iface);
            }
        });
    }

    /**
     * Creates a {@link Metamodel} in runtime mode when spoon sources are not available.
     *
     * See also {@link #getInstance()}.
     */
    private Metamodel() {
        for (spoon.reflect.declaration.CtType<?> iface : spoon.metamodel.Metamodel.getAllMetamodelInterfaces()) {
            if (iface instanceof spoon.reflect.declaration.CtInterface) {
                getOrCreateConcept(iface);
            }
        }
    }

    /**
     *
     *
     * @return all {@link MetamodelConcept}s of spoon meta model
     */
    public java.util.Collection<spoon.metamodel.MetamodelConcept> getConcepts() {
        return java.util.Collections.unmodifiableCollection(nameToConcept.values());
    }

    /**
     *
     *
     * @return List of Spoon model interfaces, which represents instantiable leafs of Spoon metamodel
     */
    @java.lang.SuppressWarnings({ "unchecked", "rawtypes" })
    public java.util.List<spoon.reflect.declaration.CtType<? extends spoon.reflect.declaration.CtElement>> getAllInstantiableMetamodelInterfaces() {
        java.util.List<spoon.reflect.declaration.CtType<? extends spoon.reflect.declaration.CtElement>> result = new java.util.ArrayList<>();
        for (spoon.metamodel.MetamodelConcept mmConcept : getConcepts()) {
            if ((mmConcept.getKind()) == (spoon.metamodel.ConceptKind.LEAF)) {
                result.add(((spoon.reflect.declaration.CtType) (mmConcept.getMetamodelInterface())));
            }
        }
        return result;
    }

    /**
     *
     *
     * @param type
     * 		a spoon model class or interface, whose concept name has to be returned
     * @return name of {@link MetamodelConcept}, which represents Spoon model {@link CtType}
     */
    public static java.lang.String getConceptName(spoon.reflect.declaration.CtType<?> type) {
        java.lang.String name = type.getSimpleName();
        if (name.endsWith(spoon.metamodel.Metamodel.CLASS_SUFFIX)) {
            name = name.substring(0, ((name.length()) - (spoon.metamodel.Metamodel.CLASS_SUFFIX.length())));
        }
        return name;
    }

    /**
     *
     *
     * @param iface
     * 		the interface of spoon model element
     * @return {@link CtClass} of Spoon model which implements the spoon model interface. null if there is no implementation.
     */
    public static spoon.reflect.declaration.CtClass<?> getImplementationOfInterface(spoon.reflect.declaration.CtInterface<?> iface) {
        java.lang.String impl = (spoon.metamodel.Metamodel.replaceApiToImplPackage(iface.getQualifiedName())) + (spoon.metamodel.Metamodel.CLASS_SUFFIX);
        return ((spoon.reflect.declaration.CtClass<?>) (spoon.metamodel.Metamodel.getType(impl, iface)));
    }

    /**
     *
     *
     * @param impl
     * 		the implementation class of a Spoon element
     * @return {@link CtInterface} of Spoon model which represents API of the spoon model class. null if there is no implementation.
     */
    public static spoon.reflect.declaration.CtInterface<?> getInterfaceOfImplementation(spoon.reflect.declaration.CtClass<?> impl) {
        java.lang.String iface = impl.getQualifiedName();
        if (((iface.endsWith(spoon.metamodel.Metamodel.CLASS_SUFFIX)) == false) || ((iface.startsWith("spoon.support.reflect.")) == false)) {
            throw new spoon.SpoonException(("Unexpected spoon model implementation class: " + (impl.getQualifiedName())));
        }
        iface = iface.substring(0, ((iface.length()) - (spoon.metamodel.Metamodel.CLASS_SUFFIX.length())));
        iface = iface.replace("spoon.support.reflect", "spoon.reflect");
        return ((spoon.reflect.declaration.CtInterface<?>) (spoon.metamodel.Metamodel.getType(iface, impl)));
    }

    /**
     *
     *
     * @param method
     * 		to be checked method
     * @return {@link CtRole} of spoon model method. Looking into all super class/interface implementations of this method
     */
    public static spoon.reflect.path.CtRole getRoleOfMethod(spoon.reflect.declaration.CtMethod<?> method) {
        spoon.reflect.factory.Factory f = method.getFactory();
        spoon.reflect.declaration.CtAnnotation<spoon.reflect.annotations.PropertyGetter> getter = spoon.metamodel.Metamodel.getInheritedAnnotation(method, f.createCtTypeReference(spoon.reflect.annotations.PropertyGetter.class));
        if (getter != null) {
            return getter.getActualAnnotation().role();
        }
        spoon.reflect.declaration.CtAnnotation<spoon.reflect.annotations.PropertySetter> setter = spoon.metamodel.Metamodel.getInheritedAnnotation(method, f.createCtTypeReference(spoon.reflect.annotations.PropertySetter.class));
        if (setter != null) {
            return setter.getActualAnnotation().role();
        }
        return null;
    }

    private static spoon.reflect.declaration.CtType<?> getType(java.lang.String qualifiedName, spoon.reflect.declaration.CtElement anElement) {
        java.lang.Class aClass;
        try {
            aClass = anElement.getClass().getClassLoader().loadClass(qualifiedName);
        } catch (java.lang.ClassNotFoundException e) {
            // OK, that interface has no implementation class
            return null;
        }
        return anElement.getFactory().Type().get(aClass);
    }

    private static final java.lang.String modelApiPackage = "spoon.reflect";

    private static final java.lang.String modelApiImplPackage = "spoon.support.reflect";

    private static java.lang.String replaceApiToImplPackage(java.lang.String modelInterfaceQName) {
        if ((modelInterfaceQName.startsWith(spoon.metamodel.Metamodel.modelApiPackage)) == false) {
            throw new spoon.SpoonException(((("The qualified name " + modelInterfaceQName) + " doesn't belong to Spoon model API package: ") + (spoon.metamodel.Metamodel.modelApiPackage)));
        }
        return (spoon.metamodel.Metamodel.modelApiImplPackage) + (modelInterfaceQName.substring(spoon.metamodel.Metamodel.modelApiPackage.length()));
    }

    private static spoon.reflect.factory.Factory createFactory(java.io.File spoonJavaSourcesDirectory) {
        final spoon.Launcher launcher = new spoon.Launcher();
        launcher.getEnvironment().setNoClasspath(true);
        launcher.getEnvironment().setCommentEnabled(true);
        // // Spoon model interfaces
        java.util.Arrays.asList("spoon/reflect/code", "spoon/reflect/declaration", "spoon/reflect/reference", "spoon/support/reflect/declaration", "spoon/support/reflect/code", "spoon/support/reflect/reference").forEach(( path) -> {
            launcher.addInputResource(new spoon.support.compiler.FileSystemFolder(new java.io.File(spoonJavaSourcesDirectory, path)));
        });
        launcher.buildModel();
        return launcher.getFactory();
    }

    /**
     *
     *
     * @param type
     * 		can be class or interface of Spoon model element
     * @return existing or creates and initializes new {@link MetamodelConcept} which represents the `type`
     */
    private spoon.metamodel.MetamodelConcept getOrCreateConcept(spoon.reflect.declaration.CtType<?> type) {
        java.lang.String conceptName = spoon.metamodel.Metamodel.getConceptName(type);
        return spoon.metamodel.Metamodel.getOrCreate(nameToConcept, conceptName, () -> new spoon.metamodel.MetamodelConcept(conceptName), ( mmConcept) -> initializeConcept(type, mmConcept));
    }

    /**
     * is called once for each {@link MetamodelConcept}, to initialize it.
     *
     * @param type
     * 		a class or inteface of the spoon model element
     * @param mmConcept
     * 		to be initialize {@link MetamodelConcept}
     */
    private void initializeConcept(spoon.reflect.declaration.CtType<?> type, spoon.metamodel.MetamodelConcept mmConcept) {
        // it is not initialized yet. Do it now
        if (type instanceof spoon.reflect.declaration.CtInterface<?>) {
            spoon.reflect.declaration.CtInterface<?> iface = ((spoon.reflect.declaration.CtInterface<?>) (type));
            mmConcept.setModelClass(spoon.metamodel.Metamodel.getImplementationOfInterface(iface));
            mmConcept.setModelInterface(iface);
        }else
            if (type instanceof spoon.reflect.declaration.CtClass<?>) {
                spoon.reflect.declaration.CtClass<?> clazz = ((spoon.reflect.declaration.CtClass<?>) (type));
                mmConcept.setModelClass(clazz);
                mmConcept.setModelInterface(spoon.metamodel.Metamodel.getInterfaceOfImplementation(clazz));
            }else {
                throw new spoon.SpoonException(("Unexpected spoon model type: " + (type.getQualifiedName())));
            }

        // add fields of interface
        if ((mmConcept.getMetamodelInterface()) != null) {
            // add fields of interface too. They are not added by above call of addFieldsOfType, because the MetamodelConcept already exists in nameToConcept
            addFieldsOfType(mmConcept, mmConcept.getMetamodelInterface());
        }
        // initialize all fields
        mmConcept.getRoleToProperty().forEach(( role, mmField) -> {
            // if there are more methods for the same field then choose the one which best matches the field type
            mmField.sortByBestMatch();
            // finally initialize value type of this field
            mmField.setValueType(mmField.detectValueType());
        });
    }

    /**
     * adds all {@link MetamodelProperty}s of `ctType`
     *
     * @param mmConcept
     * 		the owner of to be created fields
     * @param ctType
     * 		to be scanned {@link CtType}
     */
    private void addFieldsOfType(spoon.metamodel.MetamodelConcept mmConcept, spoon.reflect.declaration.CtType<?> ctType) {
        ctType.getTypeMembers().forEach(( typeMember) -> {
            if (typeMember instanceof spoon.reflect.declaration.CtMethod<?>) {
                spoon.reflect.declaration.CtMethod<?> method = ((spoon.reflect.declaration.CtMethod<?>) (typeMember));
                spoon.reflect.path.CtRole role = spoon.metamodel.Metamodel.getRoleOfMethod(method);
                if (role != null) {
                    spoon.metamodel.MetamodelProperty field = mmConcept.getOrCreateMMField(role);
                    field.addMethod(method);
                }else {
                    mmConcept.otherMethods.add(method);
                }
            }
        });
        addFieldsOfSuperType(mmConcept, ctType.getSuperclass());
        ctType.getSuperInterfaces().forEach(( superIfaceRef) -> addFieldsOfSuperType(mmConcept, superIfaceRef));
    }

    private static java.util.Set<java.lang.String> EXPECTED_TYPES_NOT_IN_CLASSPATH = new java.util.HashSet<>(java.util.Arrays.asList("java.lang.Cloneable", "java.lang.Object", "spoon.processing.FactoryAccessor", "spoon.reflect.visitor.CtVisitable", "spoon.reflect.visitor.chain.CtQueryable", "spoon.template.TemplateParameter", "java.lang.Iterable", "java.io.Serializable"));

    /**
     * add all fields of `superTypeRef` into `mmConcept`
     *
     * @param concept
     * 		sub type
     * @param superTypeRef
     * 		super type
     */
    private void addFieldsOfSuperType(spoon.metamodel.MetamodelConcept concept, spoon.reflect.reference.CtTypeReference<?> superTypeRef) {
        if (superTypeRef == null) {
            return;
        }
        if (spoon.metamodel.Metamodel.EXPECTED_TYPES_NOT_IN_CLASSPATH.contains(superTypeRef.getQualifiedName())) {
            // ignore classes which are not part of spoon model
            return;
        }
        spoon.reflect.declaration.CtType<?> superType = superTypeRef.getTypeDeclaration();
        if (superType == null) {
            throw new spoon.SpoonException((("Cannot create spoon meta model. The class " + (superTypeRef.getQualifiedName())) + " is missing class path"));
        }
        // call getOrCreateConcept recursively for super concepts
        spoon.metamodel.MetamodelConcept superConcept = getOrCreateConcept(superType);
        if (superConcept != concept) {
            concept.addSuperConcept(superConcept);
        }
    }

    static <K, V> V getOrCreate(java.util.Map<K, V> map, K key, java.util.function.Supplier<V> valueCreator) {
        return spoon.metamodel.Metamodel.getOrCreate(map, key, valueCreator, null);
    }

    /**
     *
     *
     * @param initializer
     * 		is called immediately after the value is added to the map
     */
    static <K, V> V getOrCreate(java.util.Map<K, V> map, K key, java.util.function.Supplier<V> valueCreator, java.util.function.Consumer<V> initializer) {
        V value = map.get(key);
        if (value == null) {
            value = valueCreator.get();
            map.put(key, value);
            if (initializer != null) {
                initializer.accept(value);
            }
        }
        return value;
    }

    static <T> boolean addUniqueObject(java.util.Collection<T> col, T o) {
        if (spoon.metamodel.Metamodel.containsObject(col, o)) {
            return false;
        }
        col.add(o);
        return true;
    }

    static boolean containsObject(java.lang.Iterable<? extends java.lang.Object> iter, java.lang.Object o) {
        for (java.lang.Object object : iter) {
            if (object == o) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     *
     * @param method
     * 		a start method
     * @param annotationType
     * 		a searched annotation type
     * @return annotation from the first method in superClass and superInterface hierarchy for the method with required annotationType
     */
    private static <A extends java.lang.annotation.Annotation> spoon.reflect.declaration.CtAnnotation<A> getInheritedAnnotation(spoon.reflect.declaration.CtMethod<?> method, spoon.reflect.reference.CtTypeReference<A> annotationType) {
        spoon.reflect.declaration.CtAnnotation<A> annotation = method.getAnnotation(annotationType);
        if (annotation == null) {
            spoon.reflect.declaration.CtType<?> declType = method.getDeclaringType();
            final spoon.support.visitor.ClassTypingContext ctc = new spoon.support.visitor.ClassTypingContext(declType);
            annotation = declType.map(new spoon.reflect.visitor.filter.AllTypeMembersFunction(spoon.reflect.declaration.CtMethod.class)).map((spoon.reflect.declaration.CtMethod<?> currentMethod) -> {
                if (method == currentMethod) {
                    return null;
                }
                if (ctc.isSameSignature(method, currentMethod)) {
                    spoon.reflect.declaration.CtAnnotation<A> annotation2 = currentMethod.getAnnotation(annotationType);
                    if (annotation2 != null) {
                        return annotation2;
                    }
                }
                return null;
            }).first();
        }
        return annotation;
    }
}

