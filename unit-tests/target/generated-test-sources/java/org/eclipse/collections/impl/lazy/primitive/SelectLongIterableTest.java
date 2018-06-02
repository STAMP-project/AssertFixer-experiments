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

import org.eclipse.collections.api.LazyLongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectLongIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectLongIterableTest
{
    private final SelectLongIterable iterable =
        new SelectLongIterable(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), LongPredicates.lessThan(3L));

    @Test
    public void longIterator()
    {
        long sum = 0L;
        for (LongIterator iterator = this.iterable.longIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        this.iterable.forEach((long each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(0L, this.iterable.count(LongPredicates.lessThan(0L)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.iterable.anySatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(this.iterable.allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.iterable.allSatisfy(LongPredicates.lessThan(4L)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(this.iterable.noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertTrue(this.iterable.noneSatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(1, this.iterable.select(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, this.iterable.select(LongPredicates.lessThan(0L)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, this.iterable.reject(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(0L, this.iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
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
        Assert.assertEquals(2L, this.iterable.max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals(1L, this.iterable.min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(1L, this.iterable.minIfEmpty(0L));
        Assert.assertEquals(
                0L,
                this.iterable.select(LongPredicates.lessThan(0L)).minIfEmpty(0L));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(2L, this.iterable.maxIfEmpty(0L));
        Assert.assertEquals(
                0L,
                this.iterable.select(LongPredicates.lessThan(0L)).maxIfEmpty(0L));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new SelectLongIterable(new LongArrayList(), LongPredicates.lessThan(3L)).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new long[]{1, 2}, this.iterable.toArray());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains(1L));
        Assert.assertTrue(this.iterable.contains(2L));
        Assert.assertFalse(this.iterable.contains(3L));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll(1L));
        Assert.assertTrue(this.iterable.containsAll(2L));
        Assert.assertTrue(this.iterable.containsAll(1L, 2L));
        Assert.assertFalse(this.iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(this.iterable.containsAll(4L, 5L, 6L));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(2L)));
        Assert.assertTrue(this.iterable.containsAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertFalse(this.iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(this.iterable.containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new long[]{1, 2}, this.iterable.toSortedArray());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), this.iterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), this.iterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L), this.iterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L), this.iterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        MutableLong result = this.iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(3L), result);
    }
}
