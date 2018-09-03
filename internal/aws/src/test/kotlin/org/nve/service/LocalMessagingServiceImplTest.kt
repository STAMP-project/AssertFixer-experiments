package org.nve.service

import org.easymock.EasyMock.expect
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Message
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import javax.mail.Session
import javax.mail.Transport
import javax.mail.internet.*
import org.powermock.api.easymock.PowerMock.mockStatic


@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Message::class,
        Session::class,
        MimeMessage::class,
        Transport::class
)
class LocalMessagingServiceImplTest {

    @Test
    fun localClientServiceSmokeTest() {
        val mockMessage = createMock<Message>()
        val mockSession = createMock<Session>()
        val mockMimeMessage = createMock<MimeMessage>()
        mockStatic(Transport::class.java)

        val messagingService = LocalMessagingServiceImpl()
        expect(mockMessage.toMimeMessage(mockSession)).andReturn(mockMimeMessage)
        expect(Transport.send(mockMimeMessage))

        replayAndVerify {
            messagingService.sendMessage(mockSession, mockMessage)
        }
    }
}