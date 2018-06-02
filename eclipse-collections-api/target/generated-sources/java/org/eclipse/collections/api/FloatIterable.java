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
import java.util.DoubleSummaryStatistics;

import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.block.function.primitive.FloatToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToByteFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToShortFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToIntFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectFloatToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;

/**
 * FloatIterable is an interface which is memory-optimized for float primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an FloatIterator. FloatIterator helps iterate over the FloatIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface FloatIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the FloatIterable in an
     * imperative style.
     */
    FloatIterator floatIterator();

    /**
     * Converts the FloatIterable to a primitive float array.
     */
    float[] toArray();

    /**
     * Returns true if the value is contained in the FloatIterable, and false if it is not.
     */
    boolean contains(float value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the FloatIterable, and false if they are not.
     */
    boolean containsAll(float... source);

    /**
     * Returns true if the all of the values specified in the source FloatIterable are contained
     * in the FloatIterable, and false if they are not.
     */
    boolean containsAll(FloatIterable source);

    /**
     * Applies the FloatProcedure to each element in the FloatIterable.
     */
    void forEach(FloatProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(FloatProcedure procedure);

    /**
     * @since 9.0.
     */
    default FloatIterable tap(FloatProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new FloatIterable with all of the elements in the FloatIterable that
     * return true for the specified predicate.
     */
    FloatIterable select(FloatPredicate predicate);

    /**
     * Returns a new FloatIterable with all of the elements in the FloatIterable that
     * return false for the specified predicate.
     */
    FloatIterable reject(FloatPredicate predicate);

    /**
     * Same as {@link #select(FloatPredicate)} , only the results are added to the target MutableFloatCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableFloatCollection> R select(FloatPredicate predicate, R target)
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
     * Same as {@link #reject(FloatPredicate)} , only the results are added to the target MutableFloatCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableFloatCollection> R reject(FloatPredicate predicate, R target)
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
    <V> RichIterable<V> collect(FloatToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(FloatToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(FloatToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(FloatToObjectFunction)}. With {@code collect}, when the {@link FloatToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(FloatToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(FloatToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(FloatToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(FloatToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(FloatToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(FloatToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(FloatToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(FloatToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(FloatToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    float detectIfNone(FloatPredicate predicate, float ifNone);

    /**
     * Returns a count of the number of elements in the FloatIterable that return true for the
     * specified predicate.
     */
    int count(FloatPredicate predicate);

    /**
     * Returns true if any of the elements in the FloatIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(FloatPredicate predicate);

    /**
     * Returns true if all of the elements in the FloatIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(FloatPredicate predicate);

    /**
     * Returns true if none of the elements in the FloatIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(FloatPredicate predicate);

    /**
     * Converts the FloatIterable to a new MutableFloatList.
     */
    MutableFloatList toList();

    /**
     * Converts the FloatIterable to a new MutableFloatSet.
     */
    MutableFloatSet toSet();

    /**
     * Converts the FloatIterable to a new MutableFloatBag.
     */
    MutableFloatBag toBag();

    /**
     * Returns a LazyFloatIterable adapter wrapping the source FloatIterable.
     */
    LazyFloatIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectFloatToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code FloatIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<FloatIterable> chunk(int size)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }

    double sum();

    /**
     * @since 8.0
     */
    default DoubleSummaryStatistics summaryStatistics()
    {
        DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
        this.forEach(stats::accept);
        return stats;
    }

    float max();

    float maxIfEmpty(float defaultValue);

    float min();

    float minIfEmpty(float defaultValue);

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

    float[] toSortedArray();

    MutableFloatList toSortedList();
}
