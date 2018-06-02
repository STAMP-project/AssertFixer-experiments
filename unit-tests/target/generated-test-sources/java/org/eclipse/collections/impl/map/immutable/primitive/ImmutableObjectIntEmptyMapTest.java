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

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectIntEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectIntEmptyMapTest extends AbstractImmutableObjectIntMapTestCase
{
    @Override
    protected ImmutableObjectIntMap<String> classUnderTest()
    {
        return (ImmutableObjectIntMap<String>) ImmutableObjectIntEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected = ObjectIntHashMap.newWithKeysValues("3", 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected1 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue(0));
        Assert.assertFalse(this.classUnderTest().containsValue(1));
        Assert.assertFalse(this.classUnderTest().containsValue(2));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        int detect = this.classUnderTest().detectIfNone((int value) -> true, 5);
        Assert.assertEquals(5, detect);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("0", 1));
        Assert.assertEquals(2, this.classUnderTest().getIfAbsent("1", 2));
        Assert.assertEquals(3, this.classUnderTest().getIfAbsent("2", 3));
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("5", 1));
        Assert.assertEquals(0, this.classUnderTest().getIfAbsent("5", 0));

        Assert.assertEquals(1, this.classUnderTest().getIfAbsent(null, 1));
        Assert.assertEquals(0, this.classUnderTest().getIfAbsent(null, 0));
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(9, this.getEmptyMap().maxIfEmpty(9));
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
        Assert.assertTrue(this.classUnderTest().allSatisfy((int value) -> false));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy((int value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, int value) -> false));

        Assert.assertEquals(new IntHashBag(), this.classUnderTest().reject((int value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, int value) -> true));

        Assert.assertEquals(new IntHashBag(), this.classUnderTest().select((int value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.classUnderTest().intIterator();
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
        Assert.assertFalse(this.classUnderTest().contains(0));
        Assert.assertFalse(this.classUnderTest().contains(1));
        Assert.assertFalse(this.classUnderTest().contains(2));
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
        Assert.assertEquals(0, this.classUnderTest().get("0"));
        Assert.assertEquals(0, this.classUnderTest().get("1"));
        Assert.assertEquals(0, this.classUnderTest().get(null));
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
        Assert.assertEquals(0L, this.classUnderTest().count((int value) -> true));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(IntHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(IntHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(0, 1, 2));
        Assert.assertFalse(this.classUnderTest().containsAll(0, 1, 5));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(0, 1, 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(0, 1, 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(new IntArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5, this.getEmptyMap().minIfEmpty(5));
        Assert.assertEquals(6, this.getEmptyMap().minIfEmpty(6));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectIntMap<String> map1 = this.newWithKeysValues("0", 0, "1", 1, null, 2);
        ObjectIntMap<String> map2 = this.getEmptyMap();

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
        Assert.assertTrue(this.classUnderTest().noneSatisfy((int value) -> true));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectIntEmptyMap<Object> iterable = new ImmutableObjectIntEmptyMap<>();
        MutableInteger result = iterable.injectInto(new MutableInteger(0), (MutableInteger object, int value) -> object.add(value));
        Assert.assertEquals(new MutableInteger(0), result);
    }
}
