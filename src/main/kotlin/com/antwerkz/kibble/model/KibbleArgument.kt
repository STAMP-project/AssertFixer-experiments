package com.antwerkz.kibble.model

data class KibbleArgument(val name: String? = null, val value: Any){

    constructor(value: Any):  this(null, value)


}
