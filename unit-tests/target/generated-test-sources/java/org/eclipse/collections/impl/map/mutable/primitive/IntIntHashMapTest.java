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
import org.eclipse.collections.impl.factory.primitive.IntIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableIntIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class IntIntHashMapTest extends AbstractMutableIntIntMapTestCase
{
    @Override
    protected IntIntHashMap classUnderTest()
    {
        return IntIntHashMap.newWithKeysValues(0, 0, 31, 31, 32, 32);
    }

    @Override
    protected IntIntHashMap newWithKeysValues(int key1, int value1)
    {
        return new IntIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected IntIntHashMap newWithKeysValues(int key1, int value1, int key2, int value2)
    {
        return new IntIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected IntIntHashMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3)
    {
        return new IntIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntIntHashMap newWithKeysValues(int key1, int value1, int key2, int value2, int key3, int value3, int key4, int value4)
    {
        return new IntIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntIntHashMap getEmptyMap()
    {
        return new IntIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keysValues = IntIntHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        IntIntHashMap hashMap = new IntIntHashMap();
        Assert.assertEquals(32L, ((int[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keysValues = IntIntHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        IntIntHashMap hashMap = new IntIntHashMap(3);
        Assert.assertEquals(16L, ((int[]) keysValues.get(hashMap)).length);

        IntIntHashMap hashMap2 = new IntIntHashMap(15);
        Assert.assertEquals(64L, ((int[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new IntIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keysValues = IntIntHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);

        IntIntHashMap hashMap = new IntIntHashMap();
        Assert.assertEquals(32L, ((int[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new IntIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        IntIntHashMap hashMap = new IntIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, i);
        }

        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10, 10);
        hashMap.put(11, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        IntIntHashMap hashMap = new IntIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, i);
        }

        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3);

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
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3, 4, 4);

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
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3, 4, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        IntToIntFunction function = (int intParameter) -> intParameter;

        hashMap.updateValue(2, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2, 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = new IntIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2, 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3, 4, 4);

        hashMap.getIfAbsentPut(2, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2, 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3, 4, 4);

        IntFunction0 function = () -> 5;

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
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3, 4, 4);

        IntFunction<Integer> function = Integer::intValue;

        hashMap.getIfAbsentPutWith(2, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2, function, Integer.valueOf(5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = IntIntHashMap.newWithKeysValues(2, 2, 3, 3, 4, 4);

        IntToIntFunction function = (int intParameter) -> (int) intParameter;

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
        Field occupiedWithData = IntIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntIntHashMap hashMap = new IntIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2, 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableIntIntMap copyMap = new IntIntHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, i);
        }

        Verify.assertSize(8, copyMap);
        MutableIntIntMap hashMap = new IntIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        IntIntHashMap hashMap0 = new IntIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1, 1, 2, 2), hashMap0);
        IntIntHashMap hashMap1 = new IntIntHashMap().withKeysValues(1, 1, 2, 2, 3, 3);
        IntIntHashMap hashMap2 = new IntIntHashMap().withKeysValues(1, 1, 2, 2, 3, 3, 4, 4);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1, 2, 2), hashMap0);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1, 2, 2, 3, 3), hashMap1);
        Assert.assertEquals(IntIntHashMap.newWithKeysValues(1, 1, 2, 2, 3, 3, 4, 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        IntIntHashMap hashMap = new IntIntHashMap().withKeysValues(1, 2, 2, 3, 3, 4, 4, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableIntIntMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get(i));
            Assert.assertEquals(1L, hashMap.updateValue(i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get(i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntIntMaps.class);
    }
}
