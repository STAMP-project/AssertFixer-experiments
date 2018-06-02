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
import org.eclipse.collections.api.map.primitive.FloatBooleanMap;
import org.eclipse.collections.api.map.primitive.ImmutableFloatBooleanMap;
import org.eclipse.collections.impl.block.factory.primitive.BooleanPredicates;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.FloatBooleanMaps;
import org.eclipse.collections.impl.list.mutable.primitive.BooleanArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatBooleanHashMap;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatBooleanSingletonMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanSingletonMapTest.stg.
 */
public class ImmutableFloatBooleanSingletonMapTest extends AbstractImmutableFloatBooleanMapTestCase
{
    @Override
    protected ImmutableFloatBooleanMap classUnderTest()
    {
        return FloatBooleanMaps.immutable.with(0.0f, true);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        ImmutableFloatBooleanMap expected = this.newWithKeysValues(0.0f, true, 1.0f, true);
        Assert.assertEquals(expected, map1.newWithKeyValue(1.0f, true));
        Assert.assertNotSame(map1, map1.newWithKeyValue(1.0f, true));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32.0f));
        Assert.assertSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableFloatBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0.0f));
        Assert.assertNotSame(map2, map2.newWithoutKey(0.0f));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableFloatBooleanMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(FloatArrayList.newListWith(31.0f, 32.0f)));
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
        Assert.assertTrue(this.classUnderTest().getIfAbsent(0.0f, false));
        Assert.assertTrue(this.classUnderTest().getIfAbsent(31.0f, true));
        Assert.assertFalse(this.classUnderTest().getIfAbsent(32.0f, false));
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
        Assert.assertTrue(this.classUnderTest().getOrThrow(0.0f));

        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(31.0f));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(32.0f));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertTrue(this.classUnderTest().get(0.0f));
        Assert.assertFalse(this.classUnderTest().get(31.0f));
        Assert.assertFalse(this.classUnderTest().get(32.0f));
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
        Assert.assertTrue(this.classUnderTest().containsKey(0.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(31.0f));
        Assert.assertFalse(this.classUnderTest().containsKey(32.0f));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.classUnderTest().keysView().toSortedList());
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
        FloatBooleanMap actual1 = this.classUnderTest().select((float key, boolean value) -> Float.compare(key, 0.0f) == 0);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(0.0f, true), actual1);
        FloatBooleanMap actual2 = this.classUnderTest().select((float key, boolean value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        FloatBooleanMap actual1 = this.classUnderTest().reject((float key, boolean value) -> Float.compare(key, 1.0f) == 0);
        Assert.assertEquals(FloatBooleanHashMap.newWithKeysValues(0.0f, true), actual1);
        FloatBooleanMap actual2 = this.classUnderTest().reject((float key, boolean value) -> Float.compare(key, 0.0f) == 0);
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
