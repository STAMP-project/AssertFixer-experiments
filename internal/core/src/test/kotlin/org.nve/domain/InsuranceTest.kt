package org.nve.domain

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import java.time.Instant

class InsuranceTest {

    @Test
    fun insuranceTermsSmokeTest() {
        val terms = Insurance.Terms(
                id = 1L,
                effectiveDate = Instant.now(),
                expirationDate = Instant.now(),
                dueDate = Instant.now()
        )

        assert.that(terms, !equalTo<Insurance.Terms>(null))
    }

    @Test
    fun insuranceBondSmokeTest() {
        val terms = Insurance.Terms(
                id = 1L,
                effectiveDate = Instant.now(),
                expirationDate = Instant.now(),
                dueDate = Instant.now()
        )
        val insurance = Insurance.Bond(
                id = 1L,
                number = "a1234",
                terms = terms,
                type = Insurance.Bond.Type.PERFORMANCE
        )

        assert.that(insurance, !equalTo<Insurance>(null))
    }

    @Test
    fun insuranceEndorsementSmokeTest() {
        val terms = Insurance.Terms(
                id = 1L,
                effectiveDate = Instant.now(),
                expirationDate = Instant.now(),
                dueDate = Instant.now()
        )

        val insurance = Insurance.Endorsement(
                id = 1L,
                number = "a1234",
                terms = terms,
                policyChange = "This is changing"
        )

        assert.that(insurance, !equalTo<Insurance>(null))
    }

    @Test
    fun insurancePolicySmokeTest() {
        val terms = Insurance.Terms(
                id = 1L,
                effectiveDate = Instant.now(),
                expirationDate = Instant.now(),
                dueDate = Instant.now()
        )
        val endorsements = setOf(Insurance.Endorsement(
                id = 1L,
                number = "a1234",
                terms = terms,
                policyChange = "This is changing"
        ))

        val insurance = Insurance.Policy(
                id = 1L,
                number = "a1234",
                terms = terms,
                endorsements = endorsements
        )

        assert.that(insurance, !equalTo<Insurance>(null))
    }
}