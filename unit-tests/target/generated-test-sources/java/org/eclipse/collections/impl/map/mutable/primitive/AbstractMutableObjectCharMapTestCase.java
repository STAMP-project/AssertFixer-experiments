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

import org.eclipse.collections.api.block.function.primitive.CharFunction;
import org.eclipse.collections.api.block.function.primitive.CharFunction0;
import org.eclipse.collections.api.block.function.primitive.CharToCharFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectCharMapTestCase extends AbstractObjectCharMapTestCase
{
    private final MutableObjectCharMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectCharMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1);

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2);

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3);

    @Override
    protected abstract <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4);

    @Override
    protected abstract <T> MutableObjectCharMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions()
    {
        MutableList<String> collisions = FastList.newList();
        ObjectCharHashMap<String> hashMap = new ObjectCharHashMap<>();
        for (int each = 3; collisions.size() <= 10; each++)
        {
            if (hashMap.spread(String.valueOf(each)) == hashMap.spread(String.valueOf(3)))
            {
                collisions.add(String.valueOf(each));
            }
        }
        return collisions;
    }

    @Test
    public void clear()
    {
        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", (char) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectCharHashMap.newMap(), hashMap);

        hashMap.put("1", (char) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectCharHashMap.newMap(), hashMap);

        hashMap.put(null, (char) 0);
        hashMap.clear();
        Assert.assertEquals(ObjectCharHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey()
    {
        MutableObjectCharMap<String> map0 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map0.removeKey("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map0);

        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map1.removeKey("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map1);

        this.map.removeKey("5");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 2), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 1);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(0)));

        Assert.assertEquals((char) 2, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(1)));

        this.map.put(null, (char) 3);
        Assert.assertEquals((char) 3, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals((char) 0, this.map.get(null));
    }

    @Test
    public void remove()
    {
        MutableObjectCharMap<String> map0 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map0.remove("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map0);

        MutableObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);
        map1.remove("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectCharHashMap.newMap(), map1);

        this.map.remove("5");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("1", (char) 1, "2", (char) 2), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues("2", (char) 2), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectCharHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0), (char) 1);
        this.map.put(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1), (char) 2);

        Assert.assertEquals((char) 1, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectCharMapTestCase.generateCollisions().get(0));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(0)));

        Assert.assertEquals((char) 2, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectCharMapTestCase.generateCollisions().get(1));
        Assert.assertEquals((char) 0, this.map.get(generateCollisions().get(1)));

        this.map.put(null, (char) 3);
        Assert.assertEquals((char) 3, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals((char) 0, this.map.get(null));
    }

    @Test
    public void put()
    {
        this.map.put("0", (char) 1);
        this.map.put("1", (char) 2);
        this.map.put("2", (char) 3);
        ObjectCharHashMap<String> expected = ObjectCharHashMap.newWithKeysValues("0", (char) 1, "1", (char) 2, "2", (char) 3);
        Assert.assertEquals(expected, this.map);

        this.map.put("5", (char) 6);
        expected.put("5", (char) 6);
        Assert.assertEquals(expected, this.map);

        this.map.put(null, (char) 7);
        expected.put(null, (char) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", (char) 1));
        this.map.putPair(PrimitiveTuples.pair("1", (char) 2));
        this.map.putPair(PrimitiveTuples.pair("2", (char) 3));
        ObjectCharHashMap<String> expected = ObjectCharHashMap.newWithKeysValues("0", (char) 1, "1", (char) 2, "2", (char) 3);
        Assert.assertEquals(expected, this.map);

        this.map.putPair(PrimitiveTuples.pair("5", (char) 6));
        expected.put("5", (char) 6);
        Assert.assertEquals(expected, this.map);

        this.map.putPair(PrimitiveTuples.pair(null, (char) 7));
        expected.put(null, (char) 7);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        String collision1 = AbstractMutableObjectCharMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectCharMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectCharMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectCharMapTestCase.generateCollisions().get(3);

        MutableObjectCharMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
        hashMap.put(collision2, (char) 2);
        hashMap.put(collision3, (char) 3);
        Assert.assertEquals((char) 2, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(collision1, (char) 1, collision3, (char) 3, collision4, (char) 4), hashMap);

        MutableObjectCharMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, (char) 1);
        hashMap1.put(collision2, (char) 2);
        hashMap1.put(collision3, (char) 3);
        Assert.assertEquals((char) 1, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(collision2, (char) 2, collision3, (char) 3, collision4, (char) 4), hashMap1);

        MutableObjectCharMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, (char) 1);
        hashMap2.put(collision2, (char) 2);
        hashMap2.put(collision3, (char) 3);
        Assert.assertEquals((char) 3, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, (char) 4);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(collision1, (char) 1, collision2, (char) 2, collision4, (char) 4), hashMap2);

        MutableObjectCharMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, (char) 1);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 1), hashMap3);
        hashMap3.put(null, (char) 2);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 2), hashMap3);
    }

    @Override
    @Test
    public void get()
    {
        super.get();

        Assert.assertEquals((char) 0, this.map.get("5"));

        this.map.put("0", (char) 1);
        Assert.assertEquals((char) 1, this.map.get("0"));

        this.map.put("5", (char) 5);
        Assert.assertEquals((char) 5, this.map.get("5"));

        this.map.put(null, (char) 6);
        Assert.assertEquals((char) 6, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();

        this.map.removeKey("0");
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));

        this.map.put("0", (char) 1);
        Assert.assertEquals((char) 1, this.map.getOrThrow("0"));

        this.map.put("5", (char) 5);
        Assert.assertEquals((char) 5, this.map.getOrThrow("5"));

        this.map.put(null, (char) 6);
        Assert.assertEquals((char) 6, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();

        this.map.removeKey("0");
        Assert.assertEquals((char) 1, this.map.getIfAbsent("0", (char) 1));
        Assert.assertEquals((char) 5, this.map.getIfAbsent("0", (char) 5));

        this.map.put("0", (char) 1);
        Assert.assertEquals((char) 1, this.map.getIfAbsent("0", (char) 5));

        this.map.put("5", (char) 5);
        Assert.assertEquals((char) 5, this.map.getIfAbsent("5", (char) 0));

        this.map.put(null, (char) 6);
        Assert.assertEquals((char) 6, this.map.getIfAbsent(null, (char) 5));
    }

    @Test
    public void getIfAbsentPut_Value()
    {
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(0, (char) 50));
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(0, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 50), map1);
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(1, (char) 50));
        Assert.assertEquals((char) 50, map1.getIfAbsentPut(1, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 50, 1, (char) 50), map1);

        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(1, (char) 50));
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(1, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 50), map2);
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(0, (char) 50));
        Assert.assertEquals((char) 50, map2.getIfAbsentPut(0, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 50, 1, (char) 50), map2);

        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 50, map3.getIfAbsentPut(null, (char) 50));
        Assert.assertEquals((char) 50, map3.getIfAbsentPut(null, (char) 100));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 50), map3);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        CharFunction0 factory = () -> (char) 100;

        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(0, factory));

        CharFunction0 factoryThrows = () -> { throw new AssertionError(); };

        Assert.assertEquals((char) 100, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 100), map1);
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals((char) 100, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 100, 1, (char) 100), map1);

        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 100), map2);
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals((char) 100, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 100, 1, (char) 100), map2);

        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 100, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals((char) 100, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 100), map3);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();

        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        CharFunction<String> functionThrows = (String each) -> { throw new AssertionError(); };
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 9), map1);
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 9, 1, (char) 9), map1);

        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 9), map2);
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 9, 1, (char) 9), map2);

        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals((char) 9, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 9), map3);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        CharFunction<Integer> function = (Integer anObject) -> anObject == null ? (char) 32 : (char) anObject.intValue();

        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 0, map1.getIfAbsentPutWithKey(0, function));
        CharFunction<Integer> functionThrows = (Integer charParameter) -> { throw new AssertionError(); };
        Assert.assertEquals((char) 0, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0), map1);
        Assert.assertEquals((char) 1, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((char) 1, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0, 1, (char) 1), map1);

        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals((char) 1, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1), map2);
        Assert.assertEquals((char) 0, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals((char) 0, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0, 1, (char) 1), map2);

        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 32, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals((char) 32, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 32), map3);
    }

    @Test
    public void updateValue()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + 1);

        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map1.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 1), map1);
        Assert.assertEquals((char) 2, map1.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2), map1);
        Assert.assertEquals((char) 1, map1.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2, 1, (char) 1), map1);
        Assert.assertEquals((char) 2, map1.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2, 1, (char) 2), map1);

        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map2.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1), map2);
        Assert.assertEquals((char) 2, map2.updateValue(1, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 2), map2);
        Assert.assertEquals((char) 1, map2.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 1, 1, (char) 2), map2);
        Assert.assertEquals((char) 2, map2.updateValue(0, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 2, 1, (char) 2), map2);

        MutableObjectCharMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map3.updateValue(null, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 1), map3);
        Assert.assertEquals((char) 2, map3.updateValue(null, (char) 0, incrementFunction));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 2), map3);
    }

    @Test
    public void addToValue()
    {
        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map1.addToValue(0, (char) 1));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 1), map1);
        Assert.assertEquals((char) 5, map1.addToValue(0, (char) 4));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 5), map1);
        Assert.assertEquals((char) 2, map1.addToValue(1, (char) 2));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 5, 1, (char) 2), map1);
        Assert.assertEquals((char) 10, map1.addToValue(1, (char) 8));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 5, 1, (char) 10), map1);

        MutableObjectCharMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals((char) 1, map2.addToValue(null, (char) 1));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 1), map2);
        Assert.assertEquals((char) 5, map2.addToValue(null, (char) 4));
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(null, (char) 5), map2);

        MutableObjectCharMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            char v = (char) (each + index);
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v));
        });
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();

        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((char) 0, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals((char) 0, this.map.get("0"));

        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals((char) 0, this.map.get("1"));

        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals((char) 0, this.map.get("2"));

        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals((char) 0, this.map.get("3"));

        this.map.put(null, (char) 5);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        this.map.put("5", (char) 5);
        Assert.assertTrue(this.map.containsValue((char) 5));

        this.map.put(null, (char) 6);
        Assert.assertTrue(this.map.containsValue((char) 6));

        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue((char) 0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableObjectCharMap<Integer> hashMap1 = this.newWithKeysValues(1, (char) 1, 0, (char) 0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);

        MutableObjectCharMap<Integer> hashMap = this.newWithKeysValues(6, (char) 6, 5, (char) 5);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues()
    {
        MutableObjectCharMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectCharMap<Integer> hashMap = emptyMap.withKeyValue(1, (char) 1);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey()
    {
        MutableObjectCharMap<Integer> map = this.newWithKeysValues(0, (char) 0, 1, (char) 1, 2, (char) 2, 3, (char) 3);
        MutableObjectCharMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(0, (char) 0, 1, (char) 1, 2, (char) 2), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableObjectCharMap<Integer> map = this.newWithKeysValues(0, (char) 0, 1, (char) 1, 2, (char) 2, 3, (char) 3);
        MutableObjectCharMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectCharHashMap.newWithKeysValues(1, (char) 1, 2, (char) 2), mapWithout);
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();

        this.map.put("5", (char) 5);
        Assert.assertTrue(this.map.contains((char) 5));

        this.map.put(null, (char) 6);
        Assert.assertTrue(this.map.contains((char) 6));

        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains((char) 0));
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableObjectCharMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectCharMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedObjectCharMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectCharMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues()
    {
        MutableObjectCharMap<String> map = this.newWithKeysValues("1", (char) 2, "2", (char) 3);
        Assert.assertEquals(
                CharObjectHashMap.newWithKeysValues((char) 2, "1", (char) 3, "2"),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues("1", (char) 1, "2", (char) 1).flipUniqueValues());
    }
}
