package com.antwerkz.kibble

import com.antwerkz.kibble.KibbleVisitor.CallBlock.SuperCallBlock
import com.antwerkz.kibble.KibbleVisitor.CallBlock.ThisCallBlock
import com.antwerkz.kibble.KibbleVisitor.ClassType.ENUM
import com.antwerkz.kibble.KibbleVisitor.ClassType.INTERFACE
import com.antwerkz.kibble.model.KibbleType
import com.antwerkz.kibble.model.Modality
import com.antwerkz.kibble.model.Modality.FINAL
import com.antwerkz.kibble.model.SuperCall
import com.antwerkz.kibble.model.TypeParameter
import com.antwerkz.kibble.model.TypeParameterVariance
import com.antwerkz.kibble.model.Visibility
import com.antwerkz.kibble.model.Visibility.PUBLIC
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.ParameterizedTypeName
import com.squareup.kotlinpoet.ParameterizedTypeName.Companion.parameterizedBy
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.PropertySpec.Builder
import com.squareup.kotlinpoet.TypeName
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.TypeVariableName
import org.jetbrains.kotlin.com.intellij.psi.PsiElement
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtModifierKeywordToken
import org.jetbrains.kotlin.lexer.KtSingleValueToken
import org.jetbrains.kotlin.psi.KtAnnotatedExpression
import org.jetbrains.kotlin.psi.KtAnnotation
import org.jetbrains.kotlin.psi.KtAnnotationEntry
import org.jetbrains.kotlin.psi.KtAnnotationUseSiteTarget
import org.jetbrains.kotlin.psi.KtAnonymousInitializer
import org.jetbrains.kotlin.psi.KtArrayAccessExpression
import org.jetbrains.kotlin.psi.KtBinaryExpression
import org.jetbrains.kotlin.psi.KtBinaryExpressionWithTypeRHS
import org.jetbrains.kotlin.psi.KtBlockExpression
import org.jetbrains.kotlin.psi.KtBlockStringTemplateEntry
import org.jetbrains.kotlin.psi.KtBreakExpression
import org.jetbrains.kotlin.psi.KtCallExpression
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtCatchClause
import org.jetbrains.kotlin.psi.KtClass
import org.jetbrains.kotlin.psi.KtClassBody
import org.jetbrains.kotlin.psi.KtClassInitializer
import org.jetbrains.kotlin.psi.KtClassLiteralExpression
import org.jetbrains.kotlin.psi.KtClassOrObject
import org.jetbrains.kotlin.psi.KtCollectionLiteralExpression
import org.jetbrains.kotlin.psi.KtConstantExpression
import org.jetbrains.kotlin.psi.KtConstructorCalleeExpression
import org.jetbrains.kotlin.psi.KtConstructorDelegationCall
import org.jetbrains.kotlin.psi.KtConstructorDelegationReferenceExpression
import org.jetbrains.kotlin.psi.KtContinueExpression
import org.jetbrains.kotlin.psi.KtDeclaration
import org.jetbrains.kotlin.psi.KtDelegatedSuperTypeEntry
import org.jetbrains.kotlin.psi.KtDestructuringDeclaration
import org.jetbrains.kotlin.psi.KtDestructuringDeclarationEntry
import org.jetbrains.kotlin.psi.KtDoWhileExpression
import org.jetbrains.kotlin.psi.KtDotQualifiedExpression
import org.jetbrains.kotlin.psi.KtDoubleColonExpression
import org.jetbrains.kotlin.psi.KtDynamicType
import org.jetbrains.kotlin.psi.KtElement
import org.jetbrains.kotlin.psi.KtEnumEntry
import org.jetbrains.kotlin.psi.KtEscapeStringTemplateEntry
import org.jetbrains.kotlin.psi.KtExpression
import org.jetbrains.kotlin.psi.KtExpressionWithLabel
import org.jetbrains.kotlin.psi.KtFile
import org.jetbrains.kotlin.psi.KtFileAnnotationList
import org.jetbrains.kotlin.psi.KtFinallySection
import org.jetbrains.kotlin.psi.KtForExpression
import org.jetbrains.kotlin.psi.KtFunctionType
import org.jetbrains.kotlin.psi.KtIfExpression
import org.jetbrains.kotlin.psi.KtImportAlias
import org.jetbrains.kotlin.psi.KtImportDirective
import org.jetbrains.kotlin.psi.KtImportList
import org.jetbrains.kotlin.psi.KtInitializerList
import org.jetbrains.kotlin.psi.KtIsExpression
import org.jetbrains.kotlin.psi.KtLabeledExpression
import org.jetbrains.kotlin.psi.KtLambdaExpression
import org.jetbrains.kotlin.psi.KtLiteralStringTemplateEntry
import org.jetbrains.kotlin.psi.KtLoopExpression
import org.jetbrains.kotlin.psi.KtModifierList
import org.jetbrains.kotlin.psi.KtModifierListOwner
import org.jetbrains.kotlin.psi.KtNamedDeclaration
import org.jetbrains.kotlin.psi.KtNamedFunction
import org.jetbrains.kotlin.psi.KtNullableType
import org.jetbrains.kotlin.psi.KtObjectDeclaration
import org.jetbrains.kotlin.psi.KtObjectLiteralExpression
import org.jetbrains.kotlin.psi.KtPackageDirective
import org.jetbrains.kotlin.psi.KtParameter
import org.jetbrains.kotlin.psi.KtParameterList
import org.jetbrains.kotlin.psi.KtParenthesizedExpression
import org.jetbrains.kotlin.psi.KtPostfixExpression
import org.jetbrains.kotlin.psi.KtPrefixExpression
import org.jetbrains.kotlin.psi.KtPrimaryConstructor
import org.jetbrains.kotlin.psi.KtProjectionKind.IN
import org.jetbrains.kotlin.psi.KtProjectionKind.OUT
import org.jetbrains.kotlin.psi.KtProjectionKind.STAR
import org.jetbrains.kotlin.psi.KtProperty
import org.jetbrains.kotlin.psi.KtPropertyAccessor
import org.jetbrains.kotlin.psi.KtPropertyDelegate
import org.jetbrains.kotlin.psi.KtQualifiedExpression
import org.jetbrains.kotlin.psi.KtReferenceExpression
import org.jetbrains.kotlin.psi.KtReturnExpression
import org.jetbrains.kotlin.psi.KtSafeQualifiedExpression
import org.jetbrains.kotlin.psi.KtScript
import org.jetbrains.kotlin.psi.KtScriptInitializer
import org.jetbrains.kotlin.psi.KtSecondaryConstructor
import org.jetbrains.kotlin.psi.KtSelfType
import org.jetbrains.kotlin.psi.KtSimpleNameExpression
import org.jetbrains.kotlin.psi.KtSimpleNameStringTemplateEntry
import org.jetbrains.kotlin.psi.KtStringTemplateEntry
import org.jetbrains.kotlin.psi.KtStringTemplateEntryWithExpression
import org.jetbrains.kotlin.psi.KtStringTemplateExpression
import org.jetbrains.kotlin.psi.KtSuperExpression
import org.jetbrains.kotlin.psi.KtSuperTypeCallEntry
import org.jetbrains.kotlin.psi.KtSuperTypeEntry
import org.jetbrains.kotlin.psi.KtSuperTypeList
import org.jetbrains.kotlin.psi.KtSuperTypeListEntry
import org.jetbrains.kotlin.psi.KtThisExpression
import org.jetbrains.kotlin.psi.KtThrowExpression
import org.jetbrains.kotlin.psi.KtTryExpression
import org.jetbrains.kotlin.psi.KtTypeAlias
import org.jetbrains.kotlin.psi.KtTypeArgumentList
import org.jetbrains.kotlin.psi.KtTypeConstraint
import org.jetbrains.kotlin.psi.KtTypeConstraintList
import org.jetbrains.kotlin.psi.KtTypeElement
import org.jetbrains.kotlin.psi.KtTypeParameter
import org.jetbrains.kotlin.psi.KtTypeParameterList
import org.jetbrains.kotlin.psi.KtTypeProjection
import org.jetbrains.kotlin.psi.KtTypeReference
import org.jetbrains.kotlin.psi.KtUnaryExpression
import org.jetbrains.kotlin.psi.KtUserType
import org.jetbrains.kotlin.psi.KtValueArgument
import org.jetbrains.kotlin.psi.KtValueArgumentList
import org.jetbrains.kotlin.psi.KtVisitorVoid
import org.jetbrains.kotlin.psi.KtWhenConditionInRange
import org.jetbrains.kotlin.psi.KtWhenConditionIsPattern
import org.jetbrains.kotlin.psi.KtWhenConditionWithExpression
import org.jetbrains.kotlin.psi.KtWhenEntry
import org.jetbrains.kotlin.psi.KtWhenExpression
import org.jetbrains.kotlin.psi.KtWhileExpression
import org.jetbrains.kotlin.psi.psiUtil.PsiChildRange
import org.jetbrains.kotlin.psi.psiUtil.allChildren
import org.jetbrains.kotlin.types.Variance
import com.squareup.kotlinpoet.WildcardTypeName

@Suppress("unused", "MemberVisibilityCanBePrivate")
internal class KibbleVisitor(private val context: KibbleContext) : KtVisitorVoid() {
    override fun visitKtFile(kt: KtFile) {
        val builder = FileSpec.builder(kt.packageDirective?.fqName?.asString() ?: "", kt.name)
        context.bookmark("visitKtFile: ${kt.name}")
        context.push(builder)

        kt.allChildren.forEach { it.accept(this) }

        context.popToBookmark().forEach {
            when (it) {
                is TypeSpec -> builder.addType(it)
                is FunSpec -> builder.addFunction(it)
                is PropertySpec -> builder.addProperty(it)
                is AnnotationSpec -> builder.addAnnotation(it)
                is FileSpec.Builder -> {
                } // ignore
                else -> unknownType(it)
            }
        }
        context.register(builder.build())
    }

    override fun visitImportDirective(directive: KtImportDirective) {
        val fqName = directive.importedFqName!!
        val alias = directive.aliasName

        if (alias != null) {
            context.peek<FileSpec.Builder>().addAliasedImport(ClassName(fqName.parent().asString(), fqName.shortName().asString()), alias)
        } else {
            context.peek<FileSpec.Builder>().addImport(fqName.parent().asString(), fqName.shortName().asString())
        }
    }

    override fun visitKtElement(element: KtElement) {
        throw Exception("Found an unprocessed type: $element")
    }

    override fun visitDeclaration(dcl: KtDeclaration) {
        return when (dcl) {
            is KtClass -> visitClass(dcl)
            is KtObjectDeclaration -> visitObjectDeclaration(dcl)
            is KtNamedFunction -> visitNamedFunction(dcl)
            is KtProperty -> visitProperty(dcl)
            is KtTypeParameter -> visitTypeParameter(dcl)
            else -> unknownType(dcl)
        }
    }

    enum class ClassType {
        ANNOTATION, CLASS, ENUM, INTERFACE, OBJECT
    }

    override fun visitClass(kt: KtClass) {
        val name = kt.name
        val (builder, kind) = classBuilder(kt, name)

        var primarySet = false
        acceptChildren(kt, builder) {
            when (it) {
                is FunSpec -> {
                    if (it.isConstructor && !primarySet) {
                        primaryConstructor(it)
                        primarySet = true
                    } else {
                        addFunction(it)
                    }
                }
                is KModifier -> addModifiers(it)
                is PropertySpec -> addProperty(it)
                is TypeName -> addSuperinterface(it)
                is AnnotationSpec -> addAnnotation(it)
                is SuperCall -> {
                    superclass(it.type)
                    it.arguments.forEach { arg -> addSuperclassConstructorParameter(arg) }
                }
                is TypeSpec -> {
                    when (kind) {
                        ENUM -> addEnumConstant(it.name ?: "", it)
                        else -> addType(it)
                    }
                }
                is CodeBlock -> addInitializerBlock(it)
                else -> unknownType(it)
            }
        }

        context.push(builder.build())
    }

    private fun classBuilder(kt: KtClass, name: String?): Pair<TypeSpec.Builder, ClassType> {
        val kind: ClassType
        val builder = when {
            kt.isInterface() -> {
                kind = INTERFACE
                TypeSpec.interfaceBuilder(name!!)
            }
            kt.isEnum() -> {
                kind = ClassType.ENUM
                TypeSpec.enumBuilder(name!!)
            }
            kt.isAnnotation() -> {
                kind = ClassType.ANNOTATION
                TypeSpec.annotationBuilder(name!!)
            }
            name == null -> {
                kind = ClassType.CLASS
                TypeSpec.anonymousClassBuilder()
            }
            !kt.isInterface() && !kt.isEnum() -> {
                kind = ClassType.CLASS
                TypeSpec.classBuilder(name)
            }
            else -> unknownType(kt)
        }
        return Pair(builder, kind)
    }

    override fun visitObjectDeclaration(declaration: KtObjectDeclaration) {
        val builder = acceptChildren(declaration, TypeSpec.objectBuilder(declaration.name ?: "")) {
            when (it) {
                is FunSpec -> addFunction(it)
                is KModifier -> addModifiers(it)
                is PropertySpec -> addProperty(it)
                is TypeName -> addSuperinterface(it)
                is AnnotationSpec -> addAnnotation(it)
                is SuperCall -> {
                    superclass(it.type)
                    it.arguments.forEach { arg -> addSuperclassConstructorParameter(arg) }
                }
                is TypeSpec -> addType(it)
                else -> unknownType(it)
            }
        }

        context.push(builder.build())
    }

    override fun visitClassOrObject(classOrObject: KtClassOrObject) {
        this.visitNamedDeclaration(classOrObject)
    }

    override fun visitSecondaryConstructor(secondary: KtSecondaryConstructor) {
        val builder = FunSpec.constructorBuilder()
        acceptChildren(secondary, builder) {
            when (it) {
                is CodeBlock -> builder.addCode(it)
                is ParameterSpec -> builder.addParameter(it)
                is ThisCallBlock -> builder.callThisConstructor(*it.arguments.toTypedArray())
                is SuperCallBlock -> builder.callSuperConstructor(*it.arguments.toTypedArray())
                else -> unknownType(it)
            }
        }
        context.push(builder.build())
    }

    override fun visitPrimaryConstructor(primary: KtPrimaryConstructor) {
        context.bookmark("visitPrimaryConstructor")
        primary.valueParameters.forEach { it.accept(this) }
        primary.modifierList?.acceptChildren(this)
        val values = context.popToBookmark()
        val builder = FunSpec.constructorBuilder()
        processChildren(builder, values) {
            when (it) {
                is ParameterSpec -> builder.addParameter(it)
                is PropertySpec -> {
                    builder.addParameter(it.name, it.type)
                    context.push(it)
                }
                else -> unknownType(it)
            }
        }

        context.push(builder.build())
    }

    private fun unknownType(it: Any): Nothing {
        TODO("unknown type: ${it.javaClass}\n${it}")
    }

    override fun visitNamedFunction(kt: KtNamedFunction) {
        val builder = FunSpec.builder(kt.name ?: missing("function name is missing: ${kt.text}"))
        acceptChildren(kt, builder) {
            when (it) {
                is CodeBlock -> addCode(it)
                is ClassName -> returns(it)
                is KModifier -> addModifiers(it)
                is ParameterSpec -> addParameter(it)
                is AnnotationSpec -> addAnnotation(it)
                else -> unknownType(it)
            }
        }

        context.push(builder.build())
    }

    internal fun <T : Any> acceptChildren(element: PsiElement, t: T, func: T.(it: Any) -> Unit): T {
        context.bookmark("acceptChildren")
        element.allChildren.accept(this)
        processChildren(t, context.popToBookmark(), func)

        return t
    }

    internal fun <T> processChildren(t: T, list: List<Any>, func: T.(it: Any) -> Unit) {
        list.forEach {
            t.func(it)
        }
    }

    private fun <T> KtElement.evaluate(visitor: KibbleVisitor): T {
        this.accept(visitor)
        return visitor.context.pop()
    }

    private fun <T> PsiElement.evaluate(visitor: KibbleVisitor): T {
        this.accept(visitor)
        return visitor.context.pop()
    }

    private fun <T> List<KtElement>.evaluate(visitor: KibbleVisitor): List<T> {
        return map { it.evaluate<T>(visitor) }
    }

    override fun visitProperty(property: KtProperty) {
        val type = property.typeReference?.evaluate<TypeName>(this) ?: ClassName("", "")
        // ?: missing("properties must have types: ${property.text  }")
        val name = property.name ?: missing("properties must be named")

        val builder = PropertySpec.builder(name, type)
        buildProperty(property, builder)
        context.push(builder.build())
    }

    private fun buildProperty(property: PsiElement, builder: Builder) {
        acceptChildren(property, builder) {
            when (it) {
                is CodeBlock -> initializer(it)
                is AnnotationSpec -> addAnnotation(it)
                is KModifier -> builder.addModifiers(it)
                is TypeName -> { /*  already handled */
                }
                else -> unknownType(it)
            }
        }
    }

    private fun missing(message: String): Nothing {
        throw Exception(message)
    }

    override fun visitDestructuringDeclaration(multiDeclaration: KtDestructuringDeclaration) {
        this.visitDeclaration(multiDeclaration)
    }

    override fun visitDestructuringDeclarationEntry(multiDeclarationEntry: KtDestructuringDeclarationEntry) {
        this.visitNamedDeclaration(multiDeclarationEntry)
    }

    override fun visitTypeAlias(typeAlias: KtTypeAlias) {
        this.visitNamedDeclaration(typeAlias)
    }

    override fun visitScript(script: KtScript) {
        this.visitDeclaration(script)
    }

    override fun visitImportAlias(importAlias: KtImportAlias) {
        this.visitKtElement(importAlias)
    }

    override fun visitImportList(importList: KtImportList) {
        importList.imports
                .map { it.accept(this) }
                .toList()
    }

    fun visitFileAnnotationList(fileAnnotationList: KtFileAnnotationList) {
        this.visitKtElement(fileAnnotationList)
    }

    override fun visitClassBody(classBody: KtClassBody) {
        classBody.acceptChildren(this)
    }

    override fun visitModifierList(list: KtModifierList) {
        list.allChildren.forEach {
            when (it) {
                is LeafPsiElement -> if (it.elementType is KtModifierKeywordToken) {
                    context.push(it.toKModifier())
                }
                else -> it.accept(this)
            }
        }
    }

    override fun visitAnnotation(annotation: KtAnnotation) {
        this.visitKtElement(annotation)
    }

    override fun visitAnnotationEntry(annotationEntry: KtAnnotationEntry) {
        val annType = annotationEntry.typeReference?.evaluate<ClassName>(this)!!
        val builder = AnnotationSpec.builder(annType)
        context.bookmark("visitAnnotationEntry: $annType")
        annotationEntry.valueArgumentList?.accept(this)
        val arguments = context.popToBookmark()
        arguments.forEach {
            it as Pair<String, String>
            builder.addMember(it.first, it.second)
        }
        context.push(builder.build())
    }

    fun visitAnnotationUseSiteTarget(annotationTarget: KtAnnotationUseSiteTarget) {
        this.visitKtElement(annotationTarget)
    }

    override fun visitConstructorCalleeExpression(kt: KtConstructorCalleeExpression) {
        val superCall = SuperCall()
        acceptChildren(kt, superCall) {
            when (it) {
                is ClassName -> superCall.type = it
                else -> unknownType(it)
            }
        }
        context.push(superCall)
    }

    override fun visitTypeParameterList(list: KtTypeParameterList) {
        list.acceptChildren(this)
    }

    override fun visitTypeParameter(parameter: KtTypeParameter) {
        val bounds: KibbleType? = parameter.extendsBound?.evaluate(this)

        val variance = when (parameter.variance) {
            Variance.INVARIANT -> null
            Variance.IN_VARIANCE -> TypeParameterVariance.IN
            Variance.OUT_VARIANCE -> TypeParameterVariance.OUT
        }

        val value = KibbleType.from(parameter.name ?: "")
        context.push(TypeParameter(value, variance, bounds))
    }

    override fun visitEnumEntry(enumEntry: KtEnumEntry) {
        this.visitClass(enumEntry)
    }

    override fun visitParameterList(list: KtParameterList) {
        list.parameters.map { it.accept(this) }
    }

    override fun visitParameter(parameter: KtParameter) {
        val name = parameter.name ?: ""
        val type = parameter.typeReference!!.evaluate<TypeName>(this)
        val builder: Any
        if (parameter.hasValOrVar()) {
            builder = PropertySpec.builder(name, type)
            builder.initializer(parameter.name!!)
            buildProperty(parameter, builder)
            context.push(builder.build())
        } else {
            builder = ParameterSpec.builder(name, type)
            acceptChildren(parameter, builder) {
                when (it) {
                    is TypeName -> {
                    } // handled
                    is KModifier -> builder.addModifiers(it)
                    else -> unknownType(it)
                }
            }
            context.push(builder.build())
        }

    }

    override fun visitSuperTypeList(list: KtSuperTypeList) {
        list.entries.forEach { it.accept(this) }
    }

    override fun visitSuperTypeListEntry(specifier: KtSuperTypeListEntry) {
        specifier.typeReference?.evaluate<KibbleType>(this)?.let {
            context.push(it)
        }
    }

    override fun visitDelegatedSuperTypeEntry(specifier: KtDelegatedSuperTypeEntry) {
        this.visitSuperTypeListEntry(specifier)
    }

    fun Pair<*, *>.toCodeBlock(): CodeBlock {
        return when (first) {
            "" -> second as CodeBlock
            else -> CodeBlock.of(first as String, second)
        }
    }

    override fun visitSuperTypeCallEntry(call: KtSuperTypeCallEntry) {
        acceptChildren(call, SuperCall()) {
            when (it) {
                is Pair<*, *> -> arguments += it.toCodeBlock()
                is SuperCall -> type = it.type
                else -> unknownType(it)
            }
        }
    }

    override fun visitSuperTypeEntry(specifier: KtSuperTypeEntry) {
        specifier.typeReference?.evaluate<ClassName>(this)?.let {
            context.push(it)
        }
    }

    sealed class CallBlock {
        val arguments = mutableListOf<CodeBlock>()

        class ThisCallBlock : CallBlock()
        class SuperCallBlock : CallBlock()
    }

    override fun visitConstructorDelegationCall(call: KtConstructorDelegationCall) {
        val callBlock = if (call.isCallToThis) ThisCallBlock() else SuperCallBlock()
        context.bookmark("visitConstructorDelegationCall")
        call.allChildren.accept(this)
        val list = context.popToBookmark()
        list.forEach {
            when (it) {
                is Pair<*, *> -> callBlock.arguments += it.toCodeBlock()
                else -> unknownType(it)
            }
        }
        context.push(callBlock)
    }

    override fun visitPropertyDelegate(delegate: KtPropertyDelegate) {
        this.visitKtElement(delegate)
    }

    override fun visitTypeReference(typeReference: KtTypeReference) {
        typeReference.acceptChildren(this)
//        typeReference.typeElement?.evaluate<Any>(this)?.let {
//            context.push(it)
//        }
    }

    override fun visitValueArgumentList(list: KtValueArgumentList) {
        list.arguments.forEach { it.accept(this) }
    }

    override fun visitArgument(argument: KtValueArgument) {
        val name = argument.getArgumentName()?.text ?: ""
        val value = argument.getArgumentExpression()?.evaluate<Any>(this) ?: ""
        context.push(name to value)
    }

    fun visitConstructorDelegationReferenceExpression(expression: KtConstructorDelegationReferenceExpression) {
        // ignore
    }

    override fun visitExpression(expression: KtExpression) {
        when (expression) {
            is KtConstructorDelegationReferenceExpression -> visitConstructorDelegationReferenceExpression(expression)
            else -> expression.accept(this)
        }
    }

    override fun visitLoopExpression(loopExpression: KtLoopExpression) {
        this.visitExpression(loopExpression)
    }

    override fun visitConstantExpression(expression: KtConstantExpression) {
        context.push(CodeBlock.of(expression.text))
    }

    override fun visitSimpleNameExpression(expression: KtSimpleNameExpression) {
        context.push(CodeBlock.of(expression.getReferencedName()))
    }

    override fun visitReferenceExpression(expression: KtReferenceExpression) {
        this.visitExpression(expression)
    }

    override fun visitLabeledExpression(expression: KtLabeledExpression) {
        context.push(CodeBlock.of(expression.text))
    }

    override fun visitPrefixExpression(expression: KtPrefixExpression) {
        context.push(CodeBlock.of(expression.text))
    }

    override fun visitPostfixExpression(expression: KtPostfixExpression) {
        this.visitUnaryExpression(expression)
    }

    override fun visitUnaryExpression(expression: KtUnaryExpression) {
        val operationToken = expression.operationToken
        val token = when (operationToken) {
            is KtSingleValueToken -> operationToken.value
            else -> unknownType(operationToken)
        }
        context.push(token)
        expression.baseExpression?.accept(this)
    }

    override fun visitBinaryExpression(expression: KtBinaryExpression) {
        context.push(expression.text)
    }

    override fun visitReturnExpression(expression: KtReturnExpression) {
        val returned = expression.returnedExpression?.evaluate<String>(this)
        val retVal = returned
                ?: (expression.labeledExpression?.evaluate<String>(this)?.let { it }
                        ?: throw RuntimeException("Could not find value for return expression: $expression"))
        context.push("return $retVal")
    }

    override fun visitExpressionWithLabel(expression: KtExpressionWithLabel) {
        this.visitExpression(expression)
    }

    override fun visitThrowExpression(expression: KtThrowExpression) {
        this.visitExpression(expression)
    }

    override fun visitBreakExpression(expression: KtBreakExpression) {
        this.visitExpressionWithLabel(expression)
    }

    override fun visitContinueExpression(expression: KtContinueExpression) {
        this.visitExpressionWithLabel(expression)
    }

    override fun visitIfExpression(expression: KtIfExpression) {
        this.visitExpression(expression)
    }

    override fun visitWhenExpression(expression: KtWhenExpression) {
        this.visitExpression(expression)
    }

    override fun visitCollectionLiteralExpression(expression: KtCollectionLiteralExpression) {
        this.visitExpression(expression)
    }

    override fun visitTryExpression(expression: KtTryExpression) {
        this.visitExpression(expression)
    }

    override fun visitForExpression(expression: KtForExpression) {
        val loopText = expression.prevSibling.text.dropWhile { it == '\n' } + expression.text

        context.push(loopText.trimIndent())
    }

    override fun visitWhileExpression(expression: KtWhileExpression) {
        this.visitLoopExpression(expression)
    }

    override fun visitDoWhileExpression(expression: KtDoWhileExpression) {
        this.visitLoopExpression(expression)
    }

    override fun visitLambdaExpression(expression: KtLambdaExpression) {
        this.visitExpression(expression)
    }

    override fun visitAnnotatedExpression(expression: KtAnnotatedExpression) {
        if (expression.annotationEntries.size != 1) {
            throw RuntimeException("Should have found one entry")
        }
        context.push(expression.annotationEntries[0].evaluate(this))
    }

    override fun visitCallExpression(expression: KtCallExpression) {
        context.push(CodeBlock.of(expression.text))
    }

    override fun visitArrayAccessExpression(expression: KtArrayAccessExpression) {
        this.visitReferenceExpression(expression)
    }

    override fun visitQualifiedExpression(expression: KtQualifiedExpression) {
        this.visitExpression(expression)
    }

    override fun visitDoubleColonExpression(expression: KtDoubleColonExpression) {
        this.visitExpression(expression)
    }

    override fun visitCallableReferenceExpression(expression: KtCallableReferenceExpression) {
        this.visitDoubleColonExpression(expression)
    }

    override fun visitClassLiteralExpression(expression: KtClassLiteralExpression) {
        this.visitDoubleColonExpression(expression)
    }

    override fun visitDotQualifiedExpression(expression: KtDotQualifiedExpression) {
        context.push(CodeBlock.of(expression.text))
    }

    override fun visitSafeQualifiedExpression(expression: KtSafeQualifiedExpression) {
        this.visitQualifiedExpression(expression)
    }

    override fun visitObjectLiteralExpression(expression: KtObjectLiteralExpression) {
        this.visitExpression(expression)
    }

    override fun visitBlockExpression(expression: KtBlockExpression) {
        val builder = CodeBlock.builder()
        val body = expression.text
                .dropWhile { it == '{' /*|| it == '\n'*/ }
                .dropLastWhile { it == '}' /*|| it == '\n'*/ }
                .trimIndent()

        builder.add(body)

        context.push(builder.build())
    }

    override fun visitCatchSection(catchClause: KtCatchClause) {
        this.visitKtElement(catchClause)
    }

    override fun visitFinallySection(finallySection: KtFinallySection) {
        this.visitKtElement(finallySection)
    }

    override fun visitTypeArgumentList(typeArgumentList: KtTypeArgumentList) {
        this.visitKtElement(typeArgumentList)
    }

    override fun visitThisExpression(expression: KtThisExpression) {
        this.visitExpressionWithLabel(expression)
    }

    override fun visitSuperExpression(expression: KtSuperExpression) {
        this.visitExpressionWithLabel(expression)
    }

    override fun visitParenthesizedExpression(expression: KtParenthesizedExpression) {
        this.visitExpression(expression)
    }

    override fun visitInitializerList(list: KtInitializerList) {
        this.visitKtElement(list)
    }

    override fun visitAnonymousInitializer(initializer: KtAnonymousInitializer) {
        this.visitDeclaration(initializer)
    }

    override fun visitScriptInitializer(initializer: KtScriptInitializer) {
        this.visitAnonymousInitializer(initializer)
    }

    override fun visitClassInitializer(initializer: KtClassInitializer) {
        context.push(initializer.body?.evaluate(this) ?: CodeBlock.of(""))
    }

    override fun visitPropertyAccessor(accessor: KtPropertyAccessor) {
        this.visitDeclaration(accessor)
    }

    override fun visitTypeConstraintList(list: KtTypeConstraintList) {
        this.visitKtElement(list)
    }

    override fun visitTypeConstraint(constraint: KtTypeConstraint) {
        this.visitKtElement(constraint)
    }

    private fun visitTypeElement(type: KtTypeElement) {
//        return when(type) {
////            is KtUserType -> visitUserType(type)
//            else -> throw RuntimeException("unknown type: ${type}")
//        }
        unknownType(type)
    }

    override fun visitUserType(type: KtUserType) {
/*
        acceptChildren(type, object: Any(){}) {
            when(it) {
                else -> unknownType(it)
            }
        }
*/
        val qualifier = type.qualifier?.text?.split(".") ?: listOf()
        val pkgName = qualifier.takeWhile { it[0].isLowerCase() }
                .joinToString(".")
        val className: String = (qualifier.takeLastWhile { it[0].isUpperCase() } + type.referencedName!!)
                .joinToString(".")
        val list = acceptChildren<TypeProjection>("user type type arguments", type.typeArgumentList)
        var value = ClassName(pkgName, className)
        if (list.isNotEmpty()) {
            var parameterized = value.parameterizedBy(list.first().type)
            for (it in list.drop(1)) {
                parameterized.plusParameter(it.type)
            }
            context.push(parameterized)
        } else {
            context.push(value)
        }
    }

    override fun visitDynamicType(type: KtDynamicType) {
        this.visitTypeElement(type)
    }

    @Suppress("UNCHECKED_CAST")
    override fun visitFunctionType(type: KtFunctionType) {
        val parameters: List<ParameterSpec> = acceptChildren("function type parameters", type.parameterList)
        val receiver = acceptChildren<TypeName>("function type receiver", type.receiver).firstOrNull()
        val returnType = acceptChildren<TypeName>("function type return type", type.returnTypeReference).first()

        val lambdaTypeName = LambdaTypeName.get(receiver, parameters, returnType)
        context.push(lambdaTypeName)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> acceptChildren(bookmark: String, element: KtElement?): List<T> {
        context.bookmark(bookmark)
        element?.acceptChildren(this)
        return context.popToBookmark() as List<T>
    }

    override fun visitSelfType(type: KtSelfType) {
        this.visitTypeElement(type)
    }

    override fun visitBinaryWithTypeRHSExpression(expression: KtBinaryExpressionWithTypeRHS) {
        this.visitExpression(expression)
    }

    override fun visitStringTemplateExpression(expression: KtStringTemplateExpression) {
        context.push(CodeBlock.of(expression.text))
    }

    override fun visitNamedDeclaration(declaration: KtNamedDeclaration) {
        this.visitDeclaration(declaration)
    }

    override fun visitNullableType(nullableType: KtNullableType) {
        nullableType.innerType?.accept(this)
        val type = context.pop<ClassName>()
        if (nullableType.modifierList?.allChildren?.isEmpty == true) {
            TODO("handle the modifiers: ${nullableType.modifierList}")
        }
        context.push(type.asNullable())
    }

    class TypeProjection(val type: ClassName, val variance: KModifier?)

    override fun visitTypeProjection(typeProjection: KtTypeProjection) {
        val value = typeProjection.typeReference?.evaluate<ClassName>(this) ?: ClassName("", "")
        var variance: KModifier? = null
        var wildcard = false
        when (typeProjection.projectionKind) {
            IN -> variance = KModifier.IN
            OUT -> variance = KModifier.OUT
            STAR -> wildcard = true
        }
        val type: TypeName = if (wildcard) WildcardTypeName.STAR else value
//        TypeVariableName(value.toString(), )

        context.push(TypeProjection(value, variance))
    }

    override fun visitWhenEntry(jetWhenEntry: KtWhenEntry) {
        this.visitKtElement(jetWhenEntry)
    }

    override fun visitIsExpression(expression: KtIsExpression) {
        this.visitExpression(expression)
    }

    override fun visitWhenConditionIsPattern(condition: KtWhenConditionIsPattern) {
        this.visitKtElement(condition)
    }

    override fun visitWhenConditionInRange(condition: KtWhenConditionInRange) {
        this.visitKtElement(condition)
    }

    override fun visitWhenConditionWithExpression(condition: KtWhenConditionWithExpression) {
        this.visitKtElement(condition)
    }

    override fun visitStringTemplateEntry(entry: KtStringTemplateEntry) {
        this.visitKtElement(entry)
    }

    override fun visitStringTemplateEntryWithExpression(entry: KtStringTemplateEntryWithExpression) {
        this.visitStringTemplateEntry(entry)
    }

    override fun visitBlockStringTemplateEntry(entry: KtBlockStringTemplateEntry) {
        this.visitStringTemplateEntryWithExpression(entry)
    }

    override fun visitSimpleNameStringTemplateEntry(entry: KtSimpleNameStringTemplateEntry) {
        this.visitStringTemplateEntryWithExpression(entry)
    }

    override fun visitLiteralStringTemplateEntry(entry: KtLiteralStringTemplateEntry) {
        this.visitStringTemplateEntry(entry)
    }

    override fun visitEscapeStringTemplateEntry(entry: KtEscapeStringTemplateEntry) {
        this.visitStringTemplateEntry(entry)
    }

    override fun visitPackageDirective(directive: KtPackageDirective) {
    }

    private fun KtModifierListOwner.isOverridden(): Boolean {
        return modifierList?.allChildren?.find { it.text == "override" } != null
    }

    private fun PsiElement?.toModality(): Modality {
        return this?.text?.let {
            Modality.valueOf(it.toUpperCase())
        } ?: FINAL
    }

    private fun PsiElement.toKModifier(): KModifier {
        return KModifier.valueOf(this.text.toUpperCase())
    }

    private fun PsiElement?.toVisibility(): Visibility {
        return this?.text?.let {
            Visibility.valueOf(it.toUpperCase())
        } ?: PUBLIC
    }


    private fun extractPkgAndClassName(raw: String): Pair<String?, String> {
        val name = raw.split(".")
                .dropLastWhile { it.isEmpty() || it[0].isUpperCase() }
                .filter { it != "" }
                .joinToString(".")
        val pkgName = if (name != "") name else null
        val className = pkgName?.let { raw.substring(it.length + 1) } ?: raw

        return pkgName to className
    }
}

internal fun PsiChildRange.accept(visitor: KibbleVisitor) {
    forEach {
        it.accept(visitor)
    }
}
