package org.nve.configuration

import com.google.inject.Inject
import com.google.inject.Injector
import com.google.inject.Provider
import com.google.inject.Singleton
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.nve.inject.get

@Suppress("unused")
@Singleton
internal class ConfigProvider @Inject constructor(
        private val injector: Injector
): Provider<Config> {
    private fun config(): Config {
        val configFilters = "config.filters"
        var config = ConfigFactory.load()
        if(!config.hasPath(configFilters))
            return config
        val filters = config.getStringList(configFilters)
                .asSequence()
                .map { injector.get<ConfigFilter>(it) }
                .toList()
        for (filter in filters)
            config = filter(config)
        return config
    }

    private val config by lazy { config() }

    override fun get(): Config = config
}