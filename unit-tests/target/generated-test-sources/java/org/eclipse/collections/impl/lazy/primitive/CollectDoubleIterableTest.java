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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.LazyDoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectDoubleIterableTest
{
    private final DoubleIterable doubleIterable = Interval.oneTo(3).collectDouble(PrimitiveFunctions.unboxIntegerToDouble());

    @Test
    public void iterator()
    {
        double sum = 0.0;
        DoubleIterator iterator = this.doubleIterable.doubleIterator();
        while (iterator.hasNext())
        {
            sum += iterator.next();
        }
        Assert.assertEquals(6.0, sum, 0.0);
    }

    @Test
    public void size()
    {
        Assert.assertEquals(3L, this.doubleIterable.size());
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(this.doubleIterable.notEmpty());
        Assert.assertFalse(this.doubleIterable.isEmpty());
    }

    @Test
    public void forEach()
    {
        double[] value = new double[1];
        this.doubleIterable.forEach(each -> { value[0] += each; });
        Assert.assertEquals(6.0, value[0], 0.0);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(1, this.doubleIterable.count(DoublePredicates.equal(1.0)));
        Assert.assertEquals(3, this.doubleIterable.count(DoublePredicates.lessThan(4.0)));
        Assert.assertEquals(2, this.doubleIterable.count(DoublePredicates.greaterThan(1.0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.doubleIterable.anySatisfy(DoublePredicates.greaterThan(1.0)));
        Assert.assertTrue(this.doubleIterable.anySatisfy(DoublePredicates.equal(1.0)));
        Assert.assertFalse(this.doubleIterable.anySatisfy(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.doubleIterable.noneSatisfy(DoublePredicates.greaterThan(2.0)));
        Assert.assertTrue(this.doubleIterable.noneSatisfy(DoublePredicates.greaterThan(4.0)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.doubleIterable.allSatisfy(DoublePredicates.lessThan(4.0)));
        Assert.assertFalse(this.doubleIterable.allSatisfy(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void select()
    {
        Assert.assertEquals(3L, this.doubleIterable.select(DoublePredicates.lessThan(4.0)).size());
        Assert.assertEquals(2L, this.doubleIterable.select(DoublePredicates.lessThan(3.0)).size());
    }

    @Test
    public void reject()
    {
        Assert.assertEquals(0L, this.doubleIterable.reject(DoublePredicates.lessThan(4.0)).size());
        Assert.assertEquals(1L, this.doubleIterable.reject(DoublePredicates.lessThan(3.0)).size());
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1.0, this.doubleIterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(0.0, this.doubleIterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6.0, this.doubleIterable.sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding()
    {
        DoubleIterable iterable =
            Interval.oneTo(100_000)
                .toList()
                .shuffleThis()
                .collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));

        Assert.assertEquals(
                1.082323233711138,
                iterable.sum(),
                1.0e-15);
    }

    @Test
    public void max()
    {
        Assert.assertEquals(3.0, Interval.fromTo(0, 3).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).max(), 0.0);
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0.0, Interval.fromTo(0, 3).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).min(), 0.0);
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(0.0, Interval.fromTo(0, 3).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, FastList.<Integer>newList().asLazy().collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).minIfEmpty(0.0), 0.0);
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(3.0, Interval.fromTo(0, 3).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, FastList.<Integer>newList().asLazy().collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).maxIfEmpty(0.0), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0},
                Interval.oneTo(4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).toArray(), 0.0);
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new double[]{1.0, 2.0, 3.0, 4.0},
                Interval.fromTo(4, 1).collectDouble(PrimitiveFunctions.unboxIntegerToDouble()).toSortedArray(), 0.0);
    }

    @Test
    public void contains()
    {
        DoubleIterable doubleIterable = Interval.fromTo(4, 1).collectDouble(PrimitiveFunctions.unboxIntegerToDouble());
        Assert.assertTrue(doubleIterable.contains(1.0));
        Assert.assertTrue(doubleIterable.contains(3.0));
        Assert.assertTrue(doubleIterable.contains(4.0));
        Assert.assertFalse(doubleIterable.contains(5.0));
    }

    @Test
    public void containsAllArray()
    {
        DoubleIterable doubleIterable = Interval.fromTo(4, 1).collectDouble(PrimitiveFunctions.unboxIntegerToDouble());
        Assert.assertTrue(doubleIterable.containsAll(1.0));
        Assert.assertTrue(doubleIterable.containsAll(1.0, 2.0, 3.0, 4.0));
        Assert.assertFalse(doubleIterable.containsAll(1.0, 2.0, 3.0, 4.0, 5.0));
        Assert.assertFalse(doubleIterable.containsAll(7.0, 6.0, 5.0));
    }

    @Test
    public void containsAllIterable()
    {
        DoubleIterable doubleIterable = Interval.fromTo(4, 1).collectDouble(PrimitiveFunctions.unboxIntegerToDouble());
        Assert.assertTrue(doubleIterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(doubleIterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0)));
        Assert.assertFalse(doubleIterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0)));
        Assert.assertFalse(doubleIterable.containsAll(DoubleArrayList.newListWith(7.0, 6.0, 5.0)));
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(FastList.newListWith("1.0", "2.0", "3.0"), this.doubleIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.doubleIterable.toString());
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("1.0, 2.0, 3.0", this.doubleIterable.makeString());
        Assert.assertEquals("1.0/2.0/3.0", this.doubleIterable.makeString("/"));
        Assert.assertEquals("[1.0, 2.0, 3.0]", this.doubleIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        this.doubleIterable.appendString(appendable);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.doubleIterable.appendString(appendable2, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.doubleIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.doubleIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), this.doubleIterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), this.doubleIterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), this.doubleIterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), this.doubleIterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.doubleIterable.toSet(), this.doubleIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyDoubleIterable.class, this.doubleIterable.asLazy());
    }
}
