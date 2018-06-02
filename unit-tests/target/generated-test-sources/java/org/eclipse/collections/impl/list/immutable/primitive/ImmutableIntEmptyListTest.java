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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableIntCollection;
import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableIntEmptyListTest extends AbstractImmutableIntListTestCase
{
    @Override
    protected ImmutableIntList classUnderTest()
    {
        return ImmutableIntEmptyList.INSTANCE;
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
        ImmutableIntCollection emptyCollection = this.classUnderTest();
        ImmutableIntCollection newCollection = emptyCollection.newWithout(9);
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
        IntIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(IntPredicates.lessThan(4)));
        IntIterable intIterable = iterable.select(IntPredicates.greaterThan(4));
        Verify.assertEmpty(intIterable);
        Assert.assertSame(iterable, intIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        IntIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(IntPredicates.lessThan(4)));
        IntIterable intIterable = iterable.reject(IntPredicates.greaterThan(4));
        Verify.assertEmpty(intIterable);
        Assert.assertSame(iterable, intIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1, 2, 3));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1));
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
        ImmutableIntEmptyList list1 = new ImmutableIntEmptyList();
        ImmutableIntEmptyList list2 = new ImmutableIntEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableIntEmptyList list1 = new ImmutableIntEmptyList();
        ImmutableIntArrayList list2 = ImmutableIntArrayList.newListWith(1, 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntEmptyList iterable = new ImmutableIntEmptyList();
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableIntList list1 = this.newWith();
        ImmutableIntList list2 = this.newWith(1, 2, 3);
        MutableInteger result = list1.injectIntoWithIndex(new MutableInteger(0), (MutableInteger object, int value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableInteger(0), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(IntLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((int each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(7));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(100));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(-1));
    }
}
