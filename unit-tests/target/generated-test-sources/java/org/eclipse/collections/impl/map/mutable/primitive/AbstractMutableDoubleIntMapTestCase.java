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

import org.eclipse.collections.api.block.function.primitive.DoubleToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleIntMapTestCase extends AbstractDoubleIntMapTestCase
{
    @Override
    protected abstract MutableDoubleIntMap classUnderTest();

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1);

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2);

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3);

    @Override
    protected abstract MutableDoubleIntMap newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3, double key4, int value4);

    @Override
    protected abstract MutableDoubleIntMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.put(0.0, 1);
        Assert.assertEquals(1, map1.get(0.0));

        map1.put(0.0, 0);
        Assert.assertEquals(0, map1.get(0.0));

        map1.put(5.0, 5);
        Assert.assertEquals(5, map1.get(5.0));

        map1.put(35.0, 35);
        Assert.assertEquals(35, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, 1);
        Assert.assertEquals(1, map1.getOrThrow(0.0));

        map1.put(1.0, 1);
        Assert.assertEquals(1, map1.getOrThrow(1.0));

        map1.put(5.0, 5);
        Assert.assertEquals(5, map1.getOrThrow(5.0));

        map1.put(35.0, 35);
        Assert.assertEquals(35, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals(5, map1.getIfAbsent(0.0, 5));

        Assert.assertEquals(6, map1.getIfAbsent(1.0, 6));
        Assert.assertEquals(6, map1.getIfAbsent(33.0, 6));

        map1.put(0.0, 1);
        Assert.assertEquals(1, map1.getIfAbsent(0.0, 5));

        map1.put(1.0, 1);
        Assert.assertEquals(1, map1.getIfAbsent(1.0, 5));

        map1.put(5.0, 5);
        Assert.assertEquals(5, map1.getIfAbsent(5.0, 6));

        map1.put(35.0, 35);
        Assert.assertEquals(35, map1.getIfAbsent(35.0, 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals(0, map1.get(0.0));

        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals(0, map1.get(1.0));

        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals(0, map1.get(31.0));

        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals(0, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableDoubleIntMap map1 = this.classUnderTest();

        map1.put(35.0, 35);
        Assert.assertTrue(map1.containsValue(35));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableDoubleIntMap map1 = this.classUnderTest();

        map1.put(35.0, 35);
        Assert.assertTrue(map1.contains(35));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableDoubleIntMap hashMap1 = this.newWithKeysValues(1.0, 1, 0.0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());

        MutableDoubleIntMap hashMap = this.newWithKeysValues(6.0, 6, 5.0, 5);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
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
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleIntHashMap(), map1);

        map1.put(1.0, 0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleIntHashMap(), map1);

        map1.put(33.0, 0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleIntHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableDoubleIntMap map0 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleIntHashMap(), map0);

        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleIntHashMap(), map1);

        MutableDoubleIntMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(31.0, 31, 32.0, 32), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableDoubleIntMap map0 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map0.remove(1.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleIntHashMap(), map0);

        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        map1.remove(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleIntHashMap(), map1);

        MutableDoubleIntMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(31.0, 31, 32.0, 32), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableDoubleIntMap map0 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent(1.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent(1.0, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent(0.0, 100));

        MutableDoubleIntMap map1 = this.newWithKeysValues(0.0, 0, 1.0, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent(1.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent(1.0, 100));

        MutableDoubleIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent(5.0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(50.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(31.0, 31, 32.0, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent(31.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent(32.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent(0.0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(31.0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(32.0, 100));
        Assert.assertEquals(new DoubleIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.put(0.0, 1);
        map1.put(31.0, 32);
        map1.put(32.0, 33);
        DoubleIntHashMap expected = DoubleIntHashMap.newWithKeysValues(0.0, 1, 31.0, 32, 32.0, 33);
        Assert.assertEquals(expected, map1);

        map1.put(1.0, 2);
        expected.put(1.0, 2);
        Assert.assertEquals(expected, map1);

        map1.put(33.0, 34);
        expected.put(33.0, 34);
        Assert.assertEquals(expected, map1);

        map1.put(30.0, 31);
        expected.put(30.0, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableDoubleIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, 1));
        map1.putPair(PrimitiveTuples.pair(31.0, 32));
        map1.putPair(PrimitiveTuples.pair(32.0, 33));
        DoubleIntHashMap expected = DoubleIntHashMap.newWithKeysValues(0.0, 1, 31.0, 32, 32.0, 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0, 2));
        expected.put(1.0, 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0, 34));
        expected.put(33.0, 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0, 31));
        expected.put(30.0, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, 1));
        Assert.assertEquals(32L, map1.addToValue(31.0, 32));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9));
        Assert.assertEquals(37L, map1.addToValue(31.0, 5));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33));
        DoubleIntHashMap expected = DoubleIntHashMap.newWithKeysValues(0.0, 11, 1.0, 12, 31.0, 37, 32.0, 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, 5));
        Assert.assertEquals(37L, map1.addToValue(31.0, 32));
        Assert.assertEquals(33L, map1.addToValue(32.0, 33));
        Assert.assertEquals(3L, map1.addToValue(1.0, 3));
        Assert.assertEquals(1L, map1.addToValue(0.0, 1));
        Assert.assertEquals(12L, map1.addToValue(1.0, 9));
        Assert.assertEquals(11L, map1.addToValue(0.0, 10));
        Assert.assertEquals(expected, map1);

        MutableDoubleIntMap map2 = this.getEmptyMap();
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
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        DoubleIntHashMap hashMap = new DoubleIntHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((double) i));
            hashMap.put((double) i, i);
            Assert.assertEquals(i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals(0, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        double collision1 = AbstractMutableDoubleIntMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleIntMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleIntMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleIntMapTestCase.generateCollisions().get(3);

        MutableDoubleIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);

        MutableDoubleIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);

        MutableDoubleIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 50, 1.0, 50), map1);

        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 50, 1.0, 50), map2);

        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 50), map3);

        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, 100));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 100, 1.0, 100), map1);

        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 100, 1.0, 100), map2);

        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 100), map3);

        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 9, 1.0, 9), map1);

        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 9, 1.0, 9), map2);

        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 9), map3);

        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToIntFunction function = (double doubleParameter) -> (int) doubleParameter;
        DoubleToIntFunction functionThrows = (double doubleParameter) -> { throw new AssertionError(); };

        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 1.0, 1), map1);

        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 1.0, 1), map2);

        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(32.0, 32), map3);

        MutableDoubleIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 33), map4);
    }

    @Test
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableDoubleIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2, 1.0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map1);

        MutableDoubleIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 1, 1.0, 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 2, 1.0, 2), map2);

        MutableDoubleIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, 0, incrementFunction));
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(33.0, 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableDoubleIntMap mutableDoubleIntMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleIntMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleIntMap.put((double) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        DoubleSet frozenSetForRemove = mutableDoubleIntMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleIntMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableDoubleIntMap mutableDoubleIntMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleIntMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleIntMapForClear.keySet().toArray());
        mutableDoubleIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableDoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 31.0, 31, 32.0, 32);
        MutableDoubleIntMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(0.0, 0, 1.0, 1, 31.0, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableDoubleIntMap map = this.newWithKeysValues(0.0, 0, 1.0, 1, 31.0, 31, 32.0, 32);
        MutableDoubleIntMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1, 31.0, 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableDoubleIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, 1), hashMap);
        Assert.assertEquals(DoubleIntHashMap.newWithKeysValues(1.0, 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedDoubleIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableDoubleIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove()
    {
        MutableDoubleIntMap mutableMap = this.classUnderTest();
        MutableIntIterator iterator = mutableMap.intIterator();

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
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableIntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableDoubleIntMap map = this.newWithKeysValues(1.0, 2, 2.0, 3, 3.0, 4, 4.0, 5);
        Assert.assertEquals(
                IntDoubleHashMap.newWithKeysValues(2, 1.0, 3, 2.0, 4, 3.0, 5, 4.0),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0, 1, 2.0, 1).flipUniqueValues());
    }
}
