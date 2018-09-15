package org.nve.persistence.dao

import javax.persistence.*

@Entity
@Table(name = "companies", schema = "ibs", catalog = "")

class CompaniesEntity {
    @get:Id
    @get:Column(name = "ID")
    var id: Int = 0

    @get:Basic
    @get:Column(name = "company_name")
    var companyName: String? = null

    @get:Basic
    @get:Column(name = "address_number")
    var addressNumber: Int = 0

    @get:Basic
    @get:Column(name = "street_name")
    var streetName: String? = null

    @get:Basic
    @get:Column(name = "state_abbreviation")
    var stateAbbreviation: String? = null

    @get:Basic
    @get:Column(name = "phone_number")
    var phoneNumber: String? = null

    @get:Basic
    @get:Column(name = "attention")
    var attention: String? = null

    @get:Basic
    @get:Column(name = "zip")
    var zip: String? = null

    @get:Basic
    @get:Column(name = "fax_number")
    var faxNumber: String? = null

    @get:Basic
    @get:Column(name = "is_brokerage")
    var isBrokerage: Byte = 0

    @get:Basic
    @get:Column(name = "is_agency")
    var isAgency: Byte = 0

    @get:Basic
    @get:Column(name = "is_customer")
    var isCustomer: Byte = 0

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as CompaniesEntity?

        if (id != that!!.id) return false
        if (addressNumber != that.addressNumber) return false
        if (isBrokerage != that.isBrokerage) return false
        if (isAgency != that.isAgency) return false
        if (isCustomer != that.isCustomer) return false
        if (if (companyName != null) companyName != that.companyName else that.companyName != null) return false
        if (if (streetName != null) streetName != that.streetName else that.streetName != null) return false
        if (if (stateAbbreviation != null) stateAbbreviation != that.stateAbbreviation else that.stateAbbreviation != null)
            return false
        if (if (phoneNumber != null) phoneNumber != that.phoneNumber else that.phoneNumber != null) return false
        if (if (attention != null) attention != that.attention else that.attention != null) return false
        if (if (zip != null) zip != that.zip else that.zip != null) return false
        return if (if (faxNumber != null) faxNumber != that.faxNumber else that.faxNumber != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (companyName != null) companyName!!.hashCode() else 0
        result = 31 * result + addressNumber
        result = 31 * result + if (streetName != null) streetName!!.hashCode() else 0
        result = 31 * result + if (stateAbbreviation != null) stateAbbreviation!!.hashCode() else 0
        result = 31 * result + if (phoneNumber != null) phoneNumber!!.hashCode() else 0
        result = 31 * result + if (attention != null) attention!!.hashCode() else 0
        result = 31 * result + if (zip != null) zip!!.hashCode() else 0
        result = 31 * result + if (faxNumber != null) faxNumber!!.hashCode() else 0
        result = 31 * result + isBrokerage.toInt()
        result = 31 * result + isAgency.toInt()
        result = 31 * result + isCustomer.toInt()
        return result
    }
}
