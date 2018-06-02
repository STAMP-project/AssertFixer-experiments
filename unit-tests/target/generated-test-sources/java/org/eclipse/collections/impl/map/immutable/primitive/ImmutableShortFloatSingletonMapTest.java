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

import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.ShortFloatMap;
import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.impl.block.factory.primitive.FloatPredicates;
import org.eclipse.collections.impl.factory.primitive.ShortFloatMaps;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortFloatSingletonMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveSingletonMapTest.stg.
 */
public class ImmutableShortFloatSingletonMapTest extends AbstractImmutableShortFloatMapTestCase
{
    @Override
    protected ImmutableShortFloatMap classUnderTest()
    {
        return ShortFloatMaps.immutable.with((short) 0, 0.0f);
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortFloatMap map1 = this.classUnderTest();
        ImmutableShortFloatMap expected = this.newWithKeysValues((short) 0, 0.0f);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 0, 0.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 0, 0.0f));
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(map1, map1.newWithoutKey((short) 32));
        Assert.assertSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map2.newWithoutKey((short) 0));
        Assert.assertNotSame(map2, map2.newWithoutKey((short) 0));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortFloatMap map1 = this.classUnderTest();
        Assert.assertEquals(this.getEmptyMap(), map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableShortFloatMap map2 = this.classUnderTest();
        Assert.assertEquals(map2, map2.newWithoutAllKeys(ShortArrayList.newListWith((short) 31, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map2);
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertTrue(this.map.containsValue(0.0f));
        Assert.assertFalse(this.map.containsValue(31.0f));
        Assert.assertFalse(this.map.containsValue(32.0f));
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertTrue(this.map.contains(0.0f));
        Assert.assertFalse(this.map.contains(31.0f));
        Assert.assertFalse(this.map.contains(32.0f));
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(0.0, this.map.getIfAbsent((short) 0, 5.0f), 0.0);
        Assert.assertEquals(15.0, this.map.getIfAbsent((short) 31, 15.0f), 0.0);
        Assert.assertEquals(25.0, this.map.getIfAbsent((short) 32, 25.0f), 0.0);
    }

    @Override
    @Test
    public void asLazy()
    {
        Assert.assertEquals(FloatArrayList.newListWith(0.0f), this.map.asLazy().toList());
    }

    @Override
    @Test
    public void floatIterator()
    {
        FloatIterator iterator = this.map.floatIterator();
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
        Assert.assertFalse(this.map.containsAll(0.0f, 31.0f, 32.0f));
        Assert.assertFalse(this.map.containsAll(31.0f, 35.0f));
        Assert.assertTrue(this.map.containsAll(0.0f));
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
        Assert.assertTrue(Arrays.equals(new float[]{0.0f}, this.map.toSortedArray()));
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 32.0f)));
        Assert.assertFalse(this.map.containsAll(FloatArrayList.newListWith(0.0f, 31.0f, 35.0f)));
        Assert.assertTrue(this.map.containsAll(FloatArrayList.newListWith(0.0f)));
        Assert.assertTrue(this.map.containsAll(new FloatArrayList()));
    }

    @Override
    @Test
    public void select()
    {
        ShortFloatMap actual1 = this.classUnderTest().select((short key, float value) -> key == (short) 0);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), actual1);
        ShortFloatMap actual2 = this.classUnderTest().select((short key, float value) -> key == (short) 1);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void reject()
    {
        ShortFloatMap actual1 = this.classUnderTest().reject((short key, float value) -> key == (short) 1);
        Assert.assertEquals(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f), actual1);
        ShortFloatMap actual2 = this.classUnderTest().reject((short key, float value) -> key == (short) 0);
        Assert.assertEquals(this.getEmptyMap(), actual2);
    }

    @Override
    @Test
    public void select_value()
    {
        FloatIterable actual1 = this.classUnderTest().select(FloatPredicates.equal(1.0f));
        Assert.assertEquals(FloatBags.immutable.empty(), actual1);

        FloatIterable actual2 = this.classUnderTest().select(FloatPredicates.equal(0.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f), actual2);
    }

    @Override
    @Test
    public void reject_value()
    {
        FloatIterable actual1 = this.classUnderTest().reject(FloatPredicates.equal(0.0f));
        Assert.assertEquals(FloatBags.immutable.empty(), actual1);

        FloatIterable actual2 = this.classUnderTest().reject(FloatPredicates.equal(1.0f));
        Assert.assertEquals(FloatBags.immutable.with(0.0f), actual2);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0, this.classUnderTest().count(FloatPredicates.equal(1.0f)));
        Assert.assertEquals(1, this.classUnderTest().count(FloatPredicates.equal(0.0f)));
    }

    @Test
    public void injectInto()
    {
        ImmutableShortFloatSingletonMap iterable = new ImmutableShortFloatSingletonMap((short) 1, 1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(1.0f), result);
    }
}
