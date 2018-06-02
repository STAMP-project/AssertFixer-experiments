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
import org.eclipse.collections.api.block.function.primitive.FloatToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableFloatObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.FloatObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class FloatObjectHashMapTest extends AbstractMutableFloatObjectMapTestCase
{
    @Override
    protected FloatObjectHashMap<String> classUnderTest()
    {
        return FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo");
    }

    @Override
    protected <T> FloatObjectHashMap<T> newWithKeysValues(float key1, T value1)
    {
        return FloatObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> FloatObjectHashMap<T> newWithKeysValues(float key1, T value1, float key2, T value2)
    {
        return FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> FloatObjectHashMap<T> newWithKeysValues(float key1, T value1, float key2, T value2, float key3, T value3)
    {
        return FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> FloatObjectHashMap<T> getEmptyMap()
    {
        return new FloatObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = FloatObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatObjectHashMap<Object> hashMap = new FloatObjectHashMap<>();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = FloatObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatObjectHashMap<Object> hashMap = new FloatObjectHashMap<>(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);

        FloatObjectHashMap<?> hashMap2 = new FloatObjectHashMap<>(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new FloatObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = FloatObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatObjectHashMap<Object> hashMap = FloatObjectHashMap.newMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithFloatObjectMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = FloatObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatObjectHashMap<Object> map = FloatObjectHashMap.newMap();

        FloatObjectHashMap<Object> hashMap = FloatObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new FloatObjectHashMap<>(), hashMap);

        map.put(1.0f, "one");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one"), FloatObjectHashMap.newMap(map));

        map.put(2.0f, "two");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two"), FloatObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException
    {
        FloatObjectHashMap<String> hashMap = FloatObjectHashMap.newMap();
        for (float i = 2.0f; i < 10.0f; i++)
        {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }

        Field keys = FloatObjectHashMap.class.getDeclaredField("keys");
        Field values = FloatObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (float i = 2.0f; i < 10.0f; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }

        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Assert.assertNull(hashMap.put(10.0f, "10"));
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception
    {
        FloatObjectHashMap<Integer> hashMap = FloatObjectHashMap.newMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((float) i, i);
        }

        Field keys = FloatObjectHashMap.class.getDeclaredField("keys");
        Field values = FloatObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);

        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove(i + 2);
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove(6.0f);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f);

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
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

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
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function<Float, Float> function = Functions.getPassThru();

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValue(2.0f, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(5.0f, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue(2.0f, function0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception
    {
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValueWith(2.0f, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith(5.0f, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith(2.0f, function0, function, 0.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = new FloatObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (float i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (float) i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put(2.0f, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        hashMap.getIfAbsentPut(2.0f, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(5.0f, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut(2.0f, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        Function0<Float> function = Functions0.value(5.0f);

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
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        Function<Float, Float> function = Functions.getPassThru();

        hashMap.getIfAbsentPutWith(2.0f, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(5.0f, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove(2.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith(2.0f, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = FloatObjectHashMap.newWithKeysValues(2.0f, 2.0f, 3.0f, 3.0f, 4.0f, 4.0f);

        FloatToObjectFunction<Float> function = (float floatParameter) -> (float) floatParameter;

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
        Field occupiedWithData = FloatObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = FloatObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        FloatObjectHashMap<Float> hashMap = new FloatObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (float i = 2; i < 10; i++)
        {
            hashMap.put((float) i, (float) i);
        }

        hashMap.remove(2.0f);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put(2.0f, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();

        FloatObjectHashMap<String> hashMap0 = new FloatObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, "one", 2.0f, "two"), hashMap0);
        FloatObjectHashMap<String> hashMap1 = new FloatObjectHashMap<String>().withKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three");
        FloatObjectHashMap<String> hashMap2 = new FloatObjectHashMap<String>().withKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three", 4.0f, "four");
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two"), hashMap0);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three"), hashMap1);
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, "one", 2.0f, "two", 3.0f, "three").withKeyValue(4.0f, "four"), hashMap2);
    }

    @Test
    public void put_every_slot()
    {
        MutableFloatObjectMap<String> hashMap = this.getEmptyMap();
        for (float i = 2.0f; i < 100.0f; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableFloatObjectMap<String> hashMap = this.getEmptyMap();
        for (float i = 2.0f; i < 100.0f; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        Function<String, String> toUpperCase = String::toUpperCase;

        MutableFloatObjectMap<String> hashMap = this.getEmptyMap();
        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        MutableFloatObjectMap<Float> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Float.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Float::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;

        MutableFloatObjectMap<Integer> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;

        MutableFloatObjectMap<Integer> hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(FloatObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding()
    {
        MutableList<Integer> randomIntegers = Interval.oneTo(100_000).toList().shuffleThis();
        final MutableFloatObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.floatValue(), i));
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
        final MutableFloatObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.floatValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));

        Assert.assertEquals(
                1.082323233711138,
                result,
                1.0e-15);
    }
}
