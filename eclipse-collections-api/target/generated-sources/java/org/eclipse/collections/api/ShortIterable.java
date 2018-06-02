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
import java.util.IntSummaryStatistics;

import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToCharFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToIntFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectShortToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.set.primitive.MutableShortSet;

/**
 * ShortIterable is an interface which is memory-optimized for short primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an ShortIterator. ShortIterator helps iterate over the ShortIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface ShortIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the ShortIterable in an
     * imperative style.
     */
    ShortIterator shortIterator();

    /**
     * Converts the ShortIterable to a primitive short array.
     */
    short[] toArray();

    /**
     * Returns true if the value is contained in the ShortIterable, and false if it is not.
     */
    boolean contains(short value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the ShortIterable, and false if they are not.
     */
    boolean containsAll(short... source);

    /**
     * Returns true if the all of the values specified in the source ShortIterable are contained
     * in the ShortIterable, and false if they are not.
     */
    boolean containsAll(ShortIterable source);

    /**
     * Applies the ShortProcedure to each element in the ShortIterable.
     */
    void forEach(ShortProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(ShortProcedure procedure);

    /**
     * @since 9.0.
     */
    default ShortIterable tap(ShortProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new ShortIterable with all of the elements in the ShortIterable that
     * return true for the specified predicate.
     */
    ShortIterable select(ShortPredicate predicate);

    /**
     * Returns a new ShortIterable with all of the elements in the ShortIterable that
     * return false for the specified predicate.
     */
    ShortIterable reject(ShortPredicate predicate);

    /**
     * Same as {@link #select(ShortPredicate)} , only the results are added to the target MutableShortCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableShortCollection> R select(ShortPredicate predicate, R target)
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
     * Same as {@link #reject(ShortPredicate)} , only the results are added to the target MutableShortCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableShortCollection> R reject(ShortPredicate predicate, R target)
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
    <V> RichIterable<V> collect(ShortToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(ShortToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(ShortToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(ShortToObjectFunction)}. With {@code collect}, when the {@link ShortToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(ShortToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(ShortToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(ShortToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(ShortToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(ShortToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(ShortToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(ShortToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(ShortToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(ShortToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    short detectIfNone(ShortPredicate predicate, short ifNone);

    /**
     * Returns a count of the number of elements in the ShortIterable that return true for the
     * specified predicate.
     */
    int count(ShortPredicate predicate);

    /**
     * Returns true if any of the elements in the ShortIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(ShortPredicate predicate);

    /**
     * Returns true if all of the elements in the ShortIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(ShortPredicate predicate);

    /**
     * Returns true if none of the elements in the ShortIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(ShortPredicate predicate);

    /**
     * Converts the ShortIterable to a new MutableShortList.
     */
    MutableShortList toList();

    /**
     * Converts the ShortIterable to a new MutableShortSet.
     */
    MutableShortSet toSet();

    /**
     * Converts the ShortIterable to a new MutableShortBag.
     */
    MutableShortBag toBag();

    /**
     * Returns a LazyShortIterable adapter wrapping the source ShortIterable.
     */
    LazyShortIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectShortToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code ShortIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<ShortIterable> chunk(int size)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    long sum();

    /**
     * @since 8.0
     */
    default IntSummaryStatistics summaryStatistics()
    {
        IntSummaryStatistics stats = new IntSummaryStatistics();
        this.forEach(stats::accept);
        return stats;
    }

    short max();

    short maxIfEmpty(short defaultValue);

    short min();

    short minIfEmpty(short defaultValue);

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

    short[] toSortedArray();

    MutableShortList toSortedList();
}
