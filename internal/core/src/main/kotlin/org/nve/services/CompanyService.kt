package org.nve.services

import org.nve.domain.Company

interface CompanyService {
    fun create(client: Company)
    fun read(): Set<Company>
    fun get(id: Long): Company
    fun update(original: Company, updated: Company)
    fun delete(client: Company)
}