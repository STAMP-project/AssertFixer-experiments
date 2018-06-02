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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.impl.factory.primitive.ShortShortMaps;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.api.map.primitive.MutableShortShortMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortShortHashMap}.
 * This file was automatically generated from template file primitivePrimitiveHashMapTest.stg.
 */
public class ShortShortHashMapTest extends AbstractMutableShortShortMapTestCase
{
    @Override
    protected ShortShortHashMap classUnderTest()
    {
        return ShortShortHashMap.newWithKeysValues((short) 0, (short) 0, (short) 31, (short) 31, (short) 32, (short) 32);
    }

    @Override
    protected ShortShortHashMap newWithKeysValues(short key1, short value1)
    {
        return new ShortShortHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortShortHashMap newWithKeysValues(short key1, short value1, short key2, short value2)
    {
        return new ShortShortHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortShortHashMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3)
    {
        return new ShortShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortShortHashMap newWithKeysValues(short key1, short value1, short key2, short value2, short key3, short value3, short key4, short value4)
    {
        return new ShortShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortShortHashMap getEmptyMap()
    {
        return new ShortShortHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keysValues = ShortShortHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ShortShortHashMap hashMap = new ShortShortHashMap();
        Assert.assertEquals(32L, ((short[]) keysValues.get(hashMap)).length);
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keysValues = ShortShortHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);
        ShortShortHashMap hashMap = new ShortShortHashMap(3);
        Assert.assertEquals(16L, ((short[]) keysValues.get(hashMap)).length);

        ShortShortHashMap hashMap2 = new ShortShortHashMap(15);
        Assert.assertEquals(64L, ((short[]) keysValues.get(hashMap2)).length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortShortHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keysValues = ShortShortHashMap.class.getDeclaredField("keysValues");
        keysValues.setAccessible(true);

        ShortShortHashMap hashMap = new ShortShortHashMap();
        Assert.assertEquals(32L, ((short[]) keysValues.get(hashMap)).length);
        Assert.assertEquals(new ShortShortHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortShortHashMap hashMap = new ShortShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (short) i);
        }

        Verify.assertSize(8, hashMap);
        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        hashMap.put((short) 10, (short) 10);
        hashMap.put((short) 11, (short) 11);
        Assert.assertEquals(9, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void removeWithoutRehash() throws Exception
    {
        ShortShortHashMap hashMap = new ShortShortHashMap();
        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (short) i);
        }

        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        occupiedWithData.setAccessible(true);
        Assert.assertEquals(8, occupiedWithData.get(hashMap));

        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
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
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3);

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
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);

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
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        ShortToShortFunction function = (short shortParameter) -> shortParameter;

        hashMap.updateValue((short) 2, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 5, (short) 0, function);
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));

        hashMap.updateValue((short) 2, (short) 0, function); // putting in a slot marked REMOVED
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnPut() throws Exception
    {
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = new ShortShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            hashMap.put((short) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(7, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.put((short) 2, (short) 9); // putting in a slot marked REMOVED
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPut() throws Exception
    {
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);

        hashMap.getIfAbsentPut((short) 2, (short) 5);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 5, (short) 5);
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPut((short) 2, (short) 5); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutFunction() throws Exception
    {
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);

        ShortFunction0 function = () -> (short) 5;

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
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);

        ShortFunction<Short> function = Short::shortValue;

        hashMap.getIfAbsentPutWith((short) 2, function, Short.valueOf((short) 5));
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 5, function, Short.valueOf((short) 5));
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        hashMap.remove((short) 2);
        Assert.assertEquals(3, occupiedWithData.get(hashMap));
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));

        hashMap.getIfAbsentPutWith((short) 2, function, Short.valueOf((short) 5)); //putting in a slot marked REMOVED
        Assert.assertEquals(4, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
    }

    @Test
    public void occupiedWithDataAndSentinelsOnGetIfAbsentPutWithKey() throws Exception
    {
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = ShortShortHashMap.newWithKeysValues((short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);

        ShortToShortFunction function = (short shortParameter) -> (short) shortParameter;

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
        Field occupiedWithData = ShortShortHashMap.class.getDeclaredField("occupiedWithData");
        Field occupiedWithSentinels = ShortShortHashMap.class.getDeclaredField("occupiedWithSentinels");
        occupiedWithData.setAccessible(true);
        occupiedWithSentinels.setAccessible(true);
        ShortShortHashMap hashMap = new ShortShortHashMap();
        Assert.assertEquals(0, occupiedWithData.get(hashMap));
        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey((short) i));
            hashMap.put((short) i, (short) i);
            Assert.assertEquals(i - 1, occupiedWithData.get(hashMap));
        }

        hashMap.remove((short) 2);
        Assert.assertEquals(1, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(7, occupiedWithData.get(hashMap));

        hashMap.put((short) 2, (short) 3); //putting in a slot marked as REMOVED

        Assert.assertEquals(0, occupiedWithSentinels.get(hashMap));
        Assert.assertEquals(8, occupiedWithData.get(hashMap));
    }

    @Test
    public void testPutAll()
    {
        MutableShortShortMap copyMap = new ShortShortHashMap();

        for (int i = 2; i < 10; i++)
        {
            Assert.assertFalse(copyMap.containsKey((short) i));
            copyMap.put((short) i, (short) i);
        }

        Verify.assertSize(8, copyMap);
        MutableShortShortMap hashMap = new ShortShortHashMap();
        Verify.assertSize(0, hashMap);
        hashMap.putAll(copyMap);
        Verify.assertSize(8, hashMap);

        for (int i = 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey((short) i));
            Assert.assertTrue(hashMap.containsValue((short) i));
        }

        Assert.assertEquals(copyMap, hashMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        ShortShortHashMap hashMap0 = new ShortShortHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, (short) 1, (short) 2, (short) 2), hashMap0);
        ShortShortHashMap hashMap1 = new ShortShortHashMap().withKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3);
        ShortShortHashMap hashMap2 = new ShortShortHashMap().withKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2), hashMap0);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3), hashMap1);
        Assert.assertEquals(ShortShortHashMap.newWithKeysValues((short) 1, (short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortShortHashMap hashMap = new ShortShortHashMap().withKeysValues((short) 1, (short) 2, (short) 2, (short) 3, (short) 3, (short) 4, (short) 4, (short) 5);
        Short sum = hashMap.injectInto(Short.valueOf((short) 1), (Short result, short value) -> Short.valueOf((short) (result + value)));
        Assert.assertEquals(Short.valueOf((short) 15), sum);
    }

    @Test
    public void updateValue_every_slot()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);

        MutableShortShortMap hashMap = this.getEmptyMap();

        for (int i = 2; i < 100; i++)
        {
            Assert.assertEquals((short) 0, hashMap.get((short) i));
            Assert.assertEquals(1L, hashMap.updateValue((short) i, (short) 0, incrementFunction));
            Assert.assertEquals((short) 1, hashMap.get((short) i));
        }
    }

    @Test
    public void classIsNonInstantiable()
    {
        Verify.assertClassNonInstantiable(ShortShortMaps.class);
    }
}
