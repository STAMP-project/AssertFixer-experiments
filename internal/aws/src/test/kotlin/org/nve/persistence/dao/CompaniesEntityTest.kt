package org.nve.persistence.dao

import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Insurance
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import kotlin.test.assertTrue

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Insurance::class
)
class CompaniesEntityTest {

    @Test
    fun companiesEntityEqualsTest() {

        var companiesEntity = CompaniesEntity()
        var companiesEntityCopy = companiesEntity

        assertTrue(companiesEntity.equals(companiesEntityCopy))

    }

    @Test
    fun companiesEntityHashCodeTest() {

        var companiesEntity = CompaniesEntity()
        companiesEntity.id = 1
        companiesEntity.streetNumber = 1234

        assertThat(companiesEntity.hashCode(), !equalTo(0))

    }
}