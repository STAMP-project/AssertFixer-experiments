package org.nve.inject

import com.google.inject.AbstractModule
import com.google.inject.Provider
import com.google.inject.Scope
import com.google.inject.binder.AnnotatedBindingBuilder
import com.google.inject.binder.ScopedBindingBuilder
import kotlin.reflect.KClass


abstract class Module: AbstractModule() {

    override fun configure() {}

    protected fun <T : Any> bind(c: KClass<T>): AnnotatedBindingBuilder<T> = bind(c.java)

    protected inline fun <reified T : Any> bind(): AnnotatedBindingBuilder<T> = bind(T::class)

    protected infix fun <T: Any> AnnotatedBindingBuilder<T>.with(c: KClass<out T>): ScopedBindingBuilder = to(c.java)

    protected inline fun <reified T : Any> AnnotatedBindingBuilder<in T>.with(): ScopedBindingBuilder = to(T::class.java)

    protected infix fun <T : Any> AnnotatedBindingBuilder<T>.using(c: KClass<Provider<out T>>): ScopedBindingBuilder =
            toProvider(c.java)

    @Suppress("unchecked_cast")
    protected inline fun <reified T: Provider<*>> AnnotatedBindingBuilder<*>.using(): ScopedBindingBuilder =
            toProvider(T::class.java as Class<out Provider<out Nothing>>)

    protected infix fun <T> AnnotatedBindingBuilder<T>.with(instance: T) = toInstance(instance)

    protected infix fun ScopedBindingBuilder.into(scope: Scope) = `in`(scope)

}