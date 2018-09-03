package org.nve.domain.generic

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.testing.createMock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Address::class,
        PhoneNumber::class
)
class IndividualTest {

    @Test
    fun individualNameSmokeTest() {
        val name =  Individual.Name(
                firstName = "First",
                lastName = "Last"
        )

        assert.that(name, !equalTo<Individual.Name>(null))
    }

    @Test
    fun individualSmokeTest() {
        val mockAddress = createMock<Address>()
        val mockPhoneNumber = createMock<PhoneNumber>()
        val name =  Individual.Name(
                firstName = "First",
                lastName = "Last"
        )

        val individual = Individual(
                name = name,
                address = mockAddress,
                phoneNumber = mockPhoneNumber
        )

        assert.that(individual, !equalTo<Individual>(null))
    }
}