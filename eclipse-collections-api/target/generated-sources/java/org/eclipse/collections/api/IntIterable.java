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

import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.block.function.primitive.IntToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.IntToByteFunction;
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.api.block.function.primitive.IntToCharFunction;
import org.eclipse.collections.api.block.function.primitive.IntToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.IntToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectIntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.set.primitive.MutableIntSet;

/**
 * IntIterable is an interface which is memory-optimized for int primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an IntIterator. IntIterator helps iterate over the IntIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface IntIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the IntIterable in an
     * imperative style.
     */
    IntIterator intIterator();

    /**
     * Converts the IntIterable to a primitive int array.
     */
    int[] toArray();

    /**
     * Returns true if the value is contained in the IntIterable, and false if it is not.
     */
    boolean contains(int value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the IntIterable, and false if they are not.
     */
    boolean containsAll(int... source);

    /**
     * Returns true if the all of the values specified in the source IntIterable are contained
     * in the IntIterable, and false if they are not.
     */
    boolean containsAll(IntIterable source);

    /**
     * Applies the IntProcedure to each element in the IntIterable.
     */
    void forEach(IntProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(IntProcedure procedure);

    /**
     * @since 9.0.
     */
    default IntIterable tap(IntProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new IntIterable with all of the elements in the IntIterable that
     * return true for the specified predicate.
     */
    IntIterable select(IntPredicate predicate);

    /**
     * Returns a new IntIterable with all of the elements in the IntIterable that
     * return false for the specified predicate.
     */
    IntIterable reject(IntPredicate predicate);

    /**
     * Same as {@link #select(IntPredicate)} , only the results are added to the target MutableIntCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableIntCollection> R select(IntPredicate predicate, R target)
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
     * Same as {@link #reject(IntPredicate)} , only the results are added to the target MutableIntCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableIntCollection> R reject(IntPredicate predicate, R target)
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
    <V> RichIterable<V> collect(IntToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(IntToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(IntToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(IntToObjectFunction)}. With {@code collect}, when the {@link IntToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(IntToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(IntToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(IntToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(IntToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(IntToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(IntToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(IntToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(IntToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(IntToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    int detectIfNone(IntPredicate predicate, int ifNone);

    /**
     * Returns a count of the number of elements in the IntIterable that return true for the
     * specified predicate.
     */
    int count(IntPredicate predicate);

    /**
     * Returns true if any of the elements in the IntIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(IntPredicate predicate);

    /**
     * Returns true if all of the elements in the IntIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(IntPredicate predicate);

    /**
     * Returns true if none of the elements in the IntIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(IntPredicate predicate);

    /**
     * Converts the IntIterable to a new MutableIntList.
     */
    MutableIntList toList();

    /**
     * Converts the IntIterable to a new MutableIntSet.
     */
    MutableIntSet toSet();

    /**
     * Converts the IntIterable to a new MutableIntBag.
     */
    MutableIntBag toBag();

    /**
     * Returns a LazyIntIterable adapter wrapping the source IntIterable.
     */
    LazyIntIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectIntToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code IntIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<IntIterable> chunk(int size)
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

    int max();

    int maxIfEmpty(int defaultValue);

    int min();

    int minIfEmpty(int defaultValue);

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

    int[] toSortedArray();

    MutableIntList toSortedList();
}
