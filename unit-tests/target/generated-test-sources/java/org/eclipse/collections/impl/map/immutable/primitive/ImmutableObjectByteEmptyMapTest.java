/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import java.util.NoSuchElementException;

import org.eclipse.collections.api.iterator.ByteIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.api.map.primitive.ObjectByteMap;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.eclipse.collections.impl.math.MutableByte;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectByteEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectByteEmptyMapTest extends AbstractImmutableObjectByteMapTestCase
{
    @Override
    protected ImmutableObjectByteMap<String> classUnderTest()
    {
        return (ImmutableObjectByteMap<String>) ImmutableObjectByteEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected = ObjectByteHashMap.newWithKeysValues("3", (byte) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (byte) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (byte) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.classUnderTest().containsKey("0"));
        Assert.assertFalse(this.classUnderTest().containsKey("1"));
        Assert.assertFalse(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.classUnderTest().containsValue((byte) 0));
        Assert.assertFalse(this.classUnderTest().containsValue((byte) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((byte) 2));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        byte detect = this.classUnderTest().detectIfNone((byte value) -> true, (byte) 5);
        Assert.assertEquals((byte) 5, detect);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent("0", (byte) 1));
        Assert.assertEquals((byte) 2, this.classUnderTest().getIfAbsent("1", (byte) 2));
        Assert.assertEquals((byte) 3, this.classUnderTest().getIfAbsent("2", (byte) 3));
        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent("5", (byte) 1));
        Assert.assertEquals((byte) 0, this.classUnderTest().getIfAbsent("5", (byte) 0));

        Assert.assertEquals((byte) 1, this.classUnderTest().getIfAbsent(null, (byte) 1));
        Assert.assertEquals((byte) 0, this.classUnderTest().getIfAbsent(null, (byte) 0));
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((byte) 9, this.getEmptyMap().maxIfEmpty((byte) 9));
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median()
    {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy((byte value) -> false));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy((byte value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, byte value) -> false));

        Assert.assertEquals(new ByteHashBag(), this.classUnderTest().reject((byte value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, byte value) -> true));

        Assert.assertEquals(new ByteHashBag(), this.classUnderTest().select((byte value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void byteIterator()
    {
        ByteIterator iterator = this.classUnderTest().byteIterator();
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average()
    {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains((byte) 0));
        Assert.assertFalse(this.classUnderTest().contains((byte) 1));
        Assert.assertFalse(this.classUnderTest().contains((byte) 2));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals((byte) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((byte) 0, this.classUnderTest().get("1"));
        Assert.assertEquals((byte) 0, this.classUnderTest().get(null));
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max()
    {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min()
    {
        this.classUnderTest().min();
    }

    @Override
    @Test
    public void sum()
    {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0L, this.classUnderTest().count((byte value) -> true));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(ByteHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(ByteHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll((byte) 0, (byte) 1, (byte) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((byte) 0, (byte) 1, (byte) 5));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(ByteArrayList.newListWith((byte) 0, (byte) 1, (byte) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(new ByteArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((byte) 5, this.getEmptyMap().minIfEmpty((byte) 5));
        Assert.assertEquals((byte) 6, this.getEmptyMap().minIfEmpty((byte) 6));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectByteMap<String> map1 = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1, null, (byte) 2);
        ObjectByteMap<String> map2 = this.getEmptyMap();

        Assert.assertNotEquals(this.classUnderTest(), map1);
        Verify.assertEqualsAndHashCode(this.classUnderTest(), map2);
        Verify.assertPostSerializedIdentity(this.classUnderTest());
    }

    @Override
    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().noneSatisfy((byte value) -> true));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectByteEmptyMap<Object> iterable = new ImmutableObjectByteEmptyMap<>();
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), (MutableByte object, byte value) -> object.add(value));
        Assert.assertEquals(new MutableByte((byte) 0), result);
    }
}
