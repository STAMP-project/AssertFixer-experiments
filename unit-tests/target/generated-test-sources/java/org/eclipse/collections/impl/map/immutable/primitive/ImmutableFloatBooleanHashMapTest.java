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

import org.eclipse.collections.api.map.primitive.ImmutableFloatBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.FloatArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableFloatBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableFloatBooleanHashMapTest extends AbstractImmutableFloatBooleanMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        ImmutableFloatBooleanMap expected = this.newWithKeysValues(0.0f, true, 31.0f, false, 32.0f, true, 33.0f, false);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0f, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0f, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        ImmutableFloatBooleanMap expected = this.newWithKeysValues(0.0f, true, 31.0f, false);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0f));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableFloatBooleanMap map1 = this.classUnderTest();
        ImmutableFloatBooleanMap expected = this.newWithKeysValues(31.0f, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(FloatArrayList.newListWith(0.0f, 32.0f)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
