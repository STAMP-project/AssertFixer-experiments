package com.sikza.socksapi.services

import com.sikza.socksapi.models.Message
import com.sikza.socksapi.repositotries.IMessagesRepository
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.stereotype.Service
import org.springframework.util.Assert
import java.util.*

@Service
class MessageService(
        private val messageRepository: IMessagesRepository,
        private val messageSendingTemplate: SimpMessageSendingOperations
) : IMessageService {

    override fun getConversation(from: String, to: String): MutableList<Message> {
        Assert.hasLength(from, "target source cannot be empty")
        Assert.hasLength(to, "target destination cannot be empty")
        return messageRepository.findByFromAndTo(from, to)
    }

    override fun getRecentMessage(emailAddress: String): Collection<Message> {
        Assert.hasLength(emailAddress.trim(), "target email cannot be empty")
        var sentMessages = messageRepository.findTop100ByReplyTo(emailAddress)
        var received = messageRepository.findTop100ByTo(emailAddress)
        sentMessages.addAll(received)
        sentMessages.sortBy {
            it.messageDate
        }
        return sentMessages
    }

    override fun route(message: Message) {
        validateMessage(message)
        ensureConversationId(message)
        this.messageRepository.save(message)
        this.messageSendingTemplate.convertAndSend("/topic/${message.to}", message)
    }

    private fun ensureConversationId(message: Message) {
        matchExistingConversation(message)
        if (message.from == "Khwela System" ||
                message.replyTo.equals("NonReply", ignoreCase = false)) {
            message.conversationId = "000000"
        }
    }

    fun matchExistingConversation(message: Message) {
        if (message.conversationId.length != UUID.randomUUID().toString().length) {
            var exiting = messageRepository.findTop1ByFromAndTo(message.from, message.to)
            message.conversationId = exiting?.conversationId ?: UUID.randomUUID().toString()
        }
    }

    private fun validateMessage(message: Message) {
        Assert.hasLength(message.from, "message source cannot be empty")
        Assert.hasLength(message.to, "message destination cannot be empty")
        Assert.hasLength(message.replyTo, "'replyTo' cannot be empty")
        Assert.hasLength(message.body, "message body cannot be empty")
    }
}
