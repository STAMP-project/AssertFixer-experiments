package org.nve.persistence

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class SessionFactoryTest {

    @Test
    fun sessionFactorySmokeTest() {
        val sessionFactory = SessionFactory()
        assertThat(sessionFactory().isConnected, equalTo(true) )
    }
}