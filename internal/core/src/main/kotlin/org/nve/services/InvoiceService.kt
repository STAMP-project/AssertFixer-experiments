package org.nve.services

import org.nve.domain.Invoice

interface InvoiceService {
    fun read(): Set<Invoice>
    fun get(id: Long): Invoice
    fun create(invoice: Invoice)
    fun delete(invoice: Invoice)
    fun update(original: Invoice, updated: Invoice)
}