package org.nve.service

import org.hibernate.Session
import org.nve.domain.Company
import org.nve.services.CompanyService
import kotlin.LazyThreadSafetyMode.NONE
import org.nve.persistence.dao.CompaniesEntity
import org.nve.persistence.SessionFactoryImpl
import javax.inject.Inject

class hibernateScratch @Inject constructor(
        val sessionFactory: SessionFactoryImpl
) {
    val session = sessionFactory.buildSession()

    fun create() {
        var companyEntity = CompaniesEntity()
        companyEntity.id = 1
        companyEntity.companyName = "sample name"
        companyEntity.addressNumber = 1234
        companyEntity.streetName = "Chestnut Street"
        companyEntity.stateAbbreviation = "CA"
        companyEntity.phoneNumber = "5552345678"
        companyEntity.attention = "John Doe"
        companyEntity.zip = "99123"
        companyEntity.faxNumber = "5551234556"
        companyEntity.isBrokerage = 0
        companyEntity.isAgency = 1
        companyEntity.isCustomer = 0

        session.beginTransaction()
        print("Trying to save the company entity")
        session.save("companies", companyEntity)
        session.getTransaction().commit()
        session.close()
    }
}