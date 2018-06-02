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

import org.eclipse.collections.api.map.primitive.ImmutableShortObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableShortObjectHashMapTest extends AbstractImmutableShortObjectMapTestCase
{
    @Override
    protected ImmutableShortObjectMap<String> classUnderTest()
    {
        return ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortObjectMap<String> map1 = this.classUnderTest();
        ImmutableShortObjectMap<String> expected = ShortObjectHashMap.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne", (short) 32, "thirtyTwo").withKeyValue((short) 33, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortObjectMap<String> map1 = this.classUnderTest();
        ImmutableShortObjectMap<String> expected = this.newWithKeysValues((short) 0, "zero", (short) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortObjectMap<String> map1 = this.classUnderTest();
        ImmutableShortObjectMap<String> expected = this.newWithKeysValues((short) 31, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
