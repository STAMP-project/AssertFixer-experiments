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
import org.eclipse.collections.impl.factory.primitive.LongLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableLongLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class LongLongHashMapTest extends AbstractMutableLongLongMapTestCase
{
    @Override
    protected LongLongHashMap classUnderTest()
    {
        return LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L);
    }

    @Override
    protected LongLongHashMap newWithKeysValues(long key1, long value1)
    {
        return new LongLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected LongLongHashMap newWithKeysValues(long key1, long value1, long key2, long value2)
    {
        return new LongLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected LongLongHashMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3)
    {
        return new LongLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongLongHashMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4)
    {
        return new LongLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongLongHashMap getEmptyMap()
    {
        return new LongLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keysValues = LongLongHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        LongLongHashMap hashMap = new LongLongHashMap();
        Assert.assertEquals(32L, ((long[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keysValues = LongLongHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        LongLongHashMap hashMap = new LongLongHashMap(3);
        Assert.assertEquals(16L, ((long[]) keysValues.get(hashMap)).length);

        LongLongHashMap hashMap2 = new LongLongHashMap(15);
        Assert.assertEquals(64L, ((long[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new LongLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keysValues = LongLongHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);

        LongLongHashMap hashMap = new LongLongHashMap();
        Assert.assertEquals(32L, ((long[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new LongLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        LongLongHashMap hashMap = new LongLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (long) i);
        }

        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10L, 10L);
        hashMap.put(11L, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        LongLongHashMap hashMap = new LongLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (long) i);
        }

        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L);

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
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L, 4L, 4L);

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
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L, 4L, 4L);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        LongToLongFunction function = (long longParameter) -> longParameter;

        hashMap.updateValue(2L, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5L, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2L, 0L, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = new LongLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((long) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2L, 9L); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L, 4L, 4L);

        hashMap.getIfAbsentPut(2L, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5L, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2L, 5L); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L, 4L, 4L);

        LongFunction0 function = () -> 5L;

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
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L, 4L, 4L);

        LongFunction<Long> function = Long::longValue;

        hashMap.getIfAbsentPutWith(2L, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5L, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2L, function, Long.valueOf(5L)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = LongLongHashMap.newWithKeysValues(2L, 2L, 3L, 3L, 4L, 4L);

        LongToLongFunction function = (long longParameter) -> (long) longParameter;

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
        Field occupiedWithData = LongLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = LongLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        LongLongHashMap hashMap = new LongLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((long) i));
            hashMap.put((long) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2L);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2L, 3L); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableLongLongMap copyMap = new LongLongHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((long) i));
            copyMap.put((long) i, (long) i);
        }

        Verify.assertSize(8, copyMap);
        MutableLongLongMap hashMap = new LongLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((long) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        LongLongHashMap hashMap0 = new LongLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1L, 1L, 2L, 2L), hashMap0);
        LongLongHashMap hashMap1 = new LongLongHashMap().withKeysValues(1L, 1L, 2L, 2L, 3L, 3L);
        LongLongHashMap hashMap2 = new LongLongHashMap().withKeysValues(1L, 1L, 2L, 2L, 3L, 3L, 4L, 4L);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L, 2L, 2L), hashMap0);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L, 2L, 2L, 3L, 3L), hashMap1);
        Assert.assertEquals(LongLongHashMap.newWithKeysValues(1L, 1L, 2L, 2L, 3L, 3L, 4L, 4L), hashMap2);
    }

    @Test
    public void injectInto()
    {
        LongLongHashMap hashMap = new LongLongHashMap().withKeysValues(1L, 2L, 2L, 3L, 3L, 4L, 4L, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableLongLongMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((long) i));
            Assert.assertEquals(1L, hashMap.updateValue((long) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((long) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(LongLongMaps.class);
    }
}
