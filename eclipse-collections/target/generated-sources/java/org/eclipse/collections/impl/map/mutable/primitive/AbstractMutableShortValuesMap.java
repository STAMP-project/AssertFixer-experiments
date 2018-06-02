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

import java.io.IOException;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectShortToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.ShortPredicate;
import org.eclipse.collections.api.block.procedure.primitive.ShortProcedure;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.collection.primitive.ImmutableShortCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableShortList;
import org.eclipse.collections.api.map.primitive.MutableShortValuesMap;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.collection.mutable.primitive.SynchronizedShortCollection;
import org.eclipse.collections.impl.collection.mutable.primitive.UnmodifiableShortCollection;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.lazy.primitive.LazyShortIterableAdapter;
import org.eclipse.collections.impl.primitive.AbstractShortIterable;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;

/**
 * This file was automatically generated from template file abstractMutablePrimitiveValuesMap.stg.
 *
 * @since 6.0.
 */
public abstract class AbstractMutableShortValuesMap extends AbstractShortIterable implements MutableShortValuesMap
{
    protected abstract int getOccupiedWithData();

    protected abstract SentinelValues getSentinelValues();

    protected abstract void setSentinelValuesNull();

    protected abstract short getEmptyValue();

    protected abstract short getValueAtIndex(int index);

    protected abstract int getTableSize();

    protected abstract boolean isNonSentinelAtIndex(int index);

    protected void addEmptyKeyValue(short value)
    {
        this.getSentinelValues().containsZeroKey = true;
        this.getSentinelValues().zeroValue = value;
    }

    protected void removeEmptyKey()
    {
        if (this.getSentinelValues().containsOneKey)
        {
            this.getSentinelValues().containsZeroKey = false;
            this.getSentinelValues().zeroValue = this.getEmptyValue();
        }
        else
        {
            this.setSentinelValuesNull();
        }
    }

    protected void addRemovedKeyValue(short value)
    {
        this.getSentinelValues().containsOneKey = true;
        this.getSentinelValues().oneValue = value;
    }

    protected void removeRemovedKey()
    {
        if (this.getSentinelValues().containsZeroKey)
        {
            this.getSentinelValues().containsOneKey = false;
            this.getSentinelValues().oneValue = this.getEmptyValue();
        }
        else
        {
            this.setSentinelValuesNull();
        }
    }

    @Override
    public boolean contains(short value)
    {
        return this.containsValue(value);
    }

    @Override
    public boolean containsAll(ShortIterable source)
    {
        return source.allSatisfy((short value) -> AbstractMutableShortValuesMap.this.contains(value));
    }

    @Override
    public short max()
    {
        if (this.isEmpty())
        {
            throw new NoSuchElementException();
        }
        ShortIterator iterator = this.shortIterator();
        short max = iterator.next();
        while (iterator.hasNext())
        {
            short value = iterator.next();
            if (max < value)
            {
                max = value;
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
        ShortIterator iterator = this.shortIterator();
        short min = iterator.next();
        while (iterator.hasNext())
        {
            short value = iterator.next();
            if (value < min)
            {
                min = value;
            }
        }
        return min;
    }

    @Override
    public int size()
    {
        return this.getOccupiedWithData() + (this.getSentinelValues() == null ? 0 : this.getSentinelValues().size());
    }

    @Override
    public boolean isEmpty()
    {
        return this.getOccupiedWithData() == 0 && (this.getSentinelValues() == null || this.getSentinelValues().size() == 0);
    }

    @Override
    public boolean notEmpty()
    {
        return this.getOccupiedWithData() != 0 || (this.getSentinelValues() != null && this.getSentinelValues().size() != 0);
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
        this.forEachValue(procedure);
    }

    @Override
    public void appendString(Appendable appendable, String start, String separator, String end)
    {
        try
        {
            appendable.append(start);

            boolean first = true;

            if (this.getSentinelValues() != null)
            {
                if (this.getSentinelValues().containsZeroKey)
                {
                    appendable.append(String.valueOf(this.getSentinelValues().zeroValue));
                    first = false;
                }
                if (this.getSentinelValues().containsOneKey)
                {
                    if (!first)
                    {
                        appendable.append(separator);
                    }
                    appendable.append(String.valueOf(this.getSentinelValues().oneValue));
                    first = false;
                }
            }
            for (int i = 0; i < this.getTableSize(); i++)
            {
                if (this.isNonSentinelAtIndex(i))
                {
                    if (!first)
                    {
                        appendable.append(separator);
                    }
                    appendable.append(String.valueOf(this.getValueAtIndex(i)));
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
    public short[] toArray()
    {
        short[] array = new short[this.size()];
        int index = 0;

        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey)
            {
                array[index] = this.getSentinelValues().zeroValue;
                index++;
            }
            if (this.getSentinelValues().containsOneKey)
            {
                array[index] = this.getSentinelValues().oneValue;
                index++;
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i))
            {
                array[index] = this.getValueAtIndex(i);
                index++;
            }
        }

        return array;
    }

    @Override
    public MutableShortBag select(ShortPredicate predicate)
    {
        return this.select(predicate, new ShortHashBag());
    }

    @Override
    public MutableShortBag reject(ShortPredicate predicate)
    {
        return this.reject(predicate, new ShortHashBag());
    }

    @Override
    public <V> MutableBag<V> collect(ShortToObjectFunction<? extends V> function)
    {
        return this.collect(function, HashBag.newBag(this.size()));
    }

    @Override
    public short detectIfNone(ShortPredicate predicate, short value)
    {
        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey && predicate.accept(this.getSentinelValues().zeroValue))
            {
                return this.getSentinelValues().zeroValue;
            }
            if (this.getSentinelValues().containsOneKey && predicate.accept(this.getSentinelValues().oneValue))
            {
                return this.getSentinelValues().oneValue;
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i) && predicate.accept(this.getValueAtIndex(i)))
            {
                return this.getValueAtIndex(i);
            }
        }
        return value;
    }

    @Override
    public int count(ShortPredicate predicate)
    {
        int count = 0;
        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey && predicate.accept(this.getSentinelValues().zeroValue))
            {
                count++;
            }
            if (this.getSentinelValues().containsOneKey && predicate.accept(this.getSentinelValues().oneValue))
            {
                count++;
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i) && predicate.accept(this.getValueAtIndex(i)))
            {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean anySatisfy(ShortPredicate predicate)
    {
        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey && predicate.accept(this.getSentinelValues().zeroValue))
            {
                return true;
            }
            if (this.getSentinelValues().containsOneKey && predicate.accept(this.getSentinelValues().oneValue))
            {
                return true;
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i) && predicate.accept(this.getValueAtIndex(i)))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean allSatisfy(ShortPredicate predicate)
    {
        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey && !predicate.accept(this.getSentinelValues().zeroValue))
            {
                return false;
            }
            if (this.getSentinelValues().containsOneKey && !predicate.accept(this.getSentinelValues().oneValue))
            {
                return false;
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i) && !predicate.accept(this.getValueAtIndex(i)))
            {
                return false;
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
                result.add(ShortBags.mutable.withAll(this));
            }
            else
            {
                ShortIterator iterator = this.shortIterator();
                while (iterator.hasNext())
                {
                    MutableShortBag batch = ShortBags.mutable.empty();
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

    @Override
    public long sum()
    {
        long result = 0L;

        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey)
            {
                result += this.getSentinelValues().zeroValue;
            }
            if (this.getSentinelValues().containsOneKey)
            {
                result += this.getSentinelValues().oneValue;
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i))
            {
                result += this.getValueAtIndex(i);
            }
        }

        return result;
    }

    @Override
    public boolean containsValue(short value)
    {
        if (this.getSentinelValues() != null && this.getSentinelValues().containsValue(value))
        {
            return true;
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i) && this.getValueAtIndex(i) == value)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public void forEachValue(ShortProcedure procedure)
    {
        if (this.getSentinelValues() != null)
        {
            if (this.getSentinelValues().containsZeroKey)
            {
                procedure.value(this.getSentinelValues().zeroValue);
            }
            if (this.getSentinelValues().containsOneKey)
            {
                procedure.value(this.getSentinelValues().oneValue);
            }
        }
        for (int i = 0; i < this.getTableSize(); i++)
        {
            if (this.isNonSentinelAtIndex(i))
            {
                procedure.value(this.getValueAtIndex(i));
            }
        }
    }

    protected static class SentinelValues extends AbstractSentinelValues
    {
        protected short zeroValue;
        protected short oneValue;

        public boolean containsValue(short value)
        {
            boolean valueEqualsZeroValue = this.containsZeroKey && this.zeroValue == value;
            boolean valueEqualsOneValue = this.containsOneKey && this.oneValue == value;
            return valueEqualsZeroValue || valueEqualsOneValue;
        }

        public SentinelValues copy()
        {
            SentinelValues sentinelValues = new SentinelValues();
            sentinelValues.zeroValue = this.zeroValue;
            sentinelValues.oneValue = this.oneValue;
            sentinelValues.containsOneKey = this.containsOneKey;
            sentinelValues.containsZeroKey = this.containsZeroKey;
            return sentinelValues;
        }
    }

    protected abstract class AbstractShortValuesCollection implements MutableShortCollection
    {
        @Override
        public void clear()
        {
            AbstractMutableShortValuesMap.this.clear();
        }

        @Override
        public MutableShortCollection select(ShortPredicate predicate)
        {
            return AbstractMutableShortValuesMap.this.select(predicate);
        }

        @Override
        public MutableShortCollection reject(ShortPredicate predicate)
        {
            return AbstractMutableShortValuesMap.this.reject(predicate);
        }

        @Override
        public short detectIfNone(ShortPredicate predicate, short ifNone)
        {
            return AbstractMutableShortValuesMap.this.detectIfNone(predicate, ifNone);
        }

        @Override
        public <V> MutableCollection<V> collect(ShortToObjectFunction<? extends V> function)
        {
            return AbstractMutableShortValuesMap.this.collect(function);
        }

        @Override
        public <T> T injectInto(T injectedValue, ObjectShortToObjectFunction<? super T, ? extends T> function)
        {
            return AbstractMutableShortValuesMap.this.injectInto(injectedValue, function);
        }

        @Override
        public RichIterable<ShortIterable> chunk(int size)
        {
            return AbstractMutableShortValuesMap.this.chunk(size);
        }

        @Override
        public long sum()
        {
            return AbstractMutableShortValuesMap.this.sum();
        }

        @Override
        public short max()
        {
            return AbstractMutableShortValuesMap.this.max();
        }

        @Override
        public short maxIfEmpty(short defaultValue)
        {
            return AbstractMutableShortValuesMap.this.maxIfEmpty(defaultValue);
        }

        @Override
        public short min()
        {
            return AbstractMutableShortValuesMap.this.min();
        }

        @Override
        public short minIfEmpty(short defaultValue)
        {
            return AbstractMutableShortValuesMap.this.minIfEmpty(defaultValue);
        }

        @Override
        public double average()
        {
            return AbstractMutableShortValuesMap.this.average();
        }

        @Override
        public double median()
        {
            return AbstractMutableShortValuesMap.this.median();
        }

        @Override
        public short[] toSortedArray()
        {
            return AbstractMutableShortValuesMap.this.toSortedArray();
        }

        @Override
        public MutableShortList toSortedList()
        {
            return AbstractMutableShortValuesMap.this.toSortedList();
        }

        @Override
        public MutableShortCollection with(short element)
        {
            throw new UnsupportedOperationException("Cannot call with() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableShortCollection without(short element)
        {
            throw new UnsupportedOperationException("Cannot call without() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableShortCollection withAll(ShortIterable elements)
        {
            throw new UnsupportedOperationException("Cannot call withAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableShortCollection withoutAll(ShortIterable elements)
        {
            throw new UnsupportedOperationException("Cannot call withoutAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public MutableShortCollection asUnmodifiable()
        {
            return UnmodifiableShortCollection.of(this);
        }

        @Override
        public MutableShortCollection asSynchronized()
        {
            return SynchronizedShortCollection.of(this);
        }

        @Override
        public ImmutableShortCollection toImmutable()
        {
            return ShortLists.immutable.withAll(this);
        }

        @Override
        public boolean contains(short value)
        {
            return AbstractMutableShortValuesMap.this.containsValue(value);
        }

        @Override
        public boolean containsAll(short... source)
        {
            return AbstractMutableShortValuesMap.this.containsAll(source);
        }

        @Override
        public boolean containsAll(ShortIterable source)
        {
            return AbstractMutableShortValuesMap.this.containsAll(source);
        }

        @Override
        public MutableShortList toList()
        {
            return AbstractMutableShortValuesMap.this.toList();
        }

        @Override
        public MutableShortSet toSet()
        {
            return AbstractMutableShortValuesMap.this.toSet();
        }

        @Override
        public MutableShortBag toBag()
        {
            return AbstractMutableShortValuesMap.this.toBag();
        }

        @Override
        public LazyShortIterable asLazy()
        {
            return new LazyShortIterableAdapter(this);
        }

        @Override
        public boolean isEmpty()
        {
            return AbstractMutableShortValuesMap.this.isEmpty();
        }

        @Override
        public boolean notEmpty()
        {
            return AbstractMutableShortValuesMap.this.notEmpty();
        }

        @Override
        public String makeString()
        {
            return AbstractMutableShortValuesMap.this.makeString();
        }

        @Override
        public String makeString(String separator)
        {
            return AbstractMutableShortValuesMap.this.makeString(separator);
        }

        @Override
        public String makeString(String start, String separator, String end)
        {
            return AbstractMutableShortValuesMap.this.makeString(start, separator, end);
        }

        @Override
        public void appendString(Appendable appendable)
        {
            AbstractMutableShortValuesMap.this.appendString(appendable);
        }

        @Override
        public void appendString(Appendable appendable, String separator)
        {
            AbstractMutableShortValuesMap.this.appendString(appendable, separator);
        }

        @Override
        public void appendString(Appendable appendable, String start, String separator, String end)
        {
            AbstractMutableShortValuesMap.this.appendString(appendable, start, separator, end);
        }

        @Override
        public void forEach(ShortProcedure procedure)
        {
            this.each(procedure);
        }

        @Override
        public void each(ShortProcedure procedure)
        {
            AbstractMutableShortValuesMap.this.each(procedure);
        }

        @Override
        public int count(ShortPredicate predicate)
        {
            return AbstractMutableShortValuesMap.this.count(predicate);
        }

        @Override
        public boolean anySatisfy(ShortPredicate predicate)
        {
            return AbstractMutableShortValuesMap.this.anySatisfy(predicate);
        }

        @Override
        public boolean allSatisfy(ShortPredicate predicate)
        {
            return AbstractMutableShortValuesMap.this.allSatisfy(predicate);
        }

        @Override
        public boolean noneSatisfy(ShortPredicate predicate)
        {
            return AbstractMutableShortValuesMap.this.noneSatisfy(predicate);
        }

        @Override
        public boolean add(short element)
        {
            throw new UnsupportedOperationException("Cannot call add() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean addAll(short... source)
        {
            throw new UnsupportedOperationException("Cannot call addAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean addAll(ShortIterable source)
        {
            throw new UnsupportedOperationException("Cannot call addAll() on " + this.getClass().getSimpleName());
        }

        @Override
        public boolean removeAll(ShortIterable source)
        {
            int oldSize = AbstractMutableShortValuesMap.this.size();

            ShortIterator iterator = source.shortIterator();
            while (iterator.hasNext())
            {
                this.remove(iterator.next());
            }
            return oldSize != AbstractMutableShortValuesMap.this.size();
        }

        @Override
        public boolean removeAll(short... source)
        {
            int oldSize = AbstractMutableShortValuesMap.this.size();

            for (short item : source)
            {
                this.remove(item);
            }
            return oldSize != AbstractMutableShortValuesMap.this.size();
        }

        @Override
        public boolean retainAll(short... source)
        {
            return this.retainAll(ShortHashSet.newSetWith(source));
        }

        @Override
        public int size()
        {
            return AbstractMutableShortValuesMap.this.size();
        }

        @Override
        public short[] toArray()
        {
            return AbstractMutableShortValuesMap.this.toArray();
        }
    }
}
