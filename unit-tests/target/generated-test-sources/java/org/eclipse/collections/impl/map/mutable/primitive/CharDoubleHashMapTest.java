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
import org.eclipse.collections.api.block.function.primitive.CharToDoubleFunction;
import org.eclipse.collections.impl.factory.primitive.CharDoubleMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharDoubleHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharDoubleHashMapTest extends AbstractMutableCharDoubleMapTestCase
{
    @Override
    protected CharDoubleHashMap classUnderTest()
    {
        return CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0);
    }

    @Override
    protected CharDoubleHashMap newWithKeysValues(char key1, double value1)
    {
        return new CharDoubleHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharDoubleHashMap newWithKeysValues(char key1, double value1, char key2, double value2)
    {
        return new CharDoubleHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharDoubleHashMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3)
    {
        return new CharDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharDoubleHashMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4)
    {
        return new CharDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharDoubleHashMap getEmptyMap()
    {
        return new CharDoubleHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = CharDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = CharDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharDoubleHashMap hashMap = new CharDoubleHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((double[]) values.get(hashMap)).length);

        CharDoubleHashMap hashMap2 = new CharDoubleHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((double[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharDoubleHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = CharDoubleHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharDoubleHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharDoubleHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (double) i);
        }

        Field keys = CharDoubleHashMap.class.getDeclaredField("keys");
        Field values = CharDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, 10.0);
        hashMap.put((char) 11, 11.0);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (double) i);
        }

        Field keys = CharDoubleHashMap.class.getDeclaredField("keys");
        Field values = CharDoubleHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((double[]) values.get(hashMap)).length);

        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove((char) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove((char) 6);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((char) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        DoubleToDoubleFunction function = (double doubleParameter) -> doubleParameter;

        hashMap.updateValue((char) 2, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 5, 0.0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 2, 0.0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((char) 2, 9.0); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);

        hashMap.getIfAbsentPut((char) 2, 5.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 5, 5.0);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 2, 5.0); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);

        DoubleFunction0 function = () -> 5.0;

        hashMap.getIfAbsentPut((char) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);

        DoubleFunction<Double> function = Double::doubleValue;

        hashMap.getIfAbsentPutWith((char) 2, function, Double.valueOf(5.0));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 5, function, Double.valueOf(5.0));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 2, function, Double.valueOf(5.0)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = CharDoubleHashMap.newWithKeysValues((char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);

        CharToDoubleFunction function = (char charParameter) -> (double) charParameter;

        hashMap.getIfAbsentPutWithKey((char) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((char) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((char) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = CharDoubleHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharDoubleHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharDoubleHashMap hashMap = new CharDoubleHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (double) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((char) 2, 3.0); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableCharDoubleMap copyMap = new CharDoubleHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (double) i);
        }

        Verify.assertSize(8, copyMap);
        MutableCharDoubleMap hashMap = new CharDoubleHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((double) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        CharDoubleHashMap hashMap0 = new CharDoubleHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, 1.0, (char) 2, 2.0), hashMap0);
        CharDoubleHashMap hashMap1 = new CharDoubleHashMap().withKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0);
        CharDoubleHashMap hashMap2 = new CharDoubleHashMap().withKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0), hashMap0);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0), hashMap1);
        Assert.assertEquals(CharDoubleHashMap.newWithKeysValues((char) 1, 1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0), hashMap2);
    }

    @Test
    public void injectInto()
    {
        CharDoubleHashMap hashMap = new CharDoubleHashMap().withKeysValues((char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4, 5.0);
        Double sum = hashMap.injectInto(Double.valueOf(1.0), (Double result, double value) -> Double.valueOf((double) (result + value)));
        Assert.assertEquals(Double.valueOf(15.0), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;

        MutableCharDoubleMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0, hashMap.get((char) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((char) i, 0.0, incrementFunction), 0.0);
            Assert.assertEquals(1.0, hashMap.get((char) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharDoubleMaps.class);
    }
}
