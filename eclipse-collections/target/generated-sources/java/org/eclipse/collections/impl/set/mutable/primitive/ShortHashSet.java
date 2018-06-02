/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.mutable.primitive;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableShortSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.factory.primitive.ShortSets;
import org.eclipse.collections.impl.set.immutable.primitive.ImmutableShortSetSerializationProxy;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.SpreadFunctions;
import org.eclipse.collections.impl.set.immutable.primitive.AbstractImmutableShortSet;
import org.eclipse.collections.impl.set.primitive.AbstractShortSet;

/**
 * This file was automatically generated from template file primitiveHashSet.stg.
 *
 * @since 3.0.
 */
public class ShortHashSet extends AbstractShortSet implements MutableShortSet, Externalizable
{
    private static final long serialVersionUID = 1L;
    private static final int OCCUPIED_DATA_RATIO = 2;
    private static final int OCCUPIED_SENTINEL_RATIO = 4;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final short EMPTY = (short) 0;
    private static final short REMOVED = (short) 1;
    private static final int CACHE_LINE_SIZE = 64;
    private static final int KEY_SIZE = 2;
    private static final int INITIAL_LINEAR_PROBE = CACHE_LINE_SIZE / KEY_SIZE / 2; /* half a cache line */

    private short[] table;
    private int occupiedWithData;
    private int occupiedWithSentinels;
    // The 32 bits of this integer indicate whether the items (short) 0 to (short) 31 are present in the set.
    private int zeroToThirtyOne;
    private int zeroToThirtyOneOccupied;
    private transient boolean copyOnWrite;

    public ShortHashSet()
    {
        this.allocateTable(DEFAULT_INITIAL_CAPACITY);
    }

    public ShortHashSet(int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            throw new IllegalArgumentException("initial capacity cannot be less than 0");
        }
        int capacity = this.smallestPowerOfTwoGreaterThan(this.fastCeil(initialCapacity * OCCUPIED_DATA_RATIO));
        this.allocateTable(capacity);
    }

    public ShortHashSet(short... elements)
    {
        this();
        this.addAll(elements);
    }

    public ShortHashSet(ShortHashSet set)
    {
        this.occupiedWithData = set.occupiedWithData;
        this.occupiedWithSentinels = set.occupiedWithSentinels;
        this.zeroToThirtyOneOccupied = set.zeroToThirtyOneOccupied;
        this.zeroToThirtyOne = set.zeroToThirtyOne;
        this.allocateTable(set.table.length);

        System.arraycopy(set.table, 0, this.table, 0, set.table.length);
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

    public static ShortHashSet newSet(ShortIterable source)
    {
        if (source instanceof ShortHashSet)
        {
            return new ShortHashSet((ShortHashSet) source);
        }

        return ShortHashSet.newSetWith(source.toArray());
    }

    public static ShortHashSet newSetWith(short... source)
    {
        return new ShortHashSet(source);
    }

    private static boolean isBetweenZeroAndThirtyOne(short value)
    {
        return value >= (short) 0 && value <= (short) 31;
    }

    @Override
    public int hashCode()
    {
        int result = 0;
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            result += (int) value;
            zeroToThirtyOne &= ~(1 << value);
        }
        if (this.table != null)
        {
            for (int i = 0; i < this.table.length; i++)
            {
                if (isNonSentinel(this.table[i]))
                {
                    result += (int) this.table[i];
                }
            }
        }
        return result;
    }

    @Override
    public int size()
    {
        return this.occupiedWithData + this.zeroToThirtyOneOccupied;
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        try
        {
            appendable.append(start);

            int count = 0;
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                if (count > 0)
                {
                    appendable.append(separator);
                }
                count++;
                appendable.append(String.valueOf(value));
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    if (count > 0)
                    {
                        appendable.append(separator);
                    }
                    count++;
                    appendable.append(String.valueOf(value));
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
    public boolean add(short element)
    {
        if (isBetweenZeroAndThirtyOne(element))
        {
            int initial = this.zeroToThirtyOne;
            this.zeroToThirtyOne |= 1 << element;
            if (this.zeroToThirtyOne != initial)
            {
                this.zeroToThirtyOneOccupied++;
                return true;
            }
            return false;
        }

        int index = this.probe(element);

        if (this.table[index] == element)
        {
            // element already present in set
            return false;
        }

        if (this.copyOnWrite)
        {
            this.copyTable();
        }
        if (this.table[index] == REMOVED)
        {
            --this.occupiedWithSentinels;
        }
        this.table[index] = element;
        ++this.occupiedWithData;
        if (this.occupiedWithData > this.maxOccupiedWithData())
        {
            this.rehashAndGrow();
        }
        return true;
    }

    @Override
    public boolean addAll(short... source)
    {
        int oldSize = this.size();
        for (short item : source)
        {
            this.add(item);
        }
        return this.size() != oldSize;
    }

    @Override
    public boolean addAll(ShortIterable source)
    {
        if (source.isEmpty())
        {
            return false;
        }
        int oldSize = this.size();
        if (source instanceof ShortHashSet)
        {
            ShortHashSet hashSet = (ShortHashSet) source;
            this.zeroToThirtyOne |= hashSet.zeroToThirtyOne;
            this.zeroToThirtyOneOccupied = Integer.bitCount(this.zeroToThirtyOne);
            for (short item : hashSet.table)
            {
                if (isNonSentinel(item))
                {
                    this.add(item);
                }
            }
        }
        else
        {
            ShortIterator iterator = source.shortIterator();
            while (iterator.hasNext())
            {
                short item = iterator.next();
                this.add(item);
            }
        }
        return this.size() != oldSize;
    }

    @Override
    public boolean remove(short value)
    {
        if (isBetweenZeroAndThirtyOne(value))
        {
            return this.removeZeroToThirtyOne(value);
        }
        int index = this.probe(value);
        if (this.table[index] == value)
        {
            if (this.copyOnWrite)
            {
                this.copyTable();
            }
            this.table[index] = REMOVED;
            this.occupiedWithData--;
            this.occupiedWithSentinels++;
            if (this.occupiedWithSentinels > this.maxOccupiedWithSentinels())
            {
                this.rehash();
            }

            return true;
        }
        return false;
    }

    private boolean removeZeroToThirtyOne(short value)
    {
        int initial = this.zeroToThirtyOne;
        this.zeroToThirtyOne &= ~(1 << value);
        if (this.zeroToThirtyOne == initial)
        {
            return false;
        }
        this.zeroToThirtyOneOccupied--;
        return true;
    }

    @Override
    public boolean removeAll(ShortIterable source)
    {
        if (source.isEmpty())
        {
            return false;
        }
        int oldSize = this.size();
        if (source instanceof ShortHashSet)
        {
            ShortHashSet hashSet = (ShortHashSet) source;
            this.zeroToThirtyOne &= ~hashSet.zeroToThirtyOne;
            this.zeroToThirtyOneOccupied = Integer.bitCount(this.zeroToThirtyOne);
            for (short item : hashSet.table)
            {
                if (isNonSentinel(item))
                {
                    this.remove(item);
                }
            }
        }
        else
        {
            ShortIterator iterator = source.shortIterator();
            while (iterator.hasNext())
            {
                short item = iterator.next();
                this.remove(item);
            }
        }
        return this.size() != oldSize;
    }

    @Override
    public boolean removeAll(short... source)
    {
        if (source.length == 0)
        {
            return false;
        }
        int oldSize = this.size();
        for (short item : source)
        {
            this.remove(item);
        }
        return this.size() != oldSize;
    }

    @Override
    public boolean retainAll(ShortIterable source)
    {
        int oldSize = this.size();
        final ShortSet sourceSet = source instanceof ShortSet ? (ShortSet) source : source.toSet();
        ShortHashSet retained = this.select(sourceSet::contains);
        if (retained.size() != oldSize)
        {
            this.zeroToThirtyOne = retained.zeroToThirtyOne;
            this.zeroToThirtyOneOccupied = retained.zeroToThirtyOneOccupied;
            this.occupiedWithData = retained.occupiedWithData;
            this.occupiedWithSentinels = retained.occupiedWithSentinels;
            this.table = retained.table;
            return true;
        }
        return false;
    }

    @Override
    public boolean retainAll(short... source)
    {
        return this.retainAll(ShortHashSet.newSetWith(source));
    }

    @Override
    public void clear()
    {
        this.zeroToThirtyOneOccupied = 0;
        this.occupiedWithData = 0;
        this.occupiedWithSentinels = 0;

        this.zeroToThirtyOne = 0;
        if (this.copyOnWrite)
        {
            this.table = new short[this.table.length];
            this.copyOnWrite = false;
        }
        else
        {
            Arrays.fill(this.table, EMPTY);
        }
    }

    @Override
    public ShortHashSet with(short element)
    {
        this.add(element);
        return this;
    }

    @Override
    public ShortHashSet without(short element)
    {
        this.remove(element);
        return this;
    }

    @Override
    public ShortHashSet withAll(ShortIterable elements)
    {
        this.addAll(elements.toArray());
        return this;
    }

    @Override
    public ShortHashSet withoutAll(ShortIterable elements)
    {
        this.removeAll(elements);
        return this;
    }

    @Override
    public MutableShortSet asUnmodifiable()
    {
        return new UnmodifiableShortSet(this);
    }

    @Override
    public MutableShortSet asSynchronized()
    {
        return new SynchronizedShortSet(this);
    }

    @Override
    public ImmutableShortSet toImmutable()
    {
        if (this.size() == 0)
        {
            return ShortSets.immutable.with();
        }
        if (this.size() == 1)
        {
            return ShortSets.immutable.with(this.shortIterator().next());
        }
        ShortHashSet mutableSet = ShortHashSet.newSetWith(this.toArray());
        return new ImmutableShortHashSet(mutableSet.table, mutableSet.occupiedWithData, mutableSet.zeroToThirtyOne, mutableSet.zeroToThirtyOneOccupied);
    }

    @Override
    public MutableShortIterator shortIterator()
    {
        return new InternalShortIterator();
    }

    @Override
    public short[] toArray()
    {
        short[] array = new short[this.size()];

        int j = 0;
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            array[j] = value;
            j++;
            zeroToThirtyOne &= ~(1 << value);
        }

        for (int i = 0; i < this.table.length && j < this.size(); i++)
        {
            if (isNonSentinel(this.table[i]))
            {
                array[j] = this.table[i];
                j++;
            }
        }
        return array;
    }

    @Override
    public boolean contains(short value)
    {
        if (isBetweenZeroAndThirtyOne(value))
        {
            int temp = this.zeroToThirtyOne;
            return ((temp >>> value) & 1) != 0;
        }
        return this.table[this.probe(value)] == value;
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
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            procedure.value(value);
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                procedure.value(value);
            }
        }
    }

    @Override
    public ShortHashSet select(ShortPredicate predicate)
    {
        return this.select(predicate, new ShortHashSet());
    }

    /**
     * @since 8.1.
     */
    @Override
    public <R extends MutableShortCollection> R select(ShortPredicate predicate, R target)
    {
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            if (predicate.accept(value))
            {
                target.add(value);
            }
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                if (predicate.accept(value))
                {
                    target.add(value);
                }
            }
        }
        return target;
    }

    @Override
    public ShortHashSet reject(ShortPredicate predicate)
    {
        return this.reject(predicate, new ShortHashSet());
    }

    /**
     * @since 8.1.
     */
    @Override
    public <R extends MutableShortCollection> R reject(ShortPredicate predicate, R target)
    {
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            if (!predicate.accept(value))
            {
                target.add(value);
            }
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                if (!predicate.accept(value))
                {
                    target.add(value);
                }
            }
        }
        return target;
    }

    @Override
    public <V> MutableSet<V> collect(ShortToObjectFunction<? extends V> function)
    {
        return this.collect(function, UnifiedSet.newSet(this.size()));
    }

    /**
     * @since 8.1.
     */
    @Override
    public <V, R extends Collection<V>> R collect(ShortToObjectFunction<? extends V> function, R target)
    {
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            target.add(function.valueOf(value));
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                target.add(function.valueOf(value));
            }
        }
        return target;
    }

    @Override
    public short detectIfNone(ShortPredicate predicate, short ifNone)
    {
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            if (predicate.accept(value))
            {
                return value;
            }
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                if (predicate.accept(value))
                {
                    return value;
                }
            }
        }
        return ifNone;
    }

    @Override
    public int count(ShortPredicate predicate)
    {
        int count = 0;
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            if (predicate.accept(value))
            {
                count++;
            }
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                if (predicate.accept(value))
                {
                    count++;
                }
            }
        }
        return count;
    }

    @Override
    public boolean anySatisfy(ShortPredicate predicate)
    {
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            if (predicate.accept(value))
            {
                return true;
            }
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                if (predicate.accept(value))
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean allSatisfy(ShortPredicate predicate)
    {
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            if (!predicate.accept(value))
            {
                return false;
            }
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                if (!predicate.accept(value))
                {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean noneSatisfy(ShortPredicate predicate)
    {
        return !this.anySatisfy(predicate);
    }

    @Override
    public long sum()
    {
        long result = 0L;

        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            result += value;
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                result += value;
            }
        }
        return result;
    }

    @Override
    public short max()
    {
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }
        short max = (short) (31 - Integer.numberOfLeadingZeros(this.zeroToThirtyOne));
        boolean isMaxSet = this.zeroToThirtyOneOccupied != 0;

        for (short value : this.table)
        {
            if (isNonSentinel(value) && (!isMaxSet || max < value))
            {
                max = value;
                isMaxSet = true;
            }
        }
        return max;
    }

    @Override
    public short min()
    {
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }
        short min = (short) Integer.numberOfTrailingZeros(this.zeroToThirtyOne);
        boolean isMinSet = this.zeroToThirtyOneOccupied != 0;

        for (short value : this.table)
        {
            if (isNonSentinel(value) && (!isMinSet || value < min))
            {
                min = value;
                isMinSet = true;
            }
        }
        return min;
    }

    @Override
    public ShortSet freeze()
    {
        if (this.size() == 0)
        {
            return ShortSets.immutable.with();
        }
        if (this.size() == 1)
        {
            return ShortSets.immutable.with(this.shortIterator().next());
        }
        this.copyOnWrite = true;
        return new ImmutableShortHashSet(this.table, this.occupiedWithData, this.zeroToThirtyOne, this.zeroToThirtyOneOccupied);
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException
    {
        out.writeInt(this.size());

        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            out.writeShort(value);
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                out.writeShort(value);
            }
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException
    {
        int size = in.readInt();

        for (int i = 0; i < size; i++)
        {
            this.add(in.readShort());
        }
    }

    @Override
    public <T> T injectInto(T injectedValue, ObjectShortToObjectFunction<? super T, ? extends T> function)
    {
        T result = injectedValue;
        int zeroToThirtyOne = this.zeroToThirtyOne;
        while (zeroToThirtyOne != 0)
        {
            short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
            result = function.valueOf(result, value);
            zeroToThirtyOne &= ~(1 << value);
        }

        for (short value : this.table)
        {
            if (isNonSentinel(value))
            {
                result = function.valueOf(result, value);
            }
        }
        return result;
    }

    @Override
    public RichIterable<ShortIterable> chunk(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size for groups must be positive but was: " + size);
        }
        MutableList<ShortIterable> result = Lists.mutable.empty();
        if (this.notEmpty())
        {
            if (this.size() <= size)
            {
                result.add(ShortSets.mutable.withAll(this));
            }
            else
            {
                ShortIterator iterator = this.shortIterator();
                while (iterator.hasNext())
                {
                    MutableShortSet batch = ShortSets.mutable.empty();
                    for (int i = 0; i < size && iterator.hasNext(); i++)
                    {
                        batch.add(iterator.next());
                    }
                    result.add(batch);
                }
            }
        }
        return result;
    }

    /**
     * Creates a new empty ShortHashSet.
     *
     * @since 9.2.
     */
    public ShortHashSet newEmpty()
    {
        return new ShortHashSet();
    }

    /**
     * Rehashes every element in the set into a new backing table of the smallest possible size and eliminating removed sentinels.
     */
    public void compact()
    {
        this.rehash(this.smallestPowerOfTwoGreaterThan(this.size()));
    }

    private void rehash()
    {
        this.rehash(this.table.length);
    }

    private void rehashAndGrow()
    {
        this.rehash(this.table.length << 1);
    }

    private void rehash(int newCapacity)
    {
        int oldLength = this.table.length;
        short[] old = this.table;
        this.allocateTable(newCapacity);
        this.occupiedWithData = 0;
        this.occupiedWithSentinels = 0;

        for (int i = 0; i < oldLength; i++)
        {
            if (isNonSentinel(old[i]))
            {
                this.add(old[i]);
            }
        }
    }

    private void allocateTable(int sizeToAllocate)
    {
        this.table = new short[sizeToAllocate];
    }

    // exposed for testing
    int probe(short element)
    {
        int index = this.spreadAndMask(element);
        short valueAtIndex = this.table[index];

        if (valueAtIndex == element || valueAtIndex == EMPTY)
        {
            return index;
        }

        int removedIndex = valueAtIndex == REMOVED ? index : -1;
        for (int i = 1; i < INITIAL_LINEAR_PROBE; i++)
        {
            int nextIndex = (index + i) & (this.table.length - 1);
            valueAtIndex = this.table[nextIndex];
            if (valueAtIndex == element)
            {
                return nextIndex;
            }
            if (valueAtIndex == EMPTY)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (valueAtIndex == REMOVED && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
        return this.probeTwo(element, removedIndex);
    }

    int probeTwo(short element, int removedIndex)
    {
        int index = this.spreadTwoAndMask(element);
        for (int i = 0; i < INITIAL_LINEAR_PROBE; i++)
        {
            int nextIndex = (index + i) & (this.table.length - 1);
            short valueAtIndex = this.table[nextIndex];
            if (valueAtIndex == element)
            {
                return nextIndex;
            }
            if (valueAtIndex == EMPTY)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (valueAtIndex == REMOVED && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
        return this.probeThree(element, removedIndex);
    }

    int probeThree(short element, int removedIndex)
    {
        int nextIndex = Integer.reverse(SpreadFunctions.shortSpreadOne(element));
        int spreadTwo = Integer.reverse(SpreadFunctions.shortSpreadTwo(element)) | 1;

        while (true)
        {
            nextIndex = this.mask(nextIndex + spreadTwo);
            short valueAtIndex = this.table[nextIndex];
            if (valueAtIndex == element)
            {
                return nextIndex;
            }
            if (valueAtIndex == EMPTY)
            {
                return removedIndex == -1 ? nextIndex : removedIndex;
            }
            if (valueAtIndex == REMOVED && removedIndex == -1)
            {
                removedIndex = nextIndex;
            }
        }
    }

    // exposed for testing
    int spreadAndMask(short element)
    {
        int code = SpreadFunctions.shortSpreadOne(element);
        return this.mask(code);
    }

    int spreadTwoAndMask(short element)
    {
        int code = SpreadFunctions.shortSpreadTwo(element);
        return this.mask(code);
    }

    private int mask(int spread)
    {
        return spread & (this.table.length - 1);
    }

    private void copyTable()
    {
        this.copyOnWrite = false;
        short[] copy = new short[this.table.length];
        System.arraycopy(this.table, 0, copy, 0, this.table.length);
        this.table = copy;
    }

    private int maxOccupiedWithData()
    {
        int capacity = this.table.length;
        // need at least one free slot for open addressing
        return Math.min(capacity - 1, capacity / OCCUPIED_DATA_RATIO);
    }

    private int maxOccupiedWithSentinels()
    {
        return this.table.length / OCCUPIED_SENTINEL_RATIO;
    }

    private static boolean isNonSentinel(short value)
    {
        return value != EMPTY && value != REMOVED;
    }

    private static final class ImmutableShortHashSet extends AbstractImmutableShortSet implements Serializable
    {
        private static final long serialVersionUID = 1L;
        private final short[] table;
        private final int occupied;
        // The 32 bits of this integer indicate whether the items (short) 0 to (short) 31 are present in the set.
        private final int zeroToThirtyOne;
        private final int zeroToThirtyOneOccupied;

        private ImmutableShortHashSet(short[] table, int occupied, int zeroToThirtyOne, int zeroToThirtyOneOccupied)
        {
            this.checkOptimizedSize(occupied + zeroToThirtyOneOccupied);
            this.occupied = occupied;
            this.zeroToThirtyOneOccupied = zeroToThirtyOneOccupied;
            this.zeroToThirtyOne = zeroToThirtyOne;
            this.table = table;
        }

        private void checkOptimizedSize(int length)
        {
            if (length <= 1)
            {
                throw new IllegalArgumentException("Use ShortSets.immutable.with() to instantiate an optimized collection");
            }
        }

        public static ImmutableShortSet newSetWith(short... elements)
        {
            return ShortHashSet.newSetWith(elements).toImmutable();
        }

        @Override
        public int hashCode()
        {
            int result = 0;
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                result += (int) value;
                zeroToThirtyOne &= ~(1 << value);
            }
            if (this.table != null)
            {
                for (int i = 0; i < this.table.length; i++)
                {
                    if (isNonSentinel(this.table[i]))
                    {
                        result += (int) this.table[i];
                    }
                }
            }
            return result;
        }

        @Override
        public int size()
        {
            return this.occupied + this.zeroToThirtyOneOccupied;
        }

        @Override
        public void appendString(Appendable appendable, String start, String separator, String end)
        {
            try
            {
                appendable.append(start);

                int count = 0;
                int zeroToThirtyOne = this.zeroToThirtyOne;
                while (zeroToThirtyOne != 0)
                {
                    short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                    if (count > 0)
                    {
                        appendable.append(separator);
                    }
                    count++;
                    appendable.append(String.valueOf(value));
                    zeroToThirtyOne &= ~(1 << value);
                }

                for (short value : this.table)
                {
                    if (isNonSentinel(value))
                    {
                        if (count > 0)
                        {
                            appendable.append(separator);
                        }
                        count++;
                        appendable.append(String.valueOf(value));
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
        public ShortIterator shortIterator()
        {
            return new InternalShortIterator();
        }

        @Override
        public short[] toArray()
        {
            short[] array = new short[this.size()];

            int j = 0;
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                array[j] = value;
                j++;
                zeroToThirtyOne &= ~(1 << value);
            }

            for (int i = 0; i < this.table.length && j < this.size(); i++)
            {
                if (isNonSentinel(this.table[i]))
                {
                    array[j] = this.table[i];
                    j++;
                }
            }
            return array;
        }

        @Override
        public boolean contains(short value)
        {
            if (isBetweenZeroAndThirtyOne(value))
            {
                int temp = this.zeroToThirtyOne;
                return ((temp >>> value) & 1) != 0;
            }
            return this.table[this.probe(value)] == value;
        }

        @Override
        public void forEach(ShortProcedure procedure)
        {
            this.each(procedure);
        }

        @Override
        public void each(ShortProcedure procedure)
        {
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                procedure.value(value);
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    procedure.value(value);
                }
            }
        }

        @Override
        public ImmutableShortSet select(ShortPredicate predicate)
        {
            return this.select(predicate, new ShortHashSet()).toImmutable();
        }

        @Override
        public ImmutableShortSet reject(ShortPredicate predicate)
        {
            return this.reject(predicate, new ShortHashSet()).toImmutable();
        }

        @Override
        public <V> ImmutableSet<V> collect(ShortToObjectFunction<? extends V> function)
        {
            MutableSet<V> set = this.collect(function, UnifiedSet.newSet(this.size()));
            return set.toImmutable();
        }

        @Override
        public short detectIfNone(ShortPredicate predicate, short ifNone)
        {
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                if (predicate.accept(value))
                {
                    return value;
                }
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    if (predicate.accept(value))
                    {
                        return value;
                    }
                }
            }
            return ifNone;
        }

        @Override
        public int count(ShortPredicate predicate)
        {
            int count = 0;
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                if (predicate.accept(value))
                {
                    count++;
                }
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    if (predicate.accept(value))
                    {
                        count++;
                    }
                }
            }
            return count;
        }

        @Override
        public boolean anySatisfy(ShortPredicate predicate)
        {
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                if (predicate.accept(value))
                {
                    return true;
                }
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    if (predicate.accept(value))
                    {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public boolean allSatisfy(ShortPredicate predicate)
        {
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                if (!predicate.accept(value))
                {
                    return false;
                }
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    if (!predicate.accept(value))
                    {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public boolean noneSatisfy(ShortPredicate predicate)
        {
            return !this.anySatisfy(predicate);
        }

        @Override
        public long sum()
        {
            long result = 0L;

            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                result += value;
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    result += value;
                }
            }
            return result;
        }

        @Override
        public short max()
        {
            if (this.isEmpty())
            {
                throw new NoSuchElementException();
            }
            short max = (short) (31 - Integer.numberOfLeadingZeros(this.zeroToThirtyOne));
            boolean isMaxSet = this.zeroToThirtyOneOccupied != 0;

            for (short value : this.table)
            {
                if (isNonSentinel(value) && (!isMaxSet || max < value))
                {
                    max = value;
                    isMaxSet = true;
                }
            }
            return max;
        }

        @Override
        public short min()
        {
            if (this.isEmpty())
            {
                throw new NoSuchElementException();
            }
            short min = (short) Integer.numberOfTrailingZeros(this.zeroToThirtyOne);
            boolean isMinSet = this.zeroToThirtyOneOccupied != 0;

            for (short value : this.table)
            {
                if (isNonSentinel(value) && (!isMinSet || value < min))
                {
                    min = value;
                    isMinSet = true;
                }
            }
            return min;
        }

        @Override
        public <T> T injectInto(T injectedValue, ObjectShortToObjectFunction<? super T, ? extends T> function)
        {
            T result = injectedValue;
            int zeroToThirtyOne = this.zeroToThirtyOne;
            while (zeroToThirtyOne != 0)
            {
                short value = (short) Integer.numberOfTrailingZeros(zeroToThirtyOne);
                result = function.valueOf(result, value);
                zeroToThirtyOne &= ~(1 << value);
            }

            for (short value : this.table)
            {
                if (isNonSentinel(value))
                {
                    result = function.valueOf(result, value);
                }
            }
            return result;
        }

        private Object writeReplace()
        {
            return new ImmutableShortSetSerializationProxy(this);
        }

        // exposed for testing
        int probe(short element)
        {
            int index = this.spreadAndMask(element);
            short valueAtIndex = this.table[index];

            if (valueAtIndex == element || valueAtIndex == EMPTY)
            {
                return index;
            }

            int removedIndex = valueAtIndex == REMOVED ? index : -1;
            for (int i = 1; i < INITIAL_LINEAR_PROBE; i++)
            {
                int nextIndex = (index + i) & (this.table.length - 1);
                valueAtIndex = this.table[nextIndex];
                if (valueAtIndex == element)
                {
                    return nextIndex;
                }
                if (valueAtIndex == EMPTY)
                {
                    return removedIndex == -1 ? nextIndex : removedIndex;
                }
                if (valueAtIndex == REMOVED && removedIndex == -1)
                {
                    removedIndex = nextIndex;
                }
            }
            return this.probeTwo(element, removedIndex);
        }

        int probeTwo(short element, int removedIndex)
        {
            int index = this.spreadTwoAndMask(element);
            for (int i = 0; i < INITIAL_LINEAR_PROBE; i++)
            {
                int nextIndex = (index + i) & (this.table.length - 1);
                short valueAtIndex = this.table[nextIndex];
                if (valueAtIndex == element)
                {
                    return nextIndex;
                }
                if (valueAtIndex == EMPTY)
                {
                    return removedIndex == -1 ? nextIndex : removedIndex;
                }
                if (valueAtIndex == REMOVED && removedIndex == -1)
                {
                    removedIndex = nextIndex;
                }
            }
            return this.probeThree(element, removedIndex);
        }

        int probeThree(short element, int removedIndex)
        {
            int nextIndex = Integer.reverse(SpreadFunctions.shortSpreadOne(element));
            int spreadTwo = Integer.reverse(SpreadFunctions.shortSpreadTwo(element)) | 1;

            while (true)
            {
                nextIndex = this.mask(nextIndex + spreadTwo);
                short valueAtIndex = this.table[nextIndex];
                if (valueAtIndex == element)
                {
                    return nextIndex;
                }
                if (valueAtIndex == EMPTY)
                {
                    return removedIndex == -1 ? nextIndex : removedIndex;
                }
                if (valueAtIndex == REMOVED && removedIndex == -1)
                {
                    removedIndex = nextIndex;
                }
            }
        }

        // exposed for testing
        int spreadAndMask(short element)
        {
            int code = SpreadFunctions.shortSpreadOne(element);
            return this.mask(code);
        }

        int spreadTwoAndMask(short element)
        {
            int code = SpreadFunctions.shortSpreadTwo(element);
            return this.mask(code);
        }

        private int mask(int spread)
        {
            return spread & (this.table.length - 1);
        }

        private class InternalShortIterator implements ShortIterator
        {
            private int count;
            private int position;
            private short zeroToThirtyOne;

            public boolean hasNext()
            {
                return this.count < ImmutableShortHashSet.this.size();
            }

            public short next()
            {
                if (!this.hasNext())
                {
                    throw new NoSuchElementException("next() called, but the iterator is exhausted");
                }
                this.count++;

                while (this.zeroToThirtyOne < 32)
                {
                    if (ImmutableShortHashSet.this.contains(this.zeroToThirtyOne))
                    {
                        short result = this.zeroToThirtyOne;
                        this.zeroToThirtyOne++;
                        return result;
                    }
                    this.zeroToThirtyOne++;
                }

                short[] table = ImmutableShortHashSet.this.table;
                while (!isNonSentinel(table[this.position]))
                {
                    this.position++;
                }
                short result = table[this.position];
                this.position++;
                return result;
            }
        }
    }

    private class InternalShortIterator implements MutableShortIterator
    {
        private int count;
        private int position;
        private short zeroToThirtyOne;

        @Override
        public boolean hasNext()
        {
            return this.count < ShortHashSet.this.size();
        }

        @Override
        public short next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException("next() called, but the iterator is exhausted");
            }
            this.count++;

            while (this.zeroToThirtyOne < 32)
            {
                if (ShortHashSet.this.contains(this.zeroToThirtyOne))
                {
                    short result = this.zeroToThirtyOne;
                    this.zeroToThirtyOne++;
                    return result;
                }
                this.zeroToThirtyOne++;
            }

            short[] table = ShortHashSet.this.table;
            while (!isNonSentinel(table[this.position]))
            {
                this.position++;
            }
            short result = table[this.position];
            this.position++;
            return result;
        }

        @Override
        public void remove()
        {
            if (this.count == 0)
            {
                throw new IllegalStateException();
            }
            short removeValue;
            if (this.zeroToThirtyOne <= (short) 32 && this.position == 0)
            {
                if (ShortHashSet.this.zeroToThirtyOne != (ShortHashSet.this.zeroToThirtyOne | 1 << (this.zeroToThirtyOne - 1)))
                {
                    throw new IllegalStateException();
                }
                removeValue = (short) (this.zeroToThirtyOne - 1);
            }
            else if (ShortHashSet.this.table[this.position - 1] == REMOVED)
            {
                throw new IllegalStateException();
            }
            else
            {
                removeValue = ShortHashSet.this.table[this.position - 1];
            }
            if (ShortHashSet.isBetweenZeroAndThirtyOne(removeValue))
            {
                ShortHashSet.this.removeZeroToThirtyOne(removeValue);
            }
            else if (ShortHashSet.this.table[this.position - 1] == removeValue)
            {
                if (ShortHashSet.this.copyOnWrite)
                {
                    ShortHashSet.this.copyTable();
                }
                ShortHashSet.this.table[position - 1] = REMOVED;
                ShortHashSet.this.occupiedWithData--;
                ShortHashSet.this.occupiedWithSentinels++;
            }

            this.count--;
        }
    }
}
