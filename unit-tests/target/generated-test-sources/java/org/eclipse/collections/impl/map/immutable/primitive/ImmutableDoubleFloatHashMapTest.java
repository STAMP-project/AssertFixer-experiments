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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleFloatMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleFloatHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableDoubleFloatHashMapTest extends AbstractImmutableDoubleFloatMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleFloatMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleFloatMap map1 = this.classUnderTest();
        ImmutableDoubleFloatMap expected = this.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f, 32.0, 32.0f, 33.0, 33.0f);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, 33.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, 33.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleFloatMap map1 = this.classUnderTest();
        ImmutableDoubleFloatMap expected = this.newWithKeysValues(0.0, 0.0f, 31.0, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleFloatMap map1 = this.classUnderTest();
        ImmutableDoubleFloatMap expected = this.newWithKeysValues(31.0, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableDoubleFloatHashMap iterable = new ImmutableDoubleFloatHashMap(DoubleFloatHashMap.newWithKeysValues(1.0, 1.0f, 2.0, 2.0f, 3.0, 3.0f));
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }
}
