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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.block.function.primitive.ByteIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.api.tuple.primitive.ByteObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveList.stg.
 *
 * @since 3.0.
 */
public interface MutableByteList extends MutableByteCollection, ByteList
{
    void addAtIndex(int index, byte element);

    boolean addAllAtIndex(int index, byte... source);

    boolean addAllAtIndex(int index, ByteIterable source);

    byte removeAtIndex(int index);

    byte set(int index, byte element);

    @Override
    MutableByteList select(BytePredicate predicate);

    @Override
    MutableByteList reject(BytePredicate predicate);

    @Override
    MutableByteList with(byte element);

    @Override
    MutableByteList without(byte element);

    @Override
    MutableByteList withAll(ByteIterable elements);

    @Override
    MutableByteList withoutAll(ByteIterable elements);

    /**
     * @since 9.0.
     */
    @Override
    default MutableByteList tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    <V> MutableList<V> collect(ByteToObjectFunction<? extends V> function);

    /**
     * Returns a new MutableList using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    @Override
    default <V> MutableList<V> collectWithIndex(ByteIntToObjectFunction<? extends V> function)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++));
    }

    MutableByteList reverseThis();

    @Override
    MutableByteList toReversed();

    /**
     * @since 6.0.
     */
    @Override
    MutableByteList distinct();

    /**
     * Sorts this list mutating its contents and returns the same mutable list (this).
     */
    MutableByteList sortThis();

    @Override
    MutableByteList asUnmodifiable();

    @Override
    MutableByteList asSynchronized();

    /**
     * Returns an immutable copy of this list.
     */
    @Override
    ImmutableByteList toImmutable();

    @Override
    MutableByteList subList(int fromIndex, int toIndex);

    /**
     * Returns a {@code MutableList} formed from this {@code MutableByteList} and another {@code ByteList} by
     * combining corresponding elements in pairs. If one of the two {@code ByteList}s is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default MutableList<ByteBytePair> zipByte(ByteIterable iterable)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Returns a {@code MutableList} formed from this {@code MutableByteList} and a {@code ListIterable} by
     * combining corresponding elements in pairs. If one of the two Lists is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default <T> MutableList<ByteObjectPair<T>> zip(Iterable<T> list)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Creates a new empty mutable version of the same List type.
     *
     * @since 9.2.
     */
    default MutableByteList newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
