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

import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractByteFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableByteFloatMapTestCase extends AbstractByteFloatMapTestCase
{
    @Override
    protected abstract MutableByteFloatMap classUnderTest();

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1);

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2);

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3);

    @Override
    protected abstract MutableByteFloatMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3, byte key4, float value4);

    @Override
    protected abstract MutableByteFloatMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.get((byte) 0), 0.0);

        map1.put((byte) 0, 0.0f);
        Assert.assertEquals(0.0f, map1.get((byte) 0), 0.0);

        map1.put((byte) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.get((byte) 5), 0.0);

        map1.put((byte) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.get((byte) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((byte) 0));
        map1.put((byte) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((byte) 0), 0.0);

        map1.put((byte) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((byte) 1), 0.0);

        map1.put((byte) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow((byte) 5), 0.0);

        map1.put((byte) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow((byte) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertEquals(5.0f, map1.getIfAbsent((byte) 0, 5.0f), 0.0);

        Assert.assertEquals(6.0f, map1.getIfAbsent((byte) 1, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((byte) 33, 6.0f), 0.0);

        map1.put((byte) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((byte) 0, 5.0f), 0.0);

        map1.put((byte) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((byte) 1, 5.0f), 0.0);

        map1.put((byte) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent((byte) 5, 6.0f), 0.0);

        map1.put((byte) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent((byte) 35, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0.0f, map1.get((byte) 0), 0.0);
        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsKey((byte) 0));
        Assert.assertEquals(0.0f, map1.get((byte) 0), 0.0);

        map1.removeKey((byte) 1);
        Assert.assertFalse(map1.containsKey((byte) 1));
        Assert.assertEquals(0.0f, map1.get((byte) 1), 0.0);

        map1.removeKey((byte) 31);
        Assert.assertFalse(map1.containsKey((byte) 31));
        Assert.assertEquals(0.0f, map1.get((byte) 31), 0.0);

        map1.removeKey((byte) 32);
        Assert.assertFalse(map1.containsKey((byte) 32));
        Assert.assertEquals(0.0f, map1.get((byte) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableByteFloatMap map1 = this.classUnderTest();

        map1.put((byte) 35, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));

        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableByteFloatMap map1 = this.classUnderTest();

        map1.put((byte) 35, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));

        map1.removeKey((byte) 0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableByteFloatMap hashMap1 = this.newWithKeysValues((byte) 1, 1.0f, (byte) 0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((byte) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((byte) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableByteFloatMap hashMap = this.newWithKeysValues((byte) 6, 6.0f, (byte) 5, 5.0f);
        hashMap.removeKey((byte) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ByteArrayList generateCollisions()
    {
        ByteArrayList collisions = new ByteArrayList();
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
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
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ByteFloatHashMap(), map1);

        map1.put((byte) 1, 0.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ByteFloatHashMap(), map1);

        map1.put((byte) 33, 0.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ByteFloatHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableByteFloatMap map0 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map0.removeKey((byte) 1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map0);
        map0.removeKey((byte) 0);
        Assert.assertEquals(new ByteFloatHashMap(), map0);

        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map1.removeKey((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map1);
        map1.removeKey((byte) 1);
        Assert.assertEquals(new ByteFloatHashMap(), map1);

        MutableByteFloatMap map2 = this.classUnderTest();
        map2.removeKey((byte) 5);
        map2.removeKey((byte) 50);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.removeKey((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.removeKey((byte) 31);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map2);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        map2.removeKey((byte) 0);
        map2.removeKey((byte) 31);
        map2.removeKey((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableByteFloatMap map0 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map0.remove((byte) 1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map0);
        map0.remove((byte) 0);
        Assert.assertEquals(new ByteFloatHashMap(), map0);

        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        map1.remove((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map1);
        map1.remove((byte) 1);
        Assert.assertEquals(new ByteFloatHashMap(), map1);

        MutableByteFloatMap map2 = this.classUnderTest();
        map2.remove((byte) 5);
        map2.remove((byte) 50);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.remove((byte) 0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        map2.remove((byte) 31);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map2);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        map2.remove((byte) 0);
        map2.remove((byte) 31);
        map2.remove((byte) 32);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableByteFloatMap map0 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);

        MutableByteFloatMap map1 = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((byte) 1, 100.0f), 0.0);

        MutableByteFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 5, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 50, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 31, 31.0f, (byte) 32, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent((byte) 31, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent((byte) 32, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 31, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((byte) 32, 100.0f), 0.0);
        Assert.assertEquals(new ByteFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableByteFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.put((byte) 0, 1.0f);
        map1.put((byte) 31, 32.0f);
        map1.put((byte) 32, 33.0f);
        ByteFloatHashMap expected = ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f, (byte) 31, 32.0f, (byte) 32, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.put((byte) 1, 2.0f);
        expected.put((byte) 1, 2.0f);
        Assert.assertEquals(expected, map1);

        map1.put((byte) 33, 34.0f);
        expected.put((byte) 33, 34.0f);
        Assert.assertEquals(expected, map1);

        map1.put((byte) 30, 31.0f);
        expected.put((byte) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableByteFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((byte) 0, 1.0f));
        map1.putPair(PrimitiveTuples.pair((byte) 31, 32.0f));
        map1.putPair(PrimitiveTuples.pair((byte) 32, 33.0f));
        ByteFloatHashMap expected = ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f, (byte) 31, 32.0f, (byte) 32, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((byte) 1, 2.0f));
        expected.put((byte) 1, 2.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((byte) 33, 34.0f));
        expected.put((byte) 33, 34.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((byte) 30, 31.0f));
        expected.put((byte) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((byte) 0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((byte) 31, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((byte) 1, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((byte) 0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((byte) 1, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((byte) 31, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((byte) 32, 33.0f), 0.0);
        ByteFloatHashMap expected = ByteFloatHashMap.newWithKeysValues((byte) 0, 11.0f, (byte) 1, 12.0f, (byte) 31, 37.0f, (byte) 32, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.removeKey((byte) 0);
        map1.removeKey((byte) 1);
        map1.removeKey((byte) 31);
        map1.removeKey((byte) 32);
        Assert.assertEquals(5.0, map1.addToValue((byte) 31, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((byte) 31, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((byte) 32, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((byte) 1, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((byte) 0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((byte) 1, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((byte) 0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);

        MutableByteFloatMap map2 = this.getEmptyMap();
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
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((byte) i), 0.0);
            hashMap.put((byte) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((byte) i), 0.0);
            hashMap.remove((byte) i);
            Assert.assertEquals(0.0f, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        byte collision1 = AbstractMutableByteFloatMapTestCase.generateCollisions().getFirst();
        byte collision2 = AbstractMutableByteFloatMapTestCase.generateCollisions().get(1);
        byte collision3 = AbstractMutableByteFloatMapTestCase.generateCollisions().get(2);
        byte collision4 = AbstractMutableByteFloatMapTestCase.generateCollisions().get(3);

        MutableByteFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);

        MutableByteFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);

        MutableByteFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 50.0f, (byte) 1, 50.0f), map1);

        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 1, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((byte) 0, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 50.0f, (byte) 1, 50.0f), map2);

        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((byte) 32, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((byte) 32, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 50.0f), map3);

        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((byte) 33, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((byte) 33, 100.0f), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 0, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((byte) 1, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 100.0f, (byte) 1, 100.0f), map1);

        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 1, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((byte) 0, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 100.0f, (byte) 1, 100.0f), map2);

        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((byte) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((byte) 32, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 100.0f), map3);

        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((byte) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((byte) 33, factoryThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((byte) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 9.0f, (byte) 1, 9.0f), map1);

        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((byte) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 9.0f, (byte) 1, 9.0f), map2);

        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((byte) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((byte) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 9.0f), map3);

        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((byte) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((byte) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToFloatFunction function = (byte byteParameter) -> (float) byteParameter;
        ByteToFloatFunction functionThrows = (byte byteParameter) -> { throw new AssertionError(); };

        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((byte) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((byte) 0, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((byte) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((byte) 1, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f), map1);

        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((byte) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((byte) 1, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((byte) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((byte) 0, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f), map2);

        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((byte) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((byte) 32, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 32, 32.0f), map3);

        MutableByteFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((byte) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((byte) 33, functionThrows), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 33.0f), map4);
    }

    @Test
    public void updateValue()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableByteFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f, (byte) 1, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f, (byte) 1, 2.0f), map1);

        MutableByteFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((byte) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 1.0f, (byte) 1, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((byte) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 2.0f, (byte) 1, 2.0f), map2);

        MutableByteFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((byte) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue((byte) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 33, 2.0f), map3);
    }

    @Test
    public void freeze()
    {
        MutableByteFloatMap mutableByteFloatMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteFloatMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableByteFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableByteFloatMap.put((byte) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ByteSet frozenSetForRemove = mutableByteFloatMap.keySet().freeze();
        ByteSet frozenSetCopyForRemove = ByteHashSet.newSetWith(mutableByteFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableByteFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableByteFloatMap.remove((byte) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableByteFloatMap mutableByteFloatMapForClear = this.classUnderTest();
        ByteSet frozenSetForClear = mutableByteFloatMapForClear.keySet().freeze();
        ByteSet frozenSetCopyForClear = ByteHashSet.newSetWith(mutableByteFloatMapForClear.keySet().toArray());
        mutableByteFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 31, 31.0f, (byte) 32, 32.0f);
        MutableByteFloatMap mapWithout = map.withoutKey((byte) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 31, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 0, 0.0f, (byte) 1, 1.0f, (byte) 31, 31.0f, (byte) 32, 32.0f);
        MutableByteFloatMap mapWithout = map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 31, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableByteFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((byte) 1, 1.0f), hashMap);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedByteFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedByteFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableByteFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableByteFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove()
    {
        MutableByteFloatMap mutableMap = this.classUnderTest();
        MutableFloatIterator iterator = mutableMap.floatIterator();

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
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableFloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableByteFloatMap map = this.newWithKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f);
        Assert.assertEquals(
                FloatByteHashMap.newWithKeysValues(2.0f, (byte) 1, 3.0f, (byte) 2, 4.0f, (byte) 3, 5.0f, (byte) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 1.0f).flipUniqueValues());
    }
}
