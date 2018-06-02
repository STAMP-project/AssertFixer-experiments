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

import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link LongObjectHashMap#values()}.
 *
 * This file was automatically generated from template file primitiveObjectHashMapValuesTest.stg.
 */
public class LongObjectHashMapValuesTest
{
    private LongObjectHashMap<String> newMapWithKeysValues(long key1, String value1, long key2, String value2)
    {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    private LongObjectHashMap<Integer> newMapWithKeysValues(long key1, Integer value1, long key2, Integer value2, long key3, Integer value3)
    {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    private LongObjectHashMap<Integer> newMapWithKeysValues(long key1, Integer value1, long key2, Integer value2, long key3, Integer value3, long key4, Integer value4)
    {
        return LongObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4);
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
    public void clear()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        map.values().clear();
        Verify.assertIterableEmpty(map);
        Verify.assertEmpty(map.values());
    }

    @Test
    public void contains()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
        values.remove(null);
        Assert.assertFalse(values.contains(null));
        map.removeKey(1L);
        Assert.assertFalse(values.contains(1));
    }

    @Test
    public void containsAll()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
        values.remove(null);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        map.removeKey(1L);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(2)));
    }

    @Test
    public void isEmpty()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3, 1L, null);
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
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3, 4L, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
        map.remove(1L);
        Verify.assertSize(3, values);
        map.put(5L, 5);
        Verify.assertSize(4, values);

        LongObjectHashMap<Integer> map1 = LongObjectHashMap.newMap();
        Collection<Integer> keySet1 = map1.values();
        Verify.assertSize(0, keySet1);
        map1.put(1L, null);
        Verify.assertSize(1, keySet1);
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

        MutableLongObjectMap<String> map1 = this.newMapWithKeysValues(0L, "zero", 1L, null);
        Iterator<String> iterator1 = map1.iterator();
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), LongObjectHashMap.newWithKeysValues(0L, "zero").equals(map1)
                || LongObjectHashMap.newWithKeysValues(1L, null).equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map1);
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator1::remove);

        MutableLongObjectMap<String> map2 = this.newMapWithKeysValues(0L, null, 9L, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), LongObjectHashMap.newWithKeysValues(0L, null).equals(map2)
                || LongObjectHashMap.newWithKeysValues(9L, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map2);

        MutableLongObjectMap<String> map3 = this.newMapWithKeysValues(8L, "eight", 9L, null);
        Iterator<String> iterator3 = map3.iterator();
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), LongObjectHashMap.newWithKeysValues(8L, "eight").equals(map3)
                || LongObjectHashMap.newWithKeysValues(9L, null).equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(LongObjectHashMap.newMap(), map3);
    }

    @Test
    public void values()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void removeFromValues()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().remove(4));

        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 3L, 3), map);
    }

    @Test
    public void removeNullFromValues()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), map);
        map.put(4L, null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 2L, 2, 3L, 3), map);
    }

    @Test
    public void removeAllFromValues()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));

        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 3L, 3), map);
    }

    @Test
    public void retainAllFromValues()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));

        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(LongObjectHashMap.newWithKeysValues(1L, 1, 3L, 3), map);
    }

    @Test
    public void valuesToArray()
    {
        LongObjectHashMap<Integer> map = this.newMapWithKeysValues(1L, 1, 2L, 2, 3L, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }
}
