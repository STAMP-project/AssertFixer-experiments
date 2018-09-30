package org.nve.template

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import com.google.common.cache.LoadingCache
import com.typesafe.config.Config
import de.neuland.jade4j.Jade4J
import de.neuland.jade4j.expression.ExpressionHandler
import de.neuland.jade4j.parser.Parser
import de.neuland.jade4j.template.ClasspathTemplateLoader
import de.neuland.jade4j.template.JadeTemplate
import org.nve.string.endWith
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.time.Duration
import java.util.concurrent.TimeUnit
import javax.inject.Inject

internal class JadeTemplateService @Inject constructor(
        private val config: Config,
        private val expressionHandler: ExpressionHandler,
        private val templateLoaderFactory: TemplateLoaderFactory
) : TemplateService {
    private val configuration by lazy { Configuration(config.getConfig("template.jade")) }
    private val templates: LoadingCache<String, JadeTemplate> = CacheBuilder
            .newBuilder()
            .expireAfterAccess(configuration.cache.toMillis(), TimeUnit.MILLISECONDS)
            .build(object : CacheLoader<String, JadeTemplate>() {
                override fun load(name: String): JadeTemplate {
                    val loader = templateLoaderFactory()
                    val actual = if (loader is ClasspathTemplateLoader) "${configuration.directory}$name" else name
                    val parser = Parser(actual, configuration.directory, loader, expressionHandler)
                    val template = JadeTemplate()
                    template.expressionHandler = expressionHandler
                    template.templateLoader = loader
                    template.rootNode = parser.parse()
                    return template
                }
            })

    override fun write(template: Template, output: OutputStream) {
        val loaded = templates[template.name]
        val model = template.model
        val writer = OutputStreamWriter(output)
        Jade4J.render(loaded, model.toMutableMap(), writer, configuration.pretty)
        writer.flush()
    }

    private data class Configuration(
            val directory: String,
            val pretty: Boolean,
            val cache: Duration
    ) {
        constructor(config: Config) : this(
                directory = config.getString("directory").trim().endWith("/"),
                pretty = config.getBoolean("pretty"),
                cache = config.getDuration("cache")
        )
    }
}