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

import org.eclipse.collections.api.map.primitive.ImmutableShortByteMap;
import org.eclipse.collections.impl.list.mutable.primitive.ShortArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ShortByteHashMap;
import org.eclipse.collections.impl.math.MutableByte;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableShortByteHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableShortByteHashMapTest extends AbstractImmutableShortByteMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableShortByteMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableShortByteMap map1 = this.classUnderTest();
        ImmutableShortByteMap expected = this.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32, (short) 33, (byte) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((short) 33, (byte) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((short) 33, (byte) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableShortByteMap map1 = this.classUnderTest();
        ImmutableShortByteMap expected = this.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31);
        Assert.assertEquals(expected, map1.newWithoutKey((short) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((short) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableShortByteMap map1 = this.classUnderTest();
        ImmutableShortByteMap expected = this.newWithKeysValues((short) 31, (byte) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ShortArrayList.newListWith((short) 0, (short) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableShortByteHashMap iterable = new ImmutableShortByteHashMap(ShortByteHashMap.newWithKeysValues((short) 1, (byte) 1, (short) 2, (byte) 2, (short) 3, (byte) 3));
        MutableByte result = iterable.injectInto(new MutableByte((byte) 0), MutableByte::add);
        Assert.assertEquals(new MutableByte((byte) 6), result);
    }
}
