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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.list.primitive.CharList;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link TapCharIterable}.
 * This file was automatically generated from template file primitiveTapIterableTest.stg.
 */
public class TapCharIterableTest
{
    private final CharList list = CharLists.immutable.with((char) 1, (char) 2, (char) 3, (char) 4, (char) 5);

    @Test
    public void charIterator()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        long sum = 0L;
        for (CharIterator iterator = iterable.charIterator(); iterator.hasNext(); )
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
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        long[] sum = new long[1];
        iterable.forEach((char each) -> sum[0] += each);
        Assert.assertEquals(15L, sum[0]);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void size()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Verify.assertSize(5, iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void empty()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void count()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void anySatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.anySatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(iterable.anySatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void allSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(iterable.allSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(iterable.allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(iterable.allSatisfy(CharPredicates.lessThan((char) 4)));
    }

    @Test
    public void noneSatisfy()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(iterable.noneSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(iterable.noneSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertFalse(iterable.noneSatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void select()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Verify.assertSize(4, iterable.select(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, iterable.select(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void reject()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Verify.assertSize(1, iterable.reject(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, iterable.reject(CharPredicates.greaterThan((char) 0)));
    }

    @Test
    public void detectIfNone()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(1L, iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(4L, iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
    }

    @Test
    public void collect()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Verify.assertIterableSize(5, iterable.collect(String::valueOf));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void sum()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(15L, iterable.sum());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void max()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals((char) 5, iterable.max());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void min()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals((char) 1, iterable.min());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void minIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals((char) 1, iterable.minIfEmpty((char) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void maxIfEmpty()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals((char) 5, iterable.maxIfEmpty((char) 0));
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new TapCharIterable(new CharArrayList(), System.out::println).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new TapCharIterable(new CharArrayList(), System.out::println).min();
    }

    @Test
    public void average()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.average(), 0.0);
        Assert.assertEquals(list.makeString("") + list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new TapCharIterable(new CharArrayList(), System.out::println).average();
    }

    @Test
    public void median()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(3.0d, iterable.median(), 0.0);
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new TapCharIterable(new CharArrayList(), System.out::println).median();
    }

    @Test
    public void toArray()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertArrayEquals(new char[]{1, 2, 3, 4, 5}, iterable.toArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void contains()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.contains((char) 1));
        Assert.assertTrue(iterable.contains((char) 2));
        Assert.assertFalse(iterable.contains((char) 6));
    }

    @Test
    public void containsAllArray()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll((char) 1));
        Assert.assertTrue(iterable.containsAll((char) 2));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(iterable.containsAll((char) 4, (char) 5, (char) 6));
    }

    @Test
    public void containsAllIterable()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 2)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(iterable.containsAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
    }

    @Test
    public void toSortedArray()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertArrayEquals(new char[]{1, 2, 3, 4, 5}, iterable.toSortedArray());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toList()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSortedList()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toSortedList());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toSet()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toSet());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void toBag()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), iterable.toBag());
        Assert.assertEquals(list.makeString(""), builder.toString());
    }

    @Test
    public void asLazy()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        Assert.assertEquals(iterable.toSet(), iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, iterable.asLazy());
        Assert.assertSame(iterable, iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        StringBuilder builder = new StringBuilder();
        TapCharIterable iterable = new TapCharIterable(this.list, builder::append);

        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 15), result);
    }
}
