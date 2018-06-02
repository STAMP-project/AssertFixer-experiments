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
import org.eclipse.collections.api.block.function.primitive.DoubleToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleFloatHashMapTest extends AbstractMutableDoubleFloatMapTestCase
{
    @Override
    protected DoubleFloatHashMap classUnderTest()
    {
        return DoubleFloatHashMap.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1)
    {
        return new DoubleFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2)
    {
        return new DoubleFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3)
    {
        return new DoubleFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleFloatHashMap newWithKeysValues(double key1, float value1, double key2, float value2, double key3, float value3, double key4, float value4)
    {
        return new DoubleFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleFloatHashMap getEmptyMap()
    {
        return new DoubleFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleFloatHashMap hashMap = new DoubleFloatHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);

        DoubleFloatHashMap hashMap2 = new DoubleFloatHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new DoubleFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (float) i);
        }

        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10.0f);
        hashMap.put(11.0, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (float) i);
        }

        Field keys = DoubleFloatHashMap.class.getDeclaredField("keys");
        Field values = DoubleFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);

        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f);

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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);

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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        FloatToFloatFunction function = (float floatParameter) -> floatParameter;

        hashMap.updateValue(2.0, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0, 0.0f, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);

        hashMap.getIfAbsentPut(2.0, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);

        FloatFunction0 function = () -> 5.0f;

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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);

        FloatFunction<Float> function = Float::floatValue;

        hashMap.getIfAbsentPutWith(2.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = DoubleFloatHashMap.newWithKeysValues(2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);

        DoubleToFloatFunction function = (double doubleParameter) -> (float) doubleParameter;

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
        Field occupiedWithData = DoubleFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableDoubleFloatMap copyMap = new DoubleFloatHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (float) i);
        }

        Verify.assertSize(8, copyMap);
        MutableDoubleFloatMap hashMap = new DoubleFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        DoubleFloatHashMap hashMap0 = new DoubleFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1.0f, 2.0, 2.0f), hashMap0);
        DoubleFloatHashMap hashMap1 = new DoubleFloatHashMap().withKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f);
        DoubleFloatHashMap hashMap2 = new DoubleFloatHashMap().withKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f), hashMap0);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f), hashMap1);
        Assert.assertEquals(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f, 4.0, 4.0f), hashMap2);
    }

    @Test
    public void injectInto()
    {
        DoubleFloatHashMap hashMap = new DoubleFloatHashMap().withKeysValues(1.0, 2.0f, 2.0, 3.0f, 3.0, 4.0f, 4.0, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableDoubleFloatMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((double) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((double) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((double) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleFloatMaps.class);
    }
}
