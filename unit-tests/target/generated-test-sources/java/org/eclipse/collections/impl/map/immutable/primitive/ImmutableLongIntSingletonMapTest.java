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
import org.eclipse.collections.api.map.primitive.LongIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongIntMap;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.LongIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongIntSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableLongIntSingletonMapTest extends AbstractImmutableLongIntMapTestCase
{
    @Override
    protected ImmutableLongIntMap classUnderTest()
    {
        return LongIntMaps.immutable.with(0L, 0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongIntMap map1 = this.classUnderTest();
        ImmutableLongIntMap expected = this.newWithKeysValues(0L, 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0L, 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0L, 0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32L));
        Assert.assertSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableLongIntMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0L));
        Assert.assertNotSame(map2, map2.newWithoutKey(0L));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongIntMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableLongIntMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(LongArrayList.newListWith(31L, 32L)));
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31L, 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32L, 25));
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
        Assert.assertEquals(0L, this.map.getOrThrow(0L));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31L));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32L));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0L));
        Assert.assertEquals(0L, this.map.get(31L));
        Assert.assertEquals(0L, this.map.get(32L));
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
        Assert.assertTrue(this.map.containsKey(0L));
        Assert.assertFalse(this.map.containsKey(31L));
        Assert.assertFalse(this.map.containsKey(32L));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(LongArrayList.newListWith(0L), this.map.keysView().toSortedList());
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
        LongIntMap actual1 = this.classUnderTest().select((long key, int value) -> key == 0L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0), actual1);
        LongIntMap actual2 = this.classUnderTest().select((long key, int value) -> key == 1L);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        LongIntMap actual1 = this.classUnderTest().reject((long key, int value) -> key == 1L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0), actual1);
        LongIntMap actual2 = this.classUnderTest().reject((long key, int value) -> key == 0L);
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
        ImmutableLongIntSingletonMap iterable = new ImmutableLongIntSingletonMap(1L, 1);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(1), result);
    }
}
