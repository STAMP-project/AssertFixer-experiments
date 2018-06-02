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
import org.eclipse.collections.api.block.function.primitive.DoubleToByteFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleByteHashMapTest extends AbstractMutableDoubleByteMapTestCase
{
    @Override
    protected DoubleByteHashMap classUnderTest()
    {
        return DoubleByteHashMap.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32);
    }

    @Override
    protected DoubleByteHashMap newWithKeysValues(double key1, byte value1)
    {
        return new DoubleByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleByteHashMap newWithKeysValues(double key1, byte value1, double key2, byte value2)
    {
        return new DoubleByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleByteHashMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3)
    {
        return new DoubleByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleByteHashMap newWithKeysValues(double key1, byte value1, double key2, byte value2, double key3, byte value3, double key4, byte value4)
    {
        return new DoubleByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleByteHashMap getEmptyMap()
    {
        return new DoubleByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = DoubleByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = DoubleByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleByteHashMap hashMap = new DoubleByteHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);

        DoubleByteHashMap hashMap2 = new DoubleByteHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new DoubleByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = DoubleByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (byte) i);
        }

        Field keys = DoubleByteHashMap.class.getDeclaredField("keys");
        Field values = DoubleByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, (byte) 10);
        hashMap.put(11.0, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (byte) i);
        }

        Field keys = DoubleByteHashMap.class.getDeclaredField("keys");
        Field values = DoubleByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);

        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ByteToByteFunction function = (byte byteParameter) -> byteParameter;

        hashMap.updateValue(2.0, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0, (byte) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0, (byte) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);

        hashMap.getIfAbsentPut(2.0, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0, (byte) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);

        ByteFunction0 function = () -> (byte) 5;

        hashMap.getIfAbsentPut(2.0, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);

        ByteFunction<Byte> function = Byte::byteValue;

        hashMap.getIfAbsentPutWith(2.0, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0, function, Byte.valueOf((byte) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = DoubleByteHashMap.newWithKeysValues(2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);

        DoubleToByteFunction function = (double doubleParameter) -> (byte) doubleParameter;

        hashMap.getIfAbsentPutWithKey(2.0, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5.0, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2.0, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = DoubleByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleByteHashMap hashMap = new DoubleByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0, (byte) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableDoubleByteMap copyMap = new DoubleByteHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (byte) i);
        }

        Verify.assertSize(8, copyMap);
        MutableDoubleByteMap hashMap = new DoubleByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        DoubleByteHashMap hashMap0 = new DoubleByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, (byte) 1, 2.0, (byte) 2), hashMap0);
        DoubleByteHashMap hashMap1 = new DoubleByteHashMap().withKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3);
        DoubleByteHashMap hashMap2 = new DoubleByteHashMap().withKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2), hashMap0);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3), hashMap1);
        Assert.assertEquals(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3, 4.0, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        DoubleByteHashMap hashMap = new DoubleByteHashMap().withKeysValues(1.0, (byte) 2, 2.0, (byte) 3, 3.0, (byte) 4, 4.0, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableDoubleByteMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((double) i));
            Assert.assertEquals(1L, hashMap.updateValue((double) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((double) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleByteMaps.class);
    }
}
