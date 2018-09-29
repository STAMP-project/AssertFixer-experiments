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

class InsuranceBondEntityTest {

    @Test
    fun insuranceBondEntityEqualsTest() {

        var objectOne = InsuranceBondEntity()
        var objectTwo = objectOne

        assertTrue(objectOne.equals(objectTwo))

    }

    @Test
    fun insuranceBondEntityHashCodeTest() {

        var objectOne = InsuranceBondEntity()
        objectOne.id = 1
        objectOne.insuranceNumber = "1234"

        assertThat(objectOne.hashCode(), !equalTo(0))

    }
}