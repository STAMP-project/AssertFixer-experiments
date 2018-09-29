package org.nve.module

import org.nve.filter.RequestStartFilter
import org.nve.inject.SimpleServletModule
import org.nve.logging.logger

@Suppress("unused")
class ModuleRequestStartFilter: SimpleServletModule() {
    private val logger = logger()

    override fun configureServlets() {
        logger.info("Configuring Request Start Filter...")
        filter("/*").through<RequestStartFilter>()
        logger.info("Done configuring Request Start Filter!")
    }
}