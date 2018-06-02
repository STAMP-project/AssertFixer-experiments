/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api.list.primitive;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.block.function.primitive.LongIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveList.stg.
 *
 * @since 3.0.
 */
public interface MutableLongList extends MutableLongCollection, LongList
{
    void addAtIndex(int index, long element);

    boolean addAllAtIndex(int index, long... source);

    boolean addAllAtIndex(int index, LongIterable source);

    long removeAtIndex(int index);

    long set(int index, long element);

    @Override
    MutableLongList select(LongPredicate predicate);

    @Override
    MutableLongList reject(LongPredicate predicate);

    @Override
    MutableLongList with(long element);

    @Override
    MutableLongList without(long element);

    @Override
    MutableLongList withAll(LongIterable elements);

    @Override
    MutableLongList withoutAll(LongIterable elements);

    /**
     * @since 9.0.
     */
    @Override
    default MutableLongList tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    <V> MutableList<V> collect(LongToObjectFunction<? extends V> function);

    /**
     * Returns a new MutableList using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    @Override
    default <V> MutableList<V> collectWithIndex(LongIntToObjectFunction<? extends V> function)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++));
    }

    MutableLongList reverseThis();

    @Override
    MutableLongList toReversed();

    /**
     * @since 6.0.
     */
    @Override
    MutableLongList distinct();

    /**
     * Sorts this list mutating its contents and returns the same mutable list (this).
     */
    MutableLongList sortThis();

    @Override
    MutableLongList asUnmodifiable();

    @Override
    MutableLongList asSynchronized();

    /**
     * Returns an immutable copy of this list.
     */
    @Override
    ImmutableLongList toImmutable();

    @Override
    MutableLongList subList(int fromIndex, int toIndex);

    /**
     * Returns a {@code MutableList} formed from this {@code MutableLongList} and another {@code LongList} by
     * combining corresponding elements in pairs. If one of the two {@code LongList}s is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default MutableList<LongLongPair> zipLong(LongIterable iterable)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Returns a {@code MutableList} formed from this {@code MutableLongList} and a {@code ListIterable} by
     * combining corresponding elements in pairs. If one of the two Lists is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default <T> MutableList<LongObjectPair<T>> zip(Iterable<T> list)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Creates a new empty mutable version of the same List type.
     *
     * @since 9.2.
     */
    default MutableLongList newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
