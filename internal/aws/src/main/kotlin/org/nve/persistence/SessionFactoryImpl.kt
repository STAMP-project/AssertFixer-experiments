package org.nve.persistence

import org.hibernate.Session
import org.hibernate.boot.MetadataSources
import org.hibernate.boot.registry.StandardServiceRegistryBuilder

class SessionFactoryImpl(configPath: String) {

    val registry = StandardServiceRegistryBuilder()
            .configure()
            .build()

    var sessionFactory = MetadataSources(registry)
            .buildMetadata()
            .buildSessionFactory()

    fun buildSession(): Session {
        return sessionFactory.openSession()
    }

}