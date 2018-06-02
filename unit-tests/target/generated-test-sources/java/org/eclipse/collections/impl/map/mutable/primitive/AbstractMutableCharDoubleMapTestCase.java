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

import org.eclipse.collections.api.block.function.primitive.CharToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractCharDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableCharDoubleMapTestCase extends AbstractCharDoubleMapTestCase
{
    @Override
    protected abstract MutableCharDoubleMap classUnderTest();

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1);

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2);

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3);

    @Override
    protected abstract MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4);

    @Override
    protected abstract MutableCharDoubleMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.put((char) 0, 1.0);
        Assert.assertEquals(1.0, map1.get((char) 0), 0.0);

        map1.put((char) 0, 0.0);
        Assert.assertEquals(0.0, map1.get((char) 0), 0.0);

        map1.put((char) 5, 5.0);
        Assert.assertEquals(5.0, map1.get((char) 5), 0.0);

        map1.put((char) 35, 35.0);
        Assert.assertEquals(35.0, map1.get((char) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((char) 0));
        map1.put((char) 0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((char) 0), 0.0);

        map1.put((char) 1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((char) 1), 0.0);

        map1.put((char) 5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow((char) 5), 0.0);

        map1.put((char) 35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow((char) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertEquals(5.0, map1.getIfAbsent((char) 0, 5.0), 0.0);

        Assert.assertEquals(6.0, map1.getIfAbsent((char) 1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((char) 33, 6.0), 0.0);

        map1.put((char) 0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((char) 0, 5.0), 0.0);

        map1.put((char) 1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((char) 1, 5.0), 0.0);

        map1.put((char) 5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent((char) 5, 6.0), 0.0);

        map1.put((char) 35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent((char) 35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0.0, map1.get((char) 0), 0.0);
        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsKey((char) 0));
        Assert.assertEquals(0.0, map1.get((char) 0), 0.0);

        map1.removeKey((char) 1);
        Assert.assertFalse(map1.containsKey((char) 1));
        Assert.assertEquals(0.0, map1.get((char) 1), 0.0);

        map1.removeKey((char) 31);
        Assert.assertFalse(map1.containsKey((char) 31));
        Assert.assertEquals(0.0, map1.get((char) 31), 0.0);

        map1.removeKey((char) 32);
        Assert.assertFalse(map1.containsKey((char) 32));
        Assert.assertEquals(0.0, map1.get((char) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableCharDoubleMap map1 = this.classUnderTest();

        map1.put((char) 35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableCharDoubleMap map1 = this.classUnderTest();

        map1.put((char) 35, 35.0);
        Assert.assertTrue(map1.contains(35.0));

        map1.removeKey((char) 0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableCharDoubleMap hashMap1 = this.newWithKeysValues((char) 1, 1.0, (char) 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((char) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((char) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableCharDoubleMap hashMap = this.newWithKeysValues((char) 6, 6.0, (char) 5, 5.0);
        hashMap.removeKey((char) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static CharArrayList generateCollisions()
    {
        CharArrayList collisions = new CharArrayList();
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
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
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new CharDoubleHashMap(), map1);

        map1.put((char) 1, 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new CharDoubleHashMap(), map1);

        map1.put((char) 33, 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new CharDoubleHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableCharDoubleMap map0 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map0.removeKey((char) 1);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map0);
        map0.removeKey((char) 0);
        Assert.assertEquals(new CharDoubleHashMap(), map0);

        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map1.removeKey((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map1);
        map1.removeKey((char) 1);
        Assert.assertEquals(new CharDoubleHashMap(), map1);

        MutableCharDoubleMap map2 = this.classUnderTest();
        map2.removeKey((char) 5);
        map2.removeKey((char) 50);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0), map2);
        map2.removeKey((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 31, 31.0, (char) 32, 32.0), map2);
        map2.removeKey((char) 31);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map2);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        map2.removeKey((char) 0);
        map2.removeKey((char) 31);
        map2.removeKey((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableCharDoubleMap map0 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map0.remove((char) 1);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map0);
        map0.remove((char) 0);
        Assert.assertEquals(new CharDoubleHashMap(), map0);

        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        map1.remove((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map1);
        map1.remove((char) 1);
        Assert.assertEquals(new CharDoubleHashMap(), map1);

        MutableCharDoubleMap map2 = this.classUnderTest();
        map2.remove((char) 5);
        map2.remove((char) 50);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0), map2);
        map2.remove((char) 0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 31, 31.0, (char) 32, 32.0), map2);
        map2.remove((char) 31);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map2);
        map2.remove((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        map2.remove((char) 0);
        map2.remove((char) 31);
        map2.remove((char) 32);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableCharDoubleMap map0 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((char) 0, 100.0), 0.0);

        MutableCharDoubleMap map1 = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent((char) 1, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((char) 1, 100.0), 0.0);

        MutableCharDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 50, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 31, 31.0, (char) 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent((char) 31, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent((char) 32, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((char) 32, 100.0), 0.0);
        Assert.assertEquals(new CharDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.put((char) 0, 1.0);
        map1.put((char) 31, 32.0);
        map1.put((char) 32, 33.0);
        CharDoubleHashMap expected = CharDoubleHashMap.newWithKeysValues((char) 0, 1.0, (char) 31, 32.0, (char) 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.put((char) 1, 2.0);
        expected.put((char) 1, 2.0);
        Assert.assertEquals(expected, map1);

        map1.put((char) 33, 34.0);
        expected.put((char) 33, 34.0);
        Assert.assertEquals(expected, map1);

        map1.put((char) 30, 31.0);
        expected.put((char) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableCharDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((char) 0, 1.0));
        map1.putPair(PrimitiveTuples.pair((char) 31, 32.0));
        map1.putPair(PrimitiveTuples.pair((char) 32, 33.0));
        CharDoubleHashMap expected = CharDoubleHashMap.newWithKeysValues((char) 0, 1.0, (char) 31, 32.0, (char) 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 1, 2.0));
        expected.put((char) 1, 2.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 33, 34.0));
        expected.put((char) 33, 34.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((char) 30, 31.0));
        expected.put((char) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((char) 0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((char) 31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((char) 1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((char) 0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((char) 1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((char) 31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((char) 32, 33.0), 0.0);
        CharDoubleHashMap expected = CharDoubleHashMap.newWithKeysValues((char) 0, 11.0, (char) 1, 12.0, (char) 31, 37.0, (char) 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.removeKey((char) 0);
        map1.removeKey((char) 1);
        map1.removeKey((char) 31);
        map1.removeKey((char) 32);
        Assert.assertEquals(5.0, map1.addToValue((char) 31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((char) 31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((char) 32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((char) 1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((char) 0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((char) 1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((char) 0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);

        MutableCharDoubleMap map2 = this.getEmptyMap();
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
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((char) i), 0.0);
            hashMap.put((char) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((char) i), 0.0);
            hashMap.remove((char) i);
            Assert.assertEquals(0.0, hashMap.get((char) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        char collision1 = AbstractMutableCharDoubleMapTestCase.generateCollisions().getFirst();
        char collision2 = AbstractMutableCharDoubleMapTestCase.generateCollisions().get(1);
        char collision3 = AbstractMutableCharDoubleMapTestCase.generateCollisions().get(2);
        char collision4 = AbstractMutableCharDoubleMapTestCase.generateCollisions().get(3);

        MutableCharDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);

        MutableCharDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);

        MutableCharDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((char) 1, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 50.0, (char) 1, 50.0), map1);

        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 1, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((char) 0, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 50.0, (char) 1, 50.0), map2);

        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((char) 32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((char) 32, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 50.0), map3);

        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((char) 33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((char) 33, 100.0), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 0, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((char) 1, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 100.0, (char) 1, 100.0), map1);

        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 1, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((char) 0, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 100.0, (char) 1, 100.0), map2);

        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((char) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((char) 32, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 100.0), map3);

        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((char) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((char) 33, factoryThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((char) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 9.0, (char) 1, 9.0), map1);

        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((char) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 9.0, (char) 1, 9.0), map2);

        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((char) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((char) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 9.0), map3);

        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((char) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((char) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToDoubleFunction function = (char charParameter) -> (double) charParameter;
        CharToDoubleFunction functionThrows = (char charParameter) -> { throw new AssertionError(); };

        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((char) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((char) 0, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((char) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((char) 1, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0), map1);

        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((char) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((char) 1, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((char) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((char) 0, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0), map2);

        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((char) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((char) 32, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 32, 32.0), map3);

        MutableCharDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((char) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((char) 33, functionThrows), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 33.0), map4);
    }

    @Test
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableCharDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0, (char) 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0, (char) 1, 2.0), map1);

        MutableCharDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((char) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 1.0, (char) 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((char) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 2.0, (char) 1, 2.0), map2);

        MutableCharDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((char) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue((char) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 33, 2.0), map3);
    }

    @Test
    public void freeze()
    {
        MutableCharDoubleMap mutableCharDoubleMap = this.classUnderTest();
        CharSet frozenSet = mutableCharDoubleMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableCharDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharDoubleMap.put((char) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        CharSet frozenSetForRemove = mutableCharDoubleMap.keySet().freeze();
        CharSet frozenSetCopyForRemove = CharHashSet.newSetWith(mutableCharDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableCharDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableCharDoubleMap.remove((char) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableCharDoubleMap mutableCharDoubleMapForClear = this.classUnderTest();
        CharSet frozenSetForClear = mutableCharDoubleMapForClear.keySet().freeze();
        CharSet frozenSetCopyForClear = CharHashSet.newSetWith(mutableCharDoubleMapForClear.keySet().toArray());
        mutableCharDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 31, 31.0, (char) 32, 32.0);
        MutableCharDoubleMap mapWithout = map.withoutKey((char) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 0, 0.0, (char) 1, 1.0, (char) 31, 31.0, (char) 32, 32.0);
        MutableCharDoubleMap mapWithout = map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableCharDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((char) 1, 1.0), hashMap);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedCharDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedCharDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableCharDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableCharDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove()
    {
        MutableCharDoubleMap mutableMap = this.classUnderTest();
        MutableDoubleIterator iterator = mutableMap.doubleIterator();

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
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableDoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableCharDoubleMap map = this.newWithKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0);
        Assert.assertEquals(
                DoubleCharHashMap.newWithKeysValues(2.0, (char) 1, 3.0, (char) 2, 4.0, (char) 3, 5.0, (char) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((char) 1, 1.0, (char) 2, 1.0).flipUniqueValues());
    }
}
