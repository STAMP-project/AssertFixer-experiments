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

import java.util.Arrays;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.iterator.CharIterator;
import org.eclipse.collections.api.map.primitive.ShortCharMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortCharMap;
import org.eclipse.collections.impl.block.factory.primitive.CharPredicates;
import org.eclipse.collections.impl.factory.primitive.ShortCharMaps;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortCharSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableShortCharSingletonMapTest extends AbstractImmutableShortCharMapTestCase
{
    @Override
    protected ImmutableShortCharMap classUnderTest()
    {
        return ShortCharMaps.immutable.with((short) 0, (char) 0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortCharMap map1 = this.classUnderTest();
        ImmutableShortCharMap expected = this.newWithKeysValues((short) 0, (char) 0);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, (char) 0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, (char) 0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortCharMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortCharMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((short) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((short) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortCharMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortCharMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(ShortArrayList.newListWith((short) 31, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue((char) 0));
        Assert.assertFalse(this.map.containsValue((char) 31));
        Assert.assertFalse(this.map.containsValue((char) 32));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains((char) 0));
        Assert.assertFalse(this.map.contains((char) 31));
        Assert.assertFalse(this.map.contains((char) 32));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0L, this.map.getIfAbsent((short) 0, (char) 5));
        Assert.assertEquals(15L, this.map.getIfAbsent((short) 31, (char) 15));
        Assert.assertEquals(25L, this.map.getIfAbsent((short) 32, (char) 25));
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void charIterator()
    {
        CharIterator iterator = this.map.charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0L, this.map.getOrThrow((short) 0));

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0L, this.map.get((short) 0));
        Assert.assertEquals(0L, this.map.get((short) 31));
        Assert.assertEquals(0L, this.map.get((short) 32));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.map.containsAll((char) 0, (char) 31, (char) 32));
        Assert.assertFalse(this.map.containsAll((char) 31, (char) 35));
        Assert.assertTrue(this.map.containsAll((char) 0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey((short) 0));
        Assert.assertFalse(this.map.containsKey((short) 31));
        Assert.assertFalse(this.map.containsKey((short) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(ShortArrayList.newListWith((short) 0), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new char[]{(char) 0}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 32)));
        Assert.assertFalse(this.map.containsAll(CharArrayList.newListWith((char) 0, (char) 31, (char) 35)));
        Assert.assertTrue(this.map.containsAll(CharArrayList.newListWith((char) 0)));
        Assert.assertTrue(this.map.containsAll(new CharArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        ShortCharMap actual1 = this.classUnderTest().select((short key, char value) -> key == (short) 0);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0), actual1);
        ShortCharMap actual2 = this.classUnderTest().select((short key, char value) -> key == (short) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        ShortCharMap actual1 = this.classUnderTest().reject((short key, char value) -> key == (short) 1);
        Assert.assertEquals(ShortCharHashMap.newWithKeysValues((short) 0, (char) 0), actual1);
        ShortCharMap actual2 = this.classUnderTest().reject((short key, char value) -> key == (short) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        CharIterable actual1 = this.classUnderTest().select(CharPredicates.equal((char) 1));
        Assert.assertEquals(CharBags.immutable.empty(), actual1);

        CharIterable actual2 = this.classUnderTest().select(CharPredicates.equal((char) 0));
        Assert.assertEquals(CharBags.immutable.with((char) 0), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        CharIterable actual1 = this.classUnderTest().reject(CharPredicates.equal((char) 0));
        Assert.assertEquals(CharBags.immutable.empty(), actual1);

        CharIterable actual2 = this.classUnderTest().reject(CharPredicates.equal((char) 1));
        Assert.assertEquals(CharBags.immutable.with((char) 0), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(CharPredicates.equal((char) 1)));
        Assert.assertEquals(1, this.classUnderTest().count(CharPredicates.equal((char) 0)));
    }

    @Test
    public void injectInto()
    {
        ImmutableShortCharSingletonMap iterable = new ImmutableShortCharSingletonMap((short) 1, (char) 1);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 1), result);
    }
}
