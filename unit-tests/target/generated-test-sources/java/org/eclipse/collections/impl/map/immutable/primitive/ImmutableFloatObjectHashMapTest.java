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

import org.eclipse.collections.api.map.primitive.ImmutableFloatObjectMap;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.FloatObjectHashMap;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatObjectHashMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapTest.stg.
 */
public class ImmutableFloatObjectHashMapTest extends AbstractImmutableFloatObjectMapTestCase
{
    @Override
    protected ImmutableFloatObjectMap<String> classUnderTest()
    {
        return FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo").toImmutable();
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatObjectMap<String> map1 = this.classUnderTest();
        ImmutableFloatObjectMap<String> expected = FloatObjectHashMap.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne", 32.0f, "thirtyTwo").withKeyValue(33.0f, "thirtyThree").toImmutable();
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0f, "thirtyThree"));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0f, "thirtyThree"));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatObjectMap<String> map1 = this.classUnderTest();
        ImmutableFloatObjectMap<String> expected = this.newWithKeysValues(0.0f, "zero", 31.0f, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutKey(32.0f));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatObjectMap<String> map1 = this.classUnderTest();
        ImmutableFloatObjectMap<String> expected = this.newWithKeysValues(31.0f, "thirtyOne");
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
