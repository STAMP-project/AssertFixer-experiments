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

import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableIntBooleanHashMapTest extends AbstractImmutableIntBooleanMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableIntBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableIntBooleanMap map1 = this.classUnderTest();
        ImmutableIntBooleanMap expected = this.newWithKeysValues(0, true, 31, false, 32, true, 33, false);
        Assert.assertEquals(expected, map1.newWithKeyValue(33, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableIntBooleanMap map1 = this.classUnderTest();
        ImmutableIntBooleanMap expected = this.newWithKeysValues(0, true, 31, false);
        Assert.assertEquals(expected, map1.newWithoutKey(32));
        Assert.assertNotSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableIntBooleanMap map1 = this.classUnderTest();
        ImmutableIntBooleanMap expected = this.newWithKeysValues(31, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
