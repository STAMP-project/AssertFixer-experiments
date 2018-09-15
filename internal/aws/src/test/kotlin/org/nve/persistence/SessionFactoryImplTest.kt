package org.nve.persistence

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


class SessionFactoryImplTest {

    @Test
    fun sessionFactoryImplSmokeTest() {
        val sessionFactory = SessionFactoryImpl("../../../../main/webapp/WEB-INF/classes/hibernate.cfg.xml")
        assertThat(sessionFactory.buildSession().isConnected, equalTo(true) )
    }
}