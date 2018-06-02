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
import org.eclipse.collections.api.block.function.primitive.LongToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.LongFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongFloatHashMapTest extends AbstractMutableLongFloatMapTestCase
{
    @Override
    protected LongFloatHashMap classUnderTest()
    {
        return LongFloatHashMap.newWithKeysValues(0L, 0.0f, 31L, 31.0f, 32L, 32.0f);
    }

    @Override
    protected LongFloatHashMap newWithKeysValues(long key1, float value1)
    {
        return new LongFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongFloatHashMap newWithKeysValues(long key1, float value1, long key2, float value2)
    {
        return new LongFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongFloatHashMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3)
    {
        return new LongFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongFloatHashMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3, long key4, float value4)
    {
        return new LongFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongFloatHashMap getEmptyMap()
    {
        return new LongFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = LongFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongFloatHashMap hashMap = new LongFloatHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = LongFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongFloatHashMap hashMap = new LongFloatHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);

        LongFloatHashMap hashMap2 = new LongFloatHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new LongFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = LongFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongFloatHashMap hashMap = new LongFloatHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        LongFloatHashMap hashMap = new LongFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (float) i);
        }

        Field keys = LongFloatHashMap.class.getDeclaredField("keys");
        Field values = LongFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, 10.0f);
        hashMap.put(11L, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        LongFloatHashMap hashMap = new LongFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (float) i);
        }

        Field keys = LongFloatHashMap.class.getDeclaredField("keys");
        Field values = LongFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);

        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f);

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
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);

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
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        FloatToFloatFunction function = (float floatParameter) -> floatParameter;

        hashMap.updateValue(2L, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5L, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2L, 0.0f, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = new LongFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2L, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);

        hashMap.getIfAbsentPut(2L, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);

        FloatFunction0 function = () -> 5.0f;

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
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);

        FloatFunction<Float> function = Float::floatValue;

        hashMap.getIfAbsentPutWith(2L, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5L, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2L, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = LongFloatHashMap.newWithKeysValues(2L, 2.0f, 3L, 3.0f, 4L, 4.0f);

        LongToFloatFunction function = (long longParameter) -> (float) longParameter;

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
        Field occupiedWithData = LongFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongFloatHashMap hashMap = new LongFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2L, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableLongFloatMap copyMap = new LongFloatHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (float) i);
        }

        Verify.assertSize(8, copyMap);
        MutableLongFloatMap hashMap = new LongFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        LongFloatHashMap hashMap0 = new LongFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, 1.0f, 2L, 2.0f), hashMap0);
        LongFloatHashMap hashMap1 = new LongFloatHashMap().withKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f);
        LongFloatHashMap hashMap2 = new LongFloatHashMap().withKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f, 2L, 2.0f), hashMap0);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f), hashMap1);
        Assert.assertEquals(LongFloatHashMap.newWithKeysValues(1L, 1.0f, 2L, 2.0f, 3L, 3.0f, 4L, 4.0f), hashMap2);
    }

    @Test
    public void injectInto()
    {
        LongFloatHashMap hashMap = new LongFloatHashMap().withKeysValues(1L, 2.0f, 2L, 3.0f, 3L, 4.0f, 4L, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableLongFloatMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((long) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((long) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((long) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongFloatMaps.class);
    }
}
