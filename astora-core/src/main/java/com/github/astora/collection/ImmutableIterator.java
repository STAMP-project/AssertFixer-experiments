package com.github.astora.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static com.github.astora.common.Requirements.requireNonNull;

public interface ImmutableIterator<E> extends Iterator<E> {

    public static final ImmutableIterator<?> EMPTY_ITERATOR = new EmptyImmutableIterator();

    public static <E> ImmutableIterator<E> wrap(Iterator<E> iterator) {
        return new ImmutableIteratorDelegate<>(iterator);
    }

    public static <E> ImmutableIterator<E> emptyIterator() {
        return (ImmutableIterator<E>) EMPTY_ITERATOR;
    }

    public static final class EmptyImmutableIterator<E> implements ImmutableIterator<E> {

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return false;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            throw new NoSuchElementException();
        }
    }

    public static final class ImmutableIteratorDelegate<E> implements ImmutableIterator<E> {

        final Iterator<E> target;

        public ImmutableIteratorDelegate(Iterator<E> target) {
            this.target = requireNonNull(
                    target) instanceof ImmutableIteratorDelegate ? ((ImmutableIteratorDelegate<E>) target).target : target;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public int hashCode() {
            return target.hashCode();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }

            if (o == null) {
                return false;
            }

            if (getClass() == o.getClass()) {
                return target.equals(((ImmutableIteratorDelegate) o).target);
            }

            return target.equals(o);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public String toString() {
            return "ImmutableIterator{" + "target=" + target + '}';
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public boolean hasNext() {
            return this.target.hasNext();
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public E next() {
            return this.target.next();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    default void remove() {
        throw new UnsupportedOperationException("immutable");
    }
}
