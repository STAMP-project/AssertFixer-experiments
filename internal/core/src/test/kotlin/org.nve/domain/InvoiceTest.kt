package org.nve.domain

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.testing.createMock
import org.powermock.modules.junit4.PowerMockRunner
import org.powermock.core.classloader.annotations.PrepareForTest
import java.time.Instant

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Company::class,
        Insurance::class,
        Invoice.Transaction::class
)
class InvoiceTest {

    @Test
    fun invoiceSmokeTest() {
        val mockCompany = createMock<Company>()
        val mockInsurance = createMock<Insurance>()
        val mockTransactions = createMock<Set<Invoice.Transaction>>()

        val invoice = Invoice(
                id = 1,
                customer = mockCompany,
                insurance = mockInsurance,
                transactions = mockTransactions,
                created = Instant.now(),
                due =  Instant.now(),
                comment = null
        )

        assert.that(invoice, !equalTo<Invoice>(null))

    }

    @Test
    fun lineItemDebitSmokeTest() {

        val lineItemType = Invoice.Transaction.Debit(
                amount = 20.00,
                date = Instant.now()
        )

        assert.that(lineItemType, !equalTo<Invoice.Transaction>(null))
    }

    @Test
    fun lineItemCreditSmokeTest() {

        val lineItemType = Invoice.Transaction.Credit(
                amount = 20.00,
                date = Instant.now()
        )

        assert.that(lineItemType, !equalTo<Invoice.Transaction>(null))
    }
}