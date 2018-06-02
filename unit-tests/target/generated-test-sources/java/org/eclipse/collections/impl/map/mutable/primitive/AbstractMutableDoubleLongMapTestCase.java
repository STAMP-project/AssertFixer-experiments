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

import org.eclipse.collections.api.block.function.primitive.DoubleToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleLongMapTestCase extends AbstractDoubleLongMapTestCase
{
    @Override
    protected abstract MutableDoubleLongMap classUnderTest();

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1);

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2);

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3);

    @Override
    protected abstract MutableDoubleLongMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3, double key4, long value4);

    @Override
    protected abstract MutableDoubleLongMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.put(0.0, 1L);
        Assert.assertEquals(1L, map1.get(0.0));

        map1.put(0.0, 0L);
        Assert.assertEquals(0L, map1.get(0.0));

        map1.put(5.0, 5L);
        Assert.assertEquals(5L, map1.get(5.0));

        map1.put(35.0, 35L);
        Assert.assertEquals(35L, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0.0));

        map1.put(1.0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1.0));

        map1.put(5.0, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5.0));

        map1.put(35.0, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals(5L, map1.getIfAbsent(0.0, 5L));

        Assert.assertEquals(6L, map1.getIfAbsent(1.0, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33.0, 6L));

        map1.put(0.0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0.0, 5L));

        map1.put(1.0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1.0, 5L));

        map1.put(5.0, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5.0, 6L));

        map1.put(35.0, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35.0, 5L));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0L, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0L, map1.get(0.0));

        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals(0L, map1.get(1.0));

        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals(0L, map1.get(31.0));

        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals(0L, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableDoubleLongMap map1 = this.classUnderTest();

        map1.put(35.0, 35L);
        Assert.assertTrue(map1.containsValue(35L));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableDoubleLongMap map1 = this.classUnderTest();

        map1.put(35.0, 35L);
        Assert.assertTrue(map1.contains(35L));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableDoubleLongMap hashMap1 = this.newWithKeysValues(1.0, 1L, 0.0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());

        MutableDoubleLongMap hashMap = this.newWithKeysValues(6.0, 6L, 5.0, 5L);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
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
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleLongHashMap(), map1);

        map1.put(1.0, 0L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 0L), map1);
        map1.clear();
        Assert.assertEquals(new DoubleLongHashMap(), map1);

        map1.put(33.0, 0L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 0L), map1);
        map1.clear();
        Assert.assertEquals(new DoubleLongHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableDoubleLongMap map0 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleLongHashMap(), map0);

        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleLongHashMap(), map1);

        MutableDoubleLongMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(31.0, 31L, 32.0, 32L), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableDoubleLongMap map0 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map0.remove(1.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleLongHashMap(), map0);

        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        map1.remove(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleLongHashMap(), map1);

        MutableDoubleLongMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(31.0, 31L, 32.0, 32L), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableDoubleLongMap map0 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1.0, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0.0, 100L));

        MutableDoubleLongMap map1 = this.newWithKeysValues(0.0, 0L, 1.0, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1.0, 100L));

        MutableDoubleLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5.0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(31.0, 31L, 32.0, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0.0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31.0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32.0, 100L));
        Assert.assertEquals(new DoubleLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.put(0.0, 1L);
        map1.put(31.0, 32L);
        map1.put(32.0, 33L);
        DoubleLongHashMap expected = DoubleLongHashMap.newWithKeysValues(0.0, 1L, 31.0, 32L, 32.0, 33L);
        Assert.assertEquals(expected, map1);

        map1.put(1.0, 2L);
        expected.put(1.0, 2L);
        Assert.assertEquals(expected, map1);

        map1.put(33.0, 34L);
        expected.put(33.0, 34L);
        Assert.assertEquals(expected, map1);

        map1.put(30.0, 31L);
        expected.put(30.0, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableDoubleLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, 1L));
        map1.putPair(PrimitiveTuples.pair(31.0, 32L));
        map1.putPair(PrimitiveTuples.pair(32.0, 33L));
        DoubleLongHashMap expected = DoubleLongHashMap.newWithKeysValues(0.0, 1L, 31.0, 32L, 32.0, 33L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0, 2L));
        expected.put(1.0, 2L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0, 34L));
        expected.put(33.0, 34L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0, 31L));
        expected.put(30.0, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, 1L));
        Assert.assertEquals(32L, map1.addToValue(31.0, 32L));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3L));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10L));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9L));
        Assert.assertEquals(37L, map1.addToValue(31.0, 5L));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33L));
        DoubleLongHashMap expected = DoubleLongHashMap.newWithKeysValues(0.0, 11L, 1.0, 12L, 31.0, 37L, 32.0, 33L);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, 5L));
        Assert.assertEquals(37L, map1.addToValue(31.0, 32L));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33L));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3L));
        Assert.assertEquals(1L, map1.addToValue(0.0, 1L));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9L));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10L));
        Assert.assertEquals(expected, map1);

        MutableDoubleLongMap map2 = this.getEmptyMap();
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
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((double) i));
            hashMap.put((double) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals(0L, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        double collision1 = AbstractMutableDoubleLongMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleLongMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleLongMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleLongMapTestCase.generateCollisions().get(3);

        MutableDoubleLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);

        MutableDoubleLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);

        MutableDoubleLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 50L, 1.0, 50L), map1);

        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 50L, 1.0, 50L), map2);

        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 50L), map3);

        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 100L));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 100L, 1.0, 100L), map1);

        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 100L, 1.0, 100L), map2);

        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 100L), map3);

        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 9L, 1.0, 9L), map1);

        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 9L, 1.0, 9L), map2);

        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 9L), map3);

        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToLongFunction function = (double doubleParameter) -> (long) doubleParameter;
        DoubleToLongFunction functionThrows = (double doubleParameter) -> { throw new AssertionError(); };

        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 1.0, 1L), map1);

        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 1.0, 1L), map2);

        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(32.0, 32L), map3);

        MutableDoubleLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 33L), map4);
    }

    @Test
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableDoubleLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L, 1.0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L, 1.0, 2L), map1);

        MutableDoubleLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 1L, 1.0, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 2L, 1.0, 2L), map2);

        MutableDoubleLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, 0L, incrementFunction));
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(33.0, 2L), map3);
    }

    @Test
    public void freeze()
    {
        MutableDoubleLongMap mutableDoubleLongMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleLongMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleLongMap.put((double) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        DoubleSet frozenSetForRemove = mutableDoubleLongMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleLongMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableDoubleLongMap mutableDoubleLongMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleLongMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleLongMapForClear.keySet().toArray());
        mutableDoubleLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableDoubleLongMap map = this.newWithKeysValues(0.0, 0L, 1.0, 1L, 31.0, 31L, 32.0, 32L);
        MutableDoubleLongMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(0.0, 0L, 1.0, 1L, 31.0, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableDoubleLongMap map = this.newWithKeysValues(0.0, 0L, 1.0, 1L, 31.0, 31L, 32.0, 32L);
        MutableDoubleLongMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 31.0, 31L), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableDoubleLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, 1L), hashMap);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedDoubleLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableDoubleLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove()
    {
        MutableDoubleLongMap mutableMap = this.classUnderTest();
        MutableLongIterator iterator = mutableMap.longIterator();

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
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableLongIterator iterator = this.classUnderTest().longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableDoubleLongMap map = this.newWithKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L);
        Assert.assertEquals(
                LongDoubleHashMap.newWithKeysValues(2L, 1.0, 3L, 2.0, 4L, 3.0, 5L, 4.0),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0, 1L, 2.0, 1L).flipUniqueValues());
    }
}
