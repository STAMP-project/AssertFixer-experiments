package org.nve.domain.generic


import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.modules.junit4.PowerMockRunner
import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.isA
import com.typesafe.config.Config
import org.powermock.core.classloader.annotations.PrepareForTest
import java.sql.Date
import java.sql.Time
import kotlin.test.assertEquals

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Config::class
)

class LineItemTest {
    @Test
    fun lineItemInitTest() {
        val invoiceID: Int = 1
        val amount: Float = 1.14F
        val chargeFromCompanyID: Int = 1
        val chargeToCompanyID: Int = 2
        val lineItemType = LineItem.LineItemType.DEBIT
        val date: Date = Date(System.currentTimeMillis())
        val time: Time = Time(System.currentTimeMillis())

        val lineItem = LineItem(invoiceID, amount, chargeFromCompanyID, chargeToCompanyID,
                LineItem.LineItemType.DEBIT, date, time)

        assert.that(lineItem, isA<LineItem>())
        assertEquals(lineItem.invoiceID, invoiceID)
        assertEquals(lineItem.amount, amount)
        assertEquals(lineItem.chargeFromCompanyID, chargeFromCompanyID)
        assertEquals(lineItem.chargeToCompanyID, chargeToCompanyID)
        assertEquals(lineItem.lineItemType, lineItemType)
        assertEquals(lineItem.date, date)
        assertEquals(lineItem.time, time)
    }
}