/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.immutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableLongCollection;
import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableLongEmptyListTest extends AbstractImmutableLongListTestCase
{
    @Override
    protected ImmutableLongList classUnderTest()
    {
        return ImmutableLongEmptyList.INSTANCE;
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void get()
    {
        this.classUnderTest().get(1);
    }

    @Override
    @Test
    public void newWithout()
    {
        ImmutableLongCollection emptyCollection = this.classUnderTest();
        ImmutableLongCollection newCollection = emptyCollection.newWithout(9L);
        Assert.assertEquals(this.newMutableCollectionWith(), newCollection);
        Assert.assertSame(emptyCollection, newCollection);
        Assert.assertEquals(this.newMutableCollectionWith(), emptyCollection);
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getFirst()
    {
        this.classUnderTest().getFirst();
    }

    @Override
    @Test(expected = IndexOutOfBoundsException.class)
    public void getLast()
    {
        this.classUnderTest().getLast();
    }

    @Override
    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void select()
    {
        super.select();
        LongIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(LongPredicates.lessThan(4L)));
        LongIterable longIterable = iterable.select(LongPredicates.greaterThan(4L));
        Verify.assertEmpty(longIterable);
        Assert.assertSame(iterable, longIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        LongIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(LongPredicates.lessThan(4L)));
        LongIterable longIterable = iterable.reject(LongPredicates.greaterThan(4L));
        Verify.assertEmpty(longIterable);
        Assert.assertSame(iterable, longIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1L, 2L, 3L));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1L));
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average()
    {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void averageIfEmpty()
    {
        Assert.assertEquals(1.2, this.classUnderTest().averageIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median()
    {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void medianIfEmpty()
    {
        Assert.assertEquals(1.2, this.classUnderTest().medianIfEmpty(1.2), 0.0);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max()
    {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min()
    {
        this.classUnderTest().min();
    }

    @Test
    public void dotProduct()
    {
        ImmutableLongEmptyList list1 = new ImmutableLongEmptyList();
        ImmutableLongEmptyList list2 = new ImmutableLongEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableLongEmptyList list1 = new ImmutableLongEmptyList();
        ImmutableLongArrayList list2 = ImmutableLongArrayList.newListWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableLongEmptyList iterable = new ImmutableLongEmptyList();
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(0L), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableLongList list1 = this.newWith();
        ImmutableLongList list2 = this.newWith(1L, 2L, 3L);
        MutableLong result = list1.injectIntoWithIndex(new MutableLong(0L), (MutableLong object, long value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableLong(0L), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(LongLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((long each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], 0L);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(7L));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0L));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(100L));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(-1L));
    }
}
