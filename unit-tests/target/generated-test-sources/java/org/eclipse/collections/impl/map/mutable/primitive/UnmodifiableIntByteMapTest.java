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

import org.eclipse.collections.api.block.function.primitive.ByteFunction;
import org.eclipse.collections.api.block.function.primitive.ByteFunction0;
import org.eclipse.collections.api.block.function.primitive.ByteToByteFunction;
import org.eclipse.collections.api.block.function.primitive.IntToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.api.map.primitive.MutableIntByteMap;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntByteMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableIntByteMapTest extends AbstractMutableIntByteMapTestCase
{
    private final UnmodifiableIntByteMap map = this.classUnderTest();

    @Override
    protected UnmodifiableIntByteMap classUnderTest()
    {
        return new UnmodifiableIntByteMap(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32));
    }

    @Override
    protected UnmodifiableIntByteMap newWithKeysValues(int key1, byte value1)
    {
        return new UnmodifiableIntByteMap(new IntByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2)
    {
        return new UnmodifiableIntByteMap(new IntByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3)
    {
        return new UnmodifiableIntByteMap(new IntByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3, int key4, byte value4)
    {
        return new UnmodifiableIntByteMap(new IntByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableIntByteMap getEmptyMap()
    {
        return new UnmodifiableIntByteMap(new IntByteHashMap());
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
        this.map.removeKey(5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove(5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent(10, (byte) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent(10, (byte) 100));
        this.map.removeKeyIfAbsent(0, (byte) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0, (byte) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey(32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(IntArrayList.newListWith(0, 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        int collision1 = AbstractMutableIntByteMapTestCase.generateCollisions().getFirst();

        UnmodifiableIntByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0));
        Assert.assertEquals(31L, this.map.get(31));
        Assert.assertEquals(32L, this.map.get(32));
        Assert.assertEquals(0L, this.map.get(1));
        Assert.assertEquals(0L, this.map.get(33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0, (byte) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31, (byte) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32, (byte) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33, (byte) 6));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0));
        Assert.assertEquals(31L, this.map.getOrThrow(31));
        Assert.assertEquals(32L, this.map.getOrThrow(32));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0, (byte) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10, (byte) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        ByteFunction0 factory = () -> (byte) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        ByteFunction0 factory = () -> (byte) 100;

        this.map.getIfAbsentPut(10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();

        this.map.getIfAbsentPutWith(10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        IntToByteFunction function = (int intParameter) -> (byte) intParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableIntByteMap mutableIntByteMap = this.classUnderTest();
        IntSet frozenSet = mutableIntByteMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        IntToByteFunction function = (int intParameter) -> (byte) intParameter;
        this.map.getIfAbsentPutWithKey(10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableIntByteMap copyMap = new UnmodifiableIntByteMap(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        this.map.updateValue(0, (byte) 0, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((byte) 0));
        Assert.assertTrue(this.map.contains((byte) 31));
        Assert.assertTrue(this.map.contains((byte) 32));
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertTrue(this.map.containsKey(31));
        Assert.assertTrue(this.map.containsKey(32));
        Assert.assertFalse(this.map.containsKey(1));
        Assert.assertFalse(this.map.containsKey(5));
        Assert.assertFalse(this.map.containsKey(35));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue((byte) 0));
        Assert.assertTrue(this.map.containsValue((byte) 31));
        Assert.assertTrue(this.map.containsValue((byte) 32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0, (byte) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1, (byte) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1, (byte) 1, 5, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0, (byte) 0, 5, (byte) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1, (byte) 1, 0, (byte) 0, 5, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6, (byte) 6, 5, (byte) 5).size());
        Verify.assertSize(3, this.map);
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        Assert.assertSame(this.map, this.map.asUnmodifiable());
    }

    @Override
    @Test
    public void byteIterator_with_remove()
    {
        MutableByteIterator iterator = this.map.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableByteIterator iterator = this.map.byteIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        // Not applicable for Unmodifiable*
    }

    @Override
    @Test
    public void flipUniqueValues()
    {
        super.flipUniqueValues();

        Verify.assertInstanceOf(UnmodifiableByteIntMap.class, this.classUnderTest().flipUniqueValues());
    }
}
