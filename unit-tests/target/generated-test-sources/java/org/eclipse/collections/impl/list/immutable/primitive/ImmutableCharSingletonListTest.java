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
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharSingletonList}.
 * This file was automatically generated from template file immutablePrimitiveSingletonListTest.stg.
 */
public class ImmutableCharSingletonListTest extends AbstractImmutableCharListTestCase
{
    @Override
    protected ImmutableCharList classUnderTest()
    {
        return CharLists.immutable.of((char) 1);
    }

    @Override
    @Test
    public void testEquals()
    {
        super.testEquals();
        Assert.assertNotEquals(this.newWith((char) 1), this.newWith());
    }

    @Test
    public void dotProduct()
    {
        ImmutableCharSingletonList list1 = new ImmutableCharSingletonList((char) 3);
        ImmutableCharSingletonList list2 = new ImmutableCharSingletonList((char) 3);
        Assert.assertEquals(9L, list1.dotProduct(list2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ImmutableCharArrayList list = ImmutableCharArrayList.newListWith((char) 1, (char) 2);
        this.classUnderTest().dotProduct(list);
    }

    @Override
    @Test
    public void injectInto()
    {
        super.injectInto();

        ImmutableCharSingletonList iterable = new ImmutableCharSingletonList((char) 1);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 1), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 2), result);
    }

    @Override
    @Test
    public void injectIntoWithIndex()
    {
        ImmutableCharList list1 = this.newWith((char) 1);
        ImmutableCharList list2 = this.newWith((char) 1, (char) 2, (char) 3);
        MutableCharacter result = list1.injectIntoWithIndex(new MutableCharacter((char) 0), (MutableCharacter object, char value, int index) -> object.add((char) (value * list2.get(index))));
        Assert.assertEquals(new MutableCharacter((char) 1), result);
    }

    @Override
    @Test
    public void toReversed()
    {
        Assert.assertEquals(CharLists.immutable.of((char) 1), this.classUnderTest().toReversed());
    }

    @Override
    @Test
    public void forEachWithIndex()
    {
        long[] sum = new long[1];
        this.classUnderTest().forEachWithIndex((char each, int index) -> sum[0] += each + index);

        Assert.assertEquals(1, sum[0], (char) 0);
    }

    @Test
    public void binarySearch()
    {
        Assert.assertEquals(-1, this.classUnderTest().binarySearch((char) 0));
        Assert.assertEquals(0, this.classUnderTest().binarySearch((char) 1));
        Assert.assertEquals(-2, this.classUnderTest().binarySearch((char) 5));
    }
}
