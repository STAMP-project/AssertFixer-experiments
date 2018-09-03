package org.nve.inject

import com.google.inject.Injector
import com.squarespace.jersey2.guice.JerseyGuiceModule
import com.squarespace.jersey2.guice.JerseyGuiceUtils.install
import org.glassfish.hk2.api.ServiceLocator
import org.glassfish.hk2.extension.ServiceLocatorGenerator
import org.nve.logging.logger

class JerseyApplicationGuiceServletContextListener: ApplicationGuiceServletContextListener() {
    companion object {
        private val log = logger()
    }

    override fun getInjector(): Injector {
        val parentInjector = super.getInjector()
        log.info("Installing HK2/Guice bridge.")
        install(ServiceLocatorGenerator { name, _ ->
            if(!name.startsWith("__HK2_Generated_")) return@ServiceLocatorGenerator null
            log.info("Creating new child Guice injector for {}.", name)
            parentInjector.createChildInjector(JerseyGuiceModule(name))
                    .getInstance(ServiceLocator::class.java)
        })
        return parentInjector
    }
}