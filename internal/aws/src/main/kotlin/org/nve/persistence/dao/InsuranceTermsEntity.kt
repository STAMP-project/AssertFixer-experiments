package org.nve.persistence.dao

import java.sql.Timestamp
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Id

@javax.persistence.Entity
@javax.persistence.Table(name = "insurance_terms", schema = "ibs", catalog = "")
class InsuranceTermsEntity {

    @get:Id
    @get:Column(name = "ID")
    var id: Int = 0

    @get:Basic
    @get:Column(name = "effective_date")
    var effectiveDate: Timestamp? = null

    @get:Basic
    @get:Column(name = "expiration_date")
    var expirationDate: Timestamp? = null

    @get:Basic
    @get:Column(name = "due_date")
    var dueDate: Timestamp? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InsuranceTermsEntity?

        if (id != that!!.id) return false
        if (if (effectiveDate != null) !effectiveDate!!.equals(that.effectiveDate) else that.effectiveDate != null)
            return false
        if (if (expirationDate != null) !expirationDate!!.equals(that.expirationDate) else that.expirationDate != null)
            return false
        return if (if (dueDate != null) !dueDate!!.equals(that.dueDate) else that.dueDate != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (effectiveDate != null) effectiveDate!!.hashCode() else 0
        result = 31 * result + if (expirationDate != null) expirationDate!!.hashCode() else 0
        result = 31 * result + if (dueDate != null) dueDate!!.hashCode() else 0
        return result
    }
}
