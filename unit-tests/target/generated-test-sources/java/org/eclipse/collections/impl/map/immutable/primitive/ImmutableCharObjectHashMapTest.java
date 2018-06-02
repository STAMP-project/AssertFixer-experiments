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

import org.eclipse.collections.api.map.primitive.ImmutableCharObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.CharArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.CharObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableCharObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableCharObjectHashMapTest extends AbstractImmutableCharObjectMapTestCase
{
    @Override
    protected ImmutableCharObjectMap<String> classUnderTest()
    {
        return CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        ImmutableCharObjectMap<String> expected = CharObjectHashMap.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne", (char) 32, "thirtyTwo").withKeyValue((char) 33, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue((char) 33, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue((char) 33, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        ImmutableCharObjectMap<String> expected = this.newWithKeysValues((char) 0, "zero", (char) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey((char) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((char) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableCharObjectMap<String> map1 = this.classUnderTest();
        ImmutableCharObjectMap<String> expected = this.newWithKeysValues((char) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(CharArrayList.newListWith((char) 0, (char) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
