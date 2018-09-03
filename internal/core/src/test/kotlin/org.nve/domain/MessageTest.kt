package org.nve.domain

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.generic.Email
import org.nve.testing.createMock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Email::class
)
class MessageTest {

    @Test
    fun messageSmokeTest() {
        val mockFrom = createMock<Email>()
        val mockTo = createMock<Set<Email>>()

        val message = Message(
                from = mockFrom,
                to = mockTo,
                subject = "Subject",
                body = "Body",
                insurance = null
        )

        assert.that(message, !equalTo<Message>(null))
    }
}