package org.nve.service

import org.nve.domain.Message
import org.nve.services.MessagingService
import javax.mail.*
import javax.mail.Transport.send

class LocalMessagingServiceImpl : MessagingService {

    override fun sendMessage(session: Session, message: Message) {
        send(message.toMimeMessage(session))
    }
}
