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

import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableByteCollection;
import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.impl.block.factory.primitive.BytePredicates;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableByteEmptyListTest extends AbstractImmutableByteListTestCase
{
    @Override
    protected ImmutableByteList classUnderTest()
    {
        return ImmutableByteEmptyList.INSTANCE;
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
        ImmutableByteCollection emptyCollection = this.classUnderTest();
        ImmutableByteCollection newCollection = emptyCollection.newWithout((byte) 9);
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
        ByteIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(BytePredicates.lessThan((byte) 4)));
        ByteIterable byteIterable = iterable.select(BytePredicates.greaterThan((byte) 4));
        Verify.assertEmpty(byteIterable);
        Assert.assertSame(iterable, byteIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        ByteIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(BytePredicates.lessThan((byte) 4)));
        ByteIterable byteIterable = iterable.reject(BytePredicates.greaterThan((byte) 4));
        Verify.assertEmpty(byteIterable);
        Assert.assertSame(iterable, byteIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((byte) 1, (byte) 2, (byte) 3));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((byte) 1));
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
        ImmutableByteEmptyList list1 = new ImmutableByteEmptyList();
        ImmutableByteEmptyList list2 = new ImmutableByteEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableByteEmptyList list1 = new ImmutableByteEmptyList();
        ImmutableByteArrayList list2 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableByteEmptyList iterable = new ImmutableByteEmptyList();
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableByteList list1 = this.newWith();
        ImmutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = list1.injectIntoWithIndex(new MutableByte((byte) 0), (MutableByte object, byte value, int index) -> object.add((byte) (value * list2.get(index))));
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(ByteLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((byte each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], (byte) 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 7));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 100));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) -1));
    }
}
