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

import org.eclipse.collections.api.block.function.primitive.ShortFunction;
import org.eclipse.collections.api.block.function.primitive.ShortFunction0;
import org.eclipse.collections.api.block.function.primitive.ShortToShortFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.api.map.primitive.MutableByteShortMap;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteShortMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableByteShortMapTest extends AbstractMutableByteShortMapTestCase
{
    private final UnmodifiableByteShortMap map = this.classUnderTest();

    @Override
    protected UnmodifiableByteShortMap classUnderTest()
    {
        return new UnmodifiableByteShortMap(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32));
    }

    @Override
    protected UnmodifiableByteShortMap newWithKeysValues(byte key1, short value1)
    {
        return new UnmodifiableByteShortMap(new ByteShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2)
    {
        return new UnmodifiableByteShortMap(new ByteShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3)
    {
        return new UnmodifiableByteShortMap(new ByteShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4)
    {
        return new UnmodifiableByteShortMap(new ByteShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableByteShortMap getEmptyMap()
    {
        return new UnmodifiableByteShortMap(new ByteShortHashMap());
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
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent((byte) 10, (short) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent((byte) 10, (short) 100));
        this.map.removeKeyIfAbsent((byte) 0, (short) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((byte) 0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((byte) 0, (short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((byte) 0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((byte) 1, (short) 1);
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
        byte collision1 = AbstractMutableByteShortMapTestCase.generateCollisions().getFirst();

        UnmodifiableByteShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent((byte) 0, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((byte) 31, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((byte) 32, (short) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent((byte) 33, (short) 6));
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
        Assert.assertEquals(0L, this.map.getIfAbsentPut((byte) 0, (short) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((byte) 10, (short) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        ShortFunction0 factory = () -> (short) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut((byte) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        ShortFunction0 factory = () -> (short) 100;

        this.map.getIfAbsentPut((byte) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        this.map.getIfAbsentPutWith((byte) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToShortFunction function = (byte byteParameter) -> (short) byteParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((byte) 0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableByteShortMap mutableByteShortMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteShortMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ByteToShortFunction function = (byte byteParameter) -> (short) byteParameter;
        this.map.getIfAbsentPutWithKey((byte) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableByteShortMap copyMap = new UnmodifiableByteShortMap(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        this.map.updateValue((byte) 0, (short) 0, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((short) 0));
        Assert.assertTrue(this.map.contains((short) 31));
        Assert.assertTrue(this.map.contains((short) 32));
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
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 31));
        Assert.assertTrue(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, (short) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, (short) 1, (byte) 5, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, (short) 0, (byte) 5, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, (short) 1, (byte) 0, (short) 0, (byte) 5, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, (short) 6, (byte) 5, (short) 5).size());
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
    public void shortIterator_with_remove()
    {
        MutableShortIterator iterator = this.map.shortIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableShortIterator iterator = this.map.shortIterator();
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

        Verify.assertInstanceOf(UnmodifiableShortByteMap.class, this.classUnderTest().flipUniqueValues());
    }
}
