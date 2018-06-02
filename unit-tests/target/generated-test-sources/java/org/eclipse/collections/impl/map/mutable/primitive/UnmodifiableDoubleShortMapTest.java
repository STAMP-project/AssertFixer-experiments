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
import org.eclipse.collections.api.block.function.primitive.DoubleToShortFunction;
import org.eclipse.collections.api.iterator.MutableShortIterator;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.api.map.primitive.MutableDoubleShortMap;
import org.eclipse.collections.api.set.primitive.DoubleSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleShortMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableDoubleShortMapTest extends AbstractMutableDoubleShortMapTestCase
{
    private final UnmodifiableDoubleShortMap map = this.classUnderTest();

    @Override
    protected UnmodifiableDoubleShortMap classUnderTest()
    {
        return new UnmodifiableDoubleShortMap(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1)
    {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2)
    {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3)
    {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3, double key4, short value4)
    {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableDoubleShortMap getEmptyMap()
    {
        return new UnmodifiableDoubleShortMap(new DoubleShortHashMap());
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
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10.0, (short) 100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals((short) 100, this.map.removeKeyIfAbsent(10.0, (short) 100));
        this.map.removeKeyIfAbsent(0.0, (short) 100);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0.0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0.0, (short) 1));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0.0, (short) 1);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1.0, (short) 1);
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
        double collision1 = AbstractMutableDoubleShortMapTestCase.generateCollisions().getFirst();

        UnmodifiableDoubleShortMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, (short) 1);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get(0.0));
        Assert.assertEquals(31L, this.map.get(31.0));
        Assert.assertEquals(32L, this.map.get(32.0));
        Assert.assertEquals(0L, this.map.get(1.0));
        Assert.assertEquals(0L, this.map.get(33.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent(0.0, (short) 5));
        Assert.assertEquals(31L, this.map.getIfAbsent(31.0, (short) 5));
        Assert.assertEquals(32L, this.map.getIfAbsent(32.0, (short) 5));
        Assert.assertEquals(6L, this.map.getIfAbsent(33.0, (short) 6));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow(0.0));
        Assert.assertEquals(31L, this.map.getOrThrow(31.0));
        Assert.assertEquals(32L, this.map.getOrThrow(32.0));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0, (short) 50));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10.0, (short) 100);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        ShortFunction0 factory = () -> (short) 100;

        Assert.assertEquals(0L, this.map.getIfAbsentPut(0.0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        ShortFunction0 factory = () -> (short) 100;

        this.map.getIfAbsentPut(10.0, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        Assert.assertEquals(0L, this.map.getIfAbsentPutWith(0.0, functionLength, "123456789"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        ShortFunction<String> functionLength = (String string) -> (short) string.length();

        this.map.getIfAbsentPutWith(10.0, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToShortFunction function = (double doubleParameter) -> (short) doubleParameter;
        Assert.assertEquals(0L, this.map.getIfAbsentPutWithKey(0.0, function));
    }

    @Override
    @Test
    public void freeze()
    {
        MutableDoubleShortMap mutableDoubleShortMap = this.classUnderTest();
        DoubleSet frozenSet = mutableDoubleShortMap.keySet().freeze();
        DoubleSet frozenSetCopy = DoubleHashSet.newSetWith(mutableDoubleShortMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        DoubleToShortFunction function = (double doubleParameter) -> (short) doubleParameter;
        this.map.getIfAbsentPutWithKey(10.0, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableDoubleShortMap copyMap = new UnmodifiableDoubleShortMap(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        ShortToShortFunction incrementFunction = (short value) -> (short) (value + (short) 1);
        this.map.updateValue(0.0, (short) 0, incrementFunction);
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
        Assert.assertTrue(this.map.containsValue((short) 0));
        Assert.assertTrue(this.map.containsValue((short) 31));
        Assert.assertTrue(this.map.containsValue((short) 32));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues(0.0, (short) 0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0, (short) 1).size());

        Assert.assertEquals(2, this.newWithKeysValues(1.0, (short) 1, 5.0, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0, (short) 0, 5.0, (short) 5).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0, (short) 1, 0.0, (short) 0, 5.0, (short) 5).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0, (short) 6, 5.0, (short) 5).size());
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

        Verify.assertInstanceOf(UnmodifiableShortDoubleMap.class, this.classUnderTest().flipUniqueValues());
    }
}
