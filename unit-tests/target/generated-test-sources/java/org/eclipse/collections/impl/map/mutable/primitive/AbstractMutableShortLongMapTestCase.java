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

import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortLongMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortLongMapTestCase extends AbstractShortLongMapTestCase
{
    @Override
    protected abstract MutableShortLongMap classUnderTest();

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1);

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2);

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3);

    @Override
    protected abstract MutableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4);

    @Override
    protected abstract MutableShortLongMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.put((short) 0, 1L);
        Assert.assertEquals(1L, map1.get((short) 0));

        map1.put((short) 0, 0L);
        Assert.assertEquals(0L, map1.get((short) 0));

        map1.put((short) 5, 5L);
        Assert.assertEquals(5L, map1.get((short) 5));

        map1.put((short) 35, 35L);
        Assert.assertEquals(35L, map1.get((short) 35));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((short) 0));

        map1.put((short) 1, 1L);
        Assert.assertEquals(1L, map1.getOrThrow((short) 1));

        map1.put((short) 5, 5L);
        Assert.assertEquals(5L, map1.getOrThrow((short) 5));

        map1.put((short) 35, 35L);
        Assert.assertEquals(35L, map1.getOrThrow((short) 35));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5L, map1.getIfAbsent((short) 0, 5L));

        Assert.assertEquals(6L, map1.getIfAbsent((short) 1, 6L));
        Assert.assertEquals(6L, map1.getIfAbsent((short) 33, 6L));

        map1.put((short) 0, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((short) 0, 5L));

        map1.put((short) 1, 1L);
        Assert.assertEquals(1L, map1.getIfAbsent((short) 1, 5L));

        map1.put((short) 5, 5L);
        Assert.assertEquals(5L, map1.getIfAbsent((short) 5, 6L));

        map1.put((short) 35, 35L);
        Assert.assertEquals(35L, map1.getIfAbsent((short) 35, 5L));
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableShortLongMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0L, map1.get((short) 0));
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0L, map1.get((short) 0));

        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0L, map1.get((short) 1));

        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0L, map1.get((short) 31));

        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0L, map1.get((short) 32));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableShortLongMap map1 = this.classUnderTest();

        map1.put((short) 35, 35L);
        Assert.assertTrue(map1.containsValue(35L));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0L));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableShortLongMap map1 = this.classUnderTest();

        map1.put((short) 35, 35L);
        Assert.assertTrue(map1.contains(35L));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0L));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableShortLongMap hashMap1 = this.newWithKeysValues((short) 1, 1L, (short) 0, 0L);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableShortLongMap hashMap = this.newWithKeysValues((short) 6, 6L, (short) 5, 5L);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortLongHashMap hashMap = new ShortLongHashMap();
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
        MutableShortLongMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortLongHashMap(), map1);

        map1.put((short) 1, 0L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 0L), map1);
        map1.clear();
        Assert.assertEquals(new ShortLongHashMap(), map1);

        map1.put((short) 33, 0L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 0L), map1);
        map1.clear();
        Assert.assertEquals(new ShortLongHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableShortLongMap map0 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortLongHashMap(), map0);

        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortLongHashMap(), map1);

        MutableShortLongMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 31, 31L, (short) 32, 32L), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        map2.removeKey(AbstractMutableShortLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
        map2.removeKey(AbstractMutableShortLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void remove()
    {
        MutableShortLongMap map0 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map0.remove((short) 1);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortLongHashMap(), map0);

        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        map1.remove((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortLongHashMap(), map1);

        MutableShortLongMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 31, 31L, (short) 32, 32L), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        map2.remove(AbstractMutableShortLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
        map2.remove(AbstractMutableShortLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableShortLongMap map0 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        Assert.assertEquals(1L, map0.removeKeyIfAbsent((short) 1, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map0);
        Assert.assertEquals(0L, map0.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map0);
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((short) 1, 100L));
        Assert.assertEquals(100L, map0.removeKeyIfAbsent((short) 0, 100L));

        MutableShortLongMap map1 = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L);
        Assert.assertEquals(0L, map1.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map1);
        Assert.assertEquals(1L, map1.removeKeyIfAbsent((short) 1, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map1);
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(100L, map1.removeKeyIfAbsent((short) 1, 100L));

        MutableShortLongMap map2 = this.classUnderTest();
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 5, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 50, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L), map2);
        Assert.assertEquals(0L, map2.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 31, 31L, (short) 32, 32L), map2);
        Assert.assertEquals(31L, map2.removeKeyIfAbsent((short) 31, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map2);
        Assert.assertEquals(32L, map2.removeKeyIfAbsent((short) 32, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 0, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 31, 100L));
        Assert.assertEquals(100L, map2.removeKeyIfAbsent((short) 32, 100L));
        Assert.assertEquals(new ShortLongHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 1L);
        map2.put(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));
        Assert.assertEquals(1L, map2.removeKeyIfAbsent(AbstractMutableShortLongMapTestCase.generateCollisions().get(0), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(0)));

        Assert.assertEquals(2L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
        Assert.assertEquals(2L, map2.removeKeyIfAbsent(AbstractMutableShortLongMapTestCase.generateCollisions().get(1), 100L));
        Assert.assertEquals(0L, map2.get(AbstractMutableShortLongMapTestCase.generateCollisions().get(1)));
    }

    @Test
    public void put()
    {
        MutableShortLongMap map1 = this.classUnderTest();
        map1.put((short) 0, 1L);
        map1.put((short) 31, 32L);
        map1.put((short) 32, 33L);
        ShortLongHashMap expected = ShortLongHashMap.newWithKeysValues((short) 0, 1L, (short) 31, 32L, (short) 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.put((short) 1, 2L);
        expected.put((short) 1, 2L);
        Assert.assertEquals(expected, map1);

        map1.put((short) 33, 34L);
        expected.put((short) 33, 34L);
        Assert.assertEquals(expected, map1);

        map1.put((short) 30, 31L);
        expected.put((short) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableShortLongMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1L));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32L));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33L));
        ShortLongHashMap expected = ShortLongHashMap.newWithKeysValues((short) 0, 1L, (short) 31, 32L, (short) 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 1, 2L));
        expected.put((short) 1, 2L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 33, 34L));
        expected.put((short) 33, 34L);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 30, 31L));
        expected.put((short) 30, 31L);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1L));
        Assert.assertEquals(32L, map1.addToValue((short) 31, 32L));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3L));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10L));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9L));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 5L));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33L));
        ShortLongHashMap expected = ShortLongHashMap.newWithKeysValues((short) 0, 11L, (short) 1, 12L, (short) 31, 37L, (short) 32, 33L);
        Assert.assertEquals(expected, map1);

        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5L, map1.addToValue((short) 31, 5L));
        Assert.assertEquals(37L, map1.addToValue((short) 31, 32L));
        Assert.assertEquals(33L, map1.addToValue((short) 32, 33L));
        Assert.assertEquals(3L, map1.addToValue((short) 1, 3L));
        Assert.assertEquals(1L, map1.addToValue((short) 0, 1L));
        Assert.assertEquals(12L, map1.addToValue((short) 1, 9L));
        Assert.assertEquals(11L, map1.addToValue((short) 0, 10L));
        Assert.assertEquals(expected, map1);

        MutableShortLongMap map2 = this.getEmptyMap();
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
            long v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v));
        });
    }

    @Test
    public void put_every_slot()
    {
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((short) i));
            hashMap.put((short) i, (long) i);
            Assert.assertEquals((long) i, hashMap.get((short) i));
            hashMap.remove((short) i);
            Assert.assertEquals(0L, hashMap.get((short) i));
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortLongMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortLongMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortLongMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortLongMapTestCase.generateCollisions().get(3);

        MutableShortLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);

        MutableShortLongMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);

        MutableShortLongMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut((short) 1, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 50L, (short) 1, 50L), map1);

        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 1, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut((short) 0, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 50L, (short) 1, 50L), map2);

        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut((short) 32, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 50L), map3);

        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 50L));
        Assert.assertEquals(50L, map4.getIfAbsentPut((short) 33, 100L));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 50L), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;
        LongFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 100L, (short) 1, 100L), map1);

        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 1, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut((short) 0, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 100L, (short) 1, 100L), map2);

        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut((short) 32, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 100L), map3);

        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factory));
        Assert.assertEquals(100L, map4.getIfAbsentPut((short) 33, factoryThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 100L), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();
        LongFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 9L, (short) 1, 9L), map1);

        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 9L, (short) 1, 9L), map2);

        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 9L), map3);

        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"));
        Assert.assertEquals(9L, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 9L), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToLongFunction function = (short shortParameter) -> (long) shortParameter;
        ShortToLongFunction functionThrows = (short shortParameter) -> { throw new AssertionError(); };

        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L), map1);

        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey((short) 1, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey((short) 0, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L), map2);

        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey((short) 32, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 32, 32L), map3);

        MutableShortLongMap map4 = this.getEmptyMap();
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, function));
        Assert.assertEquals(33L, map4.getIfAbsentPutWithKey((short) 33, functionThrows));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 33L), map4);
    }

    @Test
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableShortLongMap map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L, (short) 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L, (short) 1, 2L), map1);

        MutableShortLongMap map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 1, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 1L, (short) 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue((short) 0, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 2L, (short) 1, 2L), map2);

        MutableShortLongMap map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue((short) 33, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue((short) 33, 0L, incrementFunction));
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 33, 2L), map3);
    }

    @Test
    public void freeze()
    {
        MutableShortLongMap mutableShortLongMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortLongMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortLongMap.put((short) i, (long) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ShortSet frozenSetForRemove = mutableShortLongMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortLongMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortLongMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortLongMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableShortLongMap mutableShortLongMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortLongMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortLongMapForClear.keySet().toArray());
        mutableShortLongMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 31, 31L, (short) 32, 32L);
        MutableShortLongMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 31, 31L), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableShortLongMap map = this.newWithKeysValues((short) 0, 0L, (short) 1, 1L, (short) 31, 31L, (short) 32, 32L);
        MutableShortLongMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 31, 31L), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableShortLongMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1L), hashMap);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortLongMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortLongMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortLongMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortLongMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void longIterator_with_remove()
    {
        MutableShortLongMap mutableMap = this.classUnderTest();
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
        MutableShortLongMap map = this.newWithKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L);
        Assert.assertEquals(
                LongShortHashMap.newWithKeysValues(2L, (short) 1, 3L, (short) 2, 4L, (short) 3, 5L, (short) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((short) 1, 1L, (short) 2, 1L).flipUniqueValues());
    }
}
