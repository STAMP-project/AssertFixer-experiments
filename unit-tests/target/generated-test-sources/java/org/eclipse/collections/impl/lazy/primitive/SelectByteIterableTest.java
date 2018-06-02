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

import org.eclipse.collections.api.LazyByteIterable;
import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectByteIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectByteIterableTest
{
    private final SelectByteIterable iterable =
        new SelectByteIterable(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), BytePredicates.lessThan((byte) 3));

    @Test
    public void byteIterator()
    {
        long sum = 0L;
        for (ByteIterator iterator = this.iterable.byteIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        this.iterable.forEach((byte each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(BytePredicates.lessThan((byte) 2)));
        Assert.assertEquals(0L, this.iterable.count(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(this.iterable.anySatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.iterable.allSatisfy(BytePredicates.greaterThan((byte) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertFalse(this.iterable.allSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertTrue(this.iterable.allSatisfy(BytePredicates.lessThan((byte) 4)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.iterable.noneSatisfy(BytePredicates.lessThan((byte) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(BytePredicates.lessThan((byte) 2)));
        Assert.assertTrue(this.iterable.noneSatisfy(BytePredicates.lessThan((byte) 1)));
        Assert.assertTrue(this.iterable.noneSatisfy(BytePredicates.greaterThan((byte) 4)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(1, this.iterable.select(BytePredicates.greaterThan((byte) 1)));
        Verify.assertSize(0, this.iterable.select(BytePredicates.lessThan((byte) 0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(BytePredicates.greaterThan((byte) 1)));
        Verify.assertSize(0, this.iterable.reject(BytePredicates.greaterThan((byte) 0)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.iterable.detectIfNone(BytePredicates.lessThan((byte) 4), (byte) 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(BytePredicates.greaterThan((byte) 3), (byte) 0));
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
        Assert.assertEquals((byte) 2, this.iterable.max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals((byte) 1, this.iterable.min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((byte) 1, this.iterable.minIfEmpty((byte) 0));
        Assert.assertEquals(
                (byte) 0,
                this.iterable.select(BytePredicates.lessThan((byte) 0)).minIfEmpty((byte) 0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((byte) 2, this.iterable.maxIfEmpty((byte) 0));
        Assert.assertEquals(
                (byte) 0,
                this.iterable.select(BytePredicates.lessThan((byte) 0)).maxIfEmpty((byte) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new SelectByteIterable(new ByteArrayList(), BytePredicates.lessThan((byte) 3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new SelectByteIterable(new ByteArrayList(), BytePredicates.lessThan((byte) 3)).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new SelectByteIterable(new ByteArrayList(), BytePredicates.lessThan((byte) 3)).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new SelectByteIterable(new ByteArrayList(), BytePredicates.lessThan((byte) 3)).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new byte[]{1, 2}, this.iterable.toArray());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains((byte) 1));
        Assert.assertTrue(this.iterable.contains((byte) 2));
        Assert.assertFalse(this.iterable.contains((byte) 3));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll((byte) 1));
        Assert.assertTrue(this.iterable.containsAll((byte) 2));
        Assert.assertTrue(this.iterable.containsAll((byte) 1, (byte) 2));
        Assert.assertFalse(this.iterable.containsAll((byte) 1, (byte) 2, (byte) 3));
        Assert.assertFalse(this.iterable.containsAll((byte) 4, (byte) 5, (byte) 6));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(ByteArrayList.newListWith((byte) 1)));
        Assert.assertTrue(this.iterable.containsAll(ByteArrayList.newListWith((byte) 2)));
        Assert.assertTrue(this.iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2)));
        Assert.assertFalse(this.iterable.containsAll(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
        Assert.assertFalse(this.iterable.containsAll(ByteArrayList.newListWith((byte) 4, (byte) 5, (byte) 6)));
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new byte[]{1, 2}, this.iterable.toSortedArray());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), this.iterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(ByteHashSet.newSetWith((byte) 1, (byte) 2), this.iterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2), this.iterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyByteIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        MutableByte result = this.iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 3), result);
    }
}
