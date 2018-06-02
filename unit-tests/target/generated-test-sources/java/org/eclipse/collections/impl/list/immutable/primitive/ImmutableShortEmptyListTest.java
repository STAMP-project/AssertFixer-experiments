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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableShortCollection;
import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableShortEmptyListTest extends AbstractImmutableShortListTestCase
{
    @Override
    protected ImmutableShortList classUnderTest()
    {
        return ImmutableShortEmptyList.INSTANCE;
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
        ImmutableShortCollection emptyCollection = this.classUnderTest();
        ImmutableShortCollection newCollection = emptyCollection.newWithout((short) 9);
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
        ShortIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(ShortPredicates.lessThan((short) 4)));
        ShortIterable shortIterable = iterable.select(ShortPredicates.greaterThan((short) 4));
        Verify.assertEmpty(shortIterable);
        Assert.assertSame(iterable, shortIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ShortIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(ShortPredicates.lessThan((short) 4)));
        ShortIterable shortIterable = iterable.reject(ShortPredicates.greaterThan((short) 4));
        Verify.assertEmpty(shortIterable);
        Assert.assertSame(iterable, shortIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((short) 1, (short) 2, (short) 3));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((short) 1));
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
        ImmutableShortEmptyList list1 = new ImmutableShortEmptyList();
        ImmutableShortEmptyList list2 = new ImmutableShortEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableShortEmptyList list1 = new ImmutableShortEmptyList();
        ImmutableShortArrayList list2 = ImmutableShortArrayList.newListWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableShortEmptyList iterable = new ImmutableShortEmptyList();
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableShortList list1 = this.newWith();
        ImmutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShort result = list1.injectIntoWithIndex(new MutableShort((short) 0), (MutableShort object, short value, int index) -> object.add((short) (value * list2.get(index))));
        Assert.assertEquals(new MutableShort((short) 0), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(ShortLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((short each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], (short) 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((short) 7));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((short) 0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((short) 100));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((short) -1));
    }
}
