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
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ReverseCharIterable}.
 * This file was automatically generated from template file reversePrimitiveIterableTest.stg.
 */
public class ReverseCharIterableTest
{
    @Test
    public void isEmpty()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Verify.assertEmpty(new CharArrayList().asReversed());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void contains()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertFalse(iterable.contains((char) 0));
        Assert.assertTrue(iterable.contains((char) 1));
    }

    @Test
    public void containsAllArray()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertTrue(iterable.containsAll((char) 1));
        Assert.assertTrue(iterable.containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(iterable.containsAll((char) 1, (char) 2, (char) 3, (char) 4));
    }

    @Test
    public void containsAllIterable()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4)));
    }

    @Test
    public void iterator()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        CharIterator iterator = iterable.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(2L, iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(3L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        CharIterator iterator = iterable.charIterator();
        while (iterator.hasNext())
        {
            iterator.next();
        }

        iterator.next();
    }

    @Test
    public void forEach()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        long[] sum = new long[1];
        iterable.forEach((char each) -> sum[0] += each);

        Assert.assertEquals(6L, sum[0]);
    }

    @Test
    public void size()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Verify.assertSize(0, new CharArrayList().asReversed());
        Verify.assertSize(3, iterable);
    }

    @Test
    public void empty()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertTrue(iterable.notEmpty());
        Verify.assertNotEmpty(iterable);
    }

    @Test
    public void count()
    {
        Assert.assertEquals(2L, CharArrayList.newListWith((char) 1, (char) 0, (char) 2).asReversed().count(CharPredicates.greaterThan('\0')));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(CharArrayList.newListWith((char) 1, (char) -1, (char) 2).asReversed().anySatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(CharArrayList.newListWith((char) 1, (char) -1, (char) 2).asReversed().anySatisfy(CharPredicates.equal((char) 0)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(CharArrayList.newListWith((char) 1, (char) 0, (char) 2).asReversed().allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(CharArrayList.newListWith((char) 1, (char) 2, (char) 3).asReversed().allSatisfy(CharPredicates.greaterThan((char) 0)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(CharArrayList.newListWith((char) 1, (char) 0, (char) 2).asReversed().noneSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertTrue(CharArrayList.newListWith((char) 1, (char) 2, (char) 3).asReversed().noneSatisfy(CharPredicates.greaterThan((char) 3)));
    }

    @Test
    public void select()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Verify.assertSize(3, iterable.select(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(2, iterable.select(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void reject()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Verify.assertSize(0, iterable.reject(CharPredicates.lessThan((char) 4)));
        Verify.assertSize(1, iterable.reject(CharPredicates.lessThan((char) 3)));
    }

    @Test
    public void detectIfNone()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertEquals(1L, iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(0L, iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
    }

    @Test
    public void collect()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Verify.assertIterablesEqual(FastList.newListWith((char) 0, (char) 1, (char) 2), iterable.collect((char parameter) -> (char) (parameter - 1)));
    }

    @Test
    public void max()
    {
        Assert.assertEquals(9L, CharArrayList.newListWith((char) 1, (char) 0, (char) 9, (char) 7).asReversed().max());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_throws_emptyList()
    {
        new CharArrayList().asReversed().max();
    }

    @Test
    public void min()
    {
        Assert.assertEquals(0L, CharArrayList.newListWith((char) 1, (char) 0, (char) 9, (char) 7).asReversed().min());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_throws_emptyList()
    {
        new CharArrayList().asReversed().min();
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5L, new CharArrayList().asReversed().minIfEmpty((char) 5));
        Assert.assertEquals(0L, new CharArrayList().asReversed().minIfEmpty((char) 0));
        Assert.assertEquals(0L, CharArrayList.newListWith((char) 1, (char) 0, (char) 9, (char) 7).asReversed().minIfEmpty((char) 5));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(5L, new CharArrayList().asReversed().maxIfEmpty((char) 5));
        Assert.assertEquals(0L, new CharArrayList().asReversed().maxIfEmpty((char) 0));
        Assert.assertEquals(9L, CharArrayList.newListWith((char) 1, (char) 0, (char) 9, (char) 7).asReversed().maxIfEmpty((char) 5));
    }

    @Test
    public void sum()
    {
        Assert.assertEquals(10L, CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4).asReversed().sum());
    }

    @Test
    public void average()
    {
        Assert.assertEquals(2.5, CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4).asReversed().average(), 0.0);
    }

    @Test
    public void median()
    {
        Assert.assertEquals(2.5, CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4).asReversed().median(), 0.0);
        Assert.assertEquals(3.0, CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5).asReversed().median(), 0.0);
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new char[]{(char) 3, (char) 4, (char) 2, (char) 1}, CharArrayList.newListWith((char) 1, (char) 2, (char) 4, (char) 3).asReversed().toArray());
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new char[]{(char) 1, (char) 3, (char) 7, (char) 9}, CharArrayList.newListWith((char) 3, (char) 1, (char) 9, (char) 7).asReversed().toSortedArray());
    }

    @Test
    public void testToString()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertEquals("[\u0001, \u0002, \u0003]", iterable.toString());
        Assert.assertEquals("[]", new CharArrayList().asReversed().toString());
    }

    @Test
    public void makeString()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        Assert.assertEquals("\u0001, \u0002, \u0003", iterable.makeString());
        Assert.assertEquals("\u0001", CharArrayList.newListWith((char) 1).makeString("/"));
        Assert.assertEquals("\u0001/\u0002/\u0003", iterable.makeString("/"));
        Assert.assertEquals(iterable.toString(), iterable.makeString("[", ", ", "]"));
        Assert.assertEquals("", new CharArrayList().asReversed().makeString());
    }

    @Test
    public void appendString()
    {
        CharIterable iterable = CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed();
        StringBuilder appendable = new StringBuilder();
        new CharArrayList().asReversed().appendString(appendable);
        Assert.assertEquals("", appendable.toString());
        StringBuilder appendable2 = new StringBuilder();
        iterable.appendString(appendable2);
        Assert.assertEquals("\u0001, \u0002, \u0003", appendable2.toString());
        StringBuilder appendable3 = new StringBuilder();
        iterable.appendString(appendable3, "/");
        Assert.assertEquals("\u0001/\u0002/\u0003", appendable3.toString());
        StringBuilder appendable4 = new StringBuilder();
        iterable.appendString(appendable4, "[", ", ", "]");
        Assert.assertEquals(iterable.toString(), appendable4.toString());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 2, (char) 1), CharArrayList.newListWith((char) 1, (char) 2).asReversed().toList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2, (char) 3), CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed().toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed().toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), CharArrayList.newListWith((char) 3, (char) 2, (char) 1).asReversed().asLazy().toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), CharArrayList.newListWith((char) 2, (char) 3, (char) 1).asReversed().toSortedList());
    }
}
