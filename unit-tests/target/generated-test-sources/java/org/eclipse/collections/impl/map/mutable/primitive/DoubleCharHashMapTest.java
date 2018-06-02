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

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleToCharFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleCharMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleCharHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleCharHashMapTest extends AbstractMutableDoubleCharMapTestCase
{
    @Override
    protected DoubleCharHashMap classUnderTest()
    {
        return DoubleCharHashMap.newWithKeysValues(0.0, (char) 0, 31.0, (char) 31, 32.0, (char) 32);
    }

    @Override
    protected DoubleCharHashMap newWithKeysValues(double key1, char value1)
    {
        return new DoubleCharHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleCharHashMap newWithKeysValues(double key1, char value1, double key2, char value2)
    {
        return new DoubleCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleCharHashMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3)
    {
        return new DoubleCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleCharHashMap newWithKeysValues(double key1, char value1, double key2, char value2, double key3, char value3, double key4, char value4)
    {
        return new DoubleCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleCharHashMap getEmptyMap()
    {
        return new DoubleCharHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = DoubleCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = DoubleCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleCharHashMap hashMap = new DoubleCharHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);

        DoubleCharHashMap hashMap2 = new DoubleCharHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new DoubleCharHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = DoubleCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleCharHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (char) i);
        }

        Field keys = DoubleCharHashMap.class.getDeclaredField("keys");
        Field values = DoubleCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, (char) 10);
        hashMap.put(11.0, (char) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (char) i);
        }

        Field keys = DoubleCharHashMap.class.getDeclaredField("keys");
        Field values = DoubleCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);

        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3);

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
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);

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
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        CharToCharFunction function = (char charParameter) -> charParameter;

        hashMap.updateValue(2.0, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0, (char) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0, (char) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);

        hashMap.getIfAbsentPut(2.0, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0, (char) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);

        CharFunction0 function = () -> (char) 5;

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
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);

        CharFunction<Character> function = Character::charValue;

        hashMap.getIfAbsentPutWith(2.0, function, Character.valueOf((char) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0, function, Character.valueOf((char) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = DoubleCharHashMap.newWithKeysValues(2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);

        DoubleToCharFunction function = (double doubleParameter) -> (char) doubleParameter;

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
        Field occupiedWithData = DoubleCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleCharHashMap hashMap = new DoubleCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0, (char) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableDoubleCharMap copyMap = new DoubleCharHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (char) i);
        }

        Verify.assertSize(8, copyMap);
        MutableDoubleCharMap hashMap = new DoubleCharHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        DoubleCharHashMap hashMap0 = new DoubleCharHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, (char) 1, 2.0, (char) 2), hashMap0);
        DoubleCharHashMap hashMap1 = new DoubleCharHashMap().withKeysValues(1.0, (char) 1, 2.0, (char) 2, 3.0, (char) 3);
        DoubleCharHashMap hashMap2 = new DoubleCharHashMap().withKeysValues(1.0, (char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1, 2.0, (char) 2), hashMap0);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1, 2.0, (char) 2, 3.0, (char) 3), hashMap1);
        Assert.assertEquals(DoubleCharHashMap.newWithKeysValues(1.0, (char) 1, 2.0, (char) 2, 3.0, (char) 3, 4.0, (char) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        DoubleCharHashMap hashMap = new DoubleCharHashMap().withKeysValues(1.0, (char) 2, 2.0, (char) 3, 3.0, (char) 4, 4.0, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableDoubleCharMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((double) i));
            Assert.assertEquals(1L, hashMap.updateValue((double) i, (char) 0, incrementFunction));
            Assert.assertEquals((char) 1, hashMap.get((double) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleCharMaps.class);
    }
}
