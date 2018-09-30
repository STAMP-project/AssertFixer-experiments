package org.nve.service

import com.natpryce.hamkrest.equalTo
import com.natpryce.hamkrest.assertion.assert
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
class LocalInsuranceServiceImplTest {

    @Test
    fun localInsuranceServiceSmokeTest() {
        val mockConfig = createMock<Config>()
        val mockBondsList = createMock<List<Config>>()
        val mockPoliciesList = createMock<List<Config>>()
        val mockEndorsementsList = createMock<List<Config>>()


        val insuranceService = LocalInsuranceServiceImpl(mockConfig)

        expect(mockConfig.getConfigList("local_insurance.bonds")).andReturn(mockBondsList)
        expect(mockConfig.getConfigList("local_insurance.policies")).andReturn(mockPoliciesList)
        expect(mockConfig.getConfigList("local_insurance.endorsements")).andReturn(mockEndorsementsList)
        expect(mockBondsList.iterator()).andReturn(buildIterator {  })
        expect(mockPoliciesList.iterator()).andReturn(buildIterator {  })
        expect(mockEndorsementsList.iterator()).andReturn(buildIterator {  })

        replayAndVerify {
            val ins = insuranceService.read()
            assert.that(ins.any(), equalTo(false))
        }
    }

}