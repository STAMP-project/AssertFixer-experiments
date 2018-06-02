/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.block.HashingStrategy;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectIntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.predicate.primitive.ObjectIntPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedIntCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableIntCollection;
import org.eclipse.collections.impl.lazy.AbstractLazyIterable;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.ObjectIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.lazy.primitive.LazyIntIterableAdapter;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
/**
 * This file was automatically generated from template file objectPrimitiveHashMapWithHashingStrategy.stg.
 *
 * @since 7.0.
 */
public class ObjectIntHashMapWithHashingStrategy<K> implements MutableObjectIntMap<K>, Externalizable
{
    public static final int EMPTY_VALUE = 0;

    private static final long serialVersionUID = 1L;
    private static final int OCCUPIED_DATA_RATIO = 2;
    private static final int OCCUPIED_SENTINEL_RATIO = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    private static final Object NULL_KEY = new Object()
    {
        @Override
        public boolean equals(Object obj)
        {
            throw new RuntimeException("Possible corruption through unsynchronized concurrent modification.");
        }

        @Override
        public int hashCode()
        {
            throw new RuntimeException("Possible corruption through unsynchronized concurrent modification.");
        }

        @Override
        public String toString()
        {
            return "ObjectIntHashMapWithHashingStrategy.NULL_KEY";
        }
    };

    private static final Object REMOVED_KEY = new Object()
    {
        @Override
        public boolean equals(Object obj)
        {
            throw new RuntimeException("Possible corruption through unsynchronized concurrent modification.");
        }

        @Override
        public int hashCode()
        {
            throw new RuntimeException("Possible corruption through unsynchronized concurrent modification.");
        }

        @Override
        public String toString()
        {
            return "ObjectIntHashMapWithHashingStrategy.REMOVED_KEY";
        }
    };

    private Object[] keys;
    private int[] values;

    private int occupiedWithData;
    private int occupiedWithSentinels;

    private HashingStrategy<? super K> hashingStrategy;

    /**
     * @deprecated Use ObjectIntHashMapWithHashingStrategy(HashingStrategy) instead.
     */
    @Deprecated
    public ObjectIntHashMapWithHashingStrategy()
    {
    }

    public ObjectIntHashMapWithHashingStrategy(HashingStrategy<? super K> hashingStrategy)
    {
        this.hashingStrategy = hashingStrategy;
        this.allocateTable(DEFAULT_INITIAL_CAPACITY << 1);
    }

    public ObjectIntHashMapWithHashingStrategy(HashingStrategy<? super K> hashingStrategy, int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            throw new IllegalArgumentException("initial capacity cannot be less than 0");
        }
        this.hashingStrategy = hashingStrategy;
        int capacity = this.smallestPowerOfTwoGreaterThan(this.fastCeil(initialCapacity * OCCUPIED_DATA_RATIO));
        this.allocateTable(capacity);
    }

    public ObjectIntHashMapWithHashingStrategy(HashingStrategy<? super K> hashingStrategy, ObjectIntMap<? extends K> map)
    {
        this(hashingStrategy, Math.max(map.size(), DEFAULT_INITIAL_CAPACITY));
        this.putAll(map);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newMap(HashingStrategy<? super K> hashingStrategy)
    {
        return new ObjectIntHashMapWithHashingStrategy<>(hashingStrategy);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newMap(HashingStrategy<? super K> hashingStrategy, ObjectIntMap<K> map)
    {
        return new ObjectIntHashMapWithHashingStrategy<>(hashingStrategy, map);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newMap(ObjectIntHashMapWithHashingStrategy<K> map)
    {
        return new ObjectIntHashMapWithHashingStrategy<>(map.hashingStrategy, map);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newWithKeysValues(HashingStrategy<? super K> hashingStrategy, K key1, int value1)
    {
        return new ObjectIntHashMapWithHashingStrategy<K>(hashingStrategy, 1).withKeyValue(key1, value1);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newWithKeysValues(HashingStrategy<? super K> hashingStrategy, K key1, int value1, K key2, int value2)
    {
        return new ObjectIntHashMapWithHashingStrategy<K>(hashingStrategy, 2).withKeysValues(key1, value1, key2, value2);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newWithKeysValues(HashingStrategy<? super K> hashingStrategy, K key1, int value1, K key2, int value2, K key3, int value3)
    {
        return new ObjectIntHashMapWithHashingStrategy<K>(hashingStrategy, 3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    public static <K> ObjectIntHashMapWithHashingStrategy<K> newWithKeysValues(HashingStrategy<? super K> hashingStrategy, K key1, int value1, K key2, int value2, K key3, int value3, K key4, int value4)
    {
        return new ObjectIntHashMapWithHashingStrategy<K>(hashingStrategy, 4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    private int smallestPowerOfTwoGreaterThan(int n)
    {
        return n > 1 ? Integer.highestOneBit(n - 1) << 1 : 1;
    }

    private int fastCeil(float v)
    {
        int possibleResult = (int) v;
        if (v - possibleResult > 0.0F)
        {
            possibleResult++;
        }
        return possibleResult;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof ObjectIntMap))
        {
            return false;
        }

        ObjectIntMap<K> other = (ObjectIntMap<K>) obj;

        if (this.size() != other.size())
        {
            return false;
        }

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && (!other.containsKey(this.toNonSentinel(this.keys[i])) || this.values[i] != other.getOrThrow(this.toNonSentinel(this.keys[i]))))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = 0;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result += this.hashingStrategy.computeHashCode(this.toNonSentinel(this.keys[i])) ^ this.values[i];
            }
        }
        return result;
    }

    @Override
    public String toString()
    {
        StringBuilder appendable = new StringBuilder();

        appendable.append("{");

        boolean first = true;

        for (int i = 0; i < this.keys.length; i++)
        {
            Object key = this.keys[i];
            if (isNonSentinel(key))
            {
                if (!first)
                {
                    appendable.append(", ");
                }
                appendable.append(this.toNonSentinel(key)).append("=").append(this.values[i]);
                first = false;
            }
        }
        appendable.append("}");

        return appendable.toString();
    }

    @Override
    public int size()
    {
        return this.occupiedWithData;
    }

    @Override
    public boolean isEmpty()
    {
        return this.size() == 0;
    }

    @Override
    public boolean notEmpty()
    {
        return this.size() != 0;
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

            boolean first = true;

            for (int i = 0; i < this.keys.length; i++)
            {
                Object key = this.keys[i];
                if (isNonSentinel(key))
                {
                    if (!first)
                    {
                        appendable.append(separator);
                    }
                    appendable.append(String.valueOf(String.valueOf(this.values[i])));
                    first = false;
                }
            }
            appendable.append(end);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public MutableIntIterator intIterator()
    {
        return new InternalIntIterator();
    }

    @Override
    public int[] toArray()
    {
        int[] result = new int[this.size()];
        int index = 0;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result[index] = this.values[i];
                index++;
            }
        }
        return result;
    }

    @Override
    public boolean contains(int value)
    {
        return this.containsValue(value);
    }

    @Override
    public boolean containsAll(int... source)
    {
        for (int item : source)
        {
            if (!this.containsValue(item))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(IntIterable source)
    {
        return this.containsAll(source.toArray());
    }

    @Override
    public void clear()
    {
        this.occupiedWithData = 0;
        this.occupiedWithSentinels = 0;
        Arrays.fill(this.keys, null);
        Arrays.fill(this.values, EMPTY_VALUE);
    }

    @Override
    public void put(K key, int value)
    {
        int index = this.probe(key);

        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            // key already present in map
            this.values[index] = value;
            return;
        }

        this.addKeyValueAtIndex(key, value, index);
    }

    @Override
    public void putAll(ObjectIntMap<? extends K> map)
    {
        map.forEachKeyValue(this::put);
    }

    @Override
    public void removeKey(K key)
    {
        int index = this.probe(key);
        this.removeKeyAtIndex(key, index);
    }

    public void removeKeyAtIndex(K key, int index)
    {
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            this.keys[index] = REMOVED_KEY;
            this.values[index] = EMPTY_VALUE;
            this.occupiedWithData--;
            this.occupiedWithSentinels++;
        }
    }

    @Override
    public void remove(Object key)
    {
        this.removeKey((K) key);
    }

    @Override
    public int removeKeyIfAbsent(K key, int value)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            this.keys[index] = REMOVED_KEY;
            int oldValue = this.values[index];
            this.values[index] = EMPTY_VALUE;
            this.occupiedWithData--;
            this.occupiedWithSentinels++;

            return oldValue;
        }
        return value;
    }

    @Override
    public int getIfAbsentPut(K key, int value)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            return this.values[index];
        }
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public int getIfAbsentPut(K key, IntFunction0 function)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            return this.values[index];
        }
        int value = function.value();
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public <P> int getIfAbsentPutWith(K key, IntFunction<? super P> function, P parameter)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            return this.values[index];
        }
        int value = function.intValueOf(parameter);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public int getIfAbsentPutWithKey(K key, IntFunction<? super K> function)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            return this.values[index];
        }
        int value = function.intValueOf(key);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public int updateValue(K key, int initialValueIfAbsent, IntToIntFunction function)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            this.values[index] = function.valueOf(this.values[index]);
            return this.values[index];
        }
        int value = function.valueOf(initialValueIfAbsent);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    private void addKeyValueAtIndex(K key, int value, int index)
    {
        if (this.keys[index] == REMOVED_KEY)
        {
            --this.occupiedWithSentinels;
        }
        this.keys[index] = toSentinelIfNull(key);
        this.values[index] = value;
        ++this.occupiedWithData;
        if (this.occupiedWithData + this.occupiedWithSentinels > this.maxOccupiedWithData())
        {
            this.rehashAndGrow();
        }
    }

    @Override
    public int addToValue(K key, int toBeAdded)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            this.values[index] += toBeAdded;
            return this.values[index];
        }
        this.addKeyValueAtIndex(key, toBeAdded, index);
        return toBeAdded;
    }

    @Override
    public ObjectIntHashMapWithHashingStrategy<K> withKeyValue(K key1, int value1)
    {
        this.put(key1, value1);
        return this;
    }

    public ObjectIntHashMapWithHashingStrategy<K> withKeysValues(K key1, int value1, K key2, int value2)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        return this;
    }

    public ObjectIntHashMapWithHashingStrategy<K> withKeysValues(K key1, int value1, K key2, int value2, K key3, int value3)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        this.put(key3, value3);
        return this;
    }

    public ObjectIntHashMapWithHashingStrategy<K> withKeysValues(K key1, int value1, K key2, int value2, K key3, int value3, K key4, int value4)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        this.put(key3, value3);
        this.put(key4, value4);
        return this;
    }

    @Override
    public ObjectIntHashMapWithHashingStrategy<K> withoutKey(K key)
    {
        this.removeKey(key);
        return this;
    }

    @Override
    public ObjectIntHashMapWithHashingStrategy<K> withoutAllKeys(Iterable<? extends K> keys)
    {
        for (K key : keys)
        {
            this.removeKey(key);
        }
        return this;
    }

    @Override
    public MutableObjectIntMap<K> asUnmodifiable()
    {
        return new UnmodifiableObjectIntMap<>(this);
    }

    @Override
    public MutableObjectIntMap<K> asSynchronized()
    {
        return new SynchronizedObjectIntMap<>(this);
    }

    @Override
    public ImmutableObjectIntMap<K> toImmutable()
    {
        return ObjectIntMaps.immutable.withAll(this);
    }

    @Override
    public int get(Object key)
    {
        return this.getIfAbsent(key, EMPTY_VALUE);
    }

    @Override
    public int getOrThrow(Object key)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]))
        {
            return this.values[index];
        }
        throw new IllegalStateException("Key " + key + " not present.");
    }

    @Override
    public int getIfAbsent(Object key, int ifAbsent)
    {
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key))
        {
            return this.values[index];
        }
        return ifAbsent;
    }

    @Override
    public boolean containsKey(Object key)
    {
        int index = this.probe(key);
        return isNonSentinel(this.keys[index]) && this.nullSafeEquals(this.toNonSentinel(this.keys[index]), key);
    }

    @Override
    public boolean containsValue(int value)
    {
        for (int i = 0; i < this.values.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && this.values[i] == value)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void forEach(IntProcedure procedure)
    {
        this.each(procedure);
    }

    @Override
    public void each(IntProcedure procedure)
    {
        this.forEachValue(procedure);
    }

    @Override
    public void forEachValue(IntProcedure procedure)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                procedure.value(this.values[i]);
            }
        }
    }

    @Override
    public void forEachKey(Procedure<? super K> procedure)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                procedure.value(this.toNonSentinel(this.keys[i]));
            }
        }
    }

    @Override
    public void forEachKeyValue(ObjectIntProcedure<? super K> procedure)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                procedure.value(this.toNonSentinel(this.keys[i]), this.values[i]);
            }
        }
    }

    @Override
    public ObjectIntHashMapWithHashingStrategy<K> select(ObjectIntPredicate<? super K> predicate)
    {
        ObjectIntHashMapWithHashingStrategy<K> result = ObjectIntHashMapWithHashingStrategy.newMap(this.hashingStrategy);

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.toNonSentinel(this.keys[i]), this.values[i]))
            {
                result.put(this.toNonSentinel(this.keys[i]), this.values[i]);
            }
        }
        return result;
    }

    @Override
    public ObjectIntHashMapWithHashingStrategy<K> reject(ObjectIntPredicate<? super K> predicate)
    {
        ObjectIntHashMapWithHashingStrategy<K> result = ObjectIntHashMapWithHashingStrategy.newMap(this.hashingStrategy);

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && !predicate.accept(this.toNonSentinel(this.keys[i]), this.values[i]))
            {
                result.put(this.toNonSentinel(this.keys[i]), this.values[i]);
            }
        }
        return result;
    }

    @Override
    public MutableIntCollection select(IntPredicate predicate)
    {
        IntArrayList result = new IntArrayList();

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.values[i]))
            {
                result.add(this.values[i]);
            }
        }
        return result;
    }

    @Override
    public MutableIntCollection reject(IntPredicate predicate)
    {
        IntArrayList result = new IntArrayList();

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && !predicate.accept(this.values[i]))
            {
                result.add(this.values[i]);
            }
        }
        return result;
    }

    @Override
    public int detectIfNone(IntPredicate predicate, int ifNone)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.values[i]))
            {
                return this.values[i];
            }
        }
        return ifNone;
    }

    @Override
    public <V> MutableCollection<V> collect(IntToObjectFunction<? extends V> function)
    {
        MutableList<V> result = FastList.newList(this.size());
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result.add(function.valueOf(this.values[i]));
            }
        }
        return result;
    }

    @Override
    public int count(IntPredicate predicate)
    {
        int count = 0;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.values[i]))
            {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean anySatisfy(IntPredicate predicate)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.values[i]))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean allSatisfy(IntPredicate predicate)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && !predicate.accept(this.values[i]))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean noneSatisfy(IntPredicate predicate)
    {
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.values[i]))
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public <V> V injectInto(V injectedValue, ObjectIntToObjectFunction<? super V, ? extends V> function)
    {
        V result = injectedValue;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result = function.valueOf(result, this.values[i]);
            }
        }

        return result;
    }

    @Override
    public RichIterable<IntIterable> chunk(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size for groups must be positive but was: " + size);
        }
        MutableList<IntIterable> result = Lists.mutable.empty();
        if (this.notEmpty())
        {
            IntIterator iterator = this.intIterator();
            while (iterator.hasNext())
            {
                MutableIntBag batch = IntBags.mutable.empty();
                for (int i = 0; i < size && iterator.hasNext(); i++)
                {
                    batch.add(iterator.next());
                }
                result.add(batch);
            }
        }
        return result;
    }

    @Override
    public long sum()
    {
        long result = 0L;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result += this.values[i];
            }
        }
        return result;
    }

    @Override
    public int max()
    {
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }
        int max = 0;
        boolean isMaxSet = false;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && (!isMaxSet || max < this.values[i]))
            {
                max = this.values[i];
                isMaxSet = true;
            }
        }
        return max;
    }

    @Override
    public int min()
    {
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }
        int min = 0;
        boolean isMinSet = false;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && (!isMinSet || this.values[i] < min))
            {
                min = this.values[i];
                isMinSet = true;
            }
        }
        return min;
    }

    @Override
    public int maxIfEmpty(int defaultValue)
    {
        if (this.isEmpty())
        {
            return defaultValue;
        }
        int max = 0;
        boolean isMaxSet = false;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && (!isMaxSet || max < this.values[i]))
            {
                max = this.values[i];
                isMaxSet = true;
            }
        }
        return max;
    }

    @Override
    public int minIfEmpty(int defaultValue)
    {
        if (this.isEmpty())
        {
            return defaultValue;
        }
        int min = 0;
        boolean isMinSet = false;

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && (!isMinSet || this.values[i] < min))
            {
                min = this.values[i];
                isMinSet = true;
            }
        }
        return min;
    }

    @Override
    public double average()
    {
        if (this.isEmpty())
        {
            throw new ArithmeticException();
        }
        return (double) this.sum() / (double) this.size();
    }

    @Override
    public double median()
    {
        if (this.isEmpty())
        {
            throw new ArithmeticException();
        }
        int[] sortedArray = this.toSortedArray();
        int middleIndex = sortedArray.length >> 1;
        if (sortedArray.length > 1 && (sortedArray.length & 1) == 0)
        {
            int first = sortedArray[middleIndex];
            int second = sortedArray[middleIndex - 1];
            return ((double) first + (double) second) / 2.0;
        }
        return (double) sortedArray[middleIndex];
    }

    @Override
    public MutableIntList toList()
    {
        MutableIntList result = new IntArrayList(this.size());

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result.add(this.values[i]);
            }
        }
        return result;
    }

    @Override
    public MutableIntSet toSet()
    {
        MutableIntSet result = new IntHashSet(this.size());

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result.add(this.values[i]);
            }
        }
        return result;
    }

    @Override
    public MutableIntBag toBag()
    {
        MutableIntBag result = new IntHashBag(this.size());

        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result.add(this.values[i]);
            }
        }
        return result;
    }

    @Override
    public LazyIntIterable asLazy()
    {
        return new LazyIntIterableAdapter(this);
    }

    @Override
    public int[] toSortedArray()
    {
        int[] array = this.toArray();
        Arrays.sort(array);
        return array;
    }

    @Override
    public MutableIntList toSortedList()
    {
        return this.toList().sortThis();
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeObject(this.hashingStrategy);
        out.writeInt(this.size());
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                out.writeObject(this.toNonSentinel(this.keys[i]));
                out.writeInt(this.values[i]);
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        this.hashingStrategy = (HashingStrategy<? super K>) in.readObject();
        int size = in.readInt();
        int capacity = this.smallestPowerOfTwoGreaterThan(this.fastCeil(size * OCCUPIED_DATA_RATIO));
        this.allocateTable(capacity);

        for (int i = 0; i < size; i++)
        {
            this.put((K) in.readObject(), in.readInt());
        }
    }

    @Override
    public LazyIterable<K> keysView()
    {
        return new KeysView();
    }

    @Override
    public RichIterable<ObjectIntPair<K>> keyValuesView()
    {
        return new KeyValuesView();
    }

    @Override
    public MutableIntObjectMap<K> flipUniqueValues()
    {
        MutableIntObjectMap<K> result = IntObjectMaps.mutable.empty();
        this.forEachKeyValue((key, value)->
        {
            K oldKey = result.put(value, key);
            if (oldKey != null)
            {
                throw new IllegalStateException("Duplicate value: " + value + " found at key: " + oldKey + " and key: " + key);
            }
        });
        return result;
    }

    /**
     * Rehashes every element in the set into a new backing table of the smallest possible size and eliminating removed sentinels.
     */
    public void compact()
    {
        this.rehash(this.smallestPowerOfTwoGreaterThan(this.size()));
    }

    private void rehashAndGrow()
    {
        this.rehash(this.keys.length << 1);
    }

    private void rehash(int newCapacity)
    {
        int oldLength = this.keys.length;
        Object[] old = this.keys;
        int[] oldValues = this.values;
        this.allocateTable(newCapacity);
        this.occupiedWithData = 0;
        this.occupiedWithSentinels = 0;

        for (int i = 0; i < oldLength; i++)
        {
            if (isNonSentinel(old[i]))
            {
                this.put(this.toNonSentinel(old[i]), oldValues[i]);
            }
        }
    }

    // exposed for testing
    int probe(Object element)
    {
        int index = this.spread(element);

        int removedIndex = -1;
        if (isRemovedKey(this.keys[index]))
        {
            removedIndex = index;
        }

        else if (this.keys[index] == null || this.nullSafeEquals(this.toNonSentinel(this.keys[index]), element))
        {
            return index;
        }

        int nextIndex = index;
        int probe = 17;

        // loop until an empty slot is reached
        while (true)
        {
            // Probe algorithm: 17*n*(n+1)/2 where n = no. of collisions
            nextIndex += probe;
            probe += 17;
            nextIndex &= this.keys.length - 1;

            if (isRemovedKey(this.keys[nextIndex]))
            {
                if (removedIndex == -1)
                {
                    removedIndex = nextIndex;
                }
            }
            else if (this.nullSafeEquals(this.toNonSentinel(this.keys[nextIndex]), element))
            {
                return nextIndex;
            }
            else if (this.keys[nextIndex] == null)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
        }
    }

    // exposed for testing
    int spread(Object element)
    {
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        K nonSentinelKey = this.toNonSentinel(element);
        int h = nonSentinelKey == null ? 0 : this.hashingStrategy.computeHashCode(nonSentinelKey);
        h ^= h >>> 20 ^ h >>> 12;
        h ^= h >>> 7 ^ h >>> 4;
        return h & (this.keys.length - 1);
    }

    private boolean nullSafeEquals(K value, Object other)
    {
        if (value == null)
        {
            if (other == null)
            {
                return true;
            }
        }
        else if (value != NULL_KEY && other != null)
        {
            if (this.hashingStrategy.equals(value, this.toNonSentinel(other)))
            {
                return true;
            }
        }
        return false;
    }

    private void allocateTable(int sizeToAllocate)
    {
        this.keys = new Object[sizeToAllocate];
        this.values = new int[sizeToAllocate];
    }

    private static boolean isRemovedKey(Object key)
    {
        return key == REMOVED_KEY;
    }

    private static <K> boolean isNonSentinel(K key)
    {
        return key != null && !isRemovedKey(key);
    }

    private K toNonSentinel(Object key)
    {
        return key == NULL_KEY ? null : (K) key;
    }

    private static Object toSentinelIfNull(Object key)
    {
        return key == null ? NULL_KEY : key;
    }

    private int maxOccupiedWithData()
    {
        int capacity = this.keys.length;
        // need at least one free slot for open addressing
        return Math.min(capacity - 1, capacity / OCCUPIED_DATA_RATIO);
    }

    private int maxOccupiedWithSentinels()
    {
        return this.keys.length / OCCUPIED_SENTINEL_RATIO;
    }

    private class InternalIntIterator implements MutableIntIterator
    {
        private int count;
        private int position;

        @Override
        public boolean hasNext()
        {
            return this.count != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public int next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException();
            }

            Object[] keys = ObjectIntHashMapWithHashingStrategy.this.keys;
            while (!isNonSentinel(keys[this.position]))
            {
                this.position++;
            }
            int result = ObjectIntHashMapWithHashingStrategy.this.values[this.position];
            this.count++;
            this.position++;
            return result;
        }

        @Override
        public void remove()
        {
            if (this.position == 0 || !isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[this.position - 1]))
            {
                throw new IllegalStateException();
            }
            ObjectIntHashMapWithHashingStrategy.this.remove(ObjectIntHashMapWithHashingStrategy.this.keys[this.position - 1]);
            this.count--;
        }
    }

    @Override
    public Set<K> keySet()
    {
        return new KeySet();
    }

    @Override
    public MutableIntCollection values()
    {
        return new ValuesCollection();
    }

    private class KeySet implements Set<K>
    {
        @Override
        public boolean equals(Object obj)
        {
            if (obj instanceof Set)
            {
                Set<?> other = (Set<?>) obj;
                if (other.size() == this.size())
                {
                    return this.containsAll(other);
                }
            }
            return false;
        }

        @Override
        public int hashCode()
        {
            int hashCode = 0;
            Object[] table = ObjectIntHashMapWithHashingStrategy.this.keys;
            for (int i = 0; i < table.length; i++)
            {
                Object key = table[i];
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(key))
                {
                    K nonSentinelKey = ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(key);
                    hashCode += nonSentinelKey == null ? 0 : ObjectIntHashMapWithHashingStrategy.this.hashingStrategy.computeHashCode(nonSentinelKey);
                }
            }
            return hashCode;
        }

        @Override
        public int size()
        {
            return ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean isEmpty()
        {
            return ObjectIntHashMapWithHashingStrategy.this.isEmpty();
        }

        @Override
        public boolean contains(Object o)
        {
            return ObjectIntHashMapWithHashingStrategy.this.containsKey(o);
        }

        @Override
        public Object[] toArray()
        {
            int size = ObjectIntHashMapWithHashingStrategy.this.size();
            Object[] result = new Object[size];
            this.copyKeys(result);
            return result;
        }

        @Override
        public <T> T[] toArray(T[] result)
        {
            int size = ObjectIntHashMapWithHashingStrategy.this.size();
            if (result.length < size)
            {
                result = (T[]) Array.newInstance(result.getClass().getComponentType(), size);
            }
            this.copyKeys(result);
            if (size < result.length)
            {
                result[size] = null;
            }
            return result;
        }

        @Override
        public boolean add(K key)
        {
            throw new UnsupportedOperationException("Cannot call add() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean remove(Object key)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();
            ObjectIntHashMapWithHashingStrategy.this.removeKey((K) key);
            return oldSize != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean containsAll(Collection<?> collection)
        {
            for (Object aCollection : collection)
            {
                if (!ObjectIntHashMapWithHashingStrategy.this.containsKey(aCollection))
                {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean addAll(Collection<? extends K> collection)
        {
            throw new UnsupportedOperationException("Cannot call addAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean retainAll(Collection<?> collection)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();
            Iterator<K> iterator = this.iterator();
            while (iterator.hasNext())
            {
                K next = iterator.next();
                if (!collection.contains(next))
                {
                    iterator.remove();
                }
            }
            return oldSize != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean removeAll(Collection<?> collection)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();
            for (Object object : collection)
            {
                ObjectIntHashMapWithHashingStrategy.this.removeKey((K) object);
            }
            return oldSize != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public void clear()
        {
            ObjectIntHashMapWithHashingStrategy.this.clear();
        }

        @Override
        public Iterator<K> iterator()
        {
            return new KeySetIterator();
        }

        private void copyKeys(Object[] result)
        {
            int count = 0;
            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                Object key = ObjectIntHashMapWithHashingStrategy.this.keys[i];
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(key))
                {
                    result[count++] = ObjectIntHashMapWithHashingStrategy.this.keys[i];
                }
            }
        }
    }

    private class KeySetIterator implements Iterator<K>
    {
        private int count;
        private int position;
        private K currentKey;
        private boolean isCurrentKeySet;

        @Override
        public boolean hasNext()
        {
            return this.count < ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public K next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException();
            }
            this.count++;
            Object[] keys = ObjectIntHashMapWithHashingStrategy.this.keys;
            while (!isNonSentinel(keys[this.position]))
            {
                this.position++;
            }
            this.currentKey = (K) ObjectIntHashMapWithHashingStrategy.this.keys[this.position];
            this.isCurrentKeySet = true;
            this.position++;
            return ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(this.currentKey);
        }

        @Override
        public void remove()
        {
            if (!this.isCurrentKeySet)
            {
                throw new IllegalStateException();
            }

            this.isCurrentKeySet = false;
            this.count--;

            if (isNonSentinel(this.currentKey))
            {
                int index = this.position - 1;
                ObjectIntHashMapWithHashingStrategy.this.removeKeyAtIndex(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(this.currentKey), index);
            }
            else
            {
                ObjectIntHashMapWithHashingStrategy.this.removeKey(this.currentKey);
            }
        }
    }

    private class ValuesCollection implements MutableIntCollection
    {
        @Override
        public int size()
        {
            return ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean isEmpty()
        {
            return ObjectIntHashMapWithHashingStrategy.this.isEmpty();
        }

        @Override
        public boolean notEmpty()
        {
            return ObjectIntHashMapWithHashingStrategy.this.notEmpty();
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

                boolean first = true;

                for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
                {
                    Object key = ObjectIntHashMapWithHashingStrategy.this.keys[i];
                    if (isNonSentinel(key))
                    {
                        if (!first)
                        {
                            appendable.append(separator);
                        }
                        appendable.append(String.valueOf(ObjectIntHashMapWithHashingStrategy.this.values[i]));
                        first = false;
                    }
                }
                appendable.append(end);
            }
            catch (IOException e)
            {
                throw new RuntimeException(e);
            }
        }

        @Override
        public boolean add(int element)
        {
            throw new UnsupportedOperationException("Cannot call add() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean addAll(int... source)
        {
            throw new UnsupportedOperationException("Cannot call addAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean addAll(IntIterable source)
        {
            throw new UnsupportedOperationException("Cannot call addAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean remove(int item)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();

            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                if (isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]) && item == ObjectIntHashMapWithHashingStrategy.this.values[i])
                {
                    ObjectIntHashMapWithHashingStrategy.this.removeKey((K) ObjectIntHashMapWithHashingStrategy.this.keys[i]);
                }
            }
            return oldSize != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean removeAll(IntIterable source)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();

            IntIterator iterator = source.intIterator();
            while (iterator.hasNext())
            {
                this.remove(iterator.next());
            }
            return oldSize != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean removeAll(int... source)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();

            for (int item : source)
            {
                this.remove(item);
            }
            return oldSize != ObjectIntHashMapWithHashingStrategy.this.size();
        }

        @Override
        public boolean retainAll(IntIterable source)
        {
            int oldSize = ObjectIntHashMapWithHashingStrategy.this.size();
            final IntSet sourceSet = source instanceof IntSet ? (IntSet) source : source.toSet();
            ObjectIntHashMapWithHashingStrategy<K> retained = ObjectIntHashMapWithHashingStrategy.this.select((K object, int value) -> sourceSet.contains(value));
            if (retained.size() != oldSize)
            {
                ObjectIntHashMapWithHashingStrategy.this.keys = retained.keys;
                ObjectIntHashMapWithHashingStrategy.this.values = retained.values;
                ObjectIntHashMapWithHashingStrategy.this.occupiedWithData = retained.occupiedWithData;
                ObjectIntHashMapWithHashingStrategy.this.occupiedWithSentinels = retained.occupiedWithSentinels;
                return true;
            }
            return false;
        }

        @Override
        public boolean retainAll(int... source)
        {
            return this.retainAll(IntHashSet.newSetWith(source));
        }

        @Override
        public void clear()
        {
            ObjectIntHashMapWithHashingStrategy.this.clear();
        }

        @Override
        public MutableIntCollection with(int element)
        {
            throw new UnsupportedOperationException("Cannot call with() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableIntCollection without(int element)
        {
            throw new UnsupportedOperationException("Cannot call without() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableIntCollection withAll(IntIterable elements)
        {
            throw new UnsupportedOperationException("Cannot call withAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableIntCollection withoutAll(IntIterable elements)
        {
            throw new UnsupportedOperationException("Cannot call withoutAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableIntCollection asUnmodifiable()
        {
            return UnmodifiableIntCollection.of(this);
        }

        @Override
        public MutableIntCollection asSynchronized()
        {
            return SynchronizedIntCollection.of(this);
        }

        @Override
        public ImmutableIntCollection toImmutable()
        {
            return IntLists.immutable.withAll(this);
        }

        @Override
        public MutableIntIterator intIterator()
        {
            return ObjectIntHashMapWithHashingStrategy.this.intIterator();
        }

        @Override
        public int[] toArray()
        {
            return ObjectIntHashMapWithHashingStrategy.this.toArray();
        }

        @Override
        public boolean contains(int value)
        {
            return ObjectIntHashMapWithHashingStrategy.this.containsValue(value);
        }

        @Override
        public boolean containsAll(int... source)
        {
            return ObjectIntHashMapWithHashingStrategy.this.containsAll(source);
        }

        @Override
        public boolean containsAll(IntIterable source)
        {
            return ObjectIntHashMapWithHashingStrategy.this.containsAll(source);
        }

        @Override
        public void forEach(IntProcedure procedure)
        {
            ObjectIntHashMapWithHashingStrategy.this.forEach(procedure);
        }

        @Override
        public void each(IntProcedure procedure)
        {
            this.forEach(procedure);
        }

        @Override
        public MutableIntCollection select(IntPredicate predicate)
        {
            return ObjectIntHashMapWithHashingStrategy.this.select(predicate);
        }

        @Override
        public MutableIntCollection reject(IntPredicate predicate)
        {
            return ObjectIntHashMapWithHashingStrategy.this.reject(predicate);
        }

        @Override
        public <V> MutableCollection<V> collect(IntToObjectFunction<? extends V> function)
        {
            return ObjectIntHashMapWithHashingStrategy.this.collect(function);
        }

        @Override
        public <T> T injectInto(T injectedValue, ObjectIntToObjectFunction<? super T, ? extends T> function)
        {
            return ObjectIntHashMapWithHashingStrategy.this.injectInto(injectedValue, function);
        }

        @Override
        public RichIterable<IntIterable> chunk(int size)
        {
            return ObjectIntHashMapWithHashingStrategy.this.chunk(size);
        }

        @Override
        public int detectIfNone(IntPredicate predicate, int ifNone)
        {
            return ObjectIntHashMapWithHashingStrategy.this.detectIfNone(predicate, ifNone);
        }

        @Override
        public int count(IntPredicate predicate)
        {
            return ObjectIntHashMapWithHashingStrategy.this.count(predicate);
        }

        @Override
        public boolean anySatisfy(IntPredicate predicate)
        {
            return ObjectIntHashMapWithHashingStrategy.this.anySatisfy(predicate);
        }

        @Override
        public boolean allSatisfy(IntPredicate predicate)
        {
            return ObjectIntHashMapWithHashingStrategy.this.allSatisfy(predicate);
        }

        @Override
        public boolean noneSatisfy(IntPredicate predicate)
        {
            return ObjectIntHashMapWithHashingStrategy.this.noneSatisfy(predicate);
        }

        @Override
        public MutableIntList toList()
        {
            return ObjectIntHashMapWithHashingStrategy.this.toList();
        }

        @Override
        public MutableIntSet toSet()
        {
            return ObjectIntHashMapWithHashingStrategy.this.toSet();
        }

        @Override
        public MutableIntBag toBag()
        {
            return ObjectIntHashMapWithHashingStrategy.this.toBag();
        }

        @Override
        public LazyIntIterable asLazy()
        {
            return new LazyIntIterableAdapter(this);
        }

        @Override
        public int[] toSortedArray()
        {
            return ObjectIntHashMapWithHashingStrategy.this.toSortedArray();
        }

        @Override
        public MutableIntList toSortedList()
        {
            return ObjectIntHashMapWithHashingStrategy.this.toSortedList();
        }

        @Override
        public long sum()
        {
            return ObjectIntHashMapWithHashingStrategy.this.sum();
        }

        @Override
        public int max()
        {
            return ObjectIntHashMapWithHashingStrategy.this.max();
        }

        @Override
        public int maxIfEmpty(int defaultValue)
        {
            return ObjectIntHashMapWithHashingStrategy.this.maxIfEmpty(defaultValue);
        }

        @Override
        public int min()
        {
            return ObjectIntHashMapWithHashingStrategy.this.min();
        }

        @Override
        public int minIfEmpty(int defaultValue)
        {
            return ObjectIntHashMapWithHashingStrategy.this.minIfEmpty(defaultValue);
        }

        @Override
        public double average()
        {
            return ObjectIntHashMapWithHashingStrategy.this.average();
        }

        @Override
        public double median()
        {
            return ObjectIntHashMapWithHashingStrategy.this.median();
        }

        /**
         * @since 9.2.
         */
        @Override
        public MutableIntCollection newEmpty()
        {
            return new IntHashBag();
        }
    }

    private class KeysView extends AbstractLazyIterable<K>
    {
        @Override
        public void each(Procedure<? super K> procedure)
        {
            ObjectIntHashMapWithHashingStrategy.this.forEachKey(procedure);
        }

        @Override
        public void forEachWithIndex(ObjectIntProcedure<? super K> objectIntProcedure)
        {
            int index = 0;
            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]))
                {
                    objectIntProcedure.value(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]), index);
                    index++;
                }
            }
        }

        @Override
        public <P> void forEachWith(Procedure2<? super K, ? super P> procedure, P parameter)
        {
            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]))
                {
                    procedure.value(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]), parameter);
                }
            }
        }

        @Override
        public Iterator<K> iterator()
        {
            return new InternalKeysViewIterator();
        }

        public class InternalKeysViewIterator implements Iterator<K>
        {
            private int count;
            private int position;

            @Override
            public K next()
            {
                if (!this.hasNext())
                {
                    throw new NoSuchElementException();
                }

                Object[] keys = ObjectIntHashMapWithHashingStrategy.this.keys;
                while (!isNonSentinel(keys[this.position]))
                {
                    this.position++;
                }
                K result = ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[this.position]);
                this.count++;
                this.position++;
                return result;
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException("Cannot call remove() on " + this.getClass().getSimpleName());
            }

            @Override
            public boolean hasNext()
            {
                return this.count != ObjectIntHashMapWithHashingStrategy.this.size();
            }
        }
    }

    private class KeyValuesView extends AbstractLazyIterable<ObjectIntPair<K>>
    {
        @Override
        public void each(Procedure<? super ObjectIntPair<K>> procedure)
        {
            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]))
                {
                    procedure.value(PrimitiveTuples.pair(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]), ObjectIntHashMapWithHashingStrategy.this.values[i]));
                }
            }
        }

        @Override
        public void forEachWithIndex(ObjectIntProcedure<? super ObjectIntPair<K>> objectIntProcedure)
        {
            int index = 0;
            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]))
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]), ObjectIntHashMapWithHashingStrategy.this.values[i]), index);
                    index++;
                }
            }
        }

        @Override
        public <P> void forEachWith(Procedure2<? super ObjectIntPair<K>, ? super P> procedure, P parameter)
        {
            for (int i = 0; i < ObjectIntHashMapWithHashingStrategy.this.keys.length; i++)
            {
                if (ObjectIntHashMapWithHashingStrategy.isNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]))
                {
                    procedure.value(PrimitiveTuples.pair(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[i]), ObjectIntHashMapWithHashingStrategy.this.values[i]), parameter);
                }
            }
        }

        @Override
        public Iterator<ObjectIntPair<K>> iterator()
        {
            return new InternalKeyValuesIterator();
        }

        public class InternalKeyValuesIterator implements Iterator<ObjectIntPair<K>>
        {
            private int count;
            private int position;

            @Override
            public ObjectIntPair<K> next()
            {
                if (!this.hasNext())
                {
                    throw new NoSuchElementException();
                }

                Object[] keys = ObjectIntHashMapWithHashingStrategy.this.keys;
                while (!isNonSentinel(keys[this.position]))
                {
                    this.position++;
                }
                ObjectIntPair<K> result = PrimitiveTuples.pair(ObjectIntHashMapWithHashingStrategy.this.toNonSentinel(ObjectIntHashMapWithHashingStrategy.this.keys[this.position]), ObjectIntHashMapWithHashingStrategy.this.values[this.position]);
                this.count++;
                this.position++;
                return result;
            }

            @Override
            public void remove()
            {
                throw new UnsupportedOperationException("Cannot call remove() on " + this.getClass().getSimpleName());
            }

            @Override
            public boolean hasNext()
            {
                return this.count != ObjectIntHashMapWithHashingStrategy.this.size();
            }
        }
    }
}
