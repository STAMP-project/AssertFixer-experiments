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

import org.eclipse.collections.api.block.function.primitive.LongToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongDoubleMapTestCase extends AbstractLongDoubleMapTestCase
{
    @Override
    protected abstract MutableLongDoubleMap classUnderTest();

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1);

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2);

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3);

    @Override
    protected abstract MutableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3, long key4, double value4);

    @Override
    protected abstract MutableLongDoubleMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.put(0L, 1.0);
        Assert.assertEquals(1.0, map1.get(0L), 0.0);

        map1.put(0L, 0.0);
        Assert.assertEquals(0.0, map1.get(0L), 0.0);

        map1.put(5L, 5.0);
        Assert.assertEquals(5.0, map1.get(5L), 0.0);

        map1.put(35L, 35.0);
        Assert.assertEquals(35.0, map1.get(35L), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0L), 0.0);

        map1.put(1L, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1L), 0.0);

        map1.put(5L, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5L), 0.0);

        map1.put(35L, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35L), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals(5.0, map1.getIfAbsent(0L, 5.0), 0.0);

        Assert.assertEquals(6.0, map1.getIfAbsent(1L, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33L, 6.0), 0.0);

        map1.put(0L, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0L, 5.0), 0.0);

        map1.put(1L, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1L, 5.0), 0.0);

        map1.put(5L, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5L, 6.0), 0.0);

        map1.put(35L, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35L, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0.0, map1.get(0L), 0.0);
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0.0, map1.get(0L), 0.0);

        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals(0.0, map1.get(1L), 0.0);

        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals(0.0, map1.get(31L), 0.0);

        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals(0.0, map1.get(32L), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableLongDoubleMap map1 = this.classUnderTest();

        map1.put(35L, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));

        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableLongDoubleMap map1 = this.classUnderTest();

        map1.put(35L, 35.0);
        Assert.assertTrue(map1.contains(35.0));

        map1.removeKey(0L);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableLongDoubleMap hashMap1 = this.newWithKeysValues(1L, 1.0, 0L, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());

        MutableLongDoubleMap hashMap = this.newWithKeysValues(6L, 6.0, 5L, 5.0);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions()
    {
        LongArrayList collisions = new LongArrayList();
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        for (long each = 2L; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2L))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongDoubleHashMap(), map1);

        map1.put(1L, 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new LongDoubleHashMap(), map1);

        map1.put(33L, 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new LongDoubleHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableLongDoubleMap map0 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map0.removeKey(1L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongDoubleHashMap(), map0);

        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map1.removeKey(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongDoubleHashMap(), map1);

        MutableLongDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(31L, 31.0, 32L, 32.0), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableLongDoubleMap map0 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map0.remove(1L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongDoubleHashMap(), map0);

        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        map1.remove(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongDoubleHashMap(), map1);

        MutableLongDoubleMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0), map2);
        map2.remove(0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(31L, 31.0, 32L, 32.0), map2);
        map2.remove(31L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableLongDoubleMap map0 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1L, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0L, 100.0), 0.0);

        MutableLongDoubleMap map1 = this.newWithKeysValues(0L, 0.0, 1L, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1L, 100.0), 0.0);

        MutableLongDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5L, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(31L, 31.0, 32L, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0L, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31L, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32L, 100.0), 0.0);
        Assert.assertEquals(new LongDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.put(0L, 1.0);
        map1.put(31L, 32.0);
        map1.put(32L, 33.0);
        LongDoubleHashMap expected = LongDoubleHashMap.newWithKeysValues(0L, 1.0, 31L, 32.0, 32L, 33.0);
        Assert.assertEquals(expected, map1);

        map1.put(1L, 2.0);
        expected.put(1L, 2.0);
        Assert.assertEquals(expected, map1);

        map1.put(33L, 34.0);
        expected.put(33L, 34.0);
        Assert.assertEquals(expected, map1);

        map1.put(30L, 31.0);
        expected.put(30L, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableLongDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, 1.0));
        map1.putPair(PrimitiveTuples.pair(31L, 32.0));
        map1.putPair(PrimitiveTuples.pair(32L, 33.0));
        LongDoubleHashMap expected = LongDoubleHashMap.newWithKeysValues(0L, 1.0, 31L, 32.0, 32L, 33.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1L, 2.0));
        expected.put(1L, 2.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33L, 34.0));
        expected.put(33L, 34.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30L, 31.0));
        expected.put(30L, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0L, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31L, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1L, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0L, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1L, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31L, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32L, 33.0), 0.0);
        LongDoubleHashMap expected = LongDoubleHashMap.newWithKeysValues(0L, 11.0, 1L, 12.0, 31L, 37.0, 32L, 33.0);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5.0, map1.addToValue(31L, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31L, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32L, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1L, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0L, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1L, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0L, 10.0), 0.0);
        Assert.assertEquals(expected, map1);

        MutableLongDoubleMap map2 = this.getEmptyMap();
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
            long k = each;
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        LongDoubleHashMap hashMap = new LongDoubleHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((long) i), 0.0);
            hashMap.put((long) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((long) i), 0.0);
            hashMap.remove((long) i);
            Assert.assertEquals(0.0, hashMap.get((long) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        long collision1 = AbstractMutableLongDoubleMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongDoubleMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongDoubleMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongDoubleMapTestCase.generateCollisions().get(3);

        MutableLongDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);

        MutableLongDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);

        MutableLongDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0L, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1L, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 50.0, 1L, 50.0), map1);

        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1L, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0L, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 50.0, 1L, 50.0), map2);

        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32L, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 50.0), map3);

        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33L, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33L, 100.0), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0L, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1L, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 100.0, 1L, 100.0), map1);

        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1L, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0L, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 100.0, 1L, 100.0), map2);

        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32L, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 100.0), map3);

        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33L, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33L, factoryThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 9.0, 1L, 9.0), map1);

        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 9.0, 1L, 9.0), map2);

        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 9.0), map3);

        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33L, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33L, functionThrows, "unused"), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToDoubleFunction function = (long longParameter) -> (double) longParameter;
        LongToDoubleFunction functionThrows = (long longParameter) -> { throw new AssertionError(); };

        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0L, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1L, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 1L, 1.0), map1);

        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1L, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0L, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 1L, 1.0), map2);

        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32L, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(32L, 32.0), map3);

        MutableLongDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33L, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33L, functionThrows), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 33.0), map4);
    }

    @Test
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableLongDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0, 1L, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0, 1L, 2.0), map1);

        MutableLongDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 1.0, 1L, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 2.0, 1L, 2.0), map2);

        MutableLongDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33L, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(33L, 2.0), map3);
    }

    @Test
    public void freeze()
    {
        MutableLongDoubleMap mutableLongDoubleMap = this.classUnderTest();
        LongSet frozenSet = mutableLongDoubleMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableLongDoubleMap.put((long) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        LongSet frozenSetForRemove = mutableLongDoubleMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableLongDoubleMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableLongDoubleMap mutableLongDoubleMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongDoubleMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongDoubleMapForClear.keySet().toArray());
        mutableLongDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableLongDoubleMap map = this.newWithKeysValues(0L, 0.0, 1L, 1.0, 31L, 31.0, 32L, 32.0);
        MutableLongDoubleMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 1L, 1.0, 31L, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableLongDoubleMap map = this.newWithKeysValues(0L, 0.0, 1L, 1.0, 31L, 31.0, 32L, 32.0);
        MutableLongDoubleMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0, 31L, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableLongDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, 1.0), hashMap);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(1L, 1.0), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedLongDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableLongDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove()
    {
        MutableLongDoubleMap mutableMap = this.classUnderTest();
        MutableDoubleIterator iterator = mutableMap.doubleIterator();

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
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableLongDoubleMap map = this.newWithKeysValues(1L, 2.0, 2L, 3.0, 3L, 4.0, 4L, 5.0);
        Assert.assertEquals(
                DoubleLongHashMap.newWithKeysValues(2.0, 1L, 3.0, 2L, 4.0, 3L, 5.0, 4L),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1L, 1.0, 2L, 1.0).flipUniqueValues());
    }
}
