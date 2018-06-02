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
import org.eclipse.collections.api.block.function.primitive.ByteToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.api.map.primitive.MutableByteDoubleMap;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteDoubleMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableByteDoubleMapTest extends AbstractMutableByteDoubleMapTestCase
{
    private final UnmodifiableByteDoubleMap map = this.classUnderTest();

    @Override
    protected UnmodifiableByteDoubleMap classUnderTest()
    {
        return new UnmodifiableByteDoubleMap(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0));
    }

    @Override
    protected UnmodifiableByteDoubleMap newWithKeysValues(byte key1, double value1)
    {
        return new UnmodifiableByteDoubleMap(new ByteDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2)
    {
        return new UnmodifiableByteDoubleMap(new ByteDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3)
    {
        return new UnmodifiableByteDoubleMap(new ByteDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableByteDoubleMap newWithKeysValues(byte key1, double value1, byte key2, double value2, byte key3, double value3, byte key4, double value4)
    {
        return new UnmodifiableByteDoubleMap(new ByteDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableByteDoubleMap getEmptyMap()
    {
        return new UnmodifiableByteDoubleMap(new ByteDoubleHashMap());
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
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent((byte) 10, 100.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent((byte) 10, 100.0), 0.0);
        this.map.removeKeyIfAbsent((byte) 0, 100.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((byte) 0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((byte) 0, 1.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((byte) 0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((byte) 1, 1.0);
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
        byte collision1 = AbstractMutableByteDoubleMapTestCase.generateCollisions().getFirst();

        UnmodifiableByteDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get((byte) 0), 0.0);
        Assert.assertEquals(31.0, this.map.get((byte) 31), 0.0);
        Assert.assertEquals(32.0, this.map.get((byte) 32), 0.0);
        Assert.assertEquals(0.0, this.map.get((byte) 1), 0.0);
        Assert.assertEquals(0.0, this.map.get((byte) 33), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent((byte) 0, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((byte) 31, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((byte) 32, 5.0), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent((byte) 33, 6.0), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow((byte) 0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow((byte) 31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow((byte) 32), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut((byte) 0, 50.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((byte) 10, 100.0);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut((byte) 0, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        DoubleFunction0 factory = () -> 100.0;

        this.map.getIfAbsentPut((byte) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith((byte) 0, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        this.map.getIfAbsentPutWith((byte) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToDoubleFunction function = (byte byteParameter) -> (double) byteParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey((byte) 0, function), 0.0);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableByteDoubleMap mutableByteDoubleMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteDoubleMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ByteToDoubleFunction function = (byte byteParameter) -> (double) byteParameter;
        this.map.getIfAbsentPutWithKey((byte) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableByteDoubleMap copyMap = new UnmodifiableByteDoubleMap(ByteDoubleHashMap.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        this.map.updateValue((byte) 0, 0.0, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertTrue(this.map.contains(31.0));
        Assert.assertTrue(this.map.contains(32.0));
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
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertTrue(this.map.containsValue(31.0));
        Assert.assertTrue(this.map.containsValue(32.0));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, 1.0).size());

        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, 1.0, (byte) 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, 0.0, (byte) 5, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, 1.0, (byte) 0, 0.0, (byte) 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, 6.0, (byte) 5, 5.0).size());
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
    public void doubleIterator_with_remove()
    {
        MutableDoubleIterator iterator = this.map.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableDoubleIterator iterator = this.map.doubleIterator();
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

        Verify.assertInstanceOf(UnmodifiableDoubleByteMap.class, this.classUnderTest().flipUniqueValues());
    }
}
