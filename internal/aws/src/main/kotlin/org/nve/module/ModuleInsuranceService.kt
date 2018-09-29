package org.nve.module

import org.nve.inject.Module
import org.nve.service.LocalInsuranceServiceImpl
import org.nve.services.InsuranceService

@Suppress("unused")
class ModuleInsuranceService : Module() {
    override fun configure() {
        bind<InsuranceService>().with<LocalInsuranceServiceImpl>()
    }
}