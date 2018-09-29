package org.nve.logging

import org.nve.reflect.resolved
import org.slf4j.Logger
import org.slf4j.LoggerFactory

inline fun <reified T : Any> T.logger() : Logger =
        LoggerFactory.getLogger(resolved.java)