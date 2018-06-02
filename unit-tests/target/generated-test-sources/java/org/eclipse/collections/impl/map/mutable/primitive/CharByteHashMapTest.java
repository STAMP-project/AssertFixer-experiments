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

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.CharToByteFunction;
import org.eclipse.collections.impl.factory.primitive.CharByteMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharByteMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharByteHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharByteHashMapTest extends AbstractMutableCharByteMapTestCase
{
    @Override
    protected CharByteHashMap classUnderTest()
    {
        return CharByteHashMap.newWithKeysValues((char) 0, (byte) 0, (char) 31, (byte) 31, (char) 32, (byte) 32);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1)
    {
        return new CharByteHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2)
    {
        return new CharByteHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3)
    {
        return new CharByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3, char key4, byte value4)
    {
        return new CharByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharByteHashMap getEmptyMap()
    {
        return new CharByteHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharByteHashMap hashMap = new CharByteHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((byte[]) values.get(hashMap)).length);

        CharByteHashMap hashMap2 = new CharByteHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((byte[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharByteHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharByteHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharByteHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        CharByteHashMap hashMap = new CharByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (byte) i);
        }

        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        Field values = CharByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, (byte) 10);
        hashMap.put((char) 11, (byte) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        CharByteHashMap hashMap = new CharByteHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (byte) i);
        }

        Field keys = CharByteHashMap.class.getDeclaredField("keys");
        Field values = CharByteHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((byte[]) values.get(hashMap)).length);

        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3);

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
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);

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
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ByteToByteFunction function = (byte byteParameter) -> byteParameter;

        hashMap.updateValue((char) 2, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 5, (byte) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 2, (byte) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((char) 2, (byte) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);

        hashMap.getIfAbsentPut((char) 2, (byte) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 5, (byte) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 2, (byte) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);

        ByteFunction0 function = () -> (byte) 5;

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
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);

        ByteFunction<Byte> function = Byte::byteValue;

        hashMap.getIfAbsentPutWith((char) 2, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 5, function, Byte.valueOf((byte) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 2, function, Byte.valueOf((byte) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = CharByteHashMap.newWithKeysValues((char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);

        CharToByteFunction function = (char charParameter) -> (byte) charParameter;

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
        Field occupiedWithData = CharByteHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharByteHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharByteHashMap hashMap = new CharByteHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (byte) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((char) 2, (byte) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableCharByteMap copyMap = new CharByteHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (byte) i);
        }

        Verify.assertSize(8, copyMap);
        MutableCharByteMap hashMap = new CharByteHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((byte) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        CharByteHashMap hashMap0 = new CharByteHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2), hashMap0);
        CharByteHashMap hashMap1 = new CharByteHashMap().withKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3);
        CharByteHashMap hashMap2 = new CharByteHashMap().withKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2), hashMap0);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3), hashMap1);
        Assert.assertEquals(CharByteHashMap.newWithKeysValues((char) 1, (byte) 1, (char) 2, (byte) 2, (char) 3, (byte) 3, (char) 4, (byte) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        CharByteHashMap hashMap = new CharByteHashMap().withKeysValues((char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3, (byte) 4, (char) 4, (byte) 5);
        Byte sum = hashMap.injectInto(Byte.valueOf((byte) 1), (Byte result, byte value) -> Byte.valueOf((byte) (result + value)));
        Assert.assertEquals(Byte.valueOf((byte) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);

        MutableCharByteMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((byte) 0, hashMap.get((char) i));
            Assert.assertEquals(1L, hashMap.updateValue((char) i, (byte) 0, incrementFunction));
            Assert.assertEquals((byte) 1, hashMap.get((char) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharByteMaps.class);
    }
}
