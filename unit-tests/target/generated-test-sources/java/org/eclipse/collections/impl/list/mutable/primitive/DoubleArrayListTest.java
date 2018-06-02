/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.list.mutable.primitive;

import java.lang.reflect.Field;

import org.eclipse.collections.impl.factory.primitive.DoubleLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.DoubleIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.DoubleIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class DoubleArrayListTest extends AbstractDoubleListTestCase
{
    private final DoubleArrayList list = this.classUnderTest();

    @Override
    protected final DoubleArrayList classUnderTest()
    {
        return DoubleArrayList.newListWith(1.0, 2.0, 3.0);
    }

    @Override
    protected DoubleArrayList newWith(double... elements)
    {
        return DoubleArrayList.newListWith(elements);
    }

    @Test
    public void testDoubleArrayListWithInitialCapacity() throws Exception
    {
        DoubleArrayList arrayList = new DoubleArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = DoubleArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((double[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues()
    {
        DoubleArrayList newList = DoubleArrayList.newWithNValues(5, 42.0);
        Verify.assertSize(5, newList);
        Assert.assertEquals(DoubleArrayList.newListWith(42.0, 42.0, 42.0, 42.0, 42.0), newList);

        DoubleArrayList newList2 = DoubleArrayList.newWithNValues(0, 2.0);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size()
    {
        DoubleArrayList newList = DoubleArrayList.newWithNValues(-5, 42.0);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception
    {
        DoubleArrayList listWithCapacity = new DoubleArrayList(4).with(1.0, 2.0, 3.0, 4.0);
        listWithCapacity.addAtIndex(3, 5.0);
        Field items = DoubleArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((double[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception
    {
        Field items = DoubleArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        DoubleArrayList arrayList = new DoubleArrayList().with(1.0, 2.0, 3.0);
        Assert.assertEquals(10L, ((double[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new double[]{1.0, 2.0, 3.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0}, (double[]) items.get(arrayList), 0.0);
        arrayList.trimToSize();
        Assert.assertArrayEquals(new double[]{1.0, 2.0, 3.0}, (double[]) items.get(arrayList), 0.0);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new DoubleArrayList());
        Verify.assertSize(3, DoubleLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct()
    {
        DoubleArrayList list1 = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        DoubleArrayList list2 = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        DoubleArrayList list1 = DoubleArrayList.newListWith(1.0, 2.0, 3.0);
        DoubleArrayList list2 = DoubleArrayList.newListWith(1.0, 2.0);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        DoubleArrayList emptyList = new DoubleArrayList();
        DoubleArrayList arrayList = emptyList.with(1.0);
        DoubleArrayList arrayList0 = new DoubleArrayList().with(1.0, 2.0);
        DoubleArrayList arrayList1 = new DoubleArrayList().with(1.0, 2.0, 3.0);
        DoubleArrayList arrayList2 = new DoubleArrayList().with(1.0, 2.0, 3.0, 4.0);
        DoubleArrayList arrayList3 = new DoubleArrayList().with(1.0, 2.0, 3.0, 4.0, 5.0);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0), arrayList);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0), arrayList2);
        Assert.assertEquals(DoubleArrayList.newListWith(1.0, 2.0, 3.0, 4.0, 5.0), arrayList3);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleIterableIterate.class);
        Verify.assertClassNonInstantiable(DoubleIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        DoubleArrayList list = new DoubleArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5.0);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }
}
