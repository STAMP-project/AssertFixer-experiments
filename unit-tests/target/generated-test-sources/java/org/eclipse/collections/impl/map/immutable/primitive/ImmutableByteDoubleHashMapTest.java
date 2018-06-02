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

import org.eclipse.collections.api.map.primitive.ImmutableByteDoubleMap;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteDoubleHashMap;
import org.eclipse.collections.impl.math.MutableDouble;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteDoubleHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableByteDoubleHashMapTest extends AbstractImmutableByteDoubleMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableByteDoubleMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteDoubleMap map1 = this.classUnderTest();
        ImmutableByteDoubleMap expected = this.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0, (byte) 32, 32.0, (byte) 33, 33.0);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 33, 33.0));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 33, 33.0));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteDoubleMap map1 = this.classUnderTest();
        ImmutableByteDoubleMap expected = this.newWithKeysValues((byte) 0, 0.0, (byte) 31, 31.0);
        Assert.assertEquals(expected, map1.newWithoutKey((byte) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteDoubleMap map1 = this.classUnderTest();
        ImmutableByteDoubleMap expected = this.newWithKeysValues((byte) 31, 31.0);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableByteDoubleHashMap iterable = new ImmutableByteDoubleHashMap(ByteDoubleHashMap.newWithKeysValues((byte) 1, 1.0, (byte) 2, 2.0, (byte) 3, 3.0));
        MutableDouble result = iterable.injectInto(new MutableDouble(0.0), MutableDouble::add);
        Assert.assertEquals(new MutableDouble(6.0), result);
    }
}
