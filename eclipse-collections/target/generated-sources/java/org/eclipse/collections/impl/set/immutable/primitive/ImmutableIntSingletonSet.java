/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.set.immutable.primitive;

import java.io.IOException;
import java.io.Serializable;

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.primitive.ImmutableIntSet;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.block.function.primitive.ObjectIntToObjectFunction;
import org.eclipse.collections.api.block.predicate.primitive.IntPredicate;
import org.eclipse.collections.api.block.procedure.primitive.IntIntProcedure;
import org.eclipse.collections.api.block.procedure.primitive.IntProcedure;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.iterator.UnmodifiableIntIterator;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.factory.primitive.IntSets;
import org.eclipse.collections.impl.lazy.primitive.LazyIntIterableAdapter;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;

/**
 * ImmutableIntSingletonSet is an optimization for {@link ImmutableIntSet} of size 1.
 * This file was automatically generated from template file immutablePrimitiveSingletonSet.stg.
 *
 * @since 4.0.
 */
final class ImmutableIntSingletonSet implements ImmutableIntSet, Serializable
{
    private static final long serialVersionUID = 1L;

    private final int element;

    ImmutableIntSingletonSet(int element)
    {
        this.element = element;
    }

    @Override
    public ImmutableIntSet newWith(int element)
    {
        return IntSets.immutable.with(this.element, element);
    }

    @Override
    public ImmutableIntSet newWithout(int element)
    {
        return this.element == element ? IntSets.immutable.with() : this;
    }

    @Override
    public ImmutableIntSet newWithAll(IntIterable elements)
    {
        return IntHashSet.newSet(elements).with(this.element).toImmutable();
    }

    @Override
    public ImmutableIntSet newWithoutAll(IntIterable elements)
    {
        return elements.contains(this.element) ? IntSets.immutable.with() : this;
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
    public boolean contains(int value)
    {
        return this.element == value;
    }

    @Override
    public boolean containsAll(IntIterable source)
    {
        for (IntIterator iterator = source.intIterator(); iterator.hasNext(); )
        {
            if (this.element != iterator.next())
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(int... source)
    {
        for (int value : source)
        {
            if (this.element != value)
            {
                return false;
            }
        }
        return true;
    }

    @Override
    public void forEach(IntProcedure procedure)
    {
        this.each(procedure);
    }

    /**
     * @since 7.0.
     */
    @Override
    public void each(IntProcedure procedure)
    {
        procedure.value(this.element);
    }

    @Override
    public ImmutableIntSet select(IntPredicate predicate)
    {
        return predicate.accept(this.element) ? IntHashSet.newSetWith(this.element).toImmutable()
                : new IntHashSet().toImmutable();
    }

    @Override
    public ImmutableIntSet reject(IntPredicate predicate)
    {
        return predicate.accept(this.element) ? new IntHashSet().toImmutable()
                : IntHashSet.newSetWith(this.element).toImmutable();
    }

    @Override
    public <V> ImmutableSet<V> collect(IntToObjectFunction<? extends V> function)
    {
        return UnifiedSet.<V>newSetWith(function.valueOf(this.element)).toImmutable();
    }

    @Override
    public MutableIntList toList()
    {
        return IntArrayList.newListWith(this.element);
    }

    public int sizeDistinct()
    {
        return 1;
    }

    public int occurrencesOf(int item)
    {
        return this.element == item ? 1 : 0;
    }

    public void forEachWithOccurrences(IntIntProcedure intIntProcedure)
    {
        intIntProcedure.value(this.element, 1);
    }

    @Override
    public int detectIfNone(IntPredicate predicate, int ifNone)
    {
        return predicate.accept(this.element) ? this.element : ifNone;
    }

    @Override
    public int count(IntPredicate predicate)
    {
        return predicate.accept(this.element) ? 1 : 0;
    }

    @Override
    public boolean anySatisfy(IntPredicate predicate)
    {
        return predicate.accept(this.element);
    }

    @Override
    public long sum()
    {
        return this.element;
    }

    @Override
    public int min()
    {
        return this.element;
    }

    @Override
    public int max()
    {
        return this.element;
    }

    @Override
    public int maxIfEmpty(int defaultValue)
    {
        return this.element;
    }

    @Override
    public int minIfEmpty(int defaultValue)
    {
        return this.element;
    }

    @Override
    public double average()
    {
        return this.element;
    }

    @Override
    public double median()
    {
        return this.element;
    }

    @Override
    public int[] toSortedArray()
    {
        return new int[]{this.element};
    }

    @Override
    public MutableIntList toSortedList()
    {
        return IntArrayList.newListWith(this.element);
    }

    @Override
    public boolean noneSatisfy(IntPredicate predicate)
    {
        return !predicate.accept(this.element);
    }

    @Override
    public boolean allSatisfy(IntPredicate predicate)
    {
        return predicate.accept(this.element);
    }

    @Override
    public <T> T injectInto(T injectedValue, ObjectIntToObjectFunction<? super T, ? extends T> function)
    {
        return function.valueOf(injectedValue, this.element);
    }

    @Override
    public RichIterable<IntIterable> chunk(int size)
    {
        if (size <= 0)
        {
            throw new IllegalArgumentException("Size for groups must be positive but was: " + size);
        }

        return Lists.immutable.with(this);
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }
        if (!(obj instanceof IntSet))
        {
            return false;
        }
        IntSet set = (IntSet) obj;
        if (set.size() != 1)
        {
            return false;
        }
        return set.contains(this.element);
    }

    @Override
    public int hashCode()
    {
        return this.element;
    }

    @Override
    public MutableIntSet toSet()
    {
        return IntHashSet.newSetWith(this.element);
    }

    @Override
    public MutableIntBag toBag()
    {
        return IntHashBag.newBagWith(this.element);
    }

    @Override
    public IntSet freeze()
    {
        return this;
    }

    @Override
    public ImmutableIntSet toImmutable()
    {
        return this;
    }

    @Override
    public LazyIntIterable asLazy()
    {
        return new LazyIntIterableAdapter(this);
    }

    @Override
    public int[] toArray()
    {
        return new int[]{this.element};
    }

    @Override
    public String toString()
    {
        return '[' + this.makeString() + ']';
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
            appendable.append(String.valueOf(this.element));
            appendable.append(end);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public IntIterator intIterator()
    {
        return new UnmodifiableIntIterator(IntHashSet.newSetWith(this.element).intIterator());
    }
}
