package org.nve.domain.generic

import java.sql.Time
import java.sql.Date

data class LineItem (
        val invoiceID: Int,
        val amount: Float,
        val chargeFromCompanyID: Int,
        val chargeToCompanyID: Int,
        val lineItemType: LineItemType,
        val date: Date,
        val time: Time
) {
    enum class LineItemType {DEBIT, CREDIT}
}