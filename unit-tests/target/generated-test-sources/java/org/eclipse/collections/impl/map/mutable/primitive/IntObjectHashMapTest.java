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

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.IntObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link IntObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class IntObjectHashMapTest extends AbstractMutableIntObjectMapTestCase
{
    @Override
    protected IntObjectHashMap<String> classUnderTest()
    {
        return IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo");
    }

    @Override
    protected <T> IntObjectHashMap<T> newWithKeysValues(int key1, T value1)
    {
        return IntObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> IntObjectHashMap<T> newWithKeysValues(int key1, T value1, int key2, T value2)
    {
        return IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> IntObjectHashMap<T> newWithKeysValues(int key1, T value1, int key2, T value2, int key3, T value3)
    {
        return IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> IntObjectHashMap<T> getEmptyMap()
    {
        return new IntObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = IntObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntObjectHashMap<Object> hashMap = new IntObjectHashMap<>();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = IntObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntObjectHashMap<Object> hashMap = new IntObjectHashMap<>(3);
        Assert.assertEquals(8L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);

        IntObjectHashMap<?> hashMap2 = new IntObjectHashMap<>(15);
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new IntObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = IntObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntObjectHashMap<Object> hashMap = IntObjectHashMap.newMap();
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new IntObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithIntObjectMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = IntObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = IntObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        IntObjectHashMap<Object> map = IntObjectHashMap.newMap();

        IntObjectHashMap<Object> hashMap = IntObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new IntObjectHashMap<>(), hashMap);

        map.put(1, "one");
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one"), IntObjectHashMap.newMap(map));

        map.put(2, "two");
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two"), IntObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException
    {
        IntObjectHashMap<String> hashMap = IntObjectHashMap.newMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }

        Field keys = IntObjectHashMap.class.getDeclaredField("keys");
        Field values = IntObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }

        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Assert.assertNull(hashMap.put(10, "10"));
        Assert.assertEquals(32L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception
    {
        IntObjectHashMap<Integer> hashMap = IntObjectHashMap.newMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, i);
        }

        Field keys = IntObjectHashMap.class.getDeclaredField("keys");
        Field values = IntObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);

        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6);
        Assert.assertEquals(16L, ((int[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove(5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function<Float, Float> function = Functions.getPassThru();

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValue(2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2, function0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValueWith(2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith(5, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith(2, function0, function, 0.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = new IntObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, (float) i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        hashMap.getIfAbsentPut(2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        Function0<Float> function = Functions0.value(5.0f);

        hashMap.getIfAbsentPut(2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        Function<Float, Float> function = Functions.getPassThru();

        hashMap.getIfAbsentPutWith(2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = IntObjectHashMap.newWithKeysValues(2, 2.0f, 3, 3.0f, 4, 4.0f);

        IntToObjectFunction<Float> function = (int intParameter) -> (float) intParameter;

        hashMap.getIfAbsentPutWithKey(2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey(2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = IntObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = IntObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        IntObjectHashMap<Float> hashMap = new IntObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put(i, (float) i);
        }

        hashMap.remove(2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();

        IntObjectHashMap<String> hashMap0 = new IntObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues(1, "one", 2, "two"), hashMap0);
        IntObjectHashMap<String> hashMap1 = new IntObjectHashMap<String>().withKeysValues(1, "one", 2, "two", 3, "three");
        IntObjectHashMap<String> hashMap2 = new IntObjectHashMap<String>().withKeysValues(1, "one", 2, "two", 3, "three", 4, "four");
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two"), hashMap0);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two", 3, "three"), hashMap1);
        Assert.assertEquals(IntObjectHashMap.newWithKeysValues(1, "one", 2, "two", 3, "three").withKeyValue(4, "four"), hashMap2);
    }

    @Test
    public void put_every_slot()
    {
        MutableIntObjectMap<String> hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableIntObjectMap<String> hashMap = this.getEmptyMap();
        for (int i = 2; i < 100; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        Function<String, String> toUpperCase = String::toUpperCase;

        MutableIntObjectMap<String> hashMap = this.getEmptyMap();
        for (int each = 2; each < 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        MutableIntObjectMap<Integer> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Integer.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Integer::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;

        MutableIntObjectMap<Integer> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;

        MutableIntObjectMap<Integer> hashMap = this.getEmptyMap();

        for (int each = 2; each < 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(IntObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding()
    {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableIntObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.intValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));

        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(
                1.082323233761663,
                result,
                1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding()
    {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableIntObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.intValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));

        Assert.assertEquals(
                1.082323233711138,
                result,
                1.0e-15);
    }
}
