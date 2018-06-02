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

import org.eclipse.collections.api.iterator.FloatIterator;
import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.api.map.primitive.ObjectFloatMap;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectFloatSingletonMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveSingletonMapTest.stg.
 */
public class ImmutableObjectFloatSingletonMapTest extends AbstractImmutableObjectFloatMapTestCase
{
    @Override
    protected ImmutableObjectFloatMap<String> classUnderTest()
    {
        return ObjectFloatHashMap.newWithKeysValues("1", 1.0f).toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected = ObjectFloatHashMap.newWithKeysValues("1", 1.0f, "3", 3.0f).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected1 = this.newWithKeysValues("1", 1.0f);
        Assert.assertEquals(expected1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableObjectFloatMap<String> expected2 = this.getEmptyMap();
        Assert.assertEquals(expected2, map1.newWithoutKey("1"));
        Assert.assertNotSame(map1, map1.newWithoutKey("1"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectFloatMap<String> map1 = this.classUnderTest();
        ImmutableObjectFloatMap<String> expected1 = this.newWithKeysValues("1", 1.0f);
        Assert.assertEquals(expected1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("2", "3")));
        Assert.assertEquals(this.classUnderTest(), map1);

        ImmutableObjectFloatMap<String> expected2 = this.getEmptyMap();
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
        Assert.assertFalse(this.classUnderTest().containsValue(0.0f));
        Assert.assertTrue(this.classUnderTest().containsValue(1.0f));
        Assert.assertFalse(this.classUnderTest().containsValue(2.0f));
    }

    @Override
    @Test
    public void detectIfNone()
    {
        float detect = this.classUnderTest().detectIfNone((float value) -> true, 5.0f);
        Assert.assertEquals(1.0f, detect, 0.0f);

        float detect1 = this.classUnderTest().detectIfNone((float value) -> false, 5.0f);
        Assert.assertEquals(5.0f, detect1, 0.0f);
    }

    @Override
    @Test
    public void getIfAbsent()
    {
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent("0", 1.0f), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent("1", 2.0f), 0.0f);
        Assert.assertEquals(3.0f, this.classUnderTest().getIfAbsent("2", 3.0f), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent("5", 1.0f), 0.0f);
        Assert.assertEquals(0.0f, this.classUnderTest().getIfAbsent("5", 0.0f), 0.0f);

        Assert.assertEquals(1.0f, this.classUnderTest().getIfAbsent(null, 1.0f), 0.0f);
        Assert.assertEquals(0.0f, this.classUnderTest().getIfAbsent(null, 0.0f), 0.0f);
    }

    @Override
    @Test
    public void maxIfEmpty()
    {
        Assert.assertEquals(1.0f, this.classUnderTest().maxIfEmpty(9.0f), 0.0f);
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
        Assert.assertFalse(this.classUnderTest().allSatisfy((float value) -> false));

        Assert.assertTrue(this.classUnderTest().allSatisfy((float value) -> true));
    }

    @Override
    @Test
    public void reject()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().reject((String object, float value) -> false));

        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().reject((String object, float value) -> true));

        Assert.assertEquals(new FloatHashBag(), this.classUnderTest().reject((float value) -> true).toBag());

        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.classUnderTest().reject((float value) -> false).toBag());
    }

    @Override
    @Test
    public void select()
    {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().select((String object, float value) -> true));

        Assert.assertEquals(this.getEmptyMap(), this.classUnderTest().select((String object, float value) -> false));

        Assert.assertEquals(new FloatHashBag(), this.classUnderTest().select((float value) -> false).toBag());

        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.classUnderTest().select((float value) -> true).toBag());
    }

    @Test
    public void keysView()
    {
        Assert.assertEquals(FastList.newListWith("1"), this.classUnderTest().keysView().toList());
    }

    @Override
    @Test
    public void floatIterator()
    {
        FloatIterator iterator = this.classUnderTest().floatIterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(1.0, iterator.next(), 0.0);
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Override
    @Test
    public void contains()
    {
        Assert.assertFalse(this.classUnderTest().contains(0.0f));
        Assert.assertTrue(this.classUnderTest().contains(1.0f));
        Assert.assertFalse(this.classUnderTest().contains(2.0f));
    }

    @Override
    @Test
    public void getOrThrow()
    {
        Assert.assertEquals(1.0f, this.classUnderTest().getOrThrow("1"), 0.0f);
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("5"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow("0"));
        Verify.assertThrows(IllegalStateException.class, () -> this.classUnderTest().getOrThrow(null));
    }

    @Override
    @Test
    public void get()
    {
        Assert.assertEquals(0.0f, this.classUnderTest().get("0"), 0.0f);
        Assert.assertEquals(1.0f, this.classUnderTest().get("1"), 0.0f);
        Assert.assertEquals(0.0f, this.classUnderTest().get(null), 0.0f);
    }

    @Override
    @Test
    public void max()
    {
        Assert.assertEquals(1.0f, this.classUnderTest().max(), 0.0f);
    }

    @Override
    @Test
    public void min()
    {
        Assert.assertEquals(1.0f, this.classUnderTest().max(), 0.0f);
    }

    @Override
    @Test
    public void sum()
    {
        Assert.assertEquals(1.0, this.classUnderTest().sum(), 0.0);
    }

    @Override
    @Test
    public void count()
    {
        Assert.assertEquals(1L, this.classUnderTest().count((float value) -> true));
        Assert.assertEquals(0L, this.classUnderTest().count((float value) -> false));
    }

    @Override
    @Test
    public void toBag()
    {
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f), this.classUnderTest().toBag());
    }

    @Override
    @Test
    public void toSet()
    {
        Assert.assertEquals(FloatHashSet.newSetWith(1.0f), this.classUnderTest().toSet());
    }

    @Override
    @Test
    public void containsAll()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(0.0f, 1.0f, 2.0f));
        Assert.assertFalse(this.classUnderTest().containsAll(0.0f, 1.0f, 5.0f));
        Assert.assertTrue(this.classUnderTest().containsAll(1.0f));
        Assert.assertTrue(this.classUnderTest().containsAll());
    }

    @Override
    @Test
    public void containsAll_Iterable()
    {
        Assert.assertFalse(this.classUnderTest().containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 2.0f)));
        Assert.assertFalse(this.classUnderTest().containsAll(FloatArrayList.newListWith(0.0f, 1.0f, 5.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(FloatArrayList.newListWith(1.0f)));
        Assert.assertTrue(this.classUnderTest().containsAll(new FloatArrayList()));
    }

    @Override
    @Test
    public void minIfEmpty()
    {
        Assert.assertEquals(1.0f, this.classUnderTest().minIfEmpty(6.0f), 0.0f);
    }

    @Override
    @Test
    public void testEquals()
    {
        ObjectFloatMap<String> map1 = this.newWithKeysValues("1", 1.0f);
        ObjectFloatMap<String> map2 = this.newWithKeysValues("0", 0.0f);
        ObjectFloatMap<String> map3 = this.newWithKeysValues("0", 0.0f, "1", 1.0f);

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
        Assert.assertFalse(this.classUnderTest().noneSatisfy((float value) -> true));

        Assert.assertTrue(this.classUnderTest().noneSatisfy((float value) -> false));
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectFloatSingletonMap<String> iterable = new ImmutableObjectFloatSingletonMap<>("1", 1.0f);
        MutableFloat result = iterable.injectInto(new MutableFloat(1.0f), (MutableFloat object, float value) -> object.add(value));
        Assert.assertEquals(new MutableFloat(2.0f), result);
    }
}
