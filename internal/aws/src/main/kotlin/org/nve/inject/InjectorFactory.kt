package org.nve.inject

import com.google.inject.Guice
import com.google.inject.Injector
import com.google.inject.Module
import com.typesafe.config.ConfigFactory
import org.nve.logging.logger


object InjectorFactory {
    private val log = logger()

    val injector: Injector by lazy {
        val loader = this::class.java.classLoader
        val modules = ConfigFactory.load()
                .getStringList("inject.modules")
                .asSequence()
                .map { loader.loadClass(it) }
                .map { it.newInstance() as Module }
                .sortedBy { it::class.simpleName }
                .toList()
        val injector = Guice.createInjector(*modules.toTypedArray())
        log.info("Loading modules: {}", modules.asSequence().map{ it::class.simpleName})
        injector
    }
}