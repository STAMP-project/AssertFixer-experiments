package org.nve.persistence.dao

import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Id

@javax.persistence.Entity
@javax.persistence.Table(name = "insurance_policy", schema = "ibs", catalog = "")
class InsurancePolicyEntity {

    @get:Id
    @get:Column(name = "ID")
    var id: Int = 0

    @get:Basic
    @get:Column(name = "insurance_number")
    var insuranceNumber: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InsurancePolicyEntity?

        if (id != that!!.id) return false
        return if (if (insuranceNumber != null) insuranceNumber != that.insuranceNumber else that.insuranceNumber != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (insuranceNumber != null) insuranceNumber!!.hashCode() else 0
        return result
    }
}
