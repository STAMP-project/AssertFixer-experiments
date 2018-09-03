package org.nve.domain.generic

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test


class EmailTest{

    @Test
    fun emailSmokeTest() {
        val email = Email(
                user = "user",
                domain = "domain.com"
        )

        assert.that(email, !equalTo<Email>(null))
    }
}
