package com.antwerkz.kibble.model

import com.antwerkz.kibble.KibbleContext
import com.antwerkz.kibble.model.Modality.FINAL
import com.antwerkz.kibble.model.Visibility.PUBLIC

/**
 * Defines a function
 *
 * @property name the function name
 * @property parameters the function parameters
 * @property type the function type
 * @property body the function body
 * @property overriding true if this function overrides a function in a parent type
 */
class KibbleFunction internal constructor(var name: String? = null,
                                          override var visibility: Visibility = PUBLIC,
                                          override var modality: Modality = FINAL,
                                          var type: KibbleType? = null,
                                          var body: String? = null,
                                          var bodyBlock: Boolean = true,
                                          override var overriding: Boolean = false,
                                          val context: KibbleContext)
    : Visible, Modal<KibbleFunction>, ParameterHolder, Overridable, GenericCapable/*, TypeContainer,
        FunctionHolder */{

//    override var classes = listOf<KibbleClass>()
//        private set
//    override var objects = listOf<KibbleObject>()
//        private set
//    override var functions = listOf<KibbleFunction>()
//        private set
    override var parameters = listOf<KibbleParameter>()
        private set
    override var typeParameters = listOf<TypeParameter>()
        private set
//    lateinit var file: KibbleFile

    override fun addParameter(parameter: KibbleParameter): KibbleParameter {
        parameters += parameter
        return parameter
    }

    override fun addTypeParameter(type: TypeParameter) {
        typeParameters += type
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KibbleFunction

        if (name != other.name) return false
        if (visibility != other.visibility) return false
        if (modality != other.modality) return false
        if (type != other.type) return false
        if (body != other.body) return false
        if (bodyBlock != other.bodyBlock) return false
        if (overriding != other.overriding) return false
        if (parameters != other.parameters) return false
        if (typeParameters != other.typeParameters) return false
//        if (file != other.file) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + visibility.hashCode()
        result = 31 * result + modality.hashCode()
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + (body?.hashCode() ?: 0)
        result = 31 * result + bodyBlock.hashCode()
        result = 31 * result + overriding.hashCode()
        result = 31 * result + parameters.hashCode()
        result = 31 * result + typeParameters.hashCode()
        return result
    }
/*
    override fun addClass(klass: KibbleClass): KibbleClass {
        classes += klass
        klass.file = file
        return klass
    }

    override fun addObject(obj: KibbleObject): KibbleObject {
        objects += obj
        obj.file = file
        return obj
    }

    override fun addFunction(function: KibbleFunction): KibbleFunction {
        functions += function
        function.file = file
        return function
    }
*/
}

