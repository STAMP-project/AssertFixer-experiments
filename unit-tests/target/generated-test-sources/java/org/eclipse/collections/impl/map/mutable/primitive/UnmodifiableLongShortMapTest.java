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
import org.eclipse.collections.api.block.function.primitive.LongToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.api.map.primitive.MutableLongShortMap;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongShortMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableLongShortMapTest extends AbstractMutableLongShortMapTestCase
{
    private final UnmodifiableLongShortMap map = this.classUnderTest();

    @Override
    protected UnmodifiableLongShortMap classUnderTest()
    {
        return new UnmodifiableLongShortMap(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32));
    }

    @Override
    protected UnmodifiableLongShortMap newWithKeysValues(long key1, short value1)
    {
        return new UnmodifiableLongShortMap(new LongShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2)
    {
        return new UnmodifiableLongShortMap(new LongShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3)
    {
        return new UnmodifiableLongShortMap(new LongShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4)
    {
        return new UnmodifiableLongShortMap(new LongShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableLongShortMap getEmptyMap()
    {
        return new UnmodifiableLongShortMap(new LongShortHashMap());
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
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10L, (short) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10L, (short) 100));
        this.map.removeKeyIfAbsent(0L, (short) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0L, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0L, (short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0L, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1L, (short) 1);
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
        long collision1 = AbstractMutableLongShortMapTestCase.generateCollisions().getFirst();

        UnmodifiableLongShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent(0L, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31L, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32L, (short) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33L, (short) 6));
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
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0L, (short) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10L, (short) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        ShortFunction0 factory = () -> (short) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0L, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        ShortFunction0 factory = () -> (short) 100;

        this.map.getIfAbsentPut(10L, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0L, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        this.map.getIfAbsentPutWith(10L, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToShortFunction function = (long longParameter) -> (short) longParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0L, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableLongShortMap mutableLongShortMap = this.classUnderTest();
        LongSet frozenSet = mutableLongShortMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        LongToShortFunction function = (long longParameter) -> (short) longParameter;
        this.map.getIfAbsentPutWithKey(10L, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableLongShortMap copyMap = new UnmodifiableLongShortMap(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        this.map.updateValue(0L, (short) 0, incrementFunction);
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
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 31));
        Assert.assertTrue(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0L, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, (short) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1L, (short) 1, 5L, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, (short) 0, 5L, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, (short) 1, 0L, (short) 0, 5L, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, (short) 6, 5L, (short) 5).size());
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

        Verify.assertInstanceOf(UnmodifiableShortLongMap.class, this.classUnderTest().flipUniqueValues());
    }
}
