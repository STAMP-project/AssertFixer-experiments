/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import java.io.IOException;
import java.io.Serializable;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectDoubleToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatDoublePredicate;
import org.eclipse.collections.api.block.predicate.primitive.DoublePredicate;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatDoubleProcedure;
import org.eclipse.collections.api.block.procedure.primitive.DoubleProcedure;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.list.primitive.MutableDoubleList;
import org.eclipse.collections.api.map.primitive.FloatDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleFloatMap;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.tuple.primitive.FloatDoublePair;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableDoubleCollection;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.iterator.ImmutableEmptyDoubleIterator;
import org.eclipse.collections.impl.lazy.primitive.LazyDoubleIterableAdapter;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.UnmodifiableFloatSet;
import org.eclipse.collections.impl.utility.LazyIterate;
import org.eclipse.collections.impl.utility.primitive.LazyFloatIterate;

/**
 * ImmutableFloatDoubleEmptyMap is an optimization for {@link ImmutableFloatDoubleMap} of size 0.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMap.stg.
 *
 * @since 4.0.
 */
final class ImmutableFloatDoubleEmptyMap implements ImmutableFloatDoubleMap, Serializable
{
    static final ImmutableFloatDoubleMap INSTANCE = new ImmutableFloatDoubleEmptyMap();

    private static final long serialVersionUID = 1L;
    private static final double EMPTY_VALUE = 0.0;

    private Object readResolve()
    {
        return INSTANCE;
    }

    @Override
    public double get(float key)
    {
        return EMPTY_VALUE;
    }

    @Override
    public double getIfAbsent(float key, double ifAbsent)
    {
        return ifAbsent;
    }

    @Override
    public double getOrThrow(float key)
    {
        throw new IllegalStateException("Key " + key + " not present.");
    }

    @Override
    public boolean containsKey(float key)
    {
        return false;
    }

    @Override
    public boolean containsValue(double value)
    {
        return false;
    }

    @Override
    public void forEachValue(DoubleProcedure procedure)
    {
    }

    @Override
    public void forEachKey(FloatProcedure procedure)
    {
    }

    @Override
    public void forEachKeyValue(FloatDoubleProcedure procedure)
    {
    }

    @Override
    public LazyFloatIterable keysView()
    {
        return LazyFloatIterate.empty();
    }

    @Override
    public RichIterable<FloatDoublePair> keyValuesView()
    {
        return LazyIterate.empty();
    }

    @Override
    public ImmutableDoubleFloatMap flipUniqueValues()
    {
        return DoubleFloatMaps.immutable.empty();
    }

    @Override
    public ImmutableFloatDoubleMap select(FloatDoublePredicate predicate)
    {
        return this;
    }

    @Override
    public ImmutableFloatDoubleMap reject(FloatDoublePredicate predicate)
    {
        return this;
    }

    @Override
    public ImmutableFloatDoubleMap toImmutable()
    {
        return this;
    }

    @Override
    public DoubleIterator doubleIterator()
    {
        return ImmutableEmptyDoubleIterator.INSTANCE;
    }

    @Override
    public void forEach(DoubleProcedure procedure)
    {
    }

    /**
     * @since 7.0.
     */
    @Override
    public void each(DoubleProcedure procedure)
    {
    }

    @Override
    public int count(DoublePredicate predicate)
    {
        return 0;
    }

    @Override
    public double sum()
    {
        return 0.0;
    }

    @Override
    public double min()
    {
        throw new NoSuchElementException();
    }

    @Override
    public double max()
    {
        throw new NoSuchElementException();
    }

    @Override
    public double maxIfEmpty(double defaultValue)
    {
        return defaultValue;
    }

    @Override
    public double minIfEmpty(double defaultValue)
    {
        return defaultValue;
    }

    @Override
    public double average()
    {
        throw new ArithmeticException();
    }

    @Override
    public double median()
    {
        throw new ArithmeticException();
    }

    @Override
    public double[] toSortedArray()
    {
        return new double[0];
    }

    @Override
    public MutableDoubleList toSortedList()
    {
        return new DoubleArrayList();
    }

    @Override
    public boolean anySatisfy(DoublePredicate predicate)
    {
        return false;
    }

    @Override
    public boolean allSatisfy(DoublePredicate predicate)
    {
        return true;
    }

    @Override
    public boolean noneSatisfy(DoublePredicate predicate)
    {
        return true;
    }

    @Override
    public ImmutableDoubleBag select(DoublePredicate predicate)
    {
        return DoubleBags.immutable.empty();
    }

    @Override
    public ImmutableDoubleBag reject(DoublePredicate predicate)
    {
        return DoubleBags.immutable.empty();
    }

    @Override
    public <V> ImmutableBag<V> collect(DoubleToObjectFunction<? extends V> function)
    {
        return Bags.immutable.empty();
    }

    @Override
    public double detectIfNone(DoublePredicate predicate, double ifNone)
    {
        return ifNone;
    }

    @Override
    public <T> T injectInto(T injectedValue, ObjectDoubleToObjectFunction<? super T, ? extends T> function)
    {
        return injectedValue;
    }

    @Override
    public RichIterable<DoubleIterable> chunk(int size)
    {
        return Lists.immutable.empty();
    }

    @Override
    public double[] toArray()
    {
        return new double[0];
    }

    @Override
    public boolean contains(double value)
    {
        return false;
    }

    @Override
    public boolean containsAll(double... source)
    {
        return source.length == 0;
    }

    @Override
    public boolean containsAll(DoubleIterable source)
    {
        return source.isEmpty();
    }

    @Override
    public MutableDoubleList toList()
    {
        return new DoubleArrayList();
    }

    @Override
    public MutableDoubleSet toSet()
    {
        return new DoubleHashSet();
    }

    @Override
    public MutableDoubleBag toBag()
    {
        return new DoubleHashBag();
    }

    @Override
    public LazyDoubleIterable asLazy()
    {
        return new LazyDoubleIterableAdapter(this);
    }

    @Override
    public ImmutableFloatDoubleMap newWithKeyValue(float key, double value)
    {
        return new ImmutableFloatDoubleSingletonMap(key, value);
    }

    @Override
    public ImmutableFloatDoubleMap newWithoutKey(float key)
    {
        return this;
    }

    @Override
    public ImmutableFloatDoubleMap newWithoutAllKeys(FloatIterable keys)
    {
        return this;
    }

    @Override
    public int size()
    {
        return 0;
    }

    @Override
    public boolean isEmpty()
    {
        return true;
    }

    @Override
    public boolean notEmpty()
    {
        return false;
    }

    @Override
    public MutableFloatSet keySet()
    {
        return UnmodifiableFloatSet.of(new FloatHashSet());
    }

    @Override
    public MutableDoubleCollection values()
    {
        return UnmodifiableDoubleCollection.of(new DoubleArrayList());
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof FloatDoubleMap))
        {
            return false;
        }
        FloatDoubleMap map = (FloatDoubleMap) obj;
        return map.isEmpty();
    }

    @Override
    public int hashCode()
    {
        return 0;
    }

    @Override
    public String toString()
    {
        return "{}";
    }

    @Override
    public String makeString()
    {
        return "";
    }

    @Override
    public String makeString(String separator)
    {
        return "";
    }

    @Override
    public String makeString(String start, String separator, String end)
    {
        return start + end;
    }

    @Override
    public void appendString(Appendable appendable)
    {
    }

    @Override
    public void appendString(Appendable appendable, String separator)
    {
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        try
        {
            appendable.append(start);
            appendable.append(end);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
