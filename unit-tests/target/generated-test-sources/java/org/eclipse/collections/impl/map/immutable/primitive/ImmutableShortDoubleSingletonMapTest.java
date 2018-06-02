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
import org.eclipse.collections.api.map.primitive.ShortDoubleMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortDoubleMap;
import org.eclipse.collections.impl.block.factory.primitive.DoublePredicates;
import org.eclipse.collections.impl.factory.primitive.ShortDoubleMaps;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortDoubleSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableShortDoubleSingletonMapTest extends AbstractImmutableShortDoubleMapTestCase
{
    @Override
    protected ImmutableShortDoubleMap classUnderTest()
    {
        return ShortDoubleMaps.immutable.with((short) 0, 0.0);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        ImmutableShortDoubleMap expected = this.newWithKeysValues((short) 0, 0.0);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, 0.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, 0.0));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((short) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((short) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortDoubleMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortDoubleMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(ShortArrayList.newListWith((short) 31, (short) 32)));
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
        Assert.assertEquals(0.0, this.map.getIfAbsent((short) 0, 5.0), 0.0);
        Assert.assertEquals(15.0, this.map.getIfAbsent((short) 31, 15.0), 0.0);
        Assert.assertEquals(25.0, this.map.getIfAbsent((short) 32, 25.0), 0.0);
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
        Assert.assertEquals(0.0, this.map.getOrThrow((short) 0), 0.0);

        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 31));
        Verify.assertThrows(IllegalStateException.class, () -> this.map.getOrThrow((short) 32));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.map.get((short) 0), 0.0);
        Assert.assertEquals(0.0, this.map.get((short) 31), 0.0);
        Assert.assertEquals(0.0, this.map.get((short) 32), 0.0);
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
        ShortDoubleMap actual1 = this.classUnderTest().select((short key, double value) -> key == (short) 0);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), actual1);
        ShortDoubleMap actual2 = this.classUnderTest().select((short key, double value) -> key == (short) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        ShortDoubleMap actual1 = this.classUnderTest().reject((short key, double value) -> key == (short) 1);
        Assert.assertEquals(ShortDoubleHashMap.newWithKeysValues((short) 0, 0.0), actual1);
        ShortDoubleMap actual2 = this.classUnderTest().reject((short key, double value) -> key == (short) 0);
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
        ImmutableShortDoubleSingletonMap iterable = new ImmutableShortDoubleSingletonMap((short) 1, 1.0);
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(1.0), result);
    }
}
