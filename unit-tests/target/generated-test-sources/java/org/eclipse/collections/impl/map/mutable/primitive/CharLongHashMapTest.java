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

import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.impl.factory.primitive.CharLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharLongHashMapTest extends AbstractMutableCharLongMapTestCase
{
    @Override
    protected CharLongHashMap classUnderTest()
    {
        return CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1)
    {
        return new CharLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1, char key2, long value2)
    {
        return new CharLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3)
    {
        return new CharLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharLongHashMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4)
    {
        return new CharLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharLongHashMap getEmptyMap()
    {
        return new CharLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharLongHashMap hashMap = new CharLongHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((long[]) values.get(hashMap)).length);

        CharLongHashMap hashMap2 = new CharLongHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((long[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        CharLongHashMap hashMap = new CharLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (long) i);
        }

        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        Field values = CharLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, 10L);
        hashMap.put((char) 11, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        CharLongHashMap hashMap = new CharLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (long) i);
        }

        Field keys = CharLongHashMap.class.getDeclaredField("keys");
        Field values = CharLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);

        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L);

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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);

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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        LongToLongFunction function = (long longParameter) -> longParameter;

        hashMap.updateValue((char) 2, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 5, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 2, 0L, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((char) 2, 9L); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);

        hashMap.getIfAbsentPut((char) 2, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 5, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 2, 5L); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);

        LongFunction0 function = () -> 5L;

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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);

        LongFunction<Long> function = Long::longValue;

        hashMap.getIfAbsentPutWith((char) 2, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 5, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 2, function, Long.valueOf(5L)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = CharLongHashMap.newWithKeysValues((char) 2, 2L, (char) 3, 3L, (char) 4, 4L);

        CharToLongFunction function = (char charParameter) -> (long) charParameter;

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
        Field occupiedWithData = CharLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharLongHashMap hashMap = new CharLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((char) 2, 3L); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableCharLongMap copyMap = new CharLongHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (long) i);
        }

        Verify.assertSize(8, copyMap);
        MutableCharLongMap hashMap = new CharLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        CharLongHashMap hashMap0 = new CharLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, 1L, (char) 2, 2L), hashMap0);
        CharLongHashMap hashMap1 = new CharLongHashMap().withKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L);
        CharLongHashMap hashMap2 = new CharLongHashMap().withKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L), hashMap0);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L), hashMap1);
        Assert.assertEquals(CharLongHashMap.newWithKeysValues((char) 1, 1L, (char) 2, 2L, (char) 3, 3L, (char) 4, 4L), hashMap2);
    }

    @Test
    public void injectInto()
    {
        CharLongHashMap hashMap = new CharLongHashMap().withKeysValues((char) 1, 2L, (char) 2, 3L, (char) 3, 4L, (char) 4, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableCharLongMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((char) i));
            Assert.assertEquals(1L, hashMap.updateValue((char) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((char) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharLongMaps.class);
    }
}
