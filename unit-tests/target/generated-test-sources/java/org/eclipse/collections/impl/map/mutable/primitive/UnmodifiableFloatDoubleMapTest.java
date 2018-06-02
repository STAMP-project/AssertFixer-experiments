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
import org.eclipse.collections.api.block.function.primitive.FloatToDoubleFunction;
import org.eclipse.collections.api.iterator.MutableDoubleIterator;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.api.map.primitive.MutableFloatDoubleMap;
import org.eclipse.collections.api.set.primitive.FloatSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableFloatDoubleMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableFloatDoubleMapTest extends AbstractMutableFloatDoubleMapTestCase
{
    private final UnmodifiableFloatDoubleMap map = this.classUnderTest();

    @Override
    protected UnmodifiableFloatDoubleMap classUnderTest()
    {
        return new UnmodifiableFloatDoubleMap(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0));
    }

    @Override
    protected UnmodifiableFloatDoubleMap newWithKeysValues(float key1, double value1)
    {
        return new UnmodifiableFloatDoubleMap(new FloatDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2)
    {
        return new UnmodifiableFloatDoubleMap(new FloatDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3)
    {
        return new UnmodifiableFloatDoubleMap(new FloatDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableFloatDoubleMap newWithKeysValues(float key1, double value1, float key2, double value2, float key3, double value3, float key4, double value4)
    {
        return new UnmodifiableFloatDoubleMap(new FloatDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableFloatDoubleMap getEmptyMap()
    {
        return new UnmodifiableFloatDoubleMap(new FloatDoubleHashMap());
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
        this.map.removeKey(5.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void remove()
    {
        this.map.remove(5.0f);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent(10.0f, 100.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100.0, this.map.removeKeyIfAbsent(10.0f, 100.0), 0.0);
        this.map.removeKeyIfAbsent(0.0f, 100.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put(0.0f, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair(0.0f, 1.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue(0.0f, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue(1.0f, 1.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.map.withoutKey(32.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.map.withoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        float collision1 = AbstractMutableFloatDoubleMapTestCase.generateCollisions().getFirst();

        UnmodifiableFloatDoubleMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get(0.0f), 0.0);
        Assert.assertEquals(31.0, this.map.get(31.0f), 0.0);
        Assert.assertEquals(32.0, this.map.get(32.0f), 0.0);
        Assert.assertEquals(0.0, this.map.get(1.0f), 0.0);
        Assert.assertEquals(0.0, this.map.get(33.0f), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0.0f, 5.0), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent(31.0f, 5.0), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent(32.0f, 5.0), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent(33.0f, 6.0), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow(0.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow(31.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow(32.0f), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(1.0f));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(33.0f));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0.0f, 50.0), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut(10.0f, 100.0);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        DoubleFunction0 factory = () -> 100.0;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut(0.0f, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        DoubleFunction0 factory = () -> 100.0;

        this.map.getIfAbsentPut(10.0f, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith(0.0f, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        DoubleFunction<String> functionLength = (String string) -> (double) string.length();

        this.map.getIfAbsentPutWith(10.0f, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        FloatToDoubleFunction function = (float floatParameter) -> (double) floatParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey(0.0f, function), 0.0);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableFloatDoubleMap mutableFloatDoubleMap = this.classUnderTest();
        FloatSet frozenSet = mutableFloatDoubleMap.keySet().freeze();
        FloatSet frozenSetCopy = FloatHashSet.newSetWith(mutableFloatDoubleMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        FloatToDoubleFunction function = (float floatParameter) -> (double) floatParameter;
        this.map.getIfAbsentPutWithKey(10.0f, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableFloatDoubleMap copyMap = new UnmodifiableFloatDoubleMap(FloatDoubleHashMap.newWithKeysValues(0.0f, 0.0, 31.0f, 31.0, 32.0f, 32.0));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        DoubleToDoubleFunction incrementFunction = (double value) -> value + 1.0;
        this.map.updateValue(0.0f, 0.0, incrementFunction);
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
        Assert.assertTrue(this.map.containsKey(0.0f));
        Assert.assertTrue(this.map.containsKey(31.0f));
        Assert.assertTrue(this.map.containsKey(32.0f));
        Assert.assertFalse(this.map.containsKey(1.0f));
        Assert.assertFalse(this.map.containsKey(5.0f));
        Assert.assertFalse(this.map.containsKey(35.0f));
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
        Assert.assertEquals(1, this.newWithKeysValues(0.0f, 0.0).size());
        Assert.assertEquals(1, this.newWithKeysValues(1.0f, 1.0).size());

        Assert.assertEquals(2, this.newWithKeysValues(1.0f, 1.0, 5.0f, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(0.0f, 0.0, 5.0f, 5.0).size());
        Assert.assertEquals(3, this.newWithKeysValues(1.0f, 1.0, 0.0f, 0.0, 5.0f, 5.0).size());
        Assert.assertEquals(2, this.newWithKeysValues(6.0f, 6.0, 5.0f, 5.0).size());
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

        Verify.assertInstanceOf(UnmodifiableDoubleFloatMap.class, this.classUnderTest().flipUniqueValues());
    }
}
