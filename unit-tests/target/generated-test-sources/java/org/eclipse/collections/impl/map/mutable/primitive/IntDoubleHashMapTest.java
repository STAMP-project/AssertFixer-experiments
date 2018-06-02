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
import org.eclipse.collections.api.block.function.primitive.IntToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.IntDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableIntDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class IntDoubleHashMapTest extends AbstractMutableIntDoubleMapTestCase
{
    @Override
    protected IntDoubleHashMap classUnderTest()
    {
        return IntDoubleHashMap.newWithKeysValues(0, 0.0, 31, 31.0, 32, 32.0);
    }

    @Override
    protected IntDoubleHashMap newWithKeysValues(int key1, double value1)
    {
        return new IntDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected IntDoubleHashMap newWithKeysValues(int key1, double value1, int key2, double value2)
    {
        return new IntDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected IntDoubleHashMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3)
    {
        return new IntDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntDoubleHashMap newWithKeysValues(int key1, double value1, int key2, double value2, int key3, double value3, int key4, double value4)
    {
        return new IntDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntDoubleHashMap getEmptyMap()
    {
        return new IntDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = IntDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = IntDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntDoubleHashMap hashMap = new IntDoubleHashMap(3);
        Assert.assertEquals(8L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);

        IntDoubleHashMap hashMap2 = new IntDoubleHashMap(15);
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new IntDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = IntDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new IntDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (double) i);
        }

        Field keys = IntDoubleHashMap.class.getDeclaredField("keys");
        Field values = IntDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10, 10.0);
        hashMap.put(11, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, (double) i);
        }

        Field keys = IntDoubleHashMap.class.getDeclaredField("keys");
        Field values = IntDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);

        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;

        hashMap.updateValue(2, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2, 0.0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2, 9.0); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);

        hashMap.getIfAbsentPut(2, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2, 5.0); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);

        DoubleFunction0 function = () -> 5.0;

        hashMap.getIfAbsentPut(2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);

        DoubleFunction<Double> function = Double::doubleValue;

        hashMap.getIfAbsentPutWith(2, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2, function, Double.valueOf(5.0)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = IntDoubleHashMap.newWithKeysValues(2, 2.0, 3, 3.0, 4, 4.0);

        IntToDoubleFunction function = (int intParameter) -> (double) intParameter;

        hashMap.getIfAbsentPutWithKey(2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = IntDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntDoubleHashMap hashMap = new IntDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2, 3.0); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableIntDoubleMap copyMap = new IntDoubleHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (double) i);
        }

        Verify.assertSize(8, copyMap);
        MutableIntDoubleMap hashMap = new IntDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        IntDoubleHashMap hashMap0 = new IntDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1, 1.0, 2, 2.0), hashMap0);
        IntDoubleHashMap hashMap1 = new IntDoubleHashMap().withKeysValues(1, 1.0, 2, 2.0, 3, 3.0);
        IntDoubleHashMap hashMap2 = new IntDoubleHashMap().withKeysValues(1, 1.0, 2, 2.0, 3, 3.0, 4, 4.0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0), hashMap0);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0), hashMap1);
        Assert.assertEquals(IntDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0, 3, 3.0, 4, 4.0), hashMap2);
    }

    @Test
    public void injectInto()
    {
        IntDoubleHashMap hashMap = new IntDoubleHashMap().withKeysValues(1, 2.0, 2, 3.0, 3, 4.0, 4, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableIntDoubleMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get(i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue(i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get(i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntDoubleMaps.class);
    }
}
