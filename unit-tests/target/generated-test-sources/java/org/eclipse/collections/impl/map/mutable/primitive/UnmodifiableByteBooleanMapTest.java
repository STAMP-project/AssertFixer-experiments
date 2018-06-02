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

import org.eclipse.collections.api.block.function.primitive.BooleanFunction;
import org.eclipse.collections.api.block.function.primitive.BooleanFunction0;
import org.eclipse.collections.api.block.function.primitive.BooleanToBooleanFunction;
import org.eclipse.collections.api.block.function.primitive.ByteToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableByteBooleanMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapTest.stg.
 */
public class UnmodifiableByteBooleanMapTest extends AbstractMutableByteBooleanMapTestCase
{
    @Override
    protected UnmodifiableByteBooleanMap classUnderTest()
    {
        return new UnmodifiableByteBooleanMap(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true));
    }

    @Override
    protected UnmodifiableByteBooleanMap newWithKeysValues(byte key1, boolean value1)
    {
        return new UnmodifiableByteBooleanMap(new ByteBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2)
    {
        return new UnmodifiableByteBooleanMap(new ByteBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3)
    {
        return new UnmodifiableByteBooleanMap(new ByteBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4)
    {
        return new UnmodifiableByteBooleanMap(new ByteBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableByteBooleanMap getEmptyMap()
    {
        return new UnmodifiableByteBooleanMap(new ByteBooleanHashMap());
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void clear()
    {
        this.classUnderTest().clear();
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void removeKey()
    {
        this.classUnderTest().removeKey((byte) 5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().removeKeyIfAbsent((byte) 10, true));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        this.classUnderTest().removeKeyIfAbsent((byte) 0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.classUnderTest().put((byte) 0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.classUnderTest().withKeyValue((byte) 1, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.classUnderTest().withoutKey((byte) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.classUnderTest().withoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        byte collision1 = AbstractMutableByteBooleanMapTestCase.generateCollisions().getFirst();

        UnmodifiableByteBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get((byte) 0));
        Assert.assertFalse(this.classUnderTest().get((byte) 31));
        Assert.assertTrue(this.classUnderTest().get((byte) 32));

        Assert.assertFalse(this.classUnderTest().get((byte) 1));
        Assert.assertFalse(this.classUnderTest().get((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((byte) 31, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 32, false));

        Assert.assertFalse(this.classUnderTest().getIfAbsent((byte) 1, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((byte) 1, true));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertTrue(this.classUnderTest().getOrThrow((byte) 0));
        Assert.assertFalse(this.classUnderTest().getOrThrow((byte) 31));
        Assert.assertTrue(this.classUnderTest().getOrThrow((byte) 32));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((byte) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsentPut((byte) 0, false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.classUnderTest().getIfAbsentPut((byte) 10, true);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        BooleanFunction0 factory = () -> true;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPut((byte) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        BooleanFunction0 factory = () -> true;

        this.classUnderTest().getIfAbsentPut((byte) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (byte) 0;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPutWith((byte) 0, functionLengthEven, "12345678"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (byte) 0;

        this.classUnderTest().getIfAbsentPutWith((byte) 10, functionLengthEven, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ByteToBooleanFunction keyIsEven = (byte parameter) -> (parameter & 1) == (byte) 0;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPutWithKey((byte) 0, keyIsEven));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ByteToBooleanFunction keyIsEven = (byte parameter) -> (parameter & 1) == (byte) 0;

        this.classUnderTest().getIfAbsentPutWithKey((byte) 10, keyIsEven);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        BooleanToBooleanFunction flip = (boolean value) -> !value;

        this.classUnderTest().updateValue((byte) 0, false, flip);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertTrue(this.classUnderTest().contains(false));
        Assert.assertFalse(this.getEmptyMap().contains(false));
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 0));
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 31));
        Assert.assertTrue(this.classUnderTest().containsKey((byte) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((byte) 35));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertTrue(this.classUnderTest().containsValue(false));
        Assert.assertFalse(this.getEmptyMap().containsValue(false));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(true, false));
        Assert.assertTrue(this.classUnderTest().containsAll(true, true));
        Assert.assertTrue(this.classUnderTest().containsAll(false, false));
        Assert.assertFalse(this.getEmptyMap().containsAll(false, true));
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, true)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false, false)));
        Assert.assertFalse(this.getEmptyMap().containsAll(BooleanArrayList.newListWith(false, false)));
    }

    @Override
    @Test
    public void size()
    {
        Verify.assertSize(0, this.getEmptyMap());
        Verify.assertSize(1, this.newWithKeysValues((byte) 0, false));
        Verify.assertSize(1, this.newWithKeysValues((byte) 1, true));
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        UnmodifiableByteBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asUnmodifiable());
    }

    @Override
    @Test
    public void booleanIterator_with_remove()
    {
        MutableBooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_invocation_of_remove_before_next()
    {
        MutableBooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Verify.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }

    @Override
    @Test
    public void iterator_throws_on_consecutive_invocation_of_remove()
    {
        // Not applicable for Unmodifiable*
    }
}
