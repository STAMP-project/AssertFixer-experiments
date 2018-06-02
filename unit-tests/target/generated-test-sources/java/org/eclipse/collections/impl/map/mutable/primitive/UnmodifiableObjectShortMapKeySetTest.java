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
 * JUnit test for {@link UnmodifiableObjectShortMap#keySet()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableObjectShortMapKeySetTest
{
    private UnmodifiableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3)
    {
        return new UnmodifiableObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private UnmodifiableObjectShortMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4)
    {
        return new UnmodifiableObjectShortMap<>(ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void add()
    {
        this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3).keySet().add("Four");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void addAll()
    {
        this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3).keySet().addAll(FastList.newListWith("Four"));
    }

    @Test
    public void contains()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.contains("One"));
        Assert.assertTrue(keySet.contains("Two"));
        Assert.assertTrue(keySet.contains("Three"));
        Assert.assertFalse(keySet.contains("Four"));
        Assert.assertTrue(keySet.contains(null));
    }

    @Test
    public void containsAll()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two")));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith("One", "Two", "Three", null)));
        Assert.assertTrue(keySet.containsAll(FastList.newListWith(null, null)));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("One", "Four")));
        Assert.assertFalse(keySet.containsAll(FastList.newListWith("Five", "Four")));
    }

    @Test
    public void isEmpty()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Assert.assertFalse(keySet.isEmpty());
        ObjectShortHashMap<String> map1 = ObjectShortHashMap.newMap();
        Set<String> keySet1 = map1.keySet();
        Assert.assertTrue(keySet1.isEmpty());
        map1.put("One", (short) 1);
        Assert.assertFalse(keySet1.isEmpty());
    }

    @Test
    public void size()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
    }

    @Test
    public void iterator()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 4);
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();

        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three", null);
        HashBag<String> actual = HashBag.newBag();
        for (int i = 0; i < 4; i++)
        {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Verify.assertThrows(NoSuchElementException.class, iterator::next);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void keySetEqualsAndHashCode()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3, null, (short) 0);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray()
    {
        UnmodifiableObjectShortMap<String> map = this.newMapWithKeysValues("One", (short) 1, "Two", (short) 2, "Three", (short) 3);
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three");
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size() + 1])));
    }
}
