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

import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.ByteDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteDoubleHashMapTest extends AbstractMutableByteDoubleMapTestCase
{
    @Override
    protected ByteDoubleHashMap classUnderTest()
    {
        return ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1)
    {
        return new ByteDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2)
    {
        return new ByteDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3)
    {
        return new ByteDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteDoubleHashMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4)
    {
        return new ByteDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteDoubleHashMap getEmptyMap()
    {
        return new ByteDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteDoubleHashMap hashMap = new ByteDoubleHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);

        ByteDoubleHashMap hashMap2 = new ByteDoubleHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ByteDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (double) i);
        }

        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, 10.0);
        hashMap.put((byte) 11, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (double) i);
        }

        Field keys = ByteDoubleHashMap.class.getDeclaredField("keys");
        Field values = ByteDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);

        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0);

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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);

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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;

        hashMap.updateValue((byte) 2, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 5, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 2, 0.0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((byte) 2, 9.0); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);

        hashMap.getIfAbsentPut((byte) 2, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, 5.0); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);

        DoubleFunction0 function = () -> 5.0;

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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);

        DoubleFunction<Double> function = Double::doubleValue;

        hashMap.getIfAbsentPutWith((byte) 2, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 5, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 2, function, Double.valueOf(5.0)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = ByteDoubleHashMap.newWithKeysValues((byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);

        ByteToDoubleFunction function = (byte byteParameter) -> (double) byteParameter;

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
        Field occupiedWithData = ByteDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((byte) 2, 3.0); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableByteDoubleMap copyMap = new ByteDoubleHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (double) i);
        }

        Verify.assertSize(8, copyMap);
        MutableByteDoubleMap hashMap = new ByteDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ByteDoubleHashMap hashMap0 = new ByteDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, 1.0, (byte) 2, 2.0), hashMap0);
        ByteDoubleHashMap hashMap1 = new ByteDoubleHashMap().withKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0);
        ByteDoubleHashMap hashMap2 = new ByteDoubleHashMap().withKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0), hashMap0);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0), hashMap1);
        Assert.assertEquals(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ByteDoubleHashMap hashMap = new ByteDoubleHashMap().withKeysValues((byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableByteDoubleMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((byte) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((byte) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteDoubleMaps.class);
    }
}
