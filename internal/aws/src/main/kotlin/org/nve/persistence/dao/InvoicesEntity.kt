package org.nve.persistence.dao

import java.sql.Timestamp
import javax.persistence.Basic
import javax.persistence.Column
import javax.persistence.Id

@javax.persistence.Entity
@javax.persistence.Table(name = "invoices", schema = "ibs", catalog = "")
class InvoicesEntity {

    @get:Id
    @get:Column(name = "ID")
    var id: Int = 0

    @get:Basic
    @get:Column(name = "created")
    var created: Timestamp? = null

    @get:Basic
    @get:Column(name = "due")
    var due: Timestamp? = null

    @get:Basic
    @get:Column(name = "comment")
    var comment: String? = null

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InvoicesEntity?

        if (id != that!!.id) return false
        if (if (created != null) !created!!.equals(that.created) else that.created != null) return false
        if (if (due != null) !due!!.equals(that.due) else that.due != null) return false
        return if (if (comment != null) comment != that.comment else that.comment != null) false else true

    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + if (created != null) created!!.hashCode() else 0
        result = 31 * result + if (due != null) due!!.hashCode() else 0
        result = 31 * result + if (comment != null) comment!!.hashCode() else 0
        return result
    }
}
