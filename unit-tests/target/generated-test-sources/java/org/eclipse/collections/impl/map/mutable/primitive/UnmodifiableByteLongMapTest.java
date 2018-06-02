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
import org.eclipse.collections.api.block.function.primitive.ByteToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.api.map.primitive.MutableByteLongMap;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteLongMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableByteLongMapTest extends AbstractMutableByteLongMapTestCase
{
    private final UnmodifiableByteLongMap map = this.classUnderTest();

    @Override
    protected UnmodifiableByteLongMap classUnderTest()
    {
        return new UnmodifiableByteLongMap(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L));
    }

    @Override
    protected UnmodifiableByteLongMap newWithKeysValues(byte key1, long value1)
    {
        return new UnmodifiableByteLongMap(new ByteLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2)
    {
        return new UnmodifiableByteLongMap(new ByteLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3)
    {
        return new UnmodifiableByteLongMap(new ByteLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3, byte key4, long value4)
    {
        return new UnmodifiableByteLongMap(new ByteLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableByteLongMap getEmptyMap()
    {
        return new UnmodifiableByteLongMap(new ByteLongHashMap());
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
        this.map.removeKey((byte) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove((byte) 5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent((byte) 10, 100L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent((byte) 10, 100L));
        this.map.removeKeyIfAbsent((byte) 0, 100L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((byte) 0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((byte) 0, 1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((byte) 0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((byte) 1, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey((byte) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        byte collision1 = AbstractMutableByteLongMapTestCase.generateCollisions().getFirst();

        UnmodifiableByteLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((byte) 0));
        Assert.assertEquals(31L, this.map.get((byte) 31));
        Assert.assertEquals(32L, this.map.get((byte) 32));
        Assert.assertEquals(0L, this.map.get((byte) 1));
        Assert.assertEquals(0L, this.map.get((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent((byte) 0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent((byte) 31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent((byte) 32, 5L));
        Assert.assertEquals(6L, this.map.getIfAbsent((byte) 33, 6L));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow((byte) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((byte) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((byte) 32));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut((byte) 0, 50L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((byte) 10, 100L);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        Assert.assertEquals(0L, this.map.getIfAbsentPut((byte) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        LongFunction0 factory = () -> 100L;

        this.map.getIfAbsentPut((byte) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        this.map.getIfAbsentPutWith((byte) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToLongFunction function = (byte byteParameter) -> (long) byteParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((byte) 0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableByteLongMap mutableByteLongMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteLongMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ByteToLongFunction function = (byte byteParameter) -> (long) byteParameter;
        this.map.getIfAbsentPutWithKey((byte) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableByteLongMap copyMap = new UnmodifiableByteLongMap(ByteLongHashMap.newWithKeysValues((byte) 0, 0L, (byte) 31, 31L, (byte) 32, 32L));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        this.map.updateValue((byte) 0, 0L, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0L));
        Assert.assertTrue(this.map.contains(31L));
        Assert.assertTrue(this.map.contains(32L));
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey((byte) 0));
        Assert.assertTrue(this.map.containsKey((byte) 31));
        Assert.assertTrue(this.map.containsKey((byte) 32));
        Assert.assertFalse(this.map.containsKey((byte) 1));
        Assert.assertFalse(this.map.containsKey((byte) 5));
        Assert.assertFalse(this.map.containsKey((byte) 35));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertTrue(this.map.containsValue(31L));
        Assert.assertTrue(this.map.containsValue(32L));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, 1L).size());

        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, 1L, (byte) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, 0L, (byte) 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, 1L, (byte) 0, 0L, (byte) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, 6L, (byte) 5, 5L).size());
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
    public void longIterator_with_remove()
    {
        MutableLongIterator iterator = this.map.longIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableLongIterator iterator = this.map.longIterator();
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

        Verify.assertInstanceOf(UnmodifiableLongByteMap.class, this.classUnderTest().flipUniqueValues());
    }
}
