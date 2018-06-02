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
import org.eclipse.collections.api.map.primitive.IntIntMap;
import org.eclipse.collections.api.map.primitive.ImmutableIntIntMap;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.factory.primitive.IntIntMaps;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.IntIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntIntSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableIntIntSingletonMapTest extends AbstractImmutableIntIntMapTestCase
{
    @Override
    protected ImmutableIntIntMap classUnderTest()
    {
        return IntIntMaps.immutable.with(0, 0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableIntIntMap map1 = this.classUnderTest();
        ImmutableIntIntMap expected = this.newWithKeysValues(0, 0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0, 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0, 0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableIntIntMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32));
        Assert.assertSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableIntIntMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0));
        Assert.assertNotSame(map2, map2.newWithoutKey(0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableIntIntMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableIntIntMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(IntArrayList.newListWith(31, 32)));
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0, 5));
        Assert.assertEquals(15L, this.map.getIfAbsent(31, 15));
        Assert.assertEquals(25L, this.map.getIfAbsent(32, 25));
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
        Assert.assertEquals(0L, this.map.getOrThrow(0));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0));
        Assert.assertEquals(0L, this.map.get(31));
        Assert.assertEquals(0L, this.map.get(32));
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
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertFalse(this.map.containsKey(31));
        Assert.assertFalse(this.map.containsKey(32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(IntArrayList.newListWith(0), this.map.keysView().toSortedList());
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
        IntIntMap actual1 = this.classUnderTest().select((int key, int value) -> key == 0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0), actual1);
        IntIntMap actual2 = this.classUnderTest().select((int key, int value) -> key == 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        IntIntMap actual1 = this.classUnderTest().reject((int key, int value) -> key == 1);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(0, 0), actual1);
        IntIntMap actual2 = this.classUnderTest().reject((int key, int value) -> key == 0);
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
        ImmutableIntIntSingletonMap iterable = new ImmutableIntIntSingletonMap(1, 1);
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(1), result);
    }
}
