package org.nve.domain

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.generic.Address
import org.nve.domain.generic.Individual
import org.nve.domain.generic.PhoneNumber
import org.nve.testing.createMock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Address::class,
        PhoneNumber::class,
        Individual::class
)
class CompanyTest {
    private val mockAddress =  createMock<Address>()
    private val mockPhoneNumber = createMock<PhoneNumber>()
    private val mockFaxNumber = createMock<PhoneNumber>()
    private val mockIndividual = createMock<Individual>()

    @Test
    fun companyBrokerageSmokeTest() {
        val company = Company.Brokerage(
                id = 1,
                name = "Brokerage",
                address = mockAddress,
                phoneNumber = mockPhoneNumber,
                faxNumber = mockFaxNumber,
                attention = mockIndividual
        )

        assert.that(company, !equalTo<Company>(null))
    }

    @Test
    fun companyCustomerSmokeTest() {
        val company = Company.Customer(
                id = 1,
                name = "Customer",
                address = mockAddress,
                phoneNumber = mockPhoneNumber,
                faxNumber = mockFaxNumber,
                attention = mockIndividual
        )

        assert.that(company, !equalTo<Company>(null))
    }

    @Test
    fun companyAgencySmokeTest() {
        val company = Company.Agency(
                id = 1,
                name = "Agency",
                address = mockAddress,
                phoneNumber = mockPhoneNumber,
                faxNumber = mockFaxNumber,
                attention = mockIndividual
        )

        assert.that(company, !equalTo<Company>(null))
    }
}