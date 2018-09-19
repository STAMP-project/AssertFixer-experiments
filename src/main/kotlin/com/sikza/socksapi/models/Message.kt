package com.sikza.socksapi.models

import java.time.LocalDateTime

class Message() {
    var from: String = ""
    var replyTo: String = ""
    var body: String = ""
    var to: String = ""
    var conversationId: String = ""
    val messageDate: LocalDateTime = LocalDateTime.now()

    constructor(from: String, replyTo: String, body: String, to: String, conversationId: String) : this() {
        this.from = from
        this.to = to
        this.replyTo = replyTo
        this.body = body
        this.conversationId = conversationId
    }

    override fun toString(): String {
        return "Message(from='$from', replyTo='$replyTo', body='$body', to='$to', conversationId='$conversationId', messageDate=$messageDate)"
    }
}