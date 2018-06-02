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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedObjectDoubleMap#keySet()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeySetTest.stg.
 */
public class SynchronizedObjectDoubleMapKeySetTest
{
    private SynchronizedObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3)
    {
        return new SynchronizedObjectDoubleMap<>(ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4)
    {
        return new SynchronizedObjectDoubleMap<>(ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0).keySet().add("Four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll()
    {
        this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0).keySet().addAll(FastList.newListWith("Four"));
    }

    @Test
    public void contains()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.contains("One"));
        Assert.assertTrue(keySet.contains("Two"));
        Assert.assertTrue(keySet.contains("Three"));
        Assert.assertFalse(keySet.contains("Four"));
        Assert.assertTrue(keySet.contains(null));
        keySet.remove(null);
        Assert.assertFalse(keySet.contains(null));
        map.removeKey("One");
        Assert.assertFalse(keySet.contains("One"));
    }

    @Test
    public void containsAll()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two", "Three", null)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Four")));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("Five", "Four")));
        keySet.remove(null);
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Two", "Three", null)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two", "Three")));
        map.removeKey("One");
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("Three", "Two")));
    }

    @Test
    public void isEmpty()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        ObjectDoubleHashMap<String> map1 = ObjectDoubleHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", 1.0);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
        map.remove("One");
        Verify.assertSize(3, keySet);
        map.put("Five", 5.0);
        Verify.assertSize(4, keySet);

        ObjectDoubleHashMap<String> map1 = ObjectDoubleHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Verify.assertSize(0, keySet1);
        map1.put(null, 1.0);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();

        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three", null);
        HashBag<String> actual = HashBag.newBag();
        Verify.assertThrows(IllegalStateException.class, iterator::remove);
        for (int i = 0; i < 4; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, (Runnable) iterator::next);
        Assert.assertEquals(expected, actual);

        Iterator<String> iterator1 = keySet.iterator();
        for (int i = 4; i > 0; i--)
        {
            Assert.assertTrue(iterator1.hasNext());
            iterator1.next();
            iterator1.remove();
            Verify.assertThrows(IllegalStateException.class, iterator1::remove);
            Verify.assertSize(i - 1, keySet);
            Verify.assertSize(i - 1, map);
        }

        Assert.assertFalse(iterator1.hasNext());
        Verify.assertEmpty(map);
        Verify.assertEmpty(keySet);
    }

    @Test
    public void removeFromKeySet()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        Assert.assertFalse(map.keySet().remove("Four"));

        Assert.assertTrue(map.keySet().remove("Two"));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("One", 1.0,  "Three", 3.0), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void removeNullFromKeySet()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        Assert.assertFalse(map.keySet().remove(null));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());

        map.put(null, 4.0);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertTrue(map.keySet().remove(null));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Test
    public void removeAllFromKeySet()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        Assert.assertFalse(map.keySet().removeAll(FastList.newListWith("Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());

        Assert.assertTrue(map.keySet().removeAll(FastList.newListWith("Two", "Four")));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("One", 1.0,  "Three", 3.0), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void retainAllFromKeySet()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        Assert.assertFalse(map.keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());

        Assert.assertTrue(map.keySet().retainAll(FastList.newListWith("One", "Three")));
        Assert.assertEquals(ObjectDoubleHashMap.newWithKeysValues("One", 1.0,  "Three", 3.0), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void clearKeySet()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        map.keySet().clear();
        Verify.assertEmpty(map);
        Verify.assertEmpty(map.keySet());
    }

    @Test
    public void keySetEqualsAndHashCode()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 0.0);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray()
    {
        SynchronizedObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three");
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size() + 1])));
    }
}
