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
import org.eclipse.collections.api.block.function.primitive.ShortToCharFunction;
import org.eclipse.collections.impl.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortCharMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortCharHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortCharHashMapTest extends AbstractMutableShortCharMapTestCase
{
    @Override
    protected ShortCharHashMap classUnderTest()
    {
        return ShortCharHashMap.newWithKeysValues((short) 0, (char) 0, (short) 31, (char) 31, (short) 32, (char) 32);
    }

    @Override
    protected ShortCharHashMap newWithKeysValues(short key1, char value1)
    {
        return new ShortCharHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortCharHashMap newWithKeysValues(short key1, char value1, short key2, char value2)
    {
        return new ShortCharHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortCharHashMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3)
    {
        return new ShortCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortCharHashMap newWithKeysValues(short key1, char value1, short key2, char value2, short key3, char value3, short key4, char value4)
    {
        return new ShortCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortCharHashMap getEmptyMap()
    {
        return new ShortCharHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ShortCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortCharHashMap hashMap = new ShortCharHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ShortCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortCharHashMap hashMap = new ShortCharHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((char[]) values.get(hashMap)).length);

        ShortCharHashMap hashMap2 = new ShortCharHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((char[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortCharHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ShortCharHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortCharHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortCharHashMap hashMap = new ShortCharHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortCharHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortCharHashMap hashMap = new ShortCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (char) i);
        }

        Field keys = ShortCharHashMap.class.getDeclaredField("keys");
        Field values = ShortCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, (char) 10);
        hashMap.put((short) 11, (char) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ShortCharHashMap hashMap = new ShortCharHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (char) i);
        }

        Field keys = ShortCharHashMap.class.getDeclaredField("keys");
        Field values = ShortCharHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((char[]) values.get(hashMap)).length);

        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3);

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
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);

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
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        CharToCharFunction function = (char charParameter) -> charParameter;

        hashMap.updateValue((short) 2, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 5, (char) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 2, (char) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = new ShortCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((short) 2, (char) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);

        hashMap.getIfAbsentPut((short) 2, (char) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, (char) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, (char) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);

        CharFunction0 function = () -> (char) 5;

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
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);

        CharFunction<Character> function = Character::charValue;

        hashMap.getIfAbsentPutWith((short) 2, function, Character.valueOf((char) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 5, function, Character.valueOf((char) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 2, function, Character.valueOf((char) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = ShortCharHashMap.newWithKeysValues((short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);

        ShortToCharFunction function = (short shortParameter) -> (char) shortParameter;

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
        Field occupiedWithData = ShortCharHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortCharHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortCharHashMap hashMap = new ShortCharHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (char) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((short) 2, (char) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableShortCharMap copyMap = new ShortCharHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (char) i);
        }

        Verify.assertSize(8, copyMap);
        MutableShortCharMap hashMap = new ShortCharHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((char) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ShortCharHashMap hashMap0 = new ShortCharHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, (char) 1, (short) 2, (char) 2), hashMap0);
        ShortCharHashMap hashMap1 = new ShortCharHashMap().withKeysValues((short) 1, (char) 1, (short) 2, (char) 2, (short) 3, (char) 3);
        ShortCharHashMap hashMap2 = new ShortCharHashMap().withKeysValues((short) 1, (char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 2), hashMap0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 2, (short) 3, (char) 3), hashMap1);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 1, (char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortCharHashMap hashMap = new ShortCharHashMap().withKeysValues((short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4, (char) 5);
        Character sum = hashMap.injectInto(Character.valueOf((char) 1), (Character result, char value) -> Character.valueOf((char) (result + value)));
        Assert.assertEquals(Character.valueOf((char) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);

        MutableShortCharMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((char) 0, hashMap.get((short) i));
            Assert.assertEquals(1L, hashMap.updateValue((short) i, (char) 0, incrementFunction));
            Assert.assertEquals((char) 1, hashMap.get((short) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortCharMaps.class);
    }
}
