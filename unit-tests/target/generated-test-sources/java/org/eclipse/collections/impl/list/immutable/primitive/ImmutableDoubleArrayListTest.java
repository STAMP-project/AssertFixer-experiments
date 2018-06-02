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

import org.eclipse.collections.api.list.primitive.ImmutableDoubleList;
import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableDoubleArrayListTest extends AbstractImmutableDoubleListTestCase
{
    @Override
    protected ImmutableDoubleList classUnderTest()
    {
        return ImmutableDoubleArrayList.newListWith(1.0, 2.0, 3.0);
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0), ImmutableDoubleArrayList.newList(DoubleArrayList.newListWith(1.0, 2.0, 3.0)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty()
    {
        ImmutableDoubleArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single()
    {
        ImmutableDoubleArrayList.newListWith(42.0);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(3, DoubleLists.immutable.ofAll(ImmutableDoubleArrayList.newList(DoubleArrayList.newListWith(1.0, 2.0, 3.0))));
    }

    @Test
    public void dotProduct()
    {
        ImmutableDoubleArrayList list1 = ImmutableDoubleArrayList.newListWith(1.0, 2.0, 3.0);
        ImmutableDoubleArrayList list2 = ImmutableDoubleArrayList.newListWith(1.0, 2.0, 3.0);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableDoubleArrayList list1 = ImmutableDoubleArrayList.newListWith(1.0, 2.0, 3.0);
        ImmutableDoubleArrayList list2 = ImmutableDoubleArrayList.newListWith(1.0, 2.0);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch()
    {
        ImmutableDoubleArrayList list = ImmutableDoubleArrayList.newListWith(2.0, 3.0, 5.0, 6.0, 9.0);
        Assert.assertEquals(-1, list.binarySearch(1.0));
        Assert.assertEquals(0, list.binarySearch(2.0));
        Assert.assertEquals(1, list.binarySearch(3.0));
        Assert.assertEquals(-3, list.binarySearch(4.0));
        Assert.assertEquals(2, list.binarySearch(5.0));
        Assert.assertEquals(3, list.binarySearch(6.0));
        Assert.assertEquals(-5, list.binarySearch(7.0));
        Assert.assertEquals(-5, list.binarySearch(8.0));
        Assert.assertEquals(4, list.binarySearch(9.0));
        Assert.assertEquals(-6, list.binarySearch(10.0));
    }
}
