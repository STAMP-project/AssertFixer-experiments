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
import org.eclipse.collections.api.block.function.primitive.ShortToIntFunction;
import org.eclipse.collections.impl.factory.primitive.ShortIntMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortIntHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortIntHashMapTest extends AbstractMutableShortIntMapTestCase
{
    @Override
    protected ShortIntHashMap classUnderTest()
    {
        return ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32);
    }

    @Override
    protected ShortIntHashMap newWithKeysValues(short key1, int value1)
    {
        return new ShortIntHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortIntHashMap newWithKeysValues(short key1, int value1, short key2, int value2)
    {
        return new ShortIntHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortIntHashMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3)
    {
        return new ShortIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortIntHashMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4)
    {
        return new ShortIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortIntHashMap getEmptyMap()
    {
        return new ShortIntHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ShortIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortIntHashMap hashMap = new ShortIntHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ShortIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortIntHashMap hashMap = new ShortIntHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((int[]) values.get(hashMap)).length);

        ShortIntHashMap hashMap2 = new ShortIntHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((int[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortIntHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ShortIntHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortIntHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortIntHashMap hashMap = new ShortIntHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortIntHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortIntHashMap hashMap = new ShortIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, i);
        }

        Field keys = ShortIntHashMap.class.getDeclaredField("keys");
        Field values = ShortIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, 10);
        hashMap.put((short) 11, 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ShortIntHashMap hashMap = new ShortIntHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, i);
        }

        Field keys = ShortIntHashMap.class.getDeclaredField("keys");
        Field values = ShortIntHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((int[]) values.get(hashMap)).length);

        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3);

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
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);

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
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        IntToIntFunction function = (int intParameter) -> intParameter;

        hashMap.updateValue((short) 2, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 5, 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 2, 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = new ShortIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((short) 2, 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);

        hashMap.getIfAbsentPut((short) 2, 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);

        IntFunction0 function = () -> 5;

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
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);

        IntFunction<Integer> function = Integer::intValue;

        hashMap.getIfAbsentPutWith((short) 2, function, Integer.valueOf(5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 5, function, Integer.valueOf(5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 2, function, Integer.valueOf(5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = ShortIntHashMap.newWithKeysValues((short) 2, 2, (short) 3, 3, (short) 4, 4);

        ShortToIntFunction function = (short shortParameter) -> (int) shortParameter;

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
        Field occupiedWithData = ShortIntHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortIntHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortIntHashMap hashMap = new ShortIntHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((short) 2, 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableShortIntMap copyMap = new ShortIntHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, i);
        }

        Verify.assertSize(8, copyMap);
        MutableShortIntMap hashMap = new ShortIntHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue(i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ShortIntHashMap hashMap0 = new ShortIntHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, 1, (short) 2, 2), hashMap0);
        ShortIntHashMap hashMap1 = new ShortIntHashMap().withKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3);
        ShortIntHashMap hashMap2 = new ShortIntHashMap().withKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3, (short) 4, 4);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2), hashMap0);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3), hashMap1);
        Assert.assertEquals(ShortIntHashMap.newWithKeysValues((short) 1, 1, (short) 2, 2, (short) 3, 3, (short) 4, 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortIntHashMap hashMap = new ShortIntHashMap().withKeysValues((short) 1, 2, (short) 2, 3, (short) 3, 4, (short) 4, 5);
        Integer sum = hashMap.injectInto(Integer.valueOf(1), (Integer result, int value) -> Integer.valueOf((int) (result + value)));
        Assert.assertEquals(Integer.valueOf(15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;

        MutableShortIntMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0, hashMap.get((short) i));
            Assert.assertEquals(1L, hashMap.updateValue((short) i, 0, incrementFunction));
            Assert.assertEquals(1, hashMap.get((short) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortIntMaps.class);
    }
}
