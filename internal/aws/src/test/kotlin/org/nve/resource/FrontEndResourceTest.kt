package org.nve.resource

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.easymock.EasyMock.expect
import org.easymock.EasyMock.mock
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.domain.Company
import org.nve.services.CompanyService
import org.nve.services.InvoiceService
import org.nve.template.Template
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)
@PrepareForTest(
        CompanyService::class,
        InvoiceService::class
)
class FrontEndResourceTest {
    @Test
    fun smokeTest() {
        val mockClient = createMock<Company>()
        val mockClientService = createMock<CompanyService>()
        val mockInvoiceService = createMock<InvoiceService>()
        val frontEndResource = FrontEndResource(mockClientService, mockInvoiceService)

        expect(mockClientService.read()).andReturn(setOf(mockClient))

        replayAndVerify {
            val indexTemplate = frontEndResource.index()
            assert.that(indexTemplate, !equalTo<Template>(null))
        }
    }
}