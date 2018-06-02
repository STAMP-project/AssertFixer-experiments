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
import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.impl.factory.primitive.ShortLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortLongHashMapTest extends AbstractMutableShortLongMapTestCase
{
    @Override
    protected ShortLongHashMap classUnderTest()
    {
        return ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1)
    {
        return new ShortLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2)
    {
        return new ShortLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3)
    {
        return new ShortLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortLongHashMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4)
    {
        return new ShortLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortLongHashMap getEmptyMap()
    {
        return new ShortLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortLongHashMap hashMap = new ShortLongHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((long[]) values.get(hashMap)).length);

        ShortLongHashMap hashMap2 = new ShortLongHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((long[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (long) i);
        }

        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, 10L);
        hashMap.put((short) 11, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ShortLongHashMap hashMap = new ShortLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (long) i);
        }

        Field keys = ShortLongHashMap.class.getDeclaredField("keys");
        Field values = ShortLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);

        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L);

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
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);

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
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        LongToLongFunction function = (long longParameter) -> longParameter;

        hashMap.updateValue((short) 2, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 5, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 2, 0L, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((short) 2, 9L); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);

        hashMap.getIfAbsentPut((short) 2, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, 5L); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);

        LongFunction0 function = () -> 5L;

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
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);

        LongFunction<Long> function = Long::longValue;

        hashMap.getIfAbsentPutWith((short) 2, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 5, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 2, function, Long.valueOf(5L)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = ShortLongHashMap.newWithKeysValues((short) 2, 2L, (short) 3, 3L, (short) 4, 4L);

        ShortToLongFunction function = (short shortParameter) -> (long) shortParameter;

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
        Field occupiedWithData = ShortLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortLongHashMap hashMap = new ShortLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((short) 2, 3L); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableShortLongMap copyMap = new ShortLongHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (long) i);
        }

        Verify.assertSize(8, copyMap);
        MutableShortLongMap hashMap = new ShortLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ShortLongHashMap hashMap0 = new ShortLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, 1L, (short) 2, 2L), hashMap0);
        ShortLongHashMap hashMap1 = new ShortLongHashMap().withKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L);
        ShortLongHashMap hashMap2 = new ShortLongHashMap().withKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L), hashMap0);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L), hashMap1);
        Assert.assertEquals(ShortLongHashMap.newWithKeysValues((short) 1, 1L, (short) 2, 2L, (short) 3, 3L, (short) 4, 4L), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortLongHashMap hashMap = new ShortLongHashMap().withKeysValues((short) 1, 2L, (short) 2, 3L, (short) 3, 4L, (short) 4, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableShortLongMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((short) i));
            Assert.assertEquals(1L, hashMap.updateValue((short) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((short) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortLongMaps.class);
    }
}
