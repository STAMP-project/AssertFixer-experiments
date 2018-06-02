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

import org.eclipse.collections.api.iterator.ShortIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectShortMap;
import org.eclipse.collections.api.map.primitive.ObjectShortMap;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectShortEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectShortEmptyMapTest extends AbstractImmutableObjectShortMapTestCase
{
    @Override
    protected ImmutableObjectShortMap<String> classUnderTest()
    {
        return (ImmutableObjectShortMap<String>) ImmutableObjectShortEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected = ObjectShortHashMap.newWithKeysValues("3", (short) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (short) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (short) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectShortMap<String> map1 = this.classUnderTest();
        ImmutableObjectShortMap<String> expected1 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue((short) 0));
        Assert.assertFalse(this.classUnderTest().containsValue((short) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((short) 2));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        short detect = this.classUnderTest().detectIfNone((short value) -> true, (short) 5);
        Assert.assertEquals((short) 5, detect);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("0", (short) 1));
        Assert.assertEquals((short) 2, this.classUnderTest().getIfAbsent("1", (short) 2));
        Assert.assertEquals((short) 3, this.classUnderTest().getIfAbsent("2", (short) 3));
        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent("5", (short) 1));
        Assert.assertEquals((short) 0, this.classUnderTest().getIfAbsent("5", (short) 0));

        Assert.assertEquals((short) 1, this.classUnderTest().getIfAbsent(null, (short) 1));
        Assert.assertEquals((short) 0, this.classUnderTest().getIfAbsent(null, (short) 0));
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((short) 9, this.getEmptyMap().maxIfEmpty((short) 9));
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
        Assert.assertTrue(this.classUnderTest().allSatisfy((short value) -> false));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy((short value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, short value) -> false));

        Assert.assertEquals(new ShortHashBag(), this.classUnderTest().reject((short value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, short value) -> true));

        Assert.assertEquals(new ShortHashBag(), this.classUnderTest().select((short value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void shortIterator()
    {
        ShortIterator iterator = this.classUnderTest().shortIterator();
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
        Assert.assertFalse(this.classUnderTest().contains((short) 0));
        Assert.assertFalse(this.classUnderTest().contains((short) 1));
        Assert.assertFalse(this.classUnderTest().contains((short) 2));
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
        Assert.assertEquals((short) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((short) 0, this.classUnderTest().get("1"));
        Assert.assertEquals((short) 0, this.classUnderTest().get(null));
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
        Assert.assertEquals(0L, this.classUnderTest().count((short value) -> true));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(ShortHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(ShortHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll((short) 0, (short) 1, (short) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((short) 0, (short) 1, (short) 5));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(ShortArrayList.newListWith((short) 0, (short) 1, (short) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(new ShortArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((short) 5, this.getEmptyMap().minIfEmpty((short) 5));
        Assert.assertEquals((short) 6, this.getEmptyMap().minIfEmpty((short) 6));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectShortMap<String> map1 = this.newWithKeysValues("0", (short) 0, "1", (short) 1, null, (short) 2);
        ObjectShortMap<String> map2 = this.getEmptyMap();

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
        Assert.assertTrue(this.classUnderTest().noneSatisfy((short value) -> true));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectShortEmptyMap<Object> iterable = new ImmutableObjectShortEmptyMap<>();
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), (MutableShort object, short value) -> object.add(value));
        Assert.assertEquals(new MutableShort((short) 0), result);
    }
}
