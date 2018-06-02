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
import org.eclipse.collections.api.block.function.primitive.ShortToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.api.map.primitive.MutableShortLongMap;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortLongMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableShortLongMapTest extends AbstractMutableShortLongMapTestCase
{
    private final UnmodifiableShortLongMap map = this.classUnderTest();

    @Override
    protected UnmodifiableShortLongMap classUnderTest()
    {
        return new UnmodifiableShortLongMap(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L));
    }

    @Override
    protected UnmodifiableShortLongMap newWithKeysValues(short key1, long value1)
    {
        return new UnmodifiableShortLongMap(new ShortLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2)
    {
        return new UnmodifiableShortLongMap(new ShortLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3)
    {
        return new UnmodifiableShortLongMap(new ShortLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4)
    {
        return new UnmodifiableShortLongMap(new ShortLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableShortLongMap getEmptyMap()
    {
        return new UnmodifiableShortLongMap(new ShortLongHashMap());
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
        this.map.removeKey((short) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove((short) 5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent((short) 10, 100L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent((short) 10, 100L));
        this.map.removeKeyIfAbsent((short) 0, 100L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((short) 0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((short) 0, 1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((short) 0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((short) 1, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey((short) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortLongMapTestCase.generateCollisions().getFirst();

        UnmodifiableShortLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((short) 0));
        Assert.assertEquals(31L, this.map.get((short) 31));
        Assert.assertEquals(32L, this.map.get((short) 32));
        Assert.assertEquals(0L, this.map.get((short) 1));
        Assert.assertEquals(0L, this.map.get((short) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent((short) 0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent((short) 31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent((short) 32, 5L));
        Assert.assertEquals(6L, this.map.getIfAbsent((short) 33, 6L));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow((short) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((short) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((short) 32));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut((short) 0, 50L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((short) 10, 100L);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        Assert.assertEquals(0L, this.map.getIfAbsentPut((short) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        LongFunction0 factory = () -> 100L;

        this.map.getIfAbsentPut((short) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        this.map.getIfAbsentPutWith((short) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToLongFunction function = (short shortParameter) -> (long) shortParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((short) 0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableShortLongMap mutableShortLongMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortLongMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ShortToLongFunction function = (short shortParameter) -> (long) shortParameter;
        this.map.getIfAbsentPutWithKey((short) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableShortLongMap copyMap = new UnmodifiableShortLongMap(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        this.map.updateValue((short) 0, 0L, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey((short) 0));
        Assert.assertTrue(this.map.containsKey((short) 31));
        Assert.assertTrue(this.map.containsKey((short) 32));
        Assert.assertFalse(this.map.containsKey((short) 1));
        Assert.assertFalse(this.map.containsKey((short) 5));
        Assert.assertFalse(this.map.containsKey((short) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1L).size());

        Assert.assertEquals(2, this.newWithKeysValues((short) 1, 1L, (short) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, 0L, (short) 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, 1L, (short) 0, 0L, (short) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, 6L, (short) 5, 5L).size());
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

        Verify.assertInstanceOf(UnmodifiableLongShortMap.class, this.classUnderTest().flipUniqueValues());
    }
}
