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
 * JUnit test for {@link SynchronizedIntByteMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedIntByteMapTest extends AbstractMutableIntByteMapTestCase
{
    private final SynchronizedIntByteMap map = this.classUnderTest();

    @Override
    protected SynchronizedIntByteMap classUnderTest()
    {
        return new SynchronizedIntByteMap(IntByteHashMap.newWithKeysValues(0, (byte) 0, 31, (byte) 31, 32, (byte) 32));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1)
    {
        return new SynchronizedIntByteMap(new IntByteHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2)
    {
        return new SynchronizedIntByteMap(new IntByteHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3)
    {
        return new SynchronizedIntByteMap(new IntByteHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3, int key4, byte value4)
    {
        return new SynchronizedIntByteMap(new IntByteHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntByteMap getEmptyMap()
    {
        return new SynchronizedIntByteMap(new IntByteHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
