package org.nve.persistence.dao

import org.nve.domain.Insurance
import javax.persistence.*
import java.sql.Timestamp

@Entity
@Table(name = "insurance_bond", schema = "ibs", catalog = "")
class InsuranceBondEntity_OLD {
    @get:Id
    @get:Column(name = "ID")
    var id: Long = 0
    @get:Basic
    @get:Column(name = "insurance_number")
    var insuranceNumber: String = ""
    @get:Basic
    @get:Column(name = "bond_type")
    var bondType: String = ""
    @get:Basic
    @get:Column(name = "term_effective_date")
    var termEffectiveDate: Timestamp = Timestamp.valueOf("1000-01-01 00:00:00")
    @get:Basic
    @get:Column(name = "term_expiration_date")
    var termExpirationDate: Timestamp = Timestamp.valueOf("1000-01-01 00:00:00")
    @get:Basic
    @get:Column(name = "term_due_date")
    var termDueDate: Timestamp = Timestamp.valueOf("1000-01-01 00:00:00")

    fun toInsuranceBond(): Insurance.Bond {
        return Insurance.Bond(
                id = id,
                number = insuranceNumber ?: "",
                terms = Insurance.Terms(
                        id = id,
                        effectiveDate = termEffectiveDate.toInstant(),
                        expirationDate = termExpirationDate.toInstant(),
                        dueDate = termDueDate.toInstant()
                ),
                type = if (bondType == "PERFORMANCE") Insurance.Bond.Type.PERFORMANCE
                        else Insurance.Bond.Type.MISC
        )
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InsuranceBondEntity_OLD?

        if (id != that!!.id) return false
        if (if (insuranceNumber != null) insuranceNumber != that.insuranceNumber else that.insuranceNumber != null)
            return false
        if (if (bondType != null) bondType != that.bondType else that.bondType != null) return false
        if (if (termEffectiveDate != null) !termEffectiveDate!!.equals(that.termEffectiveDate) else that.termEffectiveDate != null)
            return false
        if (if (termExpirationDate != null) !termExpirationDate!!.equals(that.termExpirationDate) else that.termExpirationDate != null)
            return false
        return if (if (termDueDate != null) !termDueDate!!.equals(that.termDueDate) else that.termDueDate != null) false else true

    }

    override fun hashCode(): Int {
        var result = id as Int
        result = 31 * result + if (insuranceNumber != null) insuranceNumber!!.hashCode() else 0
        result = 31 * result + if (bondType != null) bondType!!.hashCode() else 0
        result = 31 * result + if (termEffectiveDate != null) termEffectiveDate!!.hashCode() else 0
        result = 31 * result + if (termExpirationDate != null) termExpirationDate!!.hashCode() else 0
        result = 31 * result + if (termDueDate != null) termDueDate!!.hashCode() else 0
        return result
    }
}
