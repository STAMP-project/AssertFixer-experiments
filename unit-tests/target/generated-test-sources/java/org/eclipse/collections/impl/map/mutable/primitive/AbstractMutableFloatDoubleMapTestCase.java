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

import org.eclipse.collections.api.block.function.primitive.FloatToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatDoubleMapTestCase extends AbstractFloatDoubleMapTestCase
{
    @Override
    protected abstract MutableFloatDoubleMap classUnderTest();

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1);

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2);

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3);

    @Override
    protected abstract MutableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4);

    @Override
    protected abstract MutableFloatDoubleMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0);
        Assert.assertEquals(1.0, map1.get(0.0f), 0.0);

        map1.put(0.0f, 0.0);
        Assert.assertEquals(0.0, map1.get(0.0f), 0.0);

        map1.put(5.0f, 5.0);
        Assert.assertEquals(5.0, map1.get(5.0f), 0.0);

        map1.put(35.0f, 35.0);
        Assert.assertEquals(35.0, map1.get(35.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0.0f), 0.0);

        map1.put(1.0f, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1.0f), 0.0);

        map1.put(5.0f, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5.0f), 0.0);

        map1.put(35.0f, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35.0f), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals(5.0, map1.getIfAbsent(0.0f, 5.0), 0.0);

        Assert.assertEquals(6.0, map1.getIfAbsent(1.0f, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33.0f, 6.0), 0.0);

        map1.put(0.0f, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0.0f, 5.0), 0.0);

        map1.put(1.0f, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1.0f, 5.0), 0.0);

        map1.put(5.0f, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5.0f, 6.0), 0.0);

        map1.put(35.0f, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35.0f, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0, map1.get(0.0f), 0.0);
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals(0.0, map1.get(0.0f), 0.0);

        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals(0.0, map1.get(1.0f), 0.0);

        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals(0.0, map1.get(31.0f), 0.0);

        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals(0.0, map1.get(32.0f), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableFloatDoubleMap map1 = this.classUnderTest();

        map1.put(35.0f, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableFloatDoubleMap map1 = this.classUnderTest();

        map1.put(35.0f, 35.0);
        Assert.assertTrue(map1.contains(35.0));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableFloatDoubleMap hashMap1 = this.newWithKeysValues(1.0f, 1.0, 0.0f, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());

        MutableFloatDoubleMap hashMap = this.newWithKeysValues(6.0f, 6.0, 5.0f, 5.0);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions()
    {
        FloatArrayList collisions = new FloatArrayList();
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
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
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatDoubleHashMap(), map1);

        map1.put(1.0f, 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new FloatDoubleHashMap(), map1);

        map1.put(33.0f, 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableFloatDoubleMap map0 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map0);

        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map1);

        MutableFloatDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(31.0f, 31.0, 32.0f, 32.0), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableFloatDoubleMap map0 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map0.remove(1.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map0);

        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        map1.remove(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map1);

        MutableFloatDoubleMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(31.0f, 31.0, 32.0f, 32.0), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableFloatDoubleMap map0 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0.0f, 100.0), 0.0);

        MutableFloatDoubleMap map1 = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1.0f, 100.0), 0.0);

        MutableFloatDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(31.0f, 31.0, 32.0f, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31.0f, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32.0f, 100.0), 0.0);
        Assert.assertEquals(new FloatDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.put(0.0f, 1.0);
        map1.put(31.0f, 32.0);
        map1.put(32.0f, 33.0);
        FloatDoubleHashMap expected = FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0, 31.0f, 32.0, 32.0f, 33.0);
        Assert.assertEquals(expected, map1);

        map1.put(1.0f, 2.0);
        expected.put(1.0f, 2.0);
        Assert.assertEquals(expected, map1);

        map1.put(33.0f, 34.0);
        expected.put(33.0f, 34.0);
        Assert.assertEquals(expected, map1);

        map1.put(30.0f, 31.0);
        expected.put(30.0f, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableFloatDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, 1.0));
        map1.putPair(PrimitiveTuples.pair(31.0f, 32.0));
        map1.putPair(PrimitiveTuples.pair(32.0f, 33.0));
        FloatDoubleHashMap expected = FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0, 31.0f, 32.0, 32.0f, 33.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0f, 2.0));
        expected.put(1.0f, 2.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0f, 34.0));
        expected.put(33.0f, 34.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0f, 31.0));
        expected.put(30.0f, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31.0f, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0), 0.0);
        FloatDoubleHashMap expected = FloatDoubleHashMap.newWithKeysValues(0.0f, 11.0, 1.0f, 12.0, 31.0f, 37.0, 32.0f, 33.0);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5.0, map1.addToValue(31.0f, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31.0f, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32.0f, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1.0f, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0.0f, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1.0f, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0.0f, 10.0), 0.0);
        Assert.assertEquals(expected, map1);

        MutableFloatDoubleMap map2 = this.getEmptyMap();
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
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((float) i), 0.0);
            hashMap.put((float) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((float) i), 0.0);
            hashMap.remove((float) i);
            Assert.assertEquals(0.0, hashMap.get((float) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().get(3);

        MutableFloatDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);

        MutableFloatDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);

        MutableFloatDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 50.0, 1.0f, 50.0), map1);

        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 50.0, 1.0f, 50.0), map2);

        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 50.0), map3);

        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33.0f, 100.0), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 100.0, 1.0f, 100.0), map1);

        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 100.0, 1.0f, 100.0), map2);

        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 100.0), map3);

        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33.0f, factoryThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 9.0, 1.0f, 9.0), map1);

        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 9.0, 1.0f, 9.0), map2);

        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 9.0), map3);

        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToDoubleFunction function = (float floatParameter) -> (double) floatParameter;
        FloatToDoubleFunction functionThrows = (float floatParameter) -> { throw new AssertionError(); };

        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0), map1);

        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0), map2);

        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(32.0f, 32.0), map3);

        MutableFloatDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33.0f, functionThrows), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 33.0), map4);
    }

    @Test
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableFloatDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0, 1.0f, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0, 1.0f, 2.0), map1);

        MutableFloatDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 1.0, 1.0f, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 2.0, 1.0f, 2.0), map2);

        MutableFloatDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33.0f, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(33.0f, 2.0), map3);
    }

    @Test
    public void freeze()
    {
        MutableFloatDoubleMap mutableFloatDoubleMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatDoubleMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatDoubleMap.put((float) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        FloatSet frozenSetForRemove = mutableFloatDoubleMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatDoubleMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableFloatDoubleMap mutableFloatDoubleMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatDoubleMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatDoubleMapForClear.keySet().toArray());
        mutableFloatDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableFloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 31.0f, 31.0, 32.0f, 32.0);
        MutableFloatDoubleMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 31.0f, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableFloatDoubleMap map = this.newWithKeysValues(0.0f, 0.0, 1.0f, 1.0, 31.0f, 31.0, 32.0f, 32.0);
        MutableFloatDoubleMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 31.0f, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableFloatDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, 1.0), hashMap);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedFloatDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableFloatDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove()
    {
        MutableFloatDoubleMap mutableMap = this.classUnderTest();
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
        MutableFloatDoubleMap map = this.newWithKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0);
        Assert.assertEquals(
                DoubleFloatHashMap.newWithKeysValues(2.0, 1.0f, 3.0, 2.0f, 4.0, 3.0f, 5.0, 4.0f),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0f, 1.0, 2.0f, 1.0).flipUniqueValues());
    }
}
