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

import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.LongArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableLongBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableLongBooleanHashMapTest extends AbstractImmutableLongBooleanMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        ImmutableLongBooleanMap expected = this.newWithKeysValues(0L, true, 31L, false, 32L, true, 33L, false);
        Assert.assertEquals(expected, map1.newWithKeyValue(33L, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33L, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        ImmutableLongBooleanMap expected = this.newWithKeysValues(0L, true, 31L, false);
        Assert.assertEquals(expected, map1.newWithoutKey(32L));
        Assert.assertNotSame(map1, map1.newWithoutKey(32L));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableLongBooleanMap map1 = this.classUnderTest();
        ImmutableLongBooleanMap expected = this.newWithKeysValues(31L, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(LongArrayList.newListWith(0L, 32L)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
