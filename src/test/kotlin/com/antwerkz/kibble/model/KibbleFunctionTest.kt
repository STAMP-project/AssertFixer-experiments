package com.antwerkz.kibble.model

import com.antwerkz.kibble.Kibble
import com.antwerkz.kibble.getFunctions
import org.testng.Assert
import org.testng.annotations.Test

class KibbleFunctionTest {
    @Test
    fun generics() {
        val file = Kibble.parseSource("""fun <T> foo(t: T)
            |fun <out K: Bar> bar(k: K)
        """.trimMargin())

        var kibbleFunction = file.getFunctions("foo")[0]
        Assert.assertEquals(kibbleFunction.typeVariables[0].toString(), "T")
        Assert.assertNull(kibbleFunction.typeVariables[0].variance)
        Assert.assertNull(kibbleFunction.typeVariables[0].bounds)

        kibbleFunction = file.getFunctions("bar")[0]
        Assert.assertEquals(kibbleFunction.typeVariables[0].toString(), "K")
        Assert.assertEquals(kibbleFunction.typeVariables[0].variance, TypeParameterVariance.OUT)
        Assert.assertEquals(kibbleFunction.typeVariables[0].bounds, KibbleType.from("Bar"))
    }
}