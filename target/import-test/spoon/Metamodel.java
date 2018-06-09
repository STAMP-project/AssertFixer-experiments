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
package spoon;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
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
import spoon.reflect.meta.ContainerKind;
import spoon.reflect.meta.RoleHandler;
import spoon.reflect.meta.impl.RoleHandlerHelper;
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
import spoon.reflect.visitor.CtScanner;
import spoon.support.DefaultCoreFactory;
import spoon.support.StandardEnvironment;
import spoon.support.reflect.code.CtAnnotationFieldAccessImpl;
import spoon.support.reflect.code.CtArrayReadImpl;
import spoon.support.reflect.code.CtArrayWriteImpl;
import spoon.support.reflect.code.CtAssertImpl;
import spoon.support.reflect.code.CtAssignmentImpl;
import spoon.support.reflect.code.CtBinaryOperatorImpl;
import spoon.support.reflect.code.CtBlockImpl;
import spoon.support.reflect.code.CtBreakImpl;
import spoon.support.reflect.code.CtCaseImpl;
import spoon.support.reflect.code.CtCatchImpl;
import spoon.support.reflect.code.CtCatchVariableImpl;
import spoon.support.reflect.code.CtCodeSnippetExpressionImpl;
import spoon.support.reflect.code.CtCodeSnippetStatementImpl;
import spoon.support.reflect.code.CtCommentImpl;
import spoon.support.reflect.code.CtConditionalImpl;
import spoon.support.reflect.code.CtConstructorCallImpl;
import spoon.support.reflect.code.CtContinueImpl;
import spoon.support.reflect.code.CtDoImpl;
import spoon.support.reflect.code.CtExecutableReferenceExpressionImpl;
import spoon.support.reflect.code.CtFieldReadImpl;
import spoon.support.reflect.code.CtFieldWriteImpl;
import spoon.support.reflect.code.CtForEachImpl;
import spoon.support.reflect.code.CtForImpl;
import spoon.support.reflect.code.CtIfImpl;
import spoon.support.reflect.code.CtInvocationImpl;
import spoon.support.reflect.code.CtJavaDocImpl;
import spoon.support.reflect.code.CtJavaDocTagImpl;
import spoon.support.reflect.code.CtLambdaImpl;
import spoon.support.reflect.code.CtLiteralImpl;
import spoon.support.reflect.code.CtLocalVariableImpl;
import spoon.support.reflect.code.CtNewArrayImpl;
import spoon.support.reflect.code.CtNewClassImpl;
import spoon.support.reflect.code.CtOperatorAssignmentImpl;
import spoon.support.reflect.code.CtReturnImpl;
import spoon.support.reflect.code.CtStatementListImpl;
import spoon.support.reflect.code.CtSuperAccessImpl;
import spoon.support.reflect.code.CtSwitchImpl;
import spoon.support.reflect.code.CtSynchronizedImpl;
import spoon.support.reflect.code.CtThisAccessImpl;
import spoon.support.reflect.code.CtThrowImpl;
import spoon.support.reflect.code.CtTryImpl;
import spoon.support.reflect.code.CtTryWithResourceImpl;
import spoon.support.reflect.code.CtTypeAccessImpl;
import spoon.support.reflect.code.CtUnaryOperatorImpl;
import spoon.support.reflect.code.CtVariableReadImpl;
import spoon.support.reflect.code.CtVariableWriteImpl;
import spoon.support.reflect.code.CtWhileImpl;
import spoon.support.reflect.declaration.CtAnnotationImpl;
import spoon.support.reflect.declaration.CtAnnotationMethodImpl;
import spoon.support.reflect.declaration.CtAnnotationTypeImpl;
import spoon.support.reflect.declaration.CtAnonymousExecutableImpl;
import spoon.support.reflect.declaration.CtClassImpl;
import spoon.support.reflect.declaration.CtConstructorImpl;
import spoon.support.reflect.declaration.CtEnumImpl;
import spoon.support.reflect.declaration.CtEnumValueImpl;
import spoon.support.reflect.declaration.CtFieldImpl;
import spoon.support.reflect.declaration.CtImportImpl;
import spoon.support.reflect.declaration.CtInterfaceImpl;
import spoon.support.reflect.declaration.CtMethodImpl;
import spoon.support.reflect.declaration.CtModuleImpl;
import spoon.support.reflect.declaration.CtModuleRequirementImpl;
import spoon.support.reflect.declaration.CtPackageExportImpl;
import spoon.support.reflect.declaration.CtPackageImpl;
import spoon.support.reflect.declaration.CtParameterImpl;
import spoon.support.reflect.declaration.CtProvidedServiceImpl;
import spoon.support.reflect.declaration.CtTypeParameterImpl;
import spoon.support.reflect.declaration.CtUsedServiceImpl;
import spoon.support.reflect.reference.CtArrayTypeReferenceImpl;
import spoon.support.reflect.reference.CtCatchVariableReferenceImpl;
import spoon.support.reflect.reference.CtExecutableReferenceImpl;
import spoon.support.reflect.reference.CtFieldReferenceImpl;
import spoon.support.reflect.reference.CtIntersectionTypeReferenceImpl;
import spoon.support.reflect.reference.CtLocalVariableReferenceImpl;
import spoon.support.reflect.reference.CtModuleReferenceImpl;
import spoon.support.reflect.reference.CtPackageReferenceImpl;
import spoon.support.reflect.reference.CtParameterReferenceImpl;
import spoon.support.reflect.reference.CtTypeParameterReferenceImpl;
import spoon.support.reflect.reference.CtTypeReferenceImpl;
import spoon.support.reflect.reference.CtUnboundVariableReferenceImpl;
import spoon.support.reflect.reference.CtWildcardReferenceImpl;


/**
 * This class enables to reason on the Spoon metamodel directly
 */
public class Metamodel {
    private Metamodel() {
    }

    /**
     * Returns all interfaces of the Spoon metamodel.
     * This method is stateless for sake of maintenance.
     * If you need to call it several times, you should store the result.
     */
    public static Set<CtType<?>> getAllMetamodelInterfaces() {
        Set<CtType<?>> result = new HashSet<>();
        Factory factory = new FactoryImpl(new DefaultCoreFactory(), new StandardEnvironment());
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

    public static Collection<Metamodel.Type> getAllMetamodelTypes() {
        return Metamodel.typesByName.values();
    }

    public static Metamodel.Type getMetamodelTypeByClass(Class<? extends CtElement> clazz) {
        return Metamodel.typesByClass.get(clazz);
    }

    /**
     * Describes a Spoon metamodel type
     */
    public static class Type {
        /**
         * Name of the type
         */
        private final String name;

        /**
         * The {@link CtClass} linked to this {@link MetamodelConcept}. Is null in case of class without interface
         */
        private final Class<? extends CtElement> modelClass;

        /**
         * The {@link CtInterface} linked to this {@link MetamodelConcept}. Is null in case of interface without class
         */
        private final Class<? extends CtElement> modelInterface;

        private final List<Metamodel.Field> fields;

        private final Map<CtRole, Metamodel.Field> fieldsByRole;

        private Type(String name, Class<? extends CtElement> modelInterface, Class<? extends CtElement> modelClass, Consumer<Metamodel.FieldMaker> fieldsCreator) {
            super();
            this.name = name;
            this.modelClass = modelClass;
            this.modelInterface = modelInterface;
            List<Metamodel.Field> fields = new ArrayList<>();
            this.fields = Collections.unmodifiableList(fields);
            fieldsCreator.accept(new Metamodel.FieldMaker() {
                @Override
                public Metamodel.FieldMaker field(CtRole role, boolean derived, boolean unsettable) {
                    fields.add(new Metamodel.Field(Metamodel.Type.this, role, derived, unsettable));
                    return this;
                }
            });
            Map<CtRole, Metamodel.Field> fieldsByRole = new LinkedHashMap<>(fields.size());
            fields.forEach(( f) -> fieldsByRole.put(f.getRole(), f));
            this.fieldsByRole = Collections.unmodifiableMap(fieldsByRole);
        }

        /**
         *
         *
         * @return interface name of Spoon model type. For example CtClass, CtForEach, ...
         * It is never followed by xxxImpl
         */
        public String getName() {
            return name;
        }

        /**
         *
         *
         * @return {@link Class} which implements this type. For example {@link CtForEachImpl}
         */
        public Class<? extends CtElement> getModelClass() {
            return modelClass;
        }

        /**
         *
         *
         * @return {@link Class} which defines interface of this type. For example {@link CtForEach}
         */
        public Class<? extends CtElement> getModelInterface() {
            return modelInterface;
        }

        @Override
        public String toString() {
            return getName();
        }

        /**
         *
         *
         * @return {@link List} of {@link Field}s of this spoon model {@link Type} in the same order, like they are processed by {@link CtScanner}
         */
        public List<Metamodel.Field> getFields() {
            return fields;
        }

        /**
         *
         *
         * @param role
         * 		the {@link CtRole} of to be returned {@link Field}
         * @return {@link Field} of this {@link Type} by {@link CtRole} or null if this {@link CtRole} doesn't exist on this {@link Type}
         */
        public Metamodel.Field getField(CtRole role) {
            return fieldsByRole.get(role);
        }
    }

    /**
     * Describes a Spoon metamodel Field
     */
    public static class Field {
        private final Metamodel.Type owner;

        private final CtRole role;

        private final RoleHandler roleHandler;

        private final boolean derived;

        private final boolean unsettable;

        private Field(Metamodel.Type owner, CtRole role, boolean derived, boolean unsettable) {
            super();
            this.owner = owner;
            this.role = role;
            this.derived = derived;
            this.unsettable = unsettable;
            this.roleHandler = RoleHandlerHelper.getRoleHandler(owner.modelClass, role);
        }

        /**
         *
         *
         * @return {@link Type}, which contains this {@link Field}
         */
        public Metamodel.Type getOwner() {
            return owner;
        }

        /**
         *
         *
         * @return {@link CtRole} of this {@link Field}
         */
        public CtRole getRole() {
            return role;
        }

        /**
         *
         *
         * @return {@link RoleHandler} providing generic access to the value of this Field
         */
        public RoleHandler getRoleHandler() {
            return roleHandler;
        }

        /**
         *
         *
         * @return true if this field is derived (value is somehow computed)
         */
        public boolean isDerived() {
            return derived;
        }

        /**
         *
         *
         * @return true if it makes no sense to set this field on this type
         */
        public boolean isUnsettable() {
            return unsettable;
        }

        /**
         *
         *
         * @param element
         * 		an instance whose attribute value is read
         * @return a value of attribute defined by this {@link Field} from the provided `element`
         */
        public <T, U> U getValue(T element) {
            return roleHandler.getValue(element);
        }

        /**
         *
         *
         * @param element
         * 		an instance whose attribute value is set
         * @param value
         * 		to be set value of attribute defined by this {@link Field} on the provided `element`
         */
        public <T, U> void setValue(T element, U value) {
            roleHandler.setValue(element, value);
        }

        /**
         *
         *
         * @return {@link Class} of {@link Field}'s value.
         */
        public Class<?> getValueClass() {
            return roleHandler.getValueClass();
        }

        /**
         *
         *
         * @return the container kind, to know whether an element, a list, a map, etc is returned.
         */
        public ContainerKind getContainerKind() {
            return roleHandler.getContainerKind();
        }

        @Override
        public String toString() {
            return ((getOwner().toString()) + "#") + (getRole().getCamelCaseName());
        }
    }

    private interface FieldMaker {
        /**
         * Creates a instance of Field in Type
         *
         * @param role
         * 		a role of the {@link Field}
         * @param derived
         * 		marker if field is derived
         * @param unsettable
         * 		marker if field is unsettable
         * @return this to support fluent API
         */
        Metamodel.FieldMaker field(CtRole role, boolean derived, boolean unsettable);
    }

    private static final Map<String, Metamodel.Type> typesByName = new HashMap<>();

    private static final Map<Class<?>, Metamodel.Type> typesByClass = new HashMap<>();

    static {
        List<Metamodel.Type> types = new ArrayList<>();
        Metamodel.initTypes(types);
        types.forEach(( type) -> {
            Metamodel.typesByName.put(type.getName(), type);
            Metamodel.typesByClass.put(type.getModelClass(), type);
            Metamodel.typesByClass.put(type.getModelInterface(), type);
        });
    }

    private static void initTypes(List<Metamodel.Type> types) {
        /**
         * body of this method was generated by /spoon-core/src/test/java/spoon/generating/MetamodelGenerator.java
         * Run the method main and copy the System output here
         */
        types.add(new Metamodel.Type("CtConditional", CtConditional.class, CtConditionalImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.TYPE, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CONDITION, false, false).field(CtRole.THEN, false, false).field(CtRole.ELSE, false, false).field(CtRole.COMMENT, false, false).field(CtRole.CAST, false, false)));
        types.add(new Metamodel.Type("CtProvidedService", CtProvidedService.class, CtProvidedServiceImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.SERVICE_TYPE, false, false).field(CtRole.IMPLEMENTATION_TYPE, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtParameter", CtParameter.class, CtParameterImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.IS_VARARGS, false, false).field(CtRole.DEFAULT_EXPRESSION, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtWhile", CtWhile.class, CtWhileImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtTypeReference", CtTypeReference.class, CtTypeReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, true, true).field(CtRole.INTERFACE, true, true).field(CtRole.SUPER_TYPE, true, true).field(CtRole.POSITION, false, false).field(CtRole.PACKAGE_REF, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.TYPE_ARGUMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.COMMENT, true, true)));
        types.add(new Metamodel.Type("CtCatchVariableReference", CtCatchVariableReference.class, CtCatchVariableReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, true, true).field(CtRole.TYPE, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtContinue", CtContinue.class, CtContinueImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.TARGET_LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtInterface", CtInterface.class, CtInterfaceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, false, false).field(CtRole.SUPER_TYPE, true, true).field(CtRole.NESTED_TYPE, true, false).field(CtRole.METHOD, true, false).field(CtRole.FIELD, true, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.INTERFACE, false, false).field(CtRole.TYPE_PARAMETER, false, false).field(CtRole.TYPE_MEMBER, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtAssignment", CtAssignment.class, CtAssignmentImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.ASSIGNED, false, false).field(CtRole.ASSIGNMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtBinaryOperator", CtBinaryOperator.class, CtBinaryOperatorImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.OPERATOR_KIND, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.LEFT_OPERAND, false, false).field(CtRole.RIGHT_OPERAND, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtEnumValue", CtEnumValue.class, CtEnumValueImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.ASSIGNMENT, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.DEFAULT_EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtModuleRequirement", CtModuleRequirement.class, CtModuleRequirementImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.MODULE_REF, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtForEach", CtForEach.class, CtForEachImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.FOREACH_VARIABLE, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtConstructor", CtConstructor.class, CtConstructorImpl.class, ( fm) -> fm.field(CtRole.NAME, true, true).field(CtRole.TYPE, true, true).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.PARAMETER, false, false).field(CtRole.THROWN, false, false).field(CtRole.TYPE_PARAMETER, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtSuperAccess", CtSuperAccess.class, CtSuperAccessImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.VARIABLE, false, false)));
        types.add(new Metamodel.Type("CtAnonymousExecutable", CtAnonymousExecutable.class, CtAnonymousExecutableImpl.class, ( fm) -> fm.field(CtRole.NAME, true, true).field(CtRole.TYPE, true, true).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.PARAMETER, true, true).field(CtRole.THROWN, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtComment", CtComment.class, CtCommentImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.COMMENT_CONTENT, false, false).field(CtRole.COMMENT_TYPE, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtWildcardReference", CtWildcardReference.class, CtWildcardReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, true, true).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_UPPER, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, true, true).field(CtRole.COMMENT, true, true).field(CtRole.INTERFACE, true, true).field(CtRole.SUPER_TYPE, true, true).field(CtRole.TYPE_ARGUMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.PACKAGE_REF, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.BOUNDING_TYPE, false, false)));
        types.add(new Metamodel.Type("CtThisAccess", CtThisAccess.class, CtThisAccessImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false)));
        types.add(new Metamodel.Type("CtArrayWrite", CtArrayWrite.class, CtArrayWriteImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtPackageReference", CtPackageReference.class, CtPackageReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtJavaDoc", CtJavaDoc.class, CtJavaDocImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.COMMENT_CONTENT, false, false).field(CtRole.COMMENT_TYPE, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.COMMENT_TAG, false, false)));
        types.add(new Metamodel.Type("CtArrayRead", CtArrayRead.class, CtArrayReadImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtStatementList", CtStatementList.class, CtStatementListImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.STATEMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtVariableWrite", CtVariableWrite.class, CtVariableWriteImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.VARIABLE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtParameterReference", CtParameterReference.class, CtParameterReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.TYPE, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtOperatorAssignment", CtOperatorAssignment.class, CtOperatorAssignmentImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.OPERATOR_KIND, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.ASSIGNED, false, false).field(CtRole.ASSIGNMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtAnnotationFieldAccess", CtAnnotationFieldAccess.class, CtAnnotationFieldAccessImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.VARIABLE, false, false)));
        types.add(new Metamodel.Type("CtUnboundVariableReference", CtUnboundVariableReference.class, CtUnboundVariableReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT, true, true).field(CtRole.ANNOTATION, true, true).field(CtRole.POSITION, false, false).field(CtRole.TYPE, false, false)));
        types.add(new Metamodel.Type("CtAnnotationMethod", CtAnnotationMethod.class, CtAnnotationMethodImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.BODY, true, true).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.IS_DEFAULT, false, false).field(CtRole.PARAMETER, true, true).field(CtRole.THROWN, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.TYPE_PARAMETER, true, true).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.DEFAULT_EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtClass", CtClass.class, CtClassImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.NESTED_TYPE, true, false).field(CtRole.CONSTRUCTOR, true, false).field(CtRole.METHOD, true, false).field(CtRole.ANNONYMOUS_EXECUTABLE, true, false).field(CtRole.FIELD, true, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.SUPER_TYPE, false, false).field(CtRole.INTERFACE, false, false).field(CtRole.TYPE_PARAMETER, false, false).field(CtRole.TYPE_MEMBER, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtBlock", CtBlock.class, CtBlockImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.STATEMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtPackage", CtPackage.class, CtPackageImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.SUB_PACKAGE, false, false).field(CtRole.CONTAINED_TYPE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtTryWithResource", CtTryWithResource.class, CtTryWithResourceImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TRY_RESOURCE, false, false).field(CtRole.BODY, false, false).field(CtRole.CATCH, false, false).field(CtRole.FINALIZER, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtAssert", CtAssert.class, CtAssertImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CONDITION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtSwitch", CtSwitch.class, CtSwitchImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.CASE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtTry", CtTry.class, CtTryImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.BODY, false, false).field(CtRole.CATCH, false, false).field(CtRole.FINALIZER, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtSynchronized", CtSynchronized.class, CtSynchronizedImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtImport", CtImport.class, CtImportImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.IMPORT_REFERENCE, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtTypeParameterReference", CtTypeParameterReference.class, CtTypeParameterReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_UPPER, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, true, true).field(CtRole.COMMENT, true, true).field(CtRole.INTERFACE, true, true).field(CtRole.SUPER_TYPE, true, true).field(CtRole.TYPE_ARGUMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.PACKAGE_REF, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.BOUNDING_TYPE, false, false)));
        types.add(new Metamodel.Type("CtInvocation", CtInvocation.class, CtInvocationImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.TYPE_ARGUMENT, true, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.EXECUTABLE_REF, false, false).field(CtRole.ARGUMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtCodeSnippetExpression", CtCodeSnippetExpression.class, CtCodeSnippetExpressionImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.SNIPPET, false, false).field(CtRole.TYPE, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false)));
        types.add(new Metamodel.Type("CtFieldWrite", CtFieldWrite.class, CtFieldWriteImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.VARIABLE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtUnaryOperator", CtUnaryOperator.class, CtUnaryOperatorImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.OPERATOR_KIND, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtExecutableReference", CtExecutableReference.class, CtExecutableReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_STATIC, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.TYPE, false, false).field(CtRole.ARGUMENT_TYPE, false, false).field(CtRole.TYPE_ARGUMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.COMMENT, true, true)));
        types.add(new Metamodel.Type("CtFor", CtFor.class, CtForImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.FOR_INIT, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.FOR_UPDATE, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtVariableRead", CtVariableRead.class, CtVariableReadImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.VARIABLE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtTypeParameter", CtTypeParameter.class, CtTypeParameterImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, true, true).field(CtRole.INTERFACE, true, true).field(CtRole.TYPE_MEMBER, true, true).field(CtRole.NESTED_TYPE, true, true).field(CtRole.METHOD, true, true).field(CtRole.FIELD, true, true).field(CtRole.TYPE_PARAMETER, true, true).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.SUPER_TYPE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtLocalVariable", CtLocalVariable.class, CtLocalVariableImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.ASSIGNMENT, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.DEFAULT_EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtIf", CtIf.class, CtIfImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CONDITION, false, false).field(CtRole.THEN, false, false).field(CtRole.ELSE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtModule", CtModule.class, CtModuleImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.REQUIRED_MODULE, true, false).field(CtRole.EXPORTED_PACKAGE, true, false).field(CtRole.OPENED_PACKAGE, true, false).field(CtRole.SERVICE_TYPE, true, false).field(CtRole.PROVIDED_SERVICE, true, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.MODULE_DIRECTIVE, false, false).field(CtRole.SUB_PACKAGE, false, false)));
        types.add(new Metamodel.Type("CtPackageExport", CtPackageExport.class, CtPackageExportImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.OPENED_PACKAGE, false, false).field(CtRole.COMMENT, false, false).field(CtRole.PACKAGE_REF, false, false).field(CtRole.MODULE_REF, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtConstructorCall", CtConstructorCall.class, CtConstructorCallImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.TYPE_ARGUMENT, true, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.EXECUTABLE_REF, false, false).field(CtRole.TARGET, false, false).field(CtRole.ARGUMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtCase", CtCase.class, CtCaseImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.STATEMENT, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtModuleReference", CtModuleReference.class, CtModuleReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtCatch", CtCatch.class, CtCatchImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.PARAMETER, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtArrayTypeReference", CtArrayTypeReference.class, CtArrayTypeReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, true, true).field(CtRole.INTERFACE, true, true).field(CtRole.SUPER_TYPE, true, true).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, true, true).field(CtRole.PACKAGE_REF, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.TYPE, false, false).field(CtRole.TYPE_ARGUMENT, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtMethod", CtMethod.class, CtMethodImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.IS_DEFAULT, false, false).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE_PARAMETER, false, false).field(CtRole.TYPE, false, false).field(CtRole.PARAMETER, false, false).field(CtRole.THROWN, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtLambda", CtLambda.class, CtLambdaImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.PARAMETER, false, false).field(CtRole.THROWN, true, true).field(CtRole.BODY, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtNewArray", CtNewArray.class, CtNewArrayImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.DIMENSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtUsedService", CtUsedService.class, CtUsedServiceImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.SERVICE_TYPE, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtIntersectionTypeReference", CtIntersectionTypeReference.class, CtIntersectionTypeReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, true, true).field(CtRole.COMMENT, true, true).field(CtRole.INTERFACE, true, true).field(CtRole.SUPER_TYPE, true, true).field(CtRole.POSITION, false, false).field(CtRole.PACKAGE_REF, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.TYPE_ARGUMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.BOUND, false, false)));
        types.add(new Metamodel.Type("CtThrow", CtThrow.class, CtThrowImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtLiteral", CtLiteral.class, CtLiteralImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.VALUE, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtReturn", CtReturn.class, CtReturnImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtJavaDocTag", CtJavaDocTag.class, CtJavaDocTagImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT_CONTENT, false, false).field(CtRole.DOCUMENTATION_TYPE, false, false).field(CtRole.JAVADOC_TAG_VALUE, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtField", CtField.class, CtFieldImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.ASSIGNMENT, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.DEFAULT_EXPRESSION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtTypeAccess", CtTypeAccess.class, CtTypeAccessImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, true).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.ACCESSED_TYPE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtCodeSnippetStatement", CtCodeSnippetStatement.class, CtCodeSnippetStatementImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.SNIPPET, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtDo", CtDo.class, CtDoImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.EXPRESSION, false, false).field(CtRole.BODY, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtAnnotation", CtAnnotation.class, CtAnnotationImpl.class, ( fm) -> fm.field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.CAST, true, true).field(CtRole.POSITION, false, false).field(CtRole.TYPE, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION_TYPE, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.VALUE, false, false)));
        types.add(new Metamodel.Type("CtFieldRead", CtFieldRead.class, CtFieldReadImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.TARGET, false, false).field(CtRole.VARIABLE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtBreak", CtBreak.class, CtBreakImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.TARGET_LABEL, false, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtFieldReference", CtFieldReference.class, CtFieldReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_FINAL, false, false).field(CtRole.IS_STATIC, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.DECLARING_TYPE, false, false).field(CtRole.TYPE, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtEnum", CtEnum.class, CtEnumImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.SUPER_TYPE, true, true).field(CtRole.NESTED_TYPE, true, false).field(CtRole.CONSTRUCTOR, true, false).field(CtRole.METHOD, true, false).field(CtRole.ANNONYMOUS_EXECUTABLE, true, false).field(CtRole.FIELD, true, false).field(CtRole.TYPE_PARAMETER, true, true).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.INTERFACE, false, false).field(CtRole.TYPE_MEMBER, false, false).field(CtRole.VALUE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtNewClass", CtNewClass.class, CtNewClassImpl.class, ( fm) -> fm.field(CtRole.TYPE, true, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.LABEL, false, false).field(CtRole.TYPE_ARGUMENT, true, false).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.CAST, false, false).field(CtRole.EXECUTABLE_REF, false, false).field(CtRole.TARGET, false, false).field(CtRole.ARGUMENT, false, false).field(CtRole.NESTED_TYPE, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtLocalVariableReference", CtLocalVariableReference.class, CtLocalVariableReferenceImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.COMMENT, true, true).field(CtRole.POSITION, false, false).field(CtRole.TYPE, false, false).field(CtRole.ANNOTATION, false, false)));
        types.add(new Metamodel.Type("CtAnnotationType", CtAnnotationType.class, CtAnnotationTypeImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.IS_SHADOW, false, false).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.MODIFIER, false, false).field(CtRole.INTERFACE, true, true).field(CtRole.SUPER_TYPE, true, true).field(CtRole.NESTED_TYPE, true, false).field(CtRole.METHOD, true, false).field(CtRole.FIELD, true, false).field(CtRole.TYPE_PARAMETER, true, true).field(CtRole.POSITION, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE_MEMBER, false, false).field(CtRole.COMMENT, false, false)));
        types.add(new Metamodel.Type("CtCatchVariable", CtCatchVariable.class, CtCatchVariableImpl.class, ( fm) -> fm.field(CtRole.NAME, false, false).field(CtRole.TYPE, true, true).field(CtRole.IS_IMPLICIT, false, false).field(CtRole.DEFAULT_EXPRESSION, true, true).field(CtRole.MODIFIER, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.MULTI_TYPE, false, false)));
        types.add(new Metamodel.Type("CtExecutableReferenceExpression", CtExecutableReferenceExpression.class, CtExecutableReferenceExpressionImpl.class, ( fm) -> fm.field(CtRole.IS_IMPLICIT, false, false).field(CtRole.POSITION, false, false).field(CtRole.COMMENT, false, false).field(CtRole.ANNOTATION, false, false).field(CtRole.TYPE, false, false).field(CtRole.CAST, false, false).field(CtRole.EXECUTABLE_REF, false, false).field(CtRole.TARGET, false, false)));
    }
}

