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

import org.eclipse.collections.api.block.function.primitive.ByteToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableByteIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteIntMapTestCase extends AbstractByteIntMapTestCase
{
    @Override
    protected abstract MutableByteIntMap classUnderTest();

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1);

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2);

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3);

    @Override
    protected abstract MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3, byte key4, int value4);

    @Override
    protected abstract MutableByteIntMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1);
        Assert.assertEquals(1, map1.get((byte) 0));

        map1.put((byte) 0, 0);
        Assert.assertEquals(0, map1.get((byte) 0));

        map1.put((byte) 5, 5);
        Assert.assertEquals(5, map1.get((byte) 5));

        map1.put((byte) 35, 35);
        Assert.assertEquals(35, map1.get((byte) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, 1);
        Assert.assertEquals(1, map1.getOrThrow((byte) 0));

        map1.put((byte) 1, 1);
        Assert.assertEquals(1, map1.getOrThrow((byte) 1));

        map1.put((byte) 5, 5);
        Assert.assertEquals(5, map1.getOrThrow((byte) 5));

        map1.put((byte) 35, 35);
        Assert.assertEquals(35, map1.getOrThrow((byte) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals(5, map1.getIfAbsent((byte) 0, 5));

        Assert.assertEquals(6, map1.getIfAbsent((byte) 1, 6));
        Assert.assertEquals(6, map1.getIfAbsent((byte) 33, 6));

        map1.put((byte) 0, 1);
        Assert.assertEquals(1, map1.getIfAbsent((byte) 0, 5));

        map1.put((byte) 1, 1);
        Assert.assertEquals(1, map1.getIfAbsent((byte) 1, 5));

        map1.put((byte) 5, 5);
        Assert.assertEquals(5, map1.getIfAbsent((byte) 5, 6));

        map1.put((byte) 35, 35);
        Assert.assertEquals(35, map1.getIfAbsent((byte) 35, 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableByteIntMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0, map1.get((byte) 0));
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0, map1.get((byte) 0));

        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals(0, map1.get((byte) 1));

        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals(0, map1.get((byte) 31));

        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals(0, map1.get((byte) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableByteIntMap map1 = this.classUnderTest();

        map1.put((byte) 35, 35);
        Assert.assertTrue(map1.containsValue(35));

        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableByteIntMap map1 = this.classUnderTest();

        map1.put((byte) 35, 35);
        Assert.assertTrue(map1.contains(35));

        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableByteIntMap hashMap1 = this.newWithKeysValues((byte) 1, 1, (byte) 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableByteIntMap hashMap = this.newWithKeysValues((byte) 6, 6, (byte) 5, 5);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions()
    {
        ByteArrayList collisions = new ByteArrayList();
        ByteIntHashMap hashMap = new ByteIntHashMap();
        for (byte each = (byte) 2; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((byte) 2))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableByteIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteIntHashMap(), map1);

        map1.put((byte) 1, 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteIntHashMap(), map1);

        map1.put((byte) 33, 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 0), map1);
        map1.clear();
        Assert.assertEquals(new ByteIntHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableByteIntMap map0 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteIntHashMap(), map0);

        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteIntHashMap(), map1);

        MutableByteIntMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 31, 31, (byte) 32, 32), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableByteIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableByteIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableByteIntMap map0 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteIntHashMap(), map0);

        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteIntHashMap(), map1);

        MutableByteIntMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 31, 31, (byte) 32, 32), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableByteIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableByteIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableByteIntMap map0 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent((byte) 1, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(new ByteIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent((byte) 1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent((byte) 0, 100));

        MutableByteIntMap map1 = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent((byte) 1, 100));
        Assert.assertEquals(new ByteIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent((byte) 1, 100));

        MutableByteIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 50, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 31, 31, (byte) 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent((byte) 31, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent((byte) 32, 100));
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((byte) 32, 100));
        Assert.assertEquals(new ByteIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableByteIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableByteIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableByteIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableByteIntMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1);
        map1.put((byte) 31, 32);
        map1.put((byte) 32, 33);
        ByteIntHashMap expected = ByteIntHashMap.newWithKeysValues((byte) 0, 1, (byte) 31, 32, (byte) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.put((byte) 1, 2);
        expected.put((byte) 1, 2);
        Assert.assertEquals(expected, map1);

        map1.put((byte) 33, 34);
        expected.put((byte) 33, 34);
        Assert.assertEquals(expected, map1);

        map1.put((byte) 30, 31);
        expected.put((byte) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableByteIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, 1));
        map1.putPair(PrimitiveTuples.pair((byte) 31, 32));
        map1.putPair(PrimitiveTuples.pair((byte) 32, 33));
        ByteIntHashMap expected = ByteIntHashMap.newWithKeysValues((byte) 0, 1, (byte) 31, 32, (byte) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((byte) 1, 2));
        expected.put((byte) 1, 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((byte) 33, 34));
        expected.put((byte) 33, 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((byte) 30, 31));
        expected.put((byte) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((byte) 0, 1));
        Assert.assertEquals(32L, map1.addToValue((byte) 31, 32));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, 3));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, 10));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, 9));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, 5));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, 33));
        ByteIntHashMap expected = ByteIntHashMap.newWithKeysValues((byte) 0, 11, (byte) 1, 12, (byte) 31, 37, (byte) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5L, map1.addToValue((byte) 31, 5));
        Assert.assertEquals(37L, map1.addToValue((byte) 31, 32));
        Assert.assertEquals(33L, map1.addToValue((byte) 32, 33));
        Assert.assertEquals(3L, map1.addToValue((byte) 1, 3));
        Assert.assertEquals(1L, map1.addToValue((byte) 0, 1));
        Assert.assertEquals(12L, map1.addToValue((byte) 1, 9));
        Assert.assertEquals(11L, map1.addToValue((byte) 0, 10));
        Assert.assertEquals(expected, map1);

        MutableByteIntMap map2 = this.getEmptyMap();
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
            byte k = (byte) (each);
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        ByteIntHashMap hashMap = new ByteIntHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((byte) i));
            hashMap.put((byte) i, i);
            Assert.assertEquals(i, hashMap.get((byte) i));
            hashMap.remove((byte) i);
            Assert.assertEquals(0, hashMap.get((byte) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        byte collision1 = AbstractMutableByteIntMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteIntMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteIntMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteIntMapTestCase.generateCollisions().get(3);

        MutableByteIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);

        MutableByteIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);

        MutableByteIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((byte) 1, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 50, (byte) 1, 50), map1);

        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 1, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((byte) 0, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 50, (byte) 1, 50), map2);

        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((byte) 32, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 50), map3);

        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((byte) 33, 100));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 100, (byte) 1, 100), map1);

        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 1, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((byte) 0, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 100, (byte) 1, 100), map2);

        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((byte) 32, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 100), map3);

        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((byte) 33, factoryThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 9, (byte) 1, 9), map1);

        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 9, (byte) 1, 9), map2);

        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 9), map3);

        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToIntFunction function = (byte byteParameter) -> (int) byteParameter;
        ByteToIntFunction functionThrows = (byte byteParameter) -> { throw new AssertionError(); };

        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 1, 1), map1);

        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((byte) 1, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((byte) 0, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 1, 1), map2);

        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((byte) 32, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 32, 32), map3);

        MutableByteIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((byte) 33, functionThrows));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 33), map4);
    }

    @Test
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableByteIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map1);

        MutableByteIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 1, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 1, (byte) 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue((byte) 0, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 2, (byte) 1, 2), map2);

        MutableByteIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((byte) 33, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue((byte) 33, 0, incrementFunction));
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 33, 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableByteIntMap mutableByteIntMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteIntMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableByteIntMap.put((byte) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ByteSet frozenSetForRemove = mutableByteIntMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableByteIntMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableByteIntMap mutableByteIntMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteIntMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteIntMapForClear.keySet().toArray());
        mutableByteIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableByteIntMap map = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 31, 31, (byte) 32, 32);
        MutableByteIntMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableByteIntMap map = this.newWithKeysValues((byte) 0, 0, (byte) 1, 1, (byte) 31, 31, (byte) 32, 32);
        MutableByteIntMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableByteIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, 1), hashMap);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedByteIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableByteIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove()
    {
        MutableByteIntMap mutableMap = this.classUnderTest();
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
        MutableByteIntMap map = this.newWithKeysValues((byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4, 5);
        Assert.assertEquals(
                IntByteHashMap.newWithKeysValues(2, (byte) 1, 3, (byte) 2, 4, (byte) 3, 5, (byte) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((byte) 1, 1, (byte) 2, 1).flipUniqueValues());
    }
}
