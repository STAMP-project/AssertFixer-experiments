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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleIntMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleIntHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableDoubleIntHashMapTest extends AbstractImmutableDoubleIntMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        ImmutableDoubleIntMap expected = this.newWithKeysValues(0.0, 0, 31.0, 31, 32.0, 32, 33.0, 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        ImmutableDoubleIntMap expected = this.newWithKeysValues(0.0, 0, 31.0, 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleIntMap map1 = this.classUnderTest();
        ImmutableDoubleIntMap expected = this.newWithKeysValues(31.0, 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableDoubleIntHashMap iterable = new ImmutableDoubleIntHashMap(DoubleIntHashMap.newWithKeysValues(1.0, 1, 2.0, 2, 3.0, 3));
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }
}
