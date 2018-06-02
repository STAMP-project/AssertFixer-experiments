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

import org.eclipse.collections.api.iterator.LongIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectLongEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectLongEmptyMapTest extends AbstractImmutableObjectLongMapTestCase
{
    @Override
    protected ImmutableObjectLongMap<String> classUnderTest()
    {
        return (ImmutableObjectLongMap<String>) ImmutableObjectLongEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected = ObjectLongHashMap.newWithKeysValues("3", 3L).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3L));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected1 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue(0L));
        Assert.assertFalse(this.classUnderTest().containsValue(1L));
        Assert.assertFalse(this.classUnderTest().containsValue(2L));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        long detect = this.classUnderTest().detectIfNone((long value) -> true, 5L);
        Assert.assertEquals(5L, detect);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(1L, this.classUnderTest().getIfAbsent("0", 1L));
        Assert.assertEquals(2L, this.classUnderTest().getIfAbsent("1", 2L));
        Assert.assertEquals(3L, this.classUnderTest().getIfAbsent("2", 3L));
        Assert.assertEquals(1L, this.classUnderTest().getIfAbsent("5", 1L));
        Assert.assertEquals(0L, this.classUnderTest().getIfAbsent("5", 0L));

        Assert.assertEquals(1L, this.classUnderTest().getIfAbsent(null, 1L));
        Assert.assertEquals(0L, this.classUnderTest().getIfAbsent(null, 0L));
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(9L, this.getEmptyMap().maxIfEmpty(9L));
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
        Assert.assertTrue(this.classUnderTest().allSatisfy((long value) -> false));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy((long value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, long value) -> false));

        Assert.assertEquals(new LongHashBag(), this.classUnderTest().reject((long value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, long value) -> true));

        Assert.assertEquals(new LongHashBag(), this.classUnderTest().select((long value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void longIterator()
    {
        LongIterator iterator = this.classUnderTest().longIterator();
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
        Assert.assertFalse(this.classUnderTest().contains(0L));
        Assert.assertFalse(this.classUnderTest().contains(1L));
        Assert.assertFalse(this.classUnderTest().contains(2L));
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
        Assert.assertEquals(0L, this.classUnderTest().get("0"));
        Assert.assertEquals(0L, this.classUnderTest().get("1"));
        Assert.assertEquals(0L, this.classUnderTest().get(null));
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
        Assert.assertEquals(0L, this.classUnderTest().count((long value) -> true));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(LongHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(LongHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(0L, 1L, 2L));
        Assert.assertFalse(this.classUnderTest().containsAll(0L, 1L, 5L));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(LongArrayList.newListWith(0L, 1L, 2L)));
        Assert.assertFalse(this.classUnderTest().containsAll(LongArrayList.newListWith(0L, 1L, 5L)));
        Assert.assertTrue(this.classUnderTest().containsAll(new LongArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5L, this.getEmptyMap().minIfEmpty(5L));
        Assert.assertEquals(6L, this.getEmptyMap().minIfEmpty(6L));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectLongMap<String> map1 = this.newWithKeysValues("0", 0L, "1", 1L, null, 2L);
        ObjectLongMap<String> map2 = this.getEmptyMap();

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
        Assert.assertTrue(this.classUnderTest().noneSatisfy((long value) -> true));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectLongEmptyMap<Object> iterable = new ImmutableObjectLongEmptyMap<>();
        MutableLong result = iterable.injectInto(new MutableLong(0L), (MutableLong object, long value) -> object.add(value));
        Assert.assertEquals(new MutableLong(0L), result);
    }
}
