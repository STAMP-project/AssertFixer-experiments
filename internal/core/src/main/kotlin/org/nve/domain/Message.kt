package org.nve.domain

import org.nve.domain.generic.Email
import javax.mail.Message
import javax.mail.Session
import javax.mail.internet.MimeMessage

class Message(
        val from: Email,
        val to: Set<Email>,
        val subject: String,
        val body: String,
        val insurance: Set<Insurance>?
) {
    fun toMimeMessage(session: Session): MimeMessage {
        val mimeMessage = MimeMessage(session)
        mimeMessage.subject = subject
        mimeMessage.setText(body)
        mimeMessage.setFrom(from)
        mimeMessage.setRecipients(Message.RecipientType.TO, to.toTypedArray())
        return mimeMessage
    }

}