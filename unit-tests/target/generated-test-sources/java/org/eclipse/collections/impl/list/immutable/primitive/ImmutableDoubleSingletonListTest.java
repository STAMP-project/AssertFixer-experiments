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
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableDoubleSingletonListTest extends AbstractImmutableDoubleListTestCase
{
    @Override
    protected ImmutableDoubleList classUnderTest()
    {
        return DoubleLists.immutable.of(1.0);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith(1.0), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableDoubleSingletonList list1 = new ImmutableDoubleSingletonList(3.0);
        ImmutableDoubleSingletonList list2 = new ImmutableDoubleSingletonList(3.0);
        Assert.assertEquals(9.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableDoubleArrayList list = ImmutableDoubleArrayList.newListWith(1.0, 2.0);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableDoubleSingletonList iterable = new ImmutableDoubleSingletonList(1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(1.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(2.0), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableDoubleList list1 = this.newWith(1.0);
        ImmutableDoubleList list2 = this.newWith(1.0, 2.0, 3.0);
        MutableDouble result = list1.injectIntoWithIndex(new MutableDouble(0.0), (MutableDouble object, double value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableDouble(1.0), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(DoubleLists.immutable.of(1.0), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((double each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], 0.0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0.0));
        Assert.assertEquals(0, this.classUnderTest().binarySearch(1.0));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch(5.0));
    }
}
