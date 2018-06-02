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
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.api.map.primitive.MutableLongLongMap;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongLongMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableLongLongMapTest extends AbstractMutableLongLongMapTestCase
{
    private final UnmodifiableLongLongMap map = this.classUnderTest();

    @Override
    protected UnmodifiableLongLongMap classUnderTest()
    {
        return new UnmodifiableLongLongMap(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L));
    }

    @Override
    protected UnmodifiableLongLongMap newWithKeysValues(long key1, long value1)
    {
        return new UnmodifiableLongLongMap(new LongLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2)
    {
        return new UnmodifiableLongLongMap(new LongLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3)
    {
        return new UnmodifiableLongLongMap(new LongLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableLongLongMap newWithKeysValues(long key1, long value1, long key2, long value2, long key3, long value3, long key4, long value4)
    {
        return new UnmodifiableLongLongMap(new LongLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableLongLongMap getEmptyMap()
    {
        return new UnmodifiableLongLongMap(new LongLongHashMap());
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
        this.map.removeKey(5L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove(5L);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent(10L, 100L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent(10L, 100L));
        this.map.removeKeyIfAbsent(0L, 100L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0L, 1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1L, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey(32L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(LongArrayList.newListWith(0L, 32L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        long collision1 = AbstractMutableLongLongMapTestCase.generateCollisions().getFirst();

        UnmodifiableLongLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0L));
        Assert.assertEquals(31L, this.map.get(31L));
        Assert.assertEquals(32L, this.map.get(32L));
        Assert.assertEquals(0L, this.map.get(1L));
        Assert.assertEquals(0L, this.map.get(33L));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, 5L));
        Assert.assertEquals(6L, this.map.getIfAbsent(33L, 6L));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0L));
        Assert.assertEquals(31L, this.map.getOrThrow(31L));
        Assert.assertEquals(32L, this.map.getOrThrow(32L));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1L));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33L));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0L, 50L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10L, 100L);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0L, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        LongFunction0 factory = () -> 100L;

        this.map.getIfAbsentPut(10L, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0L, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        this.map.getIfAbsentPutWith(10L, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToLongFunction function = (long longParameter) -> longParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0L, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableLongLongMap mutableLongLongMap = this.classUnderTest();
        LongSet frozenSet = mutableLongLongMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        LongToLongFunction function = (long longParameter) -> longParameter;
        this.map.getIfAbsentPutWithKey(10L, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableLongLongMap copyMap = new UnmodifiableLongLongMap(LongLongHashMap.newWithKeysValues(0L, 0L, 31L, 31L, 32L, 32L));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        this.map.updateValue(0L, 0L, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey(0L));
        Assert.assertTrue(this.map.containsKey(31L));
        Assert.assertTrue(this.map.containsKey(32L));
        Assert.assertFalse(this.map.containsKey(1L));
        Assert.assertFalse(this.map.containsKey(5L));
        Assert.assertFalse(this.map.containsKey(35L));
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
        Assert.assertEquals(1, this.newWithKeysValues(0L, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, 1L).size());

        Assert.assertEquals(2, this.newWithKeysValues(1L, 1L, 5L, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, 0L, 5L, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, 1L, 0L, 0L, 5L, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, 6L, 5L, 5L).size());
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

        Verify.assertInstanceOf(UnmodifiableLongLongMap.class, this.classUnderTest().flipUniqueValues());
    }
}
