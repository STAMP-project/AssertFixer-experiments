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

import org.eclipse.collections.api.block.function.primitive.DoubleToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleByteMapTestCase extends AbstractDoubleByteMapTestCase
{
    @Override
    protected abstract MutableDoubleByteMap classUnderTest();

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1);

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2);

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3);

    @Override
    protected abstract MutableDoubleByteMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3, double key4, byte value4);

    @Override
    protected abstract MutableDoubleByteMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.put(0.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get(0.0));

        map1.put(0.0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get(0.0));

        map1.put(5.0, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get(5.0));

        map1.put(35.0, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(0.0));

        map1.put(1.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow(1.0));

        map1.put(5.0, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow(5.0));

        map1.put(35.0, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(0.0, (byte) 5));

        Assert.assertEquals((byte) 6, map1.getIfAbsent(1.0, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent(33.0, (byte) 6));

        map1.put(0.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(0.0, (byte) 5));

        map1.put(1.0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent(1.0, (byte) 5));

        map1.put(5.0, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent(5.0, (byte) 6));

        map1.put(35.0, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent(35.0, (byte) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((byte) 0, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((byte) 0, map1.get(0.0));

        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals((byte) 0, map1.get(1.0));

        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals((byte) 0, map1.get(31.0));

        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals((byte) 0, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableDoubleByteMap map1 = this.classUnderTest();

        map1.put(35.0, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableDoubleByteMap map1 = this.classUnderTest();

        map1.put(35.0, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableDoubleByteMap hashMap1 = this.newWithKeysValues(1.0, (byte) 1, 0.0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());

        MutableDoubleByteMap hashMap = this.newWithKeysValues(6.0, (byte) 6, 5.0, (byte) 5);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        for (double each = 2.0; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleByteHashMap(), map1);

        map1.put(1.0, (byte) 0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleByteHashMap(), map1);

        map1.put(33.0, (byte) 0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleByteHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableDoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleByteHashMap(), map0);

        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleByteHashMap(), map1);

        MutableDoubleByteMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableDoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map0.remove(1.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleByteHashMap(), map0);

        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        map1.remove(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleByteHashMap(), map1);

        MutableDoubleByteMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(31.0, (byte) 31, 32.0, (byte) 32), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableDoubleByteMap map0 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent(1.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(1.0, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent(0.0, (byte) 100));

        MutableDoubleByteMap map1 = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent(1.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent(1.0, (byte) 100));

        MutableDoubleByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(5.0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(50.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(31.0, (byte) 31, 32.0, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent(31.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent(32.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(0.0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(31.0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent(32.0, (byte) 100));
        Assert.assertEquals(new DoubleByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.put(0.0, (byte) 1);
        map1.put(31.0, (byte) 32);
        map1.put(32.0, (byte) 33);
        DoubleByteHashMap expected = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1, 31.0, (byte) 32, 32.0, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.put(1.0, (byte) 2);
        expected.put(1.0, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.put(33.0, (byte) 34);
        expected.put(33.0, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.put(30.0, (byte) 31);
        expected.put(30.0, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableDoubleByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair(31.0, (byte) 32));
        map1.putPair(PrimitiveTuples.pair(32.0, (byte) 33));
        DoubleByteHashMap expected = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1, 31.0, (byte) 32, 32.0, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0, (byte) 2));
        expected.put(1.0, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0, (byte) 34));
        expected.put(33.0, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0, (byte) 31));
        expected.put(30.0, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0, (byte) 33));
        DoubleByteHashMap expected = DoubleByteHashMap.newWithKeysValues(0.0, (byte) 11, 1.0, (byte) 12, 31.0, (byte) 37, 32.0, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0, (byte) 10));
        Assert.assertEquals(expected, map1);

        MutableDoubleByteMap map2 = this.getEmptyMap();
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
            double k = each;
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((double) i));
            hashMap.put((double) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals((byte) 0, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        double collision1 = AbstractMutableDoubleByteMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleByteMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleByteMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleByteMapTestCase.generateCollisions().get(3);

        MutableDoubleByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);

        MutableDoubleByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);

        MutableDoubleByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 50, 1.0, (byte) 50), map1);

        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 50, 1.0, (byte) 50), map2);

        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 50), map3);

        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (byte) 100));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 100, 1.0, (byte) 100), map1);

        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 100, 1.0, (byte) 100), map2);

        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 100), map3);

        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 9, 1.0, (byte) 9), map1);

        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 9, 1.0, (byte) 9), map2);

        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 9), map3);

        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToByteFunction function = (double doubleParameter) -> (byte) doubleParameter;
        DoubleToByteFunction functionThrows = (double doubleParameter) -> { throw new AssertionError(); };

        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1), map1);

        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1), map2);

        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(32.0, (byte) 32), map3);

        MutableDoubleByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 33), map4);
    }

    @Test
    public void updateValue()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableDoubleByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2, 1.0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2, 1.0, (byte) 2), map1);

        MutableDoubleByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 1, 1.0, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 2, 1.0, (byte) 2), map2);

        MutableDoubleByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, (byte) 0, incrementFunction));
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(33.0, (byte) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableDoubleByteMap mutableDoubleByteMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleByteMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleByteMap.put((double) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        DoubleSet frozenSetForRemove = mutableDoubleByteMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleByteMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableDoubleByteMap mutableDoubleByteMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleByteMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleByteMapForClear.keySet().toArray());
        mutableDoubleByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableDoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 31.0, (byte) 31, 32.0, (byte) 32);
        MutableDoubleByteMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 31.0, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableDoubleByteMap map = this.newWithKeysValues(0.0, (byte) 0, 1.0, (byte) 1, 31.0, (byte) 31, 32.0, (byte) 32);
        MutableDoubleByteMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 31.0, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableDoubleByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, (byte) 1), hashMap);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedDoubleByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableDoubleByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove()
    {
        MutableDoubleByteMap mutableMap = this.classUnderTest();
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
        MutableDoubleByteMap map = this.newWithKeysValues(1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0, (byte) 5);
        Assert.assertEquals(
                ByteDoubleHashMap.newWithKeysValues((byte) 2, 1.0, (byte) 3, 2.0, (byte) 4, 3.0, (byte) 5, 4.0),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 1).flipUniqueValues());
    }
}
