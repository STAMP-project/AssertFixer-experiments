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
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.LongToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.LongShortPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.LongProcedure;
import org.eclipse.collections.api.block.procedure.primitive.LongShortProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.impl.SpreadFunctions;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.LongShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongShortMap;
import org.eclipse.collections.api.map.primitive.MutableLongShortMap;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.tuple.primitive.LongShortPair;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.iterator.UnmodifiableLongIterator;
import org.eclipse.collections.impl.lazy.AbstractLazyIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyLongIterable;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;

/**
 * This file was automatically generated from template file primitivePrimitiveHashMap.stg.
 *
 * @since 3.0.
 */
public class LongShortHashMap extends AbstractMutableShortValuesMap implements MutableLongShortMap, Externalizable, MutableLongKeysMap
{
    private static final short EMPTY_VALUE = (short) 0;
    private static final long serialVersionUID = 1L;
    private static final long EMPTY_KEY = 0L;
    private static final long REMOVED_KEY = 1L;
    private static final int CACHE_LINE_SIZE = 64;
    private static final int KEY_SIZE = 8;
    private static final int INITIAL_LINEAR_PROBE = CACHE_LINE_SIZE / KEY_SIZE / 2; /* half a cache line */

    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    private long[] keys;
    private short[] values;
    private int occupiedWithData;
    private int occupiedWithSentinels;

    private SentinelValues sentinelValues;

    private boolean copyKeysOnWrite;

    public LongShortHashMap()
    {
        this.allocateTable(DEFAULT_INITIAL_CAPACITY << 1);
    }

    public LongShortHashMap(int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            throw new IllegalArgumentException("initial capacity cannot be less than 0");
        }
        int capacity = this.smallestPowerOfTwoGreaterThan(initialCapacity << 1);
        this.allocateTable(capacity);
    }

    public LongShortHashMap(LongShortMap map)
    {
        if (map instanceof LongShortHashMap && ((LongShortHashMap) map).occupiedWithSentinels == 0)
        {
            LongShortHashMap hashMap = (LongShortHashMap) map;
            this.occupiedWithData = hashMap.occupiedWithData;
            if (hashMap.sentinelValues != null)
            {
                this.sentinelValues = hashMap.sentinelValues.copy();
            }
            this.keys = Arrays.copyOf(hashMap.keys, hashMap.keys.length);
            this.values = Arrays.copyOf(hashMap.values, hashMap.values.length);
        }
        else
        {
            int capacity = this.smallestPowerOfTwoGreaterThan(Math.max(map.size(), DEFAULT_INITIAL_CAPACITY) << 1);
            this.allocateTable(capacity);
            this.putAll(map);
        }
    }

    public static LongShortHashMap newWithKeysValues(long key1, short value1)
    {
        return new LongShortHashMap(1).withKeyValue(key1, value1);
    }

    public static LongShortHashMap newWithKeysValues(long key1, short value1, long key2, short value2)
    {
        return new LongShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    public static LongShortHashMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3)
    {
        return new LongShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    public static LongShortHashMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4)
    {
        return new LongShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    private int smallestPowerOfTwoGreaterThan(int n)
    {
        return n > 1 ? Integer.highestOneBit(n - 1) << 1 : 1;
    }

    @Override
    protected int getOccupiedWithData()
    {
        return this.occupiedWithData;
    }

    @Override
    protected SentinelValues getSentinelValues()
    {
        return this.sentinelValues;
    }

    @Override
    protected void setSentinelValuesNull()
    {
        this.sentinelValues = null;
    }

    @Override
    protected short getEmptyValue()
    {
        return EMPTY_VALUE;
    }

    @Override
    protected int getTableSize()
    {
        return this.values.length;
    }

    @Override
    protected short getValueAtIndex(int index)
    {
        return this.values[index];
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (!(obj instanceof LongShortMap))
        {
            return false;
        }

        LongShortMap other = (LongShortMap) obj;

        if (this.size() != other.size())
        {
            return false;
        }

        if (this.sentinelValues == null)
        {
            if (other.containsKey(EMPTY_KEY) || other.containsKey(REMOVED_KEY))
            {
                return false;
            }
        }
        else
        {
            if (this.sentinelValues.containsZeroKey && (!other.containsKey(EMPTY_KEY) || this.sentinelValues.zeroValue != other.getOrThrow(EMPTY_KEY)))
            {
                return false;
            }

            if (this.sentinelValues.containsOneKey && (!other.containsKey(REMOVED_KEY) || this.sentinelValues.oneValue != other.getOrThrow(REMOVED_KEY)))
            {
                return false;
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            long key = this.keys[i];
            if (isNonSentinel(key) && (!other.containsKey(key) || this.values[i] != other.getOrThrow(key)))
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

        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey)
            {
                result += (int) (EMPTY_KEY ^ EMPTY_KEY >>> 32) ^ (int) this.sentinelValues.zeroValue;
            }
            if (this.sentinelValues.containsOneKey)
            {
                result += (int) (REMOVED_KEY ^ REMOVED_KEY >>> 32) ^ (int) this.sentinelValues.oneValue;
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result += (int) (this.keys[i] ^ this.keys[i] >>> 32) ^ (int) this.values[i];
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

        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey)
            {
                appendable.append(EMPTY_KEY).append("=").append(this.sentinelValues.zeroValue);
                first = false;
            }
            if (this.sentinelValues.containsOneKey)
            {
                if (!first)
                {
                    appendable.append(", ");
                }
                appendable.append(REMOVED_KEY).append("=").append(this.sentinelValues.oneValue);
                first = false;
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            long key = this.keys[i];
            if (isNonSentinel(key))
            {
                if (!first)
                {
                    appendable.append(", ");
                }
                appendable.append(key).append("=").append(this.values[i]);
                first = false;
            }
        }
        appendable.append("}");

        return appendable.toString();
    }

    @Override
    public MutableShortIterator shortIterator()
    {
        return new InternalShortIterator();
    }

    @Override
    public <V> V injectInto(V injectedValue, ObjectShortToObjectFunction<? super V, ? extends V> function)
    {
        V result = injectedValue;

        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey)
            {
                result = function.valueOf(result, this.sentinelValues.zeroValue);
            }
            if (this.sentinelValues.containsOneKey)
            {
                result = function.valueOf(result, this.sentinelValues.oneValue);
            }
        }
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
    public void clear()
    {
        this.sentinelValues = null;
        this.occupiedWithData = 0;
        this.occupiedWithSentinels = 0;
        if (this.copyKeysOnWrite)
        {
            this.copyKeys();
        }
        Arrays.fill(this.keys, EMPTY_KEY);
        Arrays.fill(this.values, EMPTY_VALUE);
    }

    @Override
    public void put(long key, short value)
    {
        if (isEmptyKey(key))
        {
            this.putForEmptySentinel(value);
            return;
        }

        if (isRemovedKey(key))
        {
            this.putForRemovedSentinel(value);
            return;
        }

        int index = this.probe(key);
        long keyAtIndex = this.keys[index];
        if (keyAtIndex == key)
        {
            this.values[index] = value;
        }
        else
        {
            this.addKeyValueAtIndex(key, value, index);
        }
    }

    private void putForRemovedSentinel(short value)
    {
        if (this.sentinelValues == null)
        {
            this.sentinelValues = new SentinelValues();
        }
        this.addRemovedKeyValue(value);
    }

    private void putForEmptySentinel(short value)
    {
        if (this.sentinelValues == null)
        {
            this.sentinelValues = new SentinelValues();
        }
        this.addEmptyKeyValue(value);
    }

    @Override
    public void putAll(LongShortMap map)
    {
        map.forEachKeyValue(this::put);
    }

    @Override
    public void removeKey(long key)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsZeroKey)
            {
                return;
            }
            this.removeEmptyKey();
            return;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsOneKey)
            {
                return;
            }
            this.removeRemovedKey();
            return;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            this.removeKeyAtIndex(index);
        }
    }

    @Override
    public void remove(long key)
    {
        this.removeKey(key);
    }

    @Override
    public short removeKeyIfAbsent(long key, short value)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsZeroKey)
            {
                return value;
            }
            short oldValue = this.sentinelValues.zeroValue;
            this.removeEmptyKey();
            return oldValue;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsOneKey)
            {
                return value;
            }
            short oldValue = this.sentinelValues.oneValue;
            this.removeRemovedKey();
            return oldValue;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            short oldValue = this.values[index];
            this.removeKeyAtIndex(index);
            return oldValue;
        }
        return value;
    }

    @Override
    public short getIfAbsentPut(long key, short value)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            return this.values[index];
        }
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public short getIfAbsentPut(long key, ShortFunction0 function)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                short value = function.value();
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            short value = function.value();
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                short value = function.value();
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            short value = function.value();
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            return this.values[index];
        }
        short value = function.value();
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public <P> short getIfAbsentPutWith(long key, ShortFunction<? super P> function, P parameter)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                short value = function.shortValueOf(parameter);
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            short value = function.shortValueOf(parameter);
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                short value = function.shortValueOf(parameter);
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            short value = function.shortValueOf(parameter);
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            return this.values[index];
        }
        short value = function.shortValueOf(parameter);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public short getIfAbsentPutWithKey(long key, LongToShortFunction function)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                short value = function.valueOf(key);
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            short value = function.valueOf(key);
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                short value = function.valueOf(key);
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            short value = function.valueOf(key);
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            return this.values[index];
        }
        short value = function.valueOf(key);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public short addToValue(long key, short toBeAdded)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(toBeAdded);
            }
            else if (this.sentinelValues.containsZeroKey)
            {
                this.sentinelValues.zeroValue += toBeAdded;
            }
            else
            {
                this.addEmptyKeyValue(toBeAdded);
            }
            return this.sentinelValues.zeroValue;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(toBeAdded);
            }
            else if (this.sentinelValues.containsOneKey)
            {
                this.sentinelValues.oneValue += toBeAdded;
            }
            else
            {
                this.addRemovedKeyValue(toBeAdded);
            }
            return this.sentinelValues.oneValue;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            this.values[index] += toBeAdded;
            return this.values[index];
        }
        this.addKeyValueAtIndex(key, toBeAdded, index);
        return toBeAdded;
    }

    private void addKeyValueAtIndex(long key, short value, int index)
    {
        if (this.keys[index] == REMOVED_KEY)
        {
            this.occupiedWithSentinels--;
        }
        if (this.copyKeysOnWrite)
        {
            this.copyKeys();
        }
        this.keys[index] = key;
        this.values[index] = value;
        this.occupiedWithData++;
        if (this.occupiedWithData + this.occupiedWithSentinels > this.maxOccupiedWithData())
        {
            this.rehashAndGrow();
        }
    }

    private void removeKeyAtIndex(int index)
    {
        if (this.copyKeysOnWrite)
        {
            this.copyKeys();
        }
        this.keys[index] = REMOVED_KEY;
        this.values[index] = EMPTY_VALUE;
        this.occupiedWithData--;
        this.occupiedWithSentinels++;
    }

    private void copyKeys()
    {
        long[] copy = new long[this.keys.length];
        System.arraycopy(this.keys, 0, copy, 0, this.keys.length);
        this.keys = copy;
        this.copyKeysOnWrite = false;
    }

    @Override
    public short updateValue(long key, short initialValueIfAbsent, ShortToShortFunction function)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(function.valueOf(initialValueIfAbsent));
            }
            else if (this.sentinelValues.containsZeroKey)
            {
                this.sentinelValues.zeroValue = function.valueOf(this.sentinelValues.zeroValue);
            }
            else
            {
                this.addEmptyKeyValue(function.valueOf(initialValueIfAbsent));
            }
            return this.sentinelValues.zeroValue;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(function.valueOf(initialValueIfAbsent));
            }
            else if (this.sentinelValues.containsOneKey)
            {
                this.sentinelValues.oneValue = function.valueOf(this.sentinelValues.oneValue);
            }
            else
            {
                this.addRemovedKeyValue(function.valueOf(initialValueIfAbsent));
            }
            return this.sentinelValues.oneValue;
        }
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            this.values[index] = function.valueOf(this.values[index]);
            return this.values[index];
        }
        short value = function.valueOf(initialValueIfAbsent);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public LongShortHashMap withKeyValue(long key1, short value1)
    {
        this.put(key1, value1);
        return this;
    }

    public LongShortHashMap withKeysValues(long key1, short value1, long key2, short value2)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        return this;
    }

    public LongShortHashMap withKeysValues(long key1, short value1, long key2, short value2, long key3, short value3)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        this.put(key3, value3);
        return this;
    }

    public LongShortHashMap withKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        this.put(key3, value3);
        this.put(key4, value4);
        return this;
    }

    @Override
    public LongShortHashMap withoutKey(long key)
    {
        this.removeKey(key);
        return this;
    }

    @Override
    public LongShortHashMap withoutAllKeys(LongIterable keys)
    {
        keys.forEach(this::removeKey);
        return this;
    }

    @Override
    public MutableLongShortMap asUnmodifiable()
    {
        return new UnmodifiableLongShortMap(this);
    }

    @Override
    public MutableLongShortMap asSynchronized()
    {
        return new SynchronizedLongShortMap(this);
    }

    @Override
    public ImmutableLongShortMap toImmutable()
    {
        return LongShortMaps.immutable.ofAll(this);
    }

    @Override
    public short get(long key)
    {
        return this.getIfAbsent(key, EMPTY_VALUE);
    }

    @Override
    public short getIfAbsent(long key, short ifAbsent)
    {
        if (isEmptyKey(key) || isRemovedKey(key))
        {
            return this.getForSentinel(key, ifAbsent);
        }
        if (this.occupiedWithSentinels == 0)
        {
            return this.fastGetIfAbsent(key, ifAbsent);
        }
        return this.slowGetIfAbsent(key, ifAbsent);
    }

    private short getForSentinel(long key, short ifAbsent)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsZeroKey)
            {
                return ifAbsent;
            }
            return this.sentinelValues.zeroValue;
        }
        if (this.sentinelValues == null || !this.sentinelValues.containsOneKey)
        {
            return ifAbsent;
        }
        return this.sentinelValues.oneValue;
    }

    private short slowGetIfAbsent(long key, short ifAbsent)
    {
        int index = this.probe(key);
        if (this.keys[index] == key)
        {
            return this.values[index];
        }
        return ifAbsent;
    }

    private short fastGetIfAbsent(long key, short ifAbsent)
    {
        int index = this.mask((int) key);

        for (int i = 0; i < INITIAL_LINEAR_PROBE; i++)
        {
            long keyAtIndex = this.keys[index];
            if (keyAtIndex == key)
            {
                return this.values[index];
            }
            if (keyAtIndex == EMPTY_KEY)
            {
                return ifAbsent;
            }
            index = (index + 1) & (this.keys.length - 1);
        }
        return this.slowGetIfAbsentTwo(key, ifAbsent);
    }

    private short slowGetIfAbsentTwo(long key, short ifAbsent)
    {
        int index = this.probeTwo(key, -1);
        if (this.keys[index] == key)
        {
            return this.values[index];
        }
        return ifAbsent;
    }

    @Override
    public short getOrThrow(long key)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsZeroKey)
            {
                throw new IllegalStateException("Key " + key + " not present.");
            }
            return this.sentinelValues.zeroValue;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsOneKey)
            {
                throw new IllegalStateException("Key " + key + " not present.");
            }
            return this.sentinelValues.oneValue;
        }
        int index = this.probe(key);
        if (isNonSentinel(this.keys[index]))
        {
            return this.values[index];
        }
        throw new IllegalStateException("Key " + key + " not present.");
    }

    @Override
    public boolean containsKey(long key)
    {
        if (isEmptyKey(key))
        {
            return this.sentinelValues != null && this.sentinelValues.containsZeroKey;
        }
        if (isRemovedKey(key))
        {
            return this.sentinelValues != null && this.sentinelValues.containsOneKey;
        }
        return this.keys[this.probe(key)] == key;
    }

    @Override
    public void forEachKey(LongProcedure procedure)
    {
        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey)
            {
                procedure.value(EMPTY_KEY);
            }
            if (this.sentinelValues.containsOneKey)
            {
                procedure.value(REMOVED_KEY);
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                procedure.value(this.keys[i]);
            }
        }
    }

    @Override
    public void forEachKeyValue(LongShortProcedure procedure)
    {
        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey)
            {
                procedure.value(EMPTY_KEY, this.sentinelValues.zeroValue);
            }
            if (this.sentinelValues.containsOneKey)
            {
                procedure.value(REMOVED_KEY, this.sentinelValues.oneValue);
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                procedure.value(this.keys[i], this.values[i]);
            }
        }
    }

    @Override
    public LazyLongIterable keysView()
    {
        return new KeysView();
    }

    @Override
    public RichIterable<LongShortPair> keyValuesView()
    {
        return new KeyValuesView();
    }

    @Override
    public MutableShortLongMap flipUniqueValues()
    {
        MutableShortLongMap result = ShortLongMaps.mutable.empty();
         this.forEachKeyValue((key, value) -> {
            if (result.containsKey(value))
            {
                throw new IllegalStateException("Duplicate value: " + value + " found at key: " + result.get(value) + " and key: " + key);
            }
            result.put(value, key);
        });
        return result;
    }

    @Override
    public LongShortHashMap select(LongShortPredicate predicate)
    {
        LongShortHashMap result = new LongShortHashMap();

        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey && predicate.accept(EMPTY_KEY, this.sentinelValues.zeroValue))
            {
                result.put(EMPTY_KEY, this.sentinelValues.zeroValue);
            }
            if (this.sentinelValues.containsOneKey && predicate.accept(REMOVED_KEY, this.sentinelValues.oneValue))
            {
                result.put(REMOVED_KEY, this.sentinelValues.oneValue);
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && predicate.accept(this.keys[i], this.values[i]))
            {
                result.put(this.keys[i], this.values[i]);
            }
        }

        return result;
    }

    @Override
    public LongShortHashMap reject(LongShortPredicate predicate)
    {
        LongShortHashMap result = new LongShortHashMap();

        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey && !predicate.accept(EMPTY_KEY, this.sentinelValues.zeroValue))
            {
                result.put(EMPTY_KEY, this.sentinelValues.zeroValue);
            }
            if (this.sentinelValues.containsOneKey && !predicate.accept(REMOVED_KEY, this.sentinelValues.oneValue))
            {
                result.put(REMOVED_KEY, this.sentinelValues.oneValue);
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]) && !predicate.accept(this.keys[i], this.values[i]))
            {
                result.put(this.keys[i], this.values[i]);
            }
        }
        return result;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(this.size());
        if (this.sentinelValues != null)
        {
            if (this.sentinelValues.containsZeroKey)
            {
                out.writeLong(EMPTY_KEY);
                out.writeShort(this.sentinelValues.zeroValue);
            }
            if (this.sentinelValues.containsOneKey)
            {
                out.writeLong(REMOVED_KEY);
                out.writeShort(this.sentinelValues.oneValue);
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                out.writeLong(this.keys[i]);
                out.writeShort(this.values[i]);
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        int size = in.readInt();
        for (int i = 0; i < size; i++)
        {
            this.put(in.readLong(), in.readShort());
        }
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
        long[] old = this.keys;
        short[] oldValues = this.values;
        this.allocateTable(newCapacity);
        this.occupiedWithData = 0;
        this.occupiedWithSentinels = 0;

        for (int i = 0; i < oldLength; i++)
        {
            if (isNonSentinel(old[i]))
            {
                this.put(old[i], oldValues[i]);
            }
        }
    }

    // exposed for testing
    int probe(long element)
    {
        int index = this.mask((int) element);
        long keyAtIndex = this.keys[index];

        if (keyAtIndex == element || keyAtIndex == EMPTY_KEY)
        {
            return index;
        }

        int removedIndex = keyAtIndex == REMOVED_KEY ? index : -1;
        for (int i = 1; i < INITIAL_LINEAR_PROBE; i++)
        {
            int nextIndex = (index + i) & (this.keys.length - 1);
            keyAtIndex = this.keys[nextIndex];
            if (keyAtIndex == element)
            {
                return nextIndex;
            }
            if (keyAtIndex == EMPTY_KEY)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (keyAtIndex == REMOVED_KEY && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
        return this.probeTwo(element, removedIndex);
    }

    int probeTwo(long element, int removedIndex)
    {
        int index = this.spreadTwoAndMask(element);
        for (int i = 0; i < INITIAL_LINEAR_PROBE; i++)
        {
            int nextIndex = (index + i) & (this.keys.length - 1);
            long keyAtIndex = this.keys[nextIndex];
            if (keyAtIndex == element)
            {
                return nextIndex;
            }
            if (keyAtIndex == EMPTY_KEY)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (keyAtIndex == REMOVED_KEY && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
        return this.probeThree(element, removedIndex);
    }

    int probeThree(long element, int removedIndex)
    {
        int nextIndex = (int) SpreadFunctions.longSpreadOne(element);
        int spreadTwo = (int) Long.reverse(SpreadFunctions.longSpreadTwo(element)) | 1;

        while (true)
        {
            nextIndex = this.mask(nextIndex + spreadTwo);
            long keyAtIndex = this.keys[nextIndex];
            if (keyAtIndex == element)
            {
                return nextIndex;
            }
            if (keyAtIndex == EMPTY_KEY)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (keyAtIndex == REMOVED_KEY && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
    }

    // exposed for testing
    int spreadAndMask(long element)
    {
        long code = SpreadFunctions.longSpreadOne(element);
        return this.mask((int) code);
    }

    int spreadTwoAndMask(long element)
    {
        long code = SpreadFunctions.longSpreadTwo(element);
        return this.mask((int) code);
    }

    private int mask(int spread)
    {
        return spread & (this.keys.length  - 1);
    }

    private void allocateTable(int sizeToAllocate)
    {
        this.keys = new long[sizeToAllocate];
        this.values = new short[sizeToAllocate];
    }

    private static boolean isEmptyKey(long key)
    {
        return key == EMPTY_KEY;
    }

    private static boolean isRemovedKey(long key)
    {
        return key == REMOVED_KEY;
    }

    private static boolean isNonSentinel(long key)
    {
        return !isEmptyKey(key) && !isRemovedKey(key);
    }

    @Override
    protected boolean isNonSentinelAtIndex(int index)
    {
        return !isEmptyKey(this.keys[index]) && !isRemovedKey(this.keys[index]);
    }

    private int maxOccupiedWithData()
    {
        return this.keys.length >> 1;
    }

    private int maxOccupiedWithSentinels()
    {
        return this.keys.length >> 2;
    }

    private class InternalShortIterator implements MutableShortIterator
    {
        private int count;
        private int position;
        private long lastKey;
        private boolean handledZero;
        private boolean handledOne;
        private boolean canRemove;

        @Override
        public boolean hasNext()
        {
            return this.count < LongShortHashMap.this.size();
        }

        @Override
        public short next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException("next() called, but the iterator is exhausted");
            }
            this.count++;
            this.canRemove = true;

            if (!this.handledZero)
            {
                this.handledZero = true;
                if (LongShortHashMap.this.containsKey(EMPTY_KEY))
                {
                    this.lastKey = EMPTY_KEY;
                    return LongShortHashMap.this.get(EMPTY_KEY);
                }
            }
            if (!this.handledOne)
            {
                this.handledOne = true;
                if (LongShortHashMap.this.containsKey(REMOVED_KEY))
                {
                    this.lastKey = REMOVED_KEY;
                    return LongShortHashMap.this.get(REMOVED_KEY);
                }
            }
            long[] keys = LongShortHashMap.this.keys;
            while (!isNonSentinel(keys[this.position]))
            {
                this.position++;
            }
            this.lastKey = keys[this.position];
            short result = LongShortHashMap.this.values[this.position];
            this.position++;

            return result;
        }

        @Override
        public void remove()
        {
            if (!this.canRemove)
            {
                throw new IllegalStateException();
            }
            LongShortHashMap.this.removeKey(this.lastKey);
            this.count--;
            this.canRemove = false;
        }
    }

    private class KeysView extends AbstractLazyLongIterable
    {
        @Override
        public LongIterator longIterator()
        {
            return new UnmodifiableLongIterator(new KeySetIterator());
        }

        /**
         * @since 7.0.
         */
        @Override
        public void each(LongProcedure procedure)
        {
            LongShortHashMap.this.forEachKey(procedure);
        }
    }

    private class KeySetIterator implements MutableLongIterator
    {
        private int count;
        private int position;
        private long lastKey;
        private boolean handledZero;
        private boolean handledOne;
        private boolean canRemove;

        @Override
        public boolean hasNext()
        {
            return this.count < LongShortHashMap.this.size();
        }

        @Override
        public long next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException("next() called, but the iterator is exhausted");
            }
            this.count++;
            this.canRemove = true;

            if (!this.handledZero)
            {
                this.handledZero = true;
                if (LongShortHashMap.this.containsKey(EMPTY_KEY))
                {
                    this.lastKey = EMPTY_KEY;
                    return this.lastKey;
                }
            }
            if (!this.handledOne)
            {
                this.handledOne = true;
                if (LongShortHashMap.this.containsKey(REMOVED_KEY))
                {
                    this.lastKey = REMOVED_KEY;
                    return this.lastKey;
                }
            }

            long[] keys = LongShortHashMap.this.keys;
            while (!isNonSentinel(keys[this.position]))
            {
                this.position++;
            }
            this.lastKey = keys[this.position];
            this.position++;

            return this.lastKey;
        }

        @Override
        public void remove()
        {
            if (!this.canRemove)
            {
                throw new IllegalStateException();
            }
            LongShortHashMap.this.removeKey(this.lastKey);
            this.count--;
            this.canRemove = false;
        }
    }

    @Override
    public MutableLongSet keySet()
    {
        return new KeySet();
    }

    private class KeySet extends AbstractMutableLongKeySet
    {
        @Override
        protected MutableLongKeysMap getOuter()
        {
            return LongShortHashMap.this;
        }

        @Override
        protected SentinelValues getSentinelValues()
        {
            return LongShortHashMap.this.sentinelValues;
        }

        @Override
        protected long getKeyAtIndex(int index)
        {
            return LongShortHashMap.this.keys[index];
        }

        @Override
        protected int getTableSize()
        {
            return LongShortHashMap.this.keys.length;
        }

        @Override
        public MutableLongIterator longIterator()
        {
            return new KeySetIterator();
        }

        @Override
        public boolean retainAll(LongIterable source)
        {
            int oldSize = LongShortHashMap.this.size();
            final LongSet sourceSet = source instanceof LongSet ? (LongSet) source : source.toSet();
            LongShortHashMap retained = LongShortHashMap.this.select((long key, short value) -> sourceSet.contains(key));
            if (retained.size() != oldSize)
            {
                LongShortHashMap.this.keys = retained.keys;
                LongShortHashMap.this.values = retained.values;
                LongShortHashMap.this.sentinelValues = retained.sentinelValues;
                LongShortHashMap.this.occupiedWithData = retained.occupiedWithData;
                LongShortHashMap.this.occupiedWithSentinels = retained.occupiedWithSentinels;
                return true;
            }
            return false;
        }

        @Override
        public boolean retainAll(long... source)
        {
            return this.retainAll(LongHashSet.newSetWith(source));
        }

        @Override
        public LongSet freeze()
        {
            LongShortHashMap.this.copyKeysOnWrite = true;
            boolean containsZeroKey = false;
            boolean containsOneKey = false;
            if (LongShortHashMap.this.sentinelValues != null)
            {
                containsZeroKey = LongShortHashMap.this.sentinelValues.containsZeroKey;
                containsOneKey = LongShortHashMap.this.sentinelValues.containsOneKey;
            }
            return new ImmutableLongMapKeySet(LongShortHashMap.this.keys, LongShortHashMap.this.occupiedWithData, containsZeroKey, containsOneKey);
        }

        /**
         * @since 9.2.
         */
        @Override
        public MutableLongSet newEmpty()
        {
            return new LongHashSet();
        }
    }

    @Override
    public MutableShortCollection values()
    {
        return new ValuesCollection();
    }

    private class ValuesCollection extends AbstractShortValuesCollection
    {
        @Override
        public MutableShortIterator shortIterator()
        {
            return LongShortHashMap.this.shortIterator();
        }

        @Override
        public boolean remove(short item)
        {
            int oldSize = LongShortHashMap.this.size();

            if (LongShortHashMap.this.sentinelValues != null)
            {
                if (LongShortHashMap.this.sentinelValues.containsZeroKey && item == LongShortHashMap.this.sentinelValues.zeroValue)
                {
                    LongShortHashMap.this.removeKey(EMPTY_KEY);
                }
                if (LongShortHashMap.this.sentinelValues.containsOneKey && item == LongShortHashMap.this.sentinelValues.oneValue)
                {
                    LongShortHashMap.this.removeKey(REMOVED_KEY);
                }
            }
            for (int i = 0; i < LongShortHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(LongShortHashMap.this.keys[i]) && item == LongShortHashMap.this.values[i])
                {
                    LongShortHashMap.this.removeKey(LongShortHashMap.this.keys[i]);
                }
            }
            return oldSize != LongShortHashMap.this.size();
        }

        @Override
        public boolean retainAll(ShortIterable source)
        {
            int oldSize = LongShortHashMap.this.size();
            final ShortSet sourceSet = source instanceof ShortSet ? (ShortSet) source : source.toSet();
            LongShortHashMap retained = LongShortHashMap.this.select((long key, short value) -> sourceSet.contains(value));
            if (retained.size() != oldSize)
            {
                LongShortHashMap.this.keys = retained.keys;
                LongShortHashMap.this.values = retained.values;
                LongShortHashMap.this.sentinelValues = retained.sentinelValues;
                LongShortHashMap.this.occupiedWithData = retained.occupiedWithData;
                LongShortHashMap.this.occupiedWithSentinels = retained.occupiedWithSentinels;
                return true;
            }
            return false;
        }

        /**
         * @since 9.2.
         */
        @Override
        public MutableShortCollection newEmpty()
        {
            return new ShortHashBag();
        }
    }

    private class KeyValuesView extends AbstractLazyIterable<LongShortPair>
    {
        @Override
        public void each(Procedure<? super LongShortPair> procedure)
        {
            if (LongShortHashMap.this.sentinelValues != null)
            {
                if (LongShortHashMap.this.sentinelValues.containsZeroKey)
                {
                    procedure.value(PrimitiveTuples.pair(EMPTY_KEY, LongShortHashMap.this.sentinelValues.zeroValue));
                }
                if (LongShortHashMap.this.sentinelValues.containsOneKey)
                {
                    procedure.value(PrimitiveTuples.pair(REMOVED_KEY, LongShortHashMap.this.sentinelValues.oneValue));
                }
            }
            for (int i = 0; i < LongShortHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(LongShortHashMap.this.keys[i]))
                {
                    procedure.value(PrimitiveTuples.pair(LongShortHashMap.this.keys[i], LongShortHashMap.this.values[i]));
                }
            }
        }

        @Override
        public void forEachWithIndex(ObjectIntProcedure<? super LongShortPair> objectIntProcedure)
        {
            int index = 0;
            if (LongShortHashMap.this.sentinelValues != null)
            {
                if (LongShortHashMap.this.sentinelValues.containsZeroKey)
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(EMPTY_KEY, LongShortHashMap.this.sentinelValues.zeroValue), index);
                    index++;
                }
                if (LongShortHashMap.this.sentinelValues.containsOneKey)
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(REMOVED_KEY, LongShortHashMap.this.sentinelValues.oneValue), index);
                    index++;
                }
            }
            for (int i = 0; i < LongShortHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(LongShortHashMap.this.keys[i]))
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(LongShortHashMap.this.keys[i], LongShortHashMap.this.values[i]), index);
                    index++;
                }
            }
        }

        @Override
        public <P> void forEachWith(Procedure2<? super LongShortPair, ? super P> procedure, P parameter)
        {
            if (LongShortHashMap.this.sentinelValues != null)
            {
                if (LongShortHashMap.this.sentinelValues.containsZeroKey)
                {
                    procedure.value(PrimitiveTuples.pair(EMPTY_KEY, LongShortHashMap.this.sentinelValues.zeroValue), parameter);
                }
                if (LongShortHashMap.this.sentinelValues.containsOneKey)
                {
                    procedure.value(PrimitiveTuples.pair(REMOVED_KEY, LongShortHashMap.this.sentinelValues.oneValue), parameter);
                }
            }
            for (int i = 0; i < LongShortHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(LongShortHashMap.this.keys[i]))
                {
                    procedure.value(PrimitiveTuples.pair(LongShortHashMap.this.keys[i], LongShortHashMap.this.values[i]), parameter);
                }
            }
        }

        @Override
        public Iterator<LongShortPair> iterator()
        {
            return new InternalKeyValuesIterator();
        }

        public class InternalKeyValuesIterator implements Iterator<LongShortPair>
        {
            private int count;
            private int position;
            private boolean handledZero;
            private boolean handledOne;

            @Override
            public LongShortPair next()
            {
                if (!this.hasNext())
                {
                    throw new NoSuchElementException("next() called, but the iterator is exhausted");
                }
                this.count++;

                if (!this.handledZero)
                {
                    this.handledZero = true;
                    if (LongShortHashMap.this.containsKey(EMPTY_KEY))
                    {
                        return PrimitiveTuples.pair(EMPTY_KEY, LongShortHashMap.this.sentinelValues.zeroValue);
                    }
                }
                if (!this.handledOne)
                {
                    this.handledOne = true;
                    if (LongShortHashMap.this.containsKey(REMOVED_KEY))
                    {
                        return PrimitiveTuples.pair(REMOVED_KEY, LongShortHashMap.this.sentinelValues.oneValue);
                    }
                }

                long[] keys = LongShortHashMap.this.keys;
                while (!isNonSentinel(keys[this.position]))
                {
                    this.position++;
                }
                LongShortPair result = PrimitiveTuples.pair(keys[this.position], LongShortHashMap.this.values[this.position]);
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
                return this.count != LongShortHashMap.this.size();
            }
        }
    }
}

