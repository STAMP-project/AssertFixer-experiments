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
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableIntArrayListTest extends AbstractImmutableIntListTestCase
{
    @Override
    protected ImmutableIntList classUnderTest()
    {
        return ImmutableIntArrayList.newListWith(1, 2, 3);
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3), ImmutableIntArrayList.newList(IntArrayList.newListWith(1, 2, 3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty()
    {
        ImmutableIntArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single()
    {
        ImmutableIntArrayList.newListWith(42);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(3, IntLists.immutable.ofAll(ImmutableIntArrayList.newList(IntArrayList.newListWith(1, 2, 3))));
    }

    @Test
    public void dotProduct()
    {
        ImmutableIntArrayList list1 = ImmutableIntArrayList.newListWith(1, 2, 3);
        ImmutableIntArrayList list2 = ImmutableIntArrayList.newListWith(1, 2, 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableIntArrayList list1 = ImmutableIntArrayList.newListWith(1, 2, 3);
        ImmutableIntArrayList list2 = ImmutableIntArrayList.newListWith(1, 2);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch()
    {
        ImmutableIntArrayList list = ImmutableIntArrayList.newListWith(2, 3, 5, 6, 9);
        Assert.assertEquals(-1, list.binarySearch(1));
        Assert.assertEquals(0, list.binarySearch(2));
        Assert.assertEquals(1, list.binarySearch(3));
        Assert.assertEquals(-3, list.binarySearch(4));
        Assert.assertEquals(2, list.binarySearch(5));
        Assert.assertEquals(3, list.binarySearch(6));
        Assert.assertEquals(-5, list.binarySearch(7));
        Assert.assertEquals(-5, list.binarySearch(8));
        Assert.assertEquals(4, list.binarySearch(9));
        Assert.assertEquals(-6, list.binarySearch(10));
    }
}
