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

import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.ShortShortMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortShortMap;
import org.eclipse.collections.impl.block.factory.primitive.ShortPredicates;
import org.eclipse.collections.impl.factory.primitive.ShortShortMaps;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortShortSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableShortShortSingletonMapTest extends AbstractImmutableShortShortMapTestCase
{
    @Override
    protected ImmutableShortShortMap classUnderTest()
    {
        return ShortShortMaps.immutable.with((short) 0, (short) 0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortShortMap map1 = this.classUnderTest();
        ImmutableShortShortMap expected = this.newWithKeysValues((short) 0, (short) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, (short) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, (short) 0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortShortMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortShortMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((short) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((short) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortShortMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortShortMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(ShortArrayList.newListWith((short) 31, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertFalse(this.map.containsValue((short) 31));
        Assert.assertFalse(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertFalse(this.map.contains((short) 31));
        Assert.assertFalse(this.map.contains((short) 32));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent((short) 0, (short) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((short) 31, (short) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((short) 32, (short) 25));
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void shortIterator()
    {
        ShortIterator iterator = this.map.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow((short) 0));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 32));
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
        Assert.assertFalse(this.map.containsAll((short) 0, (short) 31, (short) 32));
        Assert.assertFalse(this.map.containsAll((short) 31, (short) 35));
        Assert.assertTrue(this.map.containsAll((short) 0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertFalse(this.map.containsKey((short) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new short[]{(short) 0}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 32)));
        Assert.assertFalse(this.map.containsAll(ShortArrayList.newListWith((short) 0, (short) 31, (short) 35)));
        Assert.assertTrue(this.map.containsAll(ShortArrayList.newListWith((short) 0)));
        Assert.assertTrue(this.map.containsAll(new ShortArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        ShortShortMap actual1 = this.classUnderTest().select((short key, short value) -> key == (short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), actual1);
        ShortShortMap actual2 = this.classUnderTest().select((short key, short value) -> key == (short) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        ShortShortMap actual1 = this.classUnderTest().reject((short key, short value) -> key == (short) 1);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), actual1);
        ShortShortMap actual2 = this.classUnderTest().reject((short key, short value) -> key == (short) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        ShortIterable actual1 = this.classUnderTest().select(ShortPredicates.equal((short) 1));
        Assert.assertEquals(ShortBags.immutable.empty(), actual1);

        ShortIterable actual2 = this.classUnderTest().select(ShortPredicates.equal((short) 0));
        Assert.assertEquals(ShortBags.immutable.with((short) 0), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        ShortIterable actual1 = this.classUnderTest().reject(ShortPredicates.equal((short) 0));
        Assert.assertEquals(ShortBags.immutable.empty(), actual1);

        ShortIterable actual2 = this.classUnderTest().reject(ShortPredicates.equal((short) 1));
        Assert.assertEquals(ShortBags.immutable.with((short) 0), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(ShortPredicates.equal((short) 1)));
        Assert.assertEquals(1, this.classUnderTest().count(ShortPredicates.equal((short) 0)));
    }

    @Test
    public void injectInto()
    {
        ImmutableShortShortSingletonMap iterable = new ImmutableShortShortSingletonMap((short) 1, (short) 1);
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 1), result);
    }
}
