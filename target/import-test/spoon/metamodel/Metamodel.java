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


import java.io.File;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import spoon.Launcher;
import spoon.SpoonException;
import spoon.reflect.annotations.PropertyGetter;
import spoon.reflect.annotations.PropertySetter;
import spoon.reflect.code.BinaryOperatorKind;
import spoon.reflect.code.CtAbstractInvocation;
import spoon.reflect.code.CtAnnotationFieldAccess;
import spoon.reflect.code.CtArrayAccess;
import spoon.reflect.code.CtArrayRead;
import spoon.reflect.code.CtArrayWrite;
import spoon.reflect.code.CtAssert;
import spoon.reflect.code.CtAssignment;
import spoon.reflect.code.CtBinaryOperator;
import spoon.reflect.code.CtBlock;
import spoon.reflect.code.CtBodyHolder;
import spoon.reflect.code.CtBreak;
import spoon.reflect.code.CtCFlowBreak;
import spoon.reflect.code.CtCase;
import spoon.reflect.code.CtCatch;
import spoon.reflect.code.CtCatchVariable;
import spoon.reflect.code.CtCodeElement;
import spoon.reflect.code.CtCodeSnippetExpression;
import spoon.reflect.code.CtCodeSnippetStatement;
import spoon.reflect.code.CtComment;
import spoon.reflect.code.CtConditional;
import spoon.reflect.code.CtConstructorCall;
import spoon.reflect.code.CtContinue;
import spoon.reflect.code.CtDo;
import spoon.reflect.code.CtExecutableReferenceExpression;
import spoon.reflect.code.CtExpression;
import spoon.reflect.code.CtFieldAccess;
import spoon.reflect.code.CtFieldRead;
import spoon.reflect.code.CtFieldWrite;
import spoon.reflect.code.CtFor;
import spoon.reflect.code.CtForEach;
import spoon.reflect.code.CtIf;
import spoon.reflect.code.CtInvocation;
import spoon.reflect.code.CtJavaDoc;
import spoon.reflect.code.CtJavaDocTag;
import spoon.reflect.code.CtLabelledFlowBreak;
import spoon.reflect.code.CtLambda;
import spoon.reflect.code.CtLiteral;
import spoon.reflect.code.CtLocalVariable;
import spoon.reflect.code.CtLoop;
import spoon.reflect.code.CtNewArray;
import spoon.reflect.code.CtNewClass;
import spoon.reflect.code.CtOperatorAssignment;
import spoon.reflect.code.CtRHSReceiver;
import spoon.reflect.code.CtReturn;
import spoon.reflect.code.CtStatement;
import spoon.reflect.code.CtStatementList;
import spoon.reflect.code.CtSuperAccess;
import spoon.reflect.code.CtSwitch;
import spoon.reflect.code.CtSynchronized;
import spoon.reflect.code.CtTargetedExpression;
import spoon.reflect.code.CtThisAccess;
import spoon.reflect.code.CtThrow;
import spoon.reflect.code.CtTry;
import spoon.reflect.code.CtTryWithResource;
import spoon.reflect.code.CtTypeAccess;
import spoon.reflect.code.CtUnaryOperator;
import spoon.reflect.code.CtVariableAccess;
import spoon.reflect.code.CtVariableRead;
import spoon.reflect.code.CtVariableWrite;
import spoon.reflect.code.CtWhile;
import spoon.reflect.code.UnaryOperatorKind;
import spoon.reflect.declaration.CtAnnotatedElementType;
import spoon.reflect.declaration.CtAnnotation;
import spoon.reflect.declaration.CtAnnotationMethod;
import spoon.reflect.declaration.CtAnnotationType;
import spoon.reflect.declaration.CtAnonymousExecutable;
import spoon.reflect.declaration.CtClass;
import spoon.reflect.declaration.CtCodeSnippet;
import spoon.reflect.declaration.CtConstructor;
import spoon.reflect.declaration.CtElement;
import spoon.reflect.declaration.CtEnum;
import spoon.reflect.declaration.CtEnumValue;
import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtField;
import spoon.reflect.declaration.CtFormalTypeDeclarer;
import spoon.reflect.declaration.CtImport;
import spoon.reflect.declaration.CtImportKind;
import spoon.reflect.declaration.CtInterface;
import spoon.reflect.declaration.CtMethod;
import spoon.reflect.declaration.CtModifiable;
import spoon.reflect.declaration.CtModule;
import spoon.reflect.declaration.CtModuleDirective;
import spoon.reflect.declaration.CtModuleRequirement;
import spoon.reflect.declaration.CtMultiTypedElement;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtPackageExport;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.declaration.CtProvidedService;
import spoon.reflect.declaration.CtShadowable;
import spoon.reflect.declaration.CtType;
import spoon.reflect.declaration.CtTypeInformation;
import spoon.reflect.declaration.CtTypeMember;
import spoon.reflect.declaration.CtTypeParameter;
import spoon.reflect.declaration.CtTypedElement;
import spoon.reflect.declaration.CtUsedService;
import spoon.reflect.declaration.CtVariable;
import spoon.reflect.declaration.ModifierKind;
import spoon.reflect.declaration.ParentNotInitializedException;
import spoon.reflect.factory.Factory;
import spoon.reflect.factory.FactoryImpl;
import spoon.reflect.path.CtRole;
import spoon.reflect.reference.CtActualTypeContainer;
import spoon.reflect.reference.CtArrayTypeReference;
import spoon.reflect.reference.CtCatchVariableReference;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtIntersectionTypeReference;
import spoon.reflect.reference.CtLocalVariableReference;
import spoon.reflect.reference.CtModuleReference;
import spoon.reflect.reference.CtPackageReference;
import spoon.reflect.reference.CtParameterReference;
import spoon.reflect.reference.CtReference;
import spoon.reflect.reference.CtTypeParameterReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.reference.CtUnboundVariableReference;
import spoon.reflect.reference.CtVariableReference;
import spoon.reflect.reference.CtWildcardReference;
import spoon.reflect.visitor.chain.CtConsumer;
import spoon.reflect.visitor.chain.CtFunction;
import spoon.reflect.visitor.filter.AllTypeMembersFunction;
import spoon.reflect.visitor.filter.TypeFilter;
import spoon.support.DefaultCoreFactory;
import spoon.support.StandardEnvironment;
import spoon.support.compiler.FileSystemFolder;
import spoon.support.visitor.ClassTypingContext;


/**
 * Represents the Spoon metamodel (incl. at runtime)
 */
public class Metamodel {
    /**
     * Returns all interfaces of the Spoon metamodel.
     * This method is stateless for sake of maintenance.
     * If you need to call it several times, you should store the result.
     */
    public static Set<CtType<?>> getAllMetamodelInterfaces() {
        Set<CtType<?>> result = new HashSet<>();
        Factory factory = new FactoryImpl(new DefaultCoreFactory(), new StandardEnvironment());
        // avoid debug messages: Some annotations might be unreachable from the shadow element:
        // which causes bad meta model creation performance
        factory.getEnvironment().setLevel("INFO");
        result.add(factory.Type().get(BinaryOperatorKind.class));
        result.add(factory.Type().get(CtAbstractInvocation.class));
        result.add(factory.Type().get(CtAnnotationFieldAccess.class));
        result.add(factory.Type().get(CtArrayAccess.class));
        result.add(factory.Type().get(CtArrayRead.class));
        result.add(factory.Type().get(CtArrayWrite.class));
        result.add(factory.Type().get(CtAssert.class));
        result.add(factory.Type().get(CtAssignment.class));
        result.add(factory.Type().get(CtBinaryOperator.class));
        result.add(factory.Type().get(CtBlock.class));
        result.add(factory.Type().get(CtBodyHolder.class));
        result.add(factory.Type().get(CtBreak.class));
        result.add(factory.Type().get(CtCFlowBreak.class));
        result.add(factory.Type().get(CtCase.class));
        result.add(factory.Type().get(CtCatch.class));
        result.add(factory.Type().get(CtCatchVariable.class));
        result.add(factory.Type().get(CtCodeElement.class));
        result.add(factory.Type().get(CtCodeSnippetExpression.class));
        result.add(factory.Type().get(CtCodeSnippetStatement.class));
        result.add(factory.Type().get(CtComment.class));
        result.add(factory.Type().get(CtConditional.class));
        result.add(factory.Type().get(CtConstructorCall.class));
        result.add(factory.Type().get(CtContinue.class));
        result.add(factory.Type().get(CtDo.class));
        result.add(factory.Type().get(CtExecutableReferenceExpression.class));
        result.add(factory.Type().get(CtExpression.class));
        result.add(factory.Type().get(CtFieldAccess.class));
        result.add(factory.Type().get(CtFieldRead.class));
        result.add(factory.Type().get(CtFieldWrite.class));
        result.add(factory.Type().get(CtFor.class));
        result.add(factory.Type().get(CtForEach.class));
        result.add(factory.Type().get(CtIf.class));
        result.add(factory.Type().get(CtInvocation.class));
        result.add(factory.Type().get(CtJavaDoc.class));
        result.add(factory.Type().get(CtJavaDocTag.class));
        result.add(factory.Type().get(CtLabelledFlowBreak.class));
        result.add(factory.Type().get(CtLambda.class));
        result.add(factory.Type().get(CtLiteral.class));
        result.add(factory.Type().get(CtLocalVariable.class));
        result.add(factory.Type().get(CtLoop.class));
        result.add(factory.Type().get(CtNewArray.class));
        result.add(factory.Type().get(CtNewClass.class));
        result.add(factory.Type().get(CtOperatorAssignment.class));
        result.add(factory.Type().get(CtRHSReceiver.class));
        result.add(factory.Type().get(CtReturn.class));
        result.add(factory.Type().get(CtStatement.class));
        result.add(factory.Type().get(CtStatementList.class));
        result.add(factory.Type().get(CtSuperAccess.class));
        result.add(factory.Type().get(CtSwitch.class));
        result.add(factory.Type().get(CtSynchronized.class));
        result.add(factory.Type().get(CtTargetedExpression.class));
        result.add(factory.Type().get(CtThisAccess.class));
        result.add(factory.Type().get(CtThrow.class));
        result.add(factory.Type().get(CtTry.class));
        result.add(factory.Type().get(CtTryWithResource.class));
        result.add(factory.Type().get(CtTypeAccess.class));
        result.add(factory.Type().get(CtUnaryOperator.class));
        result.add(factory.Type().get(CtVariableAccess.class));
        result.add(factory.Type().get(CtVariableRead.class));
        result.add(factory.Type().get(CtVariableWrite.class));
        result.add(factory.Type().get(CtWhile.class));
        result.add(factory.Type().get(UnaryOperatorKind.class));
        result.add(factory.Type().get(CtAnnotatedElementType.class));
        result.add(factory.Type().get(CtAnnotation.class));
        result.add(factory.Type().get(CtAnnotationMethod.class));
        result.add(factory.Type().get(CtAnnotationType.class));
        result.add(factory.Type().get(CtAnonymousExecutable.class));
        result.add(factory.Type().get(CtClass.class));
        result.add(factory.Type().get(CtCodeSnippet.class));
        result.add(factory.Type().get(CtConstructor.class));
        result.add(factory.Type().get(CtElement.class));
        result.add(factory.Type().get(CtEnum.class));
        result.add(factory.Type().get(CtEnumValue.class));
        result.add(factory.Type().get(CtExecutable.class));
        result.add(factory.Type().get(CtField.class));
        result.add(factory.Type().get(CtFormalTypeDeclarer.class));
        result.add(factory.Type().get(CtInterface.class));
        result.add(factory.Type().get(CtMethod.class));
        result.add(factory.Type().get(CtModifiable.class));
        result.add(factory.Type().get(CtMultiTypedElement.class));
        result.add(factory.Type().get(CtNamedElement.class));
        result.add(factory.Type().get(CtPackage.class));
        result.add(factory.Type().get(CtParameter.class));
        result.add(factory.Type().get(CtShadowable.class));
        result.add(factory.Type().get(CtType.class));
        result.add(factory.Type().get(CtTypeInformation.class));
        result.add(factory.Type().get(CtTypeMember.class));
        result.add(factory.Type().get(CtTypeParameter.class));
        result.add(factory.Type().get(CtTypedElement.class));
        result.add(factory.Type().get(CtVariable.class));
        result.add(factory.Type().get(ModifierKind.class));
        result.add(factory.Type().get(ParentNotInitializedException.class));
        result.add(factory.Type().get(CtActualTypeContainer.class));
        result.add(factory.Type().get(CtArrayTypeReference.class));
        result.add(factory.Type().get(CtCatchVariableReference.class));
        result.add(factory.Type().get(CtExecutableReference.class));
        result.add(factory.Type().get(CtFieldReference.class));
        result.add(factory.Type().get(CtIntersectionTypeReference.class));
        result.add(factory.Type().get(CtLocalVariableReference.class));
        result.add(factory.Type().get(CtPackageReference.class));
        result.add(factory.Type().get(CtParameterReference.class));
        result.add(factory.Type().get(CtReference.class));
        result.add(factory.Type().get(CtTypeParameterReference.class));
        result.add(factory.Type().get(CtTypeReference.class));
        result.add(factory.Type().get(CtUnboundVariableReference.class));
        result.add(factory.Type().get(CtVariableReference.class));
        result.add(factory.Type().get(CtWildcardReference.class));
        result.add(factory.Type().get(CtImport.class));
        result.add(factory.Type().get(CtImportKind.class));
        result.add(factory.Type().get(CtModule.class));
        result.add(factory.Type().get(CtModuleRequirement.class));
        result.add(factory.Type().get(CtPackageExport.class));
        result.add(factory.Type().get(CtProvidedService.class));
        result.add(factory.Type().get(CtModuleReference.class));
        result.add(factory.Type().get(CtUsedService.class));
        result.add(factory.Type().get(CtModuleDirective.class));
        return result;
    }

    private static final String CLASS_SUFFIX = "Impl";

    /**
     * qualified names of packages which contains interfaces of spoon model
     */
    public static final Set<String> MODEL_IFACE_PACKAGES = new HashSet<>(Arrays.asList("spoon.reflect.code", "spoon.reflect.declaration", "spoon.reflect.reference"));

    /**
     * {@link MetamodelConcept}s by name
     */
    private final Map<String, MetamodelConcept> nameToConcept = new HashMap<>();

    private static Metamodel instance;

    /**
     *
     *
     * @return Spoon {@link Metamodel}, which is built once and then returns cached version
     */
    public static Metamodel getInstance() {
        if ((Metamodel.instance) == null) {
            Metamodel.instance = new Metamodel();
        }
        return Metamodel.instance;
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
    public Metamodel(File spoonJavaSourcesDirectory) {
        this(Metamodel.createFactory(spoonJavaSourcesDirectory));
    }

    /**
     *
     *
     * @param factory
     * 		already loaded factory with all Spoon model types
     */
    private Metamodel(Factory factory) {
        for (String apiPackage : Metamodel.MODEL_IFACE_PACKAGES) {
            if ((factory.Package().get(apiPackage)) == null) {
                throw new SpoonException(("Spoon Factory model is missing API package " + apiPackage));
            }
            String implPackage = Metamodel.replaceApiToImplPackage(apiPackage);
            if ((factory.Package().get(implPackage)) == null) {
                throw new SpoonException(("Spoon Factory model is missing implementation package " + implPackage));
            }
        }
        // search for all interfaces of spoon model and create MetamodelConcepts for them
        factory.getModel().filterChildren(new TypeFilter<>(CtInterface.class)).forEach((CtInterface<?> iface) -> {
            if (Metamodel.MODEL_IFACE_PACKAGES.contains(iface.getPackage().getQualifiedName())) {
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
        for (CtType<?> iface : Metamodel.getAllMetamodelInterfaces()) {
            if (iface instanceof CtInterface) {
                getOrCreateConcept(iface);
            }
        }
    }

    /**
     *
     *
     * @return all {@link MetamodelConcept}s of spoon meta model
     */
    public Collection<MetamodelConcept> getConcepts() {
        return Collections.unmodifiableCollection(nameToConcept.values());
    }

    /**
     *
     *
     * @return List of Spoon model interfaces, which represents instantiable leafs of Spoon metamodel
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<CtType<? extends CtElement>> getAllInstantiableMetamodelInterfaces() {
        List<CtType<? extends CtElement>> result = new ArrayList<>();
        for (MetamodelConcept mmConcept : getConcepts()) {
            if ((mmConcept.getKind()) == (ConceptKind.LEAF)) {
                result.add(((CtType) (mmConcept.getMetamodelInterface())));
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
    public static String getConceptName(CtType<?> type) {
        String name = type.getSimpleName();
        if (name.endsWith(Metamodel.CLASS_SUFFIX)) {
            name = name.substring(0, ((name.length()) - (Metamodel.CLASS_SUFFIX.length())));
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
    public static CtClass<?> getImplementationOfInterface(CtInterface<?> iface) {
        String impl = (Metamodel.replaceApiToImplPackage(iface.getQualifiedName())) + (Metamodel.CLASS_SUFFIX);
        return ((CtClass<?>) (Metamodel.getType(impl, iface)));
    }

    /**
     *
     *
     * @param impl
     * 		the implementation class of a Spoon element
     * @return {@link CtInterface} of Spoon model which represents API of the spoon model class. null if there is no implementation.
     */
    public static CtInterface<?> getInterfaceOfImplementation(CtClass<?> impl) {
        String iface = impl.getQualifiedName();
        if (((iface.endsWith(Metamodel.CLASS_SUFFIX)) == false) || ((iface.startsWith("spoon.support.reflect.")) == false)) {
            throw new SpoonException(("Unexpected spoon model implementation class: " + (impl.getQualifiedName())));
        }
        iface = iface.substring(0, ((iface.length()) - (Metamodel.CLASS_SUFFIX.length())));
        iface = iface.replace("spoon.support.reflect", "spoon.reflect");
        return ((CtInterface<?>) (Metamodel.getType(iface, impl)));
    }

    /**
     *
     *
     * @param method
     * 		to be checked method
     * @return {@link CtRole} of spoon model method. Looking into all super class/interface implementations of this method
     */
    public static CtRole getRoleOfMethod(CtMethod<?> method) {
        Factory f = method.getFactory();
        CtAnnotation<PropertyGetter> getter = Metamodel.getInheritedAnnotation(method, f.createCtTypeReference(PropertyGetter.class));
        if (getter != null) {
            return getter.getActualAnnotation().role();
        }
        CtAnnotation<PropertySetter> setter = Metamodel.getInheritedAnnotation(method, f.createCtTypeReference(PropertySetter.class));
        if (setter != null) {
            return setter.getActualAnnotation().role();
        }
        return null;
    }

    private static CtType<?> getType(String qualifiedName, CtElement anElement) {
        Class aClass;
        try {
            aClass = anElement.getClass().getClassLoader().loadClass(qualifiedName);
        } catch (ClassNotFoundException e) {
            // OK, that interface has no implementation class
            return null;
        }
        return anElement.getFactory().Type().get(aClass);
    }

    private static final String modelApiPackage = "spoon.reflect";

    private static final String modelApiImplPackage = "spoon.support.reflect";

    private static String replaceApiToImplPackage(String modelInterfaceQName) {
        if ((modelInterfaceQName.startsWith(Metamodel.modelApiPackage)) == false) {
            throw new SpoonException(((("The qualified name " + modelInterfaceQName) + " doesn't belong to Spoon model API package: ") + (Metamodel.modelApiPackage)));
        }
        return (Metamodel.modelApiImplPackage) + (modelInterfaceQName.substring(Metamodel.modelApiPackage.length()));
    }

    private static Factory createFactory(File spoonJavaSourcesDirectory) {
        final Launcher launcher = new Launcher();
        launcher.getEnvironment().setNoClasspath(true);
        launcher.getEnvironment().setCommentEnabled(true);
        // // Spoon model interfaces
        Arrays.asList("spoon/reflect/code", "spoon/reflect/declaration", "spoon/reflect/reference", "spoon/support/reflect/declaration", "spoon/support/reflect/code", "spoon/support/reflect/reference").forEach(( path) -> {
            launcher.addInputResource(new FileSystemFolder(new File(spoonJavaSourcesDirectory, path)));
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
    private MetamodelConcept getOrCreateConcept(CtType<?> type) {
        String conceptName = Metamodel.getConceptName(type);
        return Metamodel.getOrCreate(nameToConcept, conceptName, () -> new MetamodelConcept(conceptName), ( mmConcept) -> initializeConcept(type, mmConcept));
    }

    /**
     * is called once for each {@link MetamodelConcept}, to initialize it.
     *
     * @param type
     * 		a class or inteface of the spoon model element
     * @param mmConcept
     * 		to be initialize {@link MetamodelConcept}
     */
    private void initializeConcept(CtType<?> type, MetamodelConcept mmConcept) {
        // it is not initialized yet. Do it now
        if (type instanceof CtInterface<?>) {
            CtInterface<?> iface = ((CtInterface<?>) (type));
            mmConcept.setModelClass(Metamodel.getImplementationOfInterface(iface));
            mmConcept.setModelInterface(iface);
        }else
            if (type instanceof CtClass<?>) {
                CtClass<?> clazz = ((CtClass<?>) (type));
                mmConcept.setModelClass(clazz);
                mmConcept.setModelInterface(Metamodel.getInterfaceOfImplementation(clazz));
            }else {
                throw new SpoonException(("Unexpected spoon model type: " + (type.getQualifiedName())));
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
    private void addFieldsOfType(MetamodelConcept mmConcept, CtType<?> ctType) {
        ctType.getTypeMembers().forEach(( typeMember) -> {
            if (typeMember instanceof CtMethod<?>) {
                CtMethod<?> method = ((CtMethod<?>) (typeMember));
                CtRole role = Metamodel.getRoleOfMethod(method);
                if (role != null) {
                    MetamodelProperty field = mmConcept.getOrCreateMMField(role);
                    field.addMethod(method);
                }else {
                    mmConcept.otherMethods.add(method);
                }
            }
        });
        addFieldsOfSuperType(mmConcept, ctType.getSuperclass());
        ctType.getSuperInterfaces().forEach(( superIfaceRef) -> addFieldsOfSuperType(mmConcept, superIfaceRef));
    }

    private static Set<String> EXPECTED_TYPES_NOT_IN_CLASSPATH = new HashSet<>(Arrays.asList("java.lang.Cloneable", "java.lang.Object", "spoon.processing.FactoryAccessor", "spoon.reflect.visitor.CtVisitable", "spoon.reflect.visitor.chain.CtQueryable", "spoon.template.TemplateParameter", "java.lang.Iterable", "java.io.Serializable"));

    /**
     * add all fields of `superTypeRef` into `mmConcept`
     *
     * @param concept
     * 		sub type
     * @param superTypeRef
     * 		super type
     */
    private void addFieldsOfSuperType(MetamodelConcept concept, CtTypeReference<?> superTypeRef) {
        if (superTypeRef == null) {
            return;
        }
        if (Metamodel.EXPECTED_TYPES_NOT_IN_CLASSPATH.contains(superTypeRef.getQualifiedName())) {
            // ignore classes which are not part of spoon model
            return;
        }
        CtType<?> superType = superTypeRef.getTypeDeclaration();
        if (superType == null) {
            throw new SpoonException((("Cannot create spoon meta model. The class " + (superTypeRef.getQualifiedName())) + " is missing class path"));
        }
        // call getOrCreateConcept recursively for super concepts
        MetamodelConcept superConcept = getOrCreateConcept(superType);
        if (superConcept != concept) {
            concept.addSuperConcept(superConcept);
        }
    }

    static <K, V> V getOrCreate(Map<K, V> map, K key, Supplier<V> valueCreator) {
        return Metamodel.getOrCreate(map, key, valueCreator, null);
    }

    /**
     *
     *
     * @param initializer
     * 		is called immediately after the value is added to the map
     */
    static <K, V> V getOrCreate(Map<K, V> map, K key, Supplier<V> valueCreator, Consumer<V> initializer) {
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

    static <T> boolean addUniqueObject(Collection<T> col, T o) {
        if (Metamodel.containsObject(col, o)) {
            return false;
        }
        col.add(o);
        return true;
    }

    static boolean containsObject(Iterable<? extends Object> iter, Object o) {
        for (Object object : iter) {
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
    private static <A extends Annotation> CtAnnotation<A> getInheritedAnnotation(CtMethod<?> method, CtTypeReference<A> annotationType) {
        CtAnnotation<A> annotation = method.getAnnotation(annotationType);
        if (annotation == null) {
            CtType<?> declType = method.getDeclaringType();
            final ClassTypingContext ctc = new ClassTypingContext(declType);
            annotation = declType.map(new AllTypeMembersFunction(CtMethod.class)).map((CtMethod<?> currentMethod) -> {
                if (method == currentMethod) {
                    return null;
                }
                if (ctc.isSameSignature(method, currentMethod)) {
                    CtAnnotation<A> annotation2 = currentMethod.getAnnotation(annotationType);
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

