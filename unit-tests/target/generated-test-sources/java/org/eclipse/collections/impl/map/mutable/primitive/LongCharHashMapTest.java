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
import org.eclipse.collections.api.block.function.primitive.LongToCharFunction;
import org.eclipse.collections.impl.factory.primitive.LongCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongCharHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongCharHashMapTest extends AbstractMutableLongCharMapTestCase
{
    @Override
    protected LongCharHashMap classUnderTest()
    {
        return LongCharHashMap.newWithKeysValues(0L, (char) 0, 31L, (char) 31, 32L, (char) 32);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1)
    {
        return new LongCharHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1, long key2, char value2)
    {
        return new LongCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3)
    {
        return new LongCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongCharHashMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3, long key4, char value4)
    {
        return new LongCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongCharHashMap getEmptyMap()
    {
        return new LongCharHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongCharHashMap hashMap = new LongCharHashMap(3);
        Assert.assertEquals(8L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);

        LongCharHashMap hashMap2 = new LongCharHashMap(15);
        Assert.assertEquals(32L, ((long[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new LongCharHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = LongCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(new LongCharHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        LongCharHashMap hashMap = new LongCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (char) i);
        }

        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        Field values = LongCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, (char) 10);
        hashMap.put(11L, (char) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        LongCharHashMap hashMap = new LongCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (char) i);
        }

        Field keys = LongCharHashMap.class.getDeclaredField("keys");
        Field values = LongCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((long[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);

        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(5, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        CharToCharFunction function = (char charParameter) -> charParameter;

        hashMap.updateValue(2L, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5L, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2L, (char) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2L, (char) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);

        hashMap.getIfAbsentPut(2L, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, (char) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);

        CharFunction0 function = () -> (char) 5;

        hashMap.getIfAbsentPut(2L, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);

        CharFunction<Character> function = Character::charValue;

        hashMap.getIfAbsentPutWith(2L, function, Character.valueOf((char) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5L, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2L, function, Character.valueOf((char) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = LongCharHashMap.newWithKeysValues(2L, (char) 2, 3L, (char) 3, 4L, (char) 4);

        LongToCharFunction function = (long longParameter) -> (char) longParameter;

        hashMap.getIfAbsentPutWithKey(2L, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5L, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2L, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = LongCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongCharHashMap hashMap = new LongCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2L, (char) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableLongCharMap copyMap = new LongCharHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (char) i);
        }

        Verify.assertSize(8, copyMap);
        MutableLongCharMap hashMap = new LongCharHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        LongCharHashMap hashMap0 = new LongCharHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, (char) 1, 2L, (char) 2), hashMap0);
        LongCharHashMap hashMap1 = new LongCharHashMap().withKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3);
        LongCharHashMap hashMap2 = new LongCharHashMap().withKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2), hashMap0);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3), hashMap1);
        Assert.assertEquals(LongCharHashMap.newWithKeysValues(1L, (char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        LongCharHashMap hashMap = new LongCharHashMap().withKeysValues(1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableLongCharMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, (char) 0, incrementFunction));
            Assert.assertEquals((char) 1, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongCharMaps.class);
    }
}
