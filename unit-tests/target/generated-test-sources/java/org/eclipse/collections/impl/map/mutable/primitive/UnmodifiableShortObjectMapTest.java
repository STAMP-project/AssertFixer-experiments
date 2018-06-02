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
import org.eclipse.collections.api.block.function.primitive.ShortToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableShortObjectMapTest extends AbstractMutableShortObjectMapTestCase
{
    private final UnmodifiableShortObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableShortObjectMap<String> classUnderTest()
    {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> newWithKeysValues(short key1, T value1)
    {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2)
    {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> newWithKeysValues(short key1, T value1, short key2, T value2, short key3, T value3)
    {
        return new UnmodifiableShortObjectMap<>(ShortObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableShortObjectMap<T> getEmptyMap()
    {
        return new UnmodifiableShortObjectMap<>(new ShortObjectHashMap<>());
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
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((short) 0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((short) 0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll()
    {
        ShortObjectHashMap<String> hashMap = ShortObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((short) 1, "one");
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
        short collision1 = AbstractMutableShortObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.map.get((short) 0));
        Assert.assertEquals("thirtyOne", this.map.get((short) 31));
        Assert.assertEquals("thirtyTwo", this.map.get((short) 32));

        Assert.assertNull(this.map.get((short) 1));
        Assert.assertNull(this.map.get((short) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.map.getIfAbsent((short) 0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent((short) 31, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent((short) 32, ifAbsent));

        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((short) 1, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent((short) 33, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((short) 0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws()
    {
        this.map.getIfAbsentPut((short) 1, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut((short) 0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws()
    {
        this.map.getIfAbsentPut((short) 1, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith((short) 0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith((short) 1, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey((short) 0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ShortToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey((short) 1, toString);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableShortObjectMap<String> mutableShortObjectMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortObjectMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValue((short) 0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValueWith((short) 0, zeroFactory, incrementFunction, 1);
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
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, "one").size());

        Assert.assertEquals(2, this.newWithKeysValues((short) 1, "one", (short) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, "zero", (short) 5, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, "one", (short) 0, "zero", (short) 5, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, "six", (short) 5, "five").size());
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

        Iterator<String> iterator = ShortObjectHashMap.newWithKeysValues((short) 0, "zero",
                (short) 31, "thirtyOne", (short) 32, "thirtyTwo")
                .withKeyValue((short) 1, "one").asUnmodifiable().iterator();
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

        UnmodifiableShortObjectMap<String> map1 = this.newWithKeysValues((short) 0, "zero", (short) 1, "one");
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

        Verify.assertInstanceOf(UnmodifiableObjectShortMap.class, this.classUnderTest().flipUniqueValues());
    }
}
