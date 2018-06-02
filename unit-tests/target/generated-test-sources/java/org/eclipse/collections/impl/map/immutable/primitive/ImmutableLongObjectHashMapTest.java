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

import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.LongObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableLongObjectHashMapTest extends AbstractImmutableLongObjectMapTestCase
{
    @Override
    protected ImmutableLongObjectMap<String> classUnderTest()
    {
        return LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> expected = LongObjectHashMap.newWithKeysValues(0L, "zero", 31L, "thirtyOne", 32L, "thirtyTwo").withKeyValue(33L, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> expected = this.newWithKeysValues(0L, "zero", 31L, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongObjectMap<String> map1 = this.classUnderTest();
        ImmutableLongObjectMap<String> expected = this.newWithKeysValues(31L, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
