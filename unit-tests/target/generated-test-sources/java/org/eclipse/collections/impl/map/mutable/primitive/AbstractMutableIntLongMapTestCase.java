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

import org.eclipse.collections.api.block.function.primitive.IntToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableIntLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractIntLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableIntLongMapTestCase extends AbstractIntLongMapTestCase
{
    @Override
    protected abstract MutableIntLongMap classUnderTest();

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1);

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2);

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3);

    @Override
    protected abstract MutableIntLongMap newWithKeysValues(int key1, long value1, int key2, long value2, int key3, long value3, int key4, long value4);

    @Override
    protected abstract MutableIntLongMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.put(0, 1L);
        Assert.assertEquals(1L, map1.get(0));

        map1.put(0, 0L);
        Assert.assertEquals(0L, map1.get(0));

        map1.put(5, 5L);
        Assert.assertEquals(5L, map1.get(5));

        map1.put(35, 35L);
        Assert.assertEquals(35L, map1.get(35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0));
        map1.put(0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(0));

        map1.put(1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow(1));

        map1.put(5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow(5));

        map1.put(35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow(35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertEquals(5L, map1.getIfAbsent(0, 5L));

        Assert.assertEquals(6L, map1.getIfAbsent(1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent(33, 6L));

        map1.put(0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(0, 5L));

        map1.put(1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent(1, 5L));

        map1.put(5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent(5, 6L));

        map1.put(35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent(35, 5L));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableIntLongMap map1 = this.classUnderTest();
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0L, map1.get(0));
        map1.removeKey(0);
        Assert.assertFalse(map1.containsKey(0));
        Assert.assertEquals(0L, map1.get(0));

        map1.removeKey(1);
        Assert.assertFalse(map1.containsKey(1));
        Assert.assertEquals(0L, map1.get(1));

        map1.removeKey(31);
        Assert.assertFalse(map1.containsKey(31));
        Assert.assertEquals(0L, map1.get(31));

        map1.removeKey(32);
        Assert.assertFalse(map1.containsKey(32));
        Assert.assertEquals(0L, map1.get(32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableIntLongMap map1 = this.classUnderTest();

        map1.put(35, 35L);
        Assert.assertTrue(map1.containsValue(35L));

        map1.removeKey(0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableIntLongMap map1 = this.classUnderTest();

        map1.put(35, 35L);
        Assert.assertTrue(map1.contains(35L));

        map1.removeKey(0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableIntLongMap hashMap1 = this.newWithKeysValues(1, 1L, 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0);
        Assert.assertEquals(0, hashMap1.size());

        MutableIntLongMap hashMap = this.newWithKeysValues(6, 6L, 5, 5L);
        hashMap.removeKey(5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static IntArrayList generateCollisions()
    {
        IntArrayList collisions = new IntArrayList();
        IntLongHashMap hashMap = new IntLongHashMap();
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
        MutableIntLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new IntLongHashMap(), map1);

        map1.put(1, 0L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new IntLongHashMap(), map1);

        map1.put(33, 0L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new IntLongHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableIntLongMap map0 = this.newWithKeysValues(0, 0L, 1, 1L);
        map0.removeKey(1);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map0);
        map0.removeKey(0);
        Assert.assertEquals(new IntLongHashMap(), map0);

        MutableIntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        map1.removeKey(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map1);
        map1.removeKey(1);
        Assert.assertEquals(new IntLongHashMap(), map1);

        MutableIntLongMap map2 = this.classUnderTest();
        map2.removeKey(5);
        map2.removeKey(50);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L), map2);
        map2.removeKey(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(31, 31L, 32, 32L), map2);
        map2.removeKey(31);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map2);
        map2.removeKey(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        map2.removeKey(0);
        map2.removeKey(31);
        map2.removeKey(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableIntLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableIntLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableIntLongMap map0 = this.newWithKeysValues(0, 0L, 1, 1L);
        map0.remove(1);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map0);
        map0.remove(0);
        Assert.assertEquals(new IntLongHashMap(), map0);

        MutableIntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        map1.remove(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map1);
        map1.remove(1);
        Assert.assertEquals(new IntLongHashMap(), map1);

        MutableIntLongMap map2 = this.classUnderTest();
        map2.remove(5);
        map2.remove(50);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L), map2);
        map2.remove(0);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(31, 31L, 32, 32L), map2);
        map2.remove(31);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map2);
        map2.remove(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        map2.remove(0);
        map2.remove(31);
        map2.remove(32);
        Assert.assertEquals(new IntLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableIntLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableIntLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableIntLongMap map0 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent(1, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(new IntLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent(0, 100L));

        MutableIntLongMap map1 = this.newWithKeysValues(0, 0L, 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent(1, 100L));
        Assert.assertEquals(new IntLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent(1, 100L));

        MutableIntLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(50, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 31, 31L, 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(31, 31L, 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent(31, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent(32, 100L));
        Assert.assertEquals(new IntLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent(32, 100L));
        Assert.assertEquals(new IntLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableIntLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableIntLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableIntLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableIntLongMap map1 = this.classUnderTest();
        map1.put(0, 1L);
        map1.put(31, 32L);
        map1.put(32, 33L);
        IntLongHashMap expected = IntLongHashMap.newWithKeysValues(0, 1L, 31, 32L, 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.put(1, 2L);
        expected.put(1, 2L);
        Assert.assertEquals(expected, map1);

        map1.put(33, 34L);
        expected.put(33, 34L);
        Assert.assertEquals(expected, map1);

        map1.put(30, 31L);
        expected.put(30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableIntLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0, 1L));
        map1.putPair(PrimitiveTuples.pair(31, 32L));
        map1.putPair(PrimitiveTuples.pair(32, 33L));
        IntLongHashMap expected = IntLongHashMap.newWithKeysValues(0, 1L, 31, 32L, 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1, 2L));
        expected.put(1, 2L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33, 34L));
        expected.put(33, 34L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30, 31L));
        expected.put(30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, 1L));
        Assert.assertEquals(32L, map1.addToValue(31, 32L));
        Assert.assertEquals(3L, map1.addToValue(1, 3L));
        Assert.assertEquals(11L, map1.addToValue(0, 10L));
        Assert.assertEquals(12L, map1.addToValue(1, 9L));
        Assert.assertEquals(37L, map1.addToValue(31, 5L));
        Assert.assertEquals(33L, map1.addToValue(32, 33L));
        IntLongHashMap expected = IntLongHashMap.newWithKeysValues(0, 11L, 1, 12L, 31, 37L, 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0);
        map1.removeKey(1);
        map1.removeKey(31);
        map1.removeKey(32);
        Assert.assertEquals(5L, map1.addToValue(31, 5L));
        Assert.assertEquals(37L, map1.addToValue(31, 32L));
        Assert.assertEquals(33L, map1.addToValue(32, 33L));
        Assert.assertEquals(3L, map1.addToValue(1, 3L));
        Assert.assertEquals(1L, map1.addToValue(0, 1L));
        Assert.assertEquals(12L, map1.addToValue(1, 9L));
        Assert.assertEquals(11L, map1.addToValue(0, 10L));
        Assert.assertEquals(expected, map1);

        MutableIntLongMap map2 = this.getEmptyMap();
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
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        IntLongHashMap hashMap = new IntLongHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get(i));
            hashMap.put(i, (long) i);
            Assert.assertEquals((long) i, hashMap.get(i));
            hashMap.remove(i);
            Assert.assertEquals(0L, hashMap.get(i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        int collision1 = AbstractMutableIntLongMapTestCase.generateCollisions().getFirst();
        int collision2 = AbstractMutableIntLongMapTestCase.generateCollisions().get(1);
        int collision3 = AbstractMutableIntLongMapTestCase.generateCollisions().get(2);
        int collision4 = AbstractMutableIntLongMapTestCase.generateCollisions().get(3);

        MutableIntLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);

        MutableIntLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);

        MutableIntLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map1);

        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map2);

        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 50L), map3);

        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33, 100L));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map1);

        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map2);

        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 100L), map3);

        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33, factoryThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map1);

        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map2);

        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(32, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 9L), map3);

        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith(33, functionThrows, "unused"));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        IntToLongFunction function = (int intParameter) -> (long) intParameter;
        IntToLongFunction functionThrows = (int intParameter) -> { throw new AssertionError(); };

        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map1);

        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map2);

        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(32, 32L), map3);

        MutableIntLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33, functionThrows));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 33L), map4);
    }

    @Test
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableIntLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L, 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map1);

        MutableIntLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 1L, 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map2);

        MutableIntLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(33, 0L, incrementFunction));
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(33, 2L), map3);
    }

    @Test
    public void freeze()
    {
        MutableIntLongMap mutableIntLongMap = this.classUnderTest();
        IntSet frozenSet = mutableIntLongMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableIntLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableIntLongMap.put((int) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        IntSet frozenSetForRemove = mutableIntLongMap.keySet().freeze();
        IntSet frozenSetCopyForRemove = IntHashSet.newSetWith(mutableIntLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableIntLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableIntLongMap.remove((int) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableIntLongMap mutableIntLongMapForClear = this.classUnderTest();
        IntSet frozenSetForClear = mutableIntLongMapForClear.keySet().freeze();
        IntSet frozenSetCopyForClear = IntHashSet.newSetWith(mutableIntLongMapForClear.keySet().toArray());
        mutableIntLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableIntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 31, 31L, 32, 32L);
        MutableIntLongMap mapWithout = map.withoutKey(32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableIntLongMap map = this.newWithKeysValues(0, 0L, 1, 1L, 31, 31L, 32, 32L);
        MutableIntLongMap mapWithout = map.withoutAllKeys(IntArrayList.newListWith(0, 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L, 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableIntLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1, 1L), hashMap);
        Assert.assertEquals(IntLongHashMap.newWithKeysValues(1, 1L), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedIntLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedIntLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableIntLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableIntLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove()
    {
        MutableIntLongMap mutableMap = this.classUnderTest();
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
        MutableIntLongMap map = this.newWithKeysValues(1, 2L, 2, 3L, 3, 4L, 4, 5L);
        Assert.assertEquals(
                LongIntHashMap.newWithKeysValues(2L, 1, 3L, 2, 4L, 3, 5L, 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1, 1L, 2, 1L).flipUniqueValues());
    }
}
