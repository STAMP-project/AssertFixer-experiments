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
import org.eclipse.collections.api.block.function.primitive.CharToShortFunction;
import org.eclipse.collections.impl.factory.primitive.CharShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharShortHashMapTest extends AbstractMutableCharShortMapTestCase
{
    @Override
    protected CharShortHashMap classUnderTest()
    {
        return CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32);
    }

    @Override
    protected CharShortHashMap newWithKeysValues(char key1, short value1)
    {
        return new CharShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharShortHashMap newWithKeysValues(char key1, short value1, char key2, short value2)
    {
        return new CharShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharShortHashMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3)
    {
        return new CharShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharShortHashMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3, char key4, short value4)
    {
        return new CharShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharShortHashMap getEmptyMap()
    {
        return new CharShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = CharShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharShortHashMap hashMap = new CharShortHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = CharShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharShortHashMap hashMap = new CharShortHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((short[]) values.get(hashMap)).length);

        CharShortHashMap hashMap2 = new CharShortHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((short[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = CharShortHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharShortHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharShortHashMap hashMap = new CharShortHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        CharShortHashMap hashMap = new CharShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (short) i);
        }

        Field keys = CharShortHashMap.class.getDeclaredField("keys");
        Field values = CharShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, (short) 10);
        hashMap.put((char) 11, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        CharShortHashMap hashMap = new CharShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (short) i);
        }

        Field keys = CharShortHashMap.class.getDeclaredField("keys");
        Field values = CharShortHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((short[]) values.get(hashMap)).length);

        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3);

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
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);

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
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ShortToShortFunction function = (short shortParameter) -> shortParameter;

        hashMap.updateValue((char) 2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 5, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 2, (short) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = new CharShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((char) 2, (short) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);

        hashMap.getIfAbsentPut((char) 2, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 5, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 2, (short) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);

        ShortFunction0 function = () -> (short) 5;

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
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);

        ShortFunction<Short> function = Short::shortValue;

        hashMap.getIfAbsentPutWith((char) 2, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 5, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 2, function, Short.valueOf((short) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = CharShortHashMap.newWithKeysValues((char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);

        CharToShortFunction function = (char charParameter) -> (short) charParameter;

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
        Field occupiedWithData = CharShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharShortHashMap hashMap = new CharShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((char) 2, (short) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableCharShortMap copyMap = new CharShortHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (short) i);
        }

        Verify.assertSize(8, copyMap);
        MutableCharShortMap hashMap = new CharShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        CharShortHashMap hashMap0 = new CharShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, (short) 1, (char) 2, (short) 2), hashMap0);
        CharShortHashMap hashMap1 = new CharShortHashMap().withKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3);
        CharShortHashMap hashMap2 = new CharShortHashMap().withKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 2), hashMap0);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3), hashMap1);
        Assert.assertEquals(CharShortHashMap.newWithKeysValues((char) 1, (short) 1, (char) 2, (short) 2, (char) 3, (short) 3, (char) 4, (short) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        CharShortHashMap hashMap = new CharShortHashMap().withKeysValues((char) 1, (short) 2, (char) 2, (short) 3, (char) 3, (short) 4, (char) 4, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);

        MutableCharShortMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((short) 0, hashMap.get((char) i));
            Assert.assertEquals(1L, hashMap.updateValue((char) i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get((char) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharShortMaps.class);
    }
}
