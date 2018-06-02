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

import org.eclipse.collections.api.block.function.primitive.LongFunction;
import org.eclipse.collections.api.block.function.primitive.LongFunction0;
import org.eclipse.collections.api.block.function.primitive.LongToLongFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectLongMapTestCase extends AbstractObjectLongMapTestCase
{
    private final MutableObjectLongMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectLongMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1);

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2);

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3);

    @Override
    protected abstract <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4);

    @Override
    protected abstract <T> MutableObjectLongMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions()
    {
        MutableList<String> collisions = FastList.newList();
        ObjectLongHashMap<String> hashMap = new ObjectLongHashMap<>();
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
        MutableObjectLongMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", 0L);
        hashMap.clear();
        Assert.assertEquals(ObjectLongHashMap.newMap(), hashMap);

        hashMap.put("1", 0L);
        hashMap.clear();
        Assert.assertEquals(ObjectLongHashMap.newMap(), hashMap);

        hashMap.put(null, 0L);
        hashMap.clear();
        Assert.assertEquals(ObjectLongHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey()
    {
        MutableObjectLongMap<String> map0 = this.newWithKeysValues("0", 0L, "1", 1L);
        map0.removeKey("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map0);

        MutableObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L);
        map1.removeKey("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map1);

        this.map.removeKey("5");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 2L), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0), 1L);
        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, this.map.get(generateCollisions().get(0)));
        this.map.removeKey(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(0)));

        Assert.assertEquals(2L, this.map.get(generateCollisions().get(1)));
        this.map.removeKey(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(1)));

        this.map.put(null, 3L);
        Assert.assertEquals(3L, this.map.get(null));
        this.map.removeKey(null);
        Assert.assertEquals(0L, this.map.get(null));
    }

    @Test
    public void remove()
    {
        MutableObjectLongMap<String> map0 = this.newWithKeysValues("0", 0L, "1", 1L);
        map0.remove("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map0);

        MutableObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L);
        map1.remove("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectLongHashMap.newMap(), map1);

        this.map.remove("5");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("1", 1L, "2", 2L), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues("2", 2L), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectLongHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0), 1L);
        this.map.put(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1), 2L);

        Assert.assertEquals(1L, this.map.get(generateCollisions().get(0)));
        this.map.remove(AbstractMutableObjectLongMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(0)));

        Assert.assertEquals(2L, this.map.get(generateCollisions().get(1)));
        this.map.remove(AbstractMutableObjectLongMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0L, this.map.get(generateCollisions().get(1)));

        this.map.put(null, 3L);
        Assert.assertEquals(3L, this.map.get(null));
        this.map.remove(null);
        Assert.assertEquals(0L, this.map.get(null));
    }

    @Test
    public void put()
    {
        this.map.put("0", 1L);
        this.map.put("1", 2L);
        this.map.put("2", 3L);
        ObjectLongHashMap<String> expected = ObjectLongHashMap.newWithKeysValues("0", 1L, "1", 2L, "2", 3L);
        Assert.assertEquals(expected, this.map);

        this.map.put("5", 6L);
        expected.put("5", 6L);
        Assert.assertEquals(expected, this.map);

        this.map.put(null, 7L);
        expected.put(null, 7L);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", 1L));
        this.map.putPair(PrimitiveTuples.pair("1", 2L));
        this.map.putPair(PrimitiveTuples.pair("2", 3L));
        ObjectLongHashMap<String> expected = ObjectLongHashMap.newWithKeysValues("0", 1L, "1", 2L, "2", 3L);
        Assert.assertEquals(expected, this.map);

        this.map.putPair(PrimitiveTuples.pair("5", 6L));
        expected.put("5", 6L);
        Assert.assertEquals(expected, this.map);

        this.map.putPair(PrimitiveTuples.pair(null, 7L));
        expected.put(null, 7L);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        String collision1 = AbstractMutableObjectLongMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectLongMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectLongMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectLongMapTestCase.generateCollisions().get(3);

        MutableObjectLongMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
        hashMap.put(collision2, 2L);
        hashMap.put(collision3, 3L);
        Assert.assertEquals(2L, hashMap.get(collision2));
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(collision1, 1L, collision3, 3L, collision4, 4L), hashMap);

        MutableObjectLongMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1L);
        hashMap1.put(collision2, 2L);
        hashMap1.put(collision3, 3L);
        Assert.assertEquals(1L, hashMap1.get(collision1));
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(collision2, 2L, collision3, 3L, collision4, 4L), hashMap1);

        MutableObjectLongMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1L);
        hashMap2.put(collision2, 2L);
        hashMap2.put(collision3, 3L);
        Assert.assertEquals(3L, hashMap2.get(collision3));
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(collision1, 1L, collision2, 2L, collision4, 4L), hashMap2);

        MutableObjectLongMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, 1L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 1L), hashMap3);
        hashMap3.put(null, 2L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 2L), hashMap3);
    }

    @Override
    @Test
    public void get()
    {
        super.get();

        Assert.assertEquals(0L, this.map.get("5"));

        this.map.put("0", 1L);
        Assert.assertEquals(1L, this.map.get("0"));

        this.map.put("5", 5L);
        Assert.assertEquals(5L, this.map.get("5"));

        this.map.put(null, 6L);
        Assert.assertEquals(6L, this.map.get(null));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();

        this.map.removeKey("0");
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));

        this.map.put("0", 1L);
        Assert.assertEquals(1L, this.map.getOrThrow("0"));

        this.map.put("5", 5L);
        Assert.assertEquals(5L, this.map.getOrThrow("5"));

        this.map.put(null, 6L);
        Assert.assertEquals(6L, this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();

        this.map.removeKey("0");
        Assert.assertEquals(1L, this.map.getIfAbsent("0", 1L));
        Assert.assertEquals(5L, this.map.getIfAbsent("0", 5L));

        this.map.put("0", 1L);
        Assert.assertEquals(1L, this.map.getIfAbsent("0", 5L));

        this.map.put("5", 5L);
        Assert.assertEquals(5L, this.map.getIfAbsent("5", 0L));

        this.map.put(null, 6L);
        Assert.assertEquals(6L, this.map.getIfAbsent(null, 5L));
    }

    @Test
    public void getIfAbsentPut_Value()
    {
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(0, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 50L), map1);
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map1.getIfAbsentPut(1, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map1);

        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(1, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 50L), map2);
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 50L));
        Assert.assertEquals(50L, map2.getIfAbsentPut(0, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 50L, 1, 50L), map2);

        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(50L, map3.getIfAbsentPut(null, 50L));
        Assert.assertEquals(50L, map3.getIfAbsentPut(null, 100L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 50L), map3);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factory));

        LongFunction0 factoryThrows = () -> { throw new AssertionError(); };

        Assert.assertEquals(100L, map1.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 100L), map1);
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map1.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map1);

        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(1, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 100L), map2);
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factory));
        Assert.assertEquals(100L, map2.getIfAbsentPut(0, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 100L, 1, 100L), map2);

        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(100L, map3.getIfAbsentPut(null, factory));
        Assert.assertEquals(100L, map3.getIfAbsentPut(null, factoryThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 100L), map3);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> string.length();

        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionLength, "123456789"));
        LongFunction<String> functionThrows = (String each) -> { throw new AssertionError(); };
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 9L), map1);
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map1.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map1);

        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(1, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 9L), map2);
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionLength, "123456789"));
        Assert.assertEquals(9L, map2.getIfAbsentPutWith(0, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 9L, 1, 9L), map2);

        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(null, functionLength, "123456789"));
        Assert.assertEquals(9L, map3.getIfAbsentPutWith(null, functionThrows, "unused"));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 9L), map3);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        LongFunction<Integer> function = (Integer anObject) -> anObject == null ? 32L : anObject.intValue();

        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, function));
        LongFunction<Integer> functionThrows = (Integer longParameter) -> { throw new AssertionError(); };
        Assert.assertEquals(0L, map1.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L), map1);
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map1.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map1);

        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, function));
        Assert.assertEquals(1L, map2.getIfAbsentPutWithKey(1, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, function));
        Assert.assertEquals(0L, map2.getIfAbsentPutWithKey(0, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L, 1, 1L), map2);

        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(null, function));
        Assert.assertEquals(32L, map3.getIfAbsentPutWithKey(null, functionThrows));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 32L), map3);
    }

    @Test
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1;

        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L), map1);
        Assert.assertEquals(1L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L, 1, 1L), map1);
        Assert.assertEquals(2L, map1.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map1);

        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L), map2);
        Assert.assertEquals(2L, map2.updateValue(1, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 2L), map2);
        Assert.assertEquals(1L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 1L, 1, 2L), map2);
        Assert.assertEquals(2L, map2.updateValue(0, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 2L, 1, 2L), map2);

        MutableObjectLongMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(1L, map3.updateValue(null, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 1L), map3);
        Assert.assertEquals(2L, map3.updateValue(null, 0L, incrementFunction));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 2L), map3);
    }

    @Test
    public void addToValue()
    {
        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1L, map1.addToValue(0, 1L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 1L), map1);
        Assert.assertEquals(5L, map1.addToValue(0, 4L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 5L), map1);
        Assert.assertEquals(2L, map1.addToValue(1, 2L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 5L, 1, 2L), map1);
        Assert.assertEquals(10L, map1.addToValue(1, 8L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 5L, 1, 10L), map1);

        MutableObjectLongMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1L, map2.addToValue(null, 1L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 1L), map2);
        Assert.assertEquals(5L, map2.addToValue(null, 4L));
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(null, 5L), map2);

        MutableObjectLongMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            long v = each + index;
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
        Assert.assertEquals(0L, this.map.get("0"));
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0L, this.map.get("0"));

        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals(0L, this.map.get("1"));

        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals(0L, this.map.get("2"));

        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals(0L, this.map.get("3"));

        this.map.put(null, 5L);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        this.map.put("5", 5L);
        Assert.assertTrue(this.map.containsValue(5L));

        this.map.put(null, 6L);
        Assert.assertTrue(this.map.containsValue(6L));

        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue(0L));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableObjectLongMap<Integer> hashMap1 = this.newWithKeysValues(1, 1L, 0, 0L);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);

        MutableObjectLongMap<Integer> hashMap = this.newWithKeysValues(6, 6L, 5, 5L);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues()
    {
        MutableObjectLongMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectLongMap<Integer> hashMap = emptyMap.withKeyValue(1, 1L);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey()
    {
        MutableObjectLongMap<Integer> map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        MutableObjectLongMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(0, 0L, 1, 1L, 2, 2L), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableObjectLongMap<Integer> map = this.newWithKeysValues(0, 0L, 1, 1L, 2, 2L, 3, 3L);
        MutableObjectLongMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectLongHashMap.newWithKeysValues(1, 1L, 2, 2L), mapWithout);
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();

        this.map.put("5", 5L);
        Assert.assertTrue(this.map.contains(5L));

        this.map.put(null, 6L);
        Assert.assertTrue(this.map.contains(6L));

        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains(0L));
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableObjectLongMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectLongMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedObjectLongMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectLongMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues()
    {
        MutableObjectLongMap<String> map = this.newWithKeysValues("1", 2L, "2", 3L);
        Assert.assertEquals(
                LongObjectHashMap.newWithKeysValues(2L, "1", 3L, "2"),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues("1", 1L, "2", 1L).flipUniqueValues());
    }
}
