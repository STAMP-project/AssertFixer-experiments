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

import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.map.primitive.CharBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableCharBooleanMap;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.CharBooleanMaps;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharBooleanHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharBooleanSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanSingletonMapTest.stg.
 */
public class ImmutableCharBooleanSingletonMapTest extends AbstractImmutableCharBooleanMapTestCase
{
    @Override
    protected ImmutableCharBooleanMap classUnderTest()
    {
        return CharBooleanMaps.immutable.with((char) 0, true);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharBooleanMap map1 = this.classUnderTest();
        ImmutableCharBooleanMap expected = this.newWithKeysValues((char) 0, true, (char) 1, true);
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 1, true));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 1, true));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((char) 32));
        Assert.assertSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableCharBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((char) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((char) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableCharBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(CharArrayList.newListWith((char) 31, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.classUnderTest().containsValue(true));
        Assert.assertFalse(this.classUnderTest().containsValue(false));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.classUnderTest().contains(true));
        Assert.assertFalse(this.classUnderTest().contains(false));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent((char) 0, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent((char) 31, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent((char) 32, false));
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(BooleanArrayList.newListWith(true), this.classUnderTest().asLazy().toList());
    }

    @Override
    @Test
    public void booleanIterator()
    {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertTrue(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertTrue(this.classUnderTest().getOrThrow((char) 0));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((char) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow((char) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get((char) 0));
        Assert.assertFalse(this.classUnderTest().get((char) 31));
        Assert.assertFalse(this.classUnderTest().get((char) 32));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(true, false));
        Assert.assertFalse(this.classUnderTest().containsAll(false));
        Assert.assertTrue(this.classUnderTest().containsAll(true));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.classUnderTest().containsKey((char) 0));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 31));
        Assert.assertFalse(this.classUnderTest().containsKey((char) 32));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(CharArrayList.newListWith((char) 0), this.classUnderTest().keysView().toSortedList());
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertTrue(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertTrue(this.classUnderTest().anySatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.isTrue()));
        Assert.assertFalse(this.classUnderTest().allSatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertFalse(this.classUnderTest().noneSatisfy(BooleanPredicates.isTrue()));
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.isFalse()));
    }

    @Override
    @Test
    public void select()
    {
        CharBooleanMap actual1 = this.classUnderTest().select((char key, boolean value) -> key == (char) 0);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), actual1);
        CharBooleanMap actual2 = this.classUnderTest().select((char key, boolean value) -> key == (char) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        CharBooleanMap actual1 = this.classUnderTest().reject((char key, boolean value) -> key == (char) 1);
        Assert.assertEquals(CharBooleanHashMap.newWithKeysValues((char) 0, true), actual1);
        CharBooleanMap actual2 = this.classUnderTest().reject((char key, boolean value) -> key == (char) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        BooleanIterable actual1 = this.classUnderTest().select(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.empty(), actual1);

        BooleanIterable actual2 = this.classUnderTest().select(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.with(true), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        BooleanIterable actual1 = this.classUnderTest().reject(BooleanPredicates.isTrue());
        Assert.assertEquals(BooleanBags.immutable.empty(), actual1);

        BooleanIterable actual2 = this.classUnderTest().reject(BooleanPredicates.isFalse());
        Assert.assertEquals(BooleanBags.immutable.with(true), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(BooleanPredicates.isFalse()));
        Assert.assertEquals(1, this.classUnderTest().count(BooleanPredicates.isTrue()));
    }
}
