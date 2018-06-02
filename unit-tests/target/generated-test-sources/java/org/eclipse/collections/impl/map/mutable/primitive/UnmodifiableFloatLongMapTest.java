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
import org.eclipse.collections.api.block.function.primitive.FloatToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.api.map.primitive.MutableFloatLongMap;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableFloatLongMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableFloatLongMapTest extends AbstractMutableFloatLongMapTestCase
{
    private final UnmodifiableFloatLongMap map = this.classUnderTest();

    @Override
    protected UnmodifiableFloatLongMap classUnderTest()
    {
        return new UnmodifiableFloatLongMap(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L));
    }

    @Override
    protected UnmodifiableFloatLongMap newWithKeysValues(float key1, long value1)
    {
        return new UnmodifiableFloatLongMap(new FloatLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2)
    {
        return new UnmodifiableFloatLongMap(new FloatLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3)
    {
        return new UnmodifiableFloatLongMap(new FloatLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableFloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3, float key4, long value4)
    {
        return new UnmodifiableFloatLongMap(new FloatLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableFloatLongMap getEmptyMap()
    {
        return new UnmodifiableFloatLongMap(new FloatLongHashMap());
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
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent(10.0f, 100L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent(10.0f, 100L));
        this.map.removeKeyIfAbsent(0.0f, 100L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0.0f, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0.0f, 1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0.0f, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1.0f, 1L);
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
        float collision1 = AbstractMutableFloatLongMapTestCase.generateCollisions().getFirst();

        UnmodifiableFloatLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0f, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0f, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0f, 5L));
        Assert.assertEquals(6L, this.map.getIfAbsent(33.0f, 6L));
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
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0f, 50L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10.0f, 100L);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0f, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        LongFunction0 factory = () -> 100L;

        this.map.getIfAbsentPut(10.0f, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0.0f, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        this.map.getIfAbsentPutWith(10.0f, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToLongFunction function = (float floatParameter) -> (long) floatParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0.0f, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableFloatLongMap mutableFloatLongMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatLongMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        FloatToLongFunction function = (float floatParameter) -> (long) floatParameter;
        this.map.getIfAbsentPutWithKey(10.0f, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableFloatLongMap copyMap = new UnmodifiableFloatLongMap(FloatLongHashMap.newWithKeysValues(0.0f, 0L, 31.0f, 31L, 32.0f, 32L));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        this.map.updateValue(0.0f, 0L, incrementFunction);
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
        Assert.assertTrue(this.map.containsValue(0L));
        Assert.assertTrue(this.map.containsValue(31L));
        Assert.assertTrue(this.map.containsValue(32L));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, 1L).size());

        Assert.assertEquals(2, this.newWithKeysValues(1.0f, 1L, 5.0f, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, 0L, 5.0f, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, 1L, 0.0f, 0L, 5.0f, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, 6L, 5.0f, 5L).size());
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

        Verify.assertInstanceOf(UnmodifiableLongFloatMap.class, this.classUnderTest().flipUniqueValues());
    }
}
