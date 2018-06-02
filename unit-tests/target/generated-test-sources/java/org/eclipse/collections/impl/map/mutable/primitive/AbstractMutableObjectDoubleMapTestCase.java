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

import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.primitive.IntInterval;
import org.eclipse.collections.impl.map.primitive.AbstractObjectDoubleMapTestCase;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * This file was automatically generated from template file abstractMutableObjectPrimitiveMapTestCase.stg.
 */
public abstract class AbstractMutableObjectDoubleMapTestCase extends AbstractObjectDoubleMapTestCase
{
    private final MutableObjectDoubleMap<String> map = this.classUnderTest();

    @Override
    protected abstract MutableObjectDoubleMap<String> classUnderTest();

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3, T key4, double value4);

    @Override
    protected abstract <T> MutableObjectDoubleMap<T> getEmptyMap();

    protected static MutableList<String> generateCollisions()
    {
        MutableList<String> collisions = FastList.newList();
        ObjectDoubleHashMap<String> hashMap = new ObjectDoubleHashMap<>();
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
        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        hashMap.put("0", 0.0);
        hashMap.clear();
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), hashMap);

        hashMap.put("1", 0.0);
        hashMap.clear();
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), hashMap);

        hashMap.put(null, 0.0);
        hashMap.clear();
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), hashMap);
    }

    @Test
    public void removeKey()
    {
        MutableObjectDoubleMap<String> map0 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map0.removeKey("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0), map0);
        map0.removeKey("0");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map0);

        MutableObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map1.removeKey("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0), map1);
        map1.removeKey("1");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map1);

        this.map.removeKey("5");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0), this.map);
        this.map.removeKey("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0), this.map);
        this.map.removeKey("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 2.0), this.map);
        this.map.removeKey("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        this.map.removeKey("0");
        this.map.removeKey("1");
        this.map.removeKey("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0), 1.0);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, this.map.get(generateCollisions().get(0)), 0.0);
        this.map.removeKey(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, this.map.get(generateCollisions().get(1)), 0.0);
        this.map.removeKey(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(1)), 0.0);

        this.map.put(null, 3.0);
        Assert.assertEquals(3.0, this.map.get(null), 0.0);
        this.map.removeKey(null);
        Assert.assertEquals(0.0, this.map.get(null), 0.0);
    }

    @Test
    public void remove()
    {
        MutableObjectDoubleMap<String> map0 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map0.remove("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0), map0);
        map0.remove("0");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map0);

        MutableObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0);
        map1.remove("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0), map1);
        map1.remove("1");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), map1);

        this.map.remove("5");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0), this.map);
        this.map.remove("0");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("1", 1.0, "2", 2.0), this.map);
        this.map.remove("1");
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("2", 2.0), this.map);
        this.map.remove("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        this.map.remove("0");
        this.map.remove("1");
        this.map.remove("2");
        Assert.assertEquals(ObjectDoubleHashMap.newMap(), this.map);
        Verify.assertEmpty(this.map);

        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0), 1.0);
        this.map.put(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1), 2.0);

        Assert.assertEquals(1.0, this.map.get(generateCollisions().get(0)), 0.0);
        this.map.remove(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(0));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(0)), 0.0);

        Assert.assertEquals(2.0, this.map.get(generateCollisions().get(1)), 0.0);
        this.map.remove(AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1));
        Assert.assertEquals(0.0, this.map.get(generateCollisions().get(1)), 0.0);

        this.map.put(null, 3.0);
        Assert.assertEquals(3.0, this.map.get(null), 0.0);
        this.map.remove(null);
        Assert.assertEquals(0.0, this.map.get(null), 0.0);
    }

    @Test
    public void put()
    {
        this.map.put("0", 1.0);
        this.map.put("1", 2.0);
        this.map.put("2", 3.0);
        ObjectDoubleHashMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("0", 1.0, "1", 2.0, "2", 3.0);
        Assert.assertEquals(expected, this.map);

        this.map.put("5", 6.0);
        expected.put("5", 6.0);
        Assert.assertEquals(expected, this.map);

        this.map.put(null, 7.0);
        expected.put(null, 7.0);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", 1.0));
        this.map.putPair(PrimitiveTuples.pair("1", 2.0));
        this.map.putPair(PrimitiveTuples.pair("2", 3.0));
        ObjectDoubleHashMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("0", 1.0, "1", 2.0, "2", 3.0);
        Assert.assertEquals(expected, this.map);

        this.map.putPair(PrimitiveTuples.pair("5", 6.0));
        expected.put("5", 6.0);
        Assert.assertEquals(expected, this.map);

        this.map.putPair(PrimitiveTuples.pair(null, 7.0));
        expected.put(null, 7.0);
        Assert.assertEquals(expected, this.map);
    }

    @Test
    public void putDuplicateWithRemovedSlot()
    {
        String collision1 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().getFirst();
        String collision2 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(1);
        String collision3 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(2);
        String collision4 = AbstractMutableObjectDoubleMapTestCase.generateCollisions().get(3);

        MutableObjectDoubleMap<String> hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
        hashMap.put(collision2, 2.0);
        hashMap.put(collision3, 3.0);
        Assert.assertEquals(2.0, hashMap.get(collision2), 0.0);
        hashMap.removeKey(collision2);
        hashMap.put(collision4, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(collision1, 1.0, collision3, 3.0, collision4, 4.0), hashMap);

        MutableObjectDoubleMap<String> hashMap1 = this.getEmptyMap();
        hashMap1.put(collision1, 1.0);
        hashMap1.put(collision2, 2.0);
        hashMap1.put(collision3, 3.0);
        Assert.assertEquals(1.0, hashMap1.get(collision1), 0.0);
        hashMap1.removeKey(collision1);
        hashMap1.put(collision4, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(collision2, 2.0, collision3, 3.0, collision4, 4.0), hashMap1);

        MutableObjectDoubleMap<String> hashMap2 = this.getEmptyMap();
        hashMap2.put(collision1, 1.0);
        hashMap2.put(collision2, 2.0);
        hashMap2.put(collision3, 3.0);
        Assert.assertEquals(3.0, hashMap2.get(collision3), 0.0);
        hashMap2.removeKey(collision3);
        hashMap2.put(collision4, 4.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(collision1, 1.0, collision2, 2.0, collision4, 4.0), hashMap2);

        MutableObjectDoubleMap<String> hashMap3 = this.getEmptyMap();
        hashMap3.put(null, 1.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 1.0), hashMap3);
        hashMap3.put(null, 2.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 2.0), hashMap3);
    }

    @Override
    @Test
    public void get()
    {
        super.get();

        Assert.assertEquals(0.0, this.map.get("5"), 0.0);

        this.map.put("0", 1.0);
        Assert.assertEquals(1.0, this.map.get("0"), 0.0);

        this.map.put("5", 5.0);
        Assert.assertEquals(5.0, this.map.get("5"), 0.0);

        this.map.put(null, 6.0);
        Assert.assertEquals(6.0, this.map.get(null), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        super.getOrThrow();

        this.map.removeKey("0");
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("0"));

        this.map.put("0", 1.0);
        Assert.assertEquals(1.0, this.map.getOrThrow("0"), 0.0);

        this.map.put("5", 5.0);
        Assert.assertEquals(5.0, this.map.getOrThrow("5"), 0.0);

        this.map.put(null, 6.0);
        Assert.assertEquals(6.0, this.map.getOrThrow(null), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        super.getIfAbsent();

        this.map.removeKey("0");
        Assert.assertEquals(1.0, this.map.getIfAbsent("0", 1.0), 0.0);
        Assert.assertEquals(5.0, this.map.getIfAbsent("0", 5.0), 0.0);

        this.map.put("0", 1.0);
        Assert.assertEquals(1.0, this.map.getIfAbsent("0", 5.0), 0.0);

        this.map.put("5", 5.0);
        Assert.assertEquals(5.0, this.map.getIfAbsent("5", 0.0), 0.0);

        this.map.put(null, 6.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent(null, 5.0), 0.0);
    }

    @Test
    public void getIfAbsentPut_Value()
    {
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 50.0), map1);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map1.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map1);

        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(1, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 50.0), map2);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 50.0), 0.0);
        Assert.assertEquals(50.0, map2.getIfAbsentPut(0, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 50.0, 1, 50.0), map2);

        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(50.0, map3.getIfAbsentPut(null, 50.0), 0.0);
        Assert.assertEquals(50.0, map3.getIfAbsentPut(null, 100.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 50.0), map3);
    }

    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;

        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factory), 0.0);

        DoubleFunction0 factoryThrows = () -> { throw new AssertionError(); };

        Assert.assertEquals(100.0, map1.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 100.0), map1);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map1.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map1);

        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(1, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 100.0), map2);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factory), 0.0);
        Assert.assertEquals(100.0, map2.getIfAbsentPut(0, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 100.0, 1, 100.0), map2);

        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(100.0, map3.getIfAbsentPut(null, factory), 0.0);
        Assert.assertEquals(100.0, map3.getIfAbsentPut(null, factoryThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 100.0), map3);
    }

    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> string.length();

        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        DoubleFunction<String> functionThrows = (String each) -> { throw new AssertionError(); };
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 9.0), map1);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map1.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map1);

        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(1, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 9.0), map2);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map2.getIfAbsentPutWith(0, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 9.0, 1, 9.0), map2);

        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(null, functionLength, "123456789"), 0.0);
        Assert.assertEquals(9.0, map3.getIfAbsentPutWith(null, functionThrows, "unused"), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 9.0), map3);
    }

    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleFunction<Integer> function = (Integer anObject) -> anObject == null ? 32.0 : anObject.intValue();

        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, function), 0.0);
        DoubleFunction<Integer> functionThrows = (Integer doubleParameter) -> { throw new AssertionError(); };
        Assert.assertEquals(0.0, map1.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0), map1);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map1.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map1);

        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, function), 0.0);
        Assert.assertEquals(1.0, map2.getIfAbsentPutWithKey(1, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, function), 0.0);
        Assert.assertEquals(0.0, map2.getIfAbsentPutWithKey(0, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0), map2);

        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(null, function), 0.0);
        Assert.assertEquals(32.0, map3.getIfAbsentPutWithKey(null, functionThrows), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 32.0), map3);
    }

    @Test
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1;

        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0), map1);
        Assert.assertEquals(1.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0, 1, 1.0), map1);
        Assert.assertEquals(2.0, map1.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map1);

        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(1, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 2.0), map2);
        Assert.assertEquals(1.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 1.0, 1, 2.0), map2);
        Assert.assertEquals(2.0, map2.updateValue(0, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 2.0, 1, 2.0), map2);

        MutableObjectDoubleMap<Integer> map3 = this.getEmptyMap();
        Assert.assertEquals(1.0, map3.updateValue(null, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 1.0), map3);
        Assert.assertEquals(2.0, map3.updateValue(null, 0.0, incrementFunction), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 2.0), map3);
    }

    @Test
    public void addToValue()
    {
        MutableObjectDoubleMap<Integer> map1 = this.getEmptyMap();
        Assert.assertEquals(1.0, map1.addToValue(0, 1.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 1.0), map1);
        Assert.assertEquals(5.0, map1.addToValue(0, 4.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 5.0), map1);
        Assert.assertEquals(2.0, map1.addToValue(1, 2.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 5.0, 1, 2.0), map1);
        Assert.assertEquals(10.0, map1.addToValue(1, 8.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 5.0, 1, 10.0), map1);

        MutableObjectDoubleMap<Integer> map2 = this.getEmptyMap();
        Assert.assertEquals(1.0, map2.addToValue(null, 1.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 1.0), map2);
        Assert.assertEquals(5.0, map2.addToValue(null, 4.0), 0.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(null, 5.0), map2);

        MutableObjectDoubleMap<String> map3 = this.getEmptyMap();
        IntInterval.zeroTo(10).forEachWithIndex((each, index) -> {
            double v = each + index;
            Assert.assertEquals("Key:" + each, v, map3.addToValue(String.valueOf(each), v), 0.0);
        });
    }

    @Override
    @Test
    public void containsKey()
    {
        super.containsKey();

        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0.0, this.map.get("0"), 0.0);
        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsKey("0"));
        Assert.assertEquals(0.0, this.map.get("0"), 0.0);

        this.map.removeKey("1");
        Assert.assertFalse(this.map.containsKey("1"));
        Assert.assertEquals(0.0, this.map.get("1"), 0.0);

        this.map.removeKey("2");
        Assert.assertFalse(this.map.containsKey("2"));
        Assert.assertEquals(0.0, this.map.get("2"), 0.0);

        this.map.removeKey("3");
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertEquals(0.0, this.map.get("3"), 0.0);

        this.map.put(null, 5.0);
        Assert.assertTrue(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        super.containsValue();
        this.map.put("5", 5.0);
        Assert.assertTrue(this.map.containsValue(5.0));

        this.map.put(null, 6.0);
        Assert.assertTrue(this.map.containsValue(6.0));

        this.map.removeKey("0");
        Assert.assertFalse(this.map.containsValue(0.0));
    }

    @Override
    @Test
    public void size()
    {
        super.size();
        MutableObjectDoubleMap<Integer> hashMap1 = this.newWithKeysValues(1, 1.0, 0, 0.0);
        Verify.assertSize(2, hashMap1);
        hashMap1.removeKey(1);
        Verify.assertSize(1, hashMap1);
        hashMap1.removeKey(0);
        Verify.assertSize(0, hashMap1);

        MutableObjectDoubleMap<Integer> hashMap = this.newWithKeysValues(6, 6.0, 5, 5.0);
        hashMap.removeKey(5);
        Verify.assertSize(1, hashMap);
    }

    @Test
    public void withKeysValues()
    {
        MutableObjectDoubleMap<Integer> emptyMap = this.getEmptyMap();
        MutableObjectDoubleMap<Integer> hashMap = emptyMap.withKeyValue(1, 1.0);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0), hashMap);
        Assert.assertSame(emptyMap, hashMap);
    }

    @Test
    public void withoutKey()
    {
        MutableObjectDoubleMap<Integer> map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        MutableObjectDoubleMap<Integer> mapWithout = map.withoutKey(3);
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0), mapWithout);
    }

    @Test
    public void withoutAllKeys()
    {
        MutableObjectDoubleMap<Integer> map = this.newWithKeysValues(0, 0.0, 1, 1.0, 2, 2.0, 3, 3.0);
        MutableObjectDoubleMap<Integer> mapWithout = map.withoutAllKeys(FastList.newListWith(0, 3));
        Assert.assertSame(map, mapWithout);
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues(1, 1.0, 2, 2.0), mapWithout);
    }

    @Override
    @Test
    public void contains()
    {
        super.contains();

        this.map.put("5", 5.0);
        Assert.assertTrue(this.map.contains(5.0));

        this.map.put(null, 6.0);
        Assert.assertTrue(this.map.contains(6.0));

        this.map.removeKey("0");
        Assert.assertFalse(this.map.contains(0.0));
    }

    @Test
    public void asUnmodifiable()
    {
        Verify.assertInstanceOf(UnmodifiableObjectDoubleMap.class, this.map.asUnmodifiable());
        Assert.assertEquals(new UnmodifiableObjectDoubleMap<>(this.map), this.map.asUnmodifiable());
    }

    @Test
    public void asSynchronized()
    {
        Verify.assertInstanceOf(SynchronizedObjectDoubleMap.class, this.map.asSynchronized());
        Assert.assertEquals(new SynchronizedObjectDoubleMap<>(this.map), this.map.asSynchronized());
    }

    @Test
    public void flipUniqueValues()
    {
        MutableObjectDoubleMap<String> map = this.newWithKeysValues("1", 2.0, "2", 3.0);
        Assert.assertEquals(
                DoubleObjectHashMap.newWithKeysValues(2.0, "1", 3.0, "2"),
                map.flipUniqueValues());
         Verify.assertThrows(
                IllegalStateException.class,
                () -> this.newWithKeysValues("1", 1.0, "2", 1.0).flipUniqueValues());
    }
}
