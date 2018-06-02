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
import org.eclipse.collections.api.block.function.primitive.FloatToCharFunction;
import org.eclipse.collections.impl.factory.primitive.FloatCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableFloatCharMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatCharHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class FloatCharHashMapTest extends AbstractMutableFloatCharMapTestCase
{
    @Override
    protected FloatCharHashMap classUnderTest()
    {
        return FloatCharHashMap.newWithKeysValues(0.0f, (char) 0, 31.0f, (char) 31, 32.0f, (char) 32);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1)
    {
        return new FloatCharHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2)
    {
        return new FloatCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3)
    {
        return new FloatCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatCharHashMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3, float key4, char value4)
    {
        return new FloatCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatCharHashMap getEmptyMap()
    {
        return new FloatCharHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatCharHashMap hashMap = new FloatCharHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);

        FloatCharHashMap hashMap2 = new FloatCharHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new FloatCharHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatCharHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (char) i);
        }

        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0f, (char) 10);
        hashMap.put(11.0f, (char) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        FloatCharHashMap hashMap = new FloatCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (char) i);
        }

        Field keys = FloatCharHashMap.class.getDeclaredField("keys");
        Field values = FloatCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);

        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3);

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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        CharToCharFunction function = (char charParameter) -> charParameter;

        hashMap.updateValue(2.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, (char) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, (char) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        hashMap.getIfAbsentPut(2.0f, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, (char) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        CharFunction0 function = () -> (char) 5;

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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        CharFunction<Character> function = Character::charValue;

        hashMap.getIfAbsentPutWith(2.0f, function, Character.valueOf((char) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0f, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0f, function, Character.valueOf((char) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = FloatCharHashMap.newWithKeysValues(2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);

        FloatToCharFunction function = (float floatParameter) -> (char) floatParameter;

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
        Field occupiedWithData = FloatCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatCharHashMap hashMap = new FloatCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((float) i));
            hashMap.put((float) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, (char) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableFloatCharMap copyMap = new FloatCharHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((float) i));
            copyMap.put((float) i, (char) i);
        }

        Verify.assertSize(8, copyMap);
        MutableFloatCharMap hashMap = new FloatCharHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((float) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        FloatCharHashMap hashMap0 = new FloatCharHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, (char) 1, 2.0f, (char) 2), hashMap0);
        FloatCharHashMap hashMap1 = new FloatCharHashMap().withKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3);
        FloatCharHashMap hashMap2 = new FloatCharHashMap().withKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2), hashMap0);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3), hashMap1);
        Assert.assertEquals(FloatCharHashMap.newWithKeysValues(1.0f, (char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        FloatCharHashMap hashMap = new FloatCharHashMap().withKeysValues(1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableFloatCharMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((float) i));
            Assert.assertEquals(1L, hashMap.updateValue((float) i, (char) 0, incrementFunction));
            Assert.assertEquals((char) 1, hashMap.get((float) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatCharMaps.class);
    }
}
