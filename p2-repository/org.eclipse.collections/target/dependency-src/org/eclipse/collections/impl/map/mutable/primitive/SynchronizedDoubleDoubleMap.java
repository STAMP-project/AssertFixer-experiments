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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectDoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.predicate.primitive.DoubleDoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.DoubleDoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleDoubleMap;
import org.eclipse.collections.api.map.primitive.DoubleDoubleMap;
import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.impl.SynchronizedRichIterable;
import org.eclipse.collections.impl.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.set.mutable.primitive.SynchronizedDoubleSet;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedDoubleCollection;

/**
 * A synchronized view of a {@link MutableDoubleDoubleMap}. It is imperative that the user manually synchronize on the collection when iterating over it using the
 * {@link MutableDoubleIterator} as per {@link Collections#synchronizedCollection(Collection)}.
 * <p>
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMap.stg.
 *
 * @see MutableDoubleDoubleMap#asSynchronized()
 * @see MutableMap#asSynchronized()
 * @since 3.1.
 */
public class SynchronizedDoubleDoubleMap
        implements MutableDoubleDoubleMap, Serializable
{
    private static final long serialVersionUID = 1L;
    private final Object lock;
    private final MutableDoubleDoubleMap map;

    public SynchronizedDoubleDoubleMap(MutableDoubleDoubleMap map)
    {
        this(map, null);
    }

    public SynchronizedDoubleDoubleMap(MutableDoubleDoubleMap map, Object newLock)
    {
        if (map == null)
        {
            throw new IllegalArgumentException("Cannot create a SynchronizedDoubleDoubleMap on a null map");
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
    public void put(double key, double value)
    {
        synchronized (this.lock)
        {
            this.map.put(key, value);
        }
    }

    @Override
    public void putPair(DoubleDoublePair keyValuePair)
    {
        synchronized (this.lock)
        {
            this.map.put(keyValuePair.getOne(), keyValuePair.getTwo());
        }
    }

    @Override
    public void putAll(DoubleDoubleMap map)
    {
        synchronized (this.lock)
        {
            this.map.putAll(map);
        }
    }

    @Override
    public void removeKey(double key)
    {
        synchronized (this.lock)
        {
            this.map.removeKey(key);
        }
    }

    @Override
    public void remove(double key)
    {
        synchronized (this.lock)
        {
            this.map.remove(key);
        }
    }

    @Override
    public double removeKeyIfAbsent(double key, double value)
    {
        synchronized (this.lock)
        {
            return this.map.removeKeyIfAbsent(key, value);
        }
    }

    @Override
    public double getIfAbsentPut(double key, double value)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPut(key, value);
        }
    }

    @Override
    public double getIfAbsentPut(double key, DoubleFunction0 function)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPut(key, function);
        }
    }

    @Override
    public double getIfAbsentPutWithKey(double key, DoubleToDoubleFunction function)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPutWithKey(key, function);
        }
    }

    @Override
    public <P> double getIfAbsentPutWith(double key, DoubleFunction<? super P> function, P parameter)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsentPutWith(key, function, parameter);
        }
    }

    @Override
    public double updateValue(double key, double initialValueIfAbsent, DoubleToDoubleFunction function)
    {
        synchronized (this.lock)
        {
            return this.map.updateValue(key, initialValueIfAbsent, function);
        }
    }

    @Override
    public double get(double key)
    {
        synchronized (this.lock)
        {
            return this.map.get(key);
        }
    }

    @Override
    public double getIfAbsent(double key, double ifAbsent)
    {
        synchronized (this.lock)
        {
            return this.map.getIfAbsent(key, ifAbsent);
        }
    }

    @Override
    public double getOrThrow(double key)
    {
        synchronized (this.lock)
        {
            return this.map.getOrThrow(key);
        }
    }

    @Override
    public boolean containsKey(double key)
    {
        synchronized (this.lock)
        {
            return this.map.containsKey(key);
        }
    }

    @Override
    public boolean containsValue(double value)
    {
        synchronized (this.lock)
        {
            return this.map.containsValue(value);
        }
    }

    @Override
    public void forEachValue(DoubleProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEachValue(procedure);
        }
    }

    @Override
    public void forEachKey(DoubleProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEachKey(procedure);
        }
    }

    @Override
    public void forEachKeyValue(DoubleDoubleProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEachKeyValue(procedure);
        }
    }

    @Override
    public LazyDoubleIterable keysView()
    {
        synchronized (this.lock)
        {
            return this.map.keysView();
        }
    }

    @Override
    public RichIterable<DoubleDoublePair> keyValuesView()
    {
        synchronized (this.lock)
        {
            return SynchronizedRichIterable.of(this.map.keyValuesView(), this.lock).asLazy();
        }
    }

    @Override
    public MutableDoubleDoubleMap flipUniqueValues()
    {
        synchronized (this.lock)
        {
            return this.map.flipUniqueValues();
        }
    }

    @Override
    public MutableDoubleDoubleMap select(DoubleDoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.select(predicate);
        }
    }

    @Override
    public MutableDoubleDoubleMap reject(DoubleDoublePredicate predicate)
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
    public MutableDoubleIterator doubleIterator()
    {
        return this.map.doubleIterator();
    }

    @Override
    public void forEach(DoubleProcedure procedure)
    {
        this.each(procedure);
    }

    /**
     * @since 7.0.
     */
    @Override
    public void each(DoubleProcedure procedure)
    {
        synchronized (this.lock)
        {
            this.map.forEach(procedure);
        }
    }

    @Override
    public int count(DoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.count(predicate);
        }
    }

    @Override
    public boolean anySatisfy(DoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.anySatisfy(predicate);
        }
    }

    @Override
    public boolean allSatisfy(DoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.allSatisfy(predicate);
        }
    }

    @Override
    public boolean noneSatisfy(DoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.noneSatisfy(predicate);
        }
    }

    @Override
    public MutableDoubleBag select(DoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.select(predicate);
        }
    }

    @Override
    public MutableDoubleBag reject(DoublePredicate predicate)
    {
        synchronized (this.lock)
        {
            return this.map.reject(predicate);
        }
    }

    @Override
    public <V> MutableBag<V> collect(DoubleToObjectFunction<? extends V> function)
    {
        synchronized (this.lock)
        {
            return this.map.collect(function);
        }
    }

    @Override
    public double detectIfNone(DoublePredicate predicate, double ifNone)
    {
        synchronized (this.lock)
        {
            return this.map.detectIfNone(predicate, ifNone);
        }
    }

    @Override
    public double sum()
    {
        synchronized (this.lock)
        {
            return this.map.sum();
        }
    }

    @Override
    public double max()
    {
        synchronized (this.lock)
        {
            return this.map.max();
        }
    }

    @Override
    public double maxIfEmpty(double defaultValue)
    {
        synchronized (this.lock)
        {
            return this.map.maxIfEmpty(defaultValue);
        }
    }

    @Override
    public double min()
    {
        synchronized (this.lock)
        {
            return this.map.min();
        }
    }

    @Override
    public double minIfEmpty(double defaultValue)
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
    public double addToValue(double key, double toBeAdded)
    {
        synchronized (this.lock)
        {
            return this.map.addToValue(key, toBeAdded);
        }
    }

    @Override
    public double[] toSortedArray()
    {
        synchronized (this.lock)
        {
            return this.map.toSortedArray();
        }
    }

    @Override
    public MutableDoubleList toSortedList()
    {
        synchronized (this.lock)
        {
            return this.map.toSortedList();
        }
    }

    @Override
    public double[] toArray()
    {
        synchronized (this.lock)
        {
            return this.map.toArray();
        }
    }

    @Override
    public boolean contains(double value)
    {
        synchronized (this.lock)
        {
            return this.map.contains(value);
        }
    }

    @Override
    public boolean containsAll(double... source)
    {
        synchronized (this.lock)
        {
            return this.map.containsAll(source);
        }
    }

    @Override
    public boolean containsAll(DoubleIterable source)
    {
        synchronized (this.lock)
        {
            return this.map.containsAll(source);
        }
    }

    @Override
    public MutableDoubleList toList()
    {
        synchronized (this.lock)
        {
            return this.map.toList();
        }
    }

    @Override
    public MutableDoubleSet toSet()
    {
        synchronized (this.lock)
        {
            return this.map.toSet();
        }
    }

    @Override
    public MutableDoubleBag toBag()
    {
        synchronized (this.lock)
        {
            return this.map.toBag();
        }
    }

    @Override
    public LazyDoubleIterable asLazy()
    {
        synchronized (this.lock)
        {
            return this.map.asLazy();
        }
    }

    @Override
    public MutableDoubleDoubleMap withKeyValue(double key, double value)
    {
        synchronized (this.lock)
        {
            this.map.withKeyValue(key, value);
        }
        return this;
    }

    @Override
    public MutableDoubleDoubleMap withoutKey(double key)
    {
        synchronized (this.lock)
        {
            this.map.withoutKey(key);
        }
        return this;
    }

    @Override
    public MutableDoubleDoubleMap withoutAllKeys(DoubleIterable keys)
    {
        synchronized (this.lock)
        {
            this.map.withoutAllKeys(keys);
        }
        return this;
    }

    @Override
    public MutableDoubleDoubleMap asUnmodifiable()
    {
        synchronized (this.lock)
        {
            return new UnmodifiableDoubleDoubleMap(this);
        }
    }

    @Override
    public MutableDoubleDoubleMap asSynchronized()
    {
        return this;
    }

    @Override
    public ImmutableDoubleDoubleMap toImmutable()
    {
        synchronized (this.lock)
        {
            return DoubleDoubleMaps.immutable.withAll(this);
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
    public MutableDoubleSet keySet()
    {
        synchronized (this.lock)
        {
            return SynchronizedDoubleSet.of(this.map.keySet(), this.lock);
        }
    }

    @Override
    public MutableDoubleCollection values()
    {
        synchronized (this.lock)
        {
            return SynchronizedDoubleCollection.of(this.map.values(), this.lock);
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
    public <T> T injectInto(T injectedValue, ObjectDoubleToObjectFunction<? super T, ? extends T> function)
    {
        synchronized (this.lock)
        {
            return this.map.injectInto(injectedValue, function);
        }
    }

    @Override
    public RichIterable<DoubleIterable> chunk(int size)
    {
        synchronized (this.lock)
        {
            return this.map.chunk(size);
        }
    }
}
