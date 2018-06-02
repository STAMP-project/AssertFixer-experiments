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
 * JUnit test for {@link SynchronizedLongShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedLongShortMapTest extends AbstractMutableLongShortMapTestCase
{
    private final SynchronizedLongShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedLongShortMap classUnderTest()
    {
        return new SynchronizedLongShortMap(LongShortHashMap.newWithKeysValues(0L, (short) 0, 31L, (short) 31, 32L, (short) 32));
    }

    @Override
    protected SynchronizedLongShortMap newWithKeysValues(long key1, short value1)
    {
        return new SynchronizedLongShortMap(new LongShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2)
    {
        return new SynchronizedLongShortMap(new LongShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3)
    {
        return new SynchronizedLongShortMap(new LongShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedLongShortMap newWithKeysValues(long key1, short value1, long key2, short value2, long key3, short value3, long key4, short value4)
    {
        return new SynchronizedLongShortMap(new LongShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedLongShortMap getEmptyMap()
    {
        return new SynchronizedLongShortMap(new LongShortHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
