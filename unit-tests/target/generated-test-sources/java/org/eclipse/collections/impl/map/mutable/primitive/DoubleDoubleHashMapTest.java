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
import org.eclipse.collections.impl.factory.primitive.DoubleDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleDoubleHashMapTest extends AbstractMutableDoubleDoubleMapTestCase
{
    @Override
    protected DoubleDoubleHashMap classUnderTest()
    {
        return DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1)
    {
        return new DoubleDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1, double key2, double value2)
    {
        return new DoubleDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3)
    {
        return new DoubleDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleDoubleHashMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3, double key4, double value4)
    {
        return new DoubleDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleDoubleHashMap getEmptyMap()
    {
        return new DoubleDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keysValues = DoubleDoubleHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(32L, ((double[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keysValues = DoubleDoubleHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap(3);
        Assert.assertEquals(16L, ((double[]) keysValues.get(hashMap)).length);

        DoubleDoubleHashMap hashMap2 = new DoubleDoubleHashMap(15);
        Assert.assertEquals(64L, ((double[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new DoubleDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keysValues = DoubleDoubleHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);

        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(32L, ((double[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new DoubleDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (double) i);
        }

        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10.0);
        hashMap.put(11.0, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (double) i);
        }

        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0);

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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);

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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;

        hashMap.updateValue(2.0, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0, 0.0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0, 9.0); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);

        hashMap.getIfAbsentPut(2.0, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0, 5.0); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);

        DoubleFunction0 function = () -> 5.0;

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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);

        DoubleFunction<Double> function = Double::doubleValue;

        hashMap.getIfAbsentPutWith(2.0, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0, function, Double.valueOf(5.0)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = DoubleDoubleHashMap.newWithKeysValues(2.0, 2.0, 3.0, 3.0, 4.0, 4.0);

        DoubleToDoubleFunction function = (double doubleParameter) -> (double) doubleParameter;

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
        Field occupiedWithData = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0, 3.0); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableDoubleDoubleMap copyMap = new DoubleDoubleHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (double) i);
        }

        Verify.assertSize(8, copyMap);
        MutableDoubleDoubleMap hashMap = new DoubleDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        DoubleDoubleHashMap hashMap0 = new DoubleDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1.0, 2.0, 2.0), hashMap0);
        DoubleDoubleHashMap hashMap1 = new DoubleDoubleHashMap().withKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0);
        DoubleDoubleHashMap hashMap2 = new DoubleDoubleHashMap().withKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0), hashMap0);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0), hashMap1);
        Assert.assertEquals(DoubleDoubleHashMap.newWithKeysValues(1.0, 1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0), hashMap2);
    }

    @Test
    public void injectInto()
    {
        DoubleDoubleHashMap hashMap = new DoubleDoubleHashMap().withKeysValues(1.0, 2.0, 2.0, 3.0, 3.0, 4.0, 4.0, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableDoubleDoubleMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((double) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((double) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((double) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleDoubleMaps.class);
    }
}
