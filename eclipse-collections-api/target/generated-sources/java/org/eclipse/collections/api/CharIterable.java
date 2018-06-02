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

import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.block.function.primitive.CharToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.CharToByteFunction;
import org.eclipse.collections.api.block.function.primitive.CharToShortFunction;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.CharToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.CharToIntFunction;
import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectCharToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.CharPredicate;
import org.eclipse.collections.api.block.procedure.primitive.CharProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.primitive.MutableCharList;
import org.eclipse.collections.api.set.primitive.MutableCharSet;

/**
 * CharIterable is an interface which is memory-optimized for char primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an CharIterator. CharIterator helps iterate over the CharIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface CharIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the CharIterable in an
     * imperative style.
     */
    CharIterator charIterator();

    /**
     * Converts the CharIterable to a primitive char array.
     */
    char[] toArray();

    /**
     * Returns true if the value is contained in the CharIterable, and false if it is not.
     */
    boolean contains(char value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the CharIterable, and false if they are not.
     */
    boolean containsAll(char... source);

    /**
     * Returns true if the all of the values specified in the source CharIterable are contained
     * in the CharIterable, and false if they are not.
     */
    boolean containsAll(CharIterable source);

    /**
     * Applies the CharProcedure to each element in the CharIterable.
     */
    void forEach(CharProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(CharProcedure procedure);

    /**
     * @since 9.0.
     */
    default CharIterable tap(CharProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new CharIterable with all of the elements in the CharIterable that
     * return true for the specified predicate.
     */
    CharIterable select(CharPredicate predicate);

    /**
     * Returns a new CharIterable with all of the elements in the CharIterable that
     * return false for the specified predicate.
     */
    CharIterable reject(CharPredicate predicate);

    /**
     * Same as {@link #select(CharPredicate)} , only the results are added to the target MutableCharCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableCharCollection> R select(CharPredicate predicate, R target)
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
     * Same as {@link #reject(CharPredicate)} , only the results are added to the target MutableCharCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableCharCollection> R reject(CharPredicate predicate, R target)
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
    <V> RichIterable<V> collect(CharToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(CharToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(CharToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(CharToObjectFunction)}. With {@code collect}, when the {@link CharToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(CharToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(CharToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(CharToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(CharToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(CharToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(CharToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(CharToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(CharToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(CharToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    char detectIfNone(CharPredicate predicate, char ifNone);

    /**
     * Returns a count of the number of elements in the CharIterable that return true for the
     * specified predicate.
     */
    int count(CharPredicate predicate);

    /**
     * Returns true if any of the elements in the CharIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(CharPredicate predicate);

    /**
     * Returns true if all of the elements in the CharIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(CharPredicate predicate);

    /**
     * Returns true if none of the elements in the CharIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(CharPredicate predicate);

    /**
     * Converts the CharIterable to a new MutableCharList.
     */
    MutableCharList toList();

    /**
     * Converts the CharIterable to a new MutableCharSet.
     */
    MutableCharSet toSet();

    /**
     * Converts the CharIterable to a new MutableCharBag.
     */
    MutableCharBag toBag();

    /**
     * Returns a LazyCharIterable adapter wrapping the source CharIterable.
     */
    LazyCharIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectCharToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code CharIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<CharIterable> chunk(int size)
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

    char max();

    char maxIfEmpty(char defaultValue);

    char min();

    char minIfEmpty(char defaultValue);

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

    char[] toSortedArray();

    MutableCharList toSortedList();
}
