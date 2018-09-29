package org.nve.service

import com.typesafe.config.Config
import org.nve.domain.Company
import org.nve.domain.generic.Address
import org.nve.domain.generic.Individual
import org.nve.domain.generic.PhoneNumber
import org.nve.services.CompanyService
import javax.inject.Inject
import javax.ws.rs.NotFoundException
import kotlin.LazyThreadSafetyMode.NONE

class LocalCompanyServiceImpl @Inject constructor(
        val config: Config
) : CompanyService {
    override fun read(): Set<Company> = clients.toSet()

    override fun get(id: Long): Company = clients.find { it.id == id } ?: throw NotFoundException("No Customer found with id $id")

    override fun delete(client: Company) {
        clients.toMutableList().removeIf { it == client }
    }

    override fun create(client: Company) {
        clients.toMutableList().add(client)
    }

    override fun update(original: Company, updated: Company) {
        clients.toMutableList().removeIf { it == original }
        clients.toMutableList().add(updated)
    }

    private val clients: Sequence<Company> by lazy(NONE) {
        config.getConfigList("local_customers")
                .asSequence()
                .map {
                    Company.Customer(
                            id = it.getLong("id"),
                            name = it.getString("name"),
                            address = toAddress(it.getConfig("address"))!!,
                            phoneNumber = toPhoneNumber(it.getConfig("phone_number"))!!,
                            faxNumber = toPhoneNumber(it.getConfig("fax_number"))!!,
                            attention = toIndividual(it.getConfig("attention"))
                    )
                }
    }

    private fun toAddress(config: Config): Address? =
            Address(
                    streetNumber = config.getInt("street_number"),
                    streetName = config.getString("street_name"),
                    city = config.getString("city"),
                    state = config.getString("state"),
                    zipCode = config.getInt("zip_code")
            )

    private fun toPhoneNumber(config: Config): PhoneNumber? =
            PhoneNumber(
                    areaCode = config.getInt("area_code"),
                    phoneNumber = config.getInt("phone_number")
            )

    private fun toName(config: Config): Individual.Name =
            Individual.Name(
                    firstName = config.getString("first_name"),
                    lastName = config.getString("last_name")
            )

    private fun toIndividual(config: Config): Individual? =
            Individual(
                    name = toName(config.getConfig("name")),
                    address = toAddress(config.getConfig("address")),
                    phoneNumber = toPhoneNumber(config.getConfig("phone_number"))
            )
}