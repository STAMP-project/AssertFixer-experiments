package org.nve.resource

import org.nve.domain.Company
import org.nve.domain.Insurance
import org.nve.domain.Invoice
import org.nve.services.CompanyService
import org.nve.services.InsuranceService
import org.nve.services.InvoiceService
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Singleton
@Path("/api")
class ApiResource @Inject constructor(
        private val companyService: CompanyService,
        private val insuranceService: InsuranceService,
        private val invoiceService: InvoiceService
) {

    @POST
    @Path("company")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createCompany(company: Company): Response {
        companyService.create(company)
        return Response.ok().build()
    }

    @GET
    @Path("company")
    @Produces(MediaType.APPLICATION_JSON)
    fun getCompanies(): Response {
        return Response.ok().entity(companyService.read()).build()
    }

    @PUT
    @Path("company")
    @Produces(MediaType.APPLICATION_JSON)
    fun updateCompany(company: Company): Response {
        companyService.update(companyService.get(company.id), company)
        return Response.ok().build()
    }

    @DELETE
    @Path("company")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteCompany(company: Company): Response {
        companyService.delete(company)
        return Response.ok().build()
    }

    @POST
    @Path("insurance")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createInsurance(insurance: Insurance): Response {
        insuranceService.create(insurance)
        return Response.ok().build()
    }

    @GET
    @Path("insurance")
    @Produces(MediaType.APPLICATION_JSON)
    fun getInsurances(): Response {
        return Response.ok().entity(insuranceService.read()).build()
    }

    @PUT
    @Path("insurance")
    @Produces(MediaType.APPLICATION_JSON)
    fun updateInsurance(insurance: Insurance): Response {
        insuranceService.update(insuranceService.get(insurance.id), insurance)
        return Response.ok().build()
    }

    @DELETE
    @Path("insurance")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteCompany(insurance: Insurance): Response {
        insuranceService.delete(insurance)
        return Response.ok().build()
    }

    @POST
    @Path("invoice")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun createInvoice(invoice: Invoice): Response {
        invoiceService.create(invoice)
        return Response.ok().build()
    }

    @GET
    @Path("invoice")
    @Produces(MediaType.APPLICATION_JSON)
    fun getInvoices(): Response {
        return Response.ok().entity(invoiceService.read()).build()
    }

    @PUT
    @Path("invoice")
    @Produces(MediaType.APPLICATION_JSON)
    fun updateInvoice(invoice: Invoice): Response {
        invoiceService.update(invoiceService.get(invoice.id), invoice)
        return Response.ok().build()
    }

    @DELETE
    @Path("invoice")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteInvoice(invoice: Invoice): Response {
        invoiceService.delete(invoice)
        return Response.ok().build()
    }
}