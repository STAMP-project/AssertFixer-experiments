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

import org.eclipse.collections.api.map.primitive.MutableFloatObjectMap;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedFloatObjectMap#values()}.
 *
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapValuesTest.stg.
 */
public class SynchronizedFloatObjectMapValuesTest
{
    private SynchronizedFloatObjectMap<String> newMapWithKeysValues(float key1, String value1, float key2, String value2)
    {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    private SynchronizedFloatObjectMap<Integer> newMapWithKeysValues(float key1, Integer value1, float key2, Integer value2, float key3, Integer value3)
    {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedFloatObjectMap<Integer> newMapWithKeysValues(float key1, Integer value1, float key2, Integer value2, float key3, Integer value3, float key4, Integer value4)
    {
        return new SynchronizedFloatObjectMap<>(FloatObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).withKeyValue(key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3).values().add(4);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll()
    {
        this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3).values().addAll(FastList.newListWith(4));
    }

    @Test
    public void clear()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        map.values().clear();
        Verify.assertIterableEmpty(map);
        Verify.assertEmpty(map.values());
    }

    @Test
    public void contains()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.contains(1));
        Assert.assertTrue(values.contains(2));
        Assert.assertTrue(values.contains(null));
        Assert.assertFalse(values.contains(4));
        values.remove(null);
        Assert.assertFalse(values.contains(null));
        map.removeKey(1.0f);
        Assert.assertFalse(values.contains(1));
    }

    @Test
    public void containsAll()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, null);
        Collection<Integer> values = map.values();
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 4)));
        Assert.assertFalse(values.containsAll(FastList.newListWith(5, 4)));
        values.remove(null);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2, null)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(1, 2)));
        map.removeKey(1.0f);
        Assert.assertFalse(values.containsAll(FastList.newListWith(1, 2)));
        Assert.assertTrue(values.containsAll(FastList.newListWith(2)));
    }

    @Test
    public void isEmpty()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3, 1.0f, null);
        Collection<Integer> values = map.values();
        Assert.assertFalse(values.isEmpty());
        FloatObjectHashMap<Integer> map1 = FloatObjectHashMap.newMap();
        Collection<Integer> values1 = map1.values();
        Assert.assertTrue(values1.isEmpty());
        map1.put(1.0f, 1);
        Assert.assertFalse(values1.isEmpty());
    }

    @Test
    public void size()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3, 4.0f, null);
        Collection<Integer> values = map.values();
        Verify.assertSize(4, values);
        map.remove(1.0f);
        Verify.assertSize(3, values);
        map.put(5.0f, 5);
        Verify.assertSize(4, values);

        FloatObjectHashMap<Integer> map1 = FloatObjectHashMap.newMap();
        Collection<Integer> keySet1 = map1.values();
        Verify.assertSize(0, keySet1);
        map1.put(1.0f, null);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator()
    {
        MutableSet<String> expected = UnifiedSet.newSetWith("zero", "thirtyOne", null);
        MutableSet<String> actual = UnifiedSet.newSet();

        Iterator<String> iterator = FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, null).iterator();
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        actual.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());

        Assert.assertEquals(expected, actual);
        Verify.assertThrows(NoSuchElementException.class, iterator::next);

        MutableFloatObjectMap<String> map1 = this.newMapWithKeysValues(0.0f, "zero", 1.0f, null);
        Iterator<String> iterator1 = map1.iterator();
        Verify.assertThrows(IllegalStateException.class, iterator1::remove);
        iterator1.next();
        iterator1.remove();
        Assert.assertTrue(map1.toString(), FloatObjectHashMap.newWithKeysValues(0.0f, "zero").equals(map1)
                || FloatObjectHashMap.newWithKeysValues(1.0f, null).equals(map1));
        iterator1.next();
        iterator1.remove();
        Assert.assertEquals(FloatObjectHashMap.newMap(), map1);
        Verify.assertThrows(IllegalStateException.class, iterator1::remove);

        MutableFloatObjectMap<String> map2 = this.newMapWithKeysValues(0.0f, null, 9.0f, "nine");
        Iterator<String> iterator2 = map2.iterator();
        Verify.assertThrows(IllegalStateException.class, iterator2::remove);
        iterator2.next();
        iterator2.remove();
        Assert.assertTrue(map2.toString(), FloatObjectHashMap.newWithKeysValues(0.0f, null).equals(map2)
                || FloatObjectHashMap.newWithKeysValues(9.0f, "nine").equals(map2));
        iterator2.next();
        iterator2.remove();
        Assert.assertEquals(FloatObjectHashMap.newMap(), map2);

        MutableFloatObjectMap<String> map3 = this.newMapWithKeysValues(8.0f, "eight", 9.0f, null);
        Iterator<String> iterator3 = map3.iterator();
        Verify.assertThrows(IllegalStateException.class, iterator3::remove);
        iterator3.next();
        iterator3.remove();
        Assert.assertTrue(map3.toString(), FloatObjectHashMap.newWithKeysValues(8.0f, "eight").equals(map3)
                || FloatObjectHashMap.newWithKeysValues(9.0f, null).equals(map3));
        iterator3.next();
        iterator3.remove();
        Assert.assertEquals(FloatObjectHashMap.newMap(), map3);
    }

    @Test
    public void values()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        Verify.assertContainsAll(map.values(), 1, 2, 3);
    }

    @Test
    public void removeFromValues()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertFalse(map.values().remove(4));

        Assert.assertTrue(map.values().remove(2));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1, 3.0f, 3), map);
    }

    @Test
    public void removeNullFromValues()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertFalse(map.values().remove(null));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3), map);
        map.put(4.0f, null);
        Assert.assertTrue(map.values().remove(null));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3), map);
    }

    @Test
    public void removeAllFromValues()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertFalse(map.values().removeAll(FastList.newListWith(4)));

        Assert.assertTrue(map.values().removeAll(FastList.newListWith(2, 4)));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1, 3.0f, 3), map);
    }

    @Test
    public void retainAllFromValues()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, 3);
        Assert.assertFalse(map.values().retainAll(FastList.newListWith(1, 2, 3, 4)));

        Assert.assertTrue(map.values().retainAll(FastList.newListWith(1, 3)));
        Assert.assertEquals(FloatObjectHashMap.newWithKeysValues(1.0f, 1, 3.0f, 3), map);
    }

    @Test
    public void valuesToArray()
    {
        SynchronizedFloatObjectMap<Integer> map = this.newMapWithKeysValues(1.0f, 1, 2.0f, 2, 3.0f, null);
        HashBag<Integer> expected = HashBag.newBagWith(1, 2, null);
        Collection<Integer> values = map.values();
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(values.toArray(new Integer[values.size() + 1])));
    }
}
