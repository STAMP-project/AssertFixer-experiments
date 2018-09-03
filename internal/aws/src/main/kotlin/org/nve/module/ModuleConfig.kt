package org.nve.module

import com.typesafe.config.Config
import org.nve.configuration.ConfigProvider
import org.nve.inject.Module

@Suppress("unused")
class ModuleConfig: Module() {
    override fun configure() {
        bind<Config>().using<ConfigProvider>()
    }
}