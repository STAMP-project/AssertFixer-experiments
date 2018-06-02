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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.ByteFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableByteFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ByteFloatHashMapTest extends AbstractMutableByteFloatMapTestCase
{
    @Override
    protected ByteFloatHashMap classUnderTest()
    {
        return ByteFloatHashMap.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1)
    {
        return new ByteFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2)
    {
        return new ByteFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3)
    {
        return new ByteFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteFloatHashMap newWithKeysValues(byte key1, float value1, byte key2, float value2, byte key3, float value3, byte key4, float value4)
    {
        return new ByteFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteFloatHashMap getEmptyMap()
    {
        return new ByteFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteFloatHashMap hashMap = new ByteFloatHashMap(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);

        ByteFloatHashMap hashMap2 = new ByteFloatHashMap(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ByteFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (float) i);
        }

        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((byte) 10, 10.0f);
        hashMap.put((byte) 11, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (float) i);
        }

        Field keys = ByteFloatHashMap.class.getDeclaredField("keys");
        Field values = ByteFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);

        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f);

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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        FloatToFloatFunction function = (float floatParameter) -> floatParameter;

        hashMap.updateValue((byte) 2, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 5, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 2, 0.0f, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((byte) 2, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        hashMap.getIfAbsentPut((byte) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        FloatFunction0 function = () -> 5.0f;

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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        FloatFunction<Float> function = Float::floatValue;

        hashMap.getIfAbsentPutWith((byte) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 2, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = ByteFloatHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        ByteToFloatFunction function = (byte byteParameter) -> (float) byteParameter;

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
        Field occupiedWithData = ByteFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteFloatHashMap hashMap = new ByteFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((byte) i));
            hashMap.put((byte) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((byte) 2, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableByteFloatMap copyMap = new ByteFloatHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((byte) i));
            copyMap.put((byte) i, (float) i);
        }

        Verify.assertSize(8, copyMap);
        MutableByteFloatMap hashMap = new ByteFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((byte) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ByteFloatHashMap hashMap0 = new ByteFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f), hashMap0);
        ByteFloatHashMap hashMap1 = new ByteFloatHashMap().withKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f);
        ByteFloatHashMap hashMap2 = new ByteFloatHashMap().withKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f), hashMap0);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f), hashMap1);
        Assert.assertEquals(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ByteFloatHashMap hashMap = new ByteFloatHashMap().withKeysValues((byte) 1, 2.0f, (byte) 2, 3.0f, (byte) 3, 4.0f, (byte) 4, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableByteFloatMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((byte) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((byte) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((byte) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteFloatMaps.class);
    }
}
