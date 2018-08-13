package com.antwerkz.kibble

import com.antwerkz.kibble.KibbleVisitor.CallBlock
import com.antwerkz.kibble.KibbleVisitor.TypeProjection
import com.antwerkz.kibble.model.KibbleType
import com.antwerkz.kibble.model.SuperCall
import com.squareup.kotlinpoet.FileSpec
import org.slf4j.LoggerFactory
import java.util.Stack

@Suppress("UNCHECKED_CAST")
class KibbleContext {
    companion object {
        val LOG = LoggerFactory.getLogger(KibbleContext::class.java)
    }
    private data class Slab(val name: String)

    private val files = mutableMapOf<String?, MutableSet<FileSpec>>()

    private val stack = Stack<Any>()

    fun register(file: FileSpec) = lookup(file.packageName).add(file)

    fun lookup(pkgName: String?) = files.getOrPut(pkgName, { mutableSetOf() })

    fun resolve(type: KibbleType) {} /*=
        lookup(type.pkgName)
                .flatMap { it.classes }
                .firstOrNull { it.name == type.className }
                */

    fun fileList(): List<FileSpec> = files.values
            .flatMap { it.toList() }

    fun push(value: Any) {
        if(value !is Slab
                && value !is SuperCall
                && value !is CallBlock
                && value !is TypeProjection
                && value !is Pair<*, *>
                && !value::class.java.`package`.name.startsWith("com.square")) {
            throw Exception("none kotlinpoet type pushed to the stack: ${value::class.java}")
        }
        stack.push(value)
    }

    fun <T> pop(): T = stack.pop() as T

    fun <T> peek(): T = (if (!stack.isEmpty()) stack.peek() else null) as T

    fun bookmark(name: String) {
        push(Slab(name))
        LOG.debug("bookmarking $name")
    }

    fun popToBookmark(): List<Any> {
        val values = mutableListOf<Any>()
        while (peek<Any>() !is Slab) {
            values += pop<Any>()
        }
        val slab = pop<Slab>()
        LOG.debug("removing bookmark $slab")
        return values.reversed()
    }

    override fun toString() = if (!stack.isEmpty()) peek<Any>().toString() else "{}"
}
