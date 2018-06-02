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

import org.eclipse.collections.api.block.function.primitive.ShortToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.api.map.primitive.MutableShortFloatMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortFloatMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortFloatMapTestCase extends AbstractShortFloatMapTestCase
{
    @Override
    protected abstract MutableShortFloatMap classUnderTest();

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1);

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2);

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3);

    @Override
    protected abstract MutableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4);

    @Override
    protected abstract MutableShortFloatMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.get((short) 0), 0.0);

        map1.put((short) 0, 0.0f);
        Assert.assertEquals(0.0f, map1.get((short) 0), 0.0);

        map1.put((short) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.get((short) 5), 0.0);

        map1.put((short) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.get((short) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((short) 0), 0.0);

        map1.put((short) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getOrThrow((short) 1), 0.0);

        map1.put((short) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getOrThrow((short) 5), 0.0);

        map1.put((short) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getOrThrow((short) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5.0f, map1.getIfAbsent((short) 0, 5.0f), 0.0);

        Assert.assertEquals(6.0f, map1.getIfAbsent((short) 1, 6.0f), 0.0);
        Assert.assertEquals(6.0f, map1.getIfAbsent((short) 33, 6.0f), 0.0);

        map1.put((short) 0, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((short) 0, 5.0f), 0.0);

        map1.put((short) 1, 1.0f);
        Assert.assertEquals(1.0f, map1.getIfAbsent((short) 1, 5.0f), 0.0);

        map1.put((short) 5, 5.0f);
        Assert.assertEquals(5.0f, map1.getIfAbsent((short) 5, 6.0f), 0.0);

        map1.put((short) 35, 35.0f);
        Assert.assertEquals(35.0f, map1.getIfAbsent((short) 35, 5.0f), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0f, map1.get((short) 0), 0.0);
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0f, map1.get((short) 0), 0.0);

        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0.0f, map1.get((short) 1), 0.0);

        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0.0f, map1.get((short) 31), 0.0);

        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0.0f, map1.get((short) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableShortFloatMap map1 = this.classUnderTest();

        map1.put((short) 35, 35.0f);
        Assert.assertTrue(map1.containsValue(35.0f));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0.0f));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableShortFloatMap map1 = this.classUnderTest();

        map1.put((short) 35, 35.0f);
        Assert.assertTrue(map1.contains(35.0f));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0.0f));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableShortFloatMap hashMap1 = this.newWithKeysValues((short) 1, 1.0f, (short) 0, 0.0f);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableShortFloatMap hashMap = this.newWithKeysValues((short) 6, 6.0f, (short) 5, 5.0f);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        for (short each = (short) 2; collisions.size() <= 10; each++)
        {
            if (hashMap.spreadAndMask(each) == hashMap.spreadAndMask((short) 2))
            {
                collisions.add(each);
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortFloatHashMap(), map1);

        map1.put((short) 1, 0.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ShortFloatHashMap(), map1);

        map1.put((short) 33, 0.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 0.0f), map1);
        map1.clear();
        Assert.assertEquals(new ShortFloatHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableShortFloatMap map0 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortFloatHashMap(), map0);

        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortFloatHashMap(), map1);

        MutableShortFloatMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableShortFloatMap map0 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map0.remove((short) 1);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortFloatHashMap(), map0);

        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        map1.remove((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortFloatHashMap(), map1);

        MutableShortFloatMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 31, 31.0f, (short) 32, 32.0f), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0f, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableShortFloatMap map0 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        Assert.assertEquals(1.0f, map0.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map0);
        Assert.assertEquals(0.0f, map0.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map0.removeKeyIfAbsent((short) 0, 100.0f), 0.0);

        MutableShortFloatMap map1 = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f);
        Assert.assertEquals(0.0f, map1.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map1);
        Assert.assertEquals(1.0f, map1.removeKeyIfAbsent((short) 1, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map1);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map1.removeKeyIfAbsent((short) 1, 100.0f), 0.0);

        MutableShortFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 5, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 50, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f), map2);
        Assert.assertEquals(0.0f, map2.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 31, 31.0f, (short) 32, 32.0f), map2);
        Assert.assertEquals(31.0f, map2.removeKeyIfAbsent((short) 31, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map2);
        Assert.assertEquals(32.0f, map2.removeKeyIfAbsent((short) 32, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 0, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 31, 100.0f), 0.0);
        Assert.assertEquals(100.0f, map2.removeKeyIfAbsent((short) 32, 100.0f), 0.0);
        Assert.assertEquals(new ShortFloatHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 1.0f);
        map2.put(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 2.0f);

        Assert.assertEquals(1.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0f, map2.removeKeyIfAbsent(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0f, map2.removeKeyIfAbsent(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1), 100.0f), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortFloatMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0f);
        map1.put((short) 31, 32.0f);
        map1.put((short) 32, 33.0f);
        ShortFloatHashMap expected = ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f, (short) 31, 32.0f, (short) 32, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.put((short) 1, 2.0f);
        expected.put((short) 1, 2.0f);
        Assert.assertEquals(expected, map1);

        map1.put((short) 33, 34.0f);
        expected.put((short) 33, 34.0f);
        Assert.assertEquals(expected, map1);

        map1.put((short) 30, 31.0f);
        expected.put((short) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableShortFloatMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1.0f));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32.0f));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33.0f));
        ShortFloatHashMap expected = ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f, (short) 31, 32.0f, (short) 32, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 1, 2.0f));
        expected.put((short) 1, 2.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 33, 34.0f));
        expected.put((short) 33, 34.0f);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 30, 31.0f));
        expected.put((short) 30, 31.0f);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0f), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((short) 31, 32.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 5.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0f), 0.0);
        ShortFloatHashMap expected = ShortFloatHashMap.newWithKeysValues((short) 0, 11.0f, (short) 1, 12.0f, (short) 31, 37.0f, (short) 32, 33.0f);
        Assert.assertEquals(expected, map1);

        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5.0, map1.addToValue((short) 31, 5.0f), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 32.0f), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0f), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0f), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0f), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0f), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0f), 0.0);
        Assert.assertEquals(expected, map1);

        MutableShortFloatMap map2 = this.getEmptyMap();
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
            short k = (short) (each);
            float v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((short) i), 0.0);
            hashMap.put((short) i, (float) i);
            Assert.assertEquals((float) i, hashMap.get((short) i), 0.0);
            hashMap.remove((short) i);
            Assert.assertEquals(0.0f, hashMap.get((short) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortFloatMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortFloatMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortFloatMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortFloatMapTestCase.generateCollisions().get(3);

        MutableShortFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
        hashMap.put(collision2, 2.0f);
        hashMap.put(collision3, 3.0f);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues(collision1, 1.0f, collision3, 3.0f, collision4, 4.0f), hashMap);

        MutableShortFloatMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0f);
        hashMap1.put(collision2, 2.0f);
        hashMap1.put(collision3, 3.0f);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues(collision2, 2.0f, collision3, 3.0f, collision4, 4.0f), hashMap1);

        MutableShortFloatMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0f);
        hashMap2.put(collision2, 2.0f);
        hashMap2.put(collision3, 3.0f);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues(collision1, 1.0f, collision2, 2.0f, collision4, 4.0f), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 50.0f), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 50.0f, (short) 1, 50.0f), map1);

        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 50.0f), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 50.0f), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 50.0f, (short) 1, 50.0f), map2);

        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 50.0f), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 50.0f), map3);

        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 50.0f), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 100.0f), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 50.0f), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        FloatFunction0 factory = () -> 100.0f;
        FloatFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 100.0f), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 100.0f, (short) 1, 100.0f), map1);

        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 100.0f), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 100.0f, (short) 1, 100.0f), map2);

        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 100.0f), map3);

        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factoryThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 100.0f), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();
        FloatFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 9.0f), map1);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 9.0f, (short) 1, 9.0f), map1);

        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 9.0f), map2);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 9.0f, (short) 1, 9.0f), map2);

        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 9.0f), map3);

        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0f, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 9.0f), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToFloatFunction function = (short shortParameter) -> (float) shortParameter;
        ShortToFloatFunction functionThrows = (short shortParameter) -> { throw new AssertionError(); };

        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f), map1);

        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f), map2);

        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 32, 32.0f), map3);

        MutableShortFloatMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, functionThrows), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 33.0f), map4);
    }

    @Test
    public void updateValue()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableShortFloatMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f), map1);
        Assert.assertEquals(1.0, map1.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f, (short) 1, 1.0f), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f, (short) 1, 2.0f), map1);

        MutableShortFloatMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 1, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 2.0f), map2);
        Assert.assertEquals(1.0, map2.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 1.0f, (short) 1, 2.0f), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 0, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 2.0f, (short) 1, 2.0f), map2);

        MutableShortFloatMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((short) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 1.0f), map3);
        Assert.assertEquals(2.0, map3.updateValue((short) 33, 0.0f, incrementFunction), 0.0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 33, 2.0f), map3);
    }

    @Test
    public void freeze()
    {
        MutableShortFloatMap mutableShortFloatMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortFloatMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortFloatMap.put((short) i, (float) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ShortSet frozenSetForRemove = mutableShortFloatMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortFloatMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortFloatMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableShortFloatMap mutableShortFloatMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortFloatMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortFloatMapForClear.keySet().toArray());
        mutableShortFloatMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 31, 31.0f, (short) 32, 32.0f);
        MutableShortFloatMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 31, 31.0f), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableShortFloatMap map = this.newWithKeysValues((short) 0, 0.0f, (short) 1, 1.0f, (short) 31, 31.0f, (short) 32, 32.0f);
        MutableShortFloatMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 31, 31.0f), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableShortFloatMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1.0f), hashMap);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortFloatMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortFloatMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortFloatMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortFloatMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void floatIterator_with_remove()
    {
        MutableShortFloatMap mutableMap = this.classUnderTest();
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
        MutableShortFloatMap map = this.newWithKeysValues((short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4, 5.0f);
        Assert.assertEquals(
                FloatShortHashMap.newWithKeysValues(2.0f, (short) 1, 3.0f, (short) 2, 4.0f, (short) 3, 5.0f, (short) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((short) 1, 1.0f, (short) 2, 1.0f).flipUniqueValues());
    }
}
