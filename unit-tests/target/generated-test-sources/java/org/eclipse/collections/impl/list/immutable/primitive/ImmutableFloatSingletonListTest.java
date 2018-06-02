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

import org.eclipse.collections.api.list.primitive.ImmutableFloatList;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableFloatSingletonListTest extends AbstractImmutableFloatListTestCase
{
    @Override
    protected ImmutableFloatList classUnderTest()
    {
        return FloatLists.immutable.of(1.0f);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith(1.0f), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableFloatSingletonList list1 = new ImmutableFloatSingletonList(3.0f);
        ImmutableFloatSingletonList list2 = new ImmutableFloatSingletonList(3.0f);
        Assert.assertEquals(9.0, list1.dotProduct(list2), 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableFloatArrayList list = ImmutableFloatArrayList.newListWith(1.0f, 2.0f);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableFloatSingletonList iterable = new ImmutableFloatSingletonList(1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(1.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(2.0f), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableFloatList list1 = this.newWith(1.0f);
        ImmutableFloatList list2 = this.newWith(1.0f, 2.0f, 3.0f);
        MutableFloat result = list1.injectIntoWithIndex(new MutableFloat(0.0f), (MutableFloat object, float value, int index) -> object.add(value * list2.get(index)));
        Assert.assertEquals(new MutableFloat(1.0f), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(FloatLists.immutable.of(1.0f), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        double[] sum = new double[1];
        this.classUnderTest().forEachWithIndex((float each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], 0.0f);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch(0.0f));
        Assert.assertEquals(0, this.classUnderTest().binarySearch(1.0f));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch(5.0f));
    }
}
