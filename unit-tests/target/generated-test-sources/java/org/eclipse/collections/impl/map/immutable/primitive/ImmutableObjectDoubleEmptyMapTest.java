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

import org.eclipse.collections.api.iterator.DoubleIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectDoubleEmptyMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveEmptyMapTest.stg.
 */
public class ImmutableObjectDoubleEmptyMapTest extends AbstractImmutableObjectDoubleMapTestCase
{
    @Override
    protected ImmutableObjectDoubleMap<String> classUnderTest()
    {
        return (ImmutableObjectDoubleMap<String>) ImmutableObjectDoubleEmptyMap.INSTANCE;
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected = ObjectDoubleHashMap.newWithKeysValues("3", 3.0).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectDoubleMap<String> map1 = this.classUnderTest();
        ImmutableObjectDoubleMap<String> expected1 = this.getEmptyMap();
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Override
    @Test
    public void containsKey()
    {
        Assert.assertFalse(this.classUnderTest().containsKey("0"));
        Assert.assertFalse(this.classUnderTest().containsKey("1"));
        Assert.assertFalse(this.classUnderTest().containsKey("2"));
        Assert.assertFalse(this.classUnderTest().containsKey("3"));
        Assert.assertFalse(this.classUnderTest().containsKey(null));
    }

    @Override
    @Test
    public void containsValue()
    {
        Assert.assertFalse(this.classUnderTest().containsValue(0.0));
        Assert.assertFalse(this.classUnderTest().containsValue(1.0));
        Assert.assertFalse(this.classUnderTest().containsValue(2.0));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        double detect = this.classUnderTest().detectIfNone((double value) -> true, 5.0);
        Assert.assertEquals(5.0, detect, 0.0);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent("0", 1.0), 0.0);
        Assert.assertEquals(2.0, this.classUnderTest().getIfAbsent("1", 2.0), 0.0);
        Assert.assertEquals(3.0, this.classUnderTest().getIfAbsent("2", 3.0), 0.0);
        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent("5", 1.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().getIfAbsent("5", 0.0), 0.0);

        Assert.assertEquals(1.0, this.classUnderTest().getIfAbsent(null, 1.0), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().getIfAbsent(null, 0.0), 0.0);
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(9.0, this.getEmptyMap().maxIfEmpty(9.0), 0.0);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void median()
    {
        this.classUnderTest().median();
    }

    @Override
    @Test
    public void allSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().allSatisfy((double value) -> false));
    }

    @Override
    @Test
    public void anySatisfy()
    {
        Assert.assertFalse(this.classUnderTest().anySatisfy((double value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, double value) -> false));

        Assert.assertEquals(new DoubleHashBag(), this.classUnderTest().reject((double value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, double value) -> true));

        Assert.assertEquals(new DoubleHashBag(), this.classUnderTest().select((double value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Verify.assertIterableEmpty(this.classUnderTest().keysView());
    }

    @Override
    @Test
    public void doubleIterator()
    {
        DoubleIterator iterator = this.classUnderTest().doubleIterator();
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test(expected = ArithmeticException.class)
    public void average()
    {
        this.classUnderTest().average();
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains(0.0));
        Assert.assertFalse(this.classUnderTest().contains(1.0));
        Assert.assertFalse(this.classUnderTest().contains(2.0));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0, this.classUnderTest().get("0"), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().get("1"), 0.0);
        Assert.assertEquals(0.0, this.classUnderTest().get(null), 0.0);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void max()
    {
        this.classUnderTest().max();
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void min()
    {
        this.classUnderTest().min();
    }

    @Override
    @Test
    public void sum()
    {
        Assert.assertEquals(0.0, this.classUnderTest().sum(), 0.0);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(0L, this.classUnderTest().count((double value) -> true));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(DoubleHashBag.newBagWith(), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(DoubleHashSet.newSetWith(), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(0.0, 1.0, 2.0));
        Assert.assertFalse(this.classUnderTest().containsAll(0.0, 1.0, 5.0));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(DoubleArrayList.newListWith(0.0, 1.0, 2.0)));
        Assert.assertFalse(this.classUnderTest().containsAll(DoubleArrayList.newListWith(0.0, 1.0, 5.0)));
        Assert.assertTrue(this.classUnderTest().containsAll(new DoubleArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(5.0, this.getEmptyMap().minIfEmpty(5.0), 0.0);
        Assert.assertEquals(6.0, this.getEmptyMap().minIfEmpty(6.0), 0.0);
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectDoubleMap<String> map1 = this.newWithKeysValues("0", 0.0, "1", 1.0, null, 2.0);
        ObjectDoubleMap<String> map2 = this.getEmptyMap();

        Assert.assertNotEquals(this.classUnderTest(), map1);
        Verify.assertEqualsAndHashCode(this.classUnderTest(), map2);
        Verify.assertPostSerializedIdentity(this.classUnderTest());
    }

    @Override
    @Test
    public void isEmpty()
    {
        Verify.assertEmpty(this.classUnderTest());
    }

    @Override
    @Test
    public void notEmpty()
    {
        Assert.assertFalse(this.classUnderTest().notEmpty());
    }

    @Override
    @Test
    public void noneSatisfy()
    {
        Assert.assertTrue(this.classUnderTest().noneSatisfy((double value) -> true));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectDoubleEmptyMap<Object> iterable = new ImmutableObjectDoubleEmptyMap<>();
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), (MutableDouble object, double value) -> object.add(value));
        Assert.assertEquals(new MutableDouble(0.0), result);
    }
}
