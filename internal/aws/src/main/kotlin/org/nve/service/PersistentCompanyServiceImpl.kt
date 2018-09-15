/*package org.nve.service

import org.hibernate.Session
import org.nve.domain.Company
import org.nve.services.CompanyService
import kotlin.LazyThreadSafetyMode.NONE
import org.nve.persistence.dao.CompaniesEntity
import org.nve.persistence.SessionFactoryImpl
import javax.inject.Inject

class PersistentCompanyServiceImpl @Inject constructor(
        val sessionFactory: SessionFactoryImpl
) : CompanyService {

    val session = sessionFactory.buildSession()



    override fun read(): Set<Company> {

    }

    override fun get(id: Long): Company {

    }

    override fun delete(client: Company) {

    }

    override fun create(client: Company) {
        var companyEntity = CompaniesEntity()
        companyEntity.id = 1
        companyEntity.companyName = "sample name"
        companyEntity.addressNumber = 1234
        companyEntity.streetName = "Chestnut Street"
        companyEntity.stateAbbreviation = "CA"
        companyEntity.phoneNumber = "555-234-5678"
        companyEntity.attention = "John Doe"
        companyEntity.zip = "99123"
        companyEntity.faxNumber = "555-123-4556"
        companyEntity.isBrokerage = 0
        companyEntity.isAgency = 1
        companyEntity.isCustomer = 0

    }

    override fun update(oiginal: Company, updated: Company) {

    }

    /*private val clients: Sequence<Company> by lazy(NONE) {

    }*/

}*/