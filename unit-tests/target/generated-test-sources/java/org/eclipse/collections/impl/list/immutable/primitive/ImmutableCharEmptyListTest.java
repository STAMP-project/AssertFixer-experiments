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

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.collection.primitive.ImmutableCharCollection;
import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharEmptyList}.
 * This file was automatically generated from template file immutablePrimitiveEmptyListTest.stg.
 */
public class ImmutableCharEmptyListTest extends AbstractImmutableCharListTestCase
{
    @Override
    protected ImmutableCharList classUnderTest()
    {
        return ImmutableCharEmptyList.INSTANCE;
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
        ImmutableCharCollection emptyCollection = this.classUnderTest();
        ImmutableCharCollection newCollection = emptyCollection.newWithout((char) 9);
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
        CharIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.select(CharPredicates.lessThan((char) 4)));
        CharIterable charIterable = iterable.select(CharPredicates.greaterThan((char) 4));
        Verify.assertEmpty(charIterable);
        Assert.assertSame(iterable, charIterable);
    }

    @Override
    @Test
    public void reject()
    {
        super.reject();
        CharIterable iterable = this.classUnderTest();
        Verify.assertEmpty(iterable.reject(CharPredicates.lessThan((char) 4)));
        CharIterable charIterable = iterable.reject(CharPredicates.greaterThan((char) 4));
        Verify.assertEmpty(charIterable);
        Assert.assertSame(iterable, charIterable);
    }

    @Override
    @Test
    public void testEquals()
    {
        Verify.assertEqualsAndHashCode(this.classUnderTest(), this.classUnderTest());
        Verify.assertEqualsAndHashCode(this.newMutableCollectionWith(), this.classUnderTest());
        Verify.assertPostSerializedIdentity(this.newWith());
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((char) 1, (char) 2, (char) 3));
        Assert.assertNotEquals(this.classUnderTest(), this.newWith((char) 1));
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
        ImmutableCharEmptyList list1 = new ImmutableCharEmptyList();
        ImmutableCharEmptyList list2 = new ImmutableCharEmptyList();
        Assert.assertEquals(0L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableCharEmptyList list1 = new ImmutableCharEmptyList();
        ImmutableCharArrayList list2 = ImmutableCharArrayList.newListWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableCharEmptyList iterable = new ImmutableCharEmptyList();
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableCharList list1 = this.newWith();
        ImmutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = list1.injectIntoWithIndex(new MutableCharacter((char) 0), (MutableCharacter object, char value, int index) -> object.add((char) (value * list2.get(index))));
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(CharLists.immutable.of(), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((char each, int index) -> sum[0] += each + index);

        Assert.assertEquals(0, sum[0], (char) 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 7));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 0));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 100));
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) -1));
    }
}
