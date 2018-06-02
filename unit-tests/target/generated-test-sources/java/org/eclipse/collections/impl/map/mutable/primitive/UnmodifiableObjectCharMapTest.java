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
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableObjectCharMap}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapTest.stg.
 */
public class UnmodifiableObjectCharMapTest extends AbstractMutableObjectCharMapTestCase
{
    private final UnmodifiableObjectCharMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableObjectCharMap<String> classUnderTest()
    {
        return new UnmodifiableObjectCharMap<>(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2));
    }

    @Override
    protected <T> UnmodifiableObjectCharMap<T> newWithKeysValues(T key1, char value1)
    {
        return new UnmodifiableObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2)
    {
        return new UnmodifiableObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3)
    {
        return new UnmodifiableObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4)
    {
        return new UnmodifiableObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> UnmodifiableObjectCharMap<T> getEmptyMap()
    {
        return new UnmodifiableObjectCharMap<>(new ObjectCharHashMap<>());
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
        this.map.put("0", (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", (char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue("1", (char) 0);
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
        String collision1 = AbstractMutableObjectCharMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, (char) 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent("0", (char) 1));
        Assert.assertEquals(1L, this.map.getIfAbsent("1", (char) 2));
        Assert.assertEquals(2L, this.map.getIfAbsent("2", (char) 3));
        Assert.assertEquals(4L, this.map.getIfAbsent("3", (char) 4));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut("0", (char) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_ValueThrowsException()
    {
        this.map.getIfAbsentPut("10", (char) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        CharFunction0 factory = () -> (char) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut("0", factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        CharFunction0 factory = () -> { throw new AssertionError(); };

        this.map.getIfAbsentPut("10", factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith("0", functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        CharFunction<String> functionLength = (String string) -> { throw new AssertionError(); };

        this.map.getIfAbsentPutWith("10", functionLength, "123456789");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        CharFunction<Integer> function = (Integer anObject) -> anObject == null ? (char) 32 : (char) anObject.intValue();

        Assert.assertEquals(0L, this.newWithKeysValues(0, (char) 0).getIfAbsentPutWithKey(0, function));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        CharFunction<Integer> function = (Integer anObject) -> { throw new AssertionError(); };

        this.<Integer>getEmptyMap().getIfAbsentPutWithKey(10, function);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.<Integer>getEmptyMap().addToValue(10, (char) 2);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        CharToCharFunction incrementFunction = (char value) -> { throw new AssertionError(); };

        MutableObjectCharMap<Integer> map1 = this.getEmptyMap();
        map1.updateValue(0, (char) 0, incrementFunction);
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
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertTrue(this.map.contains((char) 1));
        Assert.assertTrue(this.map.contains((char) 2));

        Assert.assertFalse(this.getEmptyMap().contains((char) 0));
        Assert.assertFalse(this.newWithKeysValues("0", (char) 0).contains((char) 1));
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
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertTrue(this.map.containsValue((char) 1));
        Assert.assertTrue(this.map.containsValue((char) 2));
        Assert.assertFalse(this.getEmptyMap().contains((char) 2));
        Assert.assertFalse(this.newWithKeysValues("0", (char) 1).contains((char) 2));
    }

    @Override
    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, (char) 0));
        Verify.assertSize(1, this.newWithKeysValues(1, (char) 1));
        Verify.assertSize(1, this.newWithKeysValues(null, (char) 2));

        Verify.assertSize(2, this.newWithKeysValues(1, (char) 1, 5, (char) 5));
        Verify.assertSize(2, this.newWithKeysValues(0, (char) 0, 5, (char) 5));
        Verify.assertSize(3, this.newWithKeysValues(1, (char) 1, 0, (char) 0, 5, (char) 5));
        Verify.assertSize(2, this.newWithKeysValues(6, (char) 6, 5, (char) 5));
    }

    @Override
    @Test
    public void flipUniqueValues()
    {
        super.flipUniqueValues();

        Verify.assertInstanceOf(UnmodifiableCharObjectMap.class, this.classUnderTest().flipUniqueValues());
    }
}
