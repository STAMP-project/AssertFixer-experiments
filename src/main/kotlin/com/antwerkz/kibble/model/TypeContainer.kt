package com.antwerkz.kibble.model

import com.antwerkz.kibble.KibbleContext

/**
 * Represents a type that can hold a Class or an object
 */
interface TypeContainer {
    val context: KibbleContext
    val objects: List<KibbleObject>


}
