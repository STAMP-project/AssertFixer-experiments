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

import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.utility.internal.primitive.ByteIterableIterate;
import org.eclipse.collections.impl.utility.internal.primitive.ByteIteratorIterate;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteArrayList}.
 * This file was automatically generated from template file primitiveArrayListTest.stg.
 */
public class ByteArrayListTest extends AbstractByteListTestCase
{
    private final ByteArrayList list = this.classUnderTest();

    @Override
    protected final ByteArrayList classUnderTest()
    {
        return ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
    }

    @Override
    protected ByteArrayList newWith(byte... elements)
    {
        return ByteArrayList.newListWith(elements);
    }

    @Test
    public void testByteArrayListWithInitialCapacity() throws Exception
    {
        ByteArrayList arrayList = new ByteArrayList(7);
        Verify.assertEmpty(arrayList);
        Field items = ByteArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((byte[]) items.get(arrayList)).length);
    }

    @Test
    public void newWithNValues()
    {
        ByteArrayList newList = ByteArrayList.newWithNValues(5, (byte) 42);
        Verify.assertSize(5, newList);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 42, (byte) 42, (byte) 42, (byte) 42, (byte) 42), newList);

        ByteArrayList newList2 = ByteArrayList.newWithNValues(0, (byte) 2);
        Verify.assertSize(0, newList2);
    }

    @Test(expected = NegativeArraySizeException.class)
    public void newWithNValues_throws_negative_size()
    {
        ByteArrayList newList = ByteArrayList.newWithNValues(-5, (byte) 42);
    }

    @Test
    public void addAtIndexAtCapacity() throws Exception
    {
        ByteArrayList listWithCapacity = new ByteArrayList(4).with((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        listWithCapacity.addAtIndex(3, (byte) 5);
        Field items = ByteArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        Assert.assertEquals(7L, ((byte[]) items.get(listWithCapacity)).length);
    }

    @Test
    public void trimToSize() throws Exception
    {
        Field items = ByteArrayList.class.getDeclaredField("items");
        items.setAccessible(true);
        ByteArrayList arrayList = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(10L, ((byte[]) items.get(arrayList)).length);
        Assert.assertArrayEquals(new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}, (byte[]) items.get(arrayList));
        arrayList.trimToSize();
        Assert.assertArrayEquals(new byte[]{(byte) 1, (byte) 2, (byte) 3}, (byte[]) items.get(arrayList));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        Verify.assertSize(0, new ByteArrayList());
        Verify.assertSize(3, ByteLists.mutable.ofAll(this.list));
        Verify.assertSize(3, this.list);
    }

    @Override
    @Test
    public void dotProduct()
    {
        ByteArrayList list1 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list2 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        Assert.assertEquals(14L, list1.dotProduct(list2));
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void dotProduct_throwsOnListsOfDifferentSizes()
    {
        ByteArrayList list1 = ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3);
        ByteArrayList list2 = ByteArrayList.newListWith((byte) 1, (byte) 2);
        list1.dotProduct(list2);
    }

    @Override
    @Test
    public void with()
    {
        super.with();
        ByteArrayList emptyList = new ByteArrayList();
        ByteArrayList arrayList = emptyList.with((byte) 1);
        ByteArrayList arrayList0 = new ByteArrayList().with((byte) 1, (byte) 2);
        ByteArrayList arrayList1 = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3);
        ByteArrayList arrayList2 = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        ByteArrayList arrayList3 = new ByteArrayList().with((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5);
        Assert.assertSame(emptyList, arrayList);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1), arrayList);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2), arrayList0);
        Assert.assertEquals(this.list, arrayList1);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), arrayList2);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5), arrayList3);
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteIterableIterate.class);
        Verify.assertClassNonInstantiable(ByteIteratorIterate.class);
    }

    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ByteArrayList list = new ByteArrayList(1);
        Assert.assertEquals(list, list.toImmutable());
        list.add((byte) 5);
        list.removeAtIndex(0);
        Assert.assertEquals(list, list.toImmutable());
    }
}
