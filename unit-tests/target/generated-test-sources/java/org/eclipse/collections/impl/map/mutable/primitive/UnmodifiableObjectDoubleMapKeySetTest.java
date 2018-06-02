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
 * JUnit test for {@link UnmodifiableObjectDoubleMap#keySet()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeySetTest.stg.
 */
public class UnmodifiableObjectDoubleMapKeySetTest
{
    private UnmodifiableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3)
    {
        return new UnmodifiableObjectDoubleMap<>(ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    private UnmodifiableObjectDoubleMap<String> newMapWithKeysValues(String key1, double value1, String key2, double value2, String key3, double value3, String key4, double value4)
    {
        return new UnmodifiableObjectDoubleMap<>(ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
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
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
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
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
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
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
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
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
        Set<String> keySet = map.keySet();
        Verify.assertSize(4, keySet);
    }

    @Test
    public void iterator()
    {
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 4.0);
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
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0, null, 0.0);
        Verify.assertEqualsAndHashCode(UnifiedSet.newSetWith("One", "Two", "Three", null), map.keySet());
        Assert.assertNotEquals(UnifiedSet.newSetWith("One", "Two", "Three"), map.keySet());
        Assert.assertNotEquals(FastList.newListWith("One", "Two", "Three", null), map.keySet());
    }

    @Test
    public void keySetToArray()
    {
        UnmodifiableObjectDoubleMap<String> map = this.newMapWithKeysValues("One", 1.0, "Two", 2.0, "Three", 3.0);
        HashBag<String> expected = HashBag.newBagWith("One", "Two", "Three");
        Set<String> keySet = map.keySet();
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray()));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size()])));
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[0])));
        expected.add(null);
        Assert.assertEquals(expected, HashBag.newBagWith(keySet.toArray(new String[keySet.size() + 1])));
    }
}
