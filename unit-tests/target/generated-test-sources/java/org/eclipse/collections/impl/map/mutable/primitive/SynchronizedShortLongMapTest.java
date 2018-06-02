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
 * JUnit test for {@link SynchronizedShortLongMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortLongMapTest extends AbstractMutableShortLongMapTestCase
{
    private final SynchronizedShortLongMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortLongMap classUnderTest()
    {
        return new SynchronizedShortLongMap(ShortLongHashMap.newWithKeysValues((short) 0, 0L, (short) 31, 31L, (short) 32, 32L));
    }

    @Override
    protected SynchronizedShortLongMap newWithKeysValues(short key1, long value1)
    {
        return new SynchronizedShortLongMap(new ShortLongHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2)
    {
        return new SynchronizedShortLongMap(new ShortLongHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3)
    {
        return new SynchronizedShortLongMap(new ShortLongHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortLongMap newWithKeysValues(short key1, long value1, short key2, long value2, short key3, long value3, short key4, long value4)
    {
        return new SynchronizedShortLongMap(new ShortLongHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortLongMap getEmptyMap()
    {
        return new SynchronizedShortLongMap(new ShortLongHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
