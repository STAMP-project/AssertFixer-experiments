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

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.IntToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.IntSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableIntObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableIntObjectMapTest extends AbstractMutableIntObjectMapTestCase
{
    private final UnmodifiableIntObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableIntObjectMap<String> classUnderTest()
    {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(0, "zero", 31, "thirtyOne", 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> newWithKeysValues(int key1, T value1)
    {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2)
    {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> newWithKeysValues(int key1, T value1, int key2, T value2, int key3, T value3)
    {
        return new UnmodifiableIntObjectMap<>(IntObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableIntObjectMap<T> getEmptyMap()
    {
        return new UnmodifiableIntObjectMap<>(new IntObjectHashMap<>());
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
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll()
    {
        IntObjectHashMap<String> hashMap = IntObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1, "one");
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
        int collision1 = AbstractMutableIntObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.map.get(0));
        Assert.assertEquals("thirtyOne", this.map.get(31));
        Assert.assertEquals("thirtyTwo", this.map.get(32));

        Assert.assertNull(this.map.get(1));
        Assert.assertNull(this.map.get(33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.map.getIfAbsent(0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent(31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent(32, ifAbsent));

        Assert.assertEquals("ifAbsent", this.map.getIfAbsent(1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent(33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws()
    {
        this.map.getIfAbsentPut(1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws()
    {
        this.map.getIfAbsentPut(1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith(1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        IntToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        IntToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey(1, toString);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableIntObjectMap<String> mutableIntObjectMap = this.classUnderTest();
        IntSet frozenSet = mutableIntObjectMap.keySet().freeze();
        IntSet frozenSetCopy = IntHashSet.newSetWith(mutableIntObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValue(0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValueWith(0, zeroFactory, incrementFunction, 1);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.map.contains(null));
        Assert.assertTrue(this.map.contains("zero"));
        Assert.assertTrue(this.map.contains("thirtyOne"));
        Assert.assertTrue(this.map.contains("thirtyTwo"));
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
        Assert.assertFalse(this.map.containsValue(null));
        Assert.assertTrue(this.map.containsValue("zero"));
        Assert.assertTrue(this.map.containsValue("thirtyOne"));
        Assert.assertTrue(this.map.containsValue("thirtyTwo"));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues(1, "one").size());

        Assert.assertEquals(2, this.newWithKeysValues(1, "one", 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(0, "zero", 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues(1, "one", 0, "zero", 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(6, "six", 5, "five").size());
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
    public void iterator()
    {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "one", "thirtyOne", "thirtyTwo");
        MutableSet<String> actual = UnifiedSet.newSet();

        Iterator<String> iterator = IntObjectHashMap.newWithKeysValues(0, "zero",
                31, "thirtyOne", 32, "thirtyTwo")
                .withKeyValue(1, "one").asUnmodifiable().iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);

        UnmodifiableIntObjectMap<String> map1 = this.newWithKeysValues(0, "zero", 1, "one");
        Iterator<String> iterator1 = map1.iterator();
        Verify.assertThrows(UnsupportedOperationException.class, iterator1::remove);
        iterator1.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator1::remove);
    }

    @Override
    @Test
    public void flipUniqueValues()
    {
        super.flipUniqueValues();

        Verify.assertInstanceOf(UnmodifiableObjectIntMap.class, this.classUnderTest().flipUniqueValues());
    }
}
