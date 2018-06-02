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

import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharLongMapTestCase extends AbstractCharLongMapTestCase
{
    @Override
    protected abstract MutableCharLongMap classUnderTest();

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1);

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2);

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3);

    @Override
    protected abstract MutableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4);

    @Override
    protected abstract MutableCharLongMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.put((char) 0, 1L);
        Assert.assertEquals(1L, map1.get((char) 0));

        map1.put((char) 0, 0L);
        Assert.assertEquals(0L, map1.get((char) 0));

        map1.put((char) 5, 5L);
        Assert.assertEquals(5L, map1.get((char) 5));

        map1.put((char) 35, 35L);
        Assert.assertEquals(35L, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((char) 0));

        map1.put((char) 1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((char) 1));

        map1.put((char) 5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow((char) 5));

        map1.put((char) 35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5L, map1.getIfAbsent((char) 0, 5L));

        Assert.assertEquals(6L, map1.getIfAbsent((char) 1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent((char) 33, 6L));

        map1.put((char) 0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((char) 0, 5L));

        map1.put((char) 1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((char) 1, 5L));

        map1.put((char) 5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent((char) 5, 6L));

        map1.put((char) 35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent((char) 35, 5L));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableCharLongMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0L, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0L, map1.get((char) 0));

        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0L, map1.get((char) 1));

        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0L, map1.get((char) 31));

        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0L, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableCharLongMap map1 = this.classUnderTest();

        map1.put((char) 35, 35L);
        Assert.assertTrue(map1.containsValue(35L));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableCharLongMap map1 = this.classUnderTest();

        map1.put((char) 35, 35L);
        Assert.assertTrue(map1.contains(35L));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableCharLongMap hashMap1 = this.newWithKeysValues((char) 1, 1L, (char) 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableCharLongMap hashMap = this.newWithKeysValues((char) 6, 6L, (char) 5, 5L);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions()
    {
        CharArrayList collisions = new CharArrayList();
        CharLongHashMap hashMap = new CharLongHashMap();
        for (char each = (char) 2; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((char) 2))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableCharLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharLongHashMap(), map1);

        map1.put((char) 1, 0L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new CharLongHashMap(), map1);

        map1.put((char) 33, 0L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new CharLongHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableCharLongMap map0 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharLongHashMap(), map0);

        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharLongHashMap(), map1);

        MutableCharLongMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 31, 31L, (char) 32, 32L), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableCharLongMap map0 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map0.remove((char) 1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharLongHashMap(), map0);

        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        map1.remove((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharLongHashMap(), map1);

        MutableCharLongMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 31, 31L, (char) 32, 32L), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableCharLongMap map0 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent((char) 1, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(new CharLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((char) 1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((char) 0, 100L));

        MutableCharLongMap map1 = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent((char) 1, 100L));
        Assert.assertEquals(new CharLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((char) 1, 100L));

        MutableCharLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 50, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 31, 31L, (char) 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent((char) 31, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent((char) 32, 100L));
        Assert.assertEquals(new CharLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((char) 32, 100L));
        Assert.assertEquals(new CharLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableCharLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableCharLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableCharLongMap map1 = this.classUnderTest();
        map1.put((char) 0, 1L);
        map1.put((char) 31, 32L);
        map1.put((char) 32, 33L);
        CharLongHashMap expected = CharLongHashMap.newWithKeysValues((char) 0, 1L, (char) 31, 32L, (char) 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.put((char) 1, 2L);
        expected.put((char) 1, 2L);
        Assert.assertEquals(expected, map1);

        map1.put((char) 33, 34L);
        expected.put((char) 33, 34L);
        Assert.assertEquals(expected, map1);

        map1.put((char) 30, 31L);
        expected.put((char) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableCharLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1L));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32L));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33L));
        CharLongHashMap expected = CharLongHashMap.newWithKeysValues((char) 0, 1L, (char) 31, 32L, (char) 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 1, 2L));
        expected.put((char) 1, 2L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 33, 34L));
        expected.put((char) 33, 34L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 30, 31L));
        expected.put((char) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1L));
        Assert.assertEquals(32L, map1.addToValue((char) 31, 32L));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3L));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10L));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9L));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 5L));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33L));
        CharLongHashMap expected = CharLongHashMap.newWithKeysValues((char) 0, 11L, (char) 1, 12L, (char) 31, 37L, (char) 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, 5L));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 32L));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33L));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3L));
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1L));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9L));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10L));
        Assert.assertEquals(expected, map1);

        MutableCharLongMap map2 = this.getEmptyMap();
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
            char k = (char) (each);
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        CharLongHashMap hashMap = new CharLongHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((char) i));
            hashMap.put((char) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals(0L, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        char collision1 = AbstractMutableCharLongMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharLongMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharLongMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharLongMapTestCase.generateCollisions().get(3);

        MutableCharLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);

        MutableCharLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);

        MutableCharLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 50L, (char) 1, 50L), map1);

        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 50L, (char) 1, 50L), map2);

        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 50L), map3);

        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 100L));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 100L, (char) 1, 100L), map1);

        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 100L, (char) 1, 100L), map2);

        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 100L), map3);

        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 9L, (char) 1, 9L), map1);

        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 9L, (char) 1, 9L), map2);

        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 9L), map3);

        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToLongFunction function = (char charParameter) -> (long) charParameter;
        CharToLongFunction functionThrows = (char charParameter) -> { throw new AssertionError(); };

        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L), map1);

        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L), map2);

        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 32, 32L), map3);

        MutableCharLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 33L), map4);
    }

    @Test
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableCharLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L, (char) 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L, (char) 1, 2L), map1);

        MutableCharLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 1L, (char) 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 2L, (char) 1, 2L), map2);

        MutableCharLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, 0L, incrementFunction));
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 33, 2L), map3);
    }

    @Test
    public void freeze()
    {
        MutableCharLongMap mutableCharLongMap = this.classUnderTest();
        CharSet frozenSet = mutableCharLongMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharLongMap.put((char) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        CharSet frozenSetForRemove = mutableCharLongMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharLongMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableCharLongMap mutableCharLongMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharLongMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharLongMapForClear.keySet().toArray());
        mutableCharLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableCharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 31, 31L, (char) 32, 32L);
        MutableCharLongMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableCharLongMap map = this.newWithKeysValues((char) 0, 0L, (char) 1, 1L, (char) 31, 31L, (char) 32, 32L);
        MutableCharLongMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableCharLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1L), hashMap);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedCharLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableCharLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove()
    {
        MutableCharLongMap mutableMap = this.classUnderTest();
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
        MutableCharLongMap map = this.newWithKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L);
        Assert.assertEquals(
                LongCharHashMap.newWithKeysValues(2L, (char) 1, 3L, (char) 2, 4L, (char) 3, 5L, (char) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((char) 1, 1L, (char) 2, 1L).flipUniqueValues());
    }
}
