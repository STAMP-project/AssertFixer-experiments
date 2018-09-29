package org.nve.persistence.dao

import org.nve.domain.Insurance
import javax.persistence.*

@Entity
@Table(name = "insurance_endorsement", schema = "ibs", catalog = "")
class InsuranceEndorsementEntity {
    @get:Id
    @get:Column(name = "ID")
    var id: Long = 0
    @get:Basic
    @get:Column(name = "policy_ID")
    var policyId: Int = 0
    @get:Basic
    @get:Column(name = "insurance_number")
    var insuranceNumber: String = ""
    @get:Basic
    @get:Column(name = "policy_change")
    var policyChange: String = ""

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InsuranceEndorsementEntity?

        if (id != that!!.id) return false
        if (policyId != that.policyId) return false
        if (if (insuranceNumber != null) insuranceNumber != that.insuranceNumber else that.insuranceNumber != null)
            return false
        return if (if (policyChange != null) policyChange != that.policyChange else that.policyChange != null) false else true

    }

    override fun hashCode(): Int {
        var result = id as Int
        result = 31 * result + policyId
        result = 31 * result + if (insuranceNumber != null) insuranceNumber!!.hashCode() else 0
        result = 31 * result + if (policyChange != null) policyChange!!.hashCode() else 0
        return result
    }
}
