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

import org.eclipse.collections.api.map.primitive.ImmutableObjectByteMap;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectByteHashMap;
import org.eclipse.collections.impl.math.MutableByte;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableObjectByteHashMap}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapTest.stg.
 */
public class ImmutableObjectByteHashMapTest extends AbstractImmutableObjectByteMapTestCase
{
    @Override
    protected ImmutableObjectByteMap<String> classUnderTest()
    {
        return ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2).toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected = ObjectByteHashMap.newWithKeysValues("0", (byte) 0, "1", (byte) 1, "2", (byte) 2, "3", (byte) 3).toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue("3", (byte) 3));
        Assert.assertNotSame(map1, map1.newWithKeyValue("3", (byte) 3));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected = this.newWithKeysValues("0", (byte) 0, "1", (byte) 1);
        Assert.assertEquals(expected, map1.newWithoutKey("2"));
        Assert.assertNotSame(map1, map1.newWithoutKey("2"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableObjectByteMap<String> map1 = this.classUnderTest();
        ImmutableObjectByteMap<String> expected = this.newWithKeysValues("1", (byte) 1);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FastList.newListWith("0", "2")));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableObjectByteHashMap<String> iterable = new ImmutableObjectByteHashMap<>(ObjectByteHashMap.newWithKeysValues("3", (byte) 3, "1", (byte) 1, "2", (byte) 2));
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), (MutableByte object, byte value) -> object.add(value));
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }
}
