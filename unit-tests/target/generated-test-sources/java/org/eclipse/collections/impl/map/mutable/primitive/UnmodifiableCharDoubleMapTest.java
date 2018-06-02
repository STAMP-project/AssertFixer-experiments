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

import org.eclipse.collections.api.block.function.primitive.DoubleFunction;
import org.eclipse.collections.api.block.function.primitive.DoubleFunction0;
import org.eclipse.collections.api.block.function.primitive.DoubleToDoubleFunction;
import org.eclipse.collections.api.block.function.primitive.CharToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharDoubleMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableCharDoubleMapTest extends AbstractMutableCharDoubleMapTestCase
{
    private final UnmodifiableCharDoubleMap map = this.classUnderTest();

    @Override
    protected UnmodifiableCharDoubleMap classUnderTest()
    {
        return new UnmodifiableCharDoubleMap(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0));
    }

    @Override
    protected UnmodifiableCharDoubleMap newWithKeysValues(char key1, double value1)
    {
        return new UnmodifiableCharDoubleMap(new CharDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2)
    {
        return new UnmodifiableCharDoubleMap(new CharDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3)
    {
        return new UnmodifiableCharDoubleMap(new CharDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3, char key4, double value4)
    {
        return new UnmodifiableCharDoubleMap(new CharDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableCharDoubleMap getEmptyMap()
    {
        return new UnmodifiableCharDoubleMap(new CharDoubleHashMap());
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
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent((char) 10, 100.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent((char) 10, 100.0), 0.0);
        this.map.removeKeyIfAbsent((char) 0, 100.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((char) 0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((char) 0, 1.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((char) 0, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((char) 1, 1.0);
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
        char collision1 = AbstractMutableCharDoubleMapTestCase.generateCollisions().getFirst();

        UnmodifiableCharDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get((char) 0), 0.0);
        Assert.assertEquals(31.0, this.map.get((char) 31), 0.0);
        Assert.assertEquals(32.0, this.map.get((char) 32), 0.0);
        Assert.assertEquals(0.0, this.map.get((char) 1), 0.0);
        Assert.assertEquals(0.0, this.map.get((char) 33), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent((char) 0, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((char) 31, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((char) 32, 5.0), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent((char) 33, 6.0), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow((char) 0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow((char) 31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow((char) 32), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((char) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut((char) 0, 50.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((char) 10, 100.0);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut((char) 0, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        DoubleFunction0 factory = () -> 100.0;

        this.map.getIfAbsentPut((char) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        this.map.getIfAbsentPutWith((char) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToDoubleFunction function = (char charParameter) -> (double) charParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey((char) 0, function), 0.0);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableCharDoubleMap mutableCharDoubleMap = this.classUnderTest();
        CharSet frozenSet = mutableCharDoubleMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        CharToDoubleFunction function = (char charParameter) -> (double) charParameter;
        this.map.getIfAbsentPutWithKey((char) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableCharDoubleMap copyMap = new UnmodifiableCharDoubleMap(CharDoubleHashMap.newWithKeysValues((char) 0, 0.0, (char) 31, 31.0, (char) 32, 32.0));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        this.map.updateValue((char) 0, 0.0, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertTrue(this.map.contains(31.0));
        Assert.assertTrue(this.map.contains(32.0));
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
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertTrue(this.map.containsValue(31.0));
        Assert.assertTrue(this.map.containsValue(32.0));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, 1.0).size());

        Assert.assertEquals(2, this.newWithKeysValues((char) 1, 1.0, (char) 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, 0.0, (char) 5, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, 1.0, (char) 0, 0.0, (char) 5, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, 6.0, (char) 5, 5.0).size());
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
    public void doubleIterator_with_remove()
    {
        MutableDoubleIterator iterator = this.map.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableDoubleIterator iterator = this.map.doubleIterator();
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

        Verify.assertInstanceOf(UnmodifiableDoubleCharMap.class, this.classUnderTest().flipUniqueValues());
    }
}
