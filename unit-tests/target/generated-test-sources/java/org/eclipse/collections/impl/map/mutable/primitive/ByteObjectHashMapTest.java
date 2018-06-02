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
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.ByteObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ByteObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class ByteObjectHashMapTest extends AbstractMutableByteObjectMapTestCase
{
    @Override
    protected ByteObjectHashMap<String> classUnderTest()
    {
        return ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo");
    }

    @Override
    protected <T> ByteObjectHashMap<T> newWithKeysValues(byte key1, T value1)
    {
        return ByteObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ByteObjectHashMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2)
    {
        return ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ByteObjectHashMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2, byte key3, T value3)
    {
        return ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ByteObjectHashMap<T> getEmptyMap()
    {
        return new ByteObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = ByteObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteObjectHashMap<Object> hashMap = new ByteObjectHashMap<>();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = ByteObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteObjectHashMap<Object> hashMap = new ByteObjectHashMap<>(3);
        Assert.assertEquals(8L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);

        ByteObjectHashMap<?> hashMap2 = new ByteObjectHashMap<>(15);
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ByteObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = ByteObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteObjectHashMap<Object> hashMap = ByteObjectHashMap.newMap();
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithByteObjectMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = ByteObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ByteObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ByteObjectHashMap<Object> map = ByteObjectHashMap.newMap();

        ByteObjectHashMap<Object> hashMap = ByteObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new ByteObjectHashMap<>(), hashMap);

        map.put((byte) 1, "one");
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one"), ByteObjectHashMap.newMap(map));

        map.put((byte) 2, "two");
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two"), ByteObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException
    {
        ByteObjectHashMap<String> hashMap = ByteObjectHashMap.newMap();
        for (byte i = (byte) 2; i < (byte) 10; i++)
        {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }

        Field keys = ByteObjectHashMap.class.getDeclaredField("keys");
        Field values = ByteObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (byte i = (byte) 2; i < (byte) 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }

        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Assert.assertNull(hashMap.put((byte) 10, "10"));
        Assert.assertEquals(32L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception
    {
        ByteObjectHashMap<Integer> hashMap = ByteObjectHashMap.newMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, i);
        }

        Field keys = ByteObjectHashMap.class.getDeclaredField("keys");
        Field values = ByteObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);

        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove((byte) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove((byte) 6);
        Assert.assertEquals(16L, ((byte[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(1, occupiedWithData.get(hashMap));

        hashMap.clear();
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnRemove() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 5);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(2, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValue() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function<Float, Float> function = Functions.getPassThru();

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValue((byte) 2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 5, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((byte) 2, function0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValueWith((byte) 2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith((byte) 5, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith((byte) 2, function0, function, 0.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = new ByteObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (byte i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (float) i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((byte) 2, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        hashMap.getIfAbsentPut((byte) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        Function0<Float> function = Functions0.value(5.0f);

        hashMap.getIfAbsentPut((byte) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((byte) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWith() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        Function<Float, Float> function = Functions.getPassThru();

        hashMap.getIfAbsentPutWith((byte) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((byte) 2, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = ByteObjectHashMap.newWithKeysValues((byte) 2, 2.0f, (byte) 3, 3.0f, (byte) 4, 4.0f);

        ByteToObjectFunction<Float> function = (byte byteParameter) -> (float) byteParameter;

        hashMap.getIfAbsentPutWithKey((byte) 2, function);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((byte) 5, function);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((byte) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWithKey((byte) 2, function); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithSentinelsOnPutRemovedSlot() throws Exception
    {
        Field occupiedWithData = ByteObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ByteObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ByteObjectHashMap<Float> hashMap = new ByteObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (byte i = 2; i < 10; i++)
        {
            hashMap.put((byte) i, (float) i);
        }

        hashMap.remove((byte) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((byte) 2, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();

        ByteObjectHashMap<String> hashMap0 = new ByteObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues((byte) 1, "one", (byte) 2, "two"), hashMap0);
        ByteObjectHashMap<String> hashMap1 = new ByteObjectHashMap<String>().withKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three");
        ByteObjectHashMap<String> hashMap2 = new ByteObjectHashMap<String>().withKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three", (byte) 4, "four");
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two"), hashMap0);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three"), hashMap1);
        Assert.assertEquals(ByteObjectHashMap.newWithKeysValues((byte) 1, "one", (byte) 2, "two", (byte) 3, "three").withKeyValue((byte) 4, "four"), hashMap2);
    }

    @Test
    public void put_every_slot()
    {
        MutableByteObjectMap<String> hashMap = this.getEmptyMap();
        for (byte i = (byte) 2; i < (byte) 100; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableByteObjectMap<String> hashMap = this.getEmptyMap();
        for (byte i = (byte) 2; i < (byte) 100; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        Function<String, String> toUpperCase = String::toUpperCase;

        MutableByteObjectMap<String> hashMap = this.getEmptyMap();
        for (byte each = (byte) 2; each < (byte) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        MutableByteObjectMap<Byte> hashMap = this.getEmptyMap();

        for (byte each = (byte) 2; each < (byte) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Byte.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Byte::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;

        MutableByteObjectMap<Integer> hashMap = this.getEmptyMap();

        for (byte each = (byte) 2; each < (byte) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;

        MutableByteObjectMap<Integer> hashMap = this.getEmptyMap();

        for (byte each = (byte) 2; each < (byte) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ByteObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding()
    {
        MutableList<Integer> randomIntegers
            = Interval.fromTo(Byte.MIN_VALUE, Byte.MAX_VALUE)
                .toList()
                .shuffleThis()
                .reject(i -> i == 0);
        final MutableByteObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.byteValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));

        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(
                2.1646461496124854,
                result,
                1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding()
    {
        MutableList<Integer> randomIntegers
            = Interval.fromTo(Byte.MIN_VALUE, Byte.MAX_VALUE)
                .toList()
                .shuffleThis()
                .reject(i -> i == 0);
        final MutableByteObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put(i.byteValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));

        Assert.assertEquals(
                2.1646461495114355,
                result,
                1.0e-15);
    }
}
