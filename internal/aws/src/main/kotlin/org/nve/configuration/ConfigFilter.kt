package org.nve.configuration

import com.typesafe.config.Config

interface ConfigFilter: (Config) -> Config {
    override fun invoke(config: Config): Config
}