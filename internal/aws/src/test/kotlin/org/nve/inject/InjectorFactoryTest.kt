package org.nve.inject


import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import com.typesafe.config.Config
import com.typesafe.config.ConfigFactory
import org.easymock.EasyMock.expect
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.resource.HealthResource
import org.nve.testing.createMock
import org.nve.testing.replayAndVerify
import org.powermock.api.easymock.PowerMock.mockStatic
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner


@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Config::class,
        ConfigFactory::class
)
class InjectorFactoryTest {

    @Test
    fun smokeTest() {
        val mockConfig = createMock<Config>()
        mockStatic(ConfigFactory::class.java)

        expect(ConfigFactory.load()).andReturn(mockConfig)
        expect(mockConfig.getStringList("inject.modules")).andReturn(listOf())

        replayAndVerify {
            val resource = InjectorFactory.injector.get<HealthResource>()
            assert.that(resource::class.java.canonicalName, equalTo(HealthResource::class.java.canonicalName))
        }
    }
}