/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.api;

import java.util.Collection;
import java.util.LongSummaryStatistics;

import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.block.function.primitive.LongToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.LongToByteFunction;
import org.eclipse.collections.api.block.function.primitive.LongToShortFunction;
import org.eclipse.collections.api.block.function.primitive.LongToCharFunction;
import org.eclipse.collections.api.block.function.primitive.LongToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.LongToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.LongToIntFunction;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectLongToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.MutableLongSet;

/**
 * LongIterable is an interface which is memory-optimized for long primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an LongIterator. LongIterator helps iterate over the LongIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface LongIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the LongIterable in an
     * imperative style.
     */
    LongIterator longIterator();

    /**
     * Converts the LongIterable to a primitive long array.
     */
    long[] toArray();

    /**
     * Returns true if the value is contained in the LongIterable, and false if it is not.
     */
    boolean contains(long value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the LongIterable, and false if they are not.
     */
    boolean containsAll(long... source);

    /**
     * Returns true if the all of the values specified in the source LongIterable are contained
     * in the LongIterable, and false if they are not.
     */
    boolean containsAll(LongIterable source);

    /**
     * Applies the LongProcedure to each element in the LongIterable.
     */
    void forEach(LongProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(LongProcedure procedure);

    /**
     * @since 9.0.
     */
    default LongIterable tap(LongProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new LongIterable with all of the elements in the LongIterable that
     * return true for the specified predicate.
     */
    LongIterable select(LongPredicate predicate);

    /**
     * Returns a new LongIterable with all of the elements in the LongIterable that
     * return false for the specified predicate.
     */
    LongIterable reject(LongPredicate predicate);

    /**
     * Same as {@link #select(LongPredicate)} , only the results are added to the target MutableLongCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableLongCollection> R select(LongPredicate predicate, R target)
    {
        this.each(each ->
        {
            if (predicate.accept(each))
            {
                target.add(each);
            }
        });
        return target;
    }

    /**
     * Same as {@link #reject(LongPredicate)} , only the results are added to the target MutableLongCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableLongCollection> R reject(LongPredicate predicate, R target)
    {
        this.each(each ->
        {
            if (!predicate.accept(each))
            {
                target.add(each);
            }
        });
        return target;
    }

    /**
     * Returns a new collection with the results of applying the specified function on each element of the source
     * collection.  This method is also commonly called transform or map.
     */
    <V> RichIterable<V> collect(LongToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(LongToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(LongToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(LongToObjectFunction)}. With {@code collect}, when the {@link LongToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(LongToObjectFunction<? extends Iterable<V>> function, R target)
    {
        this.each(each ->
        {
            Iterable<V> iterable = function.valueOf(each);
            if (iterable instanceof Collection)
            {
                target.addAll((Collection<V>) iterable);
            }
            else
            {
                iterable.forEach(target::add);
            }
        });
        return target;
    }

    /**
     * Returns the target {@code MutableBooleanCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableBooleanCollection> R collectBoolean(LongToBooleanFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableByteCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableByteCollection> R collectByte(LongToByteFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableCharCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableCharCollection> R collectChar(LongToCharFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableShortCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableShortCollection> R collectShort(LongToShortFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableIntCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableIntCollection> R collectInt(LongToIntFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableFloatCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableFloatCollection> R collectFloat(LongToFloatFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableLongCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableLongCollection> R collectLong(LongToLongFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    /**
     * Returns the target {@code MutableDoubleCollection} with the results of applying the specified function on each element
     * of the source collection.
     *
     * @since 8.1.
     */
    default <R extends MutableDoubleCollection> R collectDouble(LongToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    long detectIfNone(LongPredicate predicate, long ifNone);

    /**
     * Returns a count of the number of elements in the LongIterable that return true for the
     * specified predicate.
     */
    int count(LongPredicate predicate);

    /**
     * Returns true if any of the elements in the LongIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(LongPredicate predicate);

    /**
     * Returns true if all of the elements in the LongIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(LongPredicate predicate);

    /**
     * Returns true if none of the elements in the LongIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(LongPredicate predicate);

    /**
     * Converts the LongIterable to a new MutableLongList.
     */
    MutableLongList toList();

    /**
     * Converts the LongIterable to a new MutableLongSet.
     */
    MutableLongSet toSet();

    /**
     * Converts the LongIterable to a new MutableLongBag.
     */
    MutableLongBag toBag();

    /**
     * Returns a LazyLongIterable adapter wrapping the source LongIterable.
     */
    LazyLongIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectLongToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code LongIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<LongIterable> chunk(int size)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    long sum();

    /**
     * @since 8.0
     */
    default LongSummaryStatistics summaryStatistics()
    {
        LongSummaryStatistics stats = new LongSummaryStatistics();
        this.forEach(stats::accept);
        return stats;
    }

    long max();

    long maxIfEmpty(long defaultValue);

    long min();

    long minIfEmpty(long defaultValue);

    double average();

    /**
     * @since 9.0
     */
    default double averageIfEmpty(double defaultValue)
    {
        if (this.isEmpty())
        {
            return defaultValue;
        }
        return this.average();
    }

    double median();

    /**
     * @since 9.0
     */
    default double medianIfEmpty(double defaultValue)
    {
        if (this.isEmpty())
        {
            return defaultValue;
        }
        return this.median();
    }

    long[] toSortedArray();

    MutableLongList toSortedList();
}
