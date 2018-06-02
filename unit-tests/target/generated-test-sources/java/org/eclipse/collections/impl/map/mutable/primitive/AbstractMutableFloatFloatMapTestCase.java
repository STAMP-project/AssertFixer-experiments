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

import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatFloatMapTestCase extends AbstractFloatFloatMapTestCase
{
    @Override
    protected abstract MutableFloatFloatMap classUnderTest();

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1);

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2);

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3);

    @Override
    protected abstract MutableFloatFloatMap newWithKeysValues(float key1, float value1, float key2, float value2, float key3, float value3, float key4, float value4);

    @Override
    protected abstract MutableFloatFloatMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.get(0.0f), 0.0);

        map1.put(0.0f, 0.0f);
        Assert.assertEquals(0.0f, map1.get(0.0f), 0.0);

        map1.put(5.0f, 5.0f);
        Assert.assertEquals(5.0f, map1.get(5.0f), 0.0);

        map1.put(35.0f, 35.0f);
        Assert.assertEquals(35.0f, map1.get(35.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(0.0f), 0.0);

        map1.put(1.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow(1.0f), 0.0);

        map1.put(5.0f, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow(5.0f), 0.0);

        map1.put(35.0f, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow(35.0f), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(0.0f, 5.0f), 0.0);

        Assert.assertEquals(6.0f, map1.getIfAbsent(1.0f, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent(33.0f, 6.0f), 0.0);

        map1.put(0.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(0.0f, 5.0f), 0.0);

        map1.put(1.0f, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent(1.0f, 5.0f), 0.0);

        map1.put(5.0f, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent(5.0f, 6.0f), 0.0);

        map1.put(35.0f, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent(35.0f, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0f, map1.get(0.0f), 0.0);
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0f, map1.get(0.0f), 0.0);

        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0.0f, map1.get(1.0f), 0.0);

        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0.0f, map1.get(31.0f), 0.0);

        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0.0f, map1.get(32.0f), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableFloatFloatMap map1 = this.classUnderTest();

        map1.put(35.0f, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableFloatFloatMap map1 = this.classUnderTest();

        map1.put(35.0f, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableFloatFloatMap hashMap1 = this.newWithKeysValues(1.0f, 1.0f, 0.0f, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());

        MutableFloatFloatMap hashMap = this.newWithKeysValues(6.0f, 6.0f, 5.0f, 5.0f);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions()
    {
        FloatArrayList collisions = new FloatArrayList();
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
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
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatFloatHashMap(), map1);

        map1.put(1.0f, 0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new FloatFloatHashMap(), map1);

        map1.put(33.0f, 0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new FloatFloatHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableFloatFloatMap map0 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map0);

        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map1);

        MutableFloatFloatMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableFloatFloatMap map0 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map0.remove(1.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map0);

        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        map1.remove(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map1);

        MutableFloatFloatMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(31.0f, 31.0f, 32.0f, 32.0f), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableFloatFloatMap map0 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent(0.0f, 100.0f), 0.0);

        MutableFloatFloatMap map1 = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent(1.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent(1.0f, 100.0f), 0.0);

        MutableFloatFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(5.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(50.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 31.0f, 31.0f, 32.0f, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(31.0f, 31.0f, 32.0f, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent(31.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent(32.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(0.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(31.0f, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent(32.0f, 100.0f), 0.0);
        Assert.assertEquals(new FloatFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0f);
        map1.put(31.0f, 32.0f);
        map1.put(32.0f, 33.0f);
        FloatFloatHashMap expected = FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f, 31.0f, 32.0f, 32.0f, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.put(1.0f, 2.0f);
        expected.put(1.0f, 2.0f);
        Assert.assertEquals(expected, map1);

        map1.put(33.0f, 34.0f);
        expected.put(33.0f, 34.0f);
        Assert.assertEquals(expected, map1);

        map1.put(30.0f, 31.0f);
        expected.put(30.0f, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableFloatFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1.0f));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32.0f));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33.0f));
        FloatFloatHashMap expected = FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f, 31.0f, 32.0f, 32.0f, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0f, 2.0f));
        expected.put(1.0f, 2.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0f, 34.0f));
        expected.put(33.0f, 34.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0f, 31.0f));
        expected.put(30.0f, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31.0f, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0f), 0.0);
        FloatFloatHashMap expected = FloatFloatHashMap.newWithKeysValues(0.0f, 11.0f, 1.0f, 12.0f, 31.0f, 37.0f, 32.0f, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5.0, map1.addToValue(31.0f, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);

        MutableFloatFloatMap map2 = this.getEmptyMap();
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
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        FloatFloatHashMap hashMap = new FloatFloatHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((float) i), 0.0);
            hashMap.put((float) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((float) i), 0.0);
            hashMap.remove((float) i);
            Assert.assertEquals(0.0f, hashMap.get((float) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatFloatMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatFloatMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatFloatMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatFloatMapTestCase.generateCollisions().get(3);

        MutableFloatFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);

        MutableFloatFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);

        MutableFloatFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 50.0f, 1.0f, 50.0f), map1);

        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 50.0f, 1.0f, 50.0f), map2);

        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 50.0f), map3);

        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 100.0f), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 100.0f, 1.0f, 100.0f), map1);

        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 100.0f, 1.0f, 100.0f), map2);

        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 100.0f), map3);

        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 9.0f, 1.0f, 9.0f), map1);

        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 9.0f, 1.0f, 9.0f), map2);

        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 9.0f), map3);

        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToFloatFunction function = (float floatParameter) -> (float) floatParameter;
        FloatToFloatFunction functionThrows = (float floatParameter) -> { throw new AssertionError(); };

        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f), map1);

        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f), map2);

        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(32.0f, 32.0f), map3);

        MutableFloatFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 33.0f), map4);
    }

    @Test
    public void updateValue()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableFloatFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f, 1.0f, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f, 1.0f, 2.0f), map1);

        MutableFloatFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(1.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 1.0f, 1.0f, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue(0.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 2.0f, 1.0f, 2.0f), map2);

        MutableFloatFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue(33.0f, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(33.0f, 2.0f), map3);
    }

    @Test
    public void freeze()
    {
        MutableFloatFloatMap mutableFloatFloatMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatFloatMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatFloatMap.put((float) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        FloatSet frozenSetForRemove = mutableFloatFloatMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatFloatMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableFloatFloatMap mutableFloatFloatMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatFloatMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatFloatMapForClear.keySet().toArray());
        mutableFloatFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableFloatFloatMap map = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 31.0f, 31.0f, 32.0f, 32.0f);
        MutableFloatFloatMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 31.0f, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableFloatFloatMap map = this.newWithKeysValues(0.0f, 0.0f, 1.0f, 1.0f, 31.0f, 31.0f, 32.0f, 32.0f);
        MutableFloatFloatMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f, 31.0f, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableFloatFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1.0f), hashMap);
        Assert.assertEquals(FloatFloatHashMap.newWithKeysValues(1.0f, 1.0f), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedFloatFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableFloatFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove()
    {
        MutableFloatFloatMap mutableMap = this.classUnderTest();
        MutableFloatIterator iterator = mutableMap.floatIterator();

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
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableFloatFloatMap map = this.newWithKeysValues(1.0f, 2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f, 5.0f);
        Assert.assertEquals(
                FloatFloatHashMap.newWithKeysValues(2.0f, 1.0f, 3.0f, 2.0f, 4.0f, 3.0f, 5.0f, 4.0f),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0f, 1.0f, 2.0f, 1.0f).flipUniqueValues());
    }
}
