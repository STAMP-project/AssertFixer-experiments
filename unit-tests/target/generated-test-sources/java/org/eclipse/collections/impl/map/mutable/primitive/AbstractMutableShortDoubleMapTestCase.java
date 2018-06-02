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

import org.eclipse.collections.api.block.function.primitive.ShortToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.api.map.primitive.MutableShortDoubleMap;
import org.eclipse.collections.api.list.primitive.MutableLongList;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.primitive.AbstractShortDoubleMapTestCase;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutablePrimitivePrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableShortDoubleMapTestCase extends AbstractShortDoubleMapTestCase
{
    @Override
    protected abstract MutableShortDoubleMap classUnderTest();

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1);

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2);

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3);

    @Override
    protected abstract MutableShortDoubleMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3, short key4, double value4);

    @Override
    protected abstract MutableShortDoubleMap getEmptyMap();

    @Override
    @Test
    public void get()
    {
        super.get();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0);
        Assert.assertEquals(1.0, map1.get((short) 0), 0.0);

        map1.put((short) 0, 0.0);
        Assert.assertEquals(0.0, map1.get((short) 0), 0.0);

        map1.put((short) 5, 5.0);
        Assert.assertEquals(5.0, map1.get((short) 5), 0.0);

        map1.put((short) 35, 35.0);
        Assert.assertEquals(35.0, map1.get((short) 35), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Verify.assertThrows(IllegalStateException.class, () -> map1.getOrThrow((short) 0));
        map1.put((short) 0, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((short) 0), 0.0);

        map1.put((short) 1, 1.0);
        Assert.assertEquals(1.0, map1.getOrThrow((short) 1), 0.0);

        map1.put((short) 5, 5.0);
        Assert.assertEquals(5.0, map1.getOrThrow((short) 5), 0.0);

        map1.put((short) 35, 35.0);
        Assert.assertEquals(35.0, map1.getOrThrow((short) 35), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertEquals(5.0, map1.getIfAbsent((short) 0, 5.0), 0.0);

        Assert.assertEquals(6.0, map1.getIfAbsent((short) 1, 6.0), 0.0);
        Assert.assertEquals(6.0, map1.getIfAbsent((short) 33, 6.0), 0.0);

        map1.put((short) 0, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((short) 0, 5.0), 0.0);

        map1.put((short) 1, 1.0);
        Assert.assertEquals(1.0, map1.getIfAbsent((short) 1, 5.0), 0.0);

        map1.put((short) 5, 5.0);
        Assert.assertEquals(5.0, map1.getIfAbsent((short) 5, 6.0), 0.0);

        map1.put((short) 35, 35.0);
        Assert.assertEquals(35.0, map1.getIfAbsent((short) 35, 5.0), 0.0);
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0, map1.get((short) 0), 0.0);
        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsKey((short) 0));
        Assert.assertEquals(0.0, map1.get((short) 0), 0.0);

        map1.removeKey((short) 1);
        Assert.assertFalse(map1.containsKey((short) 1));
        Assert.assertEquals(0.0, map1.get((short) 1), 0.0);

        map1.removeKey((short) 31);
        Assert.assertFalse(map1.containsKey((short) 31));
        Assert.assertEquals(0.0, map1.get((short) 31), 0.0);

        map1.removeKey((short) 32);
        Assert.assertFalse(map1.containsKey((short) 32));
        Assert.assertEquals(0.0, map1.get((short) 32), 0.0);
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        MutableShortDoubleMap map1 = this.classUnderTest();

        map1.put((short) 35, 35.0);
        Assert.assertTrue(map1.containsValue(35.0));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.containsValue(0.0));
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();
        MutableShortDoubleMap map1 = this.classUnderTest();

        map1.put((short) 35, 35.0);
        Assert.assertTrue(map1.contains(35.0));

        map1.removeKey((short) 0);
        Assert.assertFalse(map1.contains(0.0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableShortDoubleMap hashMap1 = this.newWithKeysValues((short) 1, 1.0, (short) 0, 0.0);
        Assert.assertEquals(2, hashMap1.size());
        hashMap1.removeKey((short) 1);
        Assert.assertEquals(1, hashMap1.size());
        hashMap1.removeKey((short) 0);
        Assert.assertEquals(0, hashMap1.size());

        MutableShortDoubleMap hashMap = this.newWithKeysValues((short) 6, 6.0, (short) 5, 5.0);
        hashMap.removeKey((short) 5);
        Assert.assertEquals(1, hashMap.size());
    }

    protected static ShortArrayList generateCollisions()
    {
        ShortArrayList collisions = new ShortArrayList();
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
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
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.clear();
        Assert.assertEquals(new ShortDoubleHashMap(), map1);

        map1.put((short) 1, 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new ShortDoubleHashMap(), map1);

        map1.put((short) 33, 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 0.0), map1);
        map1.clear();
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
    }

    @Test
    public void removeKey()
    {
        MutableShortDoubleMap map0 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map0.removeKey((short) 1);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map0);
        map0.removeKey((short) 0);
        Assert.assertEquals(new ShortDoubleHashMap(), map0);

        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map1.removeKey((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map1);
        map1.removeKey((short) 1);
        Assert.assertEquals(new ShortDoubleHashMap(), map1);

        MutableShortDoubleMap map2 = this.classUnderTest();
        map2.removeKey((short) 5);
        map2.removeKey((short) 50);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0), map2);
        map2.removeKey((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 31, 31.0, (short) 32, 32.0), map2);
        map2.removeKey((short) 31);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map2);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        map2.removeKey((short) 0);
        map2.removeKey((short) 31);
        map2.removeKey((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.removeKey(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.removeKey(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void remove()
    {
        MutableShortDoubleMap map0 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map0.remove((short) 1);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map0);
        map0.remove((short) 0);
        Assert.assertEquals(new ShortDoubleHashMap(), map0);

        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        map1.remove((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map1);
        map1.remove((short) 1);
        Assert.assertEquals(new ShortDoubleHashMap(), map1);

        MutableShortDoubleMap map2 = this.classUnderTest();
        map2.remove((short) 5);
        map2.remove((short) 50);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0), map2);
        map2.remove((short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 31, 31.0, (short) 32, 32.0), map2);
        map2.remove((short) 31);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map2);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        map2.remove((short) 0);
        map2.remove((short) 31);
        map2.remove((short) 32);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        map2.remove(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        map2.remove(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void removeKeyIfAbsent()
    {
        MutableShortDoubleMap map0 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        Assert.assertEquals(1.0, map0.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map0);
        Assert.assertEquals(0.0, map0.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        Assert.assertEquals(100.0, map0.removeKeyIfAbsent((short) 0, 100.0), 0.0);

        MutableShortDoubleMap map1 = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0);
        Assert.assertEquals(0.0, map1.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map1);
        Assert.assertEquals(1.0, map1.removeKeyIfAbsent((short) 1, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map1);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map1.removeKeyIfAbsent((short) 1, 100.0), 0.0);

        MutableShortDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 5, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 50, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0), map2);
        Assert.assertEquals(0.0, map2.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 31, 31.0, (short) 32, 32.0), map2);
        Assert.assertEquals(31.0, map2.removeKeyIfAbsent((short) 31, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map2);
        Assert.assertEquals(32.0, map2.removeKeyIfAbsent((short) 32, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 0, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 31, 100.0), 0.0);
        Assert.assertEquals(100.0, map2.removeKeyIfAbsent((short) 32, 100.0), 0.0);
        Assert.assertEquals(new ShortDoubleHashMap(), map2);
        Verify.assertEmpty(map2);

        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 1.0);
        map2.put(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);
        Assert.assertEquals(1.0, map2.removeKeyIfAbsent(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
        Assert.assertEquals(2.0, map2.removeKeyIfAbsent(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1), 100.0), 0.0);
        Assert.assertEquals(0.0, map2.get(AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1)), 0.0);
    }

    @Test
    public void put()
    {
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.put((short) 0, 1.0);
        map1.put((short) 31, 32.0);
        map1.put((short) 32, 33.0);
        ShortDoubleHashMap expected = ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0, (short) 31, 32.0, (short) 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.put((short) 1, 2.0);
        expected.put((short) 1, 2.0);
        Assert.assertEquals(expected, map1);

        map1.put((short) 33, 34.0);
        expected.put((short) 33, 34.0);
        Assert.assertEquals(expected, map1);

        map1.put((short) 30, 31.0);
        expected.put((short) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void putPair()
    {
        MutableShortDoubleMap map1 = this.classUnderTest();
        map1.putPair(PrimitiveTuples.pair((short) 0, 1.0));
        map1.putPair(PrimitiveTuples.pair((short) 31, 32.0));
        map1.putPair(PrimitiveTuples.pair((short) 32, 33.0));
        ShortDoubleHashMap expected = ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0, (short) 31, 32.0, (short) 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 1, 2.0));
        expected.put((short) 1, 2.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 33, 34.0));
        expected.put((short) 33, 34.0);
        Assert.assertEquals(expected, map1);

        map1.putPair(PrimitiveTuples.pair((short) 30, 31.0));
        expected.put((short) 30, 31.0);
        Assert.assertEquals(expected, map1);
    }

    @Test
    public void addToValue()
    {
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0), 0.0);
        Assert.assertEquals(32.0, map1.addToValue((short) 31, 32.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 5.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0), 0.0);
        ShortDoubleHashMap expected = ShortDoubleHashMap.newWithKeysValues((short) 0, 11.0, (short) 1, 12.0, (short) 31, 37.0, (short) 32, 33.0);
        Assert.assertEquals(expected, map1);

        map1.removeKey((short) 0);
        map1.removeKey((short) 1);
        map1.removeKey((short) 31);
        map1.removeKey((short) 32);
        Assert.assertEquals(5.0, map1.addToValue((short) 31, 5.0), 0.0);
        Assert.assertEquals(37.0, map1.addToValue((short) 31, 32.0), 0.0);
        Assert.assertEquals(33.0, map1.addToValue((short) 32, 33.0), 0.0);
        Assert.assertEquals(3.0, map1.addToValue((short) 1, 3.0), 0.0);
        Assert.assertEquals(1.0, map1.addToValue((short) 0, 1.0), 0.0);
        Assert.assertEquals(12.0, map1.addToValue((short) 1, 9.0), 0.0);
        Assert.assertEquals(11.0, map1.addToValue((short) 0, 10.0), 0.0);
        Assert.assertEquals(expected, map1);

        MutableShortDoubleMap map2 = this.getEmptyMap();
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
            double v = each + index;
            Assert.assertEquals("Key:" + k, v, map2.addToValue(k, v), 0.0);
        });
    }

    @Test
    public void put_every_slot()
    {
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((short) i), 0.0);
            hashMap.put((short) i, (double) i);
            Assert.assertEquals((double) i, hashMap.get((short) i), 0.0);
            hashMap.remove((short) i);
            Assert.assertEquals(0.0, hashMap.get((short) i), 0.0);
        }
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortDoubleMapTestCase.generateCollisions().getFirst();
        short collision2 = AbstractMutableShortDoubleMapTestCase.generateCollisions().get(1);
        short collision3 = AbstractMutableShortDoubleMapTestCase.generateCollisions().get(2);
        short collision4 = AbstractMutableShortDoubleMapTestCase.generateCollisions().get(3);

        MutableShortDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);

        MutableShortDoubleMap hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);

        MutableShortDoubleMap hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);
    }

    @Test
    public void getIfAbsentPut()
    {
        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut((short) 1, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 50.0, (short) 1, 50.0), map1);

        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 1, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut((short) 0, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 50.0, (short) 1, 50.0), map2);

        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut((short) 32, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 50.0), map3);

        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 50.0), 0.0);
        Assert.assertEquals(50.0, map4.getIfAbsentPut((short) 33, 100.0), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 50.0), map4);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;
        DoubleFunction0 factoryThrows = () -> { throw new AssertionError(); };

        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 100.0, (short) 1, 100.0), map1);

        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 1, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut((short) 0, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 100.0, (short) 1, 100.0), map2);

        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut((short) 32, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 100.0), map3);

        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factory), 0.0);
        Assert.assertEquals(100.0, map4.getIfAbsentPut((short) 33, factoryThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 100.0), map4);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();
        DoubleFunction<String> functionThrows = (String string) -> { throw new AssertionError(); };

        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 9.0, (short) 1, 9.0), map1);

        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith((short) 0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 9.0, (short) 1, 9.0), map2);

        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((short) 32, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith((short) 32, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 9.0), map3);

        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((short) 33, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map4.getIfAbsentPutWith((short) 33, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 9.0), map4);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToDoubleFunction function = (short shortParameter) -> (double) shortParameter;
        ShortToDoubleFunction functionThrows = (short shortParameter) -> { throw new AssertionError(); };

        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0), map1);

        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey((short) 1, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey((short) 0, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0), map2);

        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey((short) 32, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 32, 32.0), map3);

        MutableShortDoubleMap map4 = this.getEmptyMap();
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, function), 0.0);
        Assert.assertEquals(33.0, map4.getIfAbsentPutWithKey((short) 33, functionThrows), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 33.0), map4);
    }

    @Test
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableShortDoubleMap map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0, (short) 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0, (short) 1, 2.0), map1);

        MutableShortDoubleMap map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 1.0, (short) 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue((short) 0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 2.0, (short) 1, 2.0), map2);

        MutableShortDoubleMap map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue((short) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue((short) 33, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 33, 2.0), map3);
    }

    @Test
    public void freeze()
    {
        MutableShortDoubleMap mutableShortDoubleMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortDoubleMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
        Assert.assertEquals(frozenSetCopy, mutableShortDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortDoubleMap.put((short) i, (double) i);
            Assert.assertEquals(frozenSet, frozenSetCopy);
        }

        ShortSet frozenSetForRemove = mutableShortDoubleMap.keySet().freeze();
        ShortSet frozenSetCopyForRemove = ShortHashSet.newSetWith(mutableShortDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        Assert.assertEquals(frozenSetCopyForRemove, mutableShortDoubleMap.keySet().freeze());
        for (int i = 0; i < 32; i++)
        {
            mutableShortDoubleMap.remove((short) i);
            Assert.assertEquals(frozenSetForRemove, frozenSetCopyForRemove);
        }

        MutableShortDoubleMap mutableShortDoubleMapForClear = this.classUnderTest();
        ShortSet frozenSetForClear = mutableShortDoubleMapForClear.keySet().freeze();
        ShortSet frozenSetCopyForClear = ShortHashSet.newSetWith(mutableShortDoubleMapForClear.keySet().toArray());
        mutableShortDoubleMapForClear.clear();
        Assert.assertEquals(frozenSetForClear, frozenSetCopyForClear);
    }

    @Test
    public void withoutKey()
    {
        MutableShortDoubleMap map = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 31, 31.0, (short) 32, 32.0);
        MutableShortDoubleMap mapWithout = map.withoutKey((short) 32);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 31, 31.0), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableShortDoubleMap map = this.newWithKeysValues((short) 0, 0.0, (short) 1, 1.0, (short) 31, 31.0, (short) 32, 32.0);
        MutableShortDoubleMap mapWithout = map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 31, 31.0), mapWithout);
    }

    @Test
    public void withKeysValues()
    {
        MutableShortDoubleMap hashMap = this.getEmptyMap();
        Assert.assertSame(hashMap.withKeyValue((short) 1, 1.0), hashMap);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0), hashMap);
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedShortDoubleMap.class, this.classUnderTest().asSynchronized());
        Assert.assertEquals(new SynchronizedShortDoubleMap(this.classUnderTest()), this.classUnderTest().asSynchronized());
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableShortDoubleMap.class, this.classUnderTest().asUnmodifiable());
        Assert.assertEquals(new UnmodifiableShortDoubleMap(this.classUnderTest()), this.classUnderTest().asUnmodifiable());
    }

    @Test
    public void doubleIterator_with_remove()
    {
        MutableShortDoubleMap mutableMap = this.classUnderTest();
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
        MutableShortDoubleMap map = this.newWithKeysValues((short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4, 5.0);
        Assert.assertEquals(
                DoubleShortHashMap.newWithKeysValues(2.0, (short) 1, 3.0, (short) 2, 4.0, (short) 3, 5.0, (short) 4),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues((short) 1, 1.0, (short) 2, 1.0).flipUniqueValues());
    }
}
