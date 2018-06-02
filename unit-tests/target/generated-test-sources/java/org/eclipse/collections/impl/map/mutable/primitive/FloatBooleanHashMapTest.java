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
import java.util.BitSet;

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.FloatToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableFloatBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link FloatBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class FloatBooleanHashMapTest extends AbstractMutableFloatBooleanMapTestCase
{
    @Override
    protected FloatBooleanHashMap classUnderTest()
    {
        return FloatBooleanHashMap.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1)
    {
        return new FloatBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2)
    {
        return new FloatBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3)
    {
        return new FloatBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatBooleanHashMap newWithKeysValues(float key1, boolean value1, float key2, boolean value2, float key3, boolean value3, float key4, boolean value4)
    {
        return new FloatBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatBooleanHashMap getEmptyMap()
    {
        return new FloatBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatBooleanHashMap hashMap = new FloatBooleanHashMap(3);
        Assert.assertEquals(8L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());

        FloatBooleanHashMap hashMap2 = new FloatBooleanHashMap(15);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new FloatBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new FloatBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float i = 2.0f; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, ((int) i & 1) == 0.0f);
        }

        Field keys = FloatBooleanHashMap.class.getDeclaredField("keys");
        Field values = FloatBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (float i = 2.0f; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put(10.0f, true);
        Assert.assertEquals(32L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());

        for (float i = 11; i < 75; i++)
        {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, ((int) i & 1) == 0.0f);
        }
        Assert.assertEquals(256L, ((float[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll()
    {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        MutableFloatBooleanMap copyMap = new FloatBooleanHashMap();

        for (float i = 1.0f; i < 11; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, ((int) i & 1) == 0.0f);
        }

        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);

        hashMap.putAll(copyMap);

        Verify.assertSize(10, hashMap);

        for (float i = 1.0f; i < 11; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
            Assert.assertTrue(copyMap.containsKey(i));
        }

        Assert.assertEquals(hashMap, copyMap);
    }

    @Override
    @Test
    public void withKeysValues()
    {
        super.withKeysValues();
        FloatBooleanHashMap hashMap0 = new FloatBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues(1.0f, false, 2.0f, true), hashMap0);
        FloatBooleanHashMap hashMap1 = new FloatBooleanHashMap().withKeysValues(1.0f, false, 2.0f, true, 3.0f, false);
        FloatBooleanHashMap hashMap2 = new FloatBooleanHashMap().withKeysValues(1.0f, false, 2.0f, true, 3.0f, false, 4.0f, true);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true), hashMap0);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true, 3.0f, false), hashMap1);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(1.0f, false, 2.0f, true, 3.0f, false, 4.0f, true), hashMap2);
    }

    @Test
    public void injectInto()
    {
        FloatBooleanHashMap hashMap0 = new FloatBooleanHashMap().withKeysValues(1.0f, false, 2.0f, true, 3.0f, false, 4.0f, false);

        Float total = hashMap0.injectInto(Float.valueOf(0.0f), (Float result, boolean value) -> value ? result : Float.valueOf((float) (result + 2.0f)));

        Assert.assertEquals(Float.valueOf(6.0f), total);
    }

    @Test
    public void put_every_slot()
    {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            hashMap.put(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
            hashMap.remove(each);
            Assert.assertFalse(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_every_slot()
    {
        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();
        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            hashMap.getIfAbsentPut(each, each % 2 == 0);
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWith_every_slot()
    {
        BooleanFunction<String> functionLength = String::isEmpty;

        MutableFloatBooleanMap hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        FloatToBooleanFunction function = (float each) -> each % 2 == 0;

        MutableFloatBooleanMap hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 == 0, hashMap.getIfAbsentPutWithKey(each, function));
            Assert.assertEquals(each % 2 == 0, hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPut_Function_every_slot()
    {
        BooleanFunction0 factory = () -> true;

        MutableFloatBooleanMap hashMap = this.getEmptyMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPut(each, factory));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void updateValue_every_slot()
    {
        BooleanToBooleanFunction function = (boolean value) -> !value;

        FloatBooleanHashMap hashMap = new FloatBooleanHashMap();

        for (float each = 2.0f; each < 100.0f; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }
}
