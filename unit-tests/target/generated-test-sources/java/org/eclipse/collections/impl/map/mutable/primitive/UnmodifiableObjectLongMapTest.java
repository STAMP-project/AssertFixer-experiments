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
import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableObjectLongMap}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapTest.stg.
 */
public class UnmodifiableObjectLongMapTest extends AbstractMutableObjectLongMapTestCase
{
    private final UnmodifiableObjectLongMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableObjectLongMap<String> classUnderTest()
    {
        return new UnmodifiableObjectLongMap<>(ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L));
    }

    @Override
    protected <T> UnmodifiableObjectLongMap<T> newWithKeysValues(T key1, long value1)
    {
        return new UnmodifiableObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2)
    {
        return new UnmodifiableObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3)
    {
        return new UnmodifiableObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3, T key4, long value4)
    {
        return new UnmodifiableObjectLongMap<>(ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> UnmodifiableObjectLongMap<T> getEmptyMap()
    {
        return new UnmodifiableObjectLongMap<>(new ObjectLongHashMap<>());
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        Assert.assertSame(this.map, this.map.asUnmodifiable());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.map.clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey()
    {
        this.map.removeKey("0");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove("0");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put("0", 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", 1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue("1", 0L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey("0");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(FastList.newListWith("0", "1"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        String collision1 = AbstractMutableObjectLongMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, 1L);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get("0"));
        Assert.assertEquals(1L, this.map.get("1"));
        Assert.assertEquals(2L, this.map.get("2"));

        Assert.assertEquals(0L, this.map.get("5"));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent("0", 1L));
        Assert.assertEquals(1L, this.map.getIfAbsent("1", 2L));
        Assert.assertEquals(2L, this.map.getIfAbsent("2", 3L));
        Assert.assertEquals(4L, this.map.getIfAbsent("3", 4L));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut("0", 100L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_ValueThrowsException()
    {
        this.map.getIfAbsentPut("10", 100L);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        Assert.assertEquals(0L, this.map.getIfAbsentPut("0", factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        LongFunction0 factory = () -> { throw new AssertionError(); };

        this.map.getIfAbsentPut("10", factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith("0", functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        LongFunction<String> functionLength = (String string) -> { throw new AssertionError(); };

        this.map.getIfAbsentPutWith("10", functionLength, "123456789");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        LongFunction<Integer> function = (Integer anObject) -> anObject == null ? 32L : anObject.intValue();

        Assert.assertEquals(0L, this.newWithKeysValues(0, 0L).getIfAbsentPutWithKey(0, function));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        LongFunction<Integer> function = (Integer anObject) -> { throw new AssertionError(); };

        this.<Integer>getEmptyMap().getIfAbsentPutWithKey(10, function);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.<Integer>getEmptyMap().addToValue(10, 2L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> { throw new AssertionError(); };

        MutableObjectLongMap<Integer> map1 = this.getEmptyMap();
        map1.updateValue(0, 0L, incrementFunction);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow("0"));
        Assert.assertEquals(1L, this.map.getOrThrow("1"));
        Assert.assertEquals(2L, this.map.getOrThrow("2"));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0L));
        Assert.assertTrue(this.map.contains(1L));
        Assert.assertTrue(this.map.contains(2L));

        Assert.assertFalse(this.getEmptyMap().contains(0L));
        Assert.assertFalse(this.newWithKeysValues("0", 0L).contains(1L));
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey("0"));
        Assert.assertTrue(this.map.containsKey("1"));
        Assert.assertTrue(this.map.containsKey("2"));
        Assert.assertFalse(this.map.containsKey("3"));
        Assert.assertFalse(this.map.containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertTrue(this.map.containsValue(1L));
        Assert.assertTrue(this.map.containsValue(2L));
        Assert.assertFalse(this.getEmptyMap().contains(2L));
        Assert.assertFalse(this.newWithKeysValues("0", 1L).contains(2L));
    }

    @Override
    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0L));
        Verify.assertSize(1, this.newWithKeysValues(1, 1L));
        Verify.assertSize(1, this.newWithKeysValues(null, 2L));

        Verify.assertSize(2, this.newWithKeysValues(1, 1L, 5, 5L));
        Verify.assertSize(2, this.newWithKeysValues(0, 0L, 5, 5L));
        Verify.assertSize(3, this.newWithKeysValues(1, 1L, 0, 0L, 5, 5L));
        Verify.assertSize(2, this.newWithKeysValues(6, 6L, 5, 5L));
    }

    @Override
    @Test
    public void flipUniqueValues()
    {
        super.flipUniqueValues();

        Verify.assertInstanceOf(UnmodifiableLongObjectMap.class, this.classUnderTest().flipUniqueValues());
    }
}
