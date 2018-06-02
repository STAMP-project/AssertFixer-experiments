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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.map.primitive.ByteBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteBooleanMap;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.ByteBooleanMaps;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteBooleanHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteBooleanSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanSingletonMapTest.stg.
 */
public class ImmutableByteBooleanSingletonMapTest extends AbstractImmutableByteBooleanMapTestCase
{
    @Override
    protected ImmutableByteBooleanMap classUnderTest()
    {
        return ByteBooleanMaps.immutable.with((byte) 0, true);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteBooleanMap map1 = this.classUnderTest();
        ImmutableByteBooleanMap expected = this.newWithKeysValues((byte) 0, true, (byte) 1, true);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 1, true));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 1, true));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((byte) 32));
        Assert.assertSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableByteBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((byte) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((byte) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableByteBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(ByteArrayList.newListWith((byte) 31, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertFalse(this.classUnderTest().containsValue(false));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertFalse(this.classUnderTest().contains(false));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 0, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 31, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((byte) 32, false));
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.classUnderTest().asLazy().toList());
    }

    @Override
    @Test
    public void booleanIterator()
    {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertTrue(this.classUnderTest().getOrThrow((byte) 0));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get((byte) 0));
        Assert.assertFalse(this.classUnderTest().get((byte) 31));
        Assert.assertFalse(this.classUnderTest().get((byte) 32));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(true, false));
        Assert.assertFalse(this.classUnderTest().containsAll(false));
        Assert.assertTrue(this.classUnderTest().containsAll(true));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 0));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 31));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0), this.classUnderTest().keysView().toSortedList());
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void select()
    {
        ByteBooleanMap actual1 = this.classUnderTest().select((byte key, boolean value) -> key == (byte) 0);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), actual1);
        ByteBooleanMap actual2 = this.classUnderTest().select((byte key, boolean value) -> key == (byte) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        ByteBooleanMap actual1 = this.classUnderTest().reject((byte key, boolean value) -> key == (byte) 1);
        Assert.assertEquals(ByteBooleanHashMap.newWithKeysValues((byte) 0, true), actual1);
        ByteBooleanMap actual2 = this.classUnderTest().reject((byte key, boolean value) -> key == (byte) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        BooleanIterable actual1 = this.classUnderTest().select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.empty(), actual1);

        BooleanIterable actual2 = this.classUnderTest().select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        BooleanIterable actual1 = this.classUnderTest().reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.empty(), actual1);

        BooleanIterable actual2 = this.classUnderTest().reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(BooleanPredicates.isFalse()));
        Assert.assertEquals(1, this.classUnderTest().count(BooleanPredicates.isTrue()));
    }
}
