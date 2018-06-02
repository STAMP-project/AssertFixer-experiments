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
import org.eclipse.collections.api.block.function.primitive.DoubleToBooleanFunction;
import org.eclipse.collections.api.iterator.MutableBooleanIterator;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableDoubleBooleanMap}.
 * This file was automatically generated from template file unmodifiablePrimitiveBooleanMapTest.stg.
 */
public class UnmodifiableDoubleBooleanMapTest extends AbstractMutableDoubleBooleanMapTestCase
{
    @Override
    protected UnmodifiableDoubleBooleanMap classUnderTest()
    {
        return new UnmodifiableDoubleBooleanMap(DoubleBooleanHashMap.newWithKeysValues(0.0, true, 31.0, false, 32.0, true));
    }

    @Override
    protected UnmodifiableDoubleBooleanMap newWithKeysValues(double key1, boolean value1)
    {
        return new UnmodifiableDoubleBooleanMap(new DoubleBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected UnmodifiableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2)
    {
        return new UnmodifiableDoubleBooleanMap(new DoubleBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected UnmodifiableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3)
    {
        return new UnmodifiableDoubleBooleanMap(new DoubleBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected UnmodifiableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3, double key4, boolean value4)
    {
        return new UnmodifiableDoubleBooleanMap(new DoubleBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected UnmodifiableDoubleBooleanMap getEmptyMap()
    {
        return new UnmodifiableDoubleBooleanMap(new DoubleBooleanHashMap());
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
        this.classUnderTest().removeKey(5.0);
    }

    @Override
    @Test
    public void removeKeyIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().removeKeyIfAbsent(10.0, true));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void removeKeyIfAbsentThrowsException()
    {
        this.classUnderTest().removeKeyIfAbsent(0.0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void put()
    {
        this.classUnderTest().put(0.0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withKeysValues()
    {
        this.classUnderTest().withKeyValue(1.0, true);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutKey()
    {
        this.classUnderTest().withoutKey(32.0);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void withoutAllKeys()
    {
        this.classUnderTest().withoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0));
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void putDuplicateWithRemovedSlot()
    {
        double collision1 = AbstractMutableDoubleBooleanMapTestCase.generateCollisions().getFirst();

        UnmodifiableDoubleBooleanMap hashMap = this.getEmptyMap();
        hashMap.put(collision1, true);
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get(0.0));
        Assert.assertFalse(this.classUnderTest().get(31.0));
        Assert.assertTrue(this.classUnderTest().get(32.0));

        Assert.assertFalse(this.classUnderTest().get(1.0));
        Assert.assertFalse(this.classUnderTest().get(33.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0.0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(31.0, true));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(32.0, false));

        Assert.assertFalse(this.classUnderTest().getIfAbsent(1.0, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(1.0, true));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertTrue(this.classUnderTest().getOrThrow(0.0));
        Assert.assertFalse(this.classUnderTest().getOrThrow(31.0));
        Assert.assertTrue(this.classUnderTest().getOrThrow(32.0));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(33.0));
    }

    @Override
    @Test
    public void getIfAbsentPut()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsentPut(0.0, false));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutThrowsException()
    {
        this.classUnderTest().getIfAbsentPut(10.0, true);
    }

    @Override
    @Test
    public void getIfAbsentPut_Function()
    {
        BooleanFunction0 factory = () -> true;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPut(0.0, factory));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPut_FunctionThrowsException()
    {
        BooleanFunction0 factory = () -> true;

        this.classUnderTest().getIfAbsentPut(10.0, factory);
    }

    @Override
    @Test
    public void getIfAbsentPutWith()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == 0.0;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPutWith(0.0, functionLengthEven, "12345678"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithThrowsException()
    {
        BooleanFunction<String> functionLengthEven = (String string) -> (string.length() & 1) == 0.0;

        this.classUnderTest().getIfAbsentPutWith(10.0, functionLengthEven, "unused");
    }

    @Override
    @Test
    public void getIfAbsentPutWithKey()
    {
        DoubleToBooleanFunction keyIsEven = (double parameter) -> ((int) parameter & 1) == 0.0;

        Assert.assertTrue(this.classUnderTest().getIfAbsentPutWithKey(0.0, keyIsEven));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getIfAbsentPutWithKeyThrowsException()
    {
        DoubleToBooleanFunction keyIsEven = (double parameter) -> ((int) parameter & 1) == 0.0;

        this.classUnderTest().getIfAbsentPutWithKey(10.0, keyIsEven);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void updateValue()
    {
        BooleanToBooleanFunction flip = (boolean value) -> !value;

        this.classUnderTest().updateValue(0.0, false, flip);
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
        Assert.assertTrue(this.classUnderTest().containsKey(0.0));
        Assert.assertTrue(this.classUnderTest().containsKey(31.0));
        Assert.assertTrue(this.classUnderTest().containsKey(32.0));
        Assert.assertFalse(this.classUnderTest().containsKey(1.0));
        Assert.assertFalse(this.classUnderTest().containsKey(5.0));
        Assert.assertFalse(this.classUnderTest().containsKey(35.0));
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
        Verify.assertSize(1, this.newWithKeysValues(0.0, false));
        Verify.assertSize(1, this.newWithKeysValues(1.0, true));
        Verify.assertSize(3, this.classUnderTest());
    }

    @Override
    @Test
    public void asUnmodifiable()
    {
        super.asUnmodifiable();
        UnmodifiableDoubleBooleanMap map1 = this.classUnderTest();
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
