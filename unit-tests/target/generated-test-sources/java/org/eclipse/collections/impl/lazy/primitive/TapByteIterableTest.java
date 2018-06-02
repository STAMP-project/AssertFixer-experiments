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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.list.primitive.ByteList;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapByteIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapByteIterableTest
{
    private final ByteList list = ByteLists.immutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);

    @Test
    public void byteIterator()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        long sum = 0L;
        for (ByteIterator iterator = iterable.byteIterator(); iterator.hasNext(); )
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
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        long[] sum = new long[1];
        iterable.forEach((byte each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.anySatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(iterable.anySatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void allSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(iterable.allSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(iterable.allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(iterable.allSatisfy(BytePredicates.lessThan((byte) 4)));
    }

    @Test
    public void noneSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(iterable.noneSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(iterable.noneSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertFalse(iterable.noneSatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void select()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Verify.assertSize(4, iterable.select(BytePredicates.greaterThan((byte) 1)));
        Verify.assertSize(0, iterable.select(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void reject()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Verify.assertSize(1, iterable.reject(BytePredicates.greaterThan((byte) 1)));
        Verify.assertSize(0, iterable.reject(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void detectIfNone()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals(4L, iterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
    }

    @Test
    public void collect()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals((byte) 5, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals((byte) 1, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals((byte) 1, iterable.minIfEmpty((byte) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals((byte) 5, iterable.maxIfEmpty((byte) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new TapByteIterable(new ByteArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new TapByteIterable(new ByteArrayList(), System.out::println).min();
    }

    @Test
    public void average()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new TapByteIterable(new ByteArrayList(), System.out::println).average();
    }

    @Test
    public void median()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new TapByteIterable(new ByteArrayList(), System.out::println).median();
    }

    @Test
    public void toArray()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.contains((byte) 1));
        Assert.assertTrue(iterable.contains((byte) 2));
        Assert.assertFalse(iterable.contains((byte) 6));
    }

    @Test
    public void containsAllArray()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll((byte) 1));
        Assert.assertTrue(iterable.containsAll((byte) 2));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2));
        Assert.assertTrue(iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(iterable.containsAll((byte) 4, (byte) 5, (byte) 6));
    }

    @Test
    public void containsAllIterable()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 2)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2)));
        Assert.assertTrue(iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(iterable.containsAll(ByteArrayList.newListWith((byte) 4, (byte) 5, (byte) 6)));
    }

    @Test
    public void toSortedArray()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertArrayEquals(new byte[]{1, 2, 3, 4, 5}, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        StringBuilder builder = new StringBuilder();
        TapByteIterable iterable = new TapByteIterable(this.list, builder::append);

        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 15), result);
    }
}
