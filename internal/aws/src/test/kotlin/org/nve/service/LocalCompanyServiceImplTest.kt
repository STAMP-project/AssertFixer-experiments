package org.nve.service

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.typesafe.config.Config
import org.easymock.EasyMock.expect
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Company
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import kotlin.coroutines.experimental.buildIterator

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Config::class,
        Company::class
)
class LocalCompanyServiceImplTest {

    @Test
    fun localClientServiceSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockConfigList = createMock<List<Config>>()

        val companyService = LocalCompanyServiceImpl(mockConfig)

        expect(mockConfig.getConfigList("local_customers")).andReturn(mockConfigList)
        expect(mockConfigList.iterator()).andReturn(buildIterator {  })

        replayAndVerify {
            val clients = companyService.read()
            assert.that(clients.any(), equalTo(false))
        }
    }

    @Test
    fun readSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockCompaniesConfig = createMock<Config>()
        val mockAddressConfig = createMock<Config>()
        val mockPhoneNumberConfig = createMock<Config>()
        val mockFaxNumberConfig = createMock<Config>()
        val mockAttentionConfig = createMock<Config>()
        val mockNameConfig = createMock<Config>()

        expect(mockConfig.getConfigList("local_customers")).andReturn(listOf(mockCompaniesConfig))

        expect(mockCompaniesConfig.getLong("id")).andReturn(1L)
        expect(mockCompaniesConfig.getString("name")).andReturn("Read Test")

        expect(mockCompaniesConfig.getConfig("address")).andReturn(mockAddressConfig)
        expect(mockAddressConfig.getInt("street_number")).andReturn(100).times(2)
        expect(mockAddressConfig.getString("street_name")).andReturn("Test Street Name").times(2)
        expect(mockAddressConfig.getString("city")).andReturn("Test City").times(2)
        expect(mockAddressConfig.getString("state")).andReturn("CA").times(2)
        expect(mockAddressConfig.getInt("zip_code")).andReturn(90000).times(2)

        expect(mockCompaniesConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig)
        expect(mockPhoneNumberConfig.getInt("area_code")).andReturn(100).times(2)
        expect(mockPhoneNumberConfig.getInt("phone_number")).andReturn(1002).times(2)

        expect(mockCompaniesConfig.getConfig("fax_number")).andReturn(mockFaxNumberConfig)
        expect(mockFaxNumberConfig.getInt("area_code")).andReturn(100)
        expect(mockFaxNumberConfig.getInt("phone_number")).andReturn(1002)

        expect(mockCompaniesConfig.getConfig("attention")).andReturn(mockAttentionConfig)
        expect(mockAttentionConfig.getConfig("address")).andReturn(mockAddressConfig)
        expect(mockAttentionConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig)
        expect(mockAttentionConfig.getConfig("name")).andReturn(mockNameConfig)
        expect(mockNameConfig.getString("first_name")).andReturn("First")
        expect(mockNameConfig.getString("last_name")).andReturn("Last")

        val companyService = LocalCompanyServiceImpl(mockConfig)

        replayAndVerify {
            val clients = companyService.read()
            assert.that(clients.any(), equalTo(true))
            
            val client = clients.toList()[0]
            assert.that(client.id, equalTo(1L))
            assert.that(client.name, equalTo("Read Test"))
            
            assert.that(client.address.streetNumber, equalTo(100))
            assert.that(client.address.streetName, equalTo("Test Street Name"))
            assert.that(client.address.city, equalTo("Test City"))
            assert.that(client.address.state, equalTo("CA"))
            assert.that(client.address.zipCode, equalTo(90000))
            
            assert.that(client.phoneNumber.areaCode, equalTo(100))
            assert.that(client.phoneNumber.phoneNumber, equalTo(1002))
            
            assert.that(client.faxNumber.areaCode, equalTo(100))
            assert.that(client.faxNumber.phoneNumber, equalTo(1002))
        }
    }

    @Test
    fun createSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockCompaniesConfig = createMock<Config>()
        val mockAddressConfig = createMock<Config>()
        val mockPhoneNumberConfig = createMock<Config>()
        val mockFaxNumberConfig = createMock<Config>()
        val mockAttentionConfig = createMock<Config>()
        val mockNameConfig = createMock<Config>()

        expect(mockConfig.getConfigList("local_customers")).andReturn(listOf(mockCompaniesConfig))

        expect(mockCompaniesConfig.getLong("id")).andReturn(1L)
        expect(mockCompaniesConfig.getString("name")).andReturn("Create Test")

        expect(mockCompaniesConfig.getConfig("address")).andReturn(mockAddressConfig)
        expect(mockAddressConfig.getInt("street_number")).andReturn(100).anyTimes()
        expect(mockAddressConfig.getString("street_name")).andReturn("Test Street Name").anyTimes()
        expect(mockAddressConfig.getString("city")).andReturn("Test City").anyTimes()
        expect(mockAddressConfig.getString("state")).andReturn("CA").anyTimes()
        expect(mockAddressConfig.getInt("zip_code")).andReturn(90000).anyTimes()

        expect(mockCompaniesConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig)
        expect(mockPhoneNumberConfig.getInt("area_code")).andReturn(100).times(2)
        expect(mockPhoneNumberConfig.getInt("phone_number")).andReturn(1002).times(2)

        expect(mockCompaniesConfig.getConfig("fax_number")).andReturn(mockFaxNumberConfig)
        expect(mockFaxNumberConfig.getInt("area_code")).andReturn(100)
        expect(mockFaxNumberConfig.getInt("phone_number")).andReturn(1002)

        expect(mockCompaniesConfig.getConfig("attention")).andReturn(mockAttentionConfig)
        expect(mockAttentionConfig.getConfig("address")).andReturn(mockAddressConfig)
        expect(mockAttentionConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig)
        expect(mockAttentionConfig.getConfig("name")).andReturn(mockNameConfig)
        expect(mockNameConfig.getString("first_name")).andReturn("First")
        expect(mockNameConfig.getString("last_name")).andReturn("Last")

        val mockCompany = createMock<Company>()
        val companyService = LocalCompanyServiceImpl(mockConfig)

        replayAndVerify {
            companyService.create(mockCompany)
        }
    }

    @Test
    fun updateSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockCompaniesConfig = createMock<Config>()
        val mockAddressConfig = createMock<Config>()
        val mockPhoneNumberConfig = createMock<Config>()
        val mockFaxNumberConfig = createMock<Config>()
        val mockAttentionConfig = createMock<Config>()
        val mockNameConfig = createMock<Config>()

        expect(mockConfig.getConfigList("local_customers")).andReturn(listOf(mockCompaniesConfig))

        expect(mockCompaniesConfig.getLong("id")).andReturn(1L).anyTimes()
        expect(mockCompaniesConfig.getString("name")).andReturn("Update Test").anyTimes()

        expect(mockCompaniesConfig.getConfig("address")).andReturn(mockAddressConfig).anyTimes()
        expect(mockAddressConfig.getInt("street_number")).andReturn(100).anyTimes()
        expect(mockAddressConfig.getString("street_name")).andReturn("Test Street Name").anyTimes()
        expect(mockAddressConfig.getString("city")).andReturn("Test City").anyTimes()
        expect(mockAddressConfig.getString("state")).andReturn("CA").anyTimes()
        expect(mockAddressConfig.getInt("zip_code")).andReturn(90000).anyTimes()

        expect(mockCompaniesConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig).anyTimes()
        expect(mockPhoneNumberConfig.getInt("area_code")).andReturn(100).anyTimes()
        expect(mockPhoneNumberConfig.getInt("phone_number")).andReturn(1002).anyTimes()

        expect(mockCompaniesConfig.getConfig("fax_number")).andReturn(mockFaxNumberConfig).anyTimes()
        expect(mockFaxNumberConfig.getInt("area_code")).andReturn(100).anyTimes()
        expect(mockFaxNumberConfig.getInt("phone_number")).andReturn(1002).anyTimes()

        expect(mockCompaniesConfig.getConfig("attention")).andReturn(mockAttentionConfig).anyTimes()
        expect(mockAttentionConfig.getConfig("address")).andReturn(mockAddressConfig).anyTimes()
        expect(mockAttentionConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig).anyTimes()
        expect(mockAttentionConfig.getConfig("name")).andReturn(mockNameConfig).anyTimes()
        expect(mockNameConfig.getString("first_name")).andReturn("First").anyTimes()
        expect(mockNameConfig.getString("last_name")).andReturn("Last").anyTimes()

        val companyService = LocalCompanyServiceImpl(mockConfig)
        val mockCompanyOne = createMock<Company>()
        val mockCompanyTwo = createMock<Company>()

        replayAndVerify {
            companyService.update(mockCompanyOne, mockCompanyTwo)
        }
    }

    @Test
    fun deleteSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockCompaniesConfig = createMock<Config>()
        val mockAddressConfig = createMock<Config>()
        val mockPhoneNumberConfig = createMock<Config>()
        val mockFaxNumberConfig = createMock<Config>()
        val mockAttentionConfig = createMock<Config>()
        val mockNameConfig = createMock<Config>()

        expect(mockConfig.getConfigList("local_customers")).andReturn(listOf(mockCompaniesConfig))

        expect(mockCompaniesConfig.getLong("id")).andReturn(1L)
        expect(mockCompaniesConfig.getString("name")).andReturn("Delete Test")

        expect(mockCompaniesConfig.getConfig("address")).andReturn(mockAddressConfig)
        expect(mockAddressConfig.getInt("street_number")).andReturn(100).anyTimes()
        expect(mockAddressConfig.getString("street_name")).andReturn("Test Street Name").anyTimes()
        expect(mockAddressConfig.getString("city")).andReturn("Test City").anyTimes()
        expect(mockAddressConfig.getString("state")).andReturn("CA").anyTimes()
        expect(mockAddressConfig.getInt("zip_code")).andReturn(90000).anyTimes()

        expect(mockCompaniesConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig)
        expect(mockPhoneNumberConfig.getInt("area_code")).andReturn(100).times(2)
        expect(mockPhoneNumberConfig.getInt("phone_number")).andReturn(1002).times(2)

        expect(mockCompaniesConfig.getConfig("fax_number")).andReturn(mockFaxNumberConfig)
        expect(mockFaxNumberConfig.getInt("area_code")).andReturn(100)
        expect(mockFaxNumberConfig.getInt("phone_number")).andReturn(1002)

        expect(mockCompaniesConfig.getConfig("attention")).andReturn(mockAttentionConfig)
        expect(mockAttentionConfig.getConfig("address")).andReturn(mockAddressConfig)
        expect(mockAttentionConfig.getConfig("phone_number")).andReturn(mockPhoneNumberConfig)
        expect(mockAttentionConfig.getConfig("name")).andReturn(mockNameConfig)
        expect(mockNameConfig.getString("first_name")).andReturn("First")
        expect(mockNameConfig.getString("last_name")).andReturn("Last")

        val companyService = LocalCompanyServiceImpl(mockConfig)
        val mockCompany = createMock<Company>()

        replayAndVerify {
            companyService.delete(mockCompany)
        }
    }
}