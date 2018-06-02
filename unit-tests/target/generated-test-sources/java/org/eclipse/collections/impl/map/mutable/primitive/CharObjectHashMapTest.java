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
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Functions2;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.factory.primitive.CharObjectMaps;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharObjectHashMap}.
 * This file was automatically generated from template file primitiveObjectHashMapTest.stg.
 */
public class CharObjectHashMapTest extends AbstractMutableCharObjectMapTestCase
{
    @Override
    protected CharObjectHashMap<String> classUnderTest()
    {
        return CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo");
    }

    @Override
    protected <T> CharObjectHashMap<T> newWithKeysValues(char key1, T value1)
    {
        return CharObjectHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> CharObjectHashMap<T> newWithKeysValues(char key1, T value1, char key2, T value2)
    {
        return CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> CharObjectHashMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3)
    {
        return CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> CharObjectHashMap<T> getEmptyMap()
    {
        return new CharObjectHashMap<>();
    }

    @Test
    public void defaultInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharObjectHashMap<Object> hashMap = new CharObjectHashMap<>();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharObjectHashMap<Object> hashMap = new CharObjectHashMap<>(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((Object[]) values.get(hashMap)).length);

        CharObjectHashMap<?> hashMap2 = new CharObjectHashMap<>(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharObjectHashMap<>(-1);
    }

    @Test
    public void newMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharObjectHashMap<Object> hashMap = CharObjectHashMap.newMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);
    }

    @Test
    public void newMapWithCharObjectMap() throws NoSuchFieldException, IllegalAccessException
    {
        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharObjectHashMap<Object> map = CharObjectHashMap.newMap();

        CharObjectHashMap<Object> hashMap = CharObjectHashMap.newMap(map);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharObjectHashMap<>(), hashMap);

        map.put((char) 1, "one");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one"), CharObjectHashMap.newMap(map));

        map.put((char) 2, "two");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two"), CharObjectHashMap.newMap(map));
    }

    @Test
    public void putWithRehash() throws NoSuchFieldException, IllegalAccessException
    {
        CharObjectHashMap<String> hashMap = CharObjectHashMap.newMap();
        for (char i = (char) 2; i < (char) 10; i++)
        {
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
        }

        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(8, hashMap.size());
        for (char i = (char) 2; i < (char) 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(hashMap.containsValue(String.valueOf(i)));
        }

        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Assert.assertNull(hashMap.put((char) 10, "10"));
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(32L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
    }

    @Test
    public void removeWithRehash() throws Exception
    {
        CharObjectHashMap<Integer> hashMap = CharObjectHashMap.newMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, i);
        }

        Field keys = CharObjectHashMap.class.getDeclaredField("keys");
        Field values = CharObjectHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);

        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 0; i < 4; i++)
        {
            hashMap.remove((char) (i + 2));
            Assert.assertEquals(7 - i, occupiedWithData.get(hashMap));
            Assert.assertEquals(i + 1, occupiedWithSentinels.get(hashMap));
        }

        hashMap.remove((char) 6);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((Object[]) values.get(hashMap)).length);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnClear() throws Exception
    {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f);

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
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

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
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function<Float, Float> function = Functions.getPassThru();

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValue((char) 2, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 5, function0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 2, function0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnUpdateValueWith() throws Exception
    {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        Function2<Float, Float, Float> function = Functions2.fromFunction(Functions.<Float>getPassThru());

        Function0<Float> function0 = Functions0.value(0.0f);

        hashMap.updateValueWith((char) 2, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith((char) 5, function0, function, 0.0f);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValueWith((char) 2, function0, function, 0.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = new CharObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (char i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (float) i);
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((char) 2, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        hashMap.getIfAbsentPut((char) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((char) 2, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        Function0<Float> function = Functions0.value(5.0f);

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
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        Function<Float, Float> function = Functions.getPassThru();

        hashMap.getIfAbsentPutWith((char) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((char) 2, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = CharObjectHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        CharToObjectFunction<Float> function = (char charParameter) -> (float) charParameter;

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
        Field occupiedWithData = CharObjectHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharObjectHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharObjectHashMap<Float> hashMap = new CharObjectHashMap<>();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (char i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (float) i);
        }

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((char) 2, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();

        CharObjectHashMap<String> hashMap0 = new CharObjectHashMap<>();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, "one", (char) 2, "two"), hashMap0);
        CharObjectHashMap<String> hashMap1 = new CharObjectHashMap<String>().withKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three");
        CharObjectHashMap<String> hashMap2 = new CharObjectHashMap<String>().withKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three", (char) 4, "four");
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two"), hashMap0);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three"), hashMap1);
        Assert.assertEquals(CharObjectHashMap.newWithKeysValues((char) 1, "one", (char) 2, "two", (char) 3, "three").withKeyValue((char) 4, "four"), hashMap2);
    }

    @Test
    public void put_every_slot()
    {
        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        for (char i = (char) 2; i < (char) 100; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertNull(hashMap.put(i, String.valueOf(i)));
            Assert.assertEquals(String.valueOf(i), hashMap.remove(i));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        for (char i = (char) 2; i < (char) 100; i++)
        {
            Assert.assertNull(hashMap.get(i));
            Assert.assertEquals("value", hashMap.getIfAbsentPut(i, Functions0.value("value")));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        Function<String, String> toUpperCase = String::toUpperCase;

        MutableCharObjectMap<String> hashMap = this.getEmptyMap();
        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals("VALUE", hashMap.getIfAbsentPutWith(each, toUpperCase, "value"));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        MutableCharObjectMap<Character> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(Character.valueOf(each), hashMap.getIfAbsentPutWithKey(each, Character::valueOf));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        Function<Integer, Integer> incrementFunction = integer -> integer + 1;

        MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValue(each, Functions0.value(0), incrementFunction).intValue());
        }
    }

    @Test
    public void updateValueWith_every_slot()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;

        MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertNull(hashMap.get(each));
            Assert.assertEquals(1L, hashMap.updateValueWith(each, Functions0.value(0), incrementFunction, 1).longValue());
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharObjectMaps.class);
    }

    @Test
    public void sumOfFloatConsistentRounding()
    {
        MutableList<Integer> randomIntegers
            = Interval.fromTo(Character.MIN_VALUE, Character.MAX_VALUE)
                .toList()
                .shuffleThis()
                .reject(i -> i == 0);
        final MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put((char) i.intValue(), i));
        double result = hashMap.sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue()));

        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(
                1.0823232337616622,
                result,
                1.0e-15);
    }

    @Test
    public void sumOfDoubleConsistentRounding()
    {
        MutableList<Integer> randomIntegers
            = Interval.fromTo(Character.MIN_VALUE, Character.MAX_VALUE)
                .toList()
                .shuffleThis()
                .reject(i -> i == 0);
        final MutableCharObjectMap<Integer> hashMap = this.getEmptyMap();
        randomIntegers.each(i -> hashMap.put((char) i.intValue(), i));
        double result = hashMap.sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue()));

        Assert.assertEquals(
                1.082323233711138,
                result,
                1.0e-15);
    }
}
