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

import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.api.map.primitive.MutableFloatCharMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractFloatCharMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableFloatCharMapTestCase extends AbstractFloatCharMapTestCase
{
    @Override
    protected abstract MutableFloatCharMap classUnderTest();

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1);

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2);

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3);

    @Override
    protected abstract MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4);

    @Override
    protected abstract MutableFloatCharMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.put(0.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.get(0.0f));

        map1.put(0.0f, (char) 0);
        Assert.assertEquals((char) 0, map1.get(0.0f));

        map1.put(5.0f, (char) 5);
        Assert.assertEquals((char) 5, map1.get(5.0f));

        map1.put(35.0f, (char) 35);
        Assert.assertEquals((char) 35, map1.get(35.0f));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow(0.0f));
        map1.put(0.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(0.0f));

        map1.put(1.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getOrThrow(1.0f));

        map1.put(5.0f, (char) 5);
        Assert.assertEquals((char) 5, map1.getOrThrow(5.0f));

        map1.put(35.0f, (char) 35);
        Assert.assertEquals((char) 35, map1.getOrThrow(35.0f));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertEquals((char) 5, map1.getIfAbsent(0.0f, (char) 5));

        Assert.assertEquals((char) 6, map1.getIfAbsent(1.0f, (char) 6));
        Assert.assertEquals((char) 6, map1.getIfAbsent(33.0f, (char) 6));

        map1.put(0.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(0.0f, (char) 5));

        map1.put(1.0f, (char) 1);
        Assert.assertEquals((char) 1, map1.getIfAbsent(1.0f, (char) 5));

        map1.put(5.0f, (char) 5);
        Assert.assertEquals((char) 5, map1.getIfAbsent(5.0f, (char) 6));

        map1.put(35.0f, (char) 35);
        Assert.assertEquals((char) 35, map1.getIfAbsent(35.0f, (char) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((char) 0, map1.get(0.0f));
        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsKey(0.0f));
        Assert.assertEquals((char) 0, map1.get(0.0f));

        map1.removeKey(1.0f);
        Assert.assertFalse(map1.containsKey(1.0f));
        Assert.assertEquals((char) 0, map1.get(1.0f));

        map1.removeKey(31.0f);
        Assert.assertFalse(map1.containsKey(31.0f));
        Assert.assertEquals((char) 0, map1.get(31.0f));

        map1.removeKey(32.0f);
        Assert.assertFalse(map1.containsKey(32.0f));
        Assert.assertEquals((char) 0, map1.get(32.0f));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableFloatCharMap map1 = this.classUnderTest();

        map1.put(35.0f, (char) 35);
        Assert.assertTrue(map1.containsValue((char) 35));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.containsValue((char) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableFloatCharMap map1 = this.classUnderTest();

        map1.put(35.0f, (char) 35);
        Assert.assertTrue(map1.contains((char) 35));

        map1.removeKey(0.0f);
        Assert.assertFalse(map1.contains((char) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableFloatCharMap hashMap1 = this.newWithKeysValues(1.0f, (char) 1, 0.0f, (char) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey(1.0f);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey(0.0f);
        Assert.assertEquals(0, hashMap1.size());

        MutableFloatCharMap hashMap = this.newWithKeysValues(6.0f, (char) 6, 5.0f, (char) 5);
        hashMap.removeKey(5.0f);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static FloatArrayList generateCollisions()
    {
        FloatArrayList collisions = new FloatArrayList();
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (float each = 2.0f; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask(2.0f))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new FloatCharHashMap(), map1);

        map1.put(1.0f, (char) 0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatCharHashMap(), map1);

        map1.put(33.0f, (char) 0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 0), map1);
        map1.clear();
        Assert.assertEquals(new FloatCharHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableFloatCharMap map0 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map0.removeKey(1.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map0);
        map0.removeKey(0.0f);
        Assert.assertEquals(new FloatCharHashMap(), map0);

        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map1.removeKey(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map1);
        map1.removeKey(1.0f);
        Assert.assertEquals(new FloatCharHashMap(), map1);

        MutableFloatCharMap map2 = this.classUnderTest();
        map2.removeKey(5.0f);
        map2.removeKey(50.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.removeKey(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.removeKey(31.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map2);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        map2.removeKey(0.0f);
        map2.removeKey(31.0f);
        map2.removeKey(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableFloatCharMap map0 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map0.remove(1.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map0);
        map0.remove(0.0f);
        Assert.assertEquals(new FloatCharHashMap(), map0);

        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        map1.remove(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map1);
        map1.remove(1.0f);
        Assert.assertEquals(new FloatCharHashMap(), map1);

        MutableFloatCharMap map2 = this.classUnderTest();
        map2.remove(5.0f);
        map2.remove(50.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.remove(0.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(31.0f, (char) 31, 32.0f, (char) 32), map2);
        map2.remove(31.0f);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map2);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        map2.remove(0.0f);
        map2.remove(31.0f);
        map2.remove(32.0f);
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableFloatCharMap map0 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        Assert.assertEquals((char) 1, map0.removeKeyIfAbsent(1.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map0);
        Assert.assertEquals((char) 0, map0.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map0);
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(1.0f, (char) 100));
        Assert.assertEquals((char) 100, map0.removeKeyIfAbsent(0.0f, (char) 100));

        MutableFloatCharMap map1 = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1);
        Assert.assertEquals((char) 0, map1.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map1);
        Assert.assertEquals((char) 1, map1.removeKeyIfAbsent(1.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map1);
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals((char) 100, map1.removeKeyIfAbsent(1.0f, (char) 100));

        MutableFloatCharMap map2 = this.classUnderTest();
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(5.0f, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(50.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32), map2);
        Assert.assertEquals((char) 0, map2.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(31.0f, (char) 31, 32.0f, (char) 32), map2);
        Assert.assertEquals((char) 31, map2.removeKeyIfAbsent(31.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map2);
        Assert.assertEquals((char) 32, map2.removeKeyIfAbsent(32.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(0.0f, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(31.0f, (char) 100));
        Assert.assertEquals((char) 100, map2.removeKeyIfAbsent(32.0f, (char) 100));
        Assert.assertEquals(new FloatCharHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 1);
        map2.put(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((char) 1, map2.removeKeyIfAbsent(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((char) 2, map2.removeKeyIfAbsent(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1), (char) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableFloatCharMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.put(0.0f, (char) 1);
        map1.put(31.0f, (char) 32);
        map1.put(32.0f, (char) 33);
        FloatCharHashMap expected = FloatCharHashMap.newWithKeysValues(0.0f, (char) 1, 31.0f, (char) 32, 32.0f, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.put(1.0f, (char) 2);
        expected.put(1.0f, (char) 2);
        Assert.assertEquals(expected, map1);

        map1.put(33.0f, (char) 34);
        expected.put(33.0f, (char) 34);
        Assert.assertEquals(expected, map1);

        map1.put(30.0f, (char) 31);
        expected.put(30.0f, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableFloatCharMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair(0.0f, (char) 1));
        map1.putPair(PrimitiveTuples.pair(31.0f, (char) 32));
        map1.putPair(PrimitiveTuples.pair(32.0f, (char) 33));
        FloatCharHashMap expected = FloatCharHashMap.newWithKeysValues(0.0f, (char) 1, 31.0f, (char) 32, 32.0f, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(1.0f, (char) 2));
        expected.put(1.0f, (char) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(33.0f, (char) 34));
        expected.put(33.0f, (char) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair(30.0f, (char) 31));
        expected.put(30.0f, (char) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0.0f, (char) 1));
        Assert.assertEquals(32L, map1.addToValue(31.0f, (char) 32));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (char) 3));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (char) 10));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (char) 9));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (char) 5));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (char) 33));
        FloatCharHashMap expected = FloatCharHashMap.newWithKeysValues(0.0f, (char) 11, 1.0f, (char) 12, 31.0f, (char) 37, 32.0f, (char) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey(0.0f);
        map1.removeKey(1.0f);
        map1.removeKey(31.0f);
        map1.removeKey(32.0f);
        Assert.assertEquals(5L, map1.addToValue(31.0f, (char) 5));
        Assert.assertEquals(37L, map1.addToValue(31.0f, (char) 32));
        Assert.assertEquals(33L, map1.addToValue(32.0f, (char) 33));
        Assert.assertEquals(3L, map1.addToValue(1.0f, (char) 3));
        Assert.assertEquals(1L, map1.addToValue(0.0f, (char) 1));
        Assert.assertEquals(12L, map1.addToValue(1.0f, (char) 9));
        Assert.assertEquals(11L, map1.addToValue(0.0f, (char) 10));
        Assert.assertEquals(expected, map1);

        MutableFloatCharMap map2 = this.getEmptyMap();
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
            float k = each;
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((float) i));
            hashMap.put((float) i, (char) i);
            Assert.assertEquals((char) i, hashMap.get((float) i));
            hashMap.remove((float) i);
            Assert.assertEquals((char) 0, hashMap.get((float) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatCharMapTestCase.generateCollisions().getFirst();
        float collision2 = AbstractMutableFloatCharMapTestCase.generateCollisions().get(1);
        float collision3 = AbstractMutableFloatCharMapTestCase.generateCollisions().get(2);
        float collision4 = AbstractMutableFloatCharMapTestCase.generateCollisions().get(3);

        MutableFloatCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);

        MutableFloatCharMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);

        MutableFloatCharMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (char) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 50, 1.0f, (char) 50), map1);

        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (char) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 50, 1.0f, (char) 50), map2);

        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (char) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut(32.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 50), map3);

        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (char) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut(33.0f, (char) 100));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        CharFunction0 factory = () -> (char) 100;
        CharFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 100, 1.0f, (char) 100), map1);

        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 100, 1.0f, (char) 100), map2);

        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(32.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 100), map3);

        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut(33.0f, factoryThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();
        CharFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 9, 1.0f, (char) 9), map1);

        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 9, 1.0f, (char) 9), map2);

        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(32.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 9), map3);

        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33.0f, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map4.getIfAbsentPutWith(33.0f, functionThrows, "unused"));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToCharFunction function = (float floatParameter) -> (char) floatParameter;
        FloatToCharFunction functionThrows = (float floatParameter) -> { throw new AssertionError(); };

        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1), map1);

        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1), map2);

        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(32.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(32.0f, (char) 32), map3);

        MutableFloatCharMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey(33.0f, functionThrows));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 33), map4);
    }

    @Test
    public void updateValue()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableFloatCharMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2), map1);
        Assert.assertEquals(1L, map1.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2, 1.0f, (char) 1), map1);
        Assert.assertEquals(2L, map1.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2, 1.0f, (char) 2), map1);

        MutableFloatCharMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), map2);
        Assert.assertEquals(2L, map2.updateValue(1.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 2), map2);
        Assert.assertEquals(1L, map2.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 1, 1.0f, (char) 2), map2);
        Assert.assertEquals(2L, map2.updateValue(0.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 2, 1.0f, (char) 2), map2);

        MutableFloatCharMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(33.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 1), map3);
        Assert.assertEquals(2L, map3.updateValue(33.0f, (char) 0, incrementFunction));
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(33.0f, (char) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableFloatCharMap mutableFloatCharMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatCharMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableFloatCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatCharMap.put((float) i, (char) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        FloatSet frozenSetForRemove = mutableFloatCharMap.keySet().freeze();
        FloatSet frozenSetCopyForRemove = FloatHashSet.newSetWith(mutableFloatCharMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableFloatCharMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableFloatCharMap.remove((float) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableFloatCharMap mutableFloatCharMapForClear = this.classUnderTest();
        FloatSet frozenSetForClear = mutableFloatCharMapForClear.keySet().freeze();
        FloatSet frozenSetCopyForClear = FloatHashSet.newSetWith(mutableFloatCharMapForClear.keySet().toArray());
        mutableFloatCharMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableFloatCharMap map = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 31.0f, (char) 31, 32.0f, (char) 32);
        MutableFloatCharMap mapWithout = map.withoutKey(32.0f);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 31.0f, (char) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableFloatCharMap map = this.newWithKeysValues(0.0f, (char) 0, 1.0f, (char) 1, 31.0f, (char) 31, 32.0f, (char) 32);
        MutableFloatCharMap mapWithout = map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 31.0f, (char) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableFloatCharMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue(1.0f, (char) 1), hashMap);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedFloatCharMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedFloatCharMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableFloatCharMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableFloatCharMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void charIterator_with_remove()
    {
        MutableFloatCharMap mutableMap = this.classUnderTest();
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
        MutableFloatCharMap map = this.newWithKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5);
        Assert.assertEquals(
                CharFloatHashMap.newWithKeysValues((char) 2, 1.0f, (char) 3, 2.0f, (char) 4, 3.0f, (char) 5, 4.0f),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 1).flipUniqueValues());
    }
}
