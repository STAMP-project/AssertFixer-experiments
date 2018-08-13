package com.antwerkz.kibble.model

import com.antwerkz.kibble.model.Modality.FINAL

/**
 * Defines a property on a file, class, or object
 *
 * @property name the name of the property
 * @property type the type of the property
 * @property initializer any initialization expression for the property
 * @property lateInit true if the property should have the `lateinit` modifier
 * @property overriding true if this property is overriding a property in a parent type
 * @property constructorParam true if the property should be listed as a constructor parameter
 */
class KibbleProperty internal constructor(val name: String, val type: KibbleType?, var initializer: String? = null,
                                          override var modality: Modality = FINAL, override var overriding: Boolean = false,
                                          var lateInit: Boolean = false, var constructorParam: Boolean = false)
    : Visible, Mutable, Modal<KibbleProperty>, Overridable,
        GenericCapable {

    override var visibility = Visibility.PUBLIC
    override var mutability= Mutability.VAL
    override var typeParameters = listOf<TypeParameter>()
        private set

    override fun addTypeParameter(type: TypeParameter) {
        typeParameters += type
    }
}

