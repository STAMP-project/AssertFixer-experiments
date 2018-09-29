package org.nve.domain

import java.time.Instant

sealed class Insurance{
    abstract val id: Long
    abstract val number: String
    abstract val terms: Insurance.Terms

    data class Terms(
            val id: Long,
            val effectiveDate: Instant,
            val expirationDate: Instant,
            val dueDate: Instant
    )

    data class Policy(
            override val id: Long,
            override val number: String,
            override val terms: Insurance.Terms,
            val endorsements: Set<Insurance.Endorsement>?
    ): Insurance()

    data class Bond(
            override val id: Long,
            override val number: String,
            override val terms: Insurance.Terms,
            val type: Bond.Type
    ): Insurance() {
        enum class Type {
            PERFORMANCE, MISC
        }
    }

    data class Endorsement(
            override val id: Long,
            override val number: String,
            override val terms: Insurance.Terms,
            val policyChange: String
    ): Insurance()
}

