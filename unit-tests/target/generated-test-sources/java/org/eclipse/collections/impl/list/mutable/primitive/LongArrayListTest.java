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

import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.LongIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.LongIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class LongArrayListTest extends AbstractLongListTestCase
{
    private final LongArrayList list = this.classUnderTest();

    @Override
    protected final LongArrayList classUnderTest()
    {
        return LongArrayList.newListWith(1L, 2L, 3L);
    }

    @Override
    protected LongArrayList newWith(long... elements)
    {
        return LongArrayList.newListWith(elements);
    }

    @Test
    public void testLongArrayListWithInitialCapacity() throws Exception
    {
        LongArrayList arrayList = new LongArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = LongArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((long[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues()
    {
        LongArrayList newList = LongArrayList.newWithNValues(5, 42L);
        Verify.assertSize(5, newList);
        Assert.assertEquals(LongArrayList.newListWith(42L, 42L, 42L, 42L, 42L), newList);

        LongArrayList newList2 = LongArrayList.newWithNValues(0, 2L);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size()
    {
        LongArrayList newList = LongArrayList.newWithNValues(-5, 42L);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception
    {
        LongArrayList listWithCapacity = new LongArrayList(4).with(1L, 2L, 3L, 4L);
        listWithCapacity.addAtIndex(3, 5L);
        Field items = LongArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((long[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception
    {
        Field items = LongArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        LongArrayList arrayList = new LongArrayList().with(1L, 2L, 3L);
        Assert.assertEquals(10L, ((long[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new long[]{1L, 2L, 3L, 0L, 0L, 0L, 0L, 0L, 0L, 0L}, (long[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new long[]{1L, 2L, 3L}, (long[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new LongArrayList());
        Verify.assertSize(3, LongLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct()
    {
        LongArrayList list1 = LongArrayList.newListWith(1L, 2L, 3L);
        LongArrayList list2 = LongArrayList.newListWith(1L, 2L, 3L);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        LongArrayList list1 = LongArrayList.newListWith(1L, 2L, 3L);
        LongArrayList list2 = LongArrayList.newListWith(1L, 2L);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        LongArrayList emptyList = new LongArrayList();
        LongArrayList arrayList = emptyList.with(1L);
        LongArrayList arrayList0 = new LongArrayList().with(1L, 2L);
        LongArrayList arrayList1 = new LongArrayList().with(1L, 2L, 3L);
        LongArrayList arrayList2 = new LongArrayList().with(1L, 2L, 3L, 4L);
        LongArrayList arrayList3 = new LongArrayList().with(1L, 2L, 3L, 4L, 5L);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(LongArrayList.newListWith(1L), arrayList);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L), arrayList2);
        Assert.assertEquals(LongArrayList.newListWith(1L, 2L, 3L, 4L, 5L), arrayList3);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongIterableIterate.class);
        Verify.assertClassNonInstantiable(LongIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        LongArrayList list = new LongArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add(5L);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }
}
