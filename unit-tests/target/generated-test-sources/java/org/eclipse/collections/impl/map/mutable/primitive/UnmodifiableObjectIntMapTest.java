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

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectIntMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableObjectIntMap}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapTest.stg.
 */
public class UnmodifiableObjectIntMapTest extends AbstractMutableObjectIntMapTestCase
{
    private final UnmodifiableObjectIntMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableObjectIntMap<String> classUnderTest()
    {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues("0", 0, "1", 1, "2", 2));
    }

    @Override
    protected <T> UnmodifiableObjectIntMap<T> newWithKeysValues(T key1, int value1)
    {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2)
    {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3)
    {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3, T key4, int value4)
    {
        return new UnmodifiableObjectIntMap<>(ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> UnmodifiableObjectIntMap<T> getEmptyMap()
    {
        return new UnmodifiableObjectIntMap<>(new ObjectIntHashMap<>());
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
        this.map.put("0", 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue("1", 0);
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
        String collision1 = AbstractMutableObjectIntMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent("0", 1));
        Assert.assertEquals(1L, this.map.getIfAbsent("1", 2));
        Assert.assertEquals(2L, this.map.getIfAbsent("2", 3));
        Assert.assertEquals(4L, this.map.getIfAbsent("3", 4));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut("0", 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_ValueThrowsException()
    {
        this.map.getIfAbsentPut("10", 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut("0", factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        IntFunction0 factory = () -> { throw new AssertionError(); };

        this.map.getIfAbsentPut("10", factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith("0", functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        IntFunction<String> functionLength = (String string) -> { throw new AssertionError(); };

        this.map.getIfAbsentPutWith("10", functionLength, "123456789");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        IntFunction<Integer> function = (Integer anObject) -> anObject == null ? 32 : anObject.intValue();

        Assert.assertEquals(0L, this.newWithKeysValues(0, 0).getIfAbsentPutWithKey(0, function));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        IntFunction<Integer> function = (Integer anObject) -> { throw new AssertionError(); };

        this.<Integer>getEmptyMap().getIfAbsentPutWithKey(10, function);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.<Integer>getEmptyMap().addToValue(10, 2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> { throw new AssertionError(); };

        MutableObjectIntMap<Integer> map1 = this.getEmptyMap();
        map1.updateValue(0, 0, incrementFunction);
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
        Assert.assertTrue(this.map.contains(0));
        Assert.assertTrue(this.map.contains(1));
        Assert.assertTrue(this.map.contains(2));

        Assert.assertFalse(this.getEmptyMap().contains(0));
        Assert.assertFalse(this.newWithKeysValues("0", 0).contains(1));
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
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(1));
        Assert.assertTrue(this.map.containsValue(2));
        Assert.assertFalse(this.getEmptyMap().contains(2));
        Assert.assertFalse(this.newWithKeysValues("0", 1).contains(2));
    }

    @Override
    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0));
        Verify.assertSize(1, this.newWithKeysValues(1, 1));
        Verify.assertSize(1, this.newWithKeysValues(null, 2));

        Verify.assertSize(2, this.newWithKeysValues(1, 1, 5, 5));
        Verify.assertSize(2, this.newWithKeysValues(0, 0, 5, 5));
        Verify.assertSize(3, this.newWithKeysValues(1, 1, 0, 0, 5, 5));
        Verify.assertSize(2, this.newWithKeysValues(6, 6, 5, 5));
    }

    @Override
    @Test
    public void flipUniqueValues()
    {
        super.flipUniqueValues();

        Verify.assertInstanceOf(UnmodifiableIntObjectMap.class, this.classUnderTest().flipUniqueValues());
    }
}
