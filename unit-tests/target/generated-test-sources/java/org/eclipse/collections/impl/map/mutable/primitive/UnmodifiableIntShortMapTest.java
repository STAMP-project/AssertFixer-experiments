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
import org.eclipse.collections.api.block.function.primitive.IntToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.api.map.primitive.MutableIntShortMap;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntShortMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableIntShortMapTest extends AbstractMutableIntShortMapTestCase
{
    private final UnmodifiableIntShortMap map = this.classUnderTest();

    @Override
    protected UnmodifiableIntShortMap classUnderTest()
    {
        return new UnmodifiableIntShortMap(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32));
    }

    @Override
    protected UnmodifiableIntShortMap newWithKeysValues(int key1, short value1)
    {
        return new UnmodifiableIntShortMap(new IntShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2)
    {
        return new UnmodifiableIntShortMap(new IntShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3)
    {
        return new UnmodifiableIntShortMap(new IntShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableIntShortMap newWithKeysValues(int key1, short value1, int key2, short value2, int key3, short value3, int key4, short value4)
    {
        return new UnmodifiableIntShortMap(new IntShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableIntShortMap getEmptyMap()
    {
        return new UnmodifiableIntShortMap(new IntShortHashMap());
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
        this.map.removeKey(5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove(5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10, (short) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10, (short) 100));
        this.map.removeKeyIfAbsent(0, (short) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0, (short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey(32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(IntArrayList.newListWith(0, 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        int collision1 = AbstractMutableIntShortMapTestCase.generateCollisions().getFirst();

        UnmodifiableIntShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0));
        Assert.assertEquals(31L, this.map.get(31));
        Assert.assertEquals(32L, this.map.get(32));
        Assert.assertEquals(0L, this.map.get(1));
        Assert.assertEquals(0L, this.map.get(33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32, (short) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33, (short) 6));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0));
        Assert.assertEquals(31L, this.map.getOrThrow(31));
        Assert.assertEquals(32L, this.map.getOrThrow(32));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0, (short) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10, (short) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        ShortFunction0 factory = () -> (short) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        ShortFunction0 factory = () -> (short) 100;

        this.map.getIfAbsentPut(10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        this.map.getIfAbsentPutWith(10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        IntToShortFunction function = (int intParameter) -> (short) intParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableIntShortMap mutableIntShortMap = this.classUnderTest();
        IntSet frozenSet = mutableIntShortMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        IntToShortFunction function = (int intParameter) -> (short) intParameter;
        this.map.getIfAbsentPutWithKey(10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableIntShortMap copyMap = new UnmodifiableIntShortMap(IntShortHashMap.newWithKeysValues(0, (short) 0, 31, (short) 31, 32, (short) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        this.map.updateValue(0, (short) 0, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey(0));
        Assert.assertTrue(this.map.containsKey(31));
        Assert.assertTrue(this.map.containsKey(32));
        Assert.assertFalse(this.map.containsKey(1));
        Assert.assertFalse(this.map.containsKey(5));
        Assert.assertFalse(this.map.containsKey(35));
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
        Assert.assertEquals(1, this.newWithKeysValues(0, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1, (short) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1, (short) 1, 5, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0, (short) 0, 5, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1, (short) 1, 0, (short) 0, 5, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6, (short) 6, 5, (short) 5).size());
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

        Verify.assertInstanceOf(UnmodifiableShortIntMap.class, this.classUnderTest().flipUniqueValues());
    }
}
