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
import org.eclipse.collections.api.map.primitive.ImmutableCharCharMap;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.CharCharMaps;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharCharEmptyMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveEmptyMapTest.stg.
 */
public class ImmutableCharCharEmptyMapTest extends AbstractImmutableCharCharMapTestCase
{
    @Override
    protected ImmutableCharCharMap classUnderTest()
    {
        return CharCharMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharCharMap map1 = this.classUnderTest();
        ImmutableCharCharMap expected = this.newWithKeysValues((char) 0, (char) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 0, (char) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 0, (char) 0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharCharMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((char) 32));
        Assert.assertSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharCharMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.map.containsValue((char) 0));
        Assert.assertFalse(this.map.containsValue((char) 31));
        Assert.assertFalse(this.map.containsValue((char) 32));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.map.contains((char) 0));
        Assert.assertFalse(this.map.contains((char) 31));
        Assert.assertFalse(this.map.contains((char) 32));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(5L, this.map.getIfAbsent((char) 0, (char) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((char) 31, (char) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((char) 32, (char) 25));
    }

    @Override
    @Test
    public void asLazy()
    {
        Verify.assertEmpty(this.map.asLazy().toList());
    }

    @Override
    @Test
    public void charIterator()
    {
        CharIterator iterator = this.map.charIterator();
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((char) 0));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((char) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((char) 0));
        Assert.assertEquals(0L, this.map.get((char) 31));
        Assert.assertEquals(0L, this.map.get((char) 32));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 32));
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 35));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.map.containsKey((char) 0));
        Assert.assertFalse(this.map.containsKey((char) 31));
        Assert.assertFalse(this.map.containsKey((char) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(CharArrayList.newListWith(), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertEquals(this.map.toSortedArray().length, 0);
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 32)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 35)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Override
    @Test
    public void isEmpty()
    {
        Assert.assertTrue(this.classUnderTest().isEmpty());
    }

    @Override
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((char value1, char value2) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((char value1, char value2) -> false));
    }

    @Override
    @Test
    public void select_value()
    {
        Assert.assertEquals(CharBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    @Test
    public void reject_value()
    {
        Assert.assertEquals(CharBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count((char value) -> true));
    }

    @Override
    @Test
    public void sum()
    {
        Assert.assertEquals(0L, this.classUnderTest().sum());
    }

    @Test
    public void injectInto()
    {
        ImmutableCharCharEmptyMap iterable = new ImmutableCharCharEmptyMap();
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 0), result);
    }
}
