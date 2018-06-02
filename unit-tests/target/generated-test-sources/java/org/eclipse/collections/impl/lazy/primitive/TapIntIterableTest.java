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

import org.eclipse.collections.api.LazyIntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.list.primitive.IntList;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapIntIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapIntIterableTest
{
    private final IntList list = IntLists.immutable.with(1, 2, 3, 4, 5);

    @Test
    public void intIterator()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        long sum = 0L;
        for (IntIterator iterator = iterable.intIterator(); iterator.hasNext(); )
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
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        long[] sum = new long[1];
        iterable.forEach((int each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.count(IntPredicates.lessThan(2)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.anySatisfy(IntPredicates.lessThan(2)));
        Assert.assertTrue(iterable.anySatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void allSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.allSatisfy(IntPredicates.greaterThan(0)));
        Assert.assertFalse(iterable.allSatisfy(IntPredicates.lessThan(2)));
        Assert.assertFalse(iterable.allSatisfy(IntPredicates.lessThan(1)));
        Assert.assertFalse(iterable.allSatisfy(IntPredicates.lessThan(4)));
    }

    @Test
    public void noneSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.noneSatisfy(IntPredicates.lessThan(0)));
        Assert.assertFalse(iterable.noneSatisfy(IntPredicates.lessThan(2)));
        Assert.assertTrue(iterable.noneSatisfy(IntPredicates.lessThan(1)));
        Assert.assertFalse(iterable.noneSatisfy(IntPredicates.greaterThan(4)));
    }

    @Test
    public void select()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Verify.assertSize(4, iterable.select(IntPredicates.greaterThan(1)));
        Verify.assertSize(0, iterable.select(IntPredicates.lessThan(0)));
    }

    @Test
    public void reject()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Verify.assertSize(1, iterable.reject(IntPredicates.greaterThan(1)));
        Verify.assertSize(0, iterable.reject(IntPredicates.greaterThan(0)));
    }

    @Test
    public void detectIfNone()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.detectIfNone(IntPredicates.lessThan(4), 0));
        Assert.assertEquals(4L, iterable.detectIfNone(IntPredicates.greaterThan(3), 0));
    }

    @Test
    public void collect()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(5, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(1, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(1, iterable.minIfEmpty(0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(5, iterable.maxIfEmpty(0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new TapIntIterable(new IntArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new TapIntIterable(new IntArrayList(), System.out::println).min();
    }

    @Test
    public void average()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new TapIntIterable(new IntArrayList(), System.out::println).average();
    }

    @Test
    public void median()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new TapIntIterable(new IntArrayList(), System.out::println).median();
    }

    @Test
    public void toArray()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.contains(1));
        Assert.assertTrue(iterable.contains(2));
        Assert.assertFalse(iterable.contains(6));
    }

    @Test
    public void containsAllArray()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll(1));
        Assert.assertTrue(iterable.containsAll(2));
        Assert.assertTrue(iterable.containsAll(1, 2));
        Assert.assertTrue(iterable.containsAll(1, 2, 3));
        Assert.assertFalse(iterable.containsAll(4, 5, 6));
    }

    @Test
    public void containsAllIterable()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(2)));
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1, 2)));
        Assert.assertTrue(iterable.containsAll(IntArrayList.newListWith(1, 2, 3)));
        Assert.assertFalse(iterable.containsAll(IntArrayList.newListWith(4, 5, 6)));
    }

    @Test
    public void toSortedArray()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertArrayEquals(new int[]{1, 2, 3, 4, 5}, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(IntHashSet.newSetWith(1, 2, 3, 4, 5), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4, 5), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyIntIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        StringBuilder builder = new StringBuilder();
        TapIntIterable iterable = new TapIntIterable(this.list, builder::append);

        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(15), result);
    }
}
