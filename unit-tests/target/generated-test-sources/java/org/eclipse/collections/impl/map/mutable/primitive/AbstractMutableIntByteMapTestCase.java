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

import org.eclipse.collections.api.block.function.primitive.IntToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableIntByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntByteMapTestCase extends AbstractIntByteMapTestCase
{
    @Override
    protected abstract MutableIntByteMap classUnderTest();

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1);

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2);

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3);

    @Override
    protected abstract MutableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3, int key4, byte value4);

    @Override
    protected abstract MutableIntByteMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.put(0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0));

        map1.put(0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0));

        map1.put(5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5));

        map1.put(35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0));

        map1.put(1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1));

        map1.put(5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5));

        map1.put(35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0, (byte) 5));

        Assert.assertEquals((byte) 6, map1.getIfAbsent(1, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33, (byte) 6));

        map1.put(0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0, (byte) 5));

        map1.put(1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1, (byte) 5));

        map1.put(5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5, (byte) 6));

        map1.put(35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35, (byte) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableIntByteMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals((byte) 0, map1.get(0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals((byte) 0, map1.get(0));

        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals((byte) 0, map1.get(1));

        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals((byte) 0, map1.get(31));

        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals((byte) 0, map1.get(32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableIntByteMap map1 = this.classUnderTest();

        map1.put(35, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));

        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableIntByteMap map1 = this.classUnderTest();

        map1.put(35, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));

        map1.removeKey(0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableIntByteMap hashMap1 = this.newWithKeysValues(1, (byte) 1, 0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());

        MutableIntByteMap hashMap = this.newWithKeysValues(6, (byte) 6, 5, (byte) 5);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions()
    {
        IntArrayList collisions = new IntArrayList();
        IntByteHashMap hashMap = new IntByteHashMap();
        for (int each = 2; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableIntByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntByteHashMap(), map1);

        map1.put(1, (byte) 0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new IntByteHashMap(), map1);

        map1.put(33, (byte) 0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new IntByteHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableIntByteMap map0 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map0.removeKey(1);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntByteHashMap(), map0);

        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map1.removeKey(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntByteHashMap(), map1);

        MutableIntByteMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(31, (byte) 31, 32, (byte) 32), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableIntByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableIntByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableIntByteMap map0 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map0.remove(1);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map0);
        map0.remove(0);
        Assert.assertEquals(new IntByteHashMap(), map0);

        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        map1.remove(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map1);
        map1.remove(1);
        Assert.assertEquals(new IntByteHashMap(), map1);

        MutableIntByteMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32), map2);
        map2.remove(0);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(31, (byte) 31, 32, (byte) 32), map2);
        map2.remove(31);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map2);
        map2.remove(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableIntByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableIntByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableIntByteMap map0 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0, (byte) 100));

        MutableIntByteMap map1 = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1, (byte) 100));

        MutableIntByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(31, (byte) 31, 32, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32, (byte) 100));
        Assert.assertEquals(new IntByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableIntByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableIntByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableIntByteMap map1 = this.classUnderTest();
        map1.put(0, (byte) 1);
        map1.put(31, (byte) 32);
        map1.put(32, (byte) 33);
        IntByteHashMap expected = IntByteHashMap.newWithKeysValues(0, (byte) 1, 31, (byte) 32, 32, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.put(1, (byte) 2);
        expected.put(1, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.put(33, (byte) 34);
        expected.put(33, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.put(30, (byte) 31);
        expected.put(30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableIntByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32, (byte) 33));
        IntByteHashMap expected = IntByteHashMap.newWithKeysValues(0, (byte) 1, 31, (byte) 32, 32, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1, (byte) 2));
        expected.put(1, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33, (byte) 34));
        expected.put(33, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30, (byte) 31));
        expected.put(30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32, (byte) 33));
        IntByteHashMap expected = IntByteHashMap.newWithKeysValues(0, (byte) 11, 1, (byte) 12, 31, (byte) 37, 32, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5L, map1.addToValue(31, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0, (byte) 10));
        Assert.assertEquals(expected, map1);

        MutableIntByteMap map2 = this.getEmptyMap();
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
            int k = (int) (each);
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        IntByteHashMap hashMap = new IntByteHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get(i));
            hashMap.put(i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get(i));
            hashMap.remove(i);
            Assert.assertEquals((byte) 0, hashMap.get(i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        int collision1 = AbstractMutableIntByteMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntByteMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntByteMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntByteMapTestCase.generateCollisions().get(3);

        MutableIntByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);

        MutableIntByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);

        MutableIntByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 50, 1, (byte) 50), map1);

        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 50, 1, (byte) 50), map2);

        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 50), map3);

        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, (byte) 100));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 100, 1, (byte) 100), map1);

        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 100, 1, (byte) 100), map2);

        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 100), map3);

        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factoryThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 9, 1, (byte) 9), map1);

        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 9, 1, (byte) 9), map2);

        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 9), map3);

        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33, functionThrows, "unused"));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        IntToByteFunction function = (int intParameter) -> (byte) intParameter;
        IntToByteFunction functionThrows = (int intParameter) -> { throw new AssertionError(); };

        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1), map1);

        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1), map2);

        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(32, (byte) 32), map3);

        MutableIntByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, functionThrows));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 33), map4);
    }

    @Test
    public void updateValue()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableIntByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 2), map1);

        MutableIntByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 1, 1, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 2, 1, (byte) 2), map2);

        MutableIntByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33, (byte) 0, incrementFunction));
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(33, (byte) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableIntByteMap mutableIntByteMap = this.classUnderTest();
        IntSet frozenSet = mutableIntByteMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableIntByteMap.put((int) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        IntSet frozenSetForRemove = mutableIntByteMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableIntByteMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableIntByteMap mutableIntByteMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntByteMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntByteMapForClear.keySet().toArray());
        mutableIntByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableIntByteMap map = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 31, (byte) 31, 32, (byte) 32);
        MutableIntByteMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 31, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableIntByteMap map = this.newWithKeysValues(0, (byte) 0, 1, (byte) 1, 31, (byte) 31, 32, (byte) 32);
        MutableIntByteMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1, 31, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableIntByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, (byte) 1), hashMap);
        Assert.assertEquals(IntByteHashMap.newWithKeysValues(1, (byte) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedIntByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableIntByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove()
    {
        MutableIntByteMap mutableMap = this.classUnderTest();
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
        MutableIntByteMap map = this.newWithKeysValues(1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4, (byte) 5);
        Assert.assertEquals(
                ByteIntHashMap.newWithKeysValues((byte) 2, 1, (byte) 3, 2, (byte) 4, 3, (byte) 5, 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1, (byte) 1, 2, (byte) 1).flipUniqueValues());
    }
}
