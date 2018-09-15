package org.nve.service

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.typesafe.config.Config
import org.easymock.EasyMock.expect
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner
import kotlin.coroutines.experimental.buildIterator

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Config::class
)
class LocalCompanyServiceImplTest {

    @Test
    fun localClientServiceSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockConfigList = createMock<List<Config>>()

        val companyService = LocalCompanyServiceImpl(mockConfig)

        expect(mockConfig.getConfigList("local_customers")).andReturn(mockConfigList)
        expect(mockConfigList.iterator()).andReturn(buildIterator {  })

        replayAndVerify {
            val clients = companyService.read()
            assert.that(clients.any(), equalTo(false))
        }
    }


}