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

import org.eclipse.collections.api.map.primitive.ImmutableByteCharMap;
import org.eclipse.collections.impl.list.mutable.primitive.ByteArrayList;
import org.eclipse.collections.impl.map.mutable.primitive.ByteCharHashMap;
import org.eclipse.collections.impl.math.MutableCharacter;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link ImmutableByteCharHashMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapTest.stg.
 */
public class ImmutableByteCharHashMapTest extends AbstractImmutableByteCharMapTestCase
{
    @Override
    @Test
    public void toImmutable()
    {
        super.toImmutable();
        ImmutableByteCharMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.toImmutable());
    }

    @Test
    public void newWithKeyValue()
    {
        ImmutableByteCharMap map1 = this.classUnderTest();
        ImmutableByteCharMap expected = this.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31, (byte) 32, (char) 32, (byte) 33, (char) 33);
        Assert.assertEquals(expected, map1.newWithKeyValue((byte) 33, (char) 33));
        Assert.assertNotSame(map1, map1.newWithKeyValue((byte) 33, (char) 33));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutKeyValue()
    {
        ImmutableByteCharMap map1 = this.classUnderTest();
        ImmutableByteCharMap expected = this.newWithKeysValues((byte) 0, (char) 0, (byte) 31, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutKey((byte) 32));
        Assert.assertNotSame(map1, map1.newWithoutKey((byte) 32));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void newWithoutAllKeys()
    {
        ImmutableByteCharMap map1 = this.classUnderTest();
        ImmutableByteCharMap expected = this.newWithKeysValues((byte) 31, (char) 31);
        Assert.assertEquals(expected, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertNotSame(map1, map1.newWithoutAllKeys(ByteArrayList.newListWith((byte) 0, (byte) 32)));
        Assert.assertEquals(this.classUnderTest(), map1);
    }

    @Test
    public void injectInto()
    {
        ImmutableByteCharHashMap iterable = new ImmutableByteCharHashMap(ByteCharHashMap.newWithKeysValues((byte) 1, (char) 1, (byte) 2, (char) 2, (byte) 3, (char) 3));
        MutableCharacter result = iterable.injectInto(new MutableCharacter((char) 0), MutableCharacter::add);
        Assert.assertEquals(new MutableCharacter((char) 6), result);
    }
}
