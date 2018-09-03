package org.nve.template

import com.typesafe.config.Config
import de.neuland.jade4j.template.ClasspathTemplateLoader
import de.neuland.jade4j.template.FileTemplateLoader
import de.neuland.jade4j.template.TemplateLoader
import org.nve.string.endWith
import org.nve.string.toUpperUnderscore
import java.nio.charset.Charset
import javax.inject.Inject

internal class JadeTemplateLoaderFactory @Inject constructor(
        private val config: Config
) : TemplateLoaderFactory {

    private val loader: TemplateLoader by lazy {
        val configuration = Configuration(config.getConfig("template.jade"))
        when (configuration.type) {
            Configuration.Type.FILE -> FileTemplateLoader(
                    configuration.directory,
                    configuration.encoding.name(),
                    configuration.extension
            )
            Configuration.Type.CLASSPATH -> ClasspathTemplateLoader(
                    configuration.encoding.name(),
                    configuration.extension
            )
        }
    }

    override fun invoke(): TemplateLoader = loader

    private data class Configuration(
            val type: Type,
            val directory: String,
            val encoding: Charset,
            val extension: String
    ) {
        constructor(config: Config) : this(
                type = Type.valueOf(config.getString("type").trim().toUpperUnderscore()),
                directory = config.getString("directory").trim().endWith("/"),
                encoding = Charset.forName(config.getString("encoding")),
                extension = config.getString("extension")
        )

        enum class Type {
            CLASSPATH, FILE
        }
    }

}