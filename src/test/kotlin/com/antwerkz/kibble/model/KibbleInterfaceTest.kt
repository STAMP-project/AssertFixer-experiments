package com.antwerkz.kibble.model

import com.antwerkz.kibble.Kibble
import com.antwerkz.kibble.classes
import com.antwerkz.kibble.functions
import com.antwerkz.kibble.interfaces
import com.antwerkz.kibble.objects
import com.antwerkz.kibble.properties
import com.squareup.kotlinpoet.ClassName
import org.testng.Assert
import org.testng.annotations.Test

class KibbleInterfaceTest {
    @Test
    fun basic() {
        val file = Kibble.parseSource("""interface temp {
        |}""".trimMargin())

        Assert.assertTrue(file.classes.isEmpty())
        Assert.assertFalse(file.interfaces.isEmpty())
        Assert.assertTrue(file.objects.isEmpty())
        Assert.assertTrue(file.functions.isEmpty())
        Assert.assertTrue(file.properties.isEmpty())
    }

    @Test
    fun everything() {
        val file = Kibble.parseSource("""interface temp {
        |
        |class Klass
        |
        |object Object
        |
        |fun function() 
        |
        |val property: String
        |
        |}""".trimMargin())

        Assert.assertFalse(file.interfaces.isEmpty())
        val kibbleInterface = file.interfaces.first()
        Assert.assertFalse(kibbleInterface.classes.isEmpty())
        Assert.assertFalse(kibbleInterface.objects.isEmpty())
        Assert.assertFalse(kibbleInterface.funSpecs.isEmpty())
        Assert.assertFalse(kibbleInterface.propertySpecs.isEmpty())
    }

    @Test
    fun extends() {
        val source = """interface Temp: java.lang.Runnable {
}""".trim()
        val file = Kibble.parseSource(source)

        Assert.assertNotNull(file.classes.first().superinterfaces[ClassName("java.lang", "Runnable")])

    }
}