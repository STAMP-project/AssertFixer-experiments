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
import org.eclipse.collections.api.block.function.primitive.ByteToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.ByteSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableByteObjectMapTest extends AbstractMutableByteObjectMapTestCase
{
    private final UnmodifiableByteObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableByteObjectMap<String> classUnderTest()
    {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> newWithKeysValues(byte key1, T value1)
    {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2)
    {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> newWithKeysValues(byte key1, T value1, byte key2, T value2, byte key3, T value3)
    {
        return new UnmodifiableByteObjectMap<>(ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableByteObjectMap<T> getEmptyMap()
    {
        return new UnmodifiableByteObjectMap<>(new ByteObjectHashMap<>());
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
        this.map.removeKey((byte) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove((byte) 5);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((byte) 0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((byte) 0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll()
    {
        ByteObjectHashMap<String> hashMap = ByteObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((byte) 1, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey((byte) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        byte collision1 = AbstractMutableByteObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.map.get((byte) 0));
        Assert.assertEquals("thirtyOne", this.map.get((byte) 31));
        Assert.assertEquals("thirtyTwo", this.map.get((byte) 32));

        Assert.assertNull(this.map.get((byte) 1));
        Assert.assertNull(this.map.get((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.map.getIfAbsent((byte) 0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent((byte) 31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent((byte) 32, ifAbsent));

        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((byte) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((byte) 33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((byte) 0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws()
    {
        this.map.getIfAbsentPut((byte) 1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((byte) 0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws()
    {
        this.map.getIfAbsentPut((byte) 1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((byte) 0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith((byte) 1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((byte) 0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ByteToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey((byte) 1, toString);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableByteObjectMap<String> mutableByteObjectMap = this.classUnderTest();
        ByteSet frozenSet = mutableByteObjectMap.keySet().freeze();
        ByteSet frozenSetCopy = ByteHashSet.newSetWith(mutableByteObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValue((byte) 0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValueWith((byte) 0, zeroFactory, incrementFunction, 1);
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
        Assert.assertTrue(this.map.containsKey((byte) 0));
        Assert.assertTrue(this.map.containsKey((byte) 31));
        Assert.assertTrue(this.map.containsKey((byte) 32));
        Assert.assertFalse(this.map.containsKey((byte) 1));
        Assert.assertFalse(this.map.containsKey((byte) 5));
        Assert.assertFalse(this.map.containsKey((byte) 35));
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
        Assert.assertEquals(1, this.newWithKeysValues((byte) 0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues((byte) 1, "one").size());

        Assert.assertEquals(2, this.newWithKeysValues((byte) 1, "one", (byte) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 0, "zero", (byte) 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues((byte) 1, "one", (byte) 0, "zero", (byte) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((byte) 6, "six", (byte) 5, "five").size());
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

        Iterator<String> iterator = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero",
                (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo")
                .withKeyValue((byte) 1, "one").asUnmodifiable().iterator();
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

        UnmodifiableByteObjectMap<String> map1 = this.newWithKeysValues((byte) 0, "zero", (byte) 1, "one");
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

        Verify.assertInstanceOf(UnmodifiableObjectByteMap.class, this.classUnderTest().flipUniqueValues());
    }
}
