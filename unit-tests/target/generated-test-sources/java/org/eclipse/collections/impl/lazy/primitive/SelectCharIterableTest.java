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

import org.eclipse.collections.api.LazyCharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SelectCharIterable}.
 * This file was automatically generated from template file primitiveSelectIterableTest.stg.
 */
public class SelectCharIterableTest
{
    private final SelectCharIterable iterable =
        new SelectCharIterable(CharArrayList.newListWith((char) 1, (char) 2, (char) 3, (char) 4, (char) 5), CharPredicates.lessThan((char) 3));

    @Test
    public void charIterator()
    {
        long sum = 0L;
        for (CharIterator iterator = this.iterable.charIterator(); iterator.hasNext(); )
        {
            sum += iterator.next();
        }
        Assert.assertEquals(3L, sum);
    }

    @Test
    public void forEach()
    {
        long[] sum = new long[1];
        this.iterable.forEach((char each) -> sum[0] += each);
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
        Assert.assertEquals(1L, this.iterable.count(CharPredicates.lessThan((char) 2)));
        Assert.assertEquals(0L, this.iterable.count(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.iterable.anySatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.iterable.anySatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.iterable.allSatisfy(CharPredicates.greaterThan((char) 0)));
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertFalse(this.iterable.allSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertTrue(this.iterable.allSatisfy(CharPredicates.lessThan((char) 4)));
    }

    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.lessThan((char) 0)));
        Assert.assertFalse(this.iterable.noneSatisfy(CharPredicates.lessThan((char) 2)));
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.lessThan((char) 1)));
        Assert.assertTrue(this.iterable.noneSatisfy(CharPredicates.greaterThan((char) 4)));
    }

    @Test
    public void select()
    {
        Verify.assertSize(1, this.iterable.select(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, this.iterable.select(CharPredicates.lessThan((char) 0)));
    }

    @Test
    public void reject()
    {
        Verify.assertSize(1, this.iterable.reject(CharPredicates.greaterThan((char) 1)));
        Verify.assertSize(0, this.iterable.reject(CharPredicates.greaterThan((char) 0)));
    }

    @Test
    public void detectIfNone()
    {
        Assert.assertEquals(1L, this.iterable.detectIfNone(CharPredicates.lessThan((char) 4), (char) 0));
        Assert.assertEquals(0L, this.iterable.detectIfNone(CharPredicates.greaterThan((char) 3), (char) 0));
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
        Assert.assertEquals((char) 2, this.iterable.max());
    }

    @Test
    public void min()
    {
        Assert.assertEquals((char) 1, this.iterable.min());
    }

    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((char) 1, this.iterable.minIfEmpty((char) 0));
        Assert.assertEquals(
                (char) 0,
                this.iterable.select(CharPredicates.lessThan((char) 0)).minIfEmpty((char) 0));
    }

    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((char) 2, this.iterable.maxIfEmpty((char) 0));
        Assert.assertEquals(
                (char) 0,
                this.iterable.select(CharPredicates.lessThan((char) 0)).maxIfEmpty((char) 0));
    }

    @Test(expected = NoSuchElementException.class)
    public void maxThrowsOnEmpty()
    {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).max();
    }

    @Test(expected = NoSuchElementException.class)
    public void minThrowsOnEmpty()
    {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).min();
    }

    @Test
    public void average()
    {
        Assert.assertEquals(1.5d, this.iterable.average(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void averageThrowsOnEmpty()
    {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).average();
    }

    @Test
    public void median()
    {
        Assert.assertEquals(1.5d, this.iterable.median(), 0.0);
    }

    @Test(expected = ArithmeticException.class)
    public void medianThrowsOnEmpty()
    {
        new SelectCharIterable(new CharArrayList(), CharPredicates.lessThan((char) 3)).median();
    }

    @Test
    public void toArray()
    {
        Assert.assertArrayEquals(new char[]{1, 2}, this.iterable.toArray());
    }

    @Test
    public void contains()
    {
        Assert.assertTrue(this.iterable.contains((char) 1));
        Assert.assertTrue(this.iterable.contains((char) 2));
        Assert.assertFalse(this.iterable.contains((char) 3));
    }

    @Test
    public void containsAllArray()
    {
        Assert.assertTrue(this.iterable.containsAll((char) 1));
        Assert.assertTrue(this.iterable.containsAll((char) 2));
        Assert.assertTrue(this.iterable.containsAll((char) 1, (char) 2));
        Assert.assertFalse(this.iterable.containsAll((char) 1, (char) 2, (char) 3));
        Assert.assertFalse(this.iterable.containsAll((char) 4, (char) 5, (char) 6));
    }

    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.iterable.containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(this.iterable.containsAll(CharArrayList.newListWith((char) 2)));
        Assert.assertTrue(this.iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2)));
        Assert.assertFalse(this.iterable.containsAll(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
        Assert.assertFalse(this.iterable.containsAll(CharArrayList.newListWith((char) 4, (char) 5, (char) 6)));
    }

    @Test
    public void toSortedArray()
    {
        Assert.assertArrayEquals(new char[]{1, 2}, this.iterable.toSortedArray());
    }

    @Test
    public void toList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), this.iterable.toList());
    }

    @Test
    public void toSortedList()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2), this.iterable.toSortedList());
    }

    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1, (char) 2), this.iterable.toSet());
    }

    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2), this.iterable.toBag());
    }

    @Test
    public void asLazy()
    {
        Assert.assertEquals(this.iterable.toSet(), this.iterable.asLazy().toSet());
        Verify.assertInstanceOf(LazyCharIterable.class, this.iterable.asLazy());
        Assert.assertSame(this.iterable, this.iterable.asLazy());
    }

    @Test
    public void injectInto()
    {
        MutableCharacter result = this.iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 3), result);
    }
}
