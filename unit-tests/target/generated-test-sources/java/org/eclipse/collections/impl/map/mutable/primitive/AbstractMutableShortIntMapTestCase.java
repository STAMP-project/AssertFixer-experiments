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

import org.eclipse.collections.api.block.function.primitive.ShortToIntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortIntMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortIntMapTestCase extends AbstractShortIntMapTestCase
{
    @Override
    protected abstract MutableShortIntMap classUnderTest();

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1);

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2);

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3);

    @Override
    protected abstract MutableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4);

    @Override
    protected abstract MutableShortIntMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.put((short) 0, 1);
        Assert.assertEquals(1, map1.get((short) 0));

        map1.put((short) 0, 0);
        Assert.assertEquals(0, map1.get((short) 0));

        map1.put((short) 5, 5);
        Assert.assertEquals(5, map1.get((short) 5));

        map1.put((short) 35, 35);
        Assert.assertEquals(35, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1);
        Assert.assertEquals(1, map1.getOrThrow((short) 0));

        map1.put((short) 1, 1);
        Assert.assertEquals(1, map1.getOrThrow((short) 1));

        map1.put((short) 5, 5);
        Assert.assertEquals(5, map1.getOrThrow((short) 5));

        map1.put((short) 35, 35);
        Assert.assertEquals(35, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5, map1.getIfAbsent((short) 0, 5));

        Assert.assertEquals(6, map1.getIfAbsent((short) 1, 6));
        Assert.assertEquals(6, map1.getIfAbsent((short) 33, 6));

        map1.put((short) 0, 1);
        Assert.assertEquals(1, map1.getIfAbsent((short) 0, 5));

        map1.put((short) 1, 1);
        Assert.assertEquals(1, map1.getIfAbsent((short) 1, 5));

        map1.put((short) 5, 5);
        Assert.assertEquals(5, map1.getIfAbsent((short) 5, 6));

        map1.put((short) 35, 35);
        Assert.assertEquals(35, map1.getIfAbsent((short) 35, 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableShortIntMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0, map1.get((short) 0));

        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0, map1.get((short) 1));

        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0, map1.get((short) 31));

        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableShortIntMap map1 = this.classUnderTest();

        map1.put((short) 35, 35);
        Assert.assertTrue(map1.containsValue(35));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableShortIntMap map1 = this.classUnderTest();

        map1.put((short) 35, 35);
        Assert.assertTrue(map1.contains(35));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableShortIntMap hashMap1 = this.newWithKeysValues((short) 1, 1, (short) 0, 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableShortIntMap hashMap = this.newWithKeysValues((short) 6, 6, (short) 5, 5);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortIntHashMap hashMap = new ShortIntHashMap();
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
        MutableShortIntMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortIntHashMap(), map1);

        map1.put((short) 1, 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortIntHashMap(), map1);

        map1.put((short) 33, 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortIntHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableShortIntMap map0 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortIntHashMap(), map0);

        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortIntHashMap(), map1);

        MutableShortIntMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 31, 31, (short) 32, 32), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableShortIntMap map0 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map0.remove((short) 1);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortIntHashMap(), map0);

        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        map1.remove((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortIntHashMap(), map1);

        MutableShortIntMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 31, 31, (short) 32, 32), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortIntMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortIntMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableShortIntMap map0 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        Assert.assertEquals(1, map0.removeKeyIfAbsent((short) 1, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map0);
        Assert.assertEquals(0, map0.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(new ShortIntHashMap(), map0);
        Assert.assertEquals(100, map0.removeKeyIfAbsent((short) 1, 100));
        Assert.assertEquals(100, map0.removeKeyIfAbsent((short) 0, 100));

        MutableShortIntMap map1 = this.newWithKeysValues((short) 0, 0, (short) 1, 1);
        Assert.assertEquals(0, map1.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map1);
        Assert.assertEquals(1, map1.removeKeyIfAbsent((short) 1, 100));
        Assert.assertEquals(new ShortIntHashMap(), map1);
        Assert.assertEquals(100, map1.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(100, map1.removeKeyIfAbsent((short) 1, 100));

        MutableShortIntMap map2 = this.classUnderTest();
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 5, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 50, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32), map2);
        Assert.assertEquals(0, map2.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 31, 31, (short) 32, 32), map2);
        Assert.assertEquals(31, map2.removeKeyIfAbsent((short) 31, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map2);
        Assert.assertEquals(32, map2.removeKeyIfAbsent((short) 32, 100));
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 0, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 31, 100));
        Assert.assertEquals(100, map2.removeKeyIfAbsent((short) 32, 100));
        Assert.assertEquals(new ShortIntHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 1);
        map2.put(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1, map2.removeKeyIfAbsent(AbstractMutableShortIntMapTestCase.generateCollisions().get(0), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2, map2.removeKeyIfAbsent(AbstractMutableShortIntMapTestCase.generateCollisions().get(1), 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortIntMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableShortIntMap map1 = this.classUnderTest();
        map1.put((short) 0, 1);
        map1.put((short) 31, 32);
        map1.put((short) 32, 33);
        ShortIntHashMap expected = ShortIntHashMap.newWithKeysValues((short) 0, 1, (short) 31, 32, (short) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.put((short) 1, 2);
        expected.put((short) 1, 2);
        Assert.assertEquals(expected, map1);

        map1.put((short) 33, 34);
        expected.put((short) 33, 34);
        Assert.assertEquals(expected, map1);

        map1.put((short) 30, 31);
        expected.put((short) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableShortIntMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33));
        ShortIntHashMap expected = ShortIntHashMap.newWithKeysValues((short) 0, 1, (short) 31, 32, (short) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 1, 2));
        expected.put((short) 1, 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 33, 34));
        expected.put((short) 33, 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 30, 31));
        expected.put((short) 30, 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1));
        Assert.assertEquals(32L, map1.addToValue((short) 31, 32));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 5));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33));
        ShortIntHashMap expected = ShortIntHashMap.newWithKeysValues((short) 0, 11, (short) 1, 12, (short) 31, 37, (short) 32, 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, 5));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 32));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3));
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10));
        Assert.assertEquals(expected, map1);

        MutableShortIntMap map2 = this.getEmptyMap();
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
            int v = (int) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        ShortIntHashMap hashMap = new ShortIntHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((short) i));
            hashMap.put((short) i, i);
            Assert.assertEquals(i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals(0, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortIntMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortIntMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortIntMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortIntMapTestCase.generateCollisions().get(3);

        MutableShortIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
        hashMap.put(collision2, 2);
        hashMap.put(collision3, 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues(collision1, 1, collision3, 3, collision4, 4), hashMap);

        MutableShortIntMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1);
        hashMap1.put(collision2, 2);
        hashMap1.put(collision3, 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues(collision2, 2, collision3, 3, collision4, 4), hashMap1);

        MutableShortIntMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1);
        hashMap2.put(collision2, 2);
        hashMap2.put(collision3, 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues(collision1, 1, collision2, 2, collision4, 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 50, (short) 1, 50), map1);

        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 50, (short) 1, 50), map2);

        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 50), map3);

        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 100));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;
        IntFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 100, (short) 1, 100), map1);

        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 100, (short) 1, 100), map2);

        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 100), map3);

        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> (int) string.length();
        IntFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 9), map1);
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 9, (short) 1, 9), map1);

        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 9), map2);
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 9, (short) 1, 9), map2);

        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(9, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals(9, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 9), map3);

        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(9, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals(9, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToIntFunction function = (short shortParameter) -> (int) shortParameter;
        ShortToIntFunction functionThrows = (short shortParameter) -> { throw new AssertionError(); };

        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 1, 1), map1);

        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 1, 1), map2);

        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 32, 32), map3);

        MutableShortIntMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 33), map4);
    }

    @Test
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableShortIntMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2, (short) 1, 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map1);

        MutableShortIntMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 2), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 1, (short) 1, 2), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 2, (short) 1, 2), map2);

        MutableShortIntMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 1), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, 0, incrementFunction));
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 33, 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableShortIntMap mutableShortIntMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortIntMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortIntMap.put((short) i, (int) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ShortSet frozenSetForRemove = mutableShortIntMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortIntMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortIntMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortIntMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableShortIntMap mutableShortIntMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortIntMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortIntMapForClear.keySet().toArray());
        mutableShortIntMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 31, 31, (short) 32, 32);
        MutableShortIntMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 31, 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableShortIntMap map = this.newWithKeysValues((short) 0, 0, (short) 1, 1, (short) 31, 31, (short) 32, 32);
        MutableShortIntMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 31, 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableShortIntMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1), hashMap);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortIntMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortIntMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortIntMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortIntMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void intIterator_with_remove()
    {
        MutableShortIntMap mutableMap = this.classUnderTest();
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
        MutableShortIntMap map = this.newWithKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5);
        Assert.assertEquals(
                IntShortHashMap.newWithKeysValues(2, (short) 1, 3, (short) 2, 4, (short) 3, 5, (short) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((short) 1, 1, (short) 2, 1).flipUniqueValues());
    }
}
