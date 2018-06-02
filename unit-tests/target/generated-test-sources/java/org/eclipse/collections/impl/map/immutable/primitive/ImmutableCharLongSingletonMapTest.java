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
import org.eclipse.collections.api.map.primitive.CharLongMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharLongMap;
import org.eclipse.collections.impl.block.factory.primitive.LongPredicates;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharLongSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableCharLongSingletonMapTest extends AbstractImmutableCharLongMapTestCase
{
    @Override
    protected ImmutableCharLongMap classUnderTest()
    {
        return CharLongMaps.immutable.with((char) 0, 0L);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharLongMap map1 = this.classUnderTest();
        ImmutableCharLongMap expected = this.newWithKeysValues((char) 0, 0L);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 0, 0L));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 0, 0L));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharLongMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((char) 32));
        Assert.assertSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableCharLongMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((char) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((char) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharLongMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableCharLongMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(CharArrayList.newListWith((char) 31, (char) 32)));
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
        Assert.assertEquals(0L, this.map.getIfAbsent((char) 0, 5L));
        Assert.assertEquals(15L, this.map.getIfAbsent((char) 31, 15L));
        Assert.assertEquals(25L, this.map.getIfAbsent((char) 32, 25L));
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
        Assert.assertEquals(0L, this.map.getOrThrow((char) 0));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(0L, this.map.get((char) 31));
        Assert.assertEquals(0L, this.map.get((char) 32));
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
        Assert.assertTrue(this.map.containsKey((char) 0));
        Assert.assertFalse(this.map.containsKey((char) 31));
        Assert.assertFalse(this.map.containsKey((char) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.map.keysView().toSortedList());
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
        CharLongMap actual1 = this.classUnderTest().select((char key, long value) -> key == (char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), actual1);
        CharLongMap actual2 = this.classUnderTest().select((char key, long value) -> key == (char) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        CharLongMap actual1 = this.classUnderTest().reject((char key, long value) -> key == (char) 1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), actual1);
        CharLongMap actual2 = this.classUnderTest().reject((char key, long value) -> key == (char) 0);
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
        ImmutableCharLongSingletonMap iterable = new ImmutableCharLongSingletonMap((char) 1, 1L);
        MutableLong result = iterable.injectInto(new MutableLong(0L), MutableLong::add);
        Assert.assertEquals(new MutableLong(1L), result);
    }
}
