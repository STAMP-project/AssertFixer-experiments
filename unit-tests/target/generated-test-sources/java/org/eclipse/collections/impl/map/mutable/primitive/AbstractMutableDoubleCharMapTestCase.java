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

import org.eclipse.collections.api.block.function.primitive.DoubleToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableDoubleCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableDoubleCharMapTestCase extends AbstractDoubleCharMapTestCase
{
    @Override
    protected abstract MutableDoubleCharMap classUnderTest();

    @Override
    protected abstract MutableDoubleCharMap newWithKeysValues(double key1, char value1);

    @Override
    protected abstract MutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2);

    @Override
    protected abstract MutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3);

    @Override
    protected abstract MutableDoubleCharMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3, double key4, char value4);

    @Override
    protected abstract MutableDoubleCharMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.put(0.0, (char) 1);
        Assert.assertEquals((char) 1, map1.get(0.0));

        map1.put(0.0, (char) 0);
        Assert.assertEquals((char) 0, map1.get(0.0));

        map1.put(5.0, (char) 5);
        Assert.assertEquals((char) 5, map1.get(5.0));

        map1.put(35.0, (char) 35);
        Assert.assertEquals((char) 35, map1.get(35.0));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0));
        map1.put(0.0, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(0.0));

        map1.put(1.0, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(1.0));

        map1.put(5.0, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow(5.0));

        map1.put(35.0, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow(35.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertEquals((char) 5, map1.getIfAbsent(0.0, (char) 5));

        Assert.assertEquals((char) 6, map1.getIfAbsent(1.0, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent(33.0, (char) 6));

        map1.put(0.0, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(0.0, (char) 5));

        map1.put(1.0, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(1.0, (char) 5));

        map1.put(5.0, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent(5.0, (char) 6));

        map1.put(35.0, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent(35.0, (char) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((char) 0, map1.get(0.0));
        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsKey(0.0));
        Assert.assertEquals((char) 0, map1.get(0.0));

        map1.removeKey(1.0);
        Assert.assertFalse(map1.containsKey(1.0));
        Assert.assertEquals((char) 0, map1.get(1.0));

        map1.removeKey(31.0);
        Assert.assertFalse(map1.containsKey(31.0));
        Assert.assertEquals((char) 0, map1.get(31.0));

        map1.removeKey(32.0);
        Assert.assertFalse(map1.containsKey(32.0));
        Assert.assertEquals((char) 0, map1.get(32.0));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableDoubleCharMap map1 = this.classUnderTest();

        map1.put(35.0, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableDoubleCharMap map1 = this.classUnderTest();

        map1.put(35.0, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));

        map1.removeKey(0.0);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableDoubleCharMap hashMap1 = this.newWithKeysValues(1.0, (char) 1, 0.0, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0);
        Assert.assertEquals(0, hashMap1.size());

        MutableDoubleCharMap hashMap = this.newWithKeysValues(6.0, (char) 6, 5.0, (char) 5);
        hashMap.removeKey(5.0);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static DoubleArrayList generateCollisions()
    {
        DoubleArrayList collisions = new DoubleArrayList();
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
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
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new DoubleCharHashMap(), map1);

        map1.put(1.0, (char) 0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleCharHashMap(), map1);

        map1.put(33.0, (char) 0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new DoubleCharHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableDoubleCharMap map0 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
        map0.removeKey(1.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0), map0);
        map0.removeKey(0.0);
        Assert.assertEquals(new DoubleCharHashMap(), map0);

        MutableDoubleCharMap map1 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
        map1.removeKey(0.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1), map1);
        map1.removeKey(1.0);
        Assert.assertEquals(new DoubleCharHashMap(), map1);

        MutableDoubleCharMap map2 = this.classUnderTest();
        map2.removeKey(5.0);
        map2.removeKey(50.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32), map2);
        map2.removeKey(0.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(31.0, (char) 31, 32.0, (char) 32), map2);
        map2.removeKey(31.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 32), map2);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleCharHashMap(), map2);
        map2.removeKey(0.0);
        map2.removeKey(31.0);
        map2.removeKey(32.0);
        Assert.assertEquals(new DoubleCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableDoubleCharMap map0 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
        map0.remove(1.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0), map0);
        map0.remove(0.0);
        Assert.assertEquals(new DoubleCharHashMap(), map0);

        MutableDoubleCharMap map1 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
        map1.remove(0.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1), map1);
        map1.remove(1.0);
        Assert.assertEquals(new DoubleCharHashMap(), map1);

        MutableDoubleCharMap map2 = this.classUnderTest();
        map2.remove(5.0);
        map2.remove(50.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32), map2);
        map2.remove(0.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(31.0, (char) 31, 32.0, (char) 32), map2);
        map2.remove(31.0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 32), map2);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleCharHashMap(), map2);
        map2.remove(0.0);
        map2.remove(31.0);
        map2.remove(32.0);
        Assert.assertEquals(new DoubleCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableDoubleCharMap map0 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent(1.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent(0.0, (char) 100));
        Assert.assertEquals(new DoubleCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(1.0, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(0.0, (char) 100));

        MutableDoubleCharMap map1 = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent(0.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent(1.0, (char) 100));
        Assert.assertEquals(new DoubleCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(0.0, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(1.0, (char) 100));

        MutableDoubleCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(5.0, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(50.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent(0.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(31.0, (char) 31, 32.0, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent(31.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent(32.0, (char) 100));
        Assert.assertEquals(new DoubleCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(0.0, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(31.0, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(32.0, (char) 100));
        Assert.assertEquals(new DoubleCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.put(0.0, (char) 1);
        map1.put(31.0, (char) 32);
        map1.put(32.0, (char) 33);
        DoubleCharHashMap expected = DoubleCharHashMap.newWithKeysValues(0.0, (char) 1, 31.0, (char) 32, 32.0, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.put(1.0, (char) 2);
        expected.put(1.0, (char) 2);
        Assert.assertEquals(expected, map1);

        map1.put(33.0, (char) 34);
        expected.put(33.0, (char) 34);
        Assert.assertEquals(expected, map1);

        map1.put(30.0, (char) 31);
        expected.put(30.0, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableDoubleCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0, (char) 1));
        map1.putPair(PrimitiveTuples.pair(31.0, (char) 32));
        map1.putPair(PrimitiveTuples.pair(32.0, (char) 33));
        DoubleCharHashMap expected = DoubleCharHashMap.newWithKeysValues(0.0, (char) 1, 31.0, (char) 32, 32.0, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0, (char) 2));
        expected.put(1.0, (char) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0, (char) 34));
        expected.put(33.0, (char) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0, (char) 31));
        expected.put(30.0, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableDoubleCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0, (char) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0, (char) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0, (char) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0, (char) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0, (char) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0, (char) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0, (char) 33));
        DoubleCharHashMap expected = DoubleCharHashMap.newWithKeysValues(0.0, (char) 11, 1.0, (char) 12, 31.0, (char) 37, 32.0, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0);
        map1.removeKey(1.0);
        map1.removeKey(31.0);
        map1.removeKey(32.0);
        Assert.assertEquals(5L, map1.addToValue(31.0, (char) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0, (char) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0, (char) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0, (char) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0, (char) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0, (char) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0, (char) 10));
        Assert.assertEquals(expected, map1);

        MutableDoubleCharMap map2 = this.getEmptyMap();
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
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((double) i));
            hashMap.put((double) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((double) i));
            hashMap.remove((double) i);
            Assert.assertEquals((char) 0, hashMap.get((double) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        double collision1 = AbstractMutableDoubleCharMapTestCase.generateCollisions().getFirst();
        double collision2 = AbstractMutableDoubleCharMapTestCase.generateCollisions().get(1);
        double collision3 = AbstractMutableDoubleCharMapTestCase.generateCollisions().get(2);
        double collision4 = AbstractMutableDoubleCharMapTestCase.generateCollisions().get(3);

        MutableDoubleCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);

        MutableDoubleCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);

        MutableDoubleCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableDoubleCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 50, 1.0, (char) 50), map1);

        MutableDoubleCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 50, 1.0, (char) 50), map2);

        MutableDoubleCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 50), map3);

        MutableDoubleCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0, (char) 100));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableDoubleCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 100, 1.0, (char) 100), map1);

        MutableDoubleCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0, factoryThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0, factoryThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 100, 1.0, (char) 100), map2);

        MutableDoubleCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0, factoryThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 100), map3);

        MutableDoubleCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0, factoryThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableDoubleCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 9, 1.0, (char) 9), map1);

        MutableDoubleCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1.0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0.0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 9, 1.0, (char) 9), map2);

        MutableDoubleCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32.0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 9), map3);

        MutableDoubleCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33.0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33.0, functionThrows, "unused"));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToCharFunction function = (double doubleParameter) -> (char) doubleParameter;
        DoubleToCharFunction functionThrows = (double doubleParameter) -> { throw new AssertionError(); };

        MutableDoubleCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1), map1);

        MutableDoubleCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0, functionThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0, functionThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1), map2);

        MutableDoubleCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0, functionThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(32.0, (char) 32), map3);

        MutableDoubleCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0, functionThrows));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 33), map4);
    }

    @Test
    public void updateValue()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableDoubleCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 2, 1.0, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 2, 1.0, (char) 2), map1);

        MutableDoubleCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 1, 1.0, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 2, 1.0, (char) 2), map2);

        MutableDoubleCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0, (char) 0, incrementFunction));
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(33.0, (char) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableDoubleCharMap mutableDoubleCharMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleCharMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableDoubleCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleCharMap.put((double) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        DoubleSet frozenSetForRemove = mutableDoubleCharMap.keySet().freeze();
        DoubleSet frozenSetCopyForRemove = DoubleHashSet.newSetWith(mutableDoubleCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableDoubleCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableDoubleCharMap.remove((double) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableDoubleCharMap mutableDoubleCharMapForClear = this.classUnderTest();
        DoubleSet frozenSetForClear = mutableDoubleCharMapForClear.keySet().freeze();
        DoubleSet frozenSetCopyForClear = DoubleHashSet.newSetWith(mutableDoubleCharMapForClear.keySet().toArray());
        mutableDoubleCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableDoubleCharMap map = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 31.0, (char) 31, 32.0, (char) 32);
        MutableDoubleCharMap mapWithout = map.withoutKey(32.0);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 31.0, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableDoubleCharMap map = this.newWithKeysValues(0.0, (char) 0, 1.0, (char) 1, 31.0, (char) 31, 32.0, (char) 32);
        MutableDoubleCharMap mapWithout = map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1, 31.0, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableDoubleCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0, (char) 1), hashMap);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedDoubleCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedDoubleCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableDoubleCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableDoubleCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove()
    {
        MutableDoubleCharMap mutableMap = this.classUnderTest();
        MutableCharIterator iterator = mutableMap.charIterator();

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
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableCharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableDoubleCharMap map = this.newWithKeysValues(1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0, (char) 5);
        Assert.assertEquals(
                CharDoubleHashMap.newWithKeysValues((char) 2, 1.0, (char) 3, 2.0, (char) 4, 3.0, (char) 5, 4.0),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0, (char) 1, 2.0, (char) 1).flipUniqueValues());
    }
}
