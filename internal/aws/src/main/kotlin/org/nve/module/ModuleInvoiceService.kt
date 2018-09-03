package org.nve.module

import org.nve.inject.Module
import org.nve.service.LocalInvoiceServiceImpl
import org.nve.services.InvoiceService

@Suppress("unused")
class ModuleInvoiceService : Module() {
    override fun configure() {
        bind<InvoiceService>().with<LocalInvoiceServiceImpl>()
    }
}
