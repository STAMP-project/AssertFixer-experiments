package org.nve.persistence.dao

import org.nve.domain.Company
import org.nve.domain.generic.Address
import org.nve.domain.generic.Individual
import org.nve.domain.generic.PhoneNumber
import javax.persistence.*

@Entity
@Table(name = "companies", schema = "ibs", catalog = "")
class CompaniesEntity {
    @get:Id
    @get:Column(name = "ID")
    var id: Long = 0
    @get:Basic
    @get:Column(name = "company_name")
    var companyName: String = ""
    @get:Basic
    @get:Column(name = "street_number")
    var streetNumber: Int = 0
    @get:Basic
    @get:Column(name = "street_name")
    var streetName: String = ""
    @get:Basic
    @get:Column(name = "city")
    var city: String = ""
    @get:Basic
    @get:Column(name = "state")
    var state: String = ""
    @get:Basic
    @get:Column(name = "phone_number")
    var phoneNumber: Int = 0
    @get:Basic
    @get:Column(name = "phone_area_code")
    var phoneAreaCode: Int = 0
    @get:Basic
    @get:Column(name = "zip")
    var zip: Int = 0
    @get:Basic
    @get:Column(name = "fax_number")
    var faxNumber: Int = 0
    @get:Basic
    @get:Column(name = "fax_area_code")
    var faxAreaCode: Int = 0
    @get:Basic
    @get:Column(name = "is_brokerage")
    var isBrokerage: Byte = 0
    @get:Basic
    @get:Column(name = "is_agency")
    var isAgency: Byte = 0
    @get:Basic
    @get:Column(name = "is_customer")
    var isCustomer: Byte = 0
    @get:Basic
    @get:Column(name = "attention_first_name")
    var attentionFirstName: String? = null
    @get:Basic
    @get:Column(name = "attention_last_name")
    var attentionLastName: String? = null
    @get:Basic
    @get:Column(name = "attention_street_number")
    var attentionStreetNumber: Int? = null
    @get:Basic
    @get:Column(name = "attention_street_name")
    var attentionStreetName: String? = null
    @get:Basic
    @get:Column(name = "attention_city")
    var attentionCity: String? = null
    @get:Basic
    @get:Column(name = "attention_state")
    var attentionState: String? = null
    @get:Column(name = "attention_zip")
    var attentionZip: Int? = 0
    @get:Basic
    @get:Column(name = "attention_phone_number")
    var attentionPhoneNumber: Int? = null
    @get:Basic
    @get:Column(name = "attention_phone_area_code")
    var attentionPhoneAreaCode: Int? = null


    fun toCompany(): Company {
        if (isBrokerage.compareTo(1) == 0) { //If the entity is a brokerage
            return Company.Brokerage(
                    id = id,
                    name = companyName,
                    address = Address(
                            streetNumber,
                            streetName,
                            city,
                            state,
                            zip
                    ),
                    phoneNumber = PhoneNumber(phoneAreaCode, phoneNumber),
                    faxNumber = PhoneNumber(faxAreaCode, faxNumber),
                    attention = Individual(
                            name = Individual.Name(
                                    attentionFirstName ?: "",
                                    attentionLastName ?: ""
                            ),
                            address = Address(
                                    attentionStreetNumber ?: 0,
                                    attentionStreetName ?: "",
                                    attentionCity ?: "",
                                    state,
                                    zip
                            ),
                            phoneNumber = PhoneNumber(
                                    attentionPhoneAreaCode ?: 0,
                                    attentionPhoneNumber ?: 0
                            )
                    )
            )
        }

        if (isAgency.compareTo(1) == 0) { //If the entity is an agency
            return Company.Agency(
                    id = id,
                    name = companyName,
                    address = Address(
                            streetNumber,
                            streetName,
                            city,
                            state,
                            zip
                    ),
                    phoneNumber = PhoneNumber(phoneAreaCode, phoneNumber),
                    faxNumber = PhoneNumber(faxAreaCode, faxNumber),
                    attention = Individual(
                            name = Individual.Name(
                                    attentionFirstName ?: "",
                                    attentionLastName ?: ""
                            ),
                            address = Address(
                                    attentionStreetNumber ?: 0,
                                    attentionStreetName ?: "",
                                    city,
                                    state,
                                    zip
                            ),
                            phoneNumber = PhoneNumber(
                                    attentionPhoneAreaCode ?: 0,
                                    attentionPhoneNumber ?: 0
                            )
                    )
            )
        }

        return Company.Agency(
                id = id,
                name = companyName,
                address = Address(
                        streetNumber,
                        streetName,
                        city,
                        state,
                        zip
                ),
                phoneNumber = PhoneNumber(phoneAreaCode, phoneNumber),
                faxNumber = PhoneNumber(faxAreaCode, faxNumber),
                attention = Individual(
                        name = Individual.Name(
                                attentionFirstName ?: "",
                                attentionLastName ?: ""
                        ),
                        address = Address(
                                attentionStreetNumber ?: 0,
                                attentionStreetName ?: "",
                                city,
                                state,
                                zip
                        ),
                        phoneNumber = PhoneNumber(
                                attentionPhoneAreaCode ?: 0,
                                attentionPhoneNumber ?: 0
                        )
                )
        )
    }


    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as CompaniesEntity?

        if (id != that!!.id) return false
        if (streetNumber != that.streetNumber) return false
        if (phoneNumber != that.phoneNumber) return false
        if (phoneAreaCode != that.phoneAreaCode) return false
        if (isBrokerage != that.isBrokerage) return false
        if (isAgency != that.isAgency) return false
        if (isCustomer != that.isCustomer) return false
        if (if (companyName != null) companyName != that.companyName else that.companyName != null) return false
        if (if (streetName != null) streetName != that.streetName else that.streetName != null) return false
        if (if (city != null) city != that.city else that.city != null) return false
        if (if (state != null) state != that.state else that.state != null) return false
        if (if (zip != null) zip != that.zip else that.zip != null) return false
        if (if (faxNumber != null) faxNumber != that.faxNumber else that.faxNumber != null) return false
        if (if (faxAreaCode != null) faxAreaCode != that.faxAreaCode else that.faxAreaCode != null) return false
        if (if (attentionFirstName != null) attentionFirstName != that.attentionFirstName else that.attentionFirstName != null)
            return false
        if (if (attentionLastName != null) attentionLastName != that.attentionLastName else that.attentionLastName != null)
            return false
        if (if (attentionStreetNumber != null) attentionStreetNumber != that.attentionStreetNumber else that.attentionStreetNumber != null)
            return false
        if (if (attentionStreetName != null) attentionStreetName != that.attentionStreetName else that.attentionStreetName != null)
            return false
        if (if (attentionCity != null) attentionCity != that.attentionCity else that.attentionCity != null)
            return false
        if (if (attentionZip != null) attentionZip != that.attentionZip else that.attentionZip != null)
            return false
        if (if (attentionState != null) attentionState != that.attentionState else that.attentionState != null)
            return false
        if (if (attentionPhoneNumber != null) attentionPhoneNumber != that.attentionPhoneNumber else that.attentionPhoneNumber != null)
            return false
        return if (if (attentionPhoneAreaCode != null) attentionPhoneAreaCode != that.attentionPhoneAreaCode else that.attentionPhoneAreaCode != null) false else true

    }

    override fun hashCode(): Int {
        var result = id.toInt()
        result = 31 * result + if (companyName != null) companyName!!.hashCode() else 0
        result = 31 * result + streetNumber
        result = 31 * result + if (streetName != null) streetName!!.hashCode() else 0
        result = 31 * result + if (city != null) city!!.hashCode() else 0
        result = 31 * result + if (state != null) state!!.hashCode() else 0
        result = 31 * result + phoneNumber
        result = 31 * result + phoneAreaCode
        result = 31 * result + if (zip != null) zip!!.hashCode() else 0
        result = 31 * result + if (faxNumber != null) faxNumber!!.hashCode() else 0
        result = 31 * result + if (faxAreaCode != null) faxAreaCode!!.hashCode() else 0
        result = 31 * result + isBrokerage.toInt()
        result = 31 * result + isAgency.toInt()
        result = 31 * result + isCustomer.toInt()
        result = 31 * result + if (attentionFirstName != null) attentionFirstName!!.hashCode() else 0
        result = 31 * result + if (attentionLastName != null) attentionLastName!!.hashCode() else 0
        result = 31 * result + if (attentionStreetNumber != null) attentionStreetNumber!!.hashCode() else 0
        result = 31 * result + if (attentionStreetName != null) attentionStreetName!!.hashCode() else 0
        result = 31 * result + if (attentionCity != null) attentionCity!!.hashCode() else 0
        result = 31 * result + if (attentionState != null) attentionState!!.hashCode() else 0
        result = 31 * result + if (attentionZip != null) attentionZip!!.hashCode() else 0
        result = 31 * result + if (attentionPhoneNumber != null) attentionPhoneNumber!!.hashCode() else 0
        result = 31 * result + if (attentionPhoneAreaCode != null) attentionPhoneAreaCode!!.hashCode() else 0
        return result
    }
}
