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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.block.function.primitive.ShortIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveList.stg.
 *
 * @since 3.0.
 */
public interface MutableShortList extends MutableShortCollection, ShortList
{
    void addAtIndex(int index, short element);

    boolean addAllAtIndex(int index, short... source);

    boolean addAllAtIndex(int index, ShortIterable source);

    short removeAtIndex(int index);

    short set(int index, short element);

    @Override
    MutableShortList select(ShortPredicate predicate);

    @Override
    MutableShortList reject(ShortPredicate predicate);

    @Override
    MutableShortList with(short element);

    @Override
    MutableShortList without(short element);

    @Override
    MutableShortList withAll(ShortIterable elements);

    @Override
    MutableShortList withoutAll(ShortIterable elements);

    /**
     * @since 9.0.
     */
    @Override
    default MutableShortList tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    <V> MutableList<V> collect(ShortToObjectFunction<? extends V> function);

    /**
     * Returns a new MutableList using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    @Override
    default <V> MutableList<V> collectWithIndex(ShortIntToObjectFunction<? extends V> function)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++));
    }

    MutableShortList reverseThis();

    @Override
    MutableShortList toReversed();

    /**
     * @since 6.0.
     */
    @Override
    MutableShortList distinct();

    /**
     * Sorts this list mutating its contents and returns the same mutable list (this).
     */
    MutableShortList sortThis();

    @Override
    MutableShortList asUnmodifiable();

    @Override
    MutableShortList asSynchronized();

    /**
     * Returns an immutable copy of this list.
     */
    @Override
    ImmutableShortList toImmutable();

    @Override
    MutableShortList subList(int fromIndex, int toIndex);

    /**
     * Returns a {@code MutableList} formed from this {@code MutableShortList} and another {@code ShortList} by
     * combining corresponding elements in pairs. If one of the two {@code ShortList}s is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default MutableList<ShortShortPair> zipShort(ShortIterable iterable)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Returns a {@code MutableList} formed from this {@code MutableShortList} and a {@code ListIterable} by
     * combining corresponding elements in pairs. If one of the two Lists is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default <T> MutableList<ShortObjectPair<T>> zip(Iterable<T> list)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Creates a new empty mutable version of the same List type.
     *
     * @since 9.2.
     */
    default MutableShortList newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
