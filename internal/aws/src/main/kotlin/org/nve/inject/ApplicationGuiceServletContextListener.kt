package org.nve.inject

import com.google.inject.Injector
import com.google.inject.servlet.GuiceServletContextListener

open class ApplicationGuiceServletContextListener : GuiceServletContextListener() {
    override fun getInjector(): Injector = InjectorFactory.injector
}