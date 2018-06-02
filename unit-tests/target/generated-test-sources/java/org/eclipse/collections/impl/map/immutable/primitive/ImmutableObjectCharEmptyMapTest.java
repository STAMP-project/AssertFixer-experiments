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

import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectCharMap;
import org.eclipse.collections.api.map.primitive.ObjectCharMap;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectCharEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectCharEmptyMapTest extends AbstractImmutableObjectCharMapTestCase
{
    @Override
    protected ImmutableObjectCharMap<String> classUnderTest()
    {
        return (ImmutableObjectCharMap<String>) ImmutableObjectCharEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectCharMap<String> map1 = this.classUnderTest();
        ImmutableObjectCharMap<String> expected = ObjectCharHashMap.newWithKeysValues("3", (char) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (char) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (char) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectCharMap<String> map1 = this.classUnderTest();
        ImmutableObjectCharMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectCharMap<String> map1 = this.classUnderTest();
        ImmutableObjectCharMap<String> expected1 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue((char) 0));
        Assert.assertFalse(this.classUnderTest().containsValue((char) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((char) 2));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        char detect = this.classUnderTest().detectIfNone((char value) -> true, (char) 5);
        Assert.assertEquals((char) 5, detect);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().getIfAbsent("0", (char) 1));
        Assert.assertEquals((char) 2, this.classUnderTest().getIfAbsent("1", (char) 2));
        Assert.assertEquals((char) 3, this.classUnderTest().getIfAbsent("2", (char) 3));
        Assert.assertEquals((char) 1, this.classUnderTest().getIfAbsent("5", (char) 1));
        Assert.assertEquals((char) 0, this.classUnderTest().getIfAbsent("5", (char) 0));

        Assert.assertEquals((char) 1, this.classUnderTest().getIfAbsent(null, (char) 1));
        Assert.assertEquals((char) 0, this.classUnderTest().getIfAbsent(null, (char) 0));
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals((char) 9, this.getEmptyMap().maxIfEmpty((char) 9));
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
        Assert.assertTrue(this.classUnderTest().allSatisfy((char value) -> false));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy((char value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, char value) -> false));

        Assert.assertEquals(new CharHashBag(), this.classUnderTest().reject((char value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, char value) -> true));

        Assert.assertEquals(new CharHashBag(), this.classUnderTest().select((char value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void charIterator()
    {
        CharIterator iterator = this.classUnderTest().charIterator();
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
        Assert.assertFalse(this.classUnderTest().contains((char) 0));
        Assert.assertFalse(this.classUnderTest().contains((char) 1));
        Assert.assertFalse(this.classUnderTest().contains((char) 2));
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
        Assert.assertEquals((char) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((char) 0, this.classUnderTest().get("1"));
        Assert.assertEquals((char) 0, this.classUnderTest().get(null));
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
        Assert.assertEquals(0L, this.classUnderTest().count((char value) -> true));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll((char) 0, (char) 1, (char) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((char) 0, (char) 1, (char) 5));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(new CharArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((char) 5, this.getEmptyMap().minIfEmpty((char) 5));
        Assert.assertEquals((char) 6, this.getEmptyMap().minIfEmpty((char) 6));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectCharMap<String> map1 = this.newWithKeysValues("0", (char) 0, "1", (char) 1, null, (char) 2);
        ObjectCharMap<String> map2 = this.getEmptyMap();

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
        Assert.assertTrue(this.classUnderTest().noneSatisfy((char value) -> true));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectCharEmptyMap<Object> iterable = new ImmutableObjectCharEmptyMap<>();
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), (MutableCharacter object, char value) -> object.add(value));
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }
}
