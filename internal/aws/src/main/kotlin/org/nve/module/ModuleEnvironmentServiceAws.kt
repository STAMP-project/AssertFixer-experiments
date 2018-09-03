package org.nve.module

import org.nve.aws.EnvironmentService
import org.nve.aws.EnvironmentServiceImpl
import org.nve.inject.Module
import org.nve.logging.logger

@Suppress("unused")
class ModuleEnvironmentServiceAws : Module() {
    private val logger = logger()

    override fun configure() {
        logger.info("Binding Module Environment Service AWS...")
        bind<EnvironmentService>().with<EnvironmentServiceImpl>()
        logger.info("Done binding Module Environment Service AWS!")
    }
}