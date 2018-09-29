package org.nve.service

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.hibernate.Session
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Insurance
import org.nve.persistence.SessionFactory
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.easymock.EasyMock.expect
import org.hibernate.query.Query
import org.nve.persistence.dao.InsuranceEntity

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        SessionFactory::class,
        Session::class,
        InsuranceEntity::class,
        Insurance::class
)
class InsuranceServiceImplTest {

    @Test
    fun readSmokeTest() {
        val mockSessionFactory = createMock<SessionFactory>()
        val mockSession = createMock<Session>()
        val mockQuery = createMock<Query<Any>>()
        val mockInsuranceEntityList = createMock<List<InsuranceEntity>>()
        val mockInsuranceEntityIterator = createMock<Iterator<InsuranceEntity>>()
        val mockInsuranceEntity = createMock<InsuranceEntity>()
        val mockInsurance = createMock<Insurance>()

        val insuranceService = InsuranceServiceImpl(mockSessionFactory)

        expect(mockSessionFactory.invoke()).andReturn(mockSession)
        expect(mockSession.createQuery("from InsuranceEntity as insuranceEntity")).andReturn(mockQuery)
        expect(mockQuery.list()).andReturn(mockInsuranceEntityList)
        expect(mockInsuranceEntityList.iterator()).andReturn(mockInsuranceEntityIterator)
        expect(mockInsuranceEntityIterator.hasNext()).andReturn(true)
        expect(mockInsuranceEntityIterator.next()).andReturn(mockInsuranceEntity)
        //expect(insuranceService.toInsurance(mockInsuranceEntity)).andReturn(mockInsurance)
        expect(mockInsuranceEntityIterator.hasNext()).andReturn(false)
        
    }
}