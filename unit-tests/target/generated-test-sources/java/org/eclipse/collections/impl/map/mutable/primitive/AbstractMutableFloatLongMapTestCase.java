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

import org.eclipse.collections.api.block.function.primitive.FloatToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatLongMapTestCase extends AbstractFloatLongMapTestCase
{
    @Override
    protected abstract MutableFloatLongMap classUnderTest();

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1);

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2);

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3);

    @Override
    protected abstract MutableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4);

    @Override
    protected abstract MutableFloatLongMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.put(0.0f, 1L);
        Assert.assertEquals(1L, map1.get(0.0f));

        map1.put(0.0f, 0L);
        Assert.assertEquals(0L, map1.get(0.0f));

        map1.put(5.0f, 5L);
        Assert.assertEquals(5L, map1.get(5.0f));

        map1.put(35.0f, 35L);
        Assert.assertEquals(35L, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0.0f));

        map1.put(1.0f, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1.0f));

        map1.put(5.0f, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5.0f));

        map1.put(35.0f, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5L, map1.getIfAbsent(0.0f, 5L));

        Assert.assertEquals(6L, map1.getIfAbsent(1.0f, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33.0f, 6L));

        map1.put(0.0f, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0.0f, 5L));

        map1.put(1.0f, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1.0f, 5L));

        map1.put(5.0f, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5.0f, 6L));

        map1.put(35.0f, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35.0f, 5L));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0L, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0L, map1.get(0.0f));

        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0L, map1.get(1.0f));

        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0L, map1.get(31.0f));

        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0L, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableFloatLongMap map1 = this.classUnderTest();

        map1.put(35.0f, 35L);
        Assert.assertTrue(map1.containsValue(35L));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableFloatLongMap map1 = this.classUnderTest();

        map1.put(35.0f, 35L);
        Assert.assertTrue(map1.contains(35L));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableFloatLongMap hashMap1 = this.newWithKeysValues(1.0f, 1L, 0.0f, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());

        MutableFloatLongMap hashMap = this.newWithKeysValues(6.0f, 6L, 5.0f, 5L);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions()
    {
        FloatArrayList collisions = new FloatArrayList();
        FloatLongHashMap hashMap = new FloatLongHashMap();
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
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatLongHashMap(), map1);

        map1.put(1.0f, 0L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 0L), map1);
        map1.clear();
        Assert.assertEquals(new FloatLongHashMap(), map1);

        map1.put(33.0f, 0L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 0L), map1);
        map1.clear();
        Assert.assertEquals(new FloatLongHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableFloatLongMap map0 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatLongHashMap(), map0);

        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatLongHashMap(), map1);

        MutableFloatLongMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(31.0f, 31L, 32.0f, 32L), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableFloatLongMap map0 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map0.remove(1.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatLongHashMap(), map0);

        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        map1.remove(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatLongHashMap(), map1);

        MutableFloatLongMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(31.0f, 31L, 32.0f, 32L), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableFloatLongMap map0 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1.0f, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0.0f, 100L));

        MutableFloatLongMap map1 = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1.0f, 100L));

        MutableFloatLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5.0f, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(31.0f, 31L, 32.0f, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0.0f, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31.0f, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32.0f, 100L));
        Assert.assertEquals(new FloatLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.put(0.0f, 1L);
        map1.put(31.0f, 32L);
        map1.put(32.0f, 33L);
        FloatLongHashMap expected = FloatLongHashMap.newWithKeysValues(0.0f, 1L, 31.0f, 32L, 32.0f, 33L);
        Assert.assertEquals(expected, map1);

        map1.put(1.0f, 2L);
        expected.put(1.0f, 2L);
        Assert.assertEquals(expected, map1);

        map1.put(33.0f, 34L);
        expected.put(33.0f, 34L);
        Assert.assertEquals(expected, map1);

        map1.put(30.0f, 31L);
        expected.put(30.0f, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableFloatLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1L));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32L));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33L));
        FloatLongHashMap expected = FloatLongHashMap.newWithKeysValues(0.0f, 1L, 31.0f, 32L, 32.0f, 33L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0f, 2L));
        expected.put(1.0f, 2L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0f, 34L));
        expected.put(33.0f, 34L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0f, 31L));
        expected.put(30.0f, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, 1L));
        Assert.assertEquals(32L, map1.addToValue(31.0f, 32L));
        Assert.assertEquals(3L, map1.addToValue(1.0f, 3L));
        Assert.assertEquals(11L, map1.addToValue(0.0f, 10L));
        Assert.assertEquals(12L, map1.addToValue(1.0f, 9L));
        Assert.assertEquals(37L, map1.addToValue(31.0f, 5L));
        Assert.assertEquals(33L, map1.addToValue(32.0f, 33L));
        FloatLongHashMap expected = FloatLongHashMap.newWithKeysValues(0.0f, 11L, 1.0f, 12L, 31.0f, 37L, 32.0f, 33L);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, 5L));
        Assert.assertEquals(37L, map1.addToValue(31.0f, 32L));
        Assert.assertEquals(33L, map1.addToValue(32.0f, 33L));
        Assert.assertEquals(3L, map1.addToValue(1.0f, 3L));
        Assert.assertEquals(1L, map1.addToValue(0.0f, 1L));
        Assert.assertEquals(12L, map1.addToValue(1.0f, 9L));
        Assert.assertEquals(11L, map1.addToValue(0.0f, 10L));
        Assert.assertEquals(expected, map1);

        MutableFloatLongMap map2 = this.getEmptyMap();
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
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        FloatLongHashMap hashMap = new FloatLongHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((float) i));
            hashMap.put((float) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals(0L, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatLongMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatLongMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatLongMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatLongMapTestCase.generateCollisions().get(3);

        MutableFloatLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);

        MutableFloatLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);

        MutableFloatLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 50L, 1.0f, 50L), map1);

        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 50L, 1.0f, 50L), map2);

        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 50L), map3);

        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, 100L));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 100L, 1.0f, 100L), map1);

        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 100L, 1.0f, 100L), map2);

        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 100L), map3);

        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 9L, 1.0f, 9L), map1);

        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 9L, 1.0f, 9L), map2);

        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 9L), map3);

        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToLongFunction function = (float floatParameter) -> (long) floatParameter;
        FloatToLongFunction functionThrows = (float floatParameter) -> { throw new AssertionError(); };

        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 1.0f, 1L), map1);

        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 1.0f, 1L), map2);

        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(32.0f, 32L), map3);

        MutableFloatLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 33L), map4);
    }

    @Test
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableFloatLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L, 1.0f, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L, 1.0f, 2L), map1);

        MutableFloatLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 1L, 1.0f, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 2L, 1.0f, 2L), map2);

        MutableFloatLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, 0L, incrementFunction));
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(33.0f, 2L), map3);
    }

    @Test
    public void freeze()
    {
        MutableFloatLongMap mutableFloatLongMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatLongMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatLongMap.put((float) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        FloatSet frozenSetForRemove = mutableFloatLongMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatLongMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableFloatLongMap mutableFloatLongMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatLongMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatLongMapForClear.keySet().toArray());
        mutableFloatLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableFloatLongMap map = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 31.0f, 31L, 32.0f, 32L);
        MutableFloatLongMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 31.0f, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableFloatLongMap map = this.newWithKeysValues(0.0f, 0L, 1.0f, 1L, 31.0f, 31L, 32.0f, 32L);
        MutableFloatLongMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L, 31.0f, 31L), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableFloatLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1L), hashMap);
        Assert.assertEquals(FloatLongHashMap.newWithKeysValues(1.0f, 1L), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedFloatLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableFloatLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove()
    {
        MutableFloatLongMap mutableMap = this.classUnderTest();
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
        MutableFloatLongMap map = this.newWithKeysValues(1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f, 5L);
        Assert.assertEquals(
                LongFloatHashMap.newWithKeysValues(2L, 1.0f, 3L, 2.0f, 4L, 3.0f, 5L, 4.0f),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0f, 1L, 2.0f, 1L).flipUniqueValues());
    }
}
