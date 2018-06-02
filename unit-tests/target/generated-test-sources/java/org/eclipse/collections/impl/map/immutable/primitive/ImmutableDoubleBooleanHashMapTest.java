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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleBooleanMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleBooleanHashMap}.
 * This file was automatically generated from template file immutablePrimitiveBooleanHashMapTest.stg.
 */
public class ImmutableDoubleBooleanHashMapTest extends AbstractImmutableDoubleBooleanMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        ImmutableDoubleBooleanMap expected = this.newWithKeysValues(0.0, true, 31.0, false, 32.0, true, 33.0, false);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, false));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, false));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        ImmutableDoubleBooleanMap expected = this.newWithKeysValues(0.0, true, 31.0, false);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleBooleanMap map1 = this.classUnderTest();
        ImmutableDoubleBooleanMap expected = this.newWithKeysValues(31.0, false);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }
}
