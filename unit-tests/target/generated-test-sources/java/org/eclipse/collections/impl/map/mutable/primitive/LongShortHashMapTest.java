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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.LongToShortFunction;
import org.eclipse.collections.impl.factory.primitive.LongShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongShortHashMapTest extends AbstractMutableLongShortMapTestCase
{
    @Override
    protected LongShortHashMap classUnderTest()
    {
        return LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32);
    }

    @Override
    protected LongShortHashMap newWithKeysValues(long key1, short value1)
    {
        return new LongShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongShortHashMap newWithKeysValues(long key1, short value1, long key2, short value2)
    {
        return new LongShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongShortHashMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3)
    {
        return new LongShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongShortHashMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4)
    {
        return new LongShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongShortHashMap getEmptyMap()
    {
        return new LongShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = LongShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongShortHashMap hashMap = new LongShortHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = LongShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongShortHashMap hashMap = new LongShortHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);

        LongShortHashMap hashMap2 = new LongShortHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new LongShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = LongShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongShortHashMap hashMap = new LongShortHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        LongShortHashMap hashMap = new LongShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (short) i);
        }

        Field keys = LongShortHashMap.class.getDeclaredField("keys");
        Field values = LongShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, (short) 10);
        hashMap.put(11L, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        LongShortHashMap hashMap = new LongShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (short) i);
        }

        Field keys = LongShortHashMap.class.getDeclaredField("keys");
        Field values = LongShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);

        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3);

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
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);

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
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ShortToShortFunction function = (short shortParameter) -> shortParameter;

        hashMap.updateValue(2L, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5L, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2L, (short) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = new LongShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2L, (short) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);

        hashMap.getIfAbsentPut(2L, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, (short) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);

        ShortFunction0 function = () -> (short) 5;

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
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);

        ShortFunction<Short> function = Short::shortValue;

        hashMap.getIfAbsentPutWith(2L, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5L, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2L, function, Short.valueOf((short) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = LongShortHashMap.newWithKeysValues(2L, (short) 2, 3L, (short) 3, 4L, (short) 4);

        LongToShortFunction function = (long longParameter) -> (short) longParameter;

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
        Field occupiedWithData = LongShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongShortHashMap hashMap = new LongShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2L, (short) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableLongShortMap copyMap = new LongShortHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (short) i);
        }

        Verify.assertSize(8, copyMap);
        MutableLongShortMap hashMap = new LongShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        LongShortHashMap hashMap0 = new LongShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, (short) 1, 2L, (short) 2), hashMap0);
        LongShortHashMap hashMap1 = new LongShortHashMap().withKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3);
        LongShortHashMap hashMap2 = new LongShortHashMap().withKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2), hashMap0);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3), hashMap1);
        Assert.assertEquals(LongShortHashMap.newWithKeysValues(1L, (short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        LongShortHashMap hashMap = new LongShortHashMap().withKeysValues(1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);

        MutableLongShortMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((short) 0, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongShortMaps.class);
    }
}
