/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.immutable.primitive;

import org.eclipse.collections.api.list.primitive.ImmutableIntList;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableIntSingletonListTest extends AbstractImmutableIntListTestCase
{
    @Override
    protected ImmutableIntList classUnderTest()
    {
        return IntLists.immutable.of(1);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith(1), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableIntSingletonList list1 = new ImmutableIntSingletonList(3);
        ImmutableIntSingletonList list2 = new ImmutableIntSingletonList(3);
        Assert.assertEquals(9L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableIntArrayList list = ImmutableIntArrayList.newListWith(1, 2);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableIntSingletonList iterable = new ImmutableIntSingletonList(1);
        MutableInteger result = iterable.injectInto(new MutableInteger(1), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(2), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableIntList list1 = this.newWith(1);
        ImmutableIntList list2 = this.newWith(1, 2, 3);
        MutableInteger result = list1.injectIntoWithIndex(new MutableInteger(0), (MutableInteger object, int value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableInteger(1), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(IntLists.immutable.of(1), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((int each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0));
        Assert.assertEquals(0, this.classUnderTest().binarySearch(1));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch(5));
    }
}
