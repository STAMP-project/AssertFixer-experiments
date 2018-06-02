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

import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.FloatIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.FloatIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class FloatArrayListTest extends AbstractFloatListTestCase
{
    private final FloatArrayList list = this.classUnderTest();

    @Override
    protected final FloatArrayList classUnderTest()
    {
        return FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
    }

    @Override
    protected FloatArrayList newWith(float... elements)
    {
        return FloatArrayList.newListWith(elements);
    }

    @Test
    public void testFloatArrayListWithInitialCapacity() throws Exception
    {
        FloatArrayList arrayList = new FloatArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = FloatArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((float[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues()
    {
        FloatArrayList newList = FloatArrayList.newWithNValues(5, 42.0f);
        Verify.assertSize(5, newList);
        Assert.assertEquals(FloatArrayList.newListWith(42.0f, 42.0f, 42.0f, 42.0f, 42.0f), newList);

        FloatArrayList newList2 = FloatArrayList.newWithNValues(0, 2.0f);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size()
    {
        FloatArrayList newList = FloatArrayList.newWithNValues(-5, 42.0f);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception
    {
        FloatArrayList listWithCapacity = new FloatArrayList(4).with(1.0f, 2.0f, 3.0f, 4.0f);
        listWithCapacity.addAtIndex(3, 5.0f);
        Field items = FloatArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((float[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception
    {
        Field items = FloatArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        FloatArrayList arrayList = new FloatArrayList().with(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(10L, ((float[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f}, (float[]) items.get(arrayList), 0.0f);
        arrayList.trimToSize();
        Assert.assertArrayEquals(new float[]{1.0f, 2.0f, 3.0f}, (float[]) items.get(arrayList), 0.0f);
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new FloatArrayList());
        Verify.assertSize(3, FloatLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct()
    {
        FloatArrayList list1 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        FloatArrayList list2 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        Assert.assertEquals(14.0, list1.dotProduct(list2), 0.0);
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        FloatArrayList list1 = FloatArrayList.newListWith(1.0f, 2.0f, 3.0f);
        FloatArrayList list2 = FloatArrayList.newListWith(1.0f, 2.0f);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        FloatArrayList emptyList = new FloatArrayList();
        FloatArrayList arrayList = emptyList.with(1.0f);
        FloatArrayList arrayList0 = new FloatArrayList().with(1.0f, 2.0f);
        FloatArrayList arrayList1 = new FloatArrayList().with(1.0f, 2.0f, 3.0f);
        FloatArrayList arrayList2 = new FloatArrayList().with(1.0f, 2.0f, 3.0f, 4.0f);
        FloatArrayList arrayList3 = new FloatArrayList().with(1.0f, 2.0f, 3.0f, 4.0f, 5.0f);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f), arrayList);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f), arrayList2);
        Assert.assertEquals(FloatArrayList.newListWith(1.0f, 2.0f, 3.0f, 4.0f, 5.0f), arrayList3);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatIterableIterate.class);
        Verify.assertClassNonInstantiable(FloatIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        FloatArrayList list = new FloatArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5.0f);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }
}
