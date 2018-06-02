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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.block.function.primitive.DoubleIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;

/**
 * This file was automatically generated from template file mutablePrimitiveList.stg.
 *
 * @since 3.0.
 */
public interface MutableDoubleList extends MutableDoubleCollection, DoubleList
{
    void addAtIndex(int index, double element);

    boolean addAllAtIndex(int index, double... source);

    boolean addAllAtIndex(int index, DoubleIterable source);

    double removeAtIndex(int index);

    double set(int index, double element);

    @Override
    MutableDoubleList select(DoublePredicate predicate);

    @Override
    MutableDoubleList reject(DoublePredicate predicate);

    @Override
    MutableDoubleList with(double element);

    @Override
    MutableDoubleList without(double element);

    @Override
    MutableDoubleList withAll(DoubleIterable elements);

    @Override
    MutableDoubleList withoutAll(DoubleIterable elements);

    /**
     * @since 9.0.
     */
    @Override
    default MutableDoubleList tap(DoubleProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    <V> MutableList<V> collect(DoubleToObjectFunction<? extends V> function);

    /**
     * Returns a new MutableList using results obtained by applying the specified function to each element
     * and its corresponding index.
     *
     * @since 9.1.
     */
    @Override
    default <V> MutableList<V> collectWithIndex(DoubleIntToObjectFunction<? extends V> function)
    {
        int[] index = { 0 };
        return this.collect(each -> function.value(each, index[0]++));
    }

    MutableDoubleList reverseThis();

    @Override
    MutableDoubleList toReversed();

    /**
     * @since 6.0.
     */
    @Override
    MutableDoubleList distinct();

    /**
     * Sorts this list mutating its contents and returns the same mutable list (this).
     */
    MutableDoubleList sortThis();

    @Override
    MutableDoubleList asUnmodifiable();

    @Override
    MutableDoubleList asSynchronized();

    /**
     * Returns an immutable copy of this list.
     */
    @Override
    ImmutableDoubleList toImmutable();

    @Override
    MutableDoubleList subList(int fromIndex, int toIndex);

    /**
     * Returns a {@code MutableList} formed from this {@code MutableDoubleList} and another {@code DoubleList} by
     * combining corresponding elements in pairs. If one of the two {@code DoubleList}s is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default MutableList<DoubleDoublePair> zipDouble(DoubleIterable iterable)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Returns a {@code MutableList} formed from this {@code MutableDoubleList} and a {@code ListIterable} by
     * combining corresponding elements in pairs. If one of the two Lists is longer than the other, its
     * remaining elements are ignored.
     *
     * @since 9.1.
     */
    default <T> MutableList<DoubleObjectPair<T>> zip(Iterable<T> list)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    /**
     * Creates a new empty mutable version of the same List type.
     *
     * @since 9.2.
     */
    default MutableDoubleList newEmpty()
    {
        throw new UnsupportedOperationException("Implement in concrete classes.");
    }
}
