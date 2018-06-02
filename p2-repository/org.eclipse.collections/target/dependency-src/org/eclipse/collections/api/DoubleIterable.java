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

import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.block.function.primitive.DoubleToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToByteFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToShortFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToCharFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToIntFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectDoubleToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;

/**
 * DoubleIterable is an interface which is memory-optimized for double primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an DoubleIterator. DoubleIterator helps iterate over the DoubleIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface DoubleIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the DoubleIterable in an
     * imperative style.
     */
    DoubleIterator doubleIterator();

    /**
     * Converts the DoubleIterable to a primitive double array.
     */
    double[] toArray();

    /**
     * Returns true if the value is contained in the DoubleIterable, and false if it is not.
     */
    boolean contains(double value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the DoubleIterable, and false if they are not.
     */
    boolean containsAll(double... source);

    /**
     * Returns true if the all of the values specified in the source DoubleIterable are contained
     * in the DoubleIterable, and false if they are not.
     */
    boolean containsAll(DoubleIterable source);

    /**
     * Applies the DoubleProcedure to each element in the DoubleIterable.
     */
    void forEach(DoubleProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(DoubleProcedure procedure);

    /**
     * @since 9.0.
     */
    default DoubleIterable tap(DoubleProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new DoubleIterable with all of the elements in the DoubleIterable that
     * return true for the specified predicate.
     */
    DoubleIterable select(DoublePredicate predicate);

    /**
     * Returns a new DoubleIterable with all of the elements in the DoubleIterable that
     * return false for the specified predicate.
     */
    DoubleIterable reject(DoublePredicate predicate);

    /**
     * Same as {@link #select(DoublePredicate)} , only the results are added to the target MutableDoubleCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableDoubleCollection> R select(DoublePredicate predicate, R target)
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
     * Same as {@link #reject(DoublePredicate)} , only the results are added to the target MutableDoubleCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableDoubleCollection> R reject(DoublePredicate predicate, R target)
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
    <V> RichIterable<V> collect(DoubleToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(DoubleToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(DoubleToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(DoubleToObjectFunction)}. With {@code collect}, when the {@link DoubleToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(DoubleToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(DoubleToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(DoubleToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(DoubleToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(DoubleToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(DoubleToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(DoubleToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(DoubleToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(DoubleToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    double detectIfNone(DoublePredicate predicate, double ifNone);

    /**
     * Returns a count of the number of elements in the DoubleIterable that return true for the
     * specified predicate.
     */
    int count(DoublePredicate predicate);

    /**
     * Returns true if any of the elements in the DoubleIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(DoublePredicate predicate);

    /**
     * Returns true if all of the elements in the DoubleIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(DoublePredicate predicate);

    /**
     * Returns true if none of the elements in the DoubleIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(DoublePredicate predicate);

    /**
     * Converts the DoubleIterable to a new MutableDoubleList.
     */
    MutableDoubleList toList();

    /**
     * Converts the DoubleIterable to a new MutableDoubleSet.
     */
    MutableDoubleSet toSet();

    /**
     * Converts the DoubleIterable to a new MutableDoubleBag.
     */
    MutableDoubleBag toBag();

    /**
     * Returns a LazyDoubleIterable adapter wrapping the source DoubleIterable.
     */
    LazyDoubleIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectDoubleToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code DoubleIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<DoubleIterable> chunk(int size)
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

    double max();

    double maxIfEmpty(double defaultValue);

    double min();

    double minIfEmpty(double defaultValue);

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

    double[] toSortedArray();

    MutableDoubleList toSortedList();
}
