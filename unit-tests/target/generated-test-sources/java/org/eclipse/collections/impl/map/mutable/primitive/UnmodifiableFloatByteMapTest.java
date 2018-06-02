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
import org.eclipse.collections.api.block.function.primitive.FloatToByteFunction;
import org.eclipse.collections.api.iterator.MutableByteIterator;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.api.map.primitive.MutableFloatByteMap;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableFloatByteMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableFloatByteMapTest extends AbstractMutableFloatByteMapTestCase
{
    private final UnmodifiableFloatByteMap map = this.classUnderTest();

    @Override
    protected UnmodifiableFloatByteMap classUnderTest()
    {
        return new UnmodifiableFloatByteMap(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32));
    }

    @Override
    protected UnmodifiableFloatByteMap newWithKeysValues(float key1, byte value1)
    {
        return new UnmodifiableFloatByteMap(new FloatByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2)
    {
        return new UnmodifiableFloatByteMap(new FloatByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3)
    {
        return new UnmodifiableFloatByteMap(new FloatByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableFloatByteMap newWithKeysValues(float key1, byte value1, float key2, byte value2, float key3, byte value3, float key4, byte value4)
    {
        return new UnmodifiableFloatByteMap(new FloatByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableFloatByteMap getEmptyMap()
    {
        return new UnmodifiableFloatByteMap(new FloatByteHashMap());
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
        this.map.removeKey(5.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove(5.0f);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent(10.0f, (byte) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((byte) 100, this.map.removeKeyIfAbsent(10.0f, (byte) 100));
        this.map.removeKeyIfAbsent(0.0f, (byte) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0.0f, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0.0f, (byte) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0.0f, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1.0f, (byte) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey(32.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatByteMapTestCase.generateCollisions().getFirst();

        UnmodifiableFloatByteMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (byte) 1);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0.0f));
        Assert.assertEquals(31L, this.map.get(31.0f));
        Assert.assertEquals(32L, this.map.get(32.0f));
        Assert.assertEquals(0L, this.map.get(1.0f));
        Assert.assertEquals(0L, this.map.get(33.0f));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, (byte) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0f, (byte) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0f, (byte) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33.0f, (byte) 6));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0f));
        Assert.assertEquals(31L, this.map.getOrThrow(31.0f));
        Assert.assertEquals(32L, this.map.getOrThrow(32.0f));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0f));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0f));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0f, (byte) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10.0f, (byte) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        ByteFunction0 factory = () -> (byte) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0f, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        ByteFunction0 factory = () -> (byte) 100;

        this.map.getIfAbsentPut(10.0f, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        ByteFunction<String> functionLength = (String string) -> (byte) string.length();

        this.map.getIfAbsentPutWith(10.0f, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToByteFunction function = (float floatParameter) -> (byte) floatParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0.0f, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableFloatByteMap mutableFloatByteMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatByteMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatByteMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        FloatToByteFunction function = (float floatParameter) -> (byte) floatParameter;
        this.map.getIfAbsentPutWithKey(10.0f, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableFloatByteMap copyMap = new UnmodifiableFloatByteMap(FloatByteHashMap.newWithKeysValues(0.0f, (byte) 0, 31.0f, (byte) 31, 32.0f, (byte) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        ByteToByteFunction incrementFunction = (byte value) -> (byte) (value + (byte) 1);
        this.map.updateValue(0.0f, (byte) 0, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey(0.0f));
        Assert.assertTrue(this.map.containsKey(31.0f));
        Assert.assertTrue(this.map.containsKey(32.0f));
        Assert.assertFalse(this.map.containsKey(1.0f));
        Assert.assertFalse(this.map.containsKey(5.0f));
        Assert.assertFalse(this.map.containsKey(35.0f));
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
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, (byte) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, (byte) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1.0f, (byte) 1, 5.0f, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, (byte) 0, 5.0f, (byte) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, (byte) 1, 0.0f, (byte) 0, 5.0f, (byte) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, (byte) 6, 5.0f, (byte) 5).size());
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

        Verify.assertInstanceOf(UnmodifiableByteFloatMap.class, this.classUnderTest().flipUniqueValues());
    }
}
