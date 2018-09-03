package org.nve.exception

import java.util.*
import java.util.UUID.randomUUID
import javax.ws.rs.WebApplicationException
import javax.ws.rs.core.Response

abstract class ServerException: WebApplicationException {
    companion object {
        private const val DETAILS = "Additional Messaging Can Be Found int he application log with the following tag:"
    }

    private val status: Response.Status
    private val uuid: UUID?

    @Suppress("unused")
    protected constructor(
            message: String,
            status: Response.Status = Response.Status.INTERNAL_SERVER_ERROR
    ): super(message, status) {
        this.status = status
        this.uuid = null
    }

    protected constructor(
            cause: Throwable,
            message: String,
            status: Response.Status = Response.Status.INTERNAL_SERVER_ERROR
    ): this(cause, randomUUID(), message, status)

    private constructor(
            cause: Throwable,
            uuid: UUID,
            message: String,
            status: Response.Status
    ): super("$message $DETAILS $uuid.") {
        this.status = status
        this.uuid = uuid
    }

    override val message: String get() = super.message!!

    override fun getResponse(): Response =
            Response.status(status).entity(message).build()
}

