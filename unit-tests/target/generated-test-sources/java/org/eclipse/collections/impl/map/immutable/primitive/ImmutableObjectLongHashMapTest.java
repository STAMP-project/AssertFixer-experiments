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

import org.eclipse.collections.api.map.primitive.ImmutableObjectLongMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectLongHashMap;
import org.eclipse.collections.impl.math.MutableLong;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectLongHashMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapTest.stg.
 */
public class ImmutableObjectLongHashMapTest extends AbstractImmutableObjectLongMapTestCase
{
    @Override
    protected ImmutableObjectLongMap<String> classUnderTest()
    {
        return ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L).toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected = ObjectLongHashMap.newWithKeysValues("0", 0L, "1", 1L, "2", 2L, "3", 3L).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", 3L));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", 3L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected = this.newWithKeysValues("0", 0L, "1", 1L);
        Assert.assertEquals(expected, map1.newWithoutKey("2"));
        Assert.assertNotSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectLongMap<String> map1 = this.classUnderTest();
        ImmutableObjectLongMap<String> expected = this.newWithKeysValues("1", 1L);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectLongHashMap<String> iterable = new ImmutableObjectLongHashMap<>(ObjectLongHashMap.newWithKeysValues("3", 3L, "1", 1L, "2", 2L));
        MutableLong result = iterable.injectInto(new MutableLong(0L), (MutableLong object, long value) -> object.add(value));
        Assert.assertEquals(new MutableLong(6L), result);
    }
}
