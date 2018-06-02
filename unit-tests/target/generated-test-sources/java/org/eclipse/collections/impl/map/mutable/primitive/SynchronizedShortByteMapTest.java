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
 * JUnit test for {@link SynchronizedShortByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortByteMapTest extends AbstractMutableShortByteMapTestCase
{
    private final SynchronizedShortByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortByteMap classUnderTest()
    {
        return new SynchronizedShortByteMap(ShortByteHashMap.newWithKeysValues((short) 0, (byte) 0, (short) 31, (byte) 31, (short) 32, (byte) 32));
    }

    @Override
    protected SynchronizedShortByteMap newWithKeysValues(short key1, byte value1)
    {
        return new SynchronizedShortByteMap(new ShortByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2)
    {
        return new SynchronizedShortByteMap(new ShortByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3)
    {
        return new SynchronizedShortByteMap(new ShortByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortByteMap newWithKeysValues(short key1, byte value1, short key2, byte value2, short key3, byte value3, short key4, byte value4)
    {
        return new SynchronizedShortByteMap(new ShortByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortByteMap getEmptyMap()
    {
        return new SynchronizedShortByteMap(new ShortByteHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
