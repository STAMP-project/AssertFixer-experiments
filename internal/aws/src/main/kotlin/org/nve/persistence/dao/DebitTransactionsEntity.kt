package org.nve.persistence.dao

import javax.persistence.*

@Entity
@Table(name = "debit_transactions", schema = "ibs", catalog = "")
class DebitTransactionsEntity {
    @get:Id
    @get:Column(name = "ID")
    var id: Int = 0
    @get:Basic
    @get:Column(name = "amount")
    var amount: Double = 0.toDouble()

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as DebitTransactionsEntity?

        if (id != that!!.id) return false
        return if (java.lang.Double.compare(that.amount, amount) != 0) false else true

    }

    override fun hashCode(): Int {
        var result: Int
        val temp: Long
        result = id
        temp = java.lang.Double.doubleToLongBits(amount)
        result = 31 * result + (temp xor temp.ushr(32)).toInt()
        return result
    }
}
