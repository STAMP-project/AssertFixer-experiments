package org.nve.service

import com.typesafe.config.Config
import org.nve.domain.Invoice
import org.nve.services.CompanyService
import org.nve.services.InsuranceService
import org.nve.services.InvoiceService
import java.time.Instant
import javax.inject.Inject
import kotlin.LazyThreadSafetyMode.NONE

class LocalInvoiceServiceImpl @Inject constructor(
        private val config: Config,
        private val companyService: CompanyService,
        private val insuranceService: InsuranceService
) : InvoiceService {
    private val invoices: Set<Invoice> by lazy(NONE) {
        val companies = companyService.read().asSequence()
        val insurances = insuranceService.read().asSequence()
        config.getConfigList("local_invoices")
                .asSequence()
                .map { invoice ->
                    Invoice(
                            id = invoice.getLong("id"),
                            customer = companies.find { company ->
                                company.id == invoice.getLong("customer")
                            }!!,
                            insurance = insurances.find { insurance ->
                                insurance.id == invoice.getLong("insurance")
                            }!!,
                            transactions = toTransactions(invoice.getConfigList("transactions")),
                            created = Instant.parse(invoice.getString("created")),
                            due = Instant.parse(invoice.getString("due")),
                            comment = invoice.getString("comment")
                    )
                }
                .toSet()
    }

    override fun get(id: Long): Invoice =
            invoices.find { id == it.id } ?: throw NoSuchElementException("No element was found with the id $id")

    override fun read(): Set<Invoice> = invoices

    override fun create(invoice: Invoice) {
        invoices
                .toMutableSet()
                .add(invoice)
    }

    override fun delete(invoice: Invoice) {
        invoices
                .toMutableSet()
                .remove(invoice)
    }

    override fun update(original: Invoice, updated: Invoice) {
        invoices.toMutableSet().remove(original)
        invoices.toMutableSet().add(updated)
    }

    private fun toTransactions(configs: List<Config>): Set<Invoice.Transaction> =
            configs.map {
                if (it.getString("type") == "credit")
                    Invoice.Transaction.Credit(
                            amount = it.getDouble("amount"),
                            date = Instant.parse(it.getString("date"))
                    )
                else
                    Invoice.Transaction.Debit(
                            amount = it.getDouble("amount"),
                            date = Instant.parse(it.getString("date"))
                    )
            }.toSet()
}

