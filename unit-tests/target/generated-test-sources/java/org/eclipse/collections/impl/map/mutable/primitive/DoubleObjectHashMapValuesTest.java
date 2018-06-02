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

import org.eclipse.collections.api.map.primitive.MutableDoubleObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link DoubleObjectHashMap#values()}.
 *
 * This file was automatically generated from template file primitiveObjectHashMapValuesTest.stg.
 */
public class DoubleObjectHashMapValuesTest
{
    private DoubleObjectHashMap<String> newMapWithKeysValues(double key1, String value1, double key2, String value2)
    {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    private DoubleObjectHashMap<Integer> newMapWithKeysValues(double key1, Integer value1, double key2, Integer value2, double key3, Integer value3)
    {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    private DoubleObjectHashMap<Integer> newMapWithKeysValues(double key1, Integer value1, double key2, Integer value2, double key3, Integer value3, double key4, Integer value4)
    {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll()
    {
        this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void clear()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        map.values().clear();
        Verify.assertIterableEmpty(map);
        Verify.assertEmpty(map.values());
    }

    @Test
    public void contains()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
        values.remove(null);
        Assert.assertFalse(values.contains(null));
        map.removeKey(1.0);
        Assert.assertFalse(values.contains(1));
    }

    @Test
    public void containsAll()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
        values.remove(null);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        map.removeKey(1.0);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(2)));
    }

    @Test
    public void isEmpty()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 1.0, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        DoubleObjectHashMap<Integer> map1 = DoubleObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put(1.0, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3, 4.0, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
        map.remove(1.0);
        Verify.assertSize(3, values);
        map.put(5.0, 5);
        Verify.assertSize(4, values);

        DoubleObjectHashMap<Integer> map1 = DoubleObjectHashMap.newMap();
        Collection<Integer> keySet1 = map1.values();
        Verify.assertSize(0, keySet1);
        map1.put(1.0, null);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator()
    {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();

        Iterator<String> iterator = DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);

        MutableDoubleObjectMap<String> map1 = this.newMapWithKeysValues(0.0, "zero", 1.0, null);
        Iterator<String> iterator1 = map1.iterator();
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), DoubleObjectHashMap.newWithKeysValues(0.0, "zero").equals(map1)
                || DoubleObjectHashMap.newWithKeysValues(1.0, null).equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map1);
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator1::remove);

        MutableDoubleObjectMap<String> map2 = this.newMapWithKeysValues(0.0, null, 9.0, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), DoubleObjectHashMap.newWithKeysValues(0.0, null).equals(map2)
                || DoubleObjectHashMap.newWithKeysValues(9.0, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map2);

        MutableDoubleObjectMap<String> map3 = this.newMapWithKeysValues(8.0, "eight", 9.0, null);
        Iterator<String> iterator3 = map3.iterator();
        Verify.assertThrows(IllegalStateException.class, (Runnable) iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), DoubleObjectHashMap.newWithKeysValues(8.0, "eight").equals(map3)
                || DoubleObjectHashMap.newWithKeysValues(9.0, null).equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(DoubleObjectHashMap.newMap(), map3);
    }

    @Test
    public void values()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void removeFromValues()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertFalse(map.values().remove(4));

        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1, 3.0, 3), map);
    }

    @Test
    public void removeNullFromValues()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3), map);
        map.put(4.0, null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3), map);
    }

    @Test
    public void removeAllFromValues()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));

        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1, 3.0, 3), map);
    }

    @Test
    public void retainAllFromValues()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));

        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(DoubleObjectHashMap.newWithKeysValues(1.0, 1, 3.0, 3), map);
    }

    @Test
    public void valuesToArray()
    {
        DoubleObjectHashMap<Integer> map = this.newMapWithKeysValues(1.0, 1, 2.0, 2, 3.0, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }
}
