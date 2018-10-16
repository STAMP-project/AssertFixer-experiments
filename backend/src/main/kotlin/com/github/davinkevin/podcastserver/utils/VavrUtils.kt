package com.github.davinkevin.podcastserver.utils

import arrow.core.Failure
import arrow.core.Success
import arrow.core.getOrElse
import io.vavr.API.None
import io.vavr.API.Option
import io.vavr.collection.HashSet
import io.vavr.collection.List

/**
 * Created by kevin on 20/07/2018
 */
fun <T> kotlin.collections.Set<T>.toVΛVΓ(): io.vavr.collection.Set<T> = HashSet.ofAll(this)
fun <T> kotlin.collections.List<T>.toVΛVΓ(): io.vavr.collection.List<T> = List.ofAll(this)

fun <T> arrow.core.Option<T>.toVΛVΓ(): io.vavr.control.Option<T> = this.map { Option(it) }.getOrElse { None() }

fun <T> arrow.core.Try<T>.toVΛVΓ(): io.vavr.control.Try<T> =
        when(this) {
            is Success -> io.vavr.control.Try.of { this.value }
            is Failure -> io.vavr.control.Try.of { throw this.exception }
        }
