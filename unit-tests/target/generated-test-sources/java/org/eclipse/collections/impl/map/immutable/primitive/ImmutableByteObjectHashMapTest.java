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

import org.eclipse.collections.api.map.primitive.ImmutableByteObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableByteObjectHashMapTest extends AbstractImmutableByteObjectMapTestCase
{
    @Override
    protected ImmutableByteObjectMap<String> classUnderTest()
    {
        return ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteObjectMap<String> map1 = this.classUnderTest();
        ImmutableByteObjectMap<String> expected = ByteObjectHashMap.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne", (byte) 32, "thirtyTwo").withKeyValue((byte) 33, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 33, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 33, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteObjectMap<String> map1 = this.classUnderTest();
        ImmutableByteObjectMap<String> expected = this.newWithKeysValues((byte) 0, "zero", (byte) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey((byte) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteObjectMap<String> map1 = this.classUnderTest();
        ImmutableByteObjectMap<String> expected = this.newWithKeysValues((byte) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
