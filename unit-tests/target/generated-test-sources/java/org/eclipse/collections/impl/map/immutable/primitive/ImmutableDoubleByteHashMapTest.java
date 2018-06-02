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

import org.eclipse.collections.api.map.primitive.ImmutableDoubleByteMap;
import org.eclipse.collections.impl.list.mutable.primitive.DoubleArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.DoubleByteHashMap;
import org.eclipse.collections.impl.math.MutableByte;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableDoubleByteHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableDoubleByteHashMapTest extends AbstractImmutableDoubleByteMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableDoubleByteMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableDoubleByteMap map1 = this.classUnderTest();
        ImmutableDoubleByteMap expected = this.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31, 32.0, (byte) 32, 33.0, (byte) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33.0, (byte) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33.0, (byte) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableDoubleByteMap map1 = this.classUnderTest();
        ImmutableDoubleByteMap expected = this.newWithKeysValues(0.0, (byte) 0, 31.0, (byte) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32.0));
        Assert.assertNotSame(map1, map1.newWithoutKey(32.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableDoubleByteMap map1 = this.classUnderTest();
        ImmutableDoubleByteMap expected = this.newWithKeysValues(31.0, (byte) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(DoubleArrayList.newListWith(0.0, 32.0)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableDoubleByteHashMap iterable = new ImmutableDoubleByteHashMap(DoubleByteHashMap.newWithKeysValues(1.0, (byte) 1, 2.0, (byte) 2, 3.0, (byte) 3));
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }
}
