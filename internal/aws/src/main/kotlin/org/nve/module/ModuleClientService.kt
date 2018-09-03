package org.nve.module

import org.nve.inject.Module
import org.nve.service.*
import org.nve.services.*


@Suppress("unused")
class ModuleClientService: Module() {
    override fun configure() {
        bind<CompanyService>().with<LocalCompanyServiceImpl>()
    }
}