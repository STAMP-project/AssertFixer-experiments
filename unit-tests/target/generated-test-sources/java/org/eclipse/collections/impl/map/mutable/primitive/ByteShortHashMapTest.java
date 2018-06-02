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
import org.eclipse.collections.api.block.function.primitive.ByteToShortFunction;
import org.eclipse.collections.impl.factory.primitive.ByteShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteShortHashMapTest extends AbstractMutableByteShortMapTestCase
{
    @Override
    protected ByteShortHashMap classUnderTest()
    {
        return ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1)
    {
        return new ByteShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2)
    {
        return new ByteShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3)
    {
        return new ByteShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteShortHashMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4)
    {
        return new ByteShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteShortHashMap getEmptyMap()
    {
        return new ByteShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteShortHashMap hashMap = new ByteShortHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);

        ByteShortHashMap hashMap2 = new ByteShortHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ByteShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ByteShortHashMap hashMap = new ByteShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (short) i);
        }

        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, (short) 10);
        hashMap.put((byte) 11, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ByteShortHashMap hashMap = new ByteShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (short) i);
        }

        Field keys = ByteShortHashMap.class.getDeclaredField("keys");
        Field values = ByteShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);

        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3);

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
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);

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
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ShortToShortFunction function = (short shortParameter) -> shortParameter;

        hashMap.updateValue((byte) 2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 5, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 2, (short) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((byte) 2, (short) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);

        hashMap.getIfAbsentPut((byte) 2, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, (short) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);

        ShortFunction0 function = () -> (short) 5;

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
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);

        ShortFunction<Short> function = Short::shortValue;

        hashMap.getIfAbsentPutWith((byte) 2, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 5, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 2, function, Short.valueOf((short) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = ByteShortHashMap.newWithKeysValues((byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);

        ByteToShortFunction function = (byte byteParameter) -> (short) byteParameter;

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
        Field occupiedWithData = ByteShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteShortHashMap hashMap = new ByteShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((byte) 2, (short) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableByteShortMap copyMap = new ByteShortHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (short) i);
        }

        Verify.assertSize(8, copyMap);
        MutableByteShortMap hashMap = new ByteShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ByteShortHashMap hashMap0 = new ByteShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2), hashMap0);
        ByteShortHashMap hashMap1 = new ByteShortHashMap().withKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3);
        ByteShortHashMap hashMap2 = new ByteShortHashMap().withKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2), hashMap0);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3), hashMap1);
        Assert.assertEquals(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3, (byte) 4, (short) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ByteShortHashMap hashMap = new ByteShortHashMap().withKeysValues((byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3, (short) 4, (byte) 4, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);

        MutableByteShortMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((short) 0, hashMap.get((byte) i));
            Assert.assertEquals(1L, hashMap.updateValue((byte) i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get((byte) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteShortMaps.class);
    }
}
