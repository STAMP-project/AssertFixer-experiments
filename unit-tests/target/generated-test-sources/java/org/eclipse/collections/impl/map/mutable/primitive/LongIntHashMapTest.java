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

import java.lang.reflect.Field;

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.LongToIntFunction;
import org.eclipse.collections.impl.factory.primitive.LongIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongIntHashMapTest extends AbstractMutableLongIntMapTestCase
{
    @Override
    protected LongIntHashMap classUnderTest()
    {
        return LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32);
    }

    @Override
    protected LongIntHashMap newWithKeysValues(long key1, int value1)
    {
        return new LongIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongIntHashMap newWithKeysValues(long key1, int value1, long key2, int value2)
    {
        return new LongIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongIntHashMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3)
    {
        return new LongIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongIntHashMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4)
    {
        return new LongIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongIntHashMap getEmptyMap()
    {
        return new LongIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = LongIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongIntHashMap hashMap = new LongIntHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = LongIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongIntHashMap hashMap = new LongIntHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);

        LongIntHashMap hashMap2 = new LongIntHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new LongIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = LongIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongIntHashMap hashMap = new LongIntHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        LongIntHashMap hashMap = new LongIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, i);
        }

        Field keys = LongIntHashMap.class.getDeclaredField("keys");
        Field values = LongIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, 10);
        hashMap.put(11L, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        LongIntHashMap hashMap = new LongIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, i);
        }

        Field keys = LongIntHashMap.class.getDeclaredField("keys");
        Field values = LongIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);

        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        IntToIntFunction function = (int intParameter) -> intParameter;

        hashMap.updateValue(2L, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5L, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2L, 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = new LongIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2L, 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);

        hashMap.getIfAbsentPut(2L, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);

        IntFunction0 function = () -> 5;

        hashMap.getIfAbsentPut(2L, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);

        IntFunction<Integer> function = Integer::intValue;

        hashMap.getIfAbsentPutWith(2L, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5L, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2L, function, Integer.valueOf(5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = LongIntHashMap.newWithKeysValues(2L, 2, 3L, 3, 4L, 4);

        LongToIntFunction function = (long longParameter) -> (int) longParameter;

        hashMap.getIfAbsentPutWithKey(2L, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2L, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = LongIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongIntHashMap hashMap = new LongIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2L, 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableLongIntMap copyMap = new LongIntHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, i);
        }

        Verify.assertSize(8, copyMap);
        MutableLongIntMap hashMap = new LongIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        LongIntHashMap hashMap0 = new LongIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, 1, 2L, 2), hashMap0);
        LongIntHashMap hashMap1 = new LongIntHashMap().withKeysValues(1L, 1, 2L, 2, 3L, 3);
        LongIntHashMap hashMap2 = new LongIntHashMap().withKeysValues(1L, 1, 2L, 2, 3L, 3, 4L, 4);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 2L, 2), hashMap0);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), hashMap1);
        Assert.assertEquals(LongIntHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3, 4L, 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        LongIntHashMap hashMap = new LongIntHashMap().withKeysValues(1L, 2, 2L, 3, 3L, 4, 4L, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableLongIntMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongIntMaps.class);
    }
}
