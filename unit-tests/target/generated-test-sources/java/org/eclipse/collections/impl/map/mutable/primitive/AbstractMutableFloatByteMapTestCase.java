/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.block.function.primitive.FloatToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatByteMapTestCase extends AbstractFloatByteMapTestCase
{
    @Override
    protected abstract MutableFloatByteMap classUnderTest();

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1);

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2);

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3);

    @Override
    protected abstract MutableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3, float key4, byte value4);

    @Override
    protected abstract MutableFloatByteMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.put(0.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0.0f));

        map1.put(0.0f, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0.0f));

        map1.put(5.0f, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5.0f));

        map1.put(35.0f, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0.0f));

        map1.put(1.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1.0f));

        map1.put(5.0f, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5.0f));

        map1.put(35.0f, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0.0f, (byte) 5));

        Assert.assertEquals((byte) 6, map1.getIfAbsent(1.0f, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33.0f, (byte) 6));

        map1.put(0.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0.0f, (byte) 5));

        map1.put(1.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1.0f, (byte) 5));

        map1.put(5.0f, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5.0f, (byte) 6));

        map1.put(35.0f, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35.0f, (byte) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((byte) 0, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((byte) 0, map1.get(0.0f));

        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals((byte) 0, map1.get(1.0f));

        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals((byte) 0, map1.get(31.0f));

        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals((byte) 0, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableFloatByteMap map1 = this.classUnderTest();

        map1.put(35.0f, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableFloatByteMap map1 = this.classUnderTest();

        map1.put(35.0f, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableFloatByteMap hashMap1 = this.newWithKeysValues(1.0f, (byte) 1, 0.0f, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());

        MutableFloatByteMap hashMap = this.newWithKeysValues(6.0f, (byte) 6, 5.0f, (byte) 5);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions()
    {
        FloatArrayList collisions = new FloatArrayList();
        FloatByteHashMap hashMap = new FloatByteHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatByteHashMap(), map1);

        map1.put(1.0f, (byte) 0);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatByteHashMap(), map1);

        map1.put(33.0f, (byte) 0);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatByteHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableFloatByteMap map0 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatByteHashMap(), map0);

        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatByteHashMap(), map1);

        MutableFloatByteMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableFloatByteMap map0 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map0.remove(1.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatByteHashMap(), map0);

        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        map1.remove(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatByteHashMap(), map1);

        MutableFloatByteMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableFloatByteMap map0 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0.0f, (byte) 100));

        MutableFloatByteMap map1 = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1.0f, (byte) 100));

        MutableFloatByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(31.0f, (byte) 31, 32.0f, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31.0f, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32.0f, (byte) 100));
        Assert.assertEquals(new FloatByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.put(0.0f, (byte) 1);
        map1.put(31.0f, (byte) 32);
        map1.put(32.0f, (byte) 33);
        FloatByteHashMap expected = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1, 31.0f, (byte) 32, 32.0f, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.put(1.0f, (byte) 2);
        expected.put(1.0f, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.put(33.0f, (byte) 34);
        expected.put(33.0f, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.put(30.0f, (byte) 31);
        expected.put(30.0f, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableFloatByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31.0f, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32.0f, (byte) 33));
        FloatByteHashMap expected = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1, 31.0f, (byte) 32, 32.0f, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0f, (byte) 2));
        expected.put(1.0f, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0f, (byte) 34));
        expected.put(33.0f, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0f, (byte) 31));
        expected.put(30.0f, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0f, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (byte) 33));
        FloatByteHashMap expected = FloatByteHashMap.newWithKeysValues(0.0f, (byte) 11, 1.0f, (byte) 12, 31.0f, (byte) 37, 32.0f, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0f, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (byte) 10));
        Assert.assertEquals(expected, map1);

        MutableFloatByteMap map2 = this.getEmptyMap();
        MutableLongList list = LongLists.mutable.with(
            936628237L,
            4889384619L,
            8733915902L,
            2377747912L,
            277382636L,
            593670575L,
            296725141L,
            7131901003L,
            9986389012L
        );

        list.forEachWithIndex((each, index) -> {
            float k = each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        FloatByteHashMap hashMap = new FloatByteHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((float) i));
            hashMap.put((float) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals((byte) 0, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatByteMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatByteMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatByteMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatByteMapTestCase.generateCollisions().get(3);

        MutableFloatByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);

        MutableFloatByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);

        MutableFloatByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 50, 1.0f, (byte) 50), map1);

        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 50, 1.0f, (byte) 50), map2);

        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 50), map3);

        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (byte) 100));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 100, 1.0f, (byte) 100), map1);

        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 100, 1.0f, (byte) 100), map2);

        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 100), map3);

        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 9, 1.0f, (byte) 9), map1);

        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 9, 1.0f, (byte) 9), map2);

        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 9), map3);

        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToByteFunction function = (float floatParameter) -> (byte) floatParameter;
        FloatToByteFunction functionThrows = (float floatParameter) -> { throw new AssertionError(); };

        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1), map1);

        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1), map2);

        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(32.0f, (byte) 32), map3);

        MutableFloatByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 33), map4);
    }

    @Test
    public void updateValue()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableFloatByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2, 1.0f, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2, 1.0f, (byte) 2), map1);

        MutableFloatByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 1, 1.0f, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 2, 1.0f, (byte) 2), map2);

        MutableFloatByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, (byte) 0, incrementFunction));
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(33.0f, (byte) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableFloatByteMap mutableFloatByteMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatByteMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatByteMap.put((float) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        FloatSet frozenSetForRemove = mutableFloatByteMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatByteMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableFloatByteMap mutableFloatByteMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatByteMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatByteMapForClear.keySet().toArray());
        mutableFloatByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableFloatByteMap map = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 31.0f, (byte) 31, 32.0f, (byte) 32);
        MutableFloatByteMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 31.0f, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableFloatByteMap map = this.newWithKeysValues(0.0f, (byte) 0, 1.0f, (byte) 1, 31.0f, (byte) 31, 32.0f, (byte) 32);
        MutableFloatByteMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1, 31.0f, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableFloatByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, (byte) 1), hashMap);
        Assert.assertEquals(FloatByteHashMap.newWithKeysValues(1.0f, (byte) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedFloatByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableFloatByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove()
    {
        MutableFloatByteMap mutableMap = this.classUnderTest();
        MutableByteIterator iterator = mutableMap.byteIterator();

        while (iterator.hasNext())
        {
            iterator.next();
            iterator.remove();
        }
        Assert.assertFalse(iterator.hasNext());
        Verify.assertEmpty(mutableMap);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableFloatByteMap map = this.newWithKeysValues(1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f, (byte) 5);
        Assert.assertEquals(
                ByteFloatHashMap.newWithKeysValues((byte) 2, 1.0f, (byte) 3, 2.0f, (byte) 4, 3.0f, (byte) 5, 4.0f),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0f, (byte) 1, 2.0f, (byte) 1).flipUniqueValues());
    }
}
