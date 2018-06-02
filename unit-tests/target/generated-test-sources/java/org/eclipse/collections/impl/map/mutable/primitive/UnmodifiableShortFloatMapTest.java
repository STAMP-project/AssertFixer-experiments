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

import org.eclipse.collections.api.block.function.primitive.FloatFunction;
import org.eclipse.collections.api.block.function.primitive.FloatFunction0;
import org.eclipse.collections.api.block.function.primitive.FloatToFloatFunction;
import org.eclipse.collections.api.block.function.primitive.ShortToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.api.map.primitive.MutableShortFloatMap;
import org.eclipse.collections.api.set.primitive.ShortSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortFloatMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableShortFloatMapTest extends AbstractMutableShortFloatMapTestCase
{
    private final UnmodifiableShortFloatMap map = this.classUnderTest();

    @Override
    protected UnmodifiableShortFloatMap classUnderTest()
    {
        return new UnmodifiableShortFloatMap(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f));
    }

    @Override
    protected UnmodifiableShortFloatMap newWithKeysValues(short key1, float value1)
    {
        return new UnmodifiableShortFloatMap(new ShortFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2)
    {
        return new UnmodifiableShortFloatMap(new ShortFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3)
    {
        return new UnmodifiableShortFloatMap(new ShortFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4)
    {
        return new UnmodifiableShortFloatMap(new ShortFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableShortFloatMap getEmptyMap()
    {
        return new UnmodifiableShortFloatMap(new ShortFloatHashMap());
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
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent((short) 10, 100.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent((short) 10, 100.0f), 0.0);
        this.map.removeKeyIfAbsent((short) 0, 100.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((short) 0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((short) 0, 1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((short) 0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((short) 1, 1.0f);
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
        short collision1 = AbstractMutableShortFloatMapTestCase.generateCollisions().getFirst();

        UnmodifiableShortFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get((short) 0), 0.0);
        Assert.assertEquals(31.0, this.map.get((short) 31), 0.0);
        Assert.assertEquals(32.0, this.map.get((short) 32), 0.0);
        Assert.assertEquals(0.0, this.map.get((short) 1), 0.0);
        Assert.assertEquals(0.0, this.map.get((short) 33), 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent((short) 0, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((short) 31, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((short) 32, 5.0f), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent((short) 33, 6.0f), 0.0);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow((short) 0), 0.0);
        Assert.assertEquals(31.0, this.map.getOrThrow((short) 31), 0.0);
        Assert.assertEquals(32.0, this.map.getOrThrow((short) 32), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 1));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsentPut((short) 0, 50.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((short) 10, 100.0f);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        FloatFunction0 factory = () -> 100.0f;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut((short) 0, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        FloatFunction0 factory = () -> 100.0f;

        this.map.getIfAbsentPut((short) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith((short) 0, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();

        this.map.getIfAbsentPutWith((short) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToFloatFunction function = (short shortParameter) -> (float) shortParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey((short) 0, function), 0.0);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableShortFloatMap mutableShortFloatMap = this.classUnderTest();
        ShortSet frozenSet = mutableShortFloatMap.keySet().freeze();
        ShortSet frozenSetCopy = ShortHashSet.newSetWith(mutableShortFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ShortToFloatFunction function = (short shortParameter) -> (float) shortParameter;
        this.map.getIfAbsentPutWithKey((short) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableShortFloatMap copyMap = new UnmodifiableShortFloatMap(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        this.map.updateValue((short) 0, 0.0f, incrementFunction);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertTrue(this.map.contains(31.0f));
        Assert.assertTrue(this.map.contains(32.0f));
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
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(31.0f));
        Assert.assertTrue(this.map.containsValue(32.0f));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 0, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues((short) 1, 1.0f).size());

        Assert.assertEquals(2, this.newWithKeysValues((short) 1, 1.0f, (short) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 0, 0.0f, (short) 5, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues((short) 1, 1.0f, (short) 0, 0.0f, (short) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((short) 6, 6.0f, (short) 5, 5.0f).size());
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
    public void floatIterator_with_remove()
    {
        MutableFloatIterator iterator = this.map.floatIterator();
        Assert.assertTrue(iterator.hasNext());
        iterator.next();
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableFloatIterator iterator = this.map.floatIterator();
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

        Verify.assertInstanceOf(UnmodifiableFloatShortMap.class, this.classUnderTest().flipUniqueValues());
    }
}
