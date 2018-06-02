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
import org.eclipse.collections.api.block.function.primitive.DoubleToLongFunction;
import org.eclipse.collections.impl.factory.primitive.DoubleLongMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableDoubleLongMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleLongHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class DoubleLongHashMapTest extends AbstractMutableDoubleLongMapTestCase
{
    @Override
    protected DoubleLongHashMap classUnderTest()
    {
        return DoubleLongHashMap.newWithKeysValues(0.0, 0L, 31.0, 31L, 32.0, 32L);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1)
    {
        return new DoubleLongHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1, double key2, long value2)
    {
        return new DoubleLongHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3)
    {
        return new DoubleLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleLongHashMap newWithKeysValues(double key1, long value1, double key2, long value2, double key3, long value3, double key4, long value4)
    {
        return new DoubleLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleLongHashMap getEmptyMap()
    {
        return new DoubleLongHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleLongHashMap hashMap = new DoubleLongHashMap(3);
        Assert.assertEquals(8L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((long[]) values.get(hashMap)).length);

        DoubleLongHashMap hashMap2 = new DoubleLongHashMap(15);
        Assert.assertEquals(32L, ((double[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((long[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new DoubleLongHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Assert.assertEquals(new DoubleLongHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (long) i);
        }

        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put(10.0, 10L);
        hashMap.put(11.0, 11L);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (long) i);
        }

        Field keys = DoubleLongHashMap.class.getDeclaredField("keys");
        Field values = DoubleLongHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((double[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((long[]) values.get(hashMap)).length);

        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L);

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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);

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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        LongToLongFunction function = (long longParameter) -> longParameter;

        hashMap.updateValue(2.0, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0, 0L, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0, 0L, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((double) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0, 9L); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);

        hashMap.getIfAbsentPut(2.0, 5L);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0, 5L);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0, 5L); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);

        LongFunction0 function = () -> 5L;

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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);

        LongFunction<Long> function = Long::longValue;

        hashMap.getIfAbsentPutWith(2.0, function, Long.valueOf(5L));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0, function, Long.valueOf(5L));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0, function, Long.valueOf(5L)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = DoubleLongHashMap.newWithKeysValues(2.0, 2L, 3.0, 3L, 4.0, 4L);

        DoubleToLongFunction function = (double doubleParameter) -> (long) doubleParameter;

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
        Field occupiedWithData = DoubleLongHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = DoubleLongHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        DoubleLongHashMap hashMap = new DoubleLongHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((double) i));
            hashMap.put((double) i, (long) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove(2.0);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0, 3L); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableDoubleLongMap copyMap = new DoubleLongHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((double) i));
            copyMap.put((double) i, (long) i);
        }

        Verify.assertSize(8, copyMap);
        MutableDoubleLongMap hashMap = new DoubleLongHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((double) i));
            Assert.assertTrue(hashMap.containsValue((long) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        DoubleLongHashMap hashMap0 = new DoubleLongHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0, 1L, 2.0, 2L), hashMap0);
        DoubleLongHashMap hashMap1 = new DoubleLongHashMap().withKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L);
        DoubleLongHashMap hashMap2 = new DoubleLongHashMap().withKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L, 4.0, 4L);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L), hashMap0);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L), hashMap1);
        Assert.assertEquals(DoubleLongHashMap.newWithKeysValues(1.0, 1L, 2.0, 2L, 3.0, 3L, 4.0, 4L), hashMap2);
    }

    @Test
    public void injectInto()
    {
        DoubleLongHashMap hashMap = new DoubleLongHashMap().withKeysValues(1.0, 2L, 2.0, 3L, 3.0, 4L, 4.0, 5L);
        Long sum = hashMap.injectInto(Long.valueOf(1L), (Long result, long value) -> Long.valueOf((long) (result + value)));
        Assert.assertEquals(Long.valueOf(15L), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;

        MutableDoubleLongMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0L, hashMap.get((double) i));
            Assert.assertEquals(1L, hashMap.updateValue((double) i, 0L, incrementFunction));
            Assert.assertEquals(1L, hashMap.get((double) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(DoubleLongMaps.class);
    }
}
