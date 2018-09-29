package org.nve.service

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.hibernate.Session
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Company
import org.nve.domain.generic.Address
import org.nve.domain.generic.Individual
import org.nve.domain.generic.PhoneNumber
import org.nve.exception.ExpectedException
import org.nve.persistence.SessionFactory
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import org.easymock.EasyMock.expect
import org.hibernate.query.Query
import org.nve.persistence.dao.CompaniesEntity

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        SessionFactory::class,
        Session::class,
        CompaniesEntity::class,
        Company::class
)
class CompanyServiceImplTest {

    @Test
    fun readSmokeTest() {
        val mockSessionFactory = createMock<SessionFactory>()
        val mockSession = createMock<Session>()
        val mockQuery = createMock<Query<Any>>()
        val mockCompaniesEntityList = createMock<List<CompaniesEntity>>()
        val mockCompaniesEntityIterator = createMock<Iterator<CompaniesEntity>>()
        val mockCompaniesEntity = createMock<CompaniesEntity>()
        val mockCompany = createMock<Company>()

        val companyService = CompanyServiceImpl(mockSessionFactory)

        expect(mockSessionFactory.invoke()).andReturn(mockSession)
        expect(mockSession.createQuery("from CompaniesEntity as companyEntity")).andReturn(mockQuery)
        expect(mockQuery.list()).andReturn(mockCompaniesEntityList)
        expect(mockCompaniesEntityList.iterator()).andReturn(mockCompaniesEntityIterator)
        expect(mockCompaniesEntityIterator.hasNext()).andReturn(true)
        expect(mockCompaniesEntityIterator.next()).andReturn(mockCompaniesEntity)
        expect(mockCompaniesEntity.toCompany()).andReturn(mockCompany)
        expect(mockCompaniesEntityIterator.hasNext()).andReturn(false)

        replayAndVerify {
            val clients = companyService.read()
            assert.that(clients.any(), equalTo(true))
        }
    }
}