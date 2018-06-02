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

import org.eclipse.collections.api.iterator.BooleanIterator;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleBooleanMap;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.DoubleBooleanMaps;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleBooleanEmptyMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanEmptyMapTest.stg.
 */
public class ImmutableDoubleBooleanEmptyMapTest extends AbstractImmutableDoubleBooleanMapTestCase
{
    @Override
    protected ImmutableDoubleBooleanMap classUnderTest()
    {
        return DoubleBooleanMaps.immutable.with();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        ImmutableDoubleBooleanMap expected = this.newWithKeysValues(0.0, true);
        Assert.assertEquals(expected, map1.newWithKeyValue(0.0, true));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0.0, true));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0));
        Assert.assertSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.classUnderTest().containsValue(true));
        Assert.assertFalse(this.classUnderTest().containsValue(false));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains(true));
        Assert.assertFalse(this.classUnderTest().contains(false));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0.0, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(31.0, false));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(32.0, false));
    }

    @Override
    @Test
    public void asLazy()
    {
        Verify.assertEmpty(this.classUnderTest().asLazy().toList());
    }

    @Override
    @Test
    public void booleanIterator()
    {
        BooleanIterator iterator = this.classUnderTest().booleanIterator();
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(0.0));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(32.0));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertFalse(this.classUnderTest().get(0.0));
        Assert.assertFalse(this.classUnderTest().get(31.0));
        Assert.assertFalse(this.classUnderTest().get(32.0));
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(true, false));
        Assert.assertFalse(this.classUnderTest().containsAll(false));
        Assert.assertFalse(this.classUnderTest().containsAll(true));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.classUnderTest().containsKey(0.0));
        Assert.assertFalse(this.classUnderTest().containsKey(31.0));
        Assert.assertFalse(this.classUnderTest().containsKey(32.0));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(), this.classUnderTest().keysView().toSortedList());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void containsAllIterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true, false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(false)));
        Assert.assertFalse(this.classUnderTest().containsAll(BooleanArrayList.newListWith(true)));
        Assert.assertTrue(this.classUnderTest().containsAll(new BooleanArrayList()));
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy(BooleanPredicates.and(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().noneSatisfy(BooleanPredicates.or(BooleanPredicates.isTrue(), BooleanPredicates.isFalse())));
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
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((key, value) -> true));
    }

    @Override
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((key, value) -> false));
    }

    @Override
    public void select_value()
    {
        Assert.assertEquals(BooleanBags.immutable.empty(), this.classUnderTest().select(value -> true));
    }

    @Override
    public void reject_value()
    {
        Assert.assertEquals(BooleanBags.immutable.empty(), this.classUnderTest().reject(value -> false));
    }

    @Override
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(value -> true));
    }
}
