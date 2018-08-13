package com.antwerkz.kibble.model

import com.antwerkz.kibble.KibbleContext
import com.antwerkz.kibble.model.Visibility.PUBLIC

/**
 * Defines an object type
 *
 * @property name the object name
 * @property companion true if this object is a companion object
 * @property initBlock any custom init block for this class
 */
class KibbleObject internal constructor(val name: String? = null, val companion: Boolean = false, override val context: KibbleContext)
    : TypeContainer, PropertyHolder, FunctionHolder, Polymorphic, Visible {

//    lateinit var file: KibbleFile

    val superCallArgs = mutableListOf<KibbleArgument>()
    var extends: KibbleType? = null
    val implements: MutableList<KibbleType> = mutableListOf()

    override var visibility: Visibility = PUBLIC
    override var objects = listOf<KibbleObject>(
            /*Comparator { o1, o2 -> o1.name?.compareTo(o2?.name ?: "") ?: 1}*/)
        private set
    override var functions = listOf<KibbleFunction>(
            /*Comparator { o1, o2 -> o1.name?.compareTo(o2?.name ?: "") ?: 1}*/)
        private set
    override var properties = listOf<KibbleProperty>()
        private set
    var initBlock: String? = null

    override fun extends(type: KibbleType, arguments: List<KibbleArgument>) {
        extends = type
        superCallArgs += arguments
    }

    override fun implements(type: KibbleType) {
        implements += type
    }

    fun addObject(obj: KibbleObject): KibbleObject {
        objects += obj
//        obj.file = file
        return obj
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as KibbleObject

        if (name != other.name) return false
        if (companion != other.companion) return false
        if (superCallArgs != other.superCallArgs) return false
        if (extends != other.extends) return false
        if (implements != other.implements) return false
        if (visibility != other.visibility) return false
        if (objects != other.objects) return false
        if (functions != other.functions) return false
        if (properties != other.properties) return false
        if (initBlock != other.initBlock) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + companion.hashCode()
        result = 31 * result + superCallArgs.hashCode()
        result = 31 * result + (extends?.hashCode() ?: 0)
        result = 31 * result + implements.hashCode()
        result = 31 * result + visibility.hashCode()
        result = 31 * result + objects.hashCode()
        result = 31 * result + functions.hashCode()
        result = 31 * result + properties.hashCode()
        result = 31 * result + (initBlock?.hashCode() ?: 0)
        return result
    }

    override fun addFunction(function: KibbleFunction): KibbleFunction {
        functions += function
//        function.file = file
        return function
    }

    override fun addProperty(property: KibbleProperty): KibbleProperty {
        properties += property
        return property
    }
}