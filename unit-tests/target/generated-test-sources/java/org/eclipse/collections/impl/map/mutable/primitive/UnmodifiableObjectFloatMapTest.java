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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.map.primitive.MutableObjectFloatMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableObjectFloatMap}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapTest.stg.
 */
public class UnmodifiableObjectFloatMapTest extends AbstractMutableObjectFloatMapTestCase
{
    private final UnmodifiableObjectFloatMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableObjectFloatMap<String> classUnderTest()
    {
        return new UnmodifiableObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues("0", 0.0f, "1", 1.0f, "2", 2.0f));
    }

    @Override
    protected <T> UnmodifiableObjectFloatMap<T> newWithKeysValues(T key1, float value1)
    {
        return new UnmodifiableObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2)
    {
        return new UnmodifiableObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3)
    {
        return new UnmodifiableObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3, T key4, float value4)
    {
        return new UnmodifiableObjectFloatMap<>(ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> UnmodifiableObjectFloatMap<T> getEmptyMap()
    {
        return new UnmodifiableObjectFloatMap<>(new ObjectFloatHashMap<>());
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
        this.map.put("0", 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair("0", 1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue("1", 0.0f);
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
        String collision1 = AbstractMutableObjectFloatMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, 1.0f);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get("0"), 0.0f);
        Assert.assertEquals(1.0, this.map.get("1"), 0.0f);
        Assert.assertEquals(2.0, this.map.get("2"), 0.0f);

        Assert.assertEquals(0.0, this.map.get("5"), 0.0f);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent("0", 1.0f), 0.0f);
        Assert.assertEquals(1.0, this.map.getIfAbsent("1", 2.0f), 0.0f);
        Assert.assertEquals(2.0, this.map.getIfAbsent("2", 3.0f), 0.0f);
        Assert.assertEquals(4.0, this.map.getIfAbsent("3", 4.0f), 0.0f);
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut("0", 100.0f), 0.0f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_ValueThrowsException()
    {
        this.map.getIfAbsentPut("10", 100.0f);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        FloatFunction0 factory = () -> 100.0f;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut("0", factory), 0.0f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        FloatFunction0 factory = () -> { throw new AssertionError(); };

        this.map.getIfAbsentPut("10", factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        FloatFunction<String> functionLength = (String string) -> string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith("0", functionLength, "123456789"), 0.0f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        FloatFunction<String> functionLength = (String string) -> { throw new AssertionError(); };

        this.map.getIfAbsentPutWith("10", functionLength, "123456789");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatFunction<Integer> function = (Integer anObject) -> anObject == null ? 32.0f : anObject.intValue();

        Assert.assertEquals(0.0, this.newWithKeysValues(0, 0.0f).getIfAbsentPutWithKey(0, function), 0.0f);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        FloatFunction<Integer> function = (Integer anObject) -> { throw new AssertionError(); };

        this.<Integer>getEmptyMap().getIfAbsentPutWithKey(10, function);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.<Integer>getEmptyMap().addToValue(10, 2.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        FloatToFloatFunction incrementFunction = (float value) -> { throw new AssertionError(); };

        MutableObjectFloatMap<Integer> map1 = this.getEmptyMap();
        map1.updateValue(0, 0.0f, incrementFunction);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow("0"), 0.0f);
        Assert.assertEquals(1.0, this.map.getOrThrow("1"), 0.0f);
        Assert.assertEquals(2.0, this.map.getOrThrow("2"), 0.0f);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(null));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(1.0f));
        Assert.assertTrue(this.map.contains(2.0f));

        Assert.assertFalse(this.getEmptyMap().contains(0.0f));
        Assert.assertFalse(this.newWithKeysValues("0", 0.0f).contains(1.0f));
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
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(1.0f));
        Assert.assertTrue(this.map.containsValue(2.0f));
        Assert.assertFalse(this.getEmptyMap().contains(2.0f));
        Assert.assertFalse(this.newWithKeysValues("0", 1.0f).contains(2.0f));
    }

    @Override
    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues(0, 0.0f));
        Verify.assertSize(1, this.newWithKeysValues(1, 1.0f));
        Verify.assertSize(1, this.newWithKeysValues(null, 2.0f));

        Verify.assertSize(2, this.newWithKeysValues(1, 1.0f, 5, 5.0f));
        Verify.assertSize(2, this.newWithKeysValues(0, 0.0f, 5, 5.0f));
        Verify.assertSize(3, this.newWithKeysValues(1, 1.0f, 0, 0.0f, 5, 5.0f));
        Verify.assertSize(2, this.newWithKeysValues(6, 6.0f, 5, 5.0f));
    }

    @Override
    @Test
    public void flipUniqueValues()
    {
        super.flipUniqueValues();

        Verify.assertInstanceOf(UnmodifiableFloatObjectMap.class, this.classUnderTest().flipUniqueValues());
    }
}
