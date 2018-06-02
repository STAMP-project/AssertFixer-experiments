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
 * JUnit test for {@link SynchronizedObjectByteMap#keySet()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeySetTest.stg.
 */
public class SynchronizedObjectByteMapKeySetTest
{
    private SynchronizedObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3)
    {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private SynchronizedObjectByteMap<String> newMapWithKeysValues(String key1, byte value1, String key2, byte value2, String key3, byte value3, String key4, byte value4)
    {
        return new SynchronizedObjectByteMap<>(ObjectByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3).keySet().add("Four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll()
    {
        this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3).keySet().addAll(FastList.newListWith("Four"));
    }

    @Test
    public void contains()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3, null, (byte) 4);
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
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3, null, (byte) 4);
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
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3, null, (byte) 4);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        ObjectByteHashMap<String> map1 = ObjectByteHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", (byte) 1);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3, null, (byte) 4);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
        map.remove("One");
        Verify.assertSize(3, keySet);
        map.put("Five", (byte) 5);
        Verify.assertSize(4, keySet);

        ObjectByteHashMap<String> map1 = ObjectByteHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Verify.assertSize(0, keySet1);
        map1.put(null, (byte) 1);
        Verify.assertSize(1, keySet1);
    }

    @Test
    public void iterator()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3, null, (byte) 4);
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
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3);
        Assert.assertFalse(map.keySet().remove("Four"));

        Assert.assertTrue(map.keySet().remove("Two"));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("One", (byte) 1,  "Three", (byte) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void removeNullFromKeySet()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3);
        Assert.assertFalse(map.keySet().remove(null));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());

        map.put(null, (byte) 4);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertTrue(map.keySet().remove(null));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
    }

    @Test
    public void removeAllFromKeySet()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3);
        Assert.assertFalse(map.keySet().removeAll(FastList.newListWith("Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());

        Assert.assertTrue(map.keySet().removeAll(FastList.newListWith("Two", "Four")));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("One", (byte) 1,  "Three", (byte) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void retainAllFromKeySet()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3);
        Assert.assertFalse(map.keySet().retainAll(FastList.newListWith("One", "Two", "Three", "Four")));
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());

        Assert.assertTrue(map.keySet().retainAll(FastList.newListWith("One", "Three")));
        Assert.assertEquals(ObjectByteHashMap.newWithKeysValues("One", (byte) 1,  "Three", (byte) 3), map);
        Assert.assertEquals(UnifiedSet.newSetWith("One", "Three"), map.keySet());
    }

    @Test
    public void clearKeySet()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3);
        map.keySet().clear();
        Verify.assertEmpty(map);
        Verify.assertEmpty(map.keySet());
    }

    @Test
    public void keySetEqualsAndHashCode()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3, null, (byte) 0);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray()
    {
        SynchronizedObjectByteMap<String> map = this.newMapWithKeysValues("One", (byte) 1, "Two", (byte) 2, "Three", (byte) 3);
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three");
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size() + 1])));
    }
}
