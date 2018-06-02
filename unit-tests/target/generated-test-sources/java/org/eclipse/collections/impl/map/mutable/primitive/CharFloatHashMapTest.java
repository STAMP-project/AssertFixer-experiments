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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.CharToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.CharFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class CharFloatHashMapTest extends AbstractMutableCharFloatMapTestCase
{
    @Override
    protected CharFloatHashMap classUnderTest()
    {
        return CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f);
    }

    @Override
    protected CharFloatHashMap newWithKeysValues(char key1, float value1)
    {
        return new CharFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharFloatHashMap newWithKeysValues(char key1, float value1, char key2, float value2)
    {
        return new CharFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharFloatHashMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3)
    {
        return new CharFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharFloatHashMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4)
    {
        return new CharFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharFloatHashMap getEmptyMap()
    {
        return new CharFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = CharFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        CharFloatHashMap hashMap = new CharFloatHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = CharFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharFloatHashMap hashMap = new CharFloatHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);

        CharFloatHashMap hashMap2 = new CharFloatHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = CharFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharFloatHashMap hashMap = new CharFloatHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new CharFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        CharFloatHashMap hashMap = new CharFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (float) i);
        }

        Field keys = CharFloatHashMap.class.getDeclaredField("keys");
        Field values = CharFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((char) 10, 10.0f);
        hashMap.put((char) 11, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        CharFloatHashMap hashMap = new CharFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (float) i);
        }

        Field keys = CharFloatHashMap.class.getDeclaredField("keys");
        Field values = CharFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);

        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f);

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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        FloatToFloatFunction function = (float floatParameter) -> floatParameter;

        hashMap.updateValue((char) 2, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 5, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((char) 2, 0.0f, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = new CharFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((char) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        FloatFunction0 function = () -> 5.0f;

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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        FloatFunction<Float> function = Float::floatValue;

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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = CharFloatHashMap.newWithKeysValues((char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);

        CharToFloatFunction function = (char charParameter) -> (float) charParameter;

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
        Field occupiedWithData = CharFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = CharFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        CharFloatHashMap hashMap = new CharFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((char) i));
            hashMap.put((char) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((char) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((char) 2, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableCharFloatMap copyMap = new CharFloatHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((char) i));
            copyMap.put((char) i, (float) i);
        }

        Verify.assertSize(8, copyMap);
        MutableCharFloatMap hashMap = new CharFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((char) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        CharFloatHashMap hashMap0 = new CharFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, 1.0f, (char) 2, 2.0f), hashMap0);
        CharFloatHashMap hashMap1 = new CharFloatHashMap().withKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f);
        CharFloatHashMap hashMap2 = new CharFloatHashMap().withKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f), hashMap0);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f), hashMap1);
        Assert.assertEquals(CharFloatHashMap.newWithKeysValues((char) 1, 1.0f, (char) 2, 2.0f, (char) 3, 3.0f, (char) 4, 4.0f), hashMap2);
    }

    @Test
    public void injectInto()
    {
        CharFloatHashMap hashMap = new CharFloatHashMap().withKeysValues((char) 1, 2.0f, (char) 2, 3.0f, (char) 3, 4.0f, (char) 4, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableCharFloatMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((char) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((char) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((char) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(CharFloatMaps.class);
    }
}
