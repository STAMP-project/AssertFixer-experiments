package org.nve.persistence.dao

import javax.persistence.*

@Entity
@Table(name = "insurance_bond", schema = "ibs", catalog = "")
class InsuranceBondEntity {
    @get:Id
    @get:Column(name = "ID")
    var id: Long = 0
    @get:Basic
    @get:Column(name = "insurance_number")
    var insuranceNumber: String = ""
    @get:Basic
    @get:Column(name = "bond_type")
    var bondType: String = ""

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InsuranceBondEntity?

        if (id != that!!.id) return false
        if (if (insuranceNumber != null) insuranceNumber != that.insuranceNumber else that.insuranceNumber != null)
            return false
        return if (if (bondType != null) bondType != that.bondType else that.bondType != null) false else true

    }

    override fun hashCode(): Int {
        var result = id as Int
        result = 31 * result + if (insuranceNumber != null) insuranceNumber!!.hashCode() else 0
        result = 31 * result + if (bondType != null) bondType!!.hashCode() else 0
        return result
    }
}
