package org.nve.inject

import com.google.inject.servlet.ServletModule
import javax.servlet.Filter

abstract class SimpleServletModule : ServletModule() {

    protected inline fun <reified T : Filter> FilterKeyBindingBuilder.through() =
            through(T::class.java)
}