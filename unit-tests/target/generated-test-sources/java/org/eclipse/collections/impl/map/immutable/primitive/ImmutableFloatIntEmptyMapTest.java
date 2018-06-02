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

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatIntEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableFloatIntEmptyMapTest extends AbstractImmutableFloatIntMapTestCase
{
    @Override
    protected ImmutableFloatIntMap classUnderTest()
    {
        return FloatIntMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        ImmutableFloatIntMap expected = this.newWithKeysValues(0.0f, 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0f, 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0f, 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.map.containsValue(0));
        Assert.assertFalse(this.map.containsValue(31));
        Assert.assertFalse(this.map.containsValue(32));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.map.contains(0));
        Assert.assertFalse(this.map.contains(31));
        Assert.assertFalse(this.map.contains(32));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(5L, this.map.getIfAbsent(0.0f, 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31.0f, 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32.0f, 25));
    }

    @Override
    @Test
    public void asLazy()
    {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.map.intIterator();
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(0.0f));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(32.0f));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0.0f));
        Assert.assertEquals(0L, this.map.get(31.0f));
        Assert.assertEquals(0L, this.map.get(32.0f));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.map.containsAll(0, 31, 32));
        Assert.assertFalse(this.map.containsAll(0, 31, 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.map.containsKey(0.0f));
        Assert.assertFalse(this.map.containsKey(31.0f));
        Assert.assertFalse(this.map.containsKey(32.0f));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(FloatArrayList.newListWith(), this.map.keysView().toSortedList());
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
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 32)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 35)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
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
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((float value1, int value2) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((float value1, int value2) -> false));
    }

    @Override
    @Test
    public void select_value()
    {
        Assert.assertEquals(IntBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value()
    {
        Assert.assertEquals(IntBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count((int value) -> true));
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
        ImmutableFloatIntEmptyMap iterable = new ImmutableFloatIntEmptyMap();
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(0), result);
    }
}
