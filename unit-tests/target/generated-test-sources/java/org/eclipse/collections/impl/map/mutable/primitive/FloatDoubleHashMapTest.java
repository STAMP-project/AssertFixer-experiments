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
import org.eclipse.collections.api.block.function.primitive.FloatToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.FloatDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class FloatDoubleHashMapTest extends AbstractMutableFloatDoubleMapTestCase
{
    @Override
    protected FloatDoubleHashMap classUnderTest()
    {
        return FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0);
    }

    @Override
    protected FloatDoubleHashMap newWithKeysValues(float key1, double value1)
    {
        return new FloatDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatDoubleHashMap newWithKeysValues(float key1, double value1, float key2, double value2)
    {
        return new FloatDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatDoubleHashMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3)
    {
        return new FloatDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatDoubleHashMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4)
    {
        return new FloatDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatDoubleHashMap getEmptyMap()
    {
        return new FloatDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = FloatDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = FloatDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatDoubleHashMap hashMap = new FloatDoubleHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);

        FloatDoubleHashMap hashMap2 = new FloatDoubleHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new FloatDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = FloatDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (double) i);
        }

        Field keys = FloatDoubleHashMap.class.getDeclaredField("keys");
        Field values = FloatDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0f, 10.0);
        hashMap.put(11.0f, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (double) i);
        }

        Field keys = FloatDoubleHashMap.class.getDeclaredField("keys");
        Field values = FloatDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);

        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0);

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
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);

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
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;

        hashMap.updateValue(2.0f, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, 0.0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, 9.0); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);

        hashMap.getIfAbsentPut(2.0f, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, 5.0); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);

        DoubleFunction0 function = () -> 5.0;

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
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);

        DoubleFunction<Double> function = Double::doubleValue;

        hashMap.getIfAbsentPutWith(2.0f, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0f, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0f, function, Double.valueOf(5.0)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = FloatDoubleHashMap.newWithKeysValues(2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);

        FloatToDoubleFunction function = (float floatParameter) -> (double) floatParameter;

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
        Field occupiedWithData = FloatDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, 3.0); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableFloatDoubleMap copyMap = new FloatDoubleHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((float) i));
            copyMap.put((float) i, (double) i);
        }

        Verify.assertSize(8, copyMap);
        MutableFloatDoubleMap hashMap = new FloatDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        FloatDoubleHashMap hashMap0 = new FloatDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, 1.0, 2.0f, 2.0), hashMap0);
        FloatDoubleHashMap hashMap1 = new FloatDoubleHashMap().withKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0);
        FloatDoubleHashMap hashMap2 = new FloatDoubleHashMap().withKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0), hashMap0);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0), hashMap1);
        Assert.assertEquals(FloatDoubleHashMap.newWithKeysValues(1.0f, 1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0), hashMap2);
    }

    @Test
    public void injectInto()
    {
        FloatDoubleHashMap hashMap = new FloatDoubleHashMap().withKeysValues(1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableFloatDoubleMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((float) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((float) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((float) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatDoubleMaps.class);
    }
}
