package org.nve.persistence

import org.hibernate.Session
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder

class SessionFactory {

    operator fun invoke(): Session =
            MetadataSources(
                    StandardServiceRegistryBuilder()
                            .configure()
                            .build()
            )
                    .buildMetadata()
                    .buildSessionFactory()
                    .openSession()
}