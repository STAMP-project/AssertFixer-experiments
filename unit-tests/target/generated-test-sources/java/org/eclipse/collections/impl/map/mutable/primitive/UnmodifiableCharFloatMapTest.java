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
import org.eclipse.collections.api.block.function.primitive.CharToFloatFunction;
import org.eclipse.collections.api.iterator.MutableFloatIterator;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.api.map.primitive.MutableCharFloatMap;
import org.eclipse.collections.api.set.primitive.CharSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableCharFloatMap}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapTest.stg.
 */
public class UnmodifiableCharFloatMapTest extends AbstractMutableCharFloatMapTestCase
{
    private final UnmodifiableCharFloatMap map = this.classUnderTest();

    @Override
    protected UnmodifiableCharFloatMap classUnderTest()
    {
        return new UnmodifiableCharFloatMap(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f));
    }

    @Override
    protected UnmodifiableCharFloatMap newWithKeysValues(char key1, float value1)
    {
        return new UnmodifiableCharFloatMap(new CharFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2)
    {
        return new UnmodifiableCharFloatMap(new CharFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3)
    {
        return new UnmodifiableCharFloatMap(new CharFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3, char key4, float value4)
    {
        return new UnmodifiableCharFloatMap(new CharFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableCharFloatMap getEmptyMap()
    {
        return new UnmodifiableCharFloatMap(new CharFloatHashMap());
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
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent((char) 10, 100.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        Assert.assertEquals(100.0f, this.map.removeKeyIfAbsent((char) 10, 100.0f), 0.0);
        this.map.removeKeyIfAbsent((char) 0, 100.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.map.put((char) 0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putPair()
    {
        this.map.putPair(PrimitiveTuples.pair((char) 0, 1.0f));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void addToValue()
    {
        this.map.addToValue((char) 0, 1.0f);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.map.withKeyValue((char) 1, 1.0f);
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
        char collision1 = AbstractMutableCharFloatMapTestCase.generateCollisions().getFirst();

        UnmodifiableCharFloatMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, 1.0f);
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
        Assert.assertEquals(0.0, this.map.getIfAbsent((char) 0, 5.0f), 0.0);
        Assert.assertEquals(31.0, this.map.getIfAbsent((char) 31, 5.0f), 0.0);
        Assert.assertEquals(32.0, this.map.getIfAbsent((char) 32, 5.0f), 0.0);
        Assert.assertEquals(6.0, this.map.getIfAbsent((char) 33, 6.0f), 0.0);
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
        Assert.assertEquals(0.0, this.map.getIfAbsentPut((char) 0, 50.0f), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.map.getIfAbsentPut((char) 10, 100.0f);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        FloatFunction0 factory = () -> 100.0f;

        Assert.assertEquals(0.0, this.map.getIfAbsentPut((char) 0, factory), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        FloatFunction0 factory = () -> 100.0f;

        this.map.getIfAbsentPut((char) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();

        Assert.assertEquals(0.0, this.map.getIfAbsentPutWith((char) 0, functionLength, "123456789"), 0.0);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        FloatFunction<String> functionLength = (String string) -> (float) string.length();

        this.map.getIfAbsentPutWith((char) 10, functionLength, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        CharToFloatFunction function = (char charParameter) -> (float) charParameter;
        Assert.assertEquals(0.0, this.map.getIfAbsentPutWithKey((char) 0, function), 0.0);
    }

    @Override
    @Test
    public void freeze()
    {
        MutableCharFloatMap mutableCharFloatMap = this.classUnderTest();
        CharSet frozenSet = mutableCharFloatMap.keySet().freeze();
        CharSet frozenSetCopy = CharHashSet.newSetWith(mutableCharFloatMap.keySet().toArray());
        Assert.assertEquals(frozenSet, frozenSetCopy);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        CharToFloatFunction function = (char charParameter) -> (float) charParameter;
        this.map.getIfAbsentPutWithKey((char) 10, function);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void putAllThrowsException()
    {
        UnmodifiableCharFloatMap copyMap = new UnmodifiableCharFloatMap(CharFloatHashMap.newWithKeysValues((char) 0, 0.0f, (char) 31, 31.0f, (char) 32, 32.0f));
        this.map.putAll(copyMap);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        FloatToFloatFunction incrementFunction = (float value) -> value + 1.0f;
        this.map.updateValue((char) 0, 0.0f, incrementFunction);
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
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertTrue(this.map.containsValue(31.0f));
        Assert.assertTrue(this.map.containsValue(32.0f));
    }

    @Override
    @Test
    public void size()
    {
        Assert.assertEquals(0, this.getEmptyMap().size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 0, 0.0f).size());
        Assert.assertEquals(1, this.newWithKeysValues((char) 1, 1.0f).size());

        Assert.assertEquals(2, this.newWithKeysValues((char) 1, 1.0f, (char) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 0, 0.0f, (char) 5, 5.0f).size());
        Assert.assertEquals(3, this.newWithKeysValues((char) 1, 1.0f, (char) 0, 0.0f, (char) 5, 5.0f).size());
        Assert.assertEquals(2, this.newWithKeysValues((char) 6, 6.0f, (char) 5, 5.0f).size());
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

        Verify.assertInstanceOf(UnmodifiableFloatCharMap.class, this.classUnderTest().flipUniqueValues());
    }
}
