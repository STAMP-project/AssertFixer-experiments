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

import org.eclipse.collections.api.list.primitive.ImmutableShortList;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableShortArrayListTest extends AbstractImmutableShortListTestCase
{
    @Override
    protected ImmutableShortList classUnderTest()
    {
        return ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3), ImmutableShortArrayList.newList(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty()
    {
        ImmutableShortArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single()
    {
        ImmutableShortArrayList.newListWith((short) 42);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(3, ShortLists.immutable.ofAll(ImmutableShortArrayList.newList(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3))));
    }

    @Test
    public void dotProduct()
    {
        ImmutableShortArrayList list1 = ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ImmutableShortArrayList list2 = ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableShortArrayList list1 = ImmutableShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ImmutableShortArrayList list2 = ImmutableShortArrayList.newListWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch()
    {
        ImmutableShortArrayList list = ImmutableShortArrayList.newListWith((short) 2, (short) 3, (short) 5, (short) 6, (short) 9);
        Assert.assertEquals(-1, list.binarySearch((short) 1));
        Assert.assertEquals(0, list.binarySearch((short) 2));
        Assert.assertEquals(1, list.binarySearch((short) 3));
        Assert.assertEquals(-3, list.binarySearch((short) 4));
        Assert.assertEquals(2, list.binarySearch((short) 5));
        Assert.assertEquals(3, list.binarySearch((short) 6));
        Assert.assertEquals(-5, list.binarySearch((short) 7));
        Assert.assertEquals(-5, list.binarySearch((short) 8));
        Assert.assertEquals(4, list.binarySearch((short) 9));
        Assert.assertEquals(-6, list.binarySearch((short) 10));
    }
}
