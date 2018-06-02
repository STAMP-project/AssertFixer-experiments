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
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableShortSingletonListTest extends AbstractImmutableShortListTestCase
{
    @Override
    protected ImmutableShortList classUnderTest()
    {
        return ShortLists.immutable.of((short) 1);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith((short) 1), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableShortSingletonList list1 = new ImmutableShortSingletonList((short) 3);
        ImmutableShortSingletonList list2 = new ImmutableShortSingletonList((short) 3);
        Assert.assertEquals(9L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableShortArrayList list = ImmutableShortArrayList.newListWith((short) 1, (short) 2);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableShortSingletonList iterable = new ImmutableShortSingletonList((short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 1), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 2), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableShortList list1 = this.newWith((short) 1);
        ImmutableShortList list2 = this.newWith((short) 1, (short) 2, (short) 3);
        MutableShort result = list1.injectIntoWithIndex(new MutableShort((short) 0), (MutableShort object, short value, int index) -> object.add((short) (value * list2.get(index))));
        Assert.assertEquals(new MutableShort((short) 1), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(ShortLists.immutable.of((short) 1), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((short each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], (short) 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((short) 0));
        Assert.assertEquals(0, this.classUnderTest().binarySearch((short) 1));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch((short) 5));
    }
}
