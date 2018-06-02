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
import org.eclipse.collections.api.block.function.primitive.DoubleToObjectFunction;
import org.eclipse.collections.api.map.primitive.MutableDoubleObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleObjectMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapTest.stg.
 */
public class UnmodifiableDoubleObjectMapTest extends AbstractMutableDoubleObjectMapTestCase
{
    private final UnmodifiableDoubleObjectMap<String> map = this.classUnderTest();

    @Override
    protected UnmodifiableDoubleObjectMap<String> classUnderTest()
    {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo"));
    }

    @Override
    protected <T> UnmodifiableDoubleObjectMap<T> newWithKeysValues(double key1, T value1)
    {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> UnmodifiableDoubleObjectMap<T> newWithKeysValues(double key1, T value1, double key2, T value2)
    {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> UnmodifiableDoubleObjectMap<T> newWithKeysValues(double key1, T value1, double key2, T value2, double key3, T value3)
    {
        return new UnmodifiableDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> UnmodifiableDoubleObjectMap<T> getEmptyMap()
    {
        return new UnmodifiableDoubleObjectMap<>(new DoubleObjectHashMap<>());
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
        this.map.removeKey(5.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove(5.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0.0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0.0, "one"));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putAll()
    {
        DoubleObjectHashMap<String> hashMap = DoubleObjectHashMap.newMap();
        this.map.putAll(hashMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1.0, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey(32.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        double collision1 = AbstractMutableDoubleObjectMapTestCase.generateCollisions().getFirst();
        this.getEmptyMap().put(collision1, "one");
    }

@Override
@Test(expected = UnsupportedOperationException.class)
public void put_NaN()
{
    MutableDoubleObjectMap<String> map = this.getEmptyMap();
    map.put(Double.NaN, "one");
}

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put_POSITIVE_INFINITY()
    {
        MutableDoubleObjectMap<String> map = this.getEmptyMap();
        map.put(Double.POSITIVE_INFINITY, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put_NEGATIVE_INFINITY()
    {
        MutableDoubleObjectMap<String> map = this.getEmptyMap();
        map.put(Double.NEGATIVE_INFINITY, "one");
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put_zero()
    {
        MutableDoubleObjectMap<String> map = this.getEmptyMap();
        map.put(0.0, "one");
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals("zero", this.map.get(0.0));
        Assert.assertEquals("thirtyOne", this.map.get(31.0));
        Assert.assertEquals("thirtyTwo", this.map.get(32.0));

        Assert.assertNull(this.map.get(1.0));
        Assert.assertNull(this.map.get(33.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Function0<String> ifAbsent = () -> "ifAbsent";

        Assert.assertEquals("zero", this.map.getIfAbsent(0.0, ifAbsent));
        Assert.assertEquals("thirtyOne", this.map.getIfAbsent(31.0, ifAbsent));
        Assert.assertEquals("thirtyTwo", this.map.getIfAbsent(32.0, ifAbsent));

        Assert.assertEquals("ifAbsent", this.map.getIfAbsent(1.0, ifAbsent));
        Assert.assertEquals("ifAbsent", this.map.getIfAbsent(33.0, ifAbsent));
    }

    @Override
    @Test
    public void getIfAbsentPut_Value()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0.0, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Value_throws()
    {
        this.map.getIfAbsentPut(1.0, "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        Assert.assertEquals("zero", this.map.getIfAbsentPut(0.0, () -> "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_Function_throws()
    {
        this.map.getIfAbsentPut(1.0, () -> "oneValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWith(0.0, toUpperCase, "zeroValue"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        Function<String, String> toUpperCase = String::toUpperCase;
        this.map.getIfAbsentPutWith(1.0, toUpperCase, "zeroValue");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToObjectFunction<String> toString = String::valueOf;
        Assert.assertEquals("zero", this.map.getIfAbsentPutWithKey(0.0, toString));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        DoubleToObjectFunction<String> toString = String::valueOf;
        this.map.getIfAbsentPutWithKey(1.0, toString);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableDoubleObjectMap<String> mutableDoubleObjectMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleObjectMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleObjectMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        Function<Integer, Integer> incrementFunction = (Integer integer) -> integer + 1;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValue(0.0, zeroFactory, incrementFunction);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValueWith()
    {
        Function2<Integer, Integer, Integer> incrementFunction = AddFunction.INTEGER;
        Function0<Integer> zeroFactory = Functions0.value(0);

        this.<Integer>getEmptyMap().updateValueWith(0.0, zeroFactory, incrementFunction, 1);
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
        Assert.assertTrue(this.map.containsKey(0.0));
        Assert.assertTrue(this.map.containsKey(31.0));
        Assert.assertTrue(this.map.containsKey(32.0));
        Assert.assertFalse(this.map.containsKey(1.0));
        Assert.assertFalse(this.map.containsKey(5.0));
        Assert.assertFalse(this.map.containsKey(35.0));
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
        Assert.assertEquals(1, this.newWithKeysValues(0.0, "zero").size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, "one").size());

        Assert.assertEquals(2, this.newWithKeysValues(1.0, "one", 5.0, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, "zero", 5.0, "five").size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, "one", 0.0, "zero", 5.0, "five").size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, "six", 5.0, "five").size());
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

        Iterator<String> iterator = DoubleObjectHashMap.newWithKeysValues(0.0, "zero",
                31.0, "thirtyOne", 32.0, "thirtyTwo")
                .withKeyValue(1.0, "one").asUnmodifiable().iterator();
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

        UnmodifiableDoubleObjectMap<String> map1 = this.newWithKeysValues(0.0, "zero", 1.0, "one");
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

        Verify.assertInstanceOf(UnmodifiableObjectDoubleMap.class, this.classUnderTest().flipUniqueValues());
    }
}
