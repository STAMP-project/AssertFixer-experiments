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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.ByteFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteFloatSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableByteFloatSingletonMapTest extends AbstractImmutableByteFloatMapTestCase
{
    @Override
    protected ImmutableByteFloatMap classUnderTest()
    {
        return ByteFloatMaps.immutable.with((byte) 0, 0.0f);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteFloatMap map1 = this.classUnderTest();
        ImmutableByteFloatMap expected = this.newWithKeysValues((byte) 0, 0.0f);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 0, 0.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 0, 0.0f));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((byte) 32));
        Assert.assertSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableByteFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((byte) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((byte) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableByteFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(ByteArrayList.newListWith((byte) 31, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertFalse(this.map.containsValue(31.0f));
        Assert.assertFalse(this.map.containsValue(32.0f));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertFalse(this.map.contains(31.0f));
        Assert.assertFalse(this.map.contains(32.0f));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent((byte) 0, 5.0f), 0.0);
        Assert.assertEquals(15.0, this.map.getIfAbsent((byte) 31, 15.0f), 0.0);
        Assert.assertEquals(25.0, this.map.getIfAbsent((byte) 32, 25.0f), 0.0);
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void floatIterator()
    {
        FloatIterator iterator = this.map.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow((byte) 0), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get((byte) 0), 0.0);
        Assert.assertEquals(0.0, this.map.get((byte) 31), 0.0);
        Assert.assertEquals(0.0, this.map.get((byte) 32), 0.0);
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.map.containsAll(0.0f, 31.0f, 32.0f));
        Assert.assertFalse(this.map.containsAll(31.0f, 35.0f));
        Assert.assertTrue(this.map.containsAll(0.0f));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey((byte) 0));
        Assert.assertFalse(this.map.containsKey((byte) 31));
        Assert.assertFalse(this.map.containsKey((byte) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(ByteArrayList.newListWith((byte) 0), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new float[]{0.0f}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f)));
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 35.0f)));
        Assert.assertTrue(this.map.containsAll(FloatArrayList.newListWith(0.0f)));
        Assert.assertTrue(this.map.containsAll(new FloatArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        ByteFloatMap actual1 = this.classUnderTest().select((byte key, float value) -> key == (byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), actual1);
        ByteFloatMap actual2 = this.classUnderTest().select((byte key, float value) -> key == (byte) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        ByteFloatMap actual1 = this.classUnderTest().reject((byte key, float value) -> key == (byte) 1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), actual1);
        ByteFloatMap actual2 = this.classUnderTest().reject((byte key, float value) -> key == (byte) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        FloatIterable actual1 = this.classUnderTest().select(FloatPredicates.equal(1.0f));
        Assert.assertEquals(FloatBags.immutable.empty(), actual1);

        FloatIterable actual2 = this.classUnderTest().select(FloatPredicates.equal(0.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        FloatIterable actual1 = this.classUnderTest().reject(FloatPredicates.equal(0.0f));
        Assert.assertEquals(FloatBags.immutable.empty(), actual1);

        FloatIterable actual2 = this.classUnderTest().reject(FloatPredicates.equal(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(FloatPredicates.equal(1.0f)));
        Assert.assertEquals(1, this.classUnderTest().count(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void injectInto()
    {
        ImmutableByteFloatSingletonMap iterable = new ImmutableByteFloatSingletonMap((byte) 1, 1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(1.0f), result);
    }
}
