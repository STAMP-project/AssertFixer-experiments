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
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableByteArrayListTest extends AbstractImmutableByteListTestCase
{
    @Override
    protected ImmutableByteList classUnderTest()
    {
        return ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3), ImmutableByteArrayList.newList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty()
    {
        ImmutableByteArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single()
    {
        ImmutableByteArrayList.newListWith((byte) 42);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(3, ByteLists.immutable.ofAll(ImmutableByteArrayList.newList(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3))));
    }

    @Test
    public void dotProduct()
    {
        ImmutableByteArrayList list1 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteArrayList list2 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableByteArrayList list1 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ImmutableByteArrayList list2 = ImmutableByteArrayList.newListWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch()
    {
        ImmutableByteArrayList list = ImmutableByteArrayList.newListWith((byte) 2, (byte) 3, (byte) 5, (byte) 6, (byte) 9);
        Assert.assertEquals(-1, list.binarySearch((byte) 1));
        Assert.assertEquals(0, list.binarySearch((byte) 2));
        Assert.assertEquals(1, list.binarySearch((byte) 3));
        Assert.assertEquals(-3, list.binarySearch((byte) 4));
        Assert.assertEquals(2, list.binarySearch((byte) 5));
        Assert.assertEquals(3, list.binarySearch((byte) 6));
        Assert.assertEquals(-5, list.binarySearch((byte) 7));
        Assert.assertEquals(-5, list.binarySearch((byte) 8));
        Assert.assertEquals(4, list.binarySearch((byte) 9));
        Assert.assertEquals(-6, list.binarySearch((byte) 10));
    }
}
