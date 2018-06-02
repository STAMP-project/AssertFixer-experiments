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
import org.eclipse.collections.api.block.function.primitive.ShortToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.ShortDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortDoubleHashMapTest extends AbstractMutableShortDoubleMapTestCase
{
    @Override
    protected ShortDoubleHashMap classUnderTest()
    {
        return ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0, (short) 31, 31.0, (short) 32, 32.0);
    }

    @Override
    protected ShortDoubleHashMap newWithKeysValues(short key1, double value1)
    {
        return new ShortDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortDoubleHashMap newWithKeysValues(short key1, double value1, short key2, double value2)
    {
        return new ShortDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortDoubleHashMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3)
    {
        return new ShortDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortDoubleHashMap newWithKeysValues(short key1, double value1, short key2, double value2, short key3, double value3, short key4, double value4)
    {
        return new ShortDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortDoubleHashMap getEmptyMap()
    {
        return new ShortDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ShortDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ShortDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortDoubleHashMap hashMap = new ShortDoubleHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);

        ShortDoubleHashMap hashMap2 = new ShortDoubleHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ShortDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (double) i);
        }

        Field keys = ShortDoubleHashMap.class.getDeclaredField("keys");
        Field values = ShortDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, 10.0);
        hashMap.put((short) 11, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (double) i);
        }

        Field keys = ShortDoubleHashMap.class.getDeclaredField("keys");
        Field values = ShortDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);

        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove((short) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove((short) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((short) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;

        hashMap.updateValue((short) 2, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 5, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 2, 0.0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((short) 2, 9.0); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);

        hashMap.getIfAbsentPut((short) 2, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, 5.0); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);

        DoubleFunction0 function = () -> 5.0;

        hashMap.getIfAbsentPut((short) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);

        DoubleFunction<Double> function = Double::doubleValue;

        hashMap.getIfAbsentPutWith((short) 2, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 5, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 2, function, Double.valueOf(5.0)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = ShortDoubleHashMap.newWithKeysValues((short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);

        ShortToDoubleFunction function = (short shortParameter) -> (double) shortParameter;

        hashMap.getIfAbsentPutWithKey((short) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((short) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((short) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = ShortDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((short) 2, 3.0); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableShortDoubleMap copyMap = new ShortDoubleHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (double) i);
        }

        Verify.assertSize(8, copyMap);
        MutableShortDoubleMap hashMap = new ShortDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ShortDoubleHashMap hashMap0 = new ShortDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, 1.0, (short) 2, 2.0), hashMap0);
        ShortDoubleHashMap hashMap1 = new ShortDoubleHashMap().withKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0);
        ShortDoubleHashMap hashMap2 = new ShortDoubleHashMap().withKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0), hashMap0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0), hashMap1);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 1, 1.0, (short) 2, 2.0, (short) 3, 3.0, (short) 4, 4.0), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortDoubleHashMap hashMap = new ShortDoubleHashMap().withKeysValues((short) 1, 2.0, (short) 2, 3.0, (short) 3, 4.0, (short) 4, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableShortDoubleMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((short) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((short) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((short) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortDoubleMaps.class);
    }
}
