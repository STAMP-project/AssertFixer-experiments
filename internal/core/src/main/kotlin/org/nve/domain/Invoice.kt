package org.nve.domain

import java.time.Instant

data class Invoice(
        val id: Long,
        val customer: Company,
        val insurance: Insurance,
        val transactions: Set<Transaction>,
        val created: Instant,
        val due: Instant,
        val comment: String?
) {
    sealed class Transaction {
        abstract val amount: Double
        abstract val date: Instant

        data class Debit(
                override val amount: Double,
                override val date: Instant
        ): Transaction()

        data class Credit(
                override val amount: Double,
                override val date: Instant
        ): Transaction()
    }
}
