package org.davidmoten.kool.internal.operators.stream;

import java.util.NoSuchElementException;
import java.util.function.BiFunction;

import org.davidmoten.kool.Maybe;
import org.davidmoten.kool.Stream;
import org.davidmoten.kool.StreamIterable;
import org.davidmoten.kool.StreamIterator;

import com.github.davidmoten.guavamini.Preconditions;

public final class ReduceNoInitialValue<T> implements Stream<Maybe<T>> {

    private final BiFunction<? super T, ? super T, ? extends T> reducer;
    private final StreamIterable<T> source;

    public ReduceNoInitialValue(BiFunction<? super T, ? super T, ? extends T> reducer,
            StreamIterable<T> source) {
        this.reducer = reducer;
        this.source = source;
    }

    @Override
    public StreamIterator<Maybe<T>> iterator() {
        return new StreamIterator<Maybe<T>>() {

            final StreamIterator<T> it = Preconditions.checkNotNull(source.iterator());
            T value = null;
            boolean finished;

            @Override
            public boolean hasNext() {
                calculate();
                return value != null;
            }

            @Override
            public Maybe<T> next() {
                if (finished) {
                    throw new NoSuchElementException();
                }
                finished = true;
                calculate();
                T t = value;
                if (t != null) {
                    value = null;
                    return Maybe.of(t);
                } else {
                    return Maybe.empty();
                }
            }

            private void calculate() {
                if (value != null) {
                    return;
                } else {
                    T a, b;
                    if (it.hasNext()) {
                        a = Preconditions.checkNotNull(it.next());
                    } else {
                        return;
                    }
                    if (it.hasNext()) {
                        b = Preconditions.checkNotNull(it.next());
                    } else {
                        return;
                    }
                    T v = reducer.apply(a, b);
                    while (it.hasNext()) {
                        v = reducer.apply(v, Preconditions.checkNotNull(it.next()));
                    }
                    value = v;
                }
            }

            @Override
            public void dispose() {
                it.dispose();
            }

        };
    }

}
