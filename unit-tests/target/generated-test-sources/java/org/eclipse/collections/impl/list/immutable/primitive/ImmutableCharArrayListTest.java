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

import org.eclipse.collections.api.list.primitive.ImmutableCharList;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharArrayList}.
 * This file was automatically generated from template file immutablePrimitiveArrayListTest.stg.
 */
public class ImmutableCharArrayListTest extends AbstractImmutableCharListTestCase
{
    @Override
    protected ImmutableCharList classUnderTest()
    {
        return ImmutableCharArrayList.newListWith((char) 1, (char) 2, (char) 3);
    }

    @Override
    @Test
    public void newCollection()
    {
        super.newCollection();
        Assert.assertEquals(CharArrayList.newListWith((char) 1, (char) 2, (char) 3), ImmutableCharArrayList.newList(CharArrayList.newListWith((char) 1, (char) 2, (char) 3)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_empty()
    {
        ImmutableCharArrayList.newListWith();
    }

    @Test(expected = IllegalArgumentException.class)
    public void newCollection_throws_single()
    {
        ImmutableCharArrayList.newListWith((char) 42);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(3, CharLists.immutable.ofAll(ImmutableCharArrayList.newList(CharArrayList.newListWith((char) 1, (char) 2, (char) 3))));
    }

    @Test
    public void dotProduct()
    {
        ImmutableCharArrayList list1 = ImmutableCharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        ImmutableCharArrayList list2 = ImmutableCharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableCharArrayList list1 = ImmutableCharArrayList.newListWith((char) 1, (char) 2, (char) 3);
        ImmutableCharArrayList list2 = ImmutableCharArrayList.newListWith((char) 1, (char) 2);
        list1.dotProduct(list2);
    }

    @Test
    public void binarySearch()
    {
        ImmutableCharArrayList list = ImmutableCharArrayList.newListWith((char) 2, (char) 3, (char) 5, (char) 6, (char) 9);
        Assert.assertEquals(-1, list.binarySearch((char) 1));
        Assert.assertEquals(0, list.binarySearch((char) 2));
        Assert.assertEquals(1, list.binarySearch((char) 3));
        Assert.assertEquals(-3, list.binarySearch((char) 4));
        Assert.assertEquals(2, list.binarySearch((char) 5));
        Assert.assertEquals(3, list.binarySearch((char) 6));
        Assert.assertEquals(-5, list.binarySearch((char) 7));
        Assert.assertEquals(-5, list.binarySearch((char) 8));
        Assert.assertEquals(4, list.binarySearch((char) 9));
        Assert.assertEquals(-6, list.binarySearch((char) 10));
    }
}
