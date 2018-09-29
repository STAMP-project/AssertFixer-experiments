package org.nve.service

import org.hibernate.HibernateException
import org.nve.domain.Company
import org.nve.domain.Company.*
import org.nve.exception.ExpectedException
import org.nve.services.CompanyService
import org.nve.persistence.dao.CompaniesEntity
import org.nve.persistence.SessionFactory
import javax.inject.Inject

class CompanyServiceImpl @Inject constructor(
        private val sessionFactory: SessionFactory
): CompanyService {

    override fun read(): Set<Company> =
            sessionFactory()
                    .createQuery("from CompaniesEntity as companyEntity")
                    .list()
                    .asSequence()
                    .map { (it as CompaniesEntity).toCompany() }
                    .toSet()

    override fun get(id: Long): Company =
            sessionFactory()
                    .use {
                        it.beginTransaction()
                        val compEnt = (it.get(CompaniesEntity::class.java, id)).toCompany()
                        it.transaction.commit()
                        compEnt
                    }

    override fun delete(client: Company) =
            sessionFactory()
                    .use {
                        try {
                            it.beginTransaction()
                            it.createQuery("delete CompaniesEntity where id = ${client.id}")
                                    .executeUpdate()
                            it.transaction.commit()
                        }
                        catch (e: HibernateException) {
                            it.transaction.rollback()
                            throw ExpectedException(e, "Error encountered when attempting to delete Company ID: ${client.id} in the database")
                        }
                    }

    override fun create(client: Company) =
            sessionFactory()
                    .use {
                        try {
                            it.beginTransaction()
                            it.save("companies", toCompanyEntity(client))
                            it.transaction.commit()
                        }
                        catch (e: HibernateException) {
                            it.transaction.rollback()
                            throw ExpectedException(e, "Error encountered when attempting to add Company ID: ${client.id} to the database")
                        }
                    }

    override fun update(original: Company, updated: Company) =
            sessionFactory()
                    .use {
                        if (original.id != updated.id)
                            throw ExpectedException(IllegalStateException(), "Illegal Update! Original ID: ${original.id}, Updated ID: ${updated.id}")
                        try {
                            it.beginTransaction()
                            it.update("companies", toCompanyEntity(updated))
                            it.transaction.commit()
                        }
                        catch (e: HibernateException) {
                            it.transaction.rollback()
                            throw ExpectedException(e, "Error encountered when attempting to update Company ID: ${original.id} in the database")
                        }
                    }

    private fun toCompanyEntity(client: Company): CompaniesEntity {
        val compEnt = CompaniesEntity()
        compEnt.companyName = client.name
        compEnt.streetNumber = client.address.streetNumber
        compEnt.streetName = client.address.streetName
        compEnt.city = client.address.city
        compEnt.state = client.address.state
        compEnt.zip = client.address.zipCode
        compEnt.phoneNumber = client.phoneNumber.phoneNumber
        compEnt.phoneAreaCode = client.phoneNumber.areaCode
        compEnt.faxNumber = client.faxNumber.phoneNumber
        compEnt.faxAreaCode = client.faxNumber.areaCode
        compEnt.attentionStreetNumber = client.attention?.address?.streetNumber
        compEnt.attentionStreetName = client.attention?.address?.streetName
        compEnt.attentionCity = client.attention?.address?.city
        compEnt.attentionState = client.attention?.address?.state
        compEnt.attentionZip = client.attention?.address?.zipCode
        compEnt.attentionFirstName = client.attention?.name?.firstName
        compEnt.attentionLastName = client.attention?.name?.lastName
        compEnt.attentionPhoneNumber = client.attention?.phoneNumber?.phoneNumber
        compEnt.attentionPhoneAreaCode = client.attention?.phoneNumber?.areaCode

        when (client) {
            is Brokerage -> {
                compEnt.isBrokerage = 1
                compEnt.isAgency = 0
                compEnt.isCustomer = 0
            }
            is Agency -> {
                compEnt.isBrokerage = 0
                compEnt.isAgency = 1
                compEnt.isCustomer = 0
            }
            is Customer -> {
                compEnt.isBrokerage = 0
                compEnt.isAgency = 0
                compEnt.isCustomer = 1
            }
        }
        return compEnt
    }
}