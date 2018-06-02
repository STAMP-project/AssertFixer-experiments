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
import org.eclipse.collections.api.block.function.primitive.ShortToIntFunction;
import org.eclipse.collections.api.iterator.MutableIntIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.api.map.primitive.MutableShortIntMap;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortIntMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableShortIntMapTest extends AbstractMutableShortIntMapTestCase
{
    private final UnmodifiableShortIntMap map = this.classUnderTest();

    @Override
    protected UnmodifiableShortIntMap classUnderTest()
    {
        return new UnmodifiableShortIntMap(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32));
    }

    @Override
    protected UnmodifiableShortIntMap newWithKeysValues(short key1, int value1)
    {
        return new UnmodifiableShortIntMap(new ShortIntHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2)
    {
        return new UnmodifiableShortIntMap(new ShortIntHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3)
    {
        return new UnmodifiableShortIntMap(new ShortIntHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableShortIntMap newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3, short key4, int value4)
    {
        return new UnmodifiableShortIntMap(new ShortIntHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableShortIntMap getEmptyMap()
    {
        return new UnmodifiableShortIntMap(new ShortIntHashMap());
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
        Assert.assertEquals(100, this.map.removeKeyIfAbsent((short) 10, 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100, this.map.removeKeyIfAbsent((short) 10, 100));
        this.map.removeKeyIfAbsent((short) 0, 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((short) 0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((short) 0, 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((short) 0, 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((short) 1, 1);
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
        short collision1 = AbstractMutableShortIntMapTestCase.generateCollisions().getFirst();

        UnmodifiableShortIntMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1);
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
        Assert.assertEquals(0L, this.map.getIfAbsent((short) 0, 5));
        Assert.assertEquals(31L, this.map.getIfAbsent((short) 31, 5));
        Assert.assertEquals(32L, this.map.getIfAbsent((short) 32, 5));
        Assert.assertEquals(6L, this.map.getIfAbsent((short) 33, 6));
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
        Assert.assertEquals(0L, this.map.getIfAbsentPut((short) 0, 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((short) 10, 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        IntFunction0 factory = () -> 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut((short) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        IntFunction0 factory = () -> 100;

        this.map.getIfAbsentPut((short) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        IntFunction<String> functionLength = (String string) -> string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith((short) 0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        IntFunction<String> functionLength = (String string) -> string.length();

        this.map.getIfAbsentPutWith((short) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToIntFunction function = (short shortParameter) -> (int) shortParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey((short) 0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableShortIntMap mutableShortIntMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortIntMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortIntMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ShortToIntFunction function = (short shortParameter) -> (int) shortParameter;
        this.map.getIfAbsentPutWithKey((short) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableShortIntMap copyMap = new UnmodifiableShortIntMap(ShortIntHashMap.newWithKeysValues((short) 0, 0, (short) 31, 31, (short) 32, 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        IntToIntFunction incrementFunction = (int value) -> value + 1;
        this.map.updateValue((short) 0, 0, incrementFunction);
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
        Assert.assertTrue(this.map.containsValue(0));
        Assert.assertTrue(this.map.containsValue(31));
        Assert.assertTrue(this.map.containsValue(32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, 0).size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1).size());

        Assert.assertEquals(2, this.newWithKeysValues((short) 1, 1, (short) 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, 0, (short) 5, 5).size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, 1, (short) 0, 0, (short) 5, 5).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, 6, (short) 5, 5).size());
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

        Verify.assertInstanceOf(UnmodifiableIntShortMap.class, this.classUnderTest().flipUniqueValues());
    }
}
