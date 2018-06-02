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

import org.eclipse.collections.api.map.primitive.ImmutableIntByteMap;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.IntByteHashMap;
import org.eclipse.collections.impl.math.MutableByte;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableIntByteHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableIntByteHashMapTest extends AbstractImmutableIntByteMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableIntByteMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableIntByteMap map1 = this.classUnderTest();
        ImmutableIntByteMap expected = this.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32, 33, (byte) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue(33, (byte) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue(33, (byte) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableIntByteMap map1 = this.classUnderTest();
        ImmutableIntByteMap expected = this.newWithKeysValues(0, (byte) 0, 31, (byte) 31);
        Assert.assertEquals(expected, map1.newWithoutKey(32));
        Assert.assertNotSame(map1, map1.newWithoutKey(32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableIntByteMap map1 = this.classUnderTest();
        ImmutableIntByteMap expected = this.newWithKeysValues(31, (byte) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(IntArrayList.newListWith(0, 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableIntByteHashMap iterable = new ImmutableIntByteHashMap(IntByteHashMap.newWithKeysValues(1, (byte) 1, 2, (byte) 2, 3, (byte) 3));
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }
}
