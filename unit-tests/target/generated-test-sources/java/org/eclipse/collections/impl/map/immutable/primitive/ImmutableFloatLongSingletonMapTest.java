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

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.FloatLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatLongMap;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatLongSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableFloatLongSingletonMapTest extends AbstractImmutableFloatLongMapTestCase
{
    @Override
    protected ImmutableFloatLongMap classUnderTest()
    {
        return FloatLongMaps.immutable.with(0.0f, 0L);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatLongMap map1 = this.classUnderTest();
        ImmutableFloatLongMap expected = this.newWithKeysValues(0.0f, 0L);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0f, 0L));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0f, 0L));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatLongMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableFloatLongMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0f));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0f));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatLongMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableFloatLongMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(FloatArrayList.newListWith(31.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertFalse(this.map.containsValue(31L));
        Assert.assertFalse(this.map.containsValue(32L));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0L));
        Assert.assertFalse(this.map.contains(31L));
        Assert.assertFalse(this.map.contains(32L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, 5L));
        Assert.assertEquals(15L, this.map.getIfAbsent(31.0f, 15L));
        Assert.assertEquals(25L, this.map.getIfAbsent(32.0f, 25L));
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(LongArrayList.newListWith(0L), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void longIterator()
    {
        LongIterator iterator = this.map.longIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0f));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31.0f));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32.0f));
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
        Assert.assertFalse(this.map.containsAll(0L, 31L, 32L));
        Assert.assertFalse(this.map.containsAll(31L, 35L));
        Assert.assertTrue(this.map.containsAll(0L));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0.0f));
        Assert.assertFalse(this.map.containsKey(31.0f));
        Assert.assertFalse(this.map.containsKey(32.0f));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new long[]{0L}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 32L)));
        Assert.assertFalse(this.map.containsAll(LongArrayList.newListWith(0L, 31L, 35L)));
        Assert.assertTrue(this.map.containsAll(LongArrayList.newListWith(0L)));
        Assert.assertTrue(this.map.containsAll(new LongArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        FloatLongMap actual1 = this.classUnderTest().select((float key, long value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), actual1);
        FloatLongMap actual2 = this.classUnderTest().select((float key, long value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        FloatLongMap actual1 = this.classUnderTest().reject((float key, long value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), actual1);
        FloatLongMap actual2 = this.classUnderTest().reject((float key, long value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        LongIterable actual1 = this.classUnderTest().select(LongPredicates.equal(1L));
        Assert.assertEquals(LongBags.immutable.empty(), actual1);

        LongIterable actual2 = this.classUnderTest().select(LongPredicates.equal(0L));
        Assert.assertEquals(LongBags.immutable.with(0L), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        LongIterable actual1 = this.classUnderTest().reject(LongPredicates.equal(0L));
        Assert.assertEquals(LongBags.immutable.empty(), actual1);

        LongIterable actual2 = this.classUnderTest().reject(LongPredicates.equal(1L));
        Assert.assertEquals(LongBags.immutable.with(0L), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(LongPredicates.equal(1L)));
        Assert.assertEquals(1, this.classUnderTest().count(LongPredicates.equal(0L)));
    }

    @Test
    public void injectInto()
    {
        ImmutableFloatLongSingletonMap iterable = new ImmutableFloatLongSingletonMap(1.0f, 1L);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(1L), result);
    }
}
