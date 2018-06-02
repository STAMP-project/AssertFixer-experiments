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
import org.eclipse.collections.api.block.function.primitive.ByteToIntFunction;
import org.eclipse.collections.impl.factory.primitive.ByteIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteIntHashMapTest extends AbstractMutableByteIntMapTestCase
{
    @Override
    protected ByteIntHashMap classUnderTest()
    {
        return ByteIntHashMap.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32);
    }

    @Override
    protected ByteIntHashMap newWithKeysValues(byte key1, int value1)
    {
        return new ByteIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteIntHashMap newWithKeysValues(byte key1, int value1, byte key2, int value2)
    {
        return new ByteIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteIntHashMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3)
    {
        return new ByteIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteIntHashMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3, byte key4, int value4)
    {
        return new ByteIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteIntHashMap getEmptyMap()
    {
        return new ByteIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ByteIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteIntHashMap hashMap = new ByteIntHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ByteIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteIntHashMap hashMap = new ByteIntHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);

        ByteIntHashMap hashMap2 = new ByteIntHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ByteIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ByteIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteIntHashMap hashMap = new ByteIntHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ByteIntHashMap hashMap = new ByteIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, i);
        }

        Field keys = ByteIntHashMap.class.getDeclaredField("keys");
        Field values = ByteIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, 10);
        hashMap.put((byte) 11, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ByteIntHashMap hashMap = new ByteIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, i);
        }

        Field keys = ByteIntHashMap.class.getDeclaredField("keys");
        Field values = ByteIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);

        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove((byte) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove((byte) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3, (byte) 4, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3, (byte) 4, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        IntToIntFunction function = (int intParameter) -> intParameter;

        hashMap.updateValue((byte) 2, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 5, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 2, 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = new ByteIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((byte) 2, 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3, (byte) 4, 4);

        hashMap.getIfAbsentPut((byte) 2, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3, (byte) 4, 4);

        IntFunction0 function = () -> 5;

        hashMap.getIfAbsentPut((byte) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3, (byte) 4, 4);

        IntFunction<Integer> function = Integer::intValue;

        hashMap.getIfAbsentPutWith((byte) 2, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 5, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 2, function, Integer.valueOf(5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = ByteIntHashMap.newWithKeysValues((byte) 2, 2, (byte) 3, 3, (byte) 4, 4);

        ByteToIntFunction function = (byte byteParameter) -> (int) byteParameter;

        hashMap.getIfAbsentPutWithKey((byte) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((byte) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((byte) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = ByteIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteIntHashMap hashMap = new ByteIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((byte) 2, 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableByteIntMap copyMap = new ByteIntHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, i);
        }

        Verify.assertSize(8, copyMap);
        MutableByteIntMap hashMap = new ByteIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ByteIntHashMap hashMap0 = new ByteIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, 1, (byte) 2, 2), hashMap0);
        ByteIntHashMap hashMap1 = new ByteIntHashMap().withKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3);
        ByteIntHashMap hashMap2 = new ByteIntHashMap().withKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2), hashMap0);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3), hashMap1);
        Assert.assertEquals(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3, (byte) 4, 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ByteIntHashMap hashMap = new ByteIntHashMap().withKeysValues((byte) 1, 2, (byte) 2, 3, (byte) 3, 4, (byte) 4, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableByteIntMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((byte) i));
            Assert.assertEquals(1L, hashMap.updateValue((byte) i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get((byte) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteIntMaps.class);
    }
}
