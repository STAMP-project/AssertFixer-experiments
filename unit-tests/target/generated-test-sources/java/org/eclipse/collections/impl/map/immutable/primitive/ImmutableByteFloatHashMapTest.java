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

import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteFloatHashMap;
import org.eclipse.collections.impl.math.MutableFloat;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteFloatHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableByteFloatHashMapTest extends AbstractImmutableByteFloatMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableByteFloatMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteFloatMap map1 = this.classUnderTest();
        ImmutableByteFloatMap expected = this.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f, (byte) 32, 32.0f, (byte) 33, 33.0f);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 33, 33.0f));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 33, 33.0f));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteFloatMap map1 = this.classUnderTest();
        ImmutableByteFloatMap expected = this.newWithKeysValues((byte) 0, 0.0f, (byte) 31, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutKey((byte) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteFloatMap map1 = this.classUnderTest();
        ImmutableByteFloatMap expected = this.newWithKeysValues((byte) 31, 31.0f);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableByteFloatHashMap iterable = new ImmutableByteFloatHashMap(ByteFloatHashMap.newWithKeysValues((byte) 1, 1.0f, (byte) 2, 2.0f, (byte) 3, 3.0f));
        MutableFloat result = iterable.injectInto(new MutableFloat(0.0f), MutableFloat::add);
        Assert.assertEquals(new MutableFloat(6.0f), result);
    }
}
