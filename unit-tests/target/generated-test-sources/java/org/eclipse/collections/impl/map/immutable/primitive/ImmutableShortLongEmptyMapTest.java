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

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortLongEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableShortLongEmptyMapTest extends AbstractImmutableShortLongMapTestCase
{
    @Override
    protected ImmutableShortLongMap classUnderTest()
    {
        return ShortLongMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortLongMap map1 = this.classUnderTest();
        ImmutableShortLongMap expected = this.newWithKeysValues((short) 0, 0L);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, 0L));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, 0L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortLongMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortLongMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.map.containsValue(0L));
        Assert.assertFalse(this.map.containsValue(31L));
        Assert.assertFalse(this.map.containsValue(32L));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.map.contains(0L));
        Assert.assertFalse(this.map.contains(31L));
        Assert.assertFalse(this.map.contains(32L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(5L, this.map.getIfAbsent((short) 0, 5L));
        Assert.assertEquals(15L, this.map.getIfAbsent((short) 31, 15L));
        Assert.assertEquals(25L, this.map.getIfAbsent((short) 32, 25L));
    }

    @Override
    @Test
    public void asLazy()
    {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void longIterator()
    {
        LongIterator iterator = this.map.longIterator();
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
        Assert.assertFalse(this.map.containsAll(0L, 31L, 32L));
        Assert.assertFalse(this.map.containsAll(0L, 31L, 35L));
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
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 32L)));
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 35L)));
        Assert.assertTrue(this.map.containsAll(new LongArrayList()));
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
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((short value1, long value2) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((short value1, long value2) -> false));
    }

    @Override
    @Test
    public void select_value()
    {
        Assert.assertEquals(LongBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value()
    {
        Assert.assertEquals(LongBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count((long value) -> true));
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
        ImmutableShortLongEmptyMap iterable = new ImmutableShortLongEmptyMap();
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(0L), result);
    }
}
