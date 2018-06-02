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

import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.LongDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.LongDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongDoubleSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableLongDoubleSingletonMapTest extends AbstractImmutableLongDoubleMapTestCase
{
    @Override
    protected ImmutableLongDoubleMap classUnderTest()
    {
        return LongDoubleMaps.immutable.with(0L, 0.0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        ImmutableLongDoubleMap expected = this.newWithKeysValues(0L, 0.0);
        Assert.assertEquals(expected, map1.newWithKeyValue(0L, 0.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue(0L, 0.0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey(32L));
        Assert.assertSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableLongDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey(0L));
        Assert.assertNotSame(map2, map2.newWithoutKey(0L));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableLongDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(LongArrayList.newListWith(31L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0.0));
        Assert.assertFalse(this.map.containsValue(31.0));
        Assert.assertFalse(this.map.containsValue(32.0));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0));
        Assert.assertFalse(this.map.contains(31.0));
        Assert.assertFalse(this.map.contains(32.0));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent(0L, 5.0), 0.0);
        Assert.assertEquals(15.0, this.map.getIfAbsent(31L, 15.0), 0.0);
        Assert.assertEquals(25.0, this.map.getIfAbsent(32L, 25.0), 0.0);
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(DoubleArrayList.newListWith(0.0), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void doubleIterator()
    {
        DoubleIterator iterator = this.map.doubleIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(0.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(0.0, this.map.getOrThrow(0L), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(31L));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow(32L));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get(0L), 0.0);
        Assert.assertEquals(0.0, this.map.get(31L), 0.0);
        Assert.assertEquals(0.0, this.map.get(32L), 0.0);
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.map.containsAll(0.0, 31.0, 32.0));
        Assert.assertFalse(this.map.containsAll(31.0, 35.0));
        Assert.assertTrue(this.map.containsAll(0.0));
        Assert.assertTrue(this.map.containsAll());
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertTrue(this.map.containsKey(0L));
        Assert.assertFalse(this.map.containsKey(31L));
        Assert.assertFalse(this.map.containsKey(32L));
    }

    @Override
    @Test
    public void keysView()
    {
        Assert.assertEquals(LongArrayList.newListWith(0L), this.map.keysView().toSortedList());
    }

    @Override
    @Test
    public void toSortedArray()
    {
        Assert.assertTrue(Arrays.equals(new double[]{0.0}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 32.0)));
        Assert.assertFalse(this.map.containsAll(DoubleArrayList.newListWith(0.0, 31.0, 35.0)));
        Assert.assertTrue(this.map.containsAll(DoubleArrayList.newListWith(0.0)));
        Assert.assertTrue(this.map.containsAll(new DoubleArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        LongDoubleMap actual1 = this.classUnderTest().select((long key, double value) -> key == 0L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), actual1);
        LongDoubleMap actual2 = this.classUnderTest().select((long key, double value) -> key == 1L);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        LongDoubleMap actual1 = this.classUnderTest().reject((long key, double value) -> key == 1L);
        Assert.assertEquals(LongDoubleHashMap.newWithKeysValues(0L, 0.0), actual1);
        LongDoubleMap actual2 = this.classUnderTest().reject((long key, double value) -> key == 0L);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        DoubleIterable actual1 = this.classUnderTest().select(DoublePredicates.equal(1.0));
        Assert.assertEquals(DoubleBags.immutable.empty(), actual1);

        DoubleIterable actual2 = this.classUnderTest().select(DoublePredicates.equal(0.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        DoubleIterable actual1 = this.classUnderTest().reject(DoublePredicates.equal(0.0));
        Assert.assertEquals(DoubleBags.immutable.empty(), actual1);

        DoubleIterable actual2 = this.classUnderTest().reject(DoublePredicates.equal(1.0));
        Assert.assertEquals(DoubleBags.immutable.with(0.0), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(DoublePredicates.equal(1.0)));
        Assert.assertEquals(1, this.classUnderTest().count(DoublePredicates.equal(0.0)));
    }

    @Test
    public void injectInto()
    {
        ImmutableLongDoubleSingletonMap iterable = new ImmutableLongDoubleSingletonMap(1L, 1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(1.0), result);
    }
}
