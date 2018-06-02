/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link SynchronizedByteShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedByteShortMapTest extends AbstractMutableByteShortMapTestCase
{
    private final SynchronizedByteShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedByteShortMap classUnderTest()
    {
        return new SynchronizedByteShortMap(ByteShortHashMap.newWithKeysValues((byte) 0, (short) 0, (byte) 31, (short) 31, (byte) 32, (short) 32));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1)
    {
        return new SynchronizedByteShortMap(new ByteShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2)
    {
        return new SynchronizedByteShortMap(new ByteShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3)
    {
        return new SynchronizedByteShortMap(new ByteShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteShortMap newWithKeysValues(byte key1, short value1, byte key2, short value2, byte key3, short value3, byte key4, short value4)
    {
        return new SynchronizedByteShortMap(new ByteShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteShortMap getEmptyMap()
    {
        return new SynchronizedByteShortMap(new ByteShortHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
