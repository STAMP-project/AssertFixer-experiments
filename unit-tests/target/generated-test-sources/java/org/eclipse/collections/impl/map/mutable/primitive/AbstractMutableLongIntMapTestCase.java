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

import org.eclipse.collections.api.block.function.primitive.LongToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractLongIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableLongIntMapTestCase extends AbstractLongIntMapTestCase
{
    @Override
    protected abstract MutableLongIntMap classUnderTest();

    @Override
    protected abstract MutableLongIntMap newWithKeysValues(long key1, int value1);

    @Override
    protected abstract MutableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2);

    @Override
    protected abstract MutableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3);

    @Override
    protected abstract MutableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4);

    @Override
    protected abstract MutableLongIntMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableLongIntMap map1 = this.classUnderTest();
        map1.put(0L, 1);
        Assert.assertEquals(1, map1.get(0L));

        map1.put(0L, 0);
        Assert.assertEquals(0, map1.get(0L));

        map1.put(5L, 5);
        Assert.assertEquals(5, map1.get(5L));

        map1.put(35L, 35);
        Assert.assertEquals(35, map1.get(35L));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableLongIntMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0L));
        map1.put(0L, 1);
        Assert.assertEquals(1, map1.getOrThrow(0L));

        map1.put(1L, 1);
        Assert.assertEquals(1, map1.getOrThrow(1L));

        map1.put(5L, 5);
        Assert.assertEquals(5, map1.getOrThrow(5L));

        map1.put(35L, 35);
        Assert.assertEquals(35, map1.getOrThrow(35L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableLongIntMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertEquals(5, map1.getIfAbsent(0L, 5));

        Assert.assertEquals(6, map1.getIfAbsent(1L, 6));
        Assert.assertEquals(6, map1.getIfAbsent(33L, 6));

        map1.put(0L, 1);
        Assert.assertEquals(1, map1.getIfAbsent(0L, 5));

        map1.put(1L, 1);
        Assert.assertEquals(1, map1.getIfAbsent(1L, 5));

        map1.put(5L, 5);
        Assert.assertEquals(5, map1.getIfAbsent(5L, 6));

        map1.put(35L, 35);
        Assert.assertEquals(35, map1.getIfAbsent(35L, 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableLongIntMap map1 = this.classUnderTest();
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0, map1.get(0L));
        map1.removeKey(0L);
        Assert.assertFalse(map1.containsKey(0L));
        Assert.assertEquals(0, map1.get(0L));

        map1.removeKey(1L);
        Assert.assertFalse(map1.containsKey(1L));
        Assert.assertEquals(0, map1.get(1L));

        map1.removeKey(31L);
        Assert.assertFalse(map1.containsKey(31L));
        Assert.assertEquals(0, map1.get(31L));

        map1.removeKey(32L);
        Assert.assertFalse(map1.containsKey(32L));
        Assert.assertEquals(0, map1.get(32L));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableLongIntMap map1 = this.classUnderTest();

        map1.put(35L, 35);
        Assert.assertTrue(map1.containsValue(35));

        map1.removeKey(0L);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableLongIntMap map1 = this.classUnderTest();

        map1.put(35L, 35);
        Assert.assertTrue(map1.contains(35));

        map1.removeKey(0L);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableLongIntMap hashMap1 = this.newWithKeysValues(1L, 1, 0L, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1L);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0L);
        Assert.assertEquals(0, hashMap1.size());

        MutableLongIntMap hashMap = this.newWithKeysValues(6L, 6, 5L, 5);
        hashMap.removeKey(5L);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static LongArrayList generateCollisions()
    {
        LongArrayList collisions = new LongArrayList();
        LongIntHashMap hashMap = new LongIntHashMap();
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
        MutableLongIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new LongIntHashMap(), map1);

        map1.put(1L, 0);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 0), map1);
        map1.clear();
        Assert.assertEquals(new LongIntHashMap(), map1);

        map1.put(33L, 0);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 0), map1);
        map1.clear();
        Assert.assertEquals(new LongIntHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableLongIntMap map0 = this.newWithKeysValues(0L, 0, 1L, 1);
        map0.removeKey(1L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0), map0);
        map0.removeKey(0L);
        Assert.assertEquals(new LongIntHashMap(), map0);

        MutableLongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1);
        map1.removeKey(0L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1), map1);
        map1.removeKey(1L);
        Assert.assertEquals(new LongIntHashMap(), map1);

        MutableLongIntMap map2 = this.classUnderTest();
        map2.removeKey(5L);
        map2.removeKey(50L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32), map2);
        map2.removeKey(0L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(31L, 31, 32L, 32), map2);
        map2.removeKey(31L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 32), map2);
        map2.removeKey(32L);
        Assert.assertEquals(new LongIntHashMap(), map2);
        map2.removeKey(0L);
        map2.removeKey(31L);
        map2.removeKey(32L);
        Assert.assertEquals(new LongIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableLongIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableLongIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableLongIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableLongIntMap map0 = this.newWithKeysValues(0L, 0, 1L, 1);
        map0.remove(1L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0), map0);
        map0.remove(0L);
        Assert.assertEquals(new LongIntHashMap(), map0);

        MutableLongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1);
        map1.remove(0L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1), map1);
        map1.remove(1L);
        Assert.assertEquals(new LongIntHashMap(), map1);

        MutableLongIntMap map2 = this.classUnderTest();
        map2.remove(5L);
        map2.remove(50L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32), map2);
        map2.remove(0L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(31L, 31, 32L, 32), map2);
        map2.remove(31L);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 32), map2);
        map2.remove(32L);
        Assert.assertEquals(new LongIntHashMap(), map2);
        map2.remove(0L);
        map2.remove(31L);
        map2.remove(32L);
        Assert.assertEquals(new LongIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableLongIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableLongIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableLongIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableLongIntMap map0 = this.newWithKeysValues(0L, 0, 1L, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent(1L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent(0L, 100));
        Assert.assertEquals(new LongIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent(1L, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent(0L, 100));

        MutableLongIntMap map1 = this.newWithKeysValues(0L, 0, 1L, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent(0L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent(1L, 100));
        Assert.assertEquals(new LongIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent(0L, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent(1L, 100));

        MutableLongIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent(5L, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(50L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent(0L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(31L, 31, 32L, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent(31L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent(32L, 100));
        Assert.assertEquals(new LongIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent(0L, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(31L, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent(32L, 100));
        Assert.assertEquals(new LongIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableLongIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableLongIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableLongIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableLongIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableLongIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableLongIntMap map1 = this.classUnderTest();
        map1.put(0L, 1);
        map1.put(31L, 32);
        map1.put(32L, 33);
        LongIntHashMap expected = LongIntHashMap.newWithKeysValues(0L, 1, 31L, 32, 32L, 33);
        Assert.assertEquals(expected, map1);

        map1.put(1L, 2);
        expected.put(1L, 2);
        Assert.assertEquals(expected, map1);

        map1.put(33L, 34);
        expected.put(33L, 34);
        Assert.assertEquals(expected, map1);

        map1.put(30L, 31);
        expected.put(30L, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableLongIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0L, 1));
        map1.putPair(PrimitiveTuples.pair(31L, 32));
        map1.putPair(PrimitiveTuples.pair(32L, 33));
        LongIntHashMap expected = LongIntHashMap.newWithKeysValues(0L, 1, 31L, 32, 32L, 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1L, 2));
        expected.put(1L, 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33L, 34));
        expected.put(33L, 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30L, 31));
        expected.put(30L, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableLongIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0L, 1));
        Assert.assertEquals(32L, map1.addToValue(31L, 32));
        Assert.assertEquals(3L, map1.addToValue(1L, 3));
        Assert.assertEquals(11L, map1.addToValue(0L, 10));
        Assert.assertEquals(12L, map1.addToValue(1L, 9));
        Assert.assertEquals(37L, map1.addToValue(31L, 5));
        Assert.assertEquals(33L, map1.addToValue(32L, 33));
        LongIntHashMap expected = LongIntHashMap.newWithKeysValues(0L, 11, 1L, 12, 31L, 37, 32L, 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0L);
        map1.removeKey(1L);
        map1.removeKey(31L);
        map1.removeKey(32L);
        Assert.assertEquals(5L, map1.addToValue(31L, 5));
        Assert.assertEquals(37L, map1.addToValue(31L, 32));
        Assert.assertEquals(33L, map1.addToValue(32L, 33));
        Assert.assertEquals(3L, map1.addToValue(1L, 3));
        Assert.assertEquals(1L, map1.addToValue(0L, 1));
        Assert.assertEquals(12L, map1.addToValue(1L, 9));
        Assert.assertEquals(11L, map1.addToValue(0L, 10));
        Assert.assertEquals(expected, map1);

        MutableLongIntMap map2 = this.getEmptyMap();
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
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        LongIntHashMap hashMap = new LongIntHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((long) i));
            hashMap.put((long) i, i);
            Assert.assertEquals(i, hashMap.get((long) i));
            hashMap.remove((long) i);
            Assert.assertEquals(0, hashMap.get((long) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        long collision1 = AbstractMutableLongIntMapTestCase.generateCollisions().getFirst();
        long collision2 = AbstractMutableLongIntMapTestCase.generateCollisions().get(1);
        long collision3 = AbstractMutableLongIntMapTestCase.generateCollisions().get(2);
        long collision4 = AbstractMutableLongIntMapTestCase.generateCollisions().get(3);

        MutableLongIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);

        MutableLongIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);

        MutableLongIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableLongIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 50, 1L, 50), map1);

        MutableLongIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 50, 1L, 50), map2);

        MutableLongIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 50), map3);

        MutableLongIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33L, 100));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableLongIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 100, 1L, 100), map1);

        MutableLongIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1L, factoryThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0L, factoryThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 100, 1L, 100), map2);

        MutableLongIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32L, factoryThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 100), map3);

        MutableLongIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33L, factoryThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableLongIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 9, 1L, 9), map1);

        MutableLongIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1L, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(1L, functionThrows, "unused"));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0L, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith(0L, functionThrows, "unused"));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 9, 1L, 9), map2);

        MutableLongIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32L, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith(32L, functionThrows, "unused"));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 9), map3);

        MutableLongIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33L, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith(33L, functionThrows, "unused"));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToIntFunction function = (long longParameter) -> (int) longParameter;
        LongToIntFunction functionThrows = (long longParameter) -> { throw new AssertionError(); };

        MutableLongIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 1L, 1), map1);

        MutableLongIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1L, functionThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0L, functionThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 1L, 1), map2);

        MutableLongIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32L, functionThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(32L, 32), map3);

        MutableLongIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33L, functionThrows));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 33), map4);
    }

    @Test
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableLongIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 2, 1L, 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 2, 1L, 2), map1);

        MutableLongIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 1, 1L, 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 2, 1L, 2), map2);

        MutableLongIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33L, 0, incrementFunction));
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(33L, 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableLongIntMap mutableLongIntMap = this.classUnderTest();
        LongSet frozenSet = mutableLongIntMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableLongIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableLongIntMap.put((long) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        LongSet frozenSetForRemove = mutableLongIntMap.keySet().freeze();
        LongSet frozenSetCopyForRemove = LongHashSet.newSetWith(mutableLongIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableLongIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableLongIntMap.remove((long) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableLongIntMap mutableLongIntMapForClear = this.classUnderTest();
        LongSet frozenSetForClear = mutableLongIntMapForClear.keySet().freeze();
        LongSet frozenSetCopyForClear = LongHashSet.newSetWith(mutableLongIntMapForClear.keySet().toArray());
        mutableLongIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableLongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 31L, 31, 32L, 32);
        MutableLongIntMap mapWithout = map.withoutKey(32L);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(0L, 0, 1L, 1, 31L, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableLongIntMap map = this.newWithKeysValues(0L, 0, 1L, 1, 31L, 31, 32L, 32);
        MutableLongIntMap mapWithout = map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 31L, 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableLongIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1L, 1), hashMap);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedLongIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedLongIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableLongIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableLongIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove()
    {
        MutableLongIntMap mutableMap = this.classUnderTest();
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
        MutableLongIntMap map = this.newWithKeysValues(1L, 2, 2L, 3, 3L, 4, 4L, 5);
        Assert.assertEquals(
                IntLongHashMap.newWithKeysValues(2, 1L, 3, 2L, 4, 3L, 5, 4L),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1L, 1, 2L, 1).flipUniqueValues());
    }
}
