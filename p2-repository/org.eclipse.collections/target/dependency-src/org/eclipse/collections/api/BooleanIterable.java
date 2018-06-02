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

import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToByteFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToShortFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToCharFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToIntFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToLongFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectBooleanToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.BooleanPredicate;
import org.eclipse.collections.api.block.procedure.primitive.BooleanProcedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.list.primitive.MutableBooleanList;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;

/**
 * BooleanIterable is an interface which is memory-optimized for boolean primitives.
 * It is inspired by the interface RichIterable, and contains a subset of the internal iterator methods on RichIterable like collect, sum, etc.
 * The API also includes an external iterator method, which returns an BooleanIterator. BooleanIterator helps iterate over the BooleanIterable without boxing the primitives.
 * This file was automatically generated from template file primitiveIterable.stg.
 */
public interface BooleanIterable extends PrimitiveIterable
{
    /**
     * Returns a primitive iterator that can be used to iterate over the BooleanIterable in an
     * imperative style.
     */
    BooleanIterator booleanIterator();

    /**
     * Converts the BooleanIterable to a primitive boolean array.
     */
    boolean[] toArray();

    /**
     * Returns true if the value is contained in the BooleanIterable, and false if it is not.
     */
    boolean contains(boolean value);

    /**
     * Returns true if the all of the values specified in the source array are contained
     * in the BooleanIterable, and false if they are not.
     */
    boolean containsAll(boolean... source);

    /**
     * Returns true if the all of the values specified in the source BooleanIterable are contained
     * in the BooleanIterable, and false if they are not.
     */
    boolean containsAll(BooleanIterable source);

    /**
     * Applies the BooleanProcedure to each element in the BooleanIterable.
     */
    void forEach(BooleanProcedure procedure);

    /**
     * A synonym for forEach.
     *
     * @since 7.0.
     */
    void each(BooleanProcedure procedure);

    /**
     * @since 9.0.
     */
    default BooleanIterable tap(BooleanProcedure procedure)
    {
        this.forEach(procedure);
        return this;
    }

    /**
     * Returns a new BooleanIterable with all of the elements in the BooleanIterable that
     * return true for the specified predicate.
     */
    BooleanIterable select(BooleanPredicate predicate);

    /**
     * Returns a new BooleanIterable with all of the elements in the BooleanIterable that
     * return false for the specified predicate.
     */
    BooleanIterable reject(BooleanPredicate predicate);

    /**
     * Same as {@link #select(BooleanPredicate)} , only the results are added to the target MutableBooleanCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableBooleanCollection> R select(BooleanPredicate predicate, R target)
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
     * Same as {@link #reject(BooleanPredicate)} , only the results are added to the target MutableBooleanCollection.
     *
     * @since 8.1.
     */
    default <R extends MutableBooleanCollection> R reject(BooleanPredicate predicate, R target)
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
    <V> RichIterable<V> collect(BooleanToObjectFunction<? extends V> function);

    /**
     * Same as {@link #collect(BooleanToObjectFunction)} , only the results are added to the target Collection.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R collect(BooleanToObjectFunction<? extends V> function, R target)
    {
        this.each(each -> target.add(function.valueOf(each)));
        return target;
    }

    /**
     * {@code flatCollect} is a special case of {@link #collect(BooleanToObjectFunction)}. With {@code collect}, when the {@link BooleanToObjectFunction} returns
     * a collection, the result is a collection of collections. {@code flatCollect} outputs a single "flattened" collection
     * instead.  This method is commonly called flatMap.
     *
     * @since 8.1.
     */
    default <V, R extends Collection<V>> R flatCollect(BooleanToObjectFunction<? extends Iterable<V>> function, R target)
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
    default <R extends MutableBooleanCollection> R collectBoolean(BooleanToBooleanFunction function, R target)
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
    default <R extends MutableByteCollection> R collectByte(BooleanToByteFunction function, R target)
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
    default <R extends MutableCharCollection> R collectChar(BooleanToCharFunction function, R target)
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
    default <R extends MutableShortCollection> R collectShort(BooleanToShortFunction function, R target)
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
    default <R extends MutableIntCollection> R collectInt(BooleanToIntFunction function, R target)
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
    default <R extends MutableFloatCollection> R collectFloat(BooleanToFloatFunction function, R target)
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
    default <R extends MutableLongCollection> R collectLong(BooleanToLongFunction function, R target)
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
    default <R extends MutableDoubleCollection> R collectDouble(BooleanToDoubleFunction function, R target)
    {
        this.each(each ->  target.add(function.valueOf(each)));
        return target;
    }

    boolean detectIfNone(BooleanPredicate predicate, boolean ifNone);

    /**
     * Returns a count of the number of elements in the BooleanIterable that return true for the
     * specified predicate.
     */
    int count(BooleanPredicate predicate);

    /**
     * Returns true if any of the elements in the BooleanIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean anySatisfy(BooleanPredicate predicate);

    /**
     * Returns true if all of the elements in the BooleanIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean allSatisfy(BooleanPredicate predicate);

    /**
     * Returns true if none of the elements in the BooleanIterable return true for the
     * specified predicate, otherwise returns false.
     */
    boolean noneSatisfy(BooleanPredicate predicate);

    /**
     * Converts the BooleanIterable to a new MutableBooleanList.
     */
    MutableBooleanList toList();

    /**
     * Converts the BooleanIterable to a new MutableBooleanSet.
     */
    MutableBooleanSet toSet();

    /**
     * Converts the BooleanIterable to a new MutableBooleanBag.
     */
    MutableBooleanBag toBag();

    /**
     * Returns a LazyBooleanIterable adapter wrapping the source BooleanIterable.
     */
    LazyBooleanIterable asLazy();

    <T> T injectInto(T injectedValue, ObjectBooleanToObjectFunction<? super T, ? extends T> function);

    /**
     * Partitions elements in fixed size chunks.
     *
     * @param size the number of elements per chunk
     *
     * @return A {@code RichIterable} containing {@code BooleanIterable}s of size {@code size}, except the last will be
     * truncated if the elements don't divide evenly.
     *
     * @since 9.2
     */
    default RichIterable<BooleanIterable> chunk(int size)
    {
        throw new UnsupportedOperationException("Default method to prevent breaking backwards compatibility");
    }
}
