package org.nve.domain.generic

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test

class PhoneNumberTest {

    @Test
    fun phoneNumberSmokeTest() {
        val phoneNumber = PhoneNumber(
                areaCode = 555,
                phoneNumber = 1234567
        )

        assert.that(phoneNumber, !equalTo<PhoneNumber>(null))
    }
}