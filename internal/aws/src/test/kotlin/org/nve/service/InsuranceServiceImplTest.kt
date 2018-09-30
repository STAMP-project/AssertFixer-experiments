package org.nve.service

import org.hibernate.Session
import org.junit.Test
import org.nve.domain.Insurance
import org.nve.persistence.SessionFactory
import org.nve.testing.createMock
import org.easymock.EasyMock.expect
import org.hibernate.query.Query
import org.nve.persistence.dao.InsuranceEntity
import java.time.Instant

/*@RunWith(PowerMockRunner::class)
@PrepareForTest(
        SessionFactory::class,
        Session::class,
        InsuranceEntity::class,
        Insurance::class
)*/
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
        expect(mockInsuranceEntityIterator.hasNext()).andReturn(false)

    }

    //Integration test to validate interaction with database. Comment out prior to push.
    @Test
    fun insuranceServiceIntegrationSaveTest() {
        val sessionFactory = SessionFactory()
        val insuranceServiceImpl = InsuranceServiceImpl(sessionFactory)
        val insurance = Insurance.Endorsement(
                id = 1,
                number = "1234",
                terms = Insurance.Terms(
                        id = 1,
                        effectiveDate = Instant.now(),
                        expirationDate = Instant.now(),
                        dueDate = Instant.now()
                ),
                policyChange = "This is a policy change note."
        )
        insuranceServiceImpl.create(insurance)
    }

    @Test fun insuranceServiceIntegrationGetTest() {
        print("Bond: " + InsuranceServiceImpl(SessionFactory())
                .get(6)
                .terms
                .effectiveDate
                .toString())
        print("Endorsement: " + InsuranceServiceImpl(SessionFactory())
                .get(11)
                .terms
                .effectiveDate
                .toString())
    }

}