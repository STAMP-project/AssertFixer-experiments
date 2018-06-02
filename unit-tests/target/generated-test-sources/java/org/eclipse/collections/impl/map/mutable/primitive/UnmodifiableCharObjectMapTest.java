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
import org.eclipse.collections.api.block.function.primitive.CharToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableCharObjectMapTest extends AbstractMutableCharObjectMapTestCase
{
    private final UnmodifiableCharObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableCharObjectMap<String> classUnderTest()
    {
        return new UnmodifiableCharObjectMap<>(CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableCharObjectMap<T> newWithKeysValues(char key1, T value1)
    {
        return new UnmodifiableCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2)
    {
        return new UnmodifiableCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableCharObjectMap<T> newWithKeysValues(char key1, T value1, char key2, T value2, char key3, T value3)
    {
        return new UnmodifiableCharObjectMap<>(CharObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableCharObjectMap<T> getEmptyMap()
    {
        return new UnmodifiableCharObjectMap<>(new CharObjectHashMap<>());
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
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((char) 0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((char) 0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll()
    {
        CharObjectHashMap<String> hashMap = CharObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((char) 1, "one");
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
        char collision1 = AbstractMutableCharObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.map.get((char) 0));
        Assert.assertEquals("thirtyOne", this.map.get((char) 31));
        Assert.assertEquals("thirtyTwo", this.map.get((char) 32));

        Assert.assertNull(this.map.get((char) 1));
        Assert.assertNull(this.map.get((char) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.map.getIfAbsent((char) 0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent((char) 31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent((char) 32, ifAbsent));

        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((char) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((char) 33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((char) 0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws()
    {
        this.map.getIfAbsentPut((char) 1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((char) 0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws()
    {
        this.map.getIfAbsentPut((char) 1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((char) 0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith((char) 1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((char) 0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        CharToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey((char) 1, toString);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableCharObjectMap<String> mutableCharObjectMap = this.classUnderTest();
        CharSet frozenSet = mutableCharObjectMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValue((char) 0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValueWith((char) 0, zeroFactory, incrementFunction, 1);
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
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, "one").size());

        Assert.assertEquals(2, this.newWithKeysValues((char) 1, "one", (char) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, "zero", (char) 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, "one", (char) 0, "zero", (char) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, "six", (char) 5, "five").size());
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

        Iterator<String> iterator = CharObjectHashMap.newWithKeysValues((char) 0, "zero",
                (char) 31, "thirtyOne", (char) 32, "thirtyTwo")
                .withKeyValue((char) 1, "one").asUnmodifiable().iterator();
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

        UnmodifiableCharObjectMap<String> map1 = this.newWithKeysValues((char) 0, "zero", (char) 1, "one");
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

        Verify.assertInstanceOf(UnmodifiableObjectCharMap.class, this.classUnderTest().flipUniqueValues());
    }
}
