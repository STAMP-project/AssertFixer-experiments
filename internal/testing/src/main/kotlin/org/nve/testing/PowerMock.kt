package org.nve.testing

import org.powermock.api.easymock.PowerMock

inline fun <reified T: Any> createMock(): T =
        PowerMock.createMock(T::class.java)

fun <T> replayAndVerify(block: () -> T): T {
    PowerMock.replayAll()
    val result = block()
    PowerMock.verifyAll()
    return result;
}