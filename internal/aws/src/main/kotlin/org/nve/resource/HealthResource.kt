package org.nve.resource

import javax.inject.Singleton
import javax.ws.rs.*
import javax.ws.rs.core.MediaType.*
import javax.ws.rs.core.Response

@Singleton
@Path("/monitor/health")
class HealthResource {

    @GET
    @Produces(TEXT_PLAIN)
    fun health(): Response {
        return Response.ok().build()
    }
}
