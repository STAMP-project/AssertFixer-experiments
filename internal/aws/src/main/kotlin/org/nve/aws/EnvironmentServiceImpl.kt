package org.nve.aws

import com.google.inject.Singleton

@Singleton
class EnvironmentServiceImpl: EnvironmentService {
    override val environment = Environment.Local()
}
