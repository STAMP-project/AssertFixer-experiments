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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.block.function.primitive.CharIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.api.tuple.primitive.CharObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveList.stg.
 *
 * @since 3.0.
 */
public interface MutableCharList extends MutableCharCollection, CharList
{
    void addAtIndex(int index, char element);

    boolean addAllAtIndex(int index, char... source);

    boolean addAllAtIndex(int index, CharIterable source);

    char removeAtIndex(int index);

    char set(int index, char element);

    @Override
    MutableCharList select(CharPredicate predicate);

    @Override
    MutableCharList reject(CharPredicate predicate);

    @Override
    MutableCharList with(char element);

    @Override
    MutableCharList without(char element);

    @Override
    MutableCharList withAll(CharIterable elements);

    @Override
    MutableCharList withoutAll(CharIterable elements);

    /**
     * @since 9.0.
     */
    @Override
    default MutableCharList tap(CharProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    <V> MutableList<V> collect(CharToObjectFunction<? extends V> function);

    /**
     * Returns a new MutableList using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    @Override
    default <V> MutableList<V> collectWithIndex(CharIntToObjectFunction<? extends V> function)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++));
    }

    MutableCharList reverseThis();

    @Override
    MutableCharList toReversed();

    /**
     * @since 6.0.
     */
    @Override
    MutableCharList distinct();

    /**
     * Sorts this list mutating its contents and returns the same mutable list (this).
     */
    MutableCharList sortThis();

    @Override
    MutableCharList asUnmodifiable();

    @Override
    MutableCharList asSynchronized();

    /**
     * Returns an immutable copy of this list.
     */
    @Override
    ImmutableCharList toImmutable();

    @Override
    MutableCharList subList(int fromIndex, int toIndex);

    /**
     * Returns a {@code MutableList} formed from this {@code MutableCharList} and another {@code CharList} by
     * combining corresponding elements in pairs. If one of the two {@code CharList}s is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default MutableList<CharCharPair> zipChar(CharIterable iterable)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Returns a {@code MutableList} formed from this {@code MutableCharList} and a {@code ListIterable} by
     * combining corresponding elements in pairs. If one of the two Lists is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default <T> MutableList<CharObjectPair<T>> zip(Iterable<T> list)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Creates a new empty mutable version of the same List type.
     *
     * @since 9.2.
     */
    default MutableCharList newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
