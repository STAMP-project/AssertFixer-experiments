package org.nve.domain

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import org.junit.runner.RunWith
import org.nve.testing.createMock
import org.powermock.core.classloader.annotations.PrepareForTest
import org.powermock.modules.junit4.PowerMockRunner

@RunWith(PowerMockRunner::class)
@PrepareForTest(
        Insurance::class
)
class CertificateTest {

    @Test
    fun certificateSmokeTest() {
        val mockPolicy = createMock<Insurance.Policy>()

        val certificate = Certificate(
                policy = mockPolicy
        )

        assert.that(certificate, !equalTo<Certificate>(null))
    }
}