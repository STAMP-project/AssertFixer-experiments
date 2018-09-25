package com.sikza.socksapi.repositotries

import com.sikza.socksapi.models.Message
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface IMessagesRepository : MongoRepository<Message, String> {
    fun findTop100ByTo(emailAddress: String): ArrayList<Message>
    fun findTop100ByReplyTo(emailAddress: String): ArrayList<Message>
    fun findByFromAndTo(from: String, to: String): MutableList<Message>
    fun findTop1ByFromAndTo(from: String, to: String): Message?

}
