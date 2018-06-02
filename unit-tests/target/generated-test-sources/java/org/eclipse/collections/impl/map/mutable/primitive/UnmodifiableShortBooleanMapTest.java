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
import org.eclipse.collections.api.block.function.primitive.ShortToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableShortBooleanMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapTest.stg.
 */
public class UnmodifiableShortBooleanMapTest extends AbstractMutableShortBooleanMapTestCase
{
    @Override
    protected UnmodifiableShortBooleanMap classUnderTest()
    {
        return new UnmodifiableShortBooleanMap(ShortBooleanHashMap.newWithKeysValues((short) 0, true, (short) 31, false, (short) 32, true));
    }

    @Override
    protected UnmodifiableShortBooleanMap newWithKeysValues(short key1, boolean value1)
    {
        return new UnmodifiableShortBooleanMap(new ShortBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2)
    {
        return new UnmodifiableShortBooleanMap(new ShortBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3)
    {
        return new UnmodifiableShortBooleanMap(new ShortBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableShortBooleanMap newWithKeysValues(short key1, boolean value1, short key2, boolean value2, short key3, boolean value3, short key4, boolean value4)
    {
        return new UnmodifiableShortBooleanMap(new ShortBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableShortBooleanMap getEmptyMap()
    {
        return new UnmodifiableShortBooleanMap(new ShortBooleanHashMap());
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
        this.classUnderTest().removeKey((short) 5);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().removeKeyIfAbsent((short) 10, true));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        this.classUnderTest().removeKeyIfAbsent((short) 0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.classUnderTest().put((short) 0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.classUnderTest().withKeyValue((short) 1, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.classUnderTest().withoutKey((short) 32);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.classUnderTest().withoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        short collision1 = AbstractMutableShortBooleanMapTestCase.generateCollisions().getFirst();

        UnmodifiableShortBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get((short) 0));
        Assert.assertFalse(this.classUnderTest().get((short) 31));
        Assert.assertTrue(this.classUnderTest().get((short) 32));

        Assert.assertFalse(this.classUnderTest().get((short) 1));
        Assert.assertFalse(this.classUnderTest().get((short) 33));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((short) 0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((short) 31, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((short) 32, false));

        Assert.assertFalse(this.classUnderTest().getIfAbsent((short) 1, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((short) 1, true));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertTrue(this.classUnderTest().getOrThrow((short) 0));
        Assert.assertFalse(this.classUnderTest().getOrThrow((short) 31));
        Assert.assertTrue(this.classUnderTest().getOrThrow((short) 32));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((short) 33));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsentPut((short) 0, false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.classUnderTest().getIfAbsentPut((short) 10, true);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        BooleanFunction0 factory = () -> true;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPut((short) 0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        BooleanFunction0 factory = () -> true;

        this.classUnderTest().getIfAbsentPut((short) 10, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (short) 0;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPutWith((short) 0, functionLengthEven, "12345678"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == (short) 0;

        this.classUnderTest().getIfAbsentPutWith((short) 10, functionLengthEven, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        ShortToBooleanFunction keyIsEven = (short parameter) -> (parameter & 1) == (short) 0;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPutWithKey((short) 0, keyIsEven));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        ShortToBooleanFunction keyIsEven = (short parameter) -> (parameter & 1) == (short) 0;

        this.classUnderTest().getIfAbsentPutWithKey((short) 10, keyIsEven);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        BooleanToBooleanFunction flip = (boolean value) -> !value;

        this.classUnderTest().updateValue((short) 0, false, flip);
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
        Assert.assertTrue(this.classUnderTest().containsKey((short) 0));
        Assert.assertTrue(this.classUnderTest().containsKey((short) 31));
        Assert.assertTrue(this.classUnderTest().containsKey((short) 32));
        Assert.assertFalse(this.classUnderTest().containsKey((short) 1));
        Assert.assertFalse(this.classUnderTest().containsKey((short) 5));
        Assert.assertFalse(this.classUnderTest().containsKey((short) 35));
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
        Verify.assertSize(1, this.newWithKeysValues((short) 0, false));
        Verify.assertSize(1, this.newWithKeysValues((short) 1, true));
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        UnmodifiableShortBooleanMap map1 = this.classUnderTest();
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
