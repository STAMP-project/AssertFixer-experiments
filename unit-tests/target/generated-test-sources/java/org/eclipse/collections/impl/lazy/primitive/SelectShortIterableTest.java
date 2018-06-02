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

import org.eclipse.collections.api.LazyShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectShortIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectShortIterableTest
{
    private final SelectShortIterable iterable =
        new SelectShortIterable(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), ShortPredicates.lessThan((short) 3));

    @Test
    public void shortIterator()
    {
        long sum = 0L;
        for (ShortIterator iterator = this.iterable.shortIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        this.iterable.forEach((short each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(ShortPredicates.lessThan((short) 2)));
        Assert.assertEquals(0L, this.iterable.count(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.iterable.anySatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.iterable.allSatisfy(ShortPredicates.greaterThan((short) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertFalse(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertTrue(this.iterable.allSatisfy(ShortPredicates.lessThan((short) 4)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.lessThan((short) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(ShortPredicates.lessThan((short) 2)));
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.lessThan((short) 1)));
        Assert.assertTrue(this.iterable.noneSatisfy(ShortPredicates.greaterThan((short) 4)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(1, this.iterable.select(ShortPredicates.greaterThan((short) 1)));
        Verify.assertSize(0, this.iterable.select(ShortPredicates.lessThan((short) 0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(ShortPredicates.greaterThan((short) 1)));
        Verify.assertSize(0, this.iterable.reject(ShortPredicates.greaterThan((short) 0)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.iterable.detectIfNone(ShortPredicates.lessThan((short) 4), (short) 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(ShortPredicates.greaterThan((short) 3), (short) 0));
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
        Assert.assertEquals((short) 2, this.iterable.max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals((short) 1, this.iterable.min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((short) 1, this.iterable.minIfEmpty((short) 0));
        Assert.assertEquals(
                (short) 0,
                this.iterable.select(ShortPredicates.lessThan((short) 0)).minIfEmpty((short) 0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((short) 2, this.iterable.maxIfEmpty((short) 0));
        Assert.assertEquals(
                (short) 0,
                this.iterable.select(ShortPredicates.lessThan((short) 0)).maxIfEmpty((short) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new SelectShortIterable(new ShortArrayList(), ShortPredicates.lessThan((short) 3)).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new short[]{1, 2}, this.iterable.toArray());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains((short) 1));
        Assert.assertTrue(this.iterable.contains((short) 2));
        Assert.assertFalse(this.iterable.contains((short) 3));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll((short) 1));
        Assert.assertTrue(this.iterable.containsAll((short) 2));
        Assert.assertTrue(this.iterable.containsAll((short) 1, (short) 2));
        Assert.assertFalse(this.iterable.containsAll((short) 1, (short) 2, (short) 3));
        Assert.assertFalse(this.iterable.containsAll((short) 4, (short) 5, (short) 6));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(ShortArrayList.newListWith((short) 1)));
        Assert.assertTrue(this.iterable.containsAll(ShortArrayList.newListWith((short) 2)));
        Assert.assertTrue(this.iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2)));
        Assert.assertFalse(this.iterable.containsAll(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
        Assert.assertFalse(this.iterable.containsAll(ShortArrayList.newListWith((short) 4, (short) 5, (short) 6)));
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new short[]{1, 2}, this.iterable.toSortedArray());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), this.iterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(ShortHashSet.newSetWith((short) 1, (short) 2), this.iterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2), this.iterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyShortIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        MutableShort result = this.iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 3), result);
    }
}
