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

import org.eclipse.collections.api.list.primitive.ImmutableByteList;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.math.MutableByte;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableByteSingletonListTest extends AbstractImmutableByteListTestCase
{
    @Override
    protected ImmutableByteList classUnderTest()
    {
        return ByteLists.immutable.of((byte) 1);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith((byte) 1), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableByteSingletonList list1 = new ImmutableByteSingletonList((byte) 3);
        ImmutableByteSingletonList list2 = new ImmutableByteSingletonList((byte) 3);
        Assert.assertEquals(9L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableByteArrayList list = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableByteSingletonList iterable = new ImmutableByteSingletonList((byte) 1);
        MutableByte result = iterable.injectInto(new MutableByte((byte) 1), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 2), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableByteList list1 = this.newWith((byte) 1);
        ImmutableByteList list2 = this.newWith((byte) 1, (byte) 2, (byte) 3);
        MutableByte result = list1.injectIntoWithIndex(new MutableByte((byte) 0), (MutableByte object, byte value, int index) -> object.add((byte) (value * list2.get(index))));
        Assert.assertEquals(new MutableByte((byte) 1), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(ByteLists.immutable.of((byte) 1), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((byte each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], (byte) 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((byte) 0));
        Assert.assertEquals(0, this.classUnderTest().binarySearch((byte) 1));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch((byte) 5));
    }
}
