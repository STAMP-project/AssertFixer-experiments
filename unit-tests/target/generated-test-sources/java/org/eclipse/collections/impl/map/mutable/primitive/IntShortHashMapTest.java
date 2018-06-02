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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.impl.factory.primitive.IntShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableIntShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class IntShortHashMapTest extends AbstractMutableIntShortMapTestCase
{
    @Override
    protected IntShortHashMap classUnderTest()
    {
        return IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1)
    {
        return new IntShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2)
    {
        return new IntShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3)
    {
        return new IntShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntShortHashMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3, int key4, short value4)
    {
        return new IntShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntShortHashMap getEmptyMap()
    {
        return new IntShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntShortHashMap hashMap = new IntShortHashMap(3);
        Assert.assertEquals(8L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);

        IntShortHashMap hashMap2 = new IntShortHashMap(15);
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new IntShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new IntShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        IntShortHashMap hashMap = new IntShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (short) i);
        }

        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        Field values = IntShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10, (short) 10);
        hashMap.put(11, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        IntShortHashMap hashMap = new IntShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, (short) i);
        }

        Field keys = IntShortHashMap.class.getDeclaredField("keys");
        Field values = IntShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);

        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3);

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
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);

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
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ShortToShortFunction function = (short shortParameter) -> shortParameter;

        hashMap.updateValue(2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2, (short) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2, (short) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);

        hashMap.getIfAbsentPut(2, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2, (short) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);

        ShortFunction0 function = () -> (short) 5;

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
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);

        ShortFunction<Short> function = Short::shortValue;

        hashMap.getIfAbsentPutWith(2, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2, function, Short.valueOf((short) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = IntShortHashMap.newWithKeysValues(2, (short) 2, 3, (short) 3, 4, (short) 4);

        IntToShortFunction function = (int intParameter) -> (short) intParameter;

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
        Field occupiedWithData = IntShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntShortHashMap hashMap = new IntShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2, (short) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableIntShortMap copyMap = new IntShortHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (short) i);
        }

        Verify.assertSize(8, copyMap);
        MutableIntShortMap hashMap = new IntShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        IntShortHashMap hashMap0 = new IntShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1, (short) 1, 2, (short) 2), hashMap0);
        IntShortHashMap hashMap1 = new IntShortHashMap().withKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3);
        IntShortHashMap hashMap2 = new IntShortHashMap().withKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2), hashMap0);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3), hashMap1);
        Assert.assertEquals(IntShortHashMap.newWithKeysValues(1, (short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        IntShortHashMap hashMap = new IntShortHashMap().withKeysValues(1, (short) 2, 2, (short) 3, 3, (short) 4, 4, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);

        MutableIntShortMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((short) 0, hashMap.get(i));
            Assert.assertEquals(1L, hashMap.updateValue(i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get(i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntShortMaps.class);
    }
}
