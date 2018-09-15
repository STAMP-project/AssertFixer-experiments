package org.nve.persistence.dao

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import kotlin.test.assertTrue


@RunWith(PowerMockRunner::class)
@PrepareForTest(

)

class InsurancePolicyEntityTest {

    @Test
    fun insurancePolicyEntityEqualsTest() {

        var objectOne = InsurancePolicyEntity()
        var objectTwo = objectOne

        assertTrue(objectOne.equals(objectTwo))

    }

    @Test
    fun insurancePolicyEntityHashCodeTest() {

        var objectOne = InsurancePolicyEntity()
        objectOne.id = 1
        objectOne.insuranceNumber = "1234"

        assertThat(objectOne.hashCode(), !equalTo(0))

    }
}