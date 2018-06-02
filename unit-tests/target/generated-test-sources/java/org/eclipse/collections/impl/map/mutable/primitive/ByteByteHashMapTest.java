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
import org.eclipse.collections.impl.factory.primitive.ByteByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteByteHashMapTest extends AbstractMutableByteByteMapTestCase
{
    @Override
    protected ByteByteHashMap classUnderTest()
    {
        return ByteByteHashMap.newWithKeysValues((byte) 0, (byte) 0, (byte) 31, (byte) 31, (byte) 32, (byte) 32);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1)
    {
        return new ByteByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2)
    {
        return new ByteByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3)
    {
        return new ByteByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteByteHashMap newWithKeysValues(byte key1, byte value1, byte key2, byte value2, byte key3, byte value3, byte key4, byte value4)
    {
        return new ByteByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteByteHashMap getEmptyMap()
    {
        return new ByteByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keysValues = ByteByteHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(32L, ((byte[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keysValues = ByteByteHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap(3);
        Assert.assertEquals(16L, ((byte[]) keysValues.get(hashMap)).length);

        ByteByteHashMap hashMap2 = new ByteByteHashMap(15);
        Assert.assertEquals(64L, ((byte[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ByteByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keysValues = ByteByteHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);

        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(32L, ((byte[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new ByteByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ByteByteHashMap hashMap = new ByteByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (byte) i);
        }

        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, (byte) 10);
        hashMap.put((byte) 11, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ByteByteHashMap hashMap = new ByteByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (byte) i);
        }

        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3);

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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);

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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ByteToByteFunction function = (byte byteParameter) -> byteParameter;

        hashMap.updateValue((byte) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 5, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 2, (byte) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((byte) 2, (byte) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);

        hashMap.getIfAbsentPut((byte) 2, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, (byte) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);

        ByteFunction0 function = () -> (byte) 5;

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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);

        ByteFunction<Byte> function = Byte::byteValue;

        hashMap.getIfAbsentPutWith((byte) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 5, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 2, function, Byte.valueOf((byte) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = ByteByteHashMap.newWithKeysValues((byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);

        ByteToByteFunction function = (byte byteParameter) -> (byte) byteParameter;

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
        Field occupiedWithData = ByteByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteByteHashMap hashMap = new ByteByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((byte) 2, (byte) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableByteByteMap copyMap = new ByteByteHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (byte) i);
        }

        Verify.assertSize(8, copyMap);
        MutableByteByteMap hashMap = new ByteByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ByteByteHashMap hashMap0 = new ByteByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2), hashMap0);
        ByteByteHashMap hashMap1 = new ByteByteHashMap().withKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3);
        ByteByteHashMap hashMap2 = new ByteByteHashMap().withKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2), hashMap0);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3), hashMap1);
        Assert.assertEquals(ByteByteHashMap.newWithKeysValues((byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ByteByteHashMap hashMap = new ByteByteHashMap().withKeysValues((byte) 1, (byte) 2, (byte) 2, (byte) 3, (byte) 3, (byte) 4, (byte) 4, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableByteByteMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((byte) i));
            Assert.assertEquals(1L, hashMap.updateValue((byte) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((byte) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteByteMaps.class);
    }
}
