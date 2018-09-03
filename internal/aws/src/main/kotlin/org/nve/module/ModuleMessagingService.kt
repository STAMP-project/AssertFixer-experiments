package org.nve.module

import org.nve.inject.Module
import org.nve.service.LocalMessagingServiceImpl
import org.nve.services.MessagingService

@Suppress("unused")
class ModuleMessagingService : Module() {
    override fun configure() {
        bind<MessagingService>().with<LocalMessagingServiceImpl>()
    }
}
