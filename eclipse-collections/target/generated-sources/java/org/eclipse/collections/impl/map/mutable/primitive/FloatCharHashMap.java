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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.LazyFloatIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectCharToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.FloatCharPredicate;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.block.procedure.primitive.FloatProcedure;
import org.eclipse.collections.api.block.procedure.primitive.FloatCharProcedure;
import org.eclipse.collections.api.block.procedure.primitive.ObjectIntProcedure;
import org.eclipse.collections.impl.SpreadFunctions;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.FloatCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatCharMap;
import org.eclipse.collections.api.map.primitive.MutableFloatCharMap;
import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.tuple.primitive.FloatCharPair;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharFloatMaps;
import org.eclipse.collections.impl.iterator.UnmodifiableFloatIterator;
import org.eclipse.collections.impl.lazy.AbstractLazyIterable;
import org.eclipse.collections.impl.lazy.primitive.AbstractLazyFloatIterable;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;

/**
 * This file was automatically generated from template file primitivePrimitiveHashMap.stg.
 *
 * @since 3.0.
 */
public class FloatCharHashMap extends AbstractMutableCharValuesMap implements MutableFloatCharMap, Externalizable, MutableFloatKeysMap
{
    private static final char EMPTY_VALUE = (char) 0;
    private static final long serialVersionUID = 1L;
    private static final float EMPTY_KEY = 0.0f;
    private static final float REMOVED_KEY = 1.0f;
    private static final int CACHE_LINE_SIZE = 64;
    private static final int KEY_SIZE = 4;
    private static final int INITIAL_LINEAR_PROBE = CACHE_LINE_SIZE / KEY_SIZE / 2; /* half a cache line */

    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    private float[] keys;
    private char[] values;
    private int occupiedWithData;
    private int occupiedWithSentinels;

    private SentinelValues sentinelValues;

    private boolean copyKeysOnWrite;

    public FloatCharHashMap()
    {
        this.allocateTable(DEFAULT_INITIAL_CAPACITY << 1);
    }

    public FloatCharHashMap(int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            throw new IllegalArgumentException("initial capacity cannot be less than 0");
        }
        int capacity = this.smallestPowerOfTwoGreaterThan(initialCapacity << 1);
        this.allocateTable(capacity);
    }

    public FloatCharHashMap(FloatCharMap map)
    {
        if (map instanceof FloatCharHashMap && ((FloatCharHashMap) map).occupiedWithSentinels == 0)
        {
            FloatCharHashMap hashMap = (FloatCharHashMap) map;
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

    public static FloatCharHashMap newWithKeysValues(float key1, char value1)
    {
        return new FloatCharHashMap(1).withKeyValue(key1, value1);
    }

    public static FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2)
    {
        return new FloatCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    public static FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3)
    {
        return new FloatCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    public static FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4)
    {
        return new FloatCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
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
    protected char getEmptyValue()
    {
        return EMPTY_VALUE;
    }

    @Override
    protected int getTableSize()
    {
        return this.values.length;
    }

    @Override
    protected char getValueAtIndex(int index)
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

        if (!(obj instanceof FloatCharMap))
        {
            return false;
        }

        FloatCharMap other = (FloatCharMap) obj;

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
            float key = this.keys[i];
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
                result += Float.floatToIntBits(EMPTY_KEY) ^ (int) this.sentinelValues.zeroValue;
            }
            if (this.sentinelValues.containsOneKey)
            {
                result += Float.floatToIntBits(REMOVED_KEY) ^ (int) this.sentinelValues.oneValue;
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                result += Float.floatToIntBits(this.keys[i]) ^ (int) this.values[i];
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
            float key = this.keys[i];
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
    public MutableCharIterator charIterator()
    {
        return new InternalCharIterator();
    }

    @Override
    public <V> V injectInto(V injectedValue, ObjectCharToObjectFunction<? super V, ? extends V> function)
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
    public void put(float key, char value)
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
        float keyAtIndex = this.keys[index];
        if (Float.compare(keyAtIndex, key) == 0)
        {
            this.values[index] = value;
        }
        else
        {
            this.addKeyValueAtIndex(key, value, index);
        }
    }

    private void putForRemovedSentinel(char value)
    {
        if (this.sentinelValues == null)
        {
            this.sentinelValues = new SentinelValues();
        }
        this.addRemovedKeyValue(value);
    }

    private void putForEmptySentinel(char value)
    {
        if (this.sentinelValues == null)
        {
            this.sentinelValues = new SentinelValues();
        }
        this.addEmptyKeyValue(value);
    }

    @Override
    public void putAll(FloatCharMap map)
    {
        map.forEachKeyValue(this::put);
    }

    @Override
    public void removeKey(float key)
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
        if (Float.compare(this.keys[index], key) == 0)
        {
            this.removeKeyAtIndex(index);
        }
    }

    @Override
    public void remove(float key)
    {
        this.removeKey(key);
    }

    @Override
    public char removeKeyIfAbsent(float key, char value)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsZeroKey)
            {
                return value;
            }
            char oldValue = this.sentinelValues.zeroValue;
            this.removeEmptyKey();
            return oldValue;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null || !this.sentinelValues.containsOneKey)
            {
                return value;
            }
            char oldValue = this.sentinelValues.oneValue;
            this.removeRemovedKey();
            return oldValue;
        }
        int index = this.probe(key);
        if (Float.compare(this.keys[index], key) == 0)
        {
            char oldValue = this.values[index];
            this.removeKeyAtIndex(index);
            return oldValue;
        }
        return value;
    }

    @Override
    public char getIfAbsentPut(float key, char value)
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
        if (Float.compare(this.keys[index], key) == 0)
        {
            return this.values[index];
        }
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public char getIfAbsentPut(float key, CharFunction0 function)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                char value = function.value();
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            char value = function.value();
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                char value = function.value();
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            char value = function.value();
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (Float.compare(this.keys[index], key) == 0)
        {
            return this.values[index];
        }
        char value = function.value();
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public <P> char getIfAbsentPutWith(float key, CharFunction<? super P> function, P parameter)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                char value = function.charValueOf(parameter);
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            char value = function.charValueOf(parameter);
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                char value = function.charValueOf(parameter);
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            char value = function.charValueOf(parameter);
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (Float.compare(this.keys[index], key) == 0)
        {
            return this.values[index];
        }
        char value = function.charValueOf(parameter);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public char getIfAbsentPutWithKey(float key, FloatToCharFunction function)
    {
        if (isEmptyKey(key))
        {
            if (this.sentinelValues == null)
            {
                char value = function.valueOf(key);
                this.sentinelValues = new SentinelValues();
                this.addEmptyKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsZeroKey)
            {
                return this.sentinelValues.zeroValue;
            }
            char value = function.valueOf(key);
            this.addEmptyKeyValue(value);
            return value;
        }
        if (isRemovedKey(key))
        {
            if (this.sentinelValues == null)
            {
                char value = function.valueOf(key);
                this.sentinelValues = new SentinelValues();
                this.addRemovedKeyValue(value);
                return value;
            }
            if (this.sentinelValues.containsOneKey)
            {
                return this.sentinelValues.oneValue;
            }
            char value = function.valueOf(key);
            this.addRemovedKeyValue(value);
            return value;
        }
        int index = this.probe(key);
        if (Float.compare(this.keys[index], key) == 0)
        {
            return this.values[index];
        }
        char value = function.valueOf(key);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public char addToValue(float key, char toBeAdded)
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
        if (Float.compare(this.keys[index], key) == 0)
        {
            this.values[index] += toBeAdded;
            return this.values[index];
        }
        this.addKeyValueAtIndex(key, toBeAdded, index);
        return toBeAdded;
    }

    private void addKeyValueAtIndex(float key, char value, int index)
    {
        if (Float.compare(this.keys[index], REMOVED_KEY) == 0)
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
        float[] copy = new float[this.keys.length];
        System.arraycopy(this.keys, 0, copy, 0, this.keys.length);
        this.keys = copy;
        this.copyKeysOnWrite = false;
    }

    @Override
    public char updateValue(float key, char initialValueIfAbsent, CharToCharFunction function)
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
        if (Float.compare(this.keys[index], key) == 0)
        {
            this.values[index] = function.valueOf(this.values[index]);
            return this.values[index];
        }
        char value = function.valueOf(initialValueIfAbsent);
        this.addKeyValueAtIndex(key, value, index);
        return value;
    }

    @Override
    public FloatCharHashMap withKeyValue(float key1, char value1)
    {
        this.put(key1, value1);
        return this;
    }

    public FloatCharHashMap withKeysValues(float key1, char value1, float key2, char value2)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        return this;
    }

    public FloatCharHashMap withKeysValues(float key1, char value1, float key2, char value2, float key3, char value3)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        this.put(key3, value3);
        return this;
    }

    public FloatCharHashMap withKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4)
    {
        this.put(key1, value1);
        this.put(key2, value2);
        this.put(key3, value3);
        this.put(key4, value4);
        return this;
    }

    @Override
    public FloatCharHashMap withoutKey(float key)
    {
        this.removeKey(key);
        return this;
    }

    @Override
    public FloatCharHashMap withoutAllKeys(FloatIterable keys)
    {
        keys.forEach(this::removeKey);
        return this;
    }

    @Override
    public MutableFloatCharMap asUnmodifiable()
    {
        return new UnmodifiableFloatCharMap(this);
    }

    @Override
    public MutableFloatCharMap asSynchronized()
    {
        return new SynchronizedFloatCharMap(this);
    }

    @Override
    public ImmutableFloatCharMap toImmutable()
    {
        return FloatCharMaps.immutable.ofAll(this);
    }

    @Override
    public char get(float key)
    {
        return this.getIfAbsent(key, EMPTY_VALUE);
    }

    @Override
    public char getIfAbsent(float key, char ifAbsent)
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

    private char getForSentinel(float key, char ifAbsent)
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

    private char slowGetIfAbsent(float key, char ifAbsent)
    {
        int index = this.probe(key);
        if (Float.compare(this.keys[index], key) == 0)
        {
            return this.values[index];
        }
        return ifAbsent;
    }

    private char fastGetIfAbsent(float key, char ifAbsent)
    {
        int index = this.mask((int) key);

        for (int i = 0; i < INITIAL_LINEAR_PROBE; i++)
        {
            float keyAtIndex = this.keys[index];
            if (Float.compare(keyAtIndex, key) == 0)
            {
                return this.values[index];
            }
            if (Float.compare(keyAtIndex, EMPTY_KEY) == 0)
            {
                return ifAbsent;
            }
            index = (index + 1) & (this.keys.length - 1);
        }
        return this.slowGetIfAbsentTwo(key, ifAbsent);
    }

    private char slowGetIfAbsentTwo(float key, char ifAbsent)
    {
        int index = this.probeTwo(key, -1);
        if (Float.compare(this.keys[index], key) == 0)
        {
            return this.values[index];
        }
        return ifAbsent;
    }

    @Override
    public char getOrThrow(float key)
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
    public boolean containsKey(float key)
    {
        if (isEmptyKey(key))
        {
            return this.sentinelValues != null && this.sentinelValues.containsZeroKey;
        }
        if (isRemovedKey(key))
        {
            return this.sentinelValues != null && this.sentinelValues.containsOneKey;
        }
        return Float.compare(this.keys[this.probe(key)], key) == 0;
    }

    @Override
    public void forEachKey(FloatProcedure procedure)
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
    public void forEachKeyValue(FloatCharProcedure procedure)
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
    public LazyFloatIterable keysView()
    {
        return new KeysView();
    }

    @Override
    public RichIterable<FloatCharPair> keyValuesView()
    {
        return new KeyValuesView();
    }

    @Override
    public MutableCharFloatMap flipUniqueValues()
    {
        MutableCharFloatMap result = CharFloatMaps.mutable.empty();
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
    public FloatCharHashMap select(FloatCharPredicate predicate)
    {
        FloatCharHashMap result = new FloatCharHashMap();

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
    public FloatCharHashMap reject(FloatCharPredicate predicate)
    {
        FloatCharHashMap result = new FloatCharHashMap();

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
                out.writeFloat(EMPTY_KEY);
                out.writeChar(this.sentinelValues.zeroValue);
            }
            if (this.sentinelValues.containsOneKey)
            {
                out.writeFloat(REMOVED_KEY);
                out.writeChar(this.sentinelValues.oneValue);
            }
        }
        for (int i = 0; i < this.keys.length; i++)
        {
            if (isNonSentinel(this.keys[i]))
            {
                out.writeFloat(this.keys[i]);
                out.writeChar(this.values[i]);
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException
    {
        int size = in.readInt();
        for (int i = 0; i < size; i++)
        {
            this.put(in.readFloat(), in.readChar());
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
        float[] old = this.keys;
        char[] oldValues = this.values;
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
    int probe(float element)
    {
        int index = this.mask((int) element);
        float keyAtIndex = this.keys[index];

        if (Float.compare(keyAtIndex, element) == 0 || Float.compare(keyAtIndex, EMPTY_KEY) == 0)
        {
            return index;
        }

        int removedIndex = Float.compare(keyAtIndex, REMOVED_KEY) == 0 ? index : -1;
        for (int i = 1; i < INITIAL_LINEAR_PROBE; i++)
        {
            int nextIndex = (index + i) & (this.keys.length - 1);
            keyAtIndex = this.keys[nextIndex];
            if (Float.compare(keyAtIndex, element) == 0)
            {
                return nextIndex;
            }
            if (Float.compare(keyAtIndex, EMPTY_KEY) == 0)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (Float.compare(keyAtIndex, REMOVED_KEY) == 0 && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
        return this.probeTwo(element, removedIndex);
    }

    int probeTwo(float element, int removedIndex)
    {
        int index = this.spreadTwoAndMask(element);
        for (int i = 0; i < INITIAL_LINEAR_PROBE; i++)
        {
            int nextIndex = (index + i) & (this.keys.length - 1);
            float keyAtIndex = this.keys[nextIndex];
            if (Float.compare(keyAtIndex, element) == 0)
            {
                return nextIndex;
            }
            if (Float.compare(keyAtIndex, EMPTY_KEY) == 0)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (Float.compare(keyAtIndex, REMOVED_KEY) == 0 && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
        return this.probeThree(element, removedIndex);
    }

    int probeThree(float element, int removedIndex)
    {
        int nextIndex = (int) SpreadFunctions.floatSpreadOne(element);
        int spreadTwo = Integer.reverse(SpreadFunctions.floatSpreadTwo(element)) | 1;

        while (true)
        {
            nextIndex = this.mask(nextIndex + spreadTwo);
            float keyAtIndex = this.keys[nextIndex];
            if (Float.compare(keyAtIndex, element) == 0)
            {
                return nextIndex;
            }
            if (Float.compare(keyAtIndex, EMPTY_KEY) == 0)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (Float.compare(keyAtIndex, REMOVED_KEY) == 0 && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
    }

    // exposed for testing
    int spreadAndMask(float element)
    {
        int code = SpreadFunctions.floatSpreadOne(element);
        return this.mask(code);
    }

    int spreadTwoAndMask(float element)
    {
        int code = SpreadFunctions.floatSpreadTwo(element);
        return this.mask(code);
    }

    private int mask(int spread)
    {
        return spread & (this.keys.length  - 1);
    }

    private void allocateTable(int sizeToAllocate)
    {
        this.keys = new float[sizeToAllocate];
        this.values = new char[sizeToAllocate];
    }

    private static boolean isEmptyKey(float key)
    {
        return Float.compare(key, EMPTY_KEY) == 0;
    }

    private static boolean isRemovedKey(float key)
    {
        return Float.compare(key, REMOVED_KEY) == 0;
    }

    private static boolean isNonSentinel(float key)
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

    private class InternalCharIterator implements MutableCharIterator
    {
        private int count;
        private int position;
        private float lastKey;
        private boolean handledZero;
        private boolean handledOne;
        private boolean canRemove;

        @Override
        public boolean hasNext()
        {
            return this.count < FloatCharHashMap.this.size();
        }

        @Override
        public char next()
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
                if (FloatCharHashMap.this.containsKey(EMPTY_KEY))
                {
                    this.lastKey = EMPTY_KEY;
                    return FloatCharHashMap.this.get(EMPTY_KEY);
                }
            }
            if (!this.handledOne)
            {
                this.handledOne = true;
                if (FloatCharHashMap.this.containsKey(REMOVED_KEY))
                {
                    this.lastKey = REMOVED_KEY;
                    return FloatCharHashMap.this.get(REMOVED_KEY);
                }
            }
            float[] keys = FloatCharHashMap.this.keys;
            while (!isNonSentinel(keys[this.position]))
            {
                this.position++;
            }
            this.lastKey = keys[this.position];
            char result = FloatCharHashMap.this.values[this.position];
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
            FloatCharHashMap.this.removeKey(this.lastKey);
            this.count--;
            this.canRemove = false;
        }
    }

    private class KeysView extends AbstractLazyFloatIterable
    {
        @Override
        public FloatIterator floatIterator()
        {
            return new UnmodifiableFloatIterator(new KeySetIterator());
        }

        /**
         * @since 7.0.
         */
        @Override
        public void each(FloatProcedure procedure)
        {
            FloatCharHashMap.this.forEachKey(procedure);
        }
    }

    private class KeySetIterator implements MutableFloatIterator
    {
        private int count;
        private int position;
        private float lastKey;
        private boolean handledZero;
        private boolean handledOne;
        private boolean canRemove;

        @Override
        public boolean hasNext()
        {
            return this.count < FloatCharHashMap.this.size();
        }

        @Override
        public float next()
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
                if (FloatCharHashMap.this.containsKey(EMPTY_KEY))
                {
                    this.lastKey = EMPTY_KEY;
                    return this.lastKey;
                }
            }
            if (!this.handledOne)
            {
                this.handledOne = true;
                if (FloatCharHashMap.this.containsKey(REMOVED_KEY))
                {
                    this.lastKey = REMOVED_KEY;
                    return this.lastKey;
                }
            }

            float[] keys = FloatCharHashMap.this.keys;
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
            FloatCharHashMap.this.removeKey(this.lastKey);
            this.count--;
            this.canRemove = false;
        }
    }

    @Override
    public MutableFloatSet keySet()
    {
        return new KeySet();
    }

    private class KeySet extends AbstractMutableFloatKeySet
    {
        @Override
        protected MutableFloatKeysMap getOuter()
        {
            return FloatCharHashMap.this;
        }

        @Override
        protected SentinelValues getSentinelValues()
        {
            return FloatCharHashMap.this.sentinelValues;
        }

        @Override
        protected float getKeyAtIndex(int index)
        {
            return FloatCharHashMap.this.keys[index];
        }

        @Override
        protected int getTableSize()
        {
            return FloatCharHashMap.this.keys.length;
        }

        @Override
        public MutableFloatIterator floatIterator()
        {
            return new KeySetIterator();
        }

        @Override
        public boolean retainAll(FloatIterable source)
        {
            int oldSize = FloatCharHashMap.this.size();
            final FloatSet sourceSet = source instanceof FloatSet ? (FloatSet) source : source.toSet();
            FloatCharHashMap retained = FloatCharHashMap.this.select((float key, char value) -> sourceSet.contains(key));
            if (retained.size() != oldSize)
            {
                FloatCharHashMap.this.keys = retained.keys;
                FloatCharHashMap.this.values = retained.values;
                FloatCharHashMap.this.sentinelValues = retained.sentinelValues;
                FloatCharHashMap.this.occupiedWithData = retained.occupiedWithData;
                FloatCharHashMap.this.occupiedWithSentinels = retained.occupiedWithSentinels;
                return true;
            }
            return false;
        }

        @Override
        public boolean retainAll(float... source)
        {
            return this.retainAll(FloatHashSet.newSetWith(source));
        }

        @Override
        public FloatSet freeze()
        {
            FloatCharHashMap.this.copyKeysOnWrite = true;
            boolean containsZeroKey = false;
            boolean containsOneKey = false;
            if (FloatCharHashMap.this.sentinelValues != null)
            {
                containsZeroKey = FloatCharHashMap.this.sentinelValues.containsZeroKey;
                containsOneKey = FloatCharHashMap.this.sentinelValues.containsOneKey;
            }
            return new ImmutableFloatMapKeySet(FloatCharHashMap.this.keys, FloatCharHashMap.this.occupiedWithData, containsZeroKey, containsOneKey);
        }

        /**
         * @since 9.2.
         */
        @Override
        public MutableFloatSet newEmpty()
        {
            return new FloatHashSet();
        }
    }

    @Override
    public MutableCharCollection values()
    {
        return new ValuesCollection();
    }

    private class ValuesCollection extends AbstractCharValuesCollection
    {
        @Override
        public MutableCharIterator charIterator()
        {
            return FloatCharHashMap.this.charIterator();
        }

        @Override
        public boolean remove(char item)
        {
            int oldSize = FloatCharHashMap.this.size();

            if (FloatCharHashMap.this.sentinelValues != null)
            {
                if (FloatCharHashMap.this.sentinelValues.containsZeroKey && item == FloatCharHashMap.this.sentinelValues.zeroValue)
                {
                    FloatCharHashMap.this.removeKey(EMPTY_KEY);
                }
                if (FloatCharHashMap.this.sentinelValues.containsOneKey && item == FloatCharHashMap.this.sentinelValues.oneValue)
                {
                    FloatCharHashMap.this.removeKey(REMOVED_KEY);
                }
            }
            for (int i = 0; i < FloatCharHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(FloatCharHashMap.this.keys[i]) && item == FloatCharHashMap.this.values[i])
                {
                    FloatCharHashMap.this.removeKey(FloatCharHashMap.this.keys[i]);
                }
            }
            return oldSize != FloatCharHashMap.this.size();
        }

        @Override
        public boolean retainAll(CharIterable source)
        {
            int oldSize = FloatCharHashMap.this.size();
            final CharSet sourceSet = source instanceof CharSet ? (CharSet) source : source.toSet();
            FloatCharHashMap retained = FloatCharHashMap.this.select((float key, char value) -> sourceSet.contains(value));
            if (retained.size() != oldSize)
            {
                FloatCharHashMap.this.keys = retained.keys;
                FloatCharHashMap.this.values = retained.values;
                FloatCharHashMap.this.sentinelValues = retained.sentinelValues;
                FloatCharHashMap.this.occupiedWithData = retained.occupiedWithData;
                FloatCharHashMap.this.occupiedWithSentinels = retained.occupiedWithSentinels;
                return true;
            }
            return false;
        }

        /**
         * @since 9.2.
         */
        @Override
        public MutableCharCollection newEmpty()
        {
            return new CharHashBag();
        }
    }

    private class KeyValuesView extends AbstractLazyIterable<FloatCharPair>
    {
        @Override
        public void each(Procedure<? super FloatCharPair> procedure)
        {
            if (FloatCharHashMap.this.sentinelValues != null)
            {
                if (FloatCharHashMap.this.sentinelValues.containsZeroKey)
                {
                    procedure.value(PrimitiveTuples.pair(EMPTY_KEY, FloatCharHashMap.this.sentinelValues.zeroValue));
                }
                if (FloatCharHashMap.this.sentinelValues.containsOneKey)
                {
                    procedure.value(PrimitiveTuples.pair(REMOVED_KEY, FloatCharHashMap.this.sentinelValues.oneValue));
                }
            }
            for (int i = 0; i < FloatCharHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(FloatCharHashMap.this.keys[i]))
                {
                    procedure.value(PrimitiveTuples.pair(FloatCharHashMap.this.keys[i], FloatCharHashMap.this.values[i]));
                }
            }
        }

        @Override
        public void forEachWithIndex(ObjectIntProcedure<? super FloatCharPair> objectIntProcedure)
        {
            int index = 0;
            if (FloatCharHashMap.this.sentinelValues != null)
            {
                if (FloatCharHashMap.this.sentinelValues.containsZeroKey)
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(EMPTY_KEY, FloatCharHashMap.this.sentinelValues.zeroValue), index);
                    index++;
                }
                if (FloatCharHashMap.this.sentinelValues.containsOneKey)
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(REMOVED_KEY, FloatCharHashMap.this.sentinelValues.oneValue), index);
                    index++;
                }
            }
            for (int i = 0; i < FloatCharHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(FloatCharHashMap.this.keys[i]))
                {
                    objectIntProcedure.value(PrimitiveTuples.pair(FloatCharHashMap.this.keys[i], FloatCharHashMap.this.values[i]), index);
                    index++;
                }
            }
        }

        @Override
        public <P> void forEachWith(Procedure2<? super FloatCharPair, ? super P> procedure, P parameter)
        {
            if (FloatCharHashMap.this.sentinelValues != null)
            {
                if (FloatCharHashMap.this.sentinelValues.containsZeroKey)
                {
                    procedure.value(PrimitiveTuples.pair(EMPTY_KEY, FloatCharHashMap.this.sentinelValues.zeroValue), parameter);
                }
                if (FloatCharHashMap.this.sentinelValues.containsOneKey)
                {
                    procedure.value(PrimitiveTuples.pair(REMOVED_KEY, FloatCharHashMap.this.sentinelValues.oneValue), parameter);
                }
            }
            for (int i = 0; i < FloatCharHashMap.this.keys.length; i++)
            {
                if (isNonSentinel(FloatCharHashMap.this.keys[i]))
                {
                    procedure.value(PrimitiveTuples.pair(FloatCharHashMap.this.keys[i], FloatCharHashMap.this.values[i]), parameter);
                }
            }
        }

        @Override
        public Iterator<FloatCharPair> iterator()
        {
            return new InternalKeyValuesIterator();
        }

        public class InternalKeyValuesIterator implements Iterator<FloatCharPair>
        {
            private int count;
            private int position;
            private boolean handledZero;
            private boolean handledOne;

            @Override
            public FloatCharPair next()
            {
                if (!this.hasNext())
                {
                    throw new NoSuchElementException("next() called, but the iterator is exhausted");
                }
                this.count++;

                if (!this.handledZero)
                {
                    this.handledZero = true;
                    if (FloatCharHashMap.this.containsKey(EMPTY_KEY))
                    {
                        return PrimitiveTuples.pair(EMPTY_KEY, FloatCharHashMap.this.sentinelValues.zeroValue);
                    }
                }
                if (!this.handledOne)
                {
                    this.handledOne = true;
                    if (FloatCharHashMap.this.containsKey(REMOVED_KEY))
                    {
                        return PrimitiveTuples.pair(REMOVED_KEY, FloatCharHashMap.this.sentinelValues.oneValue);
                    }
                }

                float[] keys = FloatCharHashMap.this.keys;
                while (!isNonSentinel(keys[this.position]))
                {
                    this.position++;
                }
                FloatCharPair result = PrimitiveTuples.pair(keys[this.position], FloatCharHashMap.this.values[this.position]);
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
                return this.count != FloatCharHashMap.this.size();
            }
        }
    }
}

