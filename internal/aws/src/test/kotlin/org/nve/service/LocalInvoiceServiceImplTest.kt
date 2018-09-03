package org.nve.service

import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.assertion.assert
import com.typesafe.config.Config
import org.easymock.EasyMock.expect
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Insurance
import org.nve.services.CompanyService
import org.nve.services.InsuranceService
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import kotlin.coroutines.experimental.buildIterator

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Config::class,
        CompanyService::class,
        InsuranceService::class
)
class LocalInvoiceServiceImplTest {

    @Test
    fun localInvoiceServiceSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockConfigList = createMock<List<Config>>()
        val mockCompanyService = createMock<CompanyService>()
        val mockInsuranceService = createMock<InsuranceService>()

        val invoiceService = LocalInvoiceServiceImpl(mockConfig, mockCompanyService, mockInsuranceService)

        expect(mockConfigList.iterator()).andReturn(buildIterator {  })
        expect(mockCompanyService.read()).andReturn(setOf())
        expect(mockInsuranceService.read()).andReturn(setOf())
        expect(mockConfig.getConfigList("local_invoices")).andReturn(mockConfigList)

        replayAndVerify {
            val invoices = invoiceService.read()
            assert.that(invoices.any(), equalTo(false))
        }
    }
}