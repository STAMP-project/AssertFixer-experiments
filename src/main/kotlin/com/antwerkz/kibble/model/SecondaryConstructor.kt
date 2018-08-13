package com.antwerkz.kibble.model

import com.antwerkz.kibble.model.Visibility.PUBLIC

/**
 * Defines a secondary constructor for class
 *
 * @property delegationArguments the arguments to pass to the delegation constructor call
 */
class SecondaryConstructor internal constructor(vararg arguments: KibbleArgument) : Visible, ParameterHolder {
    override var visibility = PUBLIC
    override var parameters = listOf<KibbleParameter>()
        private set
    val delegationArguments = mutableListOf<KibbleArgument>()
    var body: String? = null

    init {
        delegationArguments += arguments
    }

    override fun addParameter(parameter: KibbleParameter): KibbleParameter {
        parameters += parameter
        return parameter
    }
}