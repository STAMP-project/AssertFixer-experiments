package org.davidmoten.kool.internal.operators.stream;

import java.util.function.Consumer;

import org.davidmoten.kool.Stream;
import org.davidmoten.kool.StreamIterator;

import com.github.davidmoten.guavamini.Preconditions;

public final class DoOnError<T> implements Stream<T> {

    private Consumer<? super Throwable> consumer;
    private Stream<T> source;

    public DoOnError(Consumer<? super Throwable> consumer, Stream<T> source) {
        this.consumer = consumer;
        this.source = source;
    }

    @Override
    public StreamIterator<T> iterator() {
        return new StreamIterator<T>() {

            StreamIterator<T> it = getIterator();

            @Override
            public boolean hasNext() {
                try {
                    return it.hasNext();
                } catch (RuntimeException | Error t) {
                    consumer.accept(t);
                    throw t;
                }
            }

            @Override
            public T next() {
                try {
                    return Preconditions.checkNotNull(it.next());
                } catch (RuntimeException | Error t) {
                    consumer.accept(t);
                    throw t;
                }
            }

            private StreamIterator<T> getIterator() {
                try {
                    return Preconditions.checkNotNull(source.iterator());
                } catch (RuntimeException | Error t) {
                    consumer.accept(t);
                    throw t;
                }
            }

            @Override
            public void dispose() {
                it.dispose();
            }

        };
    }

}
