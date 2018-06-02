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

import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.IntIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.IntIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class IntArrayListTest extends AbstractIntListTestCase
{
    private final IntArrayList list = this.classUnderTest();

    @Override
    protected final IntArrayList classUnderTest()
    {
        return IntArrayList.newListWith(1, 2, 3);
    }

    @Override
    protected IntArrayList newWith(int... elements)
    {
        return IntArrayList.newListWith(elements);
    }

    @Test
    public void testIntArrayListWithInitialCapacity() throws Exception
    {
        IntArrayList arrayList = new IntArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = IntArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((int[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues()
    {
        IntArrayList newList = IntArrayList.newWithNValues(5, 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(IntArrayList.newListWith(42, 42, 42, 42, 42), newList);

        IntArrayList newList2 = IntArrayList.newWithNValues(0, 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size()
    {
        IntArrayList newList = IntArrayList.newWithNValues(-5, 42);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception
    {
        IntArrayList listWithCapacity = new IntArrayList(4).with(1, 2, 3, 4);
        listWithCapacity.addAtIndex(3, 5);
        Field items = IntArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((int[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception
    {
        Field items = IntArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        IntArrayList arrayList = new IntArrayList().with(1, 2, 3);
        Assert.assertEquals(10L, ((int[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new int[]{1, 2, 3, 0, 0, 0, 0, 0, 0, 0}, (int[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new int[]{1, 2, 3}, (int[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new IntArrayList());
        Verify.assertSize(3, IntLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct()
    {
        IntArrayList list1 = IntArrayList.newListWith(1, 2, 3);
        IntArrayList list2 = IntArrayList.newListWith(1, 2, 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        IntArrayList list1 = IntArrayList.newListWith(1, 2, 3);
        IntArrayList list2 = IntArrayList.newListWith(1, 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        IntArrayList emptyList = new IntArrayList();
        IntArrayList arrayList = emptyList.with(1);
        IntArrayList arrayList0 = new IntArrayList().with(1, 2);
        IntArrayList arrayList1 = new IntArrayList().with(1, 2, 3);
        IntArrayList arrayList2 = new IntArrayList().with(1, 2, 3, 4);
        IntArrayList arrayList3 = new IntArrayList().with(1, 2, 3, 4, 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(IntArrayList.newListWith(1), arrayList);
        Assert.assertEquals(IntArrayList.newListWith(1, 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4), arrayList2);
        Assert.assertEquals(IntArrayList.newListWith(1, 2, 3, 4, 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntIterableIterate.class);
        Verify.assertClassNonInstantiable(IntIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        IntArrayList list = new IntArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }
}
