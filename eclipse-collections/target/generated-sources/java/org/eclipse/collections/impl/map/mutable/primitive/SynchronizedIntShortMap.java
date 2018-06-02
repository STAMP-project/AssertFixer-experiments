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
import java.util.Collection;
import java.util.Collections;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectShortToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.predicate.primitive.IntShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntShortProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntShortMap;
import org.eclipse.collections.api.map.primitive.IntShortMap;
import org.eclipse.collections.api.map.primitive.MutableIntShortMap;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.tuple.primitive.IntShortPair;
import org.eclipse.collections.impl.SynchronizedRichIterable;
import org.eclipse.collections.impl.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.set.mutable.primitive.SynchronizedIntSet;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedShortCollection;

/**
 * A synchronized view of a {@link MutableIntShortMap}. It is imperative that the user manually synchronize on the collection when iterating over it using the
 * {@link MutableShortIterator} as per {@link Collections#synchronizedCollection(Collection)}.
 * <p>
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMap.stg.
 *
 * @see MutableIntShortMap#asSynchronized()
 * @see MutableMap#asSynchronized()
 * @since 3.1.
 */
public class SynchronizedIntShortMap
        implements MutableIntShortMap, Serializable
{
    private static final long serialVersionUID = 1L;
    private final Object lock;
    private final MutableIntShortMap map;

    public SynchronizedIntShortMap(MutableIntShortMap map)
    {
        this(map, null);
    }

    public SynchronizedIntShortMap(MutableIntShortMap map, Object newLock)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("Cannot create a SynchronizedIntShortMap on a null map");
        }

        this.map = map;
        this.lock = newLock == null ? this : newLock;
    }

    @Override
    public void clear()
    {
        synchronized (this.lock)
        {
            this.map.clear();
        }
    }

    @Override
    public void put(int key, short value)
    {
        synchronized (this.lock)
        {
            this.map.put(key, value);
        }
    }

    @Override
    public void putPair(IntShortPair keyValuePair)
    {
        synchronized (this.lock)
        {
            this.map.put(keyValuePair.getOne(), keyValuePair.getTwo());
        }
    }

    @Override
    public void putAll(IntShortMap map)
    {
        synchronized (this.lock)
        {
            this.map.putAll(map);
        }
    }

    @Override
    public void removeKey(int key)
    {
        synchronized (this.lock)
        {
            this.map.removeKey(key);
        }
    }

    @Override
    public void remove(int key)
    {
        synchronized (this.lock)
        {
            this.map.remove(key);
        }
    }

    @Override
    public short removeKeyIfAbsent(int key, short value)
    {
        synchronized (this.lock)
        {
            return this.map.removeKeyIfAbsent(key, value);
        }
    }

    @Override
    public short getIfAbsentPut(int key, short value)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPut(key, value);
        }
    }

    @Override
    public short getIfAbsentPut(int key, ShortFunction0 function)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPut(key, function);
        }
    }

    @Override
    public short getIfAbsentPutWithKey(int key, IntToShortFunction function)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPutWithKey(key, function);
        }
    }

    @Override
    public <P> short getIfAbsentPutWith(int key, ShortFunction<? super P> function, P parameter)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPutWith(key, function, parameter);
        }
    }

    @Override
    public short updateValue(int key, short initialValueIfAbsent, ShortToShortFunction function)
    {
        synchronized (this.lock)
        {
            return this.map.updateValue(key, initialValueIfAbsent, function);
        }
    }

    @Override
    public short get(int key)
    {
        synchronized (this.lock)
        {
            return this.map.get(key);
        }
    }

    @Override
    public short getIfAbsent(int key, short ifAbsent)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsent(key, ifAbsent);
        }
    }

    @Override
    public short getOrThrow(int key)
    {
        synchronized (this.lock)
        {
            return this.map.getOrThrow(key);
        }
    }

    @Override
    public boolean containsKey(int key)
    {
        synchronized (this.lock)
        {
            return this.map.containsKey(key);
        }
    }

    @Override
    public boolean containsValue(short value)
    {
        synchronized (this.lock)
        {
            return this.map.containsValue(value);
        }
    }

    @Override
    public void forEachValue(ShortProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEachValue(procedure);
        }
    }

    @Override
    public void forEachKey(IntProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEachKey(procedure);
        }
    }

    @Override
    public void forEachKeyValue(IntShortProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEachKeyValue(procedure);
        }
    }

    @Override
    public LazyIntIterable keysView()
    {
        synchronized (this.lock)
        {
            return this.map.keysView();
        }
    }

    @Override
    public RichIterable<IntShortPair> keyValuesView()
    {
        synchronized (this.lock)
        {
            return SynchronizedRichIterable.of(this.map.keyValuesView(), this.lock).asLazy();
        }
    }

    @Override
    public MutableShortIntMap flipUniqueValues()
    {
        synchronized (this.lock)
        {
            return this.map.flipUniqueValues();
        }
    }

    @Override
    public MutableIntShortMap select(IntShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.select(predicate);
        }
    }

    @Override
    public MutableIntShortMap reject(IntShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.reject(predicate);
        }
    }

    /**
     * This must be manually synchronized by the developer.
     */
    @Override
    public MutableShortIterator shortIterator()
    {
        return this.map.shortIterator();
    }

    @Override
    public void forEach(ShortProcedure procedure)
    {
        this.each(procedure);
    }

    /**
     * @since 7.0.
     */
    @Override
    public void each(ShortProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEach(procedure);
        }
    }

    @Override
    public int count(ShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.count(predicate);
        }
    }

    @Override
    public boolean anySatisfy(ShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.anySatisfy(predicate);
        }
    }

    @Override
    public boolean allSatisfy(ShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.allSatisfy(predicate);
        }
    }

    @Override
    public boolean noneSatisfy(ShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.noneSatisfy(predicate);
        }
    }

    @Override
    public MutableShortBag select(ShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.select(predicate);
        }
    }

    @Override
    public MutableShortBag reject(ShortPredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.reject(predicate);
        }
    }

    @Override
    public <V> MutableBag<V> collect(ShortToObjectFunction<? extends V> function)
    {
        synchronized (this.lock)
        {
            return this.map.collect(function);
        }
    }

    @Override
    public short detectIfNone(ShortPredicate predicate, short ifNone)
    {
        synchronized (this.lock)
        {
            return this.map.detectIfNone(predicate, ifNone);
        }
    }

    @Override
    public long sum()
    {
        synchronized (this.lock)
        {
            return this.map.sum();
        }
    }

    @Override
    public short max()
    {
        synchronized (this.lock)
        {
            return this.map.max();
        }
    }

    @Override
    public short maxIfEmpty(short defaultValue)
    {
        synchronized (this.lock)
        {
            return this.map.maxIfEmpty(defaultValue);
        }
    }

    @Override
    public short min()
    {
        synchronized (this.lock)
        {
            return this.map.min();
        }
    }

    @Override
    public short minIfEmpty(short defaultValue)
    {
        synchronized (this.lock)
        {
            return this.map.minIfEmpty(defaultValue);
        }
    }

    @Override
    public double average()
    {
        synchronized (this.lock)
        {
            return this.map.average();
        }
    }

    @Override
    public double median()
    {
        synchronized (this.lock)
        {
            return this.map.median();
        }
    }

    @Override
    public short addToValue(int key, short toBeAdded)
    {
        synchronized (this.lock)
        {
            return this.map.addToValue(key, toBeAdded);
        }
    }

    @Override
    public short[] toSortedArray()
    {
        synchronized (this.lock)
        {
            return this.map.toSortedArray();
        }
    }

    @Override
    public MutableShortList toSortedList()
    {
        synchronized (this.lock)
        {
            return this.map.toSortedList();
        }
    }

    @Override
    public short[] toArray()
    {
        synchronized (this.lock)
        {
            return this.map.toArray();
        }
    }

    @Override
    public boolean contains(short value)
    {
        synchronized (this.lock)
        {
            return this.map.contains(value);
        }
    }

    @Override
    public boolean containsAll(short... source)
    {
        synchronized (this.lock)
        {
            return this.map.containsAll(source);
        }
    }

    @Override
    public boolean containsAll(ShortIterable source)
    {
        synchronized (this.lock)
        {
            return this.map.containsAll(source);
        }
    }

    @Override
    public MutableShortList toList()
    {
        synchronized (this.lock)
        {
            return this.map.toList();
        }
    }

    @Override
    public MutableShortSet toSet()
    {
        synchronized (this.lock)
        {
            return this.map.toSet();
        }
    }

    @Override
    public MutableShortBag toBag()
    {
        synchronized (this.lock)
        {
            return this.map.toBag();
        }
    }

    @Override
    public LazyShortIterable asLazy()
    {
        synchronized (this.lock)
        {
            return this.map.asLazy();
        }
    }

    @Override
    public MutableIntShortMap withKeyValue(int key, short value)
    {
        synchronized (this.lock)
        {
            this.map.withKeyValue(key, value);
        }
        return this;
    }

    @Override
    public MutableIntShortMap withoutKey(int key)
    {
        synchronized (this.lock)
        {
            this.map.withoutKey(key);
        }
        return this;
    }

    @Override
    public MutableIntShortMap withoutAllKeys(IntIterable keys)
    {
        synchronized (this.lock)
        {
            this.map.withoutAllKeys(keys);
        }
        return this;
    }

    @Override
    public MutableIntShortMap asUnmodifiable()
    {
        synchronized (this.lock)
        {
            return new UnmodifiableIntShortMap(this);
        }
    }

    @Override
    public MutableIntShortMap asSynchronized()
    {
        return this;
    }

    @Override
    public ImmutableIntShortMap toImmutable()
    {
        synchronized (this.lock)
        {
            return IntShortMaps.immutable.withAll(this);
        }
    }

    @Override
    public int size()
    {
        synchronized (this.lock)
        {
            return this.map.size();
        }
    }

    @Override
    public boolean isEmpty()
    {
        synchronized (this.lock)
        {
            return this.map.isEmpty();
        }
    }

    @Override
    public boolean notEmpty()
    {
        synchronized (this.lock)
        {
            return this.map.notEmpty();
        }
    }

    @Override
    public MutableIntSet keySet()
    {
        synchronized (this.lock)
        {
            return SynchronizedIntSet.of(this.map.keySet(), this.lock);
        }
    }

    @Override
    public MutableShortCollection values()
    {
        synchronized (this.lock)
        {
            return SynchronizedShortCollection.of(this.map.values(), this.lock);
        }
    }

    @Override
    public boolean equals(Object otherMap)
    {
        synchronized (this.lock)
        {
            return this.map.equals(otherMap);
        }
    }

    @Override
    public int hashCode()
    {
        synchronized (this.lock)
        {
            return this.map.hashCode();
        }
    }

    @Override
    public String toString()
    {
        synchronized (this.lock)
        {
            return this.map.toString();
        }
    }

    @Override
    public String makeString()
    {
        synchronized (this.lock)
        {
            return this.map.makeString();
        }
    }

    @Override
    public String makeString(String separator)
    {
        synchronized (this.lock)
        {
            return this.map.makeString(separator);
        }
    }

    @Override
    public String makeString(String start, String separator, String end)
    {
        synchronized (this.lock)
        {
            return this.map.makeString(start, separator, end);
        }
    }

    @Override
    public void appendString(Appendable appendable)
    {
        synchronized (this.lock)
        {
            this.map.appendString(appendable);
        }
    }

    @Override
    public void appendString(Appendable appendable, String separator)
    {
        synchronized (this.lock)
        {
            this.map.appendString(appendable, separator);
        }
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        synchronized (this.lock)
        {
            this.map.appendString(appendable, start, separator, end);
        }
    }

    @Override
    public <T> T injectInto(T injectedValue, ObjectShortToObjectFunction<? super T, ? extends T> function)
    {
        synchronized (this.lock)
        {
            return this.map.injectInto(injectedValue, function);
        }
    }

    @Override
    public RichIterable<ShortIterable> chunk(int size)
    {
        synchronized (this.lock)
        {
            return this.map.chunk(size);
        }
    }
}
