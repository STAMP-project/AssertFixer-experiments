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

import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.api.map.primitive.MutableShortShortMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortShortMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortShortMapTestCase extends AbstractShortShortMapTestCase
{
    @Override
    protected abstract MutableShortShortMap classUnderTest();

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1);

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2);

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3);

    @Override
    protected abstract MutableShortShortMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3, short key4, short value4);

    @Override
    protected abstract MutableShortShortMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.put((short) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.get((short) 0));

        map1.put((short) 0, (short) 0);
        Assert.assertEquals((short) 0, map1.get((short) 0));

        map1.put((short) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.get((short) 5));

        map1.put((short) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((short) 0));

        map1.put((short) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getOrThrow((short) 1));

        map1.put((short) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getOrThrow((short) 5));

        map1.put((short) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals((short) 5, map1.getIfAbsent((short) 0, (short) 5));

        Assert.assertEquals((short) 6, map1.getIfAbsent((short) 1, (short) 6));
        Assert.assertEquals((short) 6, map1.getIfAbsent((short) 33, (short) 6));

        map1.put((short) 0, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((short) 0, (short) 5));

        map1.put((short) 1, (short) 1);
        Assert.assertEquals((short) 1, map1.getIfAbsent((short) 1, (short) 5));

        map1.put((short) 5, (short) 5);
        Assert.assertEquals((short) 5, map1.getIfAbsent((short) 5, (short) 6));

        map1.put((short) 35, (short) 35);
        Assert.assertEquals((short) 35, map1.getIfAbsent((short) 35, (short) 5));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableShortShortMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((short) 0, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals((short) 0, map1.get((short) 0));

        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals((short) 0, map1.get((short) 1));

        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals((short) 0, map1.get((short) 31));

        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals((short) 0, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableShortShortMap map1 = this.classUnderTest();

        map1.put((short) 35, (short) 35);
        Assert.assertTrue(map1.containsValue((short) 35));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue((short) 0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableShortShortMap map1 = this.classUnderTest();

        map1.put((short) 35, (short) 35);
        Assert.assertTrue(map1.contains((short) 35));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains((short) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableShortShortMap hashMap1 = this.newWithKeysValues((short) 1, (short) 1, (short) 0, (short) 0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableShortShortMap hashMap = this.newWithKeysValues((short) 6, (short) 6, (short) 5, (short) 5);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortShortHashMap hashMap = new ShortShortHashMap();
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
        MutableShortShortMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortShortHashMap(), map1);

        map1.put((short) 1, (short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortShortHashMap(), map1);

        map1.put((short) 33, (short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 0), map1);
        map1.clear();
        Assert.assertEquals(new ShortShortHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableShortShortMap map0 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortShortHashMap(), map0);

        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortShortHashMap(), map1);

        MutableShortShortMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 2);

        Assert.assertEquals((short) 1, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableShortShortMap map0 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map0.remove((short) 1);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortShortHashMap(), map0);

        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        map1.remove((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortShortHashMap(), map1);

        MutableShortShortMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 31, (short) 31, (short) 32, (short) 32), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 2);

        Assert.assertEquals((short) 1, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortShortMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((short) 0, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortShortMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableShortShortMap map0 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        Assert.assertEquals((short) 1, map0.removeKeyIfAbsent((short) 1, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map0);
        Assert.assertEquals((short) 0, map0.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map0);
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((short) 1, (short) 100));
        Assert.assertEquals((short) 100, map0.removeKeyIfAbsent((short) 0, (short) 100));

        MutableShortShortMap map1 = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1);
        Assert.assertEquals((short) 0, map1.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map1);
        Assert.assertEquals((short) 1, map1.removeKeyIfAbsent((short) 1, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map1);
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals((short) 100, map1.removeKeyIfAbsent((short) 1, (short) 100));

        MutableShortShortMap map2 = this.classUnderTest();
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 5, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 50, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32), map2);
        Assert.assertEquals((short) 0, map2.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 31, (short) 31, (short) 32, (short) 32), map2);
        Assert.assertEquals((short) 31, map2.removeKeyIfAbsent((short) 31, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map2);
        Assert.assertEquals((short) 32, map2.removeKeyIfAbsent((short) 32, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 0, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 31, (short) 100));
        Assert.assertEquals((short) 100, map2.removeKeyIfAbsent((short) 32, (short) 100));
        Assert.assertEquals(new ShortShortHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 1);
        map2.put(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 2);

        Assert.assertEquals(1L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals((short) 1, map2.removeKeyIfAbsent(AbstractMutableShortShortMapTestCase.generateCollisions().get(0), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals((short) 2, map2.removeKeyIfAbsent(AbstractMutableShortShortMapTestCase.generateCollisions().get(1), (short) 100));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortShortMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableShortShortMap map1 = this.classUnderTest();
        map1.put((short) 0, (short) 1);
        map1.put((short) 31, (short) 32);
        map1.put((short) 32, (short) 33);
        ShortShortHashMap expected = ShortShortHashMap.newWithKeysValues((short) 0, (short) 1, (short) 31, (short) 32, (short) 32, (short) 33);
        Assert.assertEquals(expected, map1);

        map1.put((short) 1, (short) 2);
        expected.put((short) 1, (short) 2);
        Assert.assertEquals(expected, map1);

        map1.put((short) 33, (short) 34);
        expected.put((short) 33, (short) 34);
        Assert.assertEquals(expected, map1);

        map1.put((short) 30, (short) 31);
        expected.put((short) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableShortShortMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, (short) 1));
        map1.putPair(PrimitiveTuples.pair((short) 31, (short) 32));
        map1.putPair(PrimitiveTuples.pair((short) 32, (short) 33));
        ShortShortHashMap expected = ShortShortHashMap.newWithKeysValues((short) 0, (short) 1, (short) 31, (short) 32, (short) 32, (short) 33);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 1, (short) 2));
        expected.put((short) 1, (short) 2);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 33, (short) 34));
        expected.put((short) 33, (short) 34);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 30, (short) 31));
        expected.put((short) 30, (short) 31);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, (short) 1));
        Assert.assertEquals(32L, map1.addToValue((short) 31, (short) 32));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (short) 3));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (short) 10));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (short) 9));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (short) 5));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (short) 33));
        ShortShortHashMap expected = ShortShortHashMap.newWithKeysValues((short) 0, (short) 11, (short) 1, (short) 12, (short) 31, (short) 37, (short) 32, (short) 33);
        Assert.assertEquals(expected, map1);

        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, (short) 5));
        Assert.assertEquals(37L, map1.addToValue((short) 31, (short) 32));
        Assert.assertEquals(33L, map1.addToValue((short) 32, (short) 33));
        Assert.assertEquals(3L, map1.addToValue((short) 1, (short) 3));
        Assert.assertEquals(1L, map1.addToValue((short) 0, (short) 1));
        Assert.assertEquals(12L, map1.addToValue((short) 1, (short) 9));
        Assert.assertEquals(11L, map1.addToValue((short) 0, (short) 10));
        Assert.assertEquals(expected, map1);

        MutableShortShortMap map2 = this.getEmptyMap();
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
            short v = (short) (each + index);
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        ShortShortHashMap hashMap = new ShortShortHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((short) 0, hashMap.get((short) i));
            hashMap.put((short) i, (short) i);
            Assert.assertEquals((short) i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals((short) 0, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortShortMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortShortMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortShortMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortShortMapTestCase.generateCollisions().get(3);

        MutableShortShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
        hashMap.put(collision2, (short) 2);
        hashMap.put(collision3, (short) 3);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues(collision1, (short) 1, collision3, (short) 3, collision4, (short) 4), hashMap);

        MutableShortShortMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (short) 1);
        hashMap1.put(collision2, (short) 2);
        hashMap1.put(collision3, (short) 3);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues(collision2, (short) 2, collision3, (short) 3, collision4, (short) 4), hashMap1);

        MutableShortShortMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (short) 1);
        hashMap2.put(collision2, (short) 2);
        hashMap2.put(collision3, (short) 3);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues(collision1, (short) 1, collision2, (short) 2, collision4, (short) 4), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 50), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (short) 50));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 50, (short) 1, (short) 50), map1);

        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 50), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (short) 50));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 50, (short) 1, (short) 50), map2);

        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (short) 50));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 50), map3);

        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (short) 50));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, (short) 100));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 50), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        ShortFunction0 factory = () -> (short) 100;
        ShortFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 100), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 100, (short) 1, (short) 100), map1);

        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 100), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 100, (short) 1, (short) 100), map2);

        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 100), map3);

        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 100), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();
        ShortFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 9), map1);
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 9, (short) 1, (short) 9), map1);

        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 9), map2);
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 9, (short) 1, (short) 9), map2);

        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 9), map3);

        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals((short) 9, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 9), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToShortFunction function = (short shortParameter) -> (short) shortParameter;
        ShortToShortFunction functionThrows = (short shortParameter) -> { throw new AssertionError(); };

        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1), map1);

        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1), map2);

        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 32, (short) 32), map3);

        MutableShortShortMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 33), map4);
    }

    @Test
    public void updateValue()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);

        MutableShortShortMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2, (short) 1, (short) 1), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2, (short) 1, (short) 2), map1);

        MutableShortShortMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 2), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 1, (short) 1, (short) 2), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 2, (short) 1, (short) 2), map2);

        MutableShortShortMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 1), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, (short) 0, incrementFunction));
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 33, (short) 2), map3);
    }

    @Test
    public void freeze()
    {
        MutableShortShortMap mutableShortShortMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortShortMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortShortMap.put((short) i, (short) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ShortSet frozenSetForRemove = mutableShortShortMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortShortMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortShortMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortShortMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableShortShortMap mutableShortShortMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortShortMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortShortMapForClear.keySet().toArray());
        mutableShortShortMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableShortShortMap map = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 31, (short) 31, (short) 32, (short) 32);
        MutableShortShortMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 31, (short) 31), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableShortShortMap map = this.newWithKeysValues((short) 0, (short) 0, (short) 1, (short) 1, (short) 31, (short) 31, (short) 32, (short) 32);
        MutableShortShortMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 31, (short) 31), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableShortShortMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, (short) 1), hashMap);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortShortMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortShortMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortShortMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortShortMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void shortIterator_with_remove()
    {
        MutableShortShortMap mutableMap = this.classUnderTest();
        MutableShortIterator iterator = mutableMap.shortIterator();

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
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        MutableShortIterator iterator = this.classUnderTest().shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        iterator.remove();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void flipUniqueValues()
    {
        MutableShortShortMap map = this.newWithKeysValues((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4, (short) 5);
        Assert.assertEquals(
                ShortShortHashMap.newWithKeysValues((short) 2, (short) 1, (short) 3, (short) 2, (short) 4, (short) 3, (short) 5, (short) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 1).flipUniqueValues());
    }
}
