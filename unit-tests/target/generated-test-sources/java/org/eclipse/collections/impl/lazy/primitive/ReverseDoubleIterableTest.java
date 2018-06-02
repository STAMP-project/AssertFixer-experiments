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
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseDoubleIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseDoubleIterableTest
{
    @Test
    public void isEmpty()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertEmpty(new DoubleArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertFalse(iterable.contains(0.0));
        Assert.assertTrue(iterable.contains(1.0));
    }

    @Test
    public void containsAllArray()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.containsAll(1.0));
        Assert.assertTrue(iterable.containsAll(1.0, 2.0, 3.0));
        Assert.assertFalse(iterable.containsAll(1.0, 2.0, 3.0, 4.0));
    }

    @Test
    public void containsAllIterable()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0)));
        Assert.assertTrue(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
        Assert.assertFalse(iterable.containsAll(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0)));
    }

    @Test
    public void iterator()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        DoubleIterator iterator = iterable.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2.0, iterator.next(), 0.0);
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        DoubleIterator iterator = iterable.doubleIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Test
    public void forEach()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        double[] sum = new double[1];
        iterable.forEach((double each) -> sum[0] += each);

        Assert.assertEquals(6.0, sum[0], 0.0);
    }

    @Test
    public void size()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(0, new DoubleArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(2L, DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().count(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, -1.0, 2.0).asReversed().anySatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, -1.0, 2.0).asReversed().anySatisfy(DoublePredicates.equal(0.0)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().allSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, 2.0, 3.0).asReversed().allSatisfy(DoublePredicates.greaterThan(0.0)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(DoubleArrayList.newListWith(1.0, 0.0, 2.0).asReversed().noneSatisfy(DoublePredicates.greaterThan(0.0)));
        Assert.assertTrue(DoubleArrayList.newListWith(1.0, 2.0, 3.0).asReversed().noneSatisfy(DoublePredicates.greaterThan(3.0)));
    }

    @Test
    public void select()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(3, iterable.select(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(2, iterable.select(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void reject()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertSize(0, iterable.reject(DoublePredicates.lessThan(4.0)));
        Verify.assertSize(1, iterable.reject(DoublePredicates.lessThan(3.0)));
    }

    @Test
    public void detectIfNone()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals(1.0, iterable.detectIfNone(DoublePredicates.lessThan(4.0), 0.0), 0.0);
        Assert.assertEquals(0.0, iterable.detectIfNone(DoublePredicates.greaterThan(3.0), 0.0), 0.0);
    }

    @Test
    public void collect()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith(0.0, 1.0, 2.0), iterable.collect((double parameter) -> parameter - 1));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(9.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().max(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList()
    {
        new DoubleArrayList().asReversed().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().min(), 0.0);
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList()
    {
        new DoubleArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5.0, new DoubleArrayList().asReversed().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleArrayList().asReversed().minIfEmpty(0.0), 0.0);
        Assert.assertEquals(0.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().minIfEmpty(5.0), 0.0);
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5.0, new DoubleArrayList().asReversed().maxIfEmpty(5.0), 0.0);
        Assert.assertEquals(0.0, new DoubleArrayList().asReversed().maxIfEmpty(0.0), 0.0);
        Assert.assertEquals(9.0, DoubleArrayList.newListWith(1.0, 0.0, 9.0, 7.0).asReversed().maxIfEmpty(5.0), 0.0);
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(10.0, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().sum(), 0.0);
    }

    @Test
    public void sumConsistentRounding()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(
                Interval.oneTo(100_000)
                        .toList()
                        .shuffleThis()
                        .collectDouble(i -> 1.0 / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()))
                        .asReversed()
                        .toArray());

        Assert.assertEquals(
                1.082323233711138,
                iterable.sum(),
                1.0e-15);
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.5, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().average(), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.5, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0).asReversed().median(), 0.0);
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new double[]{3.0, 4.0, 2.0, 1.0}, DoubleArrayList.newListWith(1.0, 2.0, 4.0, 3.0).asReversed().toArray(), 0.0);
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new double[]{1.0, 3.0, 7.0, 9.0}, DoubleArrayList.newListWith(3.0, 1.0, 9.0, 7.0).asReversed().toSortedArray(), 0.0);
    }

    @Test
    public void testToString()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals("[1.0, 2.0, 3.0]", iterable.toString());
        Assert.assertEquals("[]", new DoubleArrayList().asReversed().toString());
    }

    @Test
    public void makeString()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        Assert.assertEquals("1.0, 2.0, 3.0", iterable.makeString());
        Assert.assertEquals("1.0", DoubleArrayList.newListWith(1.0).makeString("/"));
        Assert.assertEquals("1.0/2.0/3.0", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new DoubleArrayList().asReversed().makeString());
    }

    @Test
    public void appendString()
    {
        DoubleIterable iterable = DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed();
        StringBuilder appendable = new StringBuilder();
        new DoubleArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("1.0, 2.0, 3.0", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("1.0/2.0/3.0", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(2.0, 1.0), DoubleArrayList.newListWith(1.0, 2.0).asReversed().toList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(DoubleHashSet.newSetWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(3.0, 2.0, 1.0).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), DoubleArrayList.newListWith(2.0, 3.0, 1.0).asReversed().toSortedList());
    }
}
