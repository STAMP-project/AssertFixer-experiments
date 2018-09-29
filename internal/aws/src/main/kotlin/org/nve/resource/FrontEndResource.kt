package org.nve.resource

import org.nve.services.CompanyService
import org.nve.services.InvoiceService
import org.nve.template.Template
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Singleton
@Path("/")
class FrontEndResource @Inject constructor(
        private val clientService: CompanyService,
        private val invoiceService: InvoiceService
) {

    @GET
    @Produces(MediaType.TEXT_HTML)
    fun index(): Template {
        val clients = clientService.read()
        return Template("index", mapOf(
                "title" to "Home",
                "clients" to clients
        ))
    }

    @GET
    @Path("/clients")
    @Produces(MediaType.TEXT_HTML)
    fun getClients(): Template {
        val clients = clientService.read()
        return Template("clients", mapOf(
                "title" to "Clients",
                "clients" to clients
        ))
    }

    @GET
    @Path("/invoices")
    @Produces(MediaType.TEXT_HTML)
    fun getInvoices(): Template {
        val invoices = invoiceService.read()
        return Template("invoices", mapOf(
                "title" to "Invoices",
                "invoices" to invoices
        ))
    }

    @GET
    @Path("/insurance")
    @Produces(MediaType.TEXT_HTML)
    fun getInsurance(): Template {
        return Template("insurance", mapOf(
                "title" to "Insurance"
        ))
    }

    @GET
    @Path("/certificates")
    @Produces(MediaType.TEXT_HTML)
    fun getCertificates(): Template {
        return Template("certificates", mapOf(
                "title" to "Certificates"
        ))
    }

    @GET
    @Path("/sign_in")
    @Produces(MediaType.TEXT_HTML)
    fun getSignIn(): Template {
        return Template("sign_in", mapOf(
                "title" to "Sign In"
        ))
    }
}
