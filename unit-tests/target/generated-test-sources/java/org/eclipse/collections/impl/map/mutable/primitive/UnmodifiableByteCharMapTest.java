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
import org.eclipse.collections.api.block.function.primitive.ByteToCharFunction;
import org.eclipse.collections.api.iterator.MutableCharIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.api.map.primitive.MutableByteCharMap;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteCharMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableByteCharMapTest extends AbstractMutableByteCharMapTestCase
{
    private final UnmodifiableByteCharMap map = this.classUnderTest();

    @Override
    protected UnmodifiableByteCharMap classUnderTest()
    {
        return new UnmodifiableByteCharMap(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32));
    }

    @Override
    protected UnmodifiableByteCharMap newWithKeysValues(byte key1, char value1)
    {
        return new UnmodifiableByteCharMap(new ByteCharHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2)
    {
        return new UnmodifiableByteCharMap(new ByteCharHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3)
    {
        return new UnmodifiableByteCharMap(new ByteCharHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableByteCharMap newWithKeysValues(byte key1, char value1, byte key2, char value2, byte key3, char value3, byte key4, char value4)
    {
        return new UnmodifiableByteCharMap(new ByteCharHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableByteCharMap getEmptyMap()
    {
        return new UnmodifiableByteCharMap(new ByteCharHashMap());
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
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent((byte) 10, (char) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((char) 100, this.map.removeKeyIfAbsent((byte) 10, (char) 100));
        this.map.removeKeyIfAbsent((byte) 0, (char) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((byte) 0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((byte) 0, (char) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((byte) 0, (char) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((byte) 1, (char) 1);
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
        byte collision1 = AbstractMutableByteCharMapTestCase.generateCollisions().getFirst();

        UnmodifiableByteCharMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (char) 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent((byte) 0, (char) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((byte) 31, (char) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((byte) 32, (char) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent((byte) 33, (char) 6));
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
        Assert.assertEquals(0L, this.map.getIfAbsentPut((byte) 0, (char) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((byte) 10, (char) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        CharFunction0 factory = () -> (char) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut((byte) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        CharFunction0 factory = () -> (char) 100;

        this.map.getIfAbsentPut((byte) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((byte) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        CharFunction<String> functionLength = (String string) -> (char) string.length();

        this.map.getIfAbsentPutWith((byte) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToCharFunction function = (byte byteParameter) -> (char) byteParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((byte) 0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableByteCharMap mutableByteCharMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteCharMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteCharMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ByteToCharFunction function = (byte byteParameter) -> (char) byteParameter;
        this.map.getIfAbsentPutWithKey((byte) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableByteCharMap copyMap = new UnmodifiableByteCharMap(ByteCharHashMap.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        CharToCharFunction incrementFunction = (char value) -> (char) (value + (char) 1);
        this.map.updateValue((byte) 0, (char) 0, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertTrue(this.map.contains((char) 31));
        Assert.assertTrue(this.map.contains((char) 32));
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
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertTrue(this.map.containsValue((char) 31));
        Assert.assertTrue(this.map.containsValue((char) 32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, (char) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, (char) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, (char) 1, (byte) 5, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, (char) 0, (byte) 5, (char) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, (char) 1, (byte) 0, (char) 0, (byte) 5, (char) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, (char) 6, (byte) 5, (char) 5).size());
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
    public void charIterator_with_remove()
    {
        MutableCharIterator iterator = this.map.charIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableCharIterator iterator = this.map.charIterator();
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

        Verify.assertInstanceOf(UnmodifiableCharByteMap.class, this.classUnderTest().flipUniqueValues());
    }
}
