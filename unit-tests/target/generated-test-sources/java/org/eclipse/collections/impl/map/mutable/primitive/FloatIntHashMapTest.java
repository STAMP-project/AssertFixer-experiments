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
import org.eclipse.collections.api.block.function.primitive.FloatToIntFunction;
import org.eclipse.collections.impl.factory.primitive.FloatIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableFloatIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class FloatIntHashMapTest extends AbstractMutableFloatIntMapTestCase
{
    @Override
    protected FloatIntHashMap classUnderTest()
    {
        return FloatIntHashMap.newWithKeysValues(0.0f, 0, 31.0f, 31, 32.0f, 32);
    }

    @Override
    protected FloatIntHashMap newWithKeysValues(float key1, int value1)
    {
        return new FloatIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatIntHashMap newWithKeysValues(float key1, int value1, float key2, int value2)
    {
        return new FloatIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatIntHashMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3)
    {
        return new FloatIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatIntHashMap newWithKeysValues(float key1, int value1, float key2, int value2, float key3, int value3, float key4, int value4)
    {
        return new FloatIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatIntHashMap getEmptyMap()
    {
        return new FloatIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = FloatIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatIntHashMap hashMap = new FloatIntHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = FloatIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatIntHashMap hashMap = new FloatIntHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);

        FloatIntHashMap hashMap2 = new FloatIntHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new FloatIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = FloatIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatIntHashMap hashMap = new FloatIntHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        FloatIntHashMap hashMap = new FloatIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, i);
        }

        Field keys = FloatIntHashMap.class.getDeclaredField("keys");
        Field values = FloatIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0f, 10);
        hashMap.put(11.0f, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        FloatIntHashMap hashMap = new FloatIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, i);
        }

        Field keys = FloatIntHashMap.class.getDeclaredField("keys");
        Field values = FloatIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);

        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        IntToIntFunction function = (int intParameter) -> intParameter;

        hashMap.updateValue(2.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = new FloatIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        hashMap.getIfAbsentPut(2.0f, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        IntFunction0 function = () -> 5;

        hashMap.getIfAbsentPut(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        IntFunction<Integer> function = Integer::intValue;

        hashMap.getIfAbsentPutWith(2.0f, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0f, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0f, function, Integer.valueOf(5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = FloatIntHashMap.newWithKeysValues(2.0f, 2, 3.0f, 3, 4.0f, 4);

        FloatToIntFunction function = (float floatParameter) -> (int) floatParameter;

        hashMap.getIfAbsentPutWithKey(2.0f, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5.0f, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2.0f, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = FloatIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatIntHashMap hashMap = new FloatIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableFloatIntMap copyMap = new FloatIntHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((float) i));
            copyMap.put((float) i, i);
        }

        Verify.assertSize(8, copyMap);
        MutableFloatIntMap hashMap = new FloatIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        FloatIntHashMap hashMap0 = new FloatIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, 1, 2.0f, 2), hashMap0);
        FloatIntHashMap hashMap1 = new FloatIntHashMap().withKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        FloatIntHashMap hashMap2 = new FloatIntHashMap().withKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3, 4.0f, 4);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2), hashMap0);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3), hashMap1);
        Assert.assertEquals(FloatIntHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3, 4.0f, 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        FloatIntHashMap hashMap = new FloatIntHashMap().withKeysValues(1.0f, 2, 2.0f, 3, 3.0f, 4, 4.0f, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableFloatIntMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((float) i));
            Assert.assertEquals(1L, hashMap.updateValue((float) i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get((float) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatIntMaps.class);
    }
}
