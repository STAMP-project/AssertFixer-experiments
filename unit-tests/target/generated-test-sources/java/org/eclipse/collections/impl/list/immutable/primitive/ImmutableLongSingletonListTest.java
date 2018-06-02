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
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableLongSingletonListTest extends AbstractImmutableLongListTestCase
{
    @Override
    protected ImmutableLongList classUnderTest()
    {
        return LongLists.immutable.of(1L);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith(1L), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableLongSingletonList list1 = new ImmutableLongSingletonList(3L);
        ImmutableLongSingletonList list2 = new ImmutableLongSingletonList(3L);
        Assert.assertEquals(9L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableLongArrayList list = ImmutableLongArrayList.newListWith(1L, 2L);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableLongSingletonList iterable = new ImmutableLongSingletonList(1L);
        MutableLong result = iterable.injectInto(new MutableLong(1L), MutableLong::add);
        Assert.assertEquals(new MutableLong(2L), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableLongList list1 = this.newWith(1L);
        ImmutableLongList list2 = this.newWith(1L, 2L, 3L);
        MutableLong result = list1.injectIntoWithIndex(new MutableLong(0L), (MutableLong object, long value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableLong(1L), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(LongLists.immutable.of(1L), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((long each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], 0L);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0L));
        Assert.assertEquals(0, this.classUnderTest().binarySearch(1L));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch(5L));
    }
}
