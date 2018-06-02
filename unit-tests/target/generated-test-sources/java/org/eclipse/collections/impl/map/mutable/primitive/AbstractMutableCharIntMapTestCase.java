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

import org.eclipse.collections.api.block.function.primitive.CharToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableCharIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharIntMapTestCase extends AbstractCharIntMapTestCase
{
    @Override
    protected abstract MutableCharIntMap classUnderTest();

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1);

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2);

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3);

    @Override
    protected abstract MutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3, char key4, int value4);

    @Override
    protected abstract MutableCharIntMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.put((char) 0, 1);
        Assert.assertEquals(1, map1.get((char) 0));

        map1.put((char) 0, 0);
        Assert.assertEquals(0, map1.get((char) 0));

        map1.put((char) 5, 5);
        Assert.assertEquals(5, map1.get((char) 5));

        map1.put((char) 35, 35);
        Assert.assertEquals(35, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1);
        Assert.assertEquals(1, map1.getOrThrow((char) 0));

        map1.put((char) 1, 1);
        Assert.assertEquals(1, map1.getOrThrow((char) 1));

        map1.put((char) 5, 5);
        Assert.assertEquals(5, map1.getOrThrow((char) 5));

        map1.put((char) 35, 35);
        Assert.assertEquals(35, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5, map1.getIfAbsent((char) 0, 5));

        Assert.assertEquals(6, map1.getIfAbsent((char) 1, 6));
        Assert.assertEquals(6, map1.getIfAbsent((char) 33, 6));

        map1.put((char) 0, 1);
        Assert.assertEquals(1, map1.getIfAbsent((char) 0, 5));

        map1.put((char) 1, 1);
        Assert.assertEquals(1, map1.getIfAbsent((char) 1, 5));

        map1.put((char) 5, 5);
        Assert.assertEquals(5, map1.getIfAbsent((char) 5, 6));

        map1.put((char) 35, 35);
        Assert.assertEquals(35, map1.getIfAbsent((char) 35, 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableCharIntMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0, map1.get((char) 0));

        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0, map1.get((char) 1));

        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0, map1.get((char) 31));

        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableCharIntMap map1 = this.classUnderTest();

        map1.put((char) 35, 35);
        Assert.assertTrue(map1.containsValue(35));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableCharIntMap map1 = this.classUnderTest();

        map1.put((char) 35, 35);
        Assert.assertTrue(map1.contains(35));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableCharIntMap hashMap1 = this.newWithKeysValues((char) 1, 1, (char) 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableCharIntMap hashMap = this.newWithKeysValues((char) 6, 6, (char) 5, 5);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions()
    {
        CharArrayList collisions = new CharArrayList();
        CharIntHashMap hashMap = new CharIntHashMap();
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
        MutableCharIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharIntHashMap(), map1);

        map1.put((char) 1, 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 0), map1);
        map1.clear();
        Assert.assertEquals(new CharIntHashMap(), map1);

        map1.put((char) 33, 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 0), map1);
        map1.clear();
        Assert.assertEquals(new CharIntHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableCharIntMap map0 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharIntHashMap(), map0);

        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharIntHashMap(), map1);

        MutableCharIntMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 31, 31, (char) 32, 32), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableCharIntMap map0 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map0.remove((char) 1);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharIntHashMap(), map0);

        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        map1.remove((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharIntHashMap(), map1);

        MutableCharIntMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 31, 31, (char) 32, 32), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableCharIntMap map0 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent((char) 1, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(new CharIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent((char) 1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent((char) 0, 100));

        MutableCharIntMap map1 = this.newWithKeysValues((char) 0, 0, (char) 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent((char) 1, 100));
        Assert.assertEquals(new CharIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent((char) 1, 100));

        MutableCharIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 50, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 31, 31, (char) 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 31, 31, (char) 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent((char) 31, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent((char) 32, 100));
        Assert.assertEquals(new CharIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((char) 32, 100));
        Assert.assertEquals(new CharIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableCharIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableCharIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableCharIntMap map1 = this.classUnderTest();
        map1.put((char) 0, 1);
        map1.put((char) 31, 32);
        map1.put((char) 32, 33);
        CharIntHashMap expected = CharIntHashMap.newWithKeysValues((char) 0, 1, (char) 31, 32, (char) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.put((char) 1, 2);
        expected.put((char) 1, 2);
        Assert.assertEquals(expected, map1);

        map1.put((char) 33, 34);
        expected.put((char) 33, 34);
        Assert.assertEquals(expected, map1);

        map1.put((char) 30, 31);
        expected.put((char) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableCharIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33));
        CharIntHashMap expected = CharIntHashMap.newWithKeysValues((char) 0, 1, (char) 31, 32, (char) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 1, 2));
        expected.put((char) 1, 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 33, 34));
        expected.put((char) 33, 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 30, 31));
        expected.put((char) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1));
        Assert.assertEquals(32L, map1.addToValue((char) 31, 32));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 5));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33));
        CharIntHashMap expected = CharIntHashMap.newWithKeysValues((char) 0, 11, (char) 1, 12, (char) 31, 37, (char) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, 5));
        Assert.assertEquals(37L, map1.addToValue((char) 31, 32));
        Assert.assertEquals(33L, map1.addToValue((char) 32, 33));
        Assert.assertEquals(3L, map1.addToValue((char) 1, 3));
        Assert.assertEquals(1L, map1.addToValue((char) 0, 1));
        Assert.assertEquals(12L, map1.addToValue((char) 1, 9));
        Assert.assertEquals(11L, map1.addToValue((char) 0, 10));
        Assert.assertEquals(expected, map1);

        MutableCharIntMap map2 = this.getEmptyMap();
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
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        CharIntHashMap hashMap = new CharIntHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((char) i));
            hashMap.put((char) i, i);
            Assert.assertEquals(i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals(0, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        char collision1 = AbstractMutableCharIntMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharIntMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharIntMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharIntMapTestCase.generateCollisions().get(3);

        MutableCharIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);

        MutableCharIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);

        MutableCharIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 50, (char) 1, 50), map1);

        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 50, (char) 1, 50), map2);

        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 50), map3);

        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, 100));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 100, (char) 1, 100), map1);

        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 100, (char) 1, 100), map2);

        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 100), map3);

        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 9, (char) 1, 9), map1);

        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 9, (char) 1, 9), map2);

        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 9), map3);

        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToIntFunction function = (char charParameter) -> (int) charParameter;
        CharToIntFunction functionThrows = (char charParameter) -> { throw new AssertionError(); };

        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1), map1);

        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1), map2);

        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 32, 32), map3);

        MutableCharIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 33), map4);
    }

    @Test
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableCharIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2, (char) 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map1);

        MutableCharIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 1, (char) 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 2, (char) 1, 2), map2);

        MutableCharIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, 0, incrementFunction));
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 33, 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableCharIntMap mutableCharIntMap = this.classUnderTest();
        CharSet frozenSet = mutableCharIntMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharIntMap.put((char) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        CharSet frozenSetForRemove = mutableCharIntMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharIntMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableCharIntMap mutableCharIntMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharIntMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharIntMapForClear.keySet().toArray());
        mutableCharIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableCharIntMap map = this.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 31, 31, (char) 32, 32);
        MutableCharIntMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableCharIntMap map = this.newWithKeysValues((char) 0, 0, (char) 1, 1, (char) 31, 31, (char) 32, 32);
        MutableCharIntMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1, (char) 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableCharIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1), hashMap);
        Assert.assertEquals(CharIntHashMap.newWithKeysValues((char) 1, 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedCharIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableCharIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove()
    {
        MutableCharIntMap mutableMap = this.classUnderTest();
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
        MutableCharIntMap map = this.newWithKeysValues((char) 1, 2, (char) 2, 3, (char) 3, 4, (char) 4, 5);
        Assert.assertEquals(
                IntCharHashMap.newWithKeysValues(2, (char) 1, 3, (char) 2, 4, (char) 3, 5, (char) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((char) 1, 1, (char) 2, 1).flipUniqueValues());
    }
}
