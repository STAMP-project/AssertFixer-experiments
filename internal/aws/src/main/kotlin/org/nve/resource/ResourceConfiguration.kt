package org.nve.resource

import org.glassfish.jersey.jackson.JacksonFeature
import org.glassfish.jersey.server.ResourceConfig
import org.nve.inject.InjectorFactory.injector
import org.nve.inject.get
import org.nve.logging.logger
import org.nve.template.JadeMessageBodyWriter

@Suppress("unused")
class ResourceConfiguration : ResourceConfig() {
    private val log = logger()

    init {
        log.info("Registering Health Resource")
        // Map Custom Exceptions
        register(injector.get<JacksonFeature>())
        // Jade Templates
        register(injector.get<JadeMessageBodyWriter>())
        // Controller Resources
        register(injector.get<FrontEndResource>())
        register(injector.get<HealthResource>())
    }
}