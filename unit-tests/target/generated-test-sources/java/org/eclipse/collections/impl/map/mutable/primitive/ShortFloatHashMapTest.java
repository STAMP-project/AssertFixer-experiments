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
import org.eclipse.collections.api.block.function.primitive.ShortToFloatFunction;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortFloatMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortFloatHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortFloatHashMapTest extends AbstractMutableShortFloatMapTestCase
{
    @Override
    protected ShortFloatHashMap classUnderTest()
    {
        return ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f);
    }

    @Override
    protected ShortFloatHashMap newWithKeysValues(short key1, float value1)
    {
        return new ShortFloatHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortFloatHashMap newWithKeysValues(short key1, float value1, short key2, float value2)
    {
        return new ShortFloatHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortFloatHashMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3)
    {
        return new ShortFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortFloatHashMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4)
    {
        return new ShortFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortFloatHashMap getEmptyMap()
    {
        return new ShortFloatHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ShortFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ShortFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortFloatHashMap hashMap = new ShortFloatHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(8L, ((float[]) values.get(hashMap)).length);

        ShortFloatHashMap hashMap2 = new ShortFloatHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(32L, ((float[]) values.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortFloatHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ShortFloatHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortFloatHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Assert.assertEquals(new ShortFloatHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (float) i);
        }

        Field keys = ShortFloatHashMap.class.getDeclaredField("keys");
        Field values = ShortFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);
        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, 10.0f);
        hashMap.put((short) 11, 11.0f);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (float) i);
        }

        Field keys = ShortFloatHashMap.class.getDeclaredField("keys");
        Field values = ShortFloatHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(16L, ((float[]) values.get(hashMap)).length);

        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f);

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
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);

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
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        FloatToFloatFunction function = (float floatParameter) -> floatParameter;

        hashMap.updateValue((short) 2, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 5, 0.0f, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 2, 0.0f, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((short) 2, 9.0f); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);

        hashMap.getIfAbsentPut((short) 2, 5.0f);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, 5.0f);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, 5.0f); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);

        FloatFunction0 function = () -> 5.0f;

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
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);

        FloatFunction<Float> function = Float::floatValue;

        hashMap.getIfAbsentPutWith((short) 2, function, Float.valueOf(5.0f));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 5, function, Float.valueOf(5.0f));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 2, function, Float.valueOf(5.0f)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = ShortFloatHashMap.newWithKeysValues((short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);

        ShortToFloatFunction function = (short shortParameter) -> (float) shortParameter;

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
        Field occupiedWithData = ShortFloatHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortFloatHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortFloatHashMap hashMap = new ShortFloatHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (float) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((short) 2, 3.0f); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableShortFloatMap copyMap = new ShortFloatHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (float) i);
        }

        Verify.assertSize(8, copyMap);
        MutableShortFloatMap hashMap = new ShortFloatHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((float) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ShortFloatHashMap hashMap0 = new ShortFloatHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, 1.0f, (short) 2, 2.0f), hashMap0);
        ShortFloatHashMap hashMap1 = new ShortFloatHashMap().withKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f);
        ShortFloatHashMap hashMap2 = new ShortFloatHashMap().withKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f), hashMap0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f), hashMap1);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 1, 1.0f, (short) 2, 2.0f, (short) 3, 3.0f, (short) 4, 4.0f), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortFloatHashMap hashMap = new ShortFloatHashMap().withKeysValues((short) 1, 2.0f, (short) 2, 3.0f, (short) 3, 4.0f, (short) 4, 5.0f);
        Float sum = hashMap.injectInto(Float.valueOf(1.0f), (Float result, float value) -> Float.valueOf((float) (result + value)));
        Assert.assertEquals(Float.valueOf(15.0f), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;

        MutableShortFloatMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals(0.0f, hashMap.get((short) i), 0.0);
            Assert.assertEquals(1.0, hashMap.updateValue((short) i, 0.0f, incrementFunction), 0.0);
            Assert.assertEquals(1.0f, hashMap.get((short) i), 0.0);
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortFloatMaps.class);
    }
}
