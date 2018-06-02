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
 * JUnit test for {@link ImmutableObjectCharSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectCharSingletonMapTest extends AbstractImmutableObjectCharMapTestCase
{
    @Override
    protected ImmutableObjectCharMap<String> classUnderTest()
    {
        return ObjectCharHashMap.newWithKeysValues("1", (char) 1).toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectCharMap<String> map1 = this.classUnderTest();
        ImmutableObjectCharMap<String> expected = ObjectCharHashMap.newWithKeysValues("1", (char) 1, "3", (char) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (char) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (char) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectCharMap<String> map1 = this.classUnderTest();
        ImmutableObjectCharMap<String> expected1 = this.newWithKeysValues("1", (char) 1);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableObjectCharMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectCharMap<String> map1 = this.classUnderTest();
        ImmutableObjectCharMap<String> expected1 = this.newWithKeysValues("1", (char) 1);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableObjectCharMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutAllKeys(FastList.newListWith("1", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("1", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.classUnderTest().containsKey("0"));
        Assert.assertTrue(this.classUnderTest().containsKey("1"));
        Assert.assertFalse(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.classUnderTest().containsValue((char) 0));
        Assert.assertTrue(this.classUnderTest().containsValue((char) 1));
        Assert.assertFalse(this.classUnderTest().containsValue((char) 2));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        char detect = this.classUnderTest().detectIfNone((char value) -> true, (char) 5);
        Assert.assertEquals((char) 1, detect);

        char detect1 = this.classUnderTest().detectIfNone((char value) -> false, (char) 5);
        Assert.assertEquals((char) 5, detect1);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().getIfAbsent("0", (char) 1));
        Assert.assertEquals((char) 1, this.classUnderTest().getIfAbsent("1", (char) 2));
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
        Assert.assertEquals((char) 1, this.classUnderTest().maxIfEmpty((char) 9));
    }

    @Override
    @Test
    public void median()
    {
        Assert.assertEquals(1.0, this.classUnderTest().median(), 0.0);
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().allSatisfy((char value) -> false));

        Assert.assertTrue(this.classUnderTest().allSatisfy((char value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, char value) -> false));

        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, char value) -> true));

        Assert.assertEquals(new CharHashBag(), this.classUnderTest().reject((char value) -> true).toBag());

        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.classUnderTest().reject((char value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, char value) -> true));

        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, char value) -> false));

        Assert.assertEquals(new CharHashBag(), this.classUnderTest().select((char value) -> false).toBag());

        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.classUnderTest().select((char value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void charIterator()
    {
        CharIterator iterator = this.classUnderTest().charIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains((char) 0));
        Assert.assertTrue(this.classUnderTest().contains((char) 1));
        Assert.assertFalse(this.classUnderTest().contains((char) 2));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().getOrThrow("1"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals((char) 0, this.classUnderTest().get("0"));
        Assert.assertEquals((char) 1, this.classUnderTest().get("1"));
        Assert.assertEquals((char) 0, this.classUnderTest().get(null));
    }

    @Override
    @Test
    public void max()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void min()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void sum()
    {
        Assert.assertEquals(1L, this.classUnderTest().sum());
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(1L, this.classUnderTest().count((char value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((char value) -> false));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(CharHashBag.newBagWith((char) 1), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(CharHashSet.newSetWith((char) 1), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll((char) 0, (char) 1, (char) 2));
        Assert.assertFalse(this.classUnderTest().containsAll((char) 0, (char) 1, (char) 5));
        Assert.assertTrue(this.classUnderTest().containsAll((char) 1));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 0, (char) 1, (char) 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(CharArrayList.newListWith((char) 1)));
        Assert.assertTrue(this.classUnderTest().containsAll(new CharArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals((char) 1, this.classUnderTest().minIfEmpty((char) 6));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectCharMap<String> map1 = this.newWithKeysValues("1", (char) 1);
        ObjectCharMap<String> map2 = this.newWithKeysValues("0", (char) 0);
        ObjectCharMap<String> map3 = this.newWithKeysValues("0", (char) 0, "1", (char) 1);

        Assert.assertNotEquals(this.classUnderTest(), map3);
        Assert.assertNotEquals(this.classUnderTest(), map2);
        Verify.assertEqualsAndHashCode(this.classUnderTest(), map1);
        Verify.assertPostSerializedEqualsAndHashCode(this.classUnderTest());
    }

    @Override
    @Test
    public void isEmpty()
    {
        Verify.assertNotEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertTrue(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().noneSatisfy((char value) -> true));

        Assert.assertTrue(this.classUnderTest().noneSatisfy((char value) -> false));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectCharSingletonMap<String> iterable = new ImmutableObjectCharSingletonMap<>("1", (char) 1);
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 1), (MutableCharacter object, char value) -> object.add(value));
        Assert.assertEquals(new MutableCharacter((char) 2), result);
    }
}
