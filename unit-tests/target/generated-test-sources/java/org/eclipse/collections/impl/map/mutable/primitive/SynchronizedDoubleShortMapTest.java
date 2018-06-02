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
 * JUnit test for {@link SynchronizedDoubleShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedDoubleShortMapTest extends AbstractMutableDoubleShortMapTestCase
{
    private final SynchronizedDoubleShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleShortMap classUnderTest()
    {
        return new SynchronizedDoubleShortMap(DoubleShortHashMap.newWithKeysValues(0.0, (short) 0, 31.0, (short) 31, 32.0, (short) 32));
    }

    @Override
    protected SynchronizedDoubleShortMap newWithKeysValues(double key1, short value1)
    {
        return new SynchronizedDoubleShortMap(new DoubleShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2)
    {
        return new SynchronizedDoubleShortMap(new DoubleShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3)
    {
        return new SynchronizedDoubleShortMap(new DoubleShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleShortMap newWithKeysValues(double key1, short value1, double key2, short value2, double key3, short value3, double key4, short value4)
    {
        return new SynchronizedDoubleShortMap(new DoubleShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleShortMap getEmptyMap()
    {
        return new SynchronizedDoubleShortMap(new DoubleShortHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
