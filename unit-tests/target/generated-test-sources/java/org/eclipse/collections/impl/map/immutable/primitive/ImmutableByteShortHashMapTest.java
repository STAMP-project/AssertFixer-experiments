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

import org.eclipse.collections.api.map.primitive.ImmutableByteShortMap;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteShortHashMap;
import org.eclipse.collections.impl.math.MutableShort;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteShortHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableByteShortHashMapTest extends AbstractImmutableByteShortMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableByteShortMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteShortMap map1 = this.classUnderTest();
        ImmutableByteShortMap expected = this.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32, (byte) 33, (short) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 33, (short) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 33, (short) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteShortMap map1 = this.classUnderTest();
        ImmutableByteShortMap expected = this.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutKey((byte) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteShortMap map1 = this.classUnderTest();
        ImmutableByteShortMap expected = this.newWithKeysValues((byte) 31, (short) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableByteShortHashMap iterable = new ImmutableByteShortHashMap(ByteShortHashMap.newWithKeysValues((byte) 1, (short) 1, (byte) 2, (short) 2, (byte) 3, (short) 3));
        MutableShort result = iterable.injectInto(new MutableShort((short) 0), MutableShort::add);
        Assert.assertEquals(new MutableShort((short) 6), result);
    }
}
