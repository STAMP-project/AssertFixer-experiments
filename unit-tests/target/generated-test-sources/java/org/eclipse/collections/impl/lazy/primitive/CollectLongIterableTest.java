/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.lazy.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectLongIterableTest
{
    private final LongIterable longIterable = Interval.oneTo(3).collectLong(PrimitiveFunctions.unboxIntegerToLong());

    @Test
    public void iterator()
    {
        long sum = 0L;
        LongIterator iterator = this.longIterable.longIterator();
        while (iterator.hasNext())
        {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size()
    {
        Assert.assertEquals(3L, this.longIterable.size());
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(this.longIterable.notEmpty());
        Assert.assertFalse(this.longIterable.isEmpty());
    }

    @Test
    public void forEach()
    {
        long[] value = new long[1];
        this.longIterable.forEach(each -> { value[0] += each; });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(1, this.longIterable.count(LongPredicates.equal(1L)));
        Assert.assertEquals(3, this.longIterable.count(LongPredicates.lessThan(4L)));
        Assert.assertEquals(2, this.longIterable.count(LongPredicates.greaterThan(1L)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.longIterable.anySatisfy(LongPredicates.greaterThan(1L)));
        Assert.assertTrue(this.longIterable.anySatisfy(LongPredicates.equal(1L)));
        Assert.assertFalse(this.longIterable.anySatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.longIterable.noneSatisfy(LongPredicates.greaterThan(2L)));
        Assert.assertTrue(this.longIterable.noneSatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.longIterable.allSatisfy(LongPredicates.lessThan(4L)));
        Assert.assertFalse(this.longIterable.allSatisfy(LongPredicates.lessThan(3L)));
    }

    @Test
    public void select()
    {
        Assert.assertEquals(3L, this.longIterable.select(LongPredicates.lessThan(4L)).size());
        Assert.assertEquals(2L, this.longIterable.select(LongPredicates.lessThan(3L)).size());
    }

    @Test
    public void reject()
    {
        Assert.assertEquals(0L, this.longIterable.reject(LongPredicates.lessThan(4L)).size());
        Assert.assertEquals(1L, this.longIterable.reject(LongPredicates.lessThan(3L)).size());
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.longIterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(0L, this.longIterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, this.longIterable.sum());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(3L, Interval.fromTo(0, 3).collectLong(PrimitiveFunctions.unboxIntegerToLong()).max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0L, Interval.fromTo(0, 3).collectLong(PrimitiveFunctions.unboxIntegerToLong()).min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(0L, Interval.fromTo(0, 3).collectLong(PrimitiveFunctions.unboxIntegerToLong()).minIfEmpty(0L));
        Assert.assertEquals(0L, FastList.<Integer>newList().asLazy().collectLong(PrimitiveFunctions.unboxIntegerToLong()).minIfEmpty(0L));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(3L, Interval.fromTo(0, 3).collectLong(PrimitiveFunctions.unboxIntegerToLong()).maxIfEmpty(0L));
        Assert.assertEquals(0L, FastList.<Integer>newList().asLazy().collectLong(PrimitiveFunctions.unboxIntegerToLong()).maxIfEmpty(0L));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectLong(PrimitiveFunctions.unboxIntegerToLong()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectLong(PrimitiveFunctions.unboxIntegerToLong()).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectLong(PrimitiveFunctions.unboxIntegerToLong()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectLong(PrimitiveFunctions.unboxIntegerToLong()).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectLong(PrimitiveFunctions.unboxIntegerToLong()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectLong(PrimitiveFunctions.unboxIntegerToLong()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectLong(PrimitiveFunctions.unboxIntegerToLong()).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new long[]{1L, 2L, 3L, 4L},
                Interval.oneTo(4).collectLong(PrimitiveFunctions.unboxIntegerToLong()).toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new long[]{1L, 2L, 3L, 4L},
                Interval.fromTo(4, 1).collectLong(PrimitiveFunctions.unboxIntegerToLong()).toSortedArray());
    }

    @Test
    public void contains()
    {
        LongIterable longIterable = Interval.fromTo(4, 1).collectLong(PrimitiveFunctions.unboxIntegerToLong());
        Assert.assertTrue(longIterable.contains(1L));
        Assert.assertTrue(longIterable.contains(3L));
        Assert.assertTrue(longIterable.contains(4L));
        Assert.assertFalse(longIterable.contains(5L));
    }

    @Test
    public void containsAllArray()
    {
        LongIterable longIterable = Interval.fromTo(4, 1).collectLong(PrimitiveFunctions.unboxIntegerToLong());
        Assert.assertTrue(longIterable.containsAll(1L));
        Assert.assertTrue(longIterable.containsAll(1L, 2L, 3L, 4L));
        Assert.assertFalse(longIterable.containsAll(1L, 2L, 3L, 4L, 5L));
        Assert.assertFalse(longIterable.containsAll(7L, 6L, 5L));
    }

    @Test
    public void containsAllIterable()
    {
        LongIterable longIterable = Interval.fromTo(4, 1).collectLong(PrimitiveFunctions.unboxIntegerToLong());
        Assert.assertTrue(longIterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(longIterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L, 4L)));
        Assert.assertFalse(longIterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L)));
        Assert.assertFalse(longIterable.containsAll(LongArrayList.newListWith(7L, 6L, 5L)));
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.longIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[1, 2, 3]", this.longIterable.toString());
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("1, 2, 3", this.longIterable.makeString());
        Assert.assertEquals("1/2/3", this.longIterable.makeString("/"));
        Assert.assertEquals("[1, 2, 3]", this.longIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        this.longIterable.appendString(appendable);
        Assert.assertEquals("1, 2, 3", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.longIterable.appendString(appendable2, "/");
        Assert.assertEquals("1/2/3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.longIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.longIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), this.longIterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), this.longIterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L), this.longIterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), this.longIterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.longIterable.toSet(), this.longIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, this.longIterable.asLazy());
    }
}
