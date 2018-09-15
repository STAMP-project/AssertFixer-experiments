package org.nve.persistence



import org.junit.Test
import org.nve.service.hibernateScratch


class hibernateScratchTest {

    @Test
    fun hibernateScratchSmokeTest() {
        val sessionFactory = SessionFactoryImpl("../../../../main/webapp/WEB-INF/classes/hibernate.cfg.xml")
        val scratch = hibernateScratch(sessionFactory)
        scratch.create()
    }

}