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
import org.eclipse.collections.api.block.function.primitive.LongToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.api.map.primitive.MutableLongDoubleMap;
import org.eclipse.collections.api.set.primitive.LongSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongDoubleMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableLongDoubleMapTest extends AbstractMutableLongDoubleMapTestCase
{
    private final UnmodifiableLongDoubleMap map = this.classUnderTest();

    @Override
    protected UnmodifiableLongDoubleMap classUnderTest()
    {
        return new UnmodifiableLongDoubleMap(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0));
    }

    @Override
    protected UnmodifiableLongDoubleMap newWithKeysValues(long key1, double value1)
    {
        return new UnmodifiableLongDoubleMap(new LongDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2)
    {
        return new UnmodifiableLongDoubleMap(new LongDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3)
    {
        return new UnmodifiableLongDoubleMap(new LongDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableLongDoubleMap newWithKeysValues(long key1, double value1, long key2, double value2, long key3, double value3, long key4, double value4)
    {
        return new UnmodifiableLongDoubleMap(new LongDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableLongDoubleMap getEmptyMap()
    {
        return new UnmodifiableLongDoubleMap(new LongDoubleHashMap());
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
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent(10L, 100.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent(10L, 100.0), 0.0);
        this.map.removeKeyIfAbsent(0L, 100.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0L, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0L, 1.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0L, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1L, 1.0);
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
        long collision1 = AbstractMutableLongDoubleMapTestCase.generateCollisions().getFirst();

        UnmodifiableLongDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get(0L), 0.0);
        Assert.assertEquals(31.0, this.map.get(31L), 0.0);
        Assert.assertEquals(32.0, this.map.get(32L), 0.0);
        Assert.assertEquals(0.0, this.map.get(1L), 0.0);
        Assert.assertEquals(0.0, this.map.get(33L), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0L, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31L, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32L, 5.0), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent(33L, 6.0), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow(0L), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31L), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32L), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1L));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33L));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0L, 50.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10L, 100.0);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0L, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        DoubleFunction0 factory = () -> 100.0;

        this.map.getIfAbsentPut(10L, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith(0L, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        this.map.getIfAbsentPutWith(10L, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        LongToDoubleFunction function = (long longParameter) -> (double) longParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey(0L, function), 0.0);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableLongDoubleMap mutableLongDoubleMap = this.classUnderTest();
        LongSet frozenSet = mutableLongDoubleMap.keySet().freeze();
        LongSet frozenSetCopy = LongHashSet.newSetWith(mutableLongDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        LongToDoubleFunction function = (long longParameter) -> (double) longParameter;
        this.map.getIfAbsentPutWithKey(10L, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableLongDoubleMap copyMap = new UnmodifiableLongDoubleMap(LongDoubleHashMap.newWithKeysValues(0L, 0.0, 31L, 31.0, 32L, 32.0));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        this.map.updateValue(0L, 0.0, incrementFunction);
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
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertTrue(this.map.containsValue(31.0));
        Assert.assertTrue(this.map.containsValue(32.0));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0L, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1L, 1.0).size());

        Assert.assertEquals(2, this.newWithKeysValues(1L, 1.0, 5L, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(0L, 0.0, 5L, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues(1L, 1.0, 0L, 0.0, 5L, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(6L, 6.0, 5L, 5.0).size());
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

        Verify.assertInstanceOf(UnmodifiableDoubleLongMap.class, this.classUnderTest().flipUniqueValues());
    }
}
