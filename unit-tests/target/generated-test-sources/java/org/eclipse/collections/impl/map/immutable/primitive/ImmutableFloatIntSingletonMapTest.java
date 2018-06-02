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

import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.FloatIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatIntSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableFloatIntSingletonMapTest extends AbstractImmutableFloatIntMapTestCase
{
    @Override
    protected ImmutableFloatIntMap classUnderTest()
    {
        return FloatIntMaps.immutable.with(0.0f, 0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        ImmutableFloatIntMap expected = this.newWithKeysValues(0.0f, 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0f, 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0f, 0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableFloatIntMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0f));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0f));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatIntMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableFloatIntMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(FloatArrayList.newListWith(31.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertFalse(this.map.containsValue(31));
        Assert.assertFalse(this.map.containsValue(32));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertFalse(this.map.contains(31));
        Assert.assertFalse(this.map.contains(32));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31.0f, 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32.0f, 25));
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(IntArrayList.newListWith(0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.map.intIterator();
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
        Assert.assertFalse(this.map.containsAll(0, 31, 32));
        Assert.assertFalse(this.map.containsAll(31, 35));
        Assert.assertTrue(this.map.containsAll(0));
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
        Assert.assertTrue(Arrays.equals(new int[]{0}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 32)));
        Assert.assertFalse(this.map.containsAll(IntArrayList.newListWith(0, 31, 35)));
        Assert.assertTrue(this.map.containsAll(IntArrayList.newListWith(0)));
        Assert.assertTrue(this.map.containsAll(new IntArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        FloatIntMap actual1 = this.classUnderTest().select((float key, int value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0), actual1);
        FloatIntMap actual2 = this.classUnderTest().select((float key, int value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        FloatIntMap actual1 = this.classUnderTest().reject((float key, int value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(0.0f, 0), actual1);
        FloatIntMap actual2 = this.classUnderTest().reject((float key, int value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        IntIterable actual1 = this.classUnderTest().select(IntPredicates.equal(1));
        Assert.assertEquals(IntBags.immutable.empty(), actual1);

        IntIterable actual2 = this.classUnderTest().select(IntPredicates.equal(0));
        Assert.assertEquals(IntBags.immutable.with(0), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        IntIterable actual1 = this.classUnderTest().reject(IntPredicates.equal(0));
        Assert.assertEquals(IntBags.immutable.empty(), actual1);

        IntIterable actual2 = this.classUnderTest().reject(IntPredicates.equal(1));
        Assert.assertEquals(IntBags.immutable.with(0), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(IntPredicates.equal(1)));
        Assert.assertEquals(1, this.classUnderTest().count(IntPredicates.equal(0)));
    }

    @Test
    public void injectInto()
    {
        ImmutableFloatIntSingletonMap iterable = new ImmutableFloatIntSingletonMap(1.0f, 1);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(1), result);
    }
}
