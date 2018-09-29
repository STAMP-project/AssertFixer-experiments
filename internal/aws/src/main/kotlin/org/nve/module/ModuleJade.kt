package org.nve.module

import de.neuland.jade4j.expression.ExpressionHandler
import de.neuland.jade4j.expression.JexlExpressionHandler
import org.nve.inject.Module
import org.nve.logging.logger
import org.nve.template.JadeTemplateLoaderFactory
import org.nve.template.JadeTemplateService
import org.nve.template.TemplateLoaderFactory
import org.nve.template.TemplateService

@Suppress("unused")
class ModuleJade : Module() {
    private val logger = logger()

    override fun configure() {
        logger.info("Binding Module Jade...")
        bind<ExpressionHandler>().with<JexlExpressionHandler>()
        bind<TemplateLoaderFactory>().with<JadeTemplateLoaderFactory>()
        bind<TemplateService>().with<JadeTemplateService>()
        logger.info("Done binding Module Jade!")
    }
}