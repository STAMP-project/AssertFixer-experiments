package org.nve.configuration

import com.typesafe.config.Config
import org.nve.aws.Environment
import org.nve.aws.EnvironmentService
import javax.inject.Inject

@Suppress("unused")
internal class ConfigFilterAwsEnvironment @Inject constructor(
        private val environmentService: EnvironmentService
) : ConfigFilter {
    override fun invoke(config: Config): Config {
        val environment = environmentService.environment
        val scope = when(environment) {
            is Environment.Local -> "local"
            is Environment.Aws -> environment.project
        }
        if(!config.hasPath(scope))
            return config
        return config.getConfig(scope).withFallback(config)
    }
}