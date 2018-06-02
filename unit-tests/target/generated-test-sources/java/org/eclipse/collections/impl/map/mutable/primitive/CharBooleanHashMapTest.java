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
import org.eclipse.collections.api.block.function.primitive.CharToBooleanFunction;
import org.eclipse.collections.api.map.primitive.MutableCharBooleanMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link CharBooleanHashMap}.
 * This file was automatically generated from template file primitiveBooleanHashMapTest.stg.
 */
public class CharBooleanHashMapTest extends AbstractMutableCharBooleanMapTestCase
{
    @Override
    protected CharBooleanHashMap classUnderTest()
    {
        return CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1)
    {
        return new CharBooleanHashMap(1).withKeyValue(key1, value1);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2)
    {
        return new CharBooleanHashMap(2).withKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3)
    {
        return new CharBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected CharBooleanHashMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4)
    {
        return new CharBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected CharBooleanHashMap getEmptyMap()
    {
        return new CharBooleanHashMap();
    }

    @Test
    public void defaultInitialCapacity() throws Exception
    {
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void newWithInitialCapacity() throws Exception
    {
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharBooleanHashMap hashMap = new CharBooleanHashMap(3);
        Assert.assertEquals(8L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());

        CharBooleanHashMap hashMap2 = new CharBooleanHashMap(15);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap2)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void newWithInitialCapacity_negative_throws()
    {
        new CharBooleanHashMap(-1);
    }

    @Test
    public void newMap() throws Exception
    {
        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        keys.setAccessible(true);
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        values.setAccessible(true);

        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Assert.assertEquals(new CharBooleanHashMap(), hashMap);
    }

    @Test
    public void putWithRehash() throws Exception
    {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char i = (char) 2; i < 10; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (char) 0);
        }

        Field keys = CharBooleanHashMap.class.getDeclaredField("keys");
        Field values = CharBooleanHashMap.class.getDeclaredField("values");
        keys.setAccessible(true);
        values.setAccessible(true);
        Assert.assertEquals(16L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());
        Verify.assertSize(8, hashMap);
        for (char i = (char) 2; i < 10; i++)
        {
            Assert.assertTrue(hashMap.containsKey(i));
        }
        Assert.assertTrue(hashMap.containsValue(false));
        Assert.assertTrue(hashMap.containsValue(true));
        hashMap.put((char) 10, true);
        Assert.assertEquals(32L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(64L, ((BitSet) values.get(hashMap)).size());

        for (char i = 11; i < 75; i++)
        {
            Assert.assertFalse(String.valueOf(i), hashMap.containsKey(i));
            hashMap.put(i, (i & 1) == (char) 0);
        }
        Assert.assertEquals(256L, ((char[]) keys.get(hashMap)).length);
        Assert.assertEquals(256L, ((BitSet) values.get(hashMap)).size());
    }

    @Test
    public void testPutAll()
    {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        MutableCharBooleanMap copyMap = new CharBooleanHashMap();

        for (char i = (char) 1; i < 11; i++)
        {
            Assert.assertFalse(hashMap.containsKey(i));
            Assert.assertFalse(copyMap.containsKey(i));
            copyMap.put(i, (i & 1) == (char) 0);
        }

        Verify.assertSize(10, copyMap);
        Verify.assertSize(0, hashMap);

        hashMap.putAll(copyMap);

        Verify.assertSize(10, hashMap);

        for (char i = (char) 1; i < 11; i++)
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
        CharBooleanHashMap hashMap0 = new CharBooleanHashMap();
        Assert.assertSame(hashMap0.withKeysValues((char) 1, false, (char) 2, true), hashMap0);
        CharBooleanHashMap hashMap1 = new CharBooleanHashMap().withKeysValues((char) 1, false, (char) 2, true, (char) 3, false);
        CharBooleanHashMap hashMap2 = new CharBooleanHashMap().withKeysValues((char) 1, false, (char) 2, true, (char) 3, false, (char) 4, true);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, true), hashMap0);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, true, (char) 3, false), hashMap1);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 1, false, (char) 2, true, (char) 3, false, (char) 4, true), hashMap2);
    }

    @Test
    public void injectInto()
    {
        CharBooleanHashMap hashMap0 = new CharBooleanHashMap().withKeysValues((char) 1, false, (char) 2, true, (char) 3, false, (char) 4, false);

        Character total = hashMap0.injectInto(Character.valueOf((char) 0), (Character result, boolean value) -> value ? result : Character.valueOf((char) (result + (char) 2)));

        Assert.assertEquals(Character.valueOf((char) 6), total);
    }

    @Test
    public void put_every_slot()
    {
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char each = (char) 2; each < (char) 100; each++)
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
        CharBooleanHashMap hashMap = new CharBooleanHashMap();
        for (char each = (char) 2; each < (char) 100; each++)
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

        MutableCharBooleanMap hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertTrue(hashMap.getIfAbsentPutWith(each, functionLength, ""));
            Assert.assertTrue(hashMap.get(each));
        }
    }

    @Test
    public void getIfAbsentPutWithKey_every_slot()
    {
        CharToBooleanFunction function = (char each) -> each % 2 == 0;

        MutableCharBooleanMap hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
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

        MutableCharBooleanMap hashMap = this.getEmptyMap();

        for (char each = (char) 2; each < (char) 100; each++)
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

        CharBooleanHashMap hashMap = new CharBooleanHashMap();

        for (char each = (char) 2; each < (char) 100; each++)
        {
            Assert.assertFalse(hashMap.get(each));
            Assert.assertEquals(each % 2 != 0, hashMap.updateValue(each, each % 2 == 0, function));
            Assert.assertEquals(each % 2 != 0, hashMap.get(each));
        }
    }
}
