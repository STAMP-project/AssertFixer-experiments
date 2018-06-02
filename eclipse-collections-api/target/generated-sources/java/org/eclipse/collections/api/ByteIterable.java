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

import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.block.function.primitive.ByteToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToCharFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToIntFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectByteToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BytePredicate;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.primitive.MutableByteList;
import org.eclipse.collections.api.set.primitive.MutableByteSet;

/**
 * ByteIterable is an interface which is memory-optimized for byte primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an ByteIterator. ByteIterator helps iterate over the ByteIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface ByteIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the ByteIterable in an
     * imperative style.
     */
    ByteIterator byteIterator();

    /**
     * Converts the ByteIterable to a primitive byte array.
     */
    byte[] toArray();

    /**
     * Returns true if the value is contained in the ByteIterable, and false if it is not.
     */
    boolean contains(byte value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the ByteIterable, and false if they are not.
     */
    boolean containsAll(byte... source);

    /**
     * Returns true if the all of the values specified in the source ByteIterable are contained
     * in the ByteIterable, and false if they are not.
     */
    boolean containsAll(ByteIterable source);

    /**
     * Applies the ByteProcedure to each element in the ByteIterable.
     */
    void forEach(ByteProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(ByteProcedure procedure);

    /**
     * @since 9.0.
     */
    default ByteIterable tap(ByteProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new ByteIterable with all of the elements in the ByteIterable that
     * return true for the specified predicate.
     */
    ByteIterable select(BytePredicate predicate);

    /**
     * Returns a new ByteIterable with all of the elements in the ByteIterable that
     * return false for the specified predicate.
     */
    ByteIterable reject(BytePredicate predicate);

    /**
     * Same as {@link #select(BytePredicate)} , only the results are added to the target MutableByteCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableByteCollection> R select(BytePredicate predicate, R target)
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
     * Same as {@link #reject(BytePredicate)} , only the results are added to the target MutableByteCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableByteCollection> R reject(BytePredicate predicate, R target)
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
    <V> RichIterable<V> collect(ByteToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(ByteToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(ByteToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(ByteToObjectFunction)}. With {@code collect}, when the {@link ByteToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(ByteToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(ByteToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(ByteToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(ByteToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(ByteToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(ByteToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(ByteToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(ByteToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(ByteToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    byte detectIfNone(BytePredicate predicate, byte ifNone);

    /**
     * Returns a count of the number of elements in the ByteIterable that return true for the
     * specified predicate.
     */
    int count(BytePredicate predicate);

    /**
     * Returns true if any of the elements in the ByteIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(BytePredicate predicate);

    /**
     * Returns true if all of the elements in the ByteIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(BytePredicate predicate);

    /**
     * Returns true if none of the elements in the ByteIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(BytePredicate predicate);

    /**
     * Converts the ByteIterable to a new MutableByteList.
     */
    MutableByteList toList();

    /**
     * Converts the ByteIterable to a new MutableByteSet.
     */
    MutableByteSet toSet();

    /**
     * Converts the ByteIterable to a new MutableByteBag.
     */
    MutableByteBag toBag();

    /**
     * Returns a LazyByteIterable adapter wrapping the source ByteIterable.
     */
    LazyByteIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectByteToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code ByteIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<ByteIterable> chunk(int size)
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

    byte max();

    byte maxIfEmpty(byte defaultValue);

    byte min();

    byte minIfEmpty(byte defaultValue);

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

    byte[] toSortedArray();

    MutableByteList toSortedList();
}
