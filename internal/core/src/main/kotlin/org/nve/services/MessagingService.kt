package org.nve.services

import org.nve.domain.Message
import javax.mail.Session

interface MessagingService {
    fun sendMessage(session: Session, message: Message)
}