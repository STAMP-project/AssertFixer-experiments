package org.nve.inject

import com.google.inject.Injector
import kotlin.reflect.KClass

inline fun <reified T : Any> Injector.get(type: KClass<T>): T =
        getInstance(type.java)

inline fun <reified T: Any> Injector.get(): T =
        get(T::class)

inline fun <reified T: Any> Injector.get(name: String): T =
        getInstance(Class.forName(name)) as T