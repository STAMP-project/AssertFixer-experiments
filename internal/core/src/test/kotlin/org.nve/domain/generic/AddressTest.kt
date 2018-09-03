package org.nve.domain.generic

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class AddressTest {

    @Test
    fun addressSmokeTest() {
        val address = Address(
                streetNumber = 1234,
                streetName = "Street Ave.",
                city = "Cool Town",
                state = "CA",
                zipCode = 12345
        )

        assert.that(address, !equalTo<Address>(null))
    }
}