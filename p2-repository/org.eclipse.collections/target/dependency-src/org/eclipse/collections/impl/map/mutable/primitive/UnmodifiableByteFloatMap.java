/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.io.Serializable;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectFloatToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatPredicate;
import org.eclipse.collections.api.block.predicate.primitive.ByteFloatPredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteFloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ByteProcedure;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.list.primitive.MutableFloatList;
import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.api.map.primitive.ByteFloatMap;
import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.eclipse.collections.api.map.primitive.MutableFloatByteMap;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.ByteFloatPair;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableFloatCollection;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.iterator.UnmodifiableFloatIterator;
import org.eclipse.collections.impl.set.mutable.primitive.UnmodifiableByteSet;

/**
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMap.stg.
 *
 * @since 3.1.
 */
public class UnmodifiableByteFloatMap
        implements MutableByteFloatMap, Serializable
{
    private static final long serialVersionUID = 1L;
    private final MutableByteFloatMap map;

    public UnmodifiableByteFloatMap(MutableByteFloatMap map)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("Cannot create a UnmodifiableByteFloatMap on a null map");
        }

        this.map = map;
    }

    @Override
    public void clear()
    {
        throw new UnsupportedOperationException("Cannot call clear() on " + this.getClass().getSimpleName());
    }

    @Override
    public void put(byte key, float value)
    {
        throw new UnsupportedOperationException("Cannot call put() on " + this.getClass().getSimpleName());
    }

    @Override
    public void putPair(ByteFloatPair keyValuePair)
    {
        throw new UnsupportedOperationException("Cannot call putPair() on " + this.getClass().getSimpleName());
    }

    @Override
    public void putAll(ByteFloatMap map)
    {
        throw new UnsupportedOperationException("Cannot call putAll() on " + this.getClass().getSimpleName());
    }

    @Override
    public void removeKey(byte key)
    {
        throw new UnsupportedOperationException("Cannot call removeKey() on " + this.getClass().getSimpleName());
    }

    @Override
    public void remove(byte key)
    {
        throw new UnsupportedOperationException("Cannot call remove() on " + this.getClass().getSimpleName());
    }

    @Override
    public float removeKeyIfAbsent(byte key, float value)
    {
        if (this.map.containsKey(key))
        {
            throw new UnsupportedOperationException("Cannot call removeKey() on " + this.getClass().getSimpleName());
        }
        return value;
    }

    @Override
    public float getIfAbsentPut(byte key, float value)
    {
        return this.map.getIfAbsentPut(key, () -> { throw new UnsupportedOperationException(); });
    }

    @Override
    public float getIfAbsentPut(byte key, FloatFunction0 function)
    {
        return this.map.getIfAbsentPut(key, () -> { throw new UnsupportedOperationException(); });
    }

    @Override
    public float getIfAbsentPutWithKey(byte key, ByteToFloatFunction function)
    {
        return this.map.getIfAbsentPut(key, () -> { throw new UnsupportedOperationException(); });
    }

    @Override
    public <P> float getIfAbsentPutWith(byte key, FloatFunction<? super P> function, P parameter)
    {
        return this.map.getIfAbsentPut(key, () -> { throw new UnsupportedOperationException(); });
    }

    @Override
    public float updateValue(byte key, float initialValueIfAbsent, FloatToFloatFunction function)
    {
        throw new UnsupportedOperationException("Cannot call updateValue() on " + this.getClass().getSimpleName());
    }

    @Override
    public float get(byte key)
    {
        return this.map.get(key);
    }

    @Override
    public float getIfAbsent(byte key, float ifAbsent)
    {
        return this.map.getIfAbsent(key, ifAbsent);
    }

    @Override
    public float getOrThrow(byte key)
    {
        return this.map.getOrThrow(key);
    }

    @Override
    public boolean containsKey(byte key)
    {
        return this.map.containsKey(key);
    }

    @Override
    public boolean containsValue(float value)
    {
        return this.map.containsValue(value);
    }

    @Override
    public void forEachValue(FloatProcedure procedure)
    {
        this.map.forEachValue(procedure);
    }

    @Override
    public void forEachKey(ByteProcedure procedure)
    {
        this.map.forEachKey(procedure);
    }

    @Override
    public void forEachKeyValue(ByteFloatProcedure procedure)
    {
        this.map.forEachKeyValue(procedure);
    }

    @Override
    public LazyByteIterable keysView()
    {
        return this.map.keysView();
    }

    @Override
    public RichIterable<ByteFloatPair> keyValuesView()
    {
        return this.map.keyValuesView();
    }

    @Override
    public MutableFloatByteMap flipUniqueValues()
    {
        return this.map.flipUniqueValues().asUnmodifiable();
    }

    @Override
    public MutableByteFloatMap select(ByteFloatPredicate predicate)
    {
        return this.map.select(predicate);
    }

    @Override
    public MutableByteFloatMap reject(ByteFloatPredicate predicate)
    {
        return this.map.reject(predicate);
    }

    @Override
    public MutableFloatIterator floatIterator()
    {
        return new UnmodifiableFloatIterator(this.map.floatIterator());
    }

    @Override
    public void forEach(FloatProcedure procedure)
    {
        this.each(procedure);
    }

    /**
     * @since 7.0.
     */
    @Override
    public void each(FloatProcedure procedure)
    {
        this.map.forEach(procedure);
    }

    @Override
    public int count(FloatPredicate predicate)
    {
        return this.map.count(predicate);
    }

    @Override
    public boolean anySatisfy(FloatPredicate predicate)
    {
        return this.map.anySatisfy(predicate);
    }

    @Override
    public boolean allSatisfy(FloatPredicate predicate)
    {
        return this.map.allSatisfy(predicate);
    }

    @Override
    public boolean noneSatisfy(FloatPredicate predicate)
    {
        return this.map.noneSatisfy(predicate);
    }

    @Override
    public MutableFloatBag select(FloatPredicate predicate)
    {
        return this.map.select(predicate);
    }

    @Override
    public MutableFloatBag reject(FloatPredicate predicate)
    {
        return this.map.reject(predicate);
    }

    @Override
    public <V> MutableBag<V> collect(FloatToObjectFunction<? extends V> function)
    {
        return this.map.collect(function);
    }

    @Override
    public float detectIfNone(FloatPredicate predicate, float ifNone)
    {
        return this.map.detectIfNone(predicate, ifNone);
    }

    @Override
    public double sum()
    {
        return this.map.sum();
    }

    @Override
    public float max()
    {
        return this.map.max();
    }

    @Override
    public float maxIfEmpty(float defaultValue)
    {
        return this.map.maxIfEmpty(defaultValue);
    }

    @Override
    public float min()
    {
        return this.map.min();
    }

    @Override
    public float minIfEmpty(float defaultValue)
    {
        return this.map.minIfEmpty(defaultValue);
    }

    @Override
    public double average()
    {
        return this.map.average();
    }

    @Override
    public double median()
    {
        return this.map.median();
    }

    @Override
    public float addToValue(byte key, float toBeAdded)
    {
        throw new UnsupportedOperationException("Cannot call addToValue() on " + this.getClass().getSimpleName());
    }

    @Override
    public float[] toSortedArray()
    {
        return this.map.toSortedArray();
    }

    @Override
    public MutableFloatList toSortedList()
    {
        return this.map.toSortedList();
    }

    @Override
    public float[] toArray()
    {
        return this.map.toArray();
    }

    @Override
    public boolean contains(float value)
    {
        return this.map.contains(value);
    }

    @Override
    public boolean containsAll(float... source)
    {
        return this.map.containsAll(source);
    }

    @Override
    public boolean containsAll(FloatIterable source)
    {
        return this.map.containsAll(source);
    }

    @Override
    public MutableFloatList toList()
    {
        return this.map.toList();
    }

    @Override
    public MutableFloatSet toSet()
    {
        return this.map.toSet();
    }

    @Override
    public MutableFloatBag toBag()
    {
        return this.map.toBag();
    }

    @Override
    public LazyFloatIterable asLazy()
    {
        return this.map.asLazy();
    }

    @Override
    public MutableByteFloatMap withKeyValue(byte key, float value)
    {
        throw new UnsupportedOperationException("Cannot call withKeyValue() on " + this.getClass().getSimpleName());
    }

    @Override
    public MutableByteFloatMap withoutKey(byte key)
    {
        throw new UnsupportedOperationException("Cannot call withoutKey() on " + this.getClass().getSimpleName());
    }

    @Override
    public MutableByteFloatMap withoutAllKeys(ByteIterable keys)
    {
        throw new UnsupportedOperationException("Cannot call withoutAllKeys() on " + this.getClass().getSimpleName());
    }

    @Override
    public MutableByteFloatMap asUnmodifiable()
    {
        return this;
    }

    @Override
    public MutableByteFloatMap asSynchronized()
    {
        return new SynchronizedByteFloatMap(this);
    }

    @Override
    public ImmutableByteFloatMap toImmutable()
    {
        return ByteFloatMaps.immutable.withAll(this);
    }

    @Override
    public int size()
    {
        return this.map.size();
    }

    @Override
    public boolean isEmpty()
    {
        return this.map.isEmpty();
    }

    @Override
    public boolean notEmpty()
    {
        return this.map.notEmpty();
    }

    @Override
    public MutableByteSet keySet()
    {
        return UnmodifiableByteSet.of(this.map.keySet());
    }

    @Override
    public MutableFloatCollection values()
    {
        return UnmodifiableFloatCollection.of(this.map.values());
    }

    @Override
    public boolean equals(Object otherMap)
    {
        return this.map.equals(otherMap);
    }

    @Override
    public int hashCode()
    {
        return this.map.hashCode();
    }

    @Override
    public String toString()
    {
        return this.map.toString();
    }

    @Override
    public String makeString()
    {
        return this.map.makeString();
    }

    @Override
    public String makeString(String separator)
    {
        return this.map.makeString(separator);
    }

    @Override
    public String makeString(String start, String separator, String end)
    {
        return this.map.makeString(start, separator, end);
    }

    @Override
    public void appendString(Appendable appendable)
    {
        this.map.appendString(appendable);
    }

    @Override
    public void appendString(Appendable appendable, String separator)
    {
        this.map.appendString(appendable, separator);
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        this.map.appendString(appendable, start, separator, end);
    }

    @Override
    public <T> T injectInto(T injectedValue, ObjectFloatToObjectFunction<? super T, ? extends T> function)
    {
        return this.map.injectInto(injectedValue, function);
    }

    @Override
    public RichIterable<FloatIterable> chunk(int size)
    {
        return this.map.chunk(size);
    }
}
