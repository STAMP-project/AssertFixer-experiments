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

import org.eclipse.collections.api.block.function.primitive.IntToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntDoubleMapTestCase extends AbstractIntDoubleMapTestCase
{
    @Override
    protected abstract MutableIntDoubleMap classUnderTest();

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1);

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2);

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3);

    @Override
    protected abstract MutableIntDoubleMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3, int key4, double value4);

    @Override
    protected abstract MutableIntDoubleMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.put(0, 1.0);
        Assert.assertEquals(1.0, map1.get(0), 0.0);

        map1.put(0, 0.0);
        Assert.assertEquals(0.0, map1.get(0), 0.0);

        map1.put(5, 5.0);
        Assert.assertEquals(5.0, map1.get(5), 0.0);

        map1.put(35, 35.0);
        Assert.assertEquals(35.0, map1.get(35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(0), 0.0);

        map1.put(1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow(1), 0.0);

        map1.put(5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow(5), 0.0);

        map1.put(35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow(35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals(5.0, map1.getIfAbsent(0, 5.0), 0.0);

        Assert.assertEquals(6.0, map1.getIfAbsent(1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent(33, 6.0), 0.0);

        map1.put(0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(0, 5.0), 0.0);

        map1.put(1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent(1, 5.0), 0.0);

        map1.put(5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent(5, 6.0), 0.0);

        map1.put(35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent(35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0.0, map1.get(0), 0.0);
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0.0, map1.get(0), 0.0);

        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals(0.0, map1.get(1), 0.0);

        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals(0.0, map1.get(31), 0.0);

        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals(0.0, map1.get(32), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableIntDoubleMap map1 = this.classUnderTest();

        map1.put(35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));

        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableIntDoubleMap map1 = this.classUnderTest();

        map1.put(35, 35.0);
        Assert.assertTrue(map1.contains(35.0));

        map1.removeKey(0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableIntDoubleMap hashMap1 = this.newWithKeysValues(1, 1.0, 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());

        MutableIntDoubleMap hashMap = this.newWithKeysValues(6, 6.0, 5, 5.0);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions()
    {
        IntArrayList collisions = new IntArrayList();
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
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
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntDoubleHashMap(), map1);

        map1.put(1, 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new IntDoubleHashMap(), map1);

        map1.put(33, 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new IntDoubleHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableIntDoubleMap map0 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map0.removeKey(1);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntDoubleHashMap(), map0);

        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map1.removeKey(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntDoubleHashMap(), map1);

        MutableIntDoubleMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(31, 31.0, 32, 32.0), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableIntDoubleMap map0 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map0.remove(1);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map0);
        map0.remove(0);
        Assert.assertEquals(new IntDoubleHashMap(), map0);

        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        map1.remove(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map1);
        map1.remove(1);
        Assert.assertEquals(new IntDoubleHashMap(), map1);

        MutableIntDoubleMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0), map2);
        map2.remove(0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(31, 31.0, 32, 32.0), map2);
        map2.remove(31);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map2);
        map2.remove(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableIntDoubleMap map0 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent(1, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent(0, 100.0), 0.0);

        MutableIntDoubleMap map1 = this.newWithKeysValues(0, 0.0, 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent(1, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent(1, 100.0), 0.0);

        MutableIntDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(50, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(31, 31.0, 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent(31, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent(32, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent(32, 100.0), 0.0);
        Assert.assertEquals(new IntDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.put(0, 1.0);
        map1.put(31, 32.0);
        map1.put(32, 33.0);
        IntDoubleHashMap expected = IntDoubleHashMap.newWithKeysValues(0, 1.0, 31, 32.0, 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.put(1, 2.0);
        expected.put(1, 2.0);
        Assert.assertEquals(expected, map1);

        map1.put(33, 34.0);
        expected.put(33, 34.0);
        Assert.assertEquals(expected, map1);

        map1.put(30, 31.0);
        expected.put(30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableIntDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, 1.0));
        map1.putPair(PrimitiveTuples.pair(31, 32.0));
        map1.putPair(PrimitiveTuples.pair(32, 33.0));
        IntDoubleHashMap expected = IntDoubleHashMap.newWithKeysValues(0, 1.0, 31, 32.0, 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1, 2.0));
        expected.put(1, 2.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33, 34.0));
        expected.put(33, 34.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30, 31.0));
        expected.put(30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue(31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32, 33.0), 0.0);
        IntDoubleHashMap expected = IntDoubleHashMap.newWithKeysValues(0, 11.0, 1, 12.0, 31, 37.0, 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5.0, map1.addToValue(31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue(31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue(32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue(1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue(1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue(0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);

        MutableIntDoubleMap map2 = this.getEmptyMap();
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
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get(i), 0.0);
            hashMap.put(i, (double) i);
            Assert.assertEquals((double) i, hashMap.get(i), 0.0);
            hashMap.remove(i);
            Assert.assertEquals(0.0, hashMap.get(i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        int collision1 = AbstractMutableIntDoubleMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntDoubleMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntDoubleMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntDoubleMapTestCase.generateCollisions().get(3);

        MutableIntDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);

        MutableIntDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);

        MutableIntDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map1);

        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map2);

        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(32, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 50.0), map3);

        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut(33, 100.0), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map1);

        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map2);

        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(32, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 100.0), map3);

        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut(33, factoryThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map1);

        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map2);

        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 9.0), map3);

        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith(33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        IntToDoubleFunction function = (int intParameter) -> (double) intParameter;
        IntToDoubleFunction functionThrows = (int intParameter) -> { throw new AssertionError(); };

        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map1);

        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map2);

        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(32, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(32, 32.0), map3);

        MutableIntDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey(33, functionThrows), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 33.0), map4);
    }

    @Test
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableIntDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0, 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map1);

        MutableIntDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 1.0, 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map2);

        MutableIntDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(33, 2.0), map3);
    }

    @Test
    public void freeze()
    {
        MutableIntDoubleMap mutableIntDoubleMap = this.classUnderTest();
        IntSet frozenSet = mutableIntDoubleMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableIntDoubleMap.put((int) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        IntSet frozenSetForRemove = mutableIntDoubleMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableIntDoubleMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableIntDoubleMap mutableIntDoubleMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntDoubleMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntDoubleMapForClear.keySet().toArray());
        mutableIntDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableIntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 31, 31.0, 32, 32.0);
        MutableIntDoubleMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0, 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableIntDoubleMap map = this.newWithKeysValues(0, 0.0, 1, 1.0, 31, 31.0, 32, 32.0);
        MutableIntDoubleMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableIntDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, 1.0), hashMap);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedIntDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableIntDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove()
    {
        MutableIntDoubleMap mutableMap = this.classUnderTest();
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
        MutableIntDoubleMap map = this.newWithKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0);
        Assert.assertEquals(
                DoubleIntHashMap.newWithKeysValues(2.0, 1, 3.0, 2, 4.0, 3, 5.0, 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1, 1.0, 2, 1.0).flipUniqueValues());
    }
}
