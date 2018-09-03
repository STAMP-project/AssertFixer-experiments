package org.nve.services

import org.nve.domain.Insurance

interface InsuranceService {
    fun read(): Set<Insurance>
    fun get(id: Long): Insurance
    fun update(current: Insurance, updated: Insurance)
    fun create(insurance: Insurance)
    fun delete(insurance: Insurance)
    fun renew(insurance: Insurance)
}