package org.nve.resource

import com.natpryce.hamkrest.assertion.assert
import com.natpryce.hamkrest.equalTo
import org.junit.Test
import javax.ws.rs.core.Response

class HealthResourceTest {

    @Test
    fun healthResourceSmokeTest() {
        val healthResource = HealthResource()
        val actual = healthResource.health()
        val expected = Response.ok().build()
        assert.that(actual.status, equalTo(expected.status))
        assert.that(actual.hasEntity(), equalTo(expected.hasEntity()))
    }
}