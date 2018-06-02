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

import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.block.function.primitive.IntFunction0;
import org.eclipse.collections.api.block.function.primitive.IntToIntFunction;
import org.eclipse.collections.api.block.function.primitive.LongToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.api.map.primitive.MutableLongIntMap;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongIntMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableLongIntMapTest extends AbstractMutableLongIntMapTestCase
{
    private final UnmodifiableLongIntMap map = this.classUnderTest();

    @Override
    protected UnmodifiableLongIntMap classUnderTest()
    {
        return new UnmodifiableLongIntMap(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32));
    }

    @Override
    protected UnmodifiableLongIntMap newWithKeysValues(long key1, int value1)
    {
        return new UnmodifiableLongIntMap(new LongIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2)
    {
        return new UnmodifiableLongIntMap(new LongIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3)
    {
        return new UnmodifiableLongIntMap(new LongIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableLongIntMap newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3, long key4, int value4)
    {
        return new UnmodifiableLongIntMap(new LongIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableLongIntMap getEmptyMap()
    {
        return new UnmodifiableLongIntMap(new LongIntHashMap());
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
        Assert.assertEquals(100, this.map.removeKeyIfAbsent(10L, 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100, this.map.removeKeyIfAbsent(10L, 100));
        this.map.removeKeyIfAbsent(0L, 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0L, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0L, 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0L, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1L, 1);
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
        long collision1 = AbstractMutableLongIntMapTestCase.generateCollisions().getFirst();

        UnmodifiableLongIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33L, 6));
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
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0L, 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10L, 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0L, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        IntFunction0 factory = () -> 100;

        this.map.getIfAbsentPut(10L, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0L, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        IntFunction<String> functionLength = (String string) -> string.length();

        this.map.getIfAbsentPutWith(10L, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToIntFunction function = (long longParameter) -> (int) longParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0L, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableLongIntMap mutableLongIntMap = this.classUnderTest();
        LongSet frozenSet = mutableLongIntMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        LongToIntFunction function = (long longParameter) -> (int) longParameter;
        this.map.getIfAbsentPutWithKey(10L, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableLongIntMap copyMap = new UnmodifiableLongIntMap(LongIntHashMap.newWithKeysValues(0L, 0, 31L, 31, 32L, 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        this.map.updateValue(0L, 0, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0));
        Assert.assertTrue(this.map.contains(31));
        Assert.assertTrue(this.map.contains(32));
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
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(31));
        Assert.assertTrue(this.map.containsValue(32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0L, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1L, 1, 5L, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, 0, 5L, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, 1, 0L, 0, 5L, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, 6, 5L, 5).size());
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
    public void intIterator_with_remove()
    {
        MutableIntIterator iterator = this.map.intIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableIntIterator iterator = this.map.intIterator();
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

        Verify.assertInstanceOf(UnmodifiableIntLongMap.class, this.classUnderTest().flipUniqueValues());
    }
}
