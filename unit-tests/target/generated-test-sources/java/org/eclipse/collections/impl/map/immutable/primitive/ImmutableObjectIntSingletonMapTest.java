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

import org.eclipse.collections.api.iterator.IntIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectIntMap;
import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectIntSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectIntSingletonMapTest extends AbstractImmutableObjectIntMapTestCase
{
    @Override
    protected ImmutableObjectIntMap<String> classUnderTest()
    {
        return ObjectIntHashMap.newWithKeysValues("1", 1).toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected = ObjectIntHashMap.newWithKeysValues("1", 1, "3", 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected1 = this.newWithKeysValues("1", 1);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableObjectIntMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectIntMap<String> map1 = this.classUnderTest();
        ImmutableObjectIntMap<String> expected1 = this.newWithKeysValues("1", 1);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableObjectIntMap<String> expected2 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue(0));
        Assert.assertTrue(this.classUnderTest().containsValue(1));
        Assert.assertFalse(this.classUnderTest().containsValue(2));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        int detect = this.classUnderTest().detectIfNone((int value) -> true, 5);
        Assert.assertEquals(1, detect);

        int detect1 = this.classUnderTest().detectIfNone((int value) -> false, 5);
        Assert.assertEquals(5, detect1);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("0", 1));
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("1", 2));
        Assert.assertEquals(3, this.classUnderTest().getIfAbsent("2", 3));
        Assert.assertEquals(1, this.classUnderTest().getIfAbsent("5", 1));
        Assert.assertEquals(0, this.classUnderTest().getIfAbsent("5", 0));

        Assert.assertEquals(1, this.classUnderTest().getIfAbsent(null, 1));
        Assert.assertEquals(0, this.classUnderTest().getIfAbsent(null, 0));
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(1, this.classUnderTest().maxIfEmpty(9));
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
        Assert.assertFalse(this.classUnderTest().allSatisfy((int value) -> false));

        Assert.assertTrue(this.classUnderTest().allSatisfy((int value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, int value) -> false));

        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, int value) -> true));

        Assert.assertEquals(new IntHashBag(), this.classUnderTest().reject((int value) -> true).toBag());

        Assert.assertEquals(IntHashBag.newBagWith(1), this.classUnderTest().reject((int value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, int value) -> true));

        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, int value) -> false));

        Assert.assertEquals(new IntHashBag(), this.classUnderTest().select((int value) -> false).toBag());

        Assert.assertEquals(IntHashBag.newBagWith(1), this.classUnderTest().select((int value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void intIterator()
    {
        IntIterator iterator = this.classUnderTest().intIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1L, iterator.next());
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains(0));
        Assert.assertTrue(this.classUnderTest().contains(1));
        Assert.assertFalse(this.classUnderTest().contains(2));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(1, this.classUnderTest().getOrThrow("1"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0, this.classUnderTest().get("0"));
        Assert.assertEquals(1, this.classUnderTest().get("1"));
        Assert.assertEquals(0, this.classUnderTest().get(null));
    }

    @Override
    @Test
    public void max()
    {
        Assert.assertEquals(1, this.classUnderTest().max());
    }

    @Override
    @Test
    public void min()
    {
        Assert.assertEquals(1, this.classUnderTest().max());
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
        Assert.assertEquals(1L, this.classUnderTest().count((int value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((int value) -> false));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(IntHashBag.newBagWith(1), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(IntHashSet.newSetWith(1), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(0, 1, 2));
        Assert.assertFalse(this.classUnderTest().containsAll(0, 1, 5));
        Assert.assertTrue(this.classUnderTest().containsAll(1));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(0, 1, 2)));
        Assert.assertFalse(this.classUnderTest().containsAll(IntArrayList.newListWith(0, 1, 5)));
        Assert.assertTrue(this.classUnderTest().containsAll(IntArrayList.newListWith(1)));
        Assert.assertTrue(this.classUnderTest().containsAll(new IntArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(1, this.classUnderTest().minIfEmpty(6));
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectIntMap<String> map1 = this.newWithKeysValues("1", 1);
        ObjectIntMap<String> map2 = this.newWithKeysValues("0", 0);
        ObjectIntMap<String> map3 = this.newWithKeysValues("0", 0, "1", 1);

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
        Assert.assertFalse(this.classUnderTest().noneSatisfy((int value) -> true));

        Assert.assertTrue(this.classUnderTest().noneSatisfy((int value) -> false));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectIntSingletonMap<String> iterable = new ImmutableObjectIntSingletonMap<>("1", 1);
        MutableInteger result = iterable.injectInto(new MutableInteger(1), (MutableInteger object, int value) -> object.add(value));
        Assert.assertEquals(new MutableInteger(2), result);
    }
}
