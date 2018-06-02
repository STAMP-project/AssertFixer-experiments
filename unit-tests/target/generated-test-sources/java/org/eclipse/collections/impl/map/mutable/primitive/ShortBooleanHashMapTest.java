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
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableShortBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ShortBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class ShortBooleanHashMapTest extends AbstractMutableShortBooleanMapTestCase
{
    @Override
    protected ShortBooleanHashMap classUnderTest()
    {
        return ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1)
    {
        return new ShortBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2)
    {
        return new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3)
    {
        return new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortBooleanHashMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4)
    {
        return new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortBooleanHashMap getEmptyMap()
    {
        return new ShortBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortBooleanHashMap hashMap = new ShortBooleanHashMap(3);
        Assert.assertEquals(8L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());

        ShortBooleanHashMap hashMap2 = new ShortBooleanHashMap(15);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new ShortBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new ShortBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short i = (short) 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (short) 0);
        }

        Field keys = ShortBooleanHashMap.class.getDeclaredField("keys");
        Field values = ShortBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (short i = (short) 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put((short) 10, true);
        Assert.assertEquals(32L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());

        for (short i = 11; i < 75; i++)
        {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (short) 0);
        }
        Assert.assertEquals(256L, ((short[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll()
    {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        MutableShortBooleanMap copyMap = new ShortBooleanHashMap();

        for (short i = (short) 1; i < 11; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == (short) 0);
        }

        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);

        hashMap.putAll(copyMap);

        Verify.assertSize(10, hashMap);

        for (short i = (short) 1; i < 11; i++)
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
        ShortBooleanHashMap hashMap0 = new ShortBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues((short) 1, false, (short) 2, true), hashMap0);
        ShortBooleanHashMap hashMap1 = new ShortBooleanHashMap().withKeysValues((short) 1, false, (short) 2, true, (short) 3, false);
        ShortBooleanHashMap hashMap2 = new ShortBooleanHashMap().withKeysValues((short) 1, false, (short) 2, true, (short) 3, false, (short) 4, true);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, true), hashMap0);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, true, (short) 3, false), hashMap1);
        Assert.assertEquals(ShortBooleanHashMap.newWithKeysValues((short) 1, false, (short) 2, true, (short) 3, false, (short) 4, true), hashMap2);
    }

    @Test
    public void injectInto()
    {
        ShortBooleanHashMap hashMap0 = new ShortBooleanHashMap().withKeysValues((short) 1, false, (short) 2, true, (short) 3, false, (short) 4, false);

        Short total = hashMap0.injectInto(Short.valueOf((short) 0), (Short result, boolean value) -> value ? result : Short.valueOf((short) (result + (short) 2)));

        Assert.assertEquals(Short.valueOf((short) 6), total);
    }

    @Test
    public void put_every_slot()
    {
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; each < (short) 100; each++)
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
        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();
        for (short each = (short) 2; each < (short) 100; each++)
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

        MutableShortBooleanMap hashMap = this.getEmptyMap();

        for (short each = (short) 2; each < (short) 100; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        ShortToBooleanFunction function = (short each) -> each % 2 == 0;

        MutableShortBooleanMap hashMap = this.getEmptyMap();

        for (short each = (short) 2; each < (short) 100; each++)
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

        MutableShortBooleanMap hashMap = this.getEmptyMap();

        for (short each = (short) 2; each < (short) 100; each++)
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

        ShortBooleanHashMap hashMap = new ShortBooleanHashMap();

        for (short each = (short) 2; each < (short) 100; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }
}
