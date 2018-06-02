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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.primitive.ImmutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.block.function.primitive.LongToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectLongToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongPredicate;
import org.eclipse.collections.api.block.predicate.primitive.ShortLongPredicate;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortLongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.map.primitive.ShortLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.ShortLongPair;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableLongCollection;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.iterator.UnmodifiableLongIterator;
import org.eclipse.collections.impl.lazy.primitive.LazyLongIterableAdapter;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortLongHashMap;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.UnmodifiableShortSet;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;

/**
 * ImmutableShortLongSingletonMap is an optimization for {@link ImmutableShortLongMap} of size 1.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMap.stg.
 *
 * @since 4.0.
 */
final class ImmutableShortLongSingletonMap implements ImmutableShortLongMap, Serializable
{
    private static final long serialVersionUID = 1L;
    private static final long EMPTY_VALUE = 0L;
    private final short key1;
    private final long value1;

    ImmutableShortLongSingletonMap(short key1, long value1)
    {
        this.key1 = key1;
        this.value1 = value1;
    }

    @Override
    public long get(short key)
    {
        return this.getIfAbsent(key, EMPTY_VALUE);
    }

    @Override
    public long getIfAbsent(short key, long ifAbsent)
    {
        return this.key1 == key ? this.value1 : ifAbsent;
    }

    @Override
    public long getOrThrow(short key)
    {
        if (this.key1 == key)
        {
            return this.value1;
        }
        throw new IllegalStateException("Key " + key + " not present.");
    }

    @Override
    public boolean containsKey(short key)
    {
        return this.key1 == key;
    }

    @Override
    public boolean containsValue(long value)
    {
        return this.value1 == value;
    }

    @Override
    public void forEachValue(LongProcedure procedure)
    {
        procedure.value(this.value1);
    }

    @Override
    public void forEachKey(ShortProcedure procedure)
    {
        procedure.value(this.key1);
    }

    @Override
    public void forEachKeyValue(ShortLongProcedure procedure)
    {
        procedure.value(this.key1, this.value1);
    }

    @Override
    public LazyShortIterable keysView()
    {
        return ShortLists.immutable.of(this.key1).asLazy();
    }

    @Override
    public RichIterable<ShortLongPair> keyValuesView()
    {
        return Lists.immutable.of(PrimitiveTuples.pair(this.key1, this.value1)).asLazy();
    }

    @Override
    public ImmutableLongShortMap flipUniqueValues()
    {
        return LongShortMaps.immutable.with(this.value1, this.key1);
    }

    @Override
    public ImmutableShortLongMap select(ShortLongPredicate predicate)
    {
        return predicate.accept(this.key1, this.value1) ? ShortLongHashMap.newWithKeysValues(this.key1, this.value1).toImmutable()
                : new ShortLongHashMap().toImmutable();
    }

    @Override
    public ImmutableShortLongMap reject(ShortLongPredicate predicate)
    {
        return predicate.accept(this.key1, this.value1) ? new ShortLongHashMap().toImmutable()
                : ShortLongHashMap.newWithKeysValues(this.key1, this.value1).toImmutable();
    }

    @Override
    public <T> T injectInto(T injectedValue, ObjectLongToObjectFunction<? super T, ? extends T> function)
    {
        return function.valueOf(injectedValue, this.value1);
    }

    @Override
    public RichIterable<LongIterable> chunk(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size for groups must be positive but was: " + size);
        }
        return Lists.mutable.with(LongBags.immutable.with(this.value1));
    }

    @Override
    public ImmutableShortLongMap toImmutable()
    {
        return this;
    }

    @Override
    public LongIterator longIterator()
    {
        return new UnmodifiableLongIterator(ShortLongHashMap.newWithKeysValues(this.key1, this.value1).longIterator());
    }

    @Override
    public void forEach(LongProcedure procedure)
    {
        this.each(procedure);
    }

    /**
     * @since 7.0.
     */
    @Override
    public void each(LongProcedure procedure)
    {
        procedure.value(this.value1);
    }

    @Override
    public int count(LongPredicate predicate)
    {
        return predicate.accept(this.value1) ? 1 : 0;
    }

    @Override
    public long sum()
    {
        return this.value1;
    }

    @Override
    public long min()
    {
        return this.value1;
    }

    @Override
    public long max()
    {
        return this.value1;
    }

    @Override
    public long maxIfEmpty(long defaultValue)
    {
        return this.value1;
    }

    @Override
    public long minIfEmpty(long defaultValue)
    {
        return this.value1;
    }

    @Override
    public double average()
    {
        return this.value1;
    }

    @Override
    public double median()
    {
        return this.value1;
    }

    @Override
    public long[] toSortedArray()
    {
        return new long[]{this.value1};
    }

    @Override
    public MutableLongList toSortedList()
    {
        return LongArrayList.newListWith(this.value1);
    }

    @Override
    public boolean anySatisfy(LongPredicate predicate)
    {
        return predicate.accept(this.value1);
    }

    @Override
    public boolean allSatisfy(LongPredicate predicate)
    {
        return predicate.accept(this.value1);
    }

    @Override
    public boolean noneSatisfy(LongPredicate predicate)
    {
        return !predicate.accept(this.value1);
    }

    @Override
    public ImmutableLongBag select(LongPredicate predicate)
    {
        return predicate.accept(this.value1) ? LongHashBag.newBagWith(this.value1).toImmutable() : LongBags.immutable.empty();
    }

    @Override
    public ImmutableLongBag reject(LongPredicate predicate)
    {
        return predicate.accept(this.value1) ? LongBags.immutable.empty() : LongHashBag.newBagWith(this.value1).toImmutable();
    }

    @Override
    public <V> ImmutableBag<V> collect(LongToObjectFunction<? extends V> function)
    {
        return Bags.immutable.of(function.valueOf(this.value1));
    }

    @Override
    public long detectIfNone(LongPredicate predicate, long ifNone)
    {
        return predicate.accept(this.value1) ? this.value1 : ifNone;
    }

    @Override
    public long[] toArray()
    {
        return new long[]{this.value1};
    }

    @Override
    public boolean contains(long value)
    {
        return this.value1 == value;
    }

    @Override
    public boolean containsAll(long... source)
    {
        for (long value : source)
        {
            if (this.value1 != value)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(LongIterable source)
    {
        for (LongIterator iterator = source.longIterator(); iterator.hasNext(); )
        {
            if (this.value1 != iterator.next())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public MutableLongList toList()
    {
        return LongArrayList.newListWith(this.value1);
    }

    @Override
    public MutableLongSet toSet()
    {
        return LongHashSet.newSetWith(this.value1);
    }

    @Override
    public MutableLongBag toBag()
    {
        return LongHashBag.newBagWith(this.value1);
    }

    @Override
    public LazyLongIterable asLazy()
    {
        return new LazyLongIterableAdapter(this);
    }

    @Override
    public ImmutableShortLongMap newWithKeyValue(short key, long value)
    {
        return ShortLongMaps.immutable.withAll(ShortLongHashMap.newWithKeysValues(this.key1, this.value1, key, value));
    }

    @Override
    public ImmutableShortLongMap newWithoutKey(short key)
    {
        return this.key1 == key ? ShortLongMaps.immutable.with() : this;
    }

    @Override
    public ImmutableShortLongMap newWithoutAllKeys(ShortIterable keys)
    {
        return keys.contains(this.key1) ? ShortLongMaps.immutable.with() : this;
    }

    @Override
    public int size()
    {
        return 1;
    }

    @Override
    public boolean isEmpty()
    {
        return false;
    }

    @Override
    public boolean notEmpty()
    {
        return true;
    }

    @Override
    public MutableShortSet keySet()
    {
        return UnmodifiableShortSet.of(ShortHashSet.newSetWith(this.key1));
    }

    @Override
    public MutableLongCollection values()
    {
        return UnmodifiableLongCollection.of(LongArrayList.newListWith(this.value1));
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof ShortLongMap))
        {
            return false;
        }
        ShortLongMap map = (ShortLongMap) obj;
        if (map.size() != 1)
        {
            return false;
        }
        return map.containsKey(this.key1) && this.value1 == map.getOrThrow(this.key1);
    }

    @Override
    public int hashCode()
    {
        return (int) this.key1 ^ (int) (this.value1 ^ this.value1 >>> 32);
    }

    @Override
    public String toString()
    {
        return "{" + this.key1 + "=" + this.value1 + "}";
    }

    @Override
    public String makeString()
    {
        return this.makeString(", ");
    }

    @Override
    public String makeString(String separator)
    {
        return this.makeString("", separator, "");
    }

    @Override
    public String makeString(String start, String separator, String end)
    {
        Appendable stringBuilder = new StringBuilder();
        this.appendString(stringBuilder, start, separator, end);
        return stringBuilder.toString();
    }

    @Override
    public void appendString(Appendable appendable)
    {
        this.appendString(appendable, ", ");
    }

    @Override
    public void appendString(Appendable appendable, String separator)
    {
        this.appendString(appendable, "", separator, "");
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        try
        {
            appendable.append(start);
            appendable.append(String.valueOf(this.value1));
            appendable.append(end);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}
