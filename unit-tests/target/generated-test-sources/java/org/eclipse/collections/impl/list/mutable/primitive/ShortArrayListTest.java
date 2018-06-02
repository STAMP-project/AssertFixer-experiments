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

import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.ShortIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.ShortIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class ShortArrayListTest extends AbstractShortListTestCase
{
    private final ShortArrayList list = this.classUnderTest();

    @Override
    protected final ShortArrayList classUnderTest()
    {
        return ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
    }

    @Override
    protected ShortArrayList newWith(short... elements)
    {
        return ShortArrayList.newListWith(elements);
    }

    @Test
    public void testShortArrayListWithInitialCapacity() throws Exception
    {
        ShortArrayList arrayList = new ShortArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = ShortArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((short[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues()
    {
        ShortArrayList newList = ShortArrayList.newWithNValues(5, (short) 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(ShortArrayList.newListWith((short) 42, (short) 42, (short) 42, (short) 42, (short) 42), newList);

        ShortArrayList newList2 = ShortArrayList.newWithNValues(0, (short) 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size()
    {
        ShortArrayList newList = ShortArrayList.newWithNValues(-5, (short) 42);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception
    {
        ShortArrayList listWithCapacity = new ShortArrayList(4).with((short) 1, (short) 2, (short) 3, (short) 4);
        listWithCapacity.addAtIndex(3, (short) 5);
        Field items = ShortArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((short[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception
    {
        Field items = ShortArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        ShortArrayList arrayList = new ShortArrayList().with((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(10L, ((short[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new short[]{(short) 1, (short) 2, (short) 3, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0, (short) 0}, (short[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new short[]{(short) 1, (short) 2, (short) 3}, (short[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new ShortArrayList());
        Verify.assertSize(3, ShortLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct()
    {
        ShortArrayList list1 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ShortArrayList list2 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ShortArrayList list1 = ShortArrayList.newListWith((short) 1, (short) 2, (short) 3);
        ShortArrayList list2 = ShortArrayList.newListWith((short) 1, (short) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        ShortArrayList emptyList = new ShortArrayList();
        ShortArrayList arrayList = emptyList.with((short) 1);
        ShortArrayList arrayList0 = new ShortArrayList().with((short) 1, (short) 2);
        ShortArrayList arrayList1 = new ShortArrayList().with((short) 1, (short) 2, (short) 3);
        ShortArrayList arrayList2 = new ShortArrayList().with((short) 1, (short) 2, (short) 3, (short) 4);
        ShortArrayList arrayList3 = new ShortArrayList().with((short) 1, (short) 2, (short) 3, (short) 4, (short) 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1), arrayList);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4), arrayList2);
        Assert.assertEquals(ShortArrayList.newListWith((short) 1, (short) 2, (short) 3, (short) 4, (short) 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortIterableIterate.class);
        Verify.assertClassNonInstantiable(ShortIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ShortArrayList list = new ShortArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add((short) 5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }
}
