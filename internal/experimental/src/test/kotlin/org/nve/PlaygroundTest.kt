package org.nve

import io.reactivex.Observable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import org.junit.Test
import kotlin.concurrent.thread

class PlaygroundTest {

    @Test
    fun smokeTest() {
    }

    private fun simpleTest() {
        val list = listOf("Alpha", "Beta", "Gamma", "Delta", "Epsilon")


        list.toObservable()
                .filter { it.length >= 5 }
                .subscribeBy(
                        onNext = { println(it) },
                        onError = { it.printStackTrace() },
                        onComplete = { println("Done!") }
                )

        asyncObservable().blockingForEach { println(it) }
    }

    private fun asyncObservable(): Observable<String> = Observable.create { subscriber ->
        thread {
            (0..75).toObservable()
                    .map { "Async value_$it" }
                    .subscribe { subscriber.onNext(it) }
        }
    }
}