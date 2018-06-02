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

import org.eclipse.collections.api.list.primitive.ImmutableLongList;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableLongArrayListTest extends AbstractImmutableLongListTestCase
{
    @Override
    protected ImmutableLongList classUnderTest()
    {
        return ImmutableLongArrayList.newListWith(1L, 2L, 3L);
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L), ImmutableLongArrayList.newList(LongArrayList.newListWith(1L, 2L, 3L)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty()
    {
        ImmutableLongArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single()
    {
        ImmutableLongArrayList.newListWith(42L);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(3, LongLists.immutable.ofAll(ImmutableLongArrayList.newList(LongArrayList.newListWith(1L, 2L, 3L))));
    }

    @Test
    public void dotProduct()
    {
        ImmutableLongArrayList list1 = ImmutableLongArrayList.newListWith(1L, 2L, 3L);
        ImmutableLongArrayList list2 = ImmutableLongArrayList.newListWith(1L, 2L, 3L);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableLongArrayList list1 = ImmutableLongArrayList.newListWith(1L, 2L, 3L);
        ImmutableLongArrayList list2 = ImmutableLongArrayList.newListWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch()
    {
        ImmutableLongArrayList list = ImmutableLongArrayList.newListWith(2L, 3L, 5L, 6L, 9L);
        Assert.assertEquals(-1, list.binarySearch(1L));
        Assert.assertEquals(0, list.binarySearch(2L));
        Assert.assertEquals(1, list.binarySearch(3L));
        Assert.assertEquals(-3, list.binarySearch(4L));
        Assert.assertEquals(2, list.binarySearch(5L));
        Assert.assertEquals(3, list.binarySearch(6L));
        Assert.assertEquals(-5, list.binarySearch(7L));
        Assert.assertEquals(-5, list.binarySearch(8L));
        Assert.assertEquals(4, list.binarySearch(9L));
        Assert.assertEquals(-6, list.binarySearch(10L));
    }
}
