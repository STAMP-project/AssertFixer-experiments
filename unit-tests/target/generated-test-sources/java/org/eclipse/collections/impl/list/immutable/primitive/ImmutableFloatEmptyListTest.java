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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableFloatCollection;
import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableFloatEmptyListTest extends AbstractImmutableFloatListTestCase
{
    @Override
    protected ImmutableFloatList classUnderTest()
    {
        return ImmutableFloatEmptyList.INSTANCE;
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
        ImmutableFloatCollection emptyCollection = this.classUnderTest();
        ImmutableFloatCollection newCollection = emptyCollection.newWithout(9.0f);
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
        FloatIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(FloatPredicates.lessThan(4.0f)));
        FloatIterable floatIterable = iterable.select(FloatPredicates.greaterThan(4.0f));
        Verify.assertEmpty(floatIterable);
        Assert.assertSame(iterable, floatIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        FloatIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(FloatPredicates.lessThan(4.0f)));
        FloatIterable floatIterable = iterable.reject(FloatPredicates.greaterThan(4.0f));
        Verify.assertEmpty(floatIterable);
        Assert.assertSame(iterable, floatIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1.0f, 2.0f, 3.0f));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith(1.0f));
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
        ImmutableFloatEmptyList list1 = new ImmutableFloatEmptyList();
        ImmutableFloatEmptyList list2 = new ImmutableFloatEmptyList();
        Assert.assertEquals(0.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableFloatEmptyList list1 = new ImmutableFloatEmptyList();
        ImmutableFloatArrayList list2 = ImmutableFloatArrayList.newListWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableFloatEmptyList iterable = new ImmutableFloatEmptyList();
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(0.0f), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableFloatList list1 = this.newWith();
        ImmutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = list1.injectIntoWithIndex(new MutableFloat(0.0f), (MutableFloat object, float value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableFloat(0.0f), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(FloatLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((float each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], 0.0f);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(7.0f));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0.0f));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(100.0f));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(-1.0f));
    }
}
