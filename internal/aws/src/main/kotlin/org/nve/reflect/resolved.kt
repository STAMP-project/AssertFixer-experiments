package org.nve.reflect

import kotlin.reflect.KClass
import kotlin.reflect.full.companionObject

inline val <reified T: Any> T.resolved: KClass<*> get() {
    return if(this::class == T::class.java.enclosingClass?.kotlin?.companionObject)
        T::class.java.enclosingClass.kotlin
    else T::class.java.kotlin
}