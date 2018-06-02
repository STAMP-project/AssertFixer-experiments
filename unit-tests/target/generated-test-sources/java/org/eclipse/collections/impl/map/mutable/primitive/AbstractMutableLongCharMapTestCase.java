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

import org.eclipse.collections.api.block.function.primitive.LongToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongCharMapTestCase extends AbstractLongCharMapTestCase
{
    @Override
    protected abstract MutableLongCharMap classUnderTest();

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1);

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2);

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3);

    @Override
    protected abstract MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4);

    @Override
    protected abstract MutableLongCharMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.put(0L, (char) 1);
        Assert.assertEquals((char) 1, map1.get(0L));

        map1.put(0L, (char) 0);
        Assert.assertEquals((char) 0, map1.get(0L));

        map1.put(5L, (char) 5);
        Assert.assertEquals((char) 5, map1.get(5L));

        map1.put(35L, (char) 35);
        Assert.assertEquals((char) 35, map1.get(35L));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(0L));

        map1.put(1L, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(1L));

        map1.put(5L, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow(5L));

        map1.put(35L, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow(35L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals((char) 5, map1.getIfAbsent(0L, (char) 5));

        Assert.assertEquals((char) 6, map1.getIfAbsent(1L, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent(33L, (char) 6));

        map1.put(0L, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(0L, (char) 5));

        map1.put(1L, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(1L, (char) 5));

        map1.put(5L, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent(5L, (char) 6));

        map1.put(35L, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent(35L, (char) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableLongCharMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((char) 0, map1.get(0L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals((char) 0, map1.get(0L));

        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals((char) 0, map1.get(1L));

        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals((char) 0, map1.get(31L));

        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals((char) 0, map1.get(32L));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableLongCharMap map1 = this.classUnderTest();

        map1.put(35L, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));

        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableLongCharMap map1 = this.classUnderTest();

        map1.put(35L, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));

        map1.removeKey(0L);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableLongCharMap hashMap1 = this.newWithKeysValues(1L, (char) 1, 0L, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());

        MutableLongCharMap hashMap = this.newWithKeysValues(6L, (char) 6, 5L, (char) 5);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions()
    {
        LongArrayList collisions = new LongArrayList();
        LongCharHashMap hashMap = new LongCharHashMap();
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
        MutableLongCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongCharHashMap(), map1);

        map1.put(1L, (char) 0);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongCharHashMap(), map1);

        map1.put(33L, (char) 0);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new LongCharHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableLongCharMap map0 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map0.removeKey(1L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongCharHashMap(), map0);

        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map1.removeKey(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongCharHashMap(), map1);

        MutableLongCharMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(31L, (char) 31, 32L, (char) 32), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableLongCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableLongCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableLongCharMap map0 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map0.remove(1L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongCharHashMap(), map0);

        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        map1.remove(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongCharHashMap(), map1);

        MutableLongCharMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32), map2);
        map2.remove(0L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(31L, (char) 31, 32L, (char) 32), map2);
        map2.remove(31L);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableLongCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableLongCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableLongCharMap map0 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent(1L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(1L, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(0L, (char) 100));

        MutableLongCharMap map1 = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent(1L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(1L, (char) 100));

        MutableLongCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(5L, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(50L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(31L, (char) 31, 32L, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent(31L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent(32L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(0L, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(31L, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(32L, (char) 100));
        Assert.assertEquals(new LongCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableLongCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableLongCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableLongCharMap map1 = this.classUnderTest();
        map1.put(0L, (char) 1);
        map1.put(31L, (char) 32);
        map1.put(32L, (char) 33);
        LongCharHashMap expected = LongCharHashMap.newWithKeysValues(0L, (char) 1, 31L, (char) 32, 32L, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.put(1L, (char) 2);
        expected.put(1L, (char) 2);
        Assert.assertEquals(expected, map1);

        map1.put(33L, (char) 34);
        expected.put(33L, (char) 34);
        Assert.assertEquals(expected, map1);

        map1.put(30L, (char) 31);
        expected.put(30L, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableLongCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, (char) 1));
        map1.putPair(PrimitiveTuples.pair(31L, (char) 32));
        map1.putPair(PrimitiveTuples.pair(32L, (char) 33));
        LongCharHashMap expected = LongCharHashMap.newWithKeysValues(0L, (char) 1, 31L, (char) 32, 32L, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1L, (char) 2));
        expected.put(1L, (char) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33L, (char) 34));
        expected.put(33L, (char) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30L, (char) 31));
        expected.put(30L, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0L, (char) 1));
        Assert.assertEquals(32L, map1.addToValue(31L, (char) 32));
        Assert.assertEquals(3L, map1.addToValue(1L, (char) 3));
        Assert.assertEquals(11L, map1.addToValue(0L, (char) 10));
        Assert.assertEquals(12L, map1.addToValue(1L, (char) 9));
        Assert.assertEquals(37L, map1.addToValue(31L, (char) 5));
        Assert.assertEquals(33L, map1.addToValue(32L, (char) 33));
        LongCharHashMap expected = LongCharHashMap.newWithKeysValues(0L, (char) 11, 1L, (char) 12, 31L, (char) 37, 32L, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5L, map1.addToValue(31L, (char) 5));
        Assert.assertEquals(37L, map1.addToValue(31L, (char) 32));
        Assert.assertEquals(33L, map1.addToValue(32L, (char) 33));
        Assert.assertEquals(3L, map1.addToValue(1L, (char) 3));
        Assert.assertEquals(1L, map1.addToValue(0L, (char) 1));
        Assert.assertEquals(12L, map1.addToValue(1L, (char) 9));
        Assert.assertEquals(11L, map1.addToValue(0L, (char) 10));
        Assert.assertEquals(expected, map1);

        MutableLongCharMap map2 = this.getEmptyMap();
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
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        LongCharHashMap hashMap = new LongCharHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((long) i));
            hashMap.put((long) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((long) i));
            hashMap.remove((long) i);
            Assert.assertEquals((char) 0, hashMap.get((long) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        long collision1 = AbstractMutableLongCharMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongCharMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongCharMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongCharMapTestCase.generateCollisions().get(3);

        MutableLongCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);

        MutableLongCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);

        MutableLongCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 50, 1L, (char) 50), map1);

        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 50, 1L, (char) 50), map2);

        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 50), map3);

        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, (char) 100));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 100, 1L, (char) 100), map1);

        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 100, 1L, (char) 100), map2);

        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 100), map3);

        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 9, 1L, (char) 9), map1);

        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 9, 1L, (char) 9), map2);

        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 9), map3);

        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33L, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToCharFunction function = (long longParameter) -> (char) longParameter;
        LongToCharFunction functionThrows = (long longParameter) -> { throw new AssertionError(); };

        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1), map1);

        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1), map2);

        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(32L, (char) 32), map3);

        MutableLongCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 33), map4);
    }

    @Test
    public void updateValue()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableLongCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2, 1L, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2, 1L, (char) 2), map1);

        MutableLongCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 1, 1L, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 2, 1L, (char) 2), map2);

        MutableLongCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33L, (char) 0, incrementFunction));
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(33L, (char) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableLongCharMap mutableLongCharMap = this.classUnderTest();
        LongSet frozenSet = mutableLongCharMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableLongCharMap.put((long) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        LongSet frozenSetForRemove = mutableLongCharMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableLongCharMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableLongCharMap mutableLongCharMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongCharMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongCharMapForClear.keySet().toArray());
        mutableLongCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableLongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 31L, (char) 31, 32L, (char) 32);
        MutableLongCharMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 31L, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableLongCharMap map = this.newWithKeysValues(0L, (char) 0, 1L, (char) 1, 31L, (char) 31, 32L, (char) 32);
        MutableLongCharMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 31L, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableLongCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, (char) 1), hashMap);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedLongCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableLongCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove()
    {
        MutableLongCharMap mutableMap = this.classUnderTest();
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
        MutableLongCharMap map = this.newWithKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5);
        Assert.assertEquals(
                CharLongHashMap.newWithKeysValues((char) 2, 1L, (char) 3, 2L, (char) 4, 3L, (char) 5, 4L),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1L, (char) 1, 2L, (char) 1).flipUniqueValues());
    }
}
