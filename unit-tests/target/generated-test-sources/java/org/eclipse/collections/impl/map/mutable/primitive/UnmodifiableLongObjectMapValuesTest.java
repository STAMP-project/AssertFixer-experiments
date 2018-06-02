/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link UnmodifiableLongObjectMap#values()}.
 *
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapValuesTest.stg.
 */
public class UnmodifiableLongObjectMapValuesTest
{
    private UnmodifiableLongObjectMap<String> newMapWithKeysValues(long key1, String value1, long key2, String value2)
    {
        return new UnmodifiableLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private UnmodifiableLongObjectMap<Integer> newMapWithKeysValues(long key1, Integer value1, long key2, Integer value2, long key3, Integer value3)
    {
        return new UnmodifiableLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private UnmodifiableLongObjectMap<Integer> newMapWithKeysValues(long key1, Integer value1, long key2, Integer value2, long key3, Integer value3, long key4, Integer value4)
    {
        return new UnmodifiableLongObjectMap<>(LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll()
    {
        this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void contains()
    {
        UnmodifiableLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
    }

    @Test
    public void containsAll()
    {
        UnmodifiableLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
    }

    @Test
    public void isEmpty()
    {
        UnmodifiableLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3, 1L, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        LongObjectHashMap<Integer> map1 = LongObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put(1L, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size()
    {
        UnmodifiableLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3, 4L, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
    }

    @Test
    public void iterator()
    {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();

        Iterator<String> iterator = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void values()
    {
        UnmodifiableLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void valuesToArray()
    {
        UnmodifiableLongObjectMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }
}
