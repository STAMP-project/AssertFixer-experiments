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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectIntIterableTest
{
    private final IntIterable intIterable = Interval.oneTo(3).collectInt(PrimitiveFunctions.unboxIntegerToInt());

    @Test
    public void iterator()
    {
        long sum = 0L;
        IntIterator iterator = this.intIterable.intIterator();
        while (iterator.hasNext())
        {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size()
    {
        Assert.assertEquals(3L, this.intIterable.size());
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(this.intIterable.notEmpty());
        Assert.assertFalse(this.intIterable.isEmpty());
    }

    @Test
    public void forEach()
    {
        long[] value = new long[1];
        this.intIterable.forEach(each -> { value[0] += each; });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(1, this.intIterable.count(IntPredicates.equal(1)));
        Assert.assertEquals(3, this.intIterable.count(IntPredicates.lessThan(4)));
        Assert.assertEquals(2, this.intIterable.count(IntPredicates.greaterThan(1)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.intIterable.anySatisfy(IntPredicates.greaterThan(1)));
        Assert.assertTrue(this.intIterable.anySatisfy(IntPredicates.equal(1)));
        Assert.assertFalse(this.intIterable.anySatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.intIterable.noneSatisfy(IntPredicates.greaterThan(2)));
        Assert.assertTrue(this.intIterable.noneSatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.intIterable.allSatisfy(IntPredicates.lessThan(4)));
        Assert.assertFalse(this.intIterable.allSatisfy(IntPredicates.lessThan(3)));
    }

    @Test
    public void select()
    {
        Assert.assertEquals(3L, this.intIterable.select(IntPredicates.lessThan(4)).size());
        Assert.assertEquals(2L, this.intIterable.select(IntPredicates.lessThan(3)).size());
    }

    @Test
    public void reject()
    {
        Assert.assertEquals(0L, this.intIterable.reject(IntPredicates.lessThan(4)).size());
        Assert.assertEquals(1L, this.intIterable.reject(IntPredicates.lessThan(3)).size());
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1, this.intIterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(0, this.intIterable.detectIfNone(IntPredicates.greaterThan(3), 0));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, this.intIterable.sum());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(3, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(0, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).minIfEmpty(0));
        Assert.assertEquals(0, FastList.<Integer>newList().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).minIfEmpty(0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(3, Interval.fromTo(0, 3).collectInt(PrimitiveFunctions.unboxIntegerToInt()).maxIfEmpty(0));
        Assert.assertEquals(0, FastList.<Integer>newList().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).maxIfEmpty(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectInt(PrimitiveFunctions.unboxIntegerToInt()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectInt(PrimitiveFunctions.unboxIntegerToInt()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectInt(PrimitiveFunctions.unboxIntegerToInt()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectInt(PrimitiveFunctions.unboxIntegerToInt()).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4},
                Interval.oneTo(4).collectInt(PrimitiveFunctions.unboxIntegerToInt()).toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new int[]{1, 2, 3, 4},
                Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt()).toSortedArray());
    }

    @Test
    public void contains()
    {
        IntIterable intIterable = Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertTrue(intIterable.contains(1));
        Assert.assertTrue(intIterable.contains(3));
        Assert.assertTrue(intIterable.contains(4));
        Assert.assertFalse(intIterable.contains(5));
    }

    @Test
    public void containsAllArray()
    {
        IntIterable intIterable = Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertTrue(intIterable.containsAll(1));
        Assert.assertTrue(intIterable.containsAll(1, 2, 3, 4));
        Assert.assertFalse(intIterable.containsAll(1, 2, 3, 4, 5));
        Assert.assertFalse(intIterable.containsAll(7, 6, 5));
    }

    @Test
    public void containsAllIterable()
    {
        IntIterable intIterable = Interval.fromTo(4, 1).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertTrue(intIterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(intIterable.containsAll(IntArrayList.newListWith(1, 2, 3, 4)));
        Assert.assertFalse(intIterable.containsAll(IntArrayList.newListWith(1, 2, 3, 4, 5)));
        Assert.assertFalse(intIterable.containsAll(IntArrayList.newListWith(7, 6, 5)));
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(FastList.newListWith("1", "2", "3"), this.intIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[1, 2, 3]", this.intIterable.toString());
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("1, 2, 3", this.intIterable.makeString());
        Assert.assertEquals("1/2/3", this.intIterable.makeString("/"));
        Assert.assertEquals("[1, 2, 3]", this.intIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        this.intIterable.appendString(appendable);
        Assert.assertEquals("1, 2, 3", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.intIterable.appendString(appendable2, "/");
        Assert.assertEquals("1/2/3", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.intIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.intIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.intIterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), this.intIterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3), this.intIterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), this.intIterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.intIterable.toSet(), this.intIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, this.intIterable.asLazy());
    }
}
