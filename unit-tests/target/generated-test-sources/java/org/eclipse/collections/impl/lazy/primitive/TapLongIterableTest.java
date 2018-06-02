/*
 * Copyright (c) 2018 Goldman Sachs and others.
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
import org.eclipse.collections.api.list.primitive.LongList;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapLongIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapLongIterableTest
{
    private final LongList list = LongLists.immutable.with(1L, 2L, 3L, 4L, 5L);

    @Test
    public void longIterator()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        long sum = 0L;
        for (LongIterator iterator = iterable.longIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(15L, sum);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void forEach()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        long[] sum = new long[1];
        iterable.forEach((long each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.count(LongPredicates.lessThan(2L)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.anySatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(iterable.anySatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void allSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.allSatisfy(LongPredicates.greaterThan(0L)));
        Assert.assertFalse(iterable.allSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertFalse(iterable.allSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(iterable.allSatisfy(LongPredicates.lessThan(4L)));
    }

    @Test
    public void noneSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.noneSatisfy(LongPredicates.lessThan(0L)));
        Assert.assertFalse(iterable.noneSatisfy(LongPredicates.lessThan(2L)));
        Assert.assertTrue(iterable.noneSatisfy(LongPredicates.lessThan(1L)));
        Assert.assertFalse(iterable.noneSatisfy(LongPredicates.greaterThan(4L)));
    }

    @Test
    public void select()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Verify.assertSize(4, iterable.select(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, iterable.select(LongPredicates.lessThan(0L)));
    }

    @Test
    public void reject()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Verify.assertSize(1, iterable.reject(LongPredicates.greaterThan(1L)));
        Verify.assertSize(0, iterable.reject(LongPredicates.greaterThan(0L)));
    }

    @Test
    public void detectIfNone()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.detectIfNone(LongPredicates.lessThan(4L), 0L));
        Assert.assertEquals(4L, iterable.detectIfNone(LongPredicates.greaterThan(3L), 0L));
    }

    @Test
    public void collect()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(5L, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.minIfEmpty(0L));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(5L, iterable.maxIfEmpty(0L));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new TapLongIterable(new LongArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new TapLongIterable(new LongArrayList(), System.out::println).min();
    }

    @Test
    public void average()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new TapLongIterable(new LongArrayList(), System.out::println).average();
    }

    @Test
    public void median()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new TapLongIterable(new LongArrayList(), System.out::println).median();
    }

    @Test
    public void toArray()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertArrayEquals(new long[]{1, 2, 3, 4, 5}, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.contains(1L));
        Assert.assertTrue(iterable.contains(2L));
        Assert.assertFalse(iterable.contains(6L));
    }

    @Test
    public void containsAllArray()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll(1L));
        Assert.assertTrue(iterable.containsAll(2L));
        Assert.assertTrue(iterable.containsAll(1L, 2L));
        Assert.assertTrue(iterable.containsAll(1L, 2L, 3L));
        Assert.assertFalse(iterable.containsAll(4L, 5L, 6L));
    }

    @Test
    public void containsAllIterable()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(2L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L, 2L)));
        Assert.assertTrue(iterable.containsAll(LongArrayList.newListWith(1L, 2L, 3L)));
        Assert.assertFalse(iterable.containsAll(LongArrayList.newListWith(4L, 5L, 6L)));
    }

    @Test
    public void toSortedArray()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertArrayEquals(new long[]{1, 2, 3, 4, 5}, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(LongHashSet.newSetWith(1L, 2L, 3L, 4L, 5L), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L, 4L, 5L), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyLongIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        StringBuilder builder = new StringBuilder();
        TapLongIterable iterable = new TapLongIterable(this.list, builder::append);

        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(15L), result);
    }
}
