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

import org.eclipse.collections.api.block.function.primitive.CharToByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.api.map.primitive.MutableCharByteMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharByteMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharByteMapTestCase extends AbstractCharByteMapTestCase
{
    @Override
    protected abstract MutableCharByteMap classUnderTest();

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1);

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2);

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3);

    @Override
    protected abstract MutableCharByteMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3, char key4, byte value4);

    @Override
    protected abstract MutableCharByteMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.put((char) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.get((char) 0));

        map1.put((char) 0, (byte) 0);
        Assert.assertEquals((byte) 0, map1.get((char) 0));

        map1.put((char) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.get((char) 5));

        map1.put((char) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.get((char) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((char) 0));

        map1.put((char) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getOrThrow((char) 1));

        map1.put((char) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getOrThrow((char) 5));

        map1.put((char) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getOrThrow((char) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((char) 0, (byte) 5));

        Assert.assertEquals((byte) 6, map1.getIfAbsent((char) 1, (byte) 6));
        Assert.assertEquals((byte) 6, map1.getIfAbsent((char) 33, (byte) 6));

        map1.put((char) 0, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((char) 0, (byte) 5));

        map1.put((char) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map1.getIfAbsent((char) 1, (byte) 5));

        map1.put((char) 5, (byte) 5);
        Assert.assertEquals((byte) 5, map1.getIfAbsent((char) 5, (byte) 6));

        map1.put((char) 35, (byte) 35);
        Assert.assertEquals((byte) 35, map1.getIfAbsent((char) 35, (byte) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableCharByteMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals((byte) 0, map1.get((char) 0));
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals((byte) 0, map1.get((char) 0));

        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals((byte) 0, map1.get((char) 1));

        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals((byte) 0, map1.get((char) 31));

        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals((byte) 0, map1.get((char) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableCharByteMap map1 = this.classUnderTest();

        map1.put((char) 35, (byte) 35);
        Assert.assertTrue(map1.containsValue((byte) 35));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue((byte) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableCharByteMap map1 = this.classUnderTest();

        map1.put((char) 35, (byte) 35);
        Assert.assertTrue(map1.contains((byte) 35));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains((byte) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableCharByteMap hashMap1 = this.newWithKeysValues((char) 1, (byte) 1, (char) 0, (byte) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableCharByteMap hashMap = this.newWithKeysValues((char) 6, (byte) 6, (char) 5, (byte) 5);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions()
    {
        CharArrayList collisions = new CharArrayList();
        CharByteHashMap hashMap = new CharByteHashMap();
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
        MutableCharByteMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharByteHashMap(), map1);

        map1.put((char) 1, (byte) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new CharByteHashMap(), map1);

        map1.put((char) 33, (byte) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 0), map1);
        map1.clear();
        Assert.assertEquals(new CharByteHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableCharByteMap map0 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharByteHashMap(), map0);

        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharByteHashMap(), map1);

        MutableCharByteMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableCharByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableCharByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableCharByteMap map0 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map0.remove((char) 1);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharByteHashMap(), map0);

        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        map1.remove((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharByteHashMap(), map1);

        MutableCharByteMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals((byte) 1, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableCharByteMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((byte) 0, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableCharByteMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableCharByteMap map0 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        Assert.assertEquals((byte) 1, map0.removeKeyIfAbsent((char) 1, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map0);
        Assert.assertEquals((byte) 0, map0.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map0);
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((char) 1, (byte) 100));
        Assert.assertEquals((byte) 100, map0.removeKeyIfAbsent((char) 0, (byte) 100));

        MutableCharByteMap map1 = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1);
        Assert.assertEquals((byte) 0, map1.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map1);
        Assert.assertEquals((byte) 1, map1.removeKeyIfAbsent((char) 1, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map1);
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map1.removeKeyIfAbsent((char) 1, (byte) 100));

        MutableCharByteMap map2 = this.classUnderTest();
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 5, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 50, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 0, map2.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 31, (byte) 31, (char) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 31, map2.removeKeyIfAbsent((char) 31, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map2);
        Assert.assertEquals((byte) 32, map2.removeKeyIfAbsent((char) 32, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map2);
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 0, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 31, (byte) 100));
        Assert.assertEquals((byte) 100, map2.removeKeyIfAbsent((char) 32, (byte) 100));
        Assert.assertEquals(new CharByteHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 1);
        map2.put(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((byte) 1, map2.removeKeyIfAbsent(AbstractMutableCharByteMapTestCase.generateCollisions().get(0), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((byte) 2, map2.removeKeyIfAbsent(AbstractMutableCharByteMapTestCase.generateCollisions().get(1), (byte) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableCharByteMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableCharByteMap map1 = this.classUnderTest();
        map1.put((char) 0, (byte) 1);
        map1.put((char) 31, (byte) 32);
        map1.put((char) 32, (byte) 33);
        CharByteHashMap expected = CharByteHashMap.newWithKeysValues((char) 0, (byte) 1, (char) 31, (byte) 32, (char) 32, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.put((char) 1, (byte) 2);
        expected.put((char) 1, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.put((char) 33, (byte) 34);
        expected.put((char) 33, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.put((char) 30, (byte) 31);
        expected.put((char) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableCharByteMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, (byte) 1));
        map1.putPair(PrimitiveTuples.pair((char) 31, (byte) 32));
        map1.putPair(PrimitiveTuples.pair((char) 32, (byte) 33));
        CharByteHashMap expected = CharByteHashMap.newWithKeysValues((char) 0, (byte) 1, (char) 31, (byte) 32, (char) 32, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 1, (byte) 2));
        expected.put((char) 1, (byte) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 33, (byte) 34));
        expected.put((char) 33, (byte) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 30, (byte) 31));
        expected.put((char) 30, (byte) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((char) 0, (byte) 1));
        Assert.assertEquals(32L, map1.addToValue((char) 31, (byte) 32));
        Assert.assertEquals(3L, map1.addToValue((char) 1, (byte) 3));
        Assert.assertEquals(11L, map1.addToValue((char) 0, (byte) 10));
        Assert.assertEquals(12L, map1.addToValue((char) 1, (byte) 9));
        Assert.assertEquals(37L, map1.addToValue((char) 31, (byte) 5));
        Assert.assertEquals(33L, map1.addToValue((char) 32, (byte) 33));
        CharByteHashMap expected = CharByteHashMap.newWithKeysValues((char) 0, (byte) 11, (char) 1, (byte) 12, (char) 31, (byte) 37, (char) 32, (byte) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5L, map1.addToValue((char) 31, (byte) 5));
        Assert.assertEquals(37L, map1.addToValue((char) 31, (byte) 32));
        Assert.assertEquals(33L, map1.addToValue((char) 32, (byte) 33));
        Assert.assertEquals(3L, map1.addToValue((char) 1, (byte) 3));
        Assert.assertEquals(1L, map1.addToValue((char) 0, (byte) 1));
        Assert.assertEquals(12L, map1.addToValue((char) 1, (byte) 9));
        Assert.assertEquals(11L, map1.addToValue((char) 0, (byte) 10));
        Assert.assertEquals(expected, map1);

        MutableCharByteMap map2 = this.getEmptyMap();
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
            byte v = (byte) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        CharByteHashMap hashMap = new CharByteHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((char) i));
            hashMap.put((char) i, (byte) i);
            Assert.assertEquals((byte) i, hashMap.get((char) i));
            hashMap.remove((char) i);
            Assert.assertEquals((byte) 0, hashMap.get((char) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        char collision1 = AbstractMutableCharByteMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharByteMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharByteMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharByteMapTestCase.generateCollisions().get(3);

        MutableCharByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
        hashMap.put(collision2, (byte) 2);
        hashMap.put(collision3, (byte) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues(collision1, (byte) 1, collision3, (byte) 3, collision4, (byte) 4), hashMap);

        MutableCharByteMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (byte) 1);
        hashMap1.put(collision2, (byte) 2);
        hashMap1.put(collision3, (byte) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues(collision2, (byte) 2, collision3, (byte) 3, collision4, (byte) 4), hashMap1);

        MutableCharByteMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (byte) 1);
        hashMap2.put(collision2, (byte) 2);
        hashMap2.put(collision3, (byte) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues(collision1, (byte) 1, collision2, (byte) 2, collision4, (byte) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, (byte) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((char) 1, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 50, (char) 1, (byte) 50), map1);

        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 1, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, (byte) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((char) 0, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 50, (char) 1, (byte) 50), map2);

        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, (byte) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((char) 32, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 50), map3);

        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, (byte) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((char) 33, (byte) 100));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        ByteFunction0 factory = () -> (byte) 100;
        ByteFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 100, (char) 1, (byte) 100), map1);

        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 1, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((char) 0, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 100, (char) 1, (byte) 100), map2);

        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((char) 32, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 100), map3);

        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((char) 33, factoryThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();
        ByteFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 9), map1);
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 9, (char) 1, (byte) 9), map1);

        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 9), map2);
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 9, (char) 1, (byte) 9), map2);

        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 9), map3);

        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"));
        Assert.assertEquals((byte) 9, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToByteFunction function = (char charParameter) -> (byte) charParameter;
        CharToByteFunction functionThrows = (char charParameter) -> { throw new AssertionError(); };

        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1), map1);

        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((char) 1, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((char) 0, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1), map2);

        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((char) 32, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 32, (byte) 32), map3);

        MutableCharByteMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((char) 33, functionThrows));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 33), map4);
    }

    @Test
    public void updateValue()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableCharByteMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2, (char) 1, (byte) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2, (char) 1, (byte) 2), map1);

        MutableCharByteMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 1, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 1, (char) 1, (byte) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((char) 0, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 2, (char) 1, (byte) 2), map2);

        MutableCharByteMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((char) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((char) 33, (byte) 0, incrementFunction));
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 33, (byte) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableCharByteMap mutableCharByteMap = this.classUnderTest();
        CharSet frozenSet = mutableCharByteMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharByteMap.put((char) i, (byte) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        CharSet frozenSetForRemove = mutableCharByteMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharByteMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharByteMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharByteMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableCharByteMap mutableCharByteMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharByteMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharByteMapForClear.keySet().toArray());
        mutableCharByteMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableCharByteMap map = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 31, (byte) 31, (char) 32, (byte) 32);
        MutableCharByteMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableCharByteMap map = this.newWithKeysValues((char) 0, (byte) 0, (char) 1, (byte) 1, (char) 31, (byte) 31, (char) 32, (byte) 32);
        MutableCharByteMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 31, (byte) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableCharByteMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, (byte) 1), hashMap);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedCharByteMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharByteMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableCharByteMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharByteMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void byteIterator_with_remove()
    {
        MutableCharByteMap mutableMap = this.classUnderTest();
        MutableByteIterator iterator = mutableMap.byteIterator();

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
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableCharByteMap map = this.newWithKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5);
        Assert.assertEquals(
                ByteCharHashMap.newWithKeysValues((byte) 2, (char) 1, (byte) 3, (char) 2, (byte) 4, (char) 3, (byte) 5, (char) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 1).flipUniqueValues());
    }
}
