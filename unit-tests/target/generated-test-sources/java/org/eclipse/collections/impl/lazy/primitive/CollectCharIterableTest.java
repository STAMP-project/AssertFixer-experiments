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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file collectPrimitiveIterableTest.stg.
 */
public class CollectCharIterableTest
{
    private final CharIterable charIterable = Interval.oneTo(3).collectChar(PrimitiveFunctions.unboxIntegerToChar());

    @Test
    public void iterator()
    {
        long sum = 0L;
        CharIterator iterator = this.charIterable.charIterator();
        while (iterator.hasNext())
        {
            sum += iterator.next();
        }
        Assert.assertEquals(6L, sum);
    }

    @Test
    public void size()
    {
        Assert.assertEquals(3L, this.charIterable.size());
    }

    @Test
    public void empty()
    {
        Assert.assertTrue(this.charIterable.notEmpty());
        Assert.assertFalse(this.charIterable.isEmpty());
    }

    @Test
    public void forEach()
    {
        long[] value = new long[1];
        this.charIterable.forEach(each -> { value[0] += each; });
        Assert.assertEquals(6L, value[0]);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(1, this.charIterable.count(CharPredicates.equal((char) 1)));
        Assert.assertEquals(3, this.charIterable.count(CharPredicates.lessThan((char) 4)));
        Assert.assertEquals(2, this.charIterable.count(CharPredicates.greaterThan((char) 1)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.charIterable.anySatisfy(CharPredicates.greaterThan((char) 1)));
        Assert.assertTrue(this.charIterable.anySatisfy(CharPredicates.equal((char) 1)));
        Assert.assertFalse(this.charIterable.anySatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.charIterable.noneSatisfy(CharPredicates.greaterThan((char) 2)));
        Assert.assertTrue(this.charIterable.noneSatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.charIterable.allSatisfy(CharPredicates.lessThan((char) 4)));
        Assert.assertFalse(this.charIterable.allSatisfy(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void select()
    {
        Assert.assertEquals(3L, this.charIterable.select(CharPredicates.lessThan((char) 4)).size());
        Assert.assertEquals(2L, this.charIterable.select(CharPredicates.lessThan((char) 3)).size());
    }

    @Test
    public void reject()
    {
        Assert.assertEquals(0L, this.charIterable.reject(CharPredicates.lessThan((char) 4)).size());
        Assert.assertEquals(1L, this.charIterable.reject(CharPredicates.lessThan((char) 3)).size());
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals((char) 1, this.charIterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals((char) 0, this.charIterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(6L, this.charIterable.sum());
    }

    @Test
    public void max()
    {
        Assert.assertEquals((char) 3, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals((char) 0, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((char) 0, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).minIfEmpty((char) 0));
        Assert.assertEquals((char) 0, FastList.<Integer>newList().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).minIfEmpty((char) 0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((char) 3, Interval.fromTo(0, 3).collectChar(PrimitiveFunctions.unboxIntegerToChar()).maxIfEmpty((char) 0));
        Assert.assertEquals((char) 0, FastList.<Integer>newList().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).maxIfEmpty((char) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectChar(PrimitiveFunctions.unboxIntegerToChar()).average(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.5, Interval.oneTo(4).collectChar(PrimitiveFunctions.unboxIntegerToChar()).median(), 0.001);
        Assert.assertEquals(4.0, Interval.oneTo(7).collectChar(PrimitiveFunctions.unboxIntegerToChar()).median(), 0.001);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        Lists.mutable.<Integer>of().asLazy().collectChar(PrimitiveFunctions.unboxIntegerToChar()).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new char[]{(char) 1, (char) 2, (char) 3, (char) 4},
                Interval.oneTo(4).collectChar(PrimitiveFunctions.unboxIntegerToChar()).toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new char[]{(char) 1, (char) 2, (char) 3, (char) 4},
                Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar()).toSortedArray());
    }

    @Test
    public void contains()
    {
        CharIterable charIterable = Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertTrue(charIterable.contains((char) 1));
        Assert.assertTrue(charIterable.contains((char) 3));
        Assert.assertTrue(charIterable.contains((char) 4));
        Assert.assertFalse(charIterable.contains((char) 5));
    }

    @Test
    public void containsAllArray()
    {
        CharIterable charIterable = Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertTrue(charIterable.containsAll((char) 1));
        Assert.assertTrue(charIterable.containsAll((char) 1, (char) 2, (char) 3, (char) 4));
        Assert.assertFalse(charIterable.containsAll((char) 1, (char) 2, (char) 3, (char) 4, (char) 5));
        Assert.assertFalse(charIterable.containsAll((char) 7, (char) 6, (char) 5));
    }

    @Test
    public void containsAllIterable()
    {
        CharIterable charIterable = Interval.fromTo(4, 1).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertTrue(charIterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(charIterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4)));
        Assert.assertFalse(charIterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5)));
        Assert.assertFalse(charIterable.containsAll(CharArrayList.newListWith((char) 7, (char) 6, (char) 5)));
    }

    @Test
    public void collect()
    {
        Assert.assertEquals(FastList.newListWith("\u0001", "\u0002", "\u0003"), this.charIterable.collect(String::valueOf).toList());
    }

    @Test
    public void testToString()
    {
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.charIterable.toString());
    }

    @Test
    public void makeString()
    {
        Assert.assertEquals("\u0001, \u0002, \u0003", this.charIterable.makeString());
        Assert.assertEquals("\u0001/\u0002/\u0003", this.charIterable.makeString("/"));
        Assert.assertEquals("[\u0001, \u0002, \u0003]", this.charIterable.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString()
    {
        StringBuilder appendable = new StringBuilder();
        this.charIterable.appendString(appendable);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        this.charIterable.appendString(appendable2, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        this.charIterable.appendString(appendable3, "[", ", ", "]");
        Assert.assertEquals(this.charIterable.toString(), appendable3.toString());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.charIterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), this.charIterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), this.charIterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), this.charIterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.charIterable.toSet(), this.charIterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, this.charIterable.asLazy());
    }
}
