/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.map.primitive.ImmutableShortByteMap;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.factory.primitive.ShortByteMaps;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortByteEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableShortByteEmptyMapTest extends AbstractImmutableShortByteMapTestCase
{
    @Override
    protected ImmutableShortByteMap classUnderTest()
    {
        return ShortByteMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortByteMap map1 = this.classUnderTest();
        ImmutableShortByteMap expected = this.newWithKeysValues((short) 0, (byte) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, (byte) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, (byte) 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortByteMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortByteMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.map.containsValue((byte) 0));
        Assert.assertFalse(this.map.containsValue((byte) 31));
        Assert.assertFalse(this.map.containsValue((byte) 32));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.map.contains((byte) 0));
        Assert.assertFalse(this.map.contains((byte) 31));
        Assert.assertFalse(this.map.contains((byte) 32));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(5L, this.map.getIfAbsent((short) 0, (byte) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((short) 31, (byte) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((short) 32, (byte) 25));
    }

    @Override
    @Test
    public void asLazy()
    {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void byteIterator()
    {
        ByteIterator iterator = this.map.byteIterator();
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 0));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((short) 0));
        Assert.assertEquals(0L, this.map.get((short) 31));
        Assert.assertEquals(0L, this.map.get((short) 32));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.map.containsAll((byte) 0, (byte) 31, (byte) 32));
        Assert.assertFalse(this.map.containsAll((byte) 0, (byte) 31, (byte) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertFalse(this.map.containsKey((short) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(ShortArrayList.newListWith(), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertEquals(this.map.toSortedArray().length, 0);
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 32)));
        Assert.assertFalse(this.map.containsAll(ByteArrayList.newListWith((byte) 0, (byte) 31, (byte) 35)));
        Assert.assertTrue(this.map.containsAll(new ByteArrayList()));
    }

    @Override
    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((short value1, byte value2) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((short value1, byte value2) -> false));
    }

    @Override
    @Test
    public void select_value()
    {
        Assert.assertEquals(ByteBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value()
    {
        Assert.assertEquals(ByteBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count((byte value) -> true));
    }

    @Override
    @Test
    public void sum()
    {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto()
    {
        ImmutableShortByteEmptyMap iterable = new ImmutableShortByteEmptyMap();
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }
}
