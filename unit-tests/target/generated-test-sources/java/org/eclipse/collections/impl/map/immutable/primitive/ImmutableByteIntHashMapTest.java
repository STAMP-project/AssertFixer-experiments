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

import org.eclipse.collections.api.map.primitive.ImmutableByteIntMap;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteIntHashMap;
import org.eclipse.collections.impl.math.MutableInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteIntHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableByteIntHashMapTest extends AbstractImmutableByteIntMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableByteIntMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteIntMap map1 = this.classUnderTest();
        ImmutableByteIntMap expected = this.newWithKeysValues((byte) 0, 0, (byte) 31, 31, (byte) 32, 32, (byte) 33, 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 33, 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 33, 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteIntMap map1 = this.classUnderTest();
        ImmutableByteIntMap expected = this.newWithKeysValues((byte) 0, 0, (byte) 31, 31);
        Assert.assertEquals(expected, map1.newWithoutKey((byte) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteIntMap map1 = this.classUnderTest();
        ImmutableByteIntMap expected = this.newWithKeysValues((byte) 31, 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableByteIntHashMap iterable = new ImmutableByteIntHashMap(ByteIntHashMap.newWithKeysValues((byte) 1, 1, (byte) 2, 2, (byte) 3, 3));
        MutableInteger result = iterable.injectInto(new MutableInteger(0), MutableInteger::add);
        Assert.assertEquals(new MutableInteger(6), result);
    }
}
