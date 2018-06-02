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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectIntIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectIntIterableTest
{
    private final SelectIntIterable iterable =
        new SelectIntIterable(IntArrayList.newListWith(1, 2, 3, 4, 5), IntPredicates.lessThan(3));

    @Test
    public void intIterator()
    {
        long sum = 0L;
        for (IntIterator iterator = this.iterable.intIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        this.iterable.forEach((int each) -> sum[0] += each);
        Assert.assertEquals(3L, sum[0]);
    }

    @Test
    public void size()
    {
        Verify.assertSize(2, this.iterable);
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(this.iterable.notEmpty());
        Verify.assertNotEmpty(this.iterable);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(1L, this.iterable.count(IntPredicates.lessThan(2)));
        Assert.assertEquals(0L, this.iterable.count(IntPredicates.lessThan(0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.iterable.anySatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.iterable.allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(this.iterable.allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertTrue(this.iterable.allSatisfy(IntPredicates.lessThan(4)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(this.iterable.noneSatisfy(IntPredicates.lessThan(2)));
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.lessThan(1)));
        Assert.assertTrue(this.iterable.noneSatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(1, this.iterable.select(IntPredicates.greaterThan(1)));
        Verify.assertSize(0, this.iterable.select(IntPredicates.lessThan(0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(IntPredicates.greaterThan(1)));
        Verify.assertSize(0, this.iterable.reject(IntPredicates.greaterThan(0)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.iterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(IntPredicates.greaterThan(3), 0));
    }

    @Test
    public void collect()
    {
        Verify.assertIterableSize(2, this.iterable.collect(String::valueOf));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(3L, this.iterable.sum());
    }

    @Test
    public void max()
    {
        Assert.assertEquals(2, this.iterable.max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals(1, this.iterable.min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(1, this.iterable.minIfEmpty(0));
        Assert.assertEquals(
                0,
                this.iterable.select(IntPredicates.lessThan(0)).minIfEmpty(0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(2, this.iterable.maxIfEmpty(0));
        Assert.assertEquals(
                0,
                this.iterable.select(IntPredicates.lessThan(0)).maxIfEmpty(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new SelectIntIterable(new IntArrayList(), IntPredicates.lessThan(3)).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new int[]{1, 2}, this.iterable.toArray());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains(1));
        Assert.assertTrue(this.iterable.contains(2));
        Assert.assertFalse(this.iterable.contains(3));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll(1));
        Assert.assertTrue(this.iterable.containsAll(2));
        Assert.assertTrue(this.iterable.containsAll(1, 2));
        Assert.assertFalse(this.iterable.containsAll(1, 2, 3));
        Assert.assertFalse(this.iterable.containsAll(4, 5, 6));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(this.iterable.containsAll(IntArrayList.newListWith(2)));
        Assert.assertTrue(this.iterable.containsAll(IntArrayList.newListWith(1, 2)));
        Assert.assertFalse(this.iterable.containsAll(IntArrayList.newListWith(1, 2, 3)));
        Assert.assertFalse(this.iterable.containsAll(IntArrayList.newListWith(4, 5, 6)));
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new int[]{1, 2}, this.iterable.toSortedArray());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(IntArrayList.newListWith(1, 2), this.iterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(IntArrayList.newListWith(1, 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(IntHashSet.newSetWith(1, 2), this.iterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(IntHashBag.newBagWith(1, 2), this.iterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        MutableInteger result = this.iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(3), result);
    }
}
