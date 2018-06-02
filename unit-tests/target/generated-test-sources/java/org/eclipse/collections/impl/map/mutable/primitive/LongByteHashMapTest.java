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

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.LongToByteFunction;
import org.eclipse.collections.impl.factory.primitive.LongByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongByteHashMapTest extends AbstractMutableLongByteMapTestCase
{
    @Override
    protected LongByteHashMap classUnderTest()
    {
        return LongByteHashMap.newWithKeysValues(0L, (byte) 0, 31L, (byte) 31, 32L, (byte) 32);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1)
    {
        return new LongByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1, long key2, byte value2)
    {
        return new LongByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3)
    {
        return new LongByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongByteHashMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3, long key4, byte value4)
    {
        return new LongByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongByteHashMap getEmptyMap()
    {
        return new LongByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongByteHashMap hashMap = new LongByteHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);

        LongByteHashMap hashMap2 = new LongByteHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new LongByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        LongByteHashMap hashMap = new LongByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (byte) i);
        }

        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        Field values = LongByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, (byte) 10);
        hashMap.put(11L, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        LongByteHashMap hashMap = new LongByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (byte) i);
        }

        Field keys = LongByteHashMap.class.getDeclaredField("keys");
        Field values = LongByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);

        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3);

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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);

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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ByteToByteFunction function = (byte byteParameter) -> byteParameter;

        hashMap.updateValue(2L, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5L, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2L, (byte) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2L, (byte) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);

        hashMap.getIfAbsentPut(2L, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, (byte) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);

        ByteFunction0 function = () -> (byte) 5;

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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);

        ByteFunction<Byte> function = Byte::byteValue;

        hashMap.getIfAbsentPutWith(2L, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5L, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2L, function, Byte.valueOf((byte) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = LongByteHashMap.newWithKeysValues(2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);

        LongToByteFunction function = (long longParameter) -> (byte) longParameter;

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
        Field occupiedWithData = LongByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongByteHashMap hashMap = new LongByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2L, (byte) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableLongByteMap copyMap = new LongByteHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (byte) i);
        }

        Verify.assertSize(8, copyMap);
        MutableLongByteMap hashMap = new LongByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        LongByteHashMap hashMap0 = new LongByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, (byte) 1, 2L, (byte) 2), hashMap0);
        LongByteHashMap hashMap1 = new LongByteHashMap().withKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3);
        LongByteHashMap hashMap2 = new LongByteHashMap().withKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2), hashMap0);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3), hashMap1);
        Assert.assertEquals(LongByteHashMap.newWithKeysValues(1L, (byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        LongByteHashMap hashMap = new LongByteHashMap().withKeysValues(1L, (byte) 2, 2L, (byte) 3, 3L, (byte) 4, 4L, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableLongByteMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongByteMaps.class);
    }
}
