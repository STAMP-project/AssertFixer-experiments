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
import org.eclipse.collections.api.block.function.primitive.CharToLongFunction;
import org.eclipse.collections.api.iterator.MutableLongIterator;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.api.map.primitive.MutableCharLongMap;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharLongMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableCharLongMapTest extends AbstractMutableCharLongMapTestCase
{
    private final UnmodifiableCharLongMap map = this.classUnderTest();

    @Override
    protected UnmodifiableCharLongMap classUnderTest()
    {
        return new UnmodifiableCharLongMap(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L));
    }

    @Override
    protected UnmodifiableCharLongMap newWithKeysValues(char key1, long value1)
    {
        return new UnmodifiableCharLongMap(new CharLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2)
    {
        return new UnmodifiableCharLongMap(new CharLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3)
    {
        return new UnmodifiableCharLongMap(new CharLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableCharLongMap newWithKeysValues(char key1, long value1, char key2, long value2, char key3, long value3, char key4, long value4)
    {
        return new UnmodifiableCharLongMap(new CharLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableCharLongMap getEmptyMap()
    {
        return new UnmodifiableCharLongMap(new CharLongHashMap());
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
        this.map.removeKey((char) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove((char) 5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent((char) 10, 100L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100L, this.map.removeKeyIfAbsent((char) 10, 100L));
        this.map.removeKeyIfAbsent((char) 0, 100L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((char) 0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((char) 0, 1L));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((char) 0, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((char) 1, 1L);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey((char) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        char collision1 = AbstractMutableCharLongMapTestCase.generateCollisions().getFirst();

        UnmodifiableCharLongMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1L);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(31L, this.map.get((char) 31));
        Assert.assertEquals(32L, this.map.get((char) 32));
        Assert.assertEquals(0L, this.map.get((char) 1));
        Assert.assertEquals(0L, this.map.get((char) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent((char) 0, 5L));
        Assert.assertEquals(31L, this.map.getIfAbsent((char) 31, 5L));
        Assert.assertEquals(32L, this.map.getIfAbsent((char) 32, 5L));
        Assert.assertEquals(6L, this.map.getIfAbsent((char) 33, 6L));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow((char) 0));
        Assert.assertEquals(31L, this.map.getOrThrow((char) 31));
        Assert.assertEquals(32L, this.map.getOrThrow((char) 32));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut((char) 0, 50L));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((char) 10, 100L);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        LongFunction0 factory = () -> 100L;

        Assert.assertEquals(0L, this.map.getIfAbsentPut((char) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        LongFunction0 factory = () -> 100L;

        this.map.getIfAbsentPut((char) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((char) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        LongFunction<String> functionLength = (String string) -> (long) string.length();

        this.map.getIfAbsentPutWith((char) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToLongFunction function = (char charParameter) -> (long) charParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((char) 0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableCharLongMap mutableCharLongMap = this.classUnderTest();
        CharSet frozenSet = mutableCharLongMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharLongMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        CharToLongFunction function = (char charParameter) -> (long) charParameter;
        this.map.getIfAbsentPutWithKey((char) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableCharLongMap copyMap = new UnmodifiableCharLongMap(CharLongHashMap.newWithKeysValues((char) 0, 0L, (char) 31, 31L, (char) 32, 32L));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        LongToLongFunction incrementFunction = (long value) -> value + 1L;
        this.map.updateValue((char) 0, 0L, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey((char) 0));
        Assert.assertTrue(this.map.containsKey((char) 31));
        Assert.assertTrue(this.map.containsKey((char) 32));
        Assert.assertFalse(this.map.containsKey((char) 1));
        Assert.assertFalse(this.map.containsKey((char) 5));
        Assert.assertFalse(this.map.containsKey((char) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, 0L).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, 1L).size());

        Assert.assertEquals(2, this.newWithKeysValues((char) 1, 1L, (char) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, 0L, (char) 5, 5L).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, 1L, (char) 0, 0L, (char) 5, 5L).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, 6L, (char) 5, 5L).size());
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

        Verify.assertInstanceOf(UnmodifiableLongCharMap.class, this.classUnderTest().flipUniqueValues());
    }
}
