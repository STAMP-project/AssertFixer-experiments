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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableDoubleCollection;
import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableDoubleEmptyListTest extends AbstractImmutableDoubleListTestCase
{
    @Override
    protected ImmutableDoubleList classUnderTest()
    {
        return ImmutableDoubleEmptyList.INSTANCE;
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
        ImmutableDoubleCollection emptyCollection = this.classUnderTest();
        ImmutableDoubleCollection newCollection = emptyCollection.newWithout(9.0);
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
        DoubleIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(DoublePredicates.lessThan(4.0)));
        DoubleIterable doubleIterable = iterable.select(DoublePredicates.greaterThan(4.0));
        Verify.assertEmpty(doubleIterable);
        Assert.assertSame(iterable, doubleIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        DoubleIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(DoublePredicates.lessThan(4.0)));
        DoubleIterable doubleIterable = iterable.reject(DoublePredicates.greaterThan(4.0));
        Verify.assertEmpty(doubleIterable);
        Assert.assertSame(iterable, doubleIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1.0, 2.0, 3.0));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1.0));
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
        ImmutableDoubleEmptyList list1 = new ImmutableDoubleEmptyList();
        ImmutableDoubleEmptyList list2 = new ImmutableDoubleEmptyList();
        Assert.assertEquals(0.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableDoubleEmptyList list1 = new ImmutableDoubleEmptyList();
        ImmutableDoubleArrayList list2 = ImmutableDoubleArrayList.newListWith(1.0, 2.0);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleEmptyList iterable = new ImmutableDoubleEmptyList();
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(0.0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableDoubleList list1 = this.newWith();
        ImmutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = list1.injectIntoWithIndex(new MutableDouble(0.0), (MutableDouble object, double value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableDouble(0.0), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(DoubleLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((double each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], 0.0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(7.0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0.0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(100.0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(-1.0));
    }
}
