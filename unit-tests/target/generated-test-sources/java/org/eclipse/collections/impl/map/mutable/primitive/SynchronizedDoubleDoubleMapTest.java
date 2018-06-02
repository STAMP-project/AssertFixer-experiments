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
 * JUnit test for {@link SynchronizedDoubleDoubleMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedDoubleDoubleMapTest extends AbstractMutableDoubleDoubleMapTestCase
{
    private final SynchronizedDoubleDoubleMap map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleDoubleMap classUnderTest()
    {
        return new SynchronizedDoubleDoubleMap(DoubleDoubleHashMap.newWithKeysValues(0.0, 0.0, 31.0, 31.0, 32.0, 32.0));
    }

    @Override
    protected SynchronizedDoubleDoubleMap newWithKeysValues(double key1, double value1)
    {
        return new SynchronizedDoubleDoubleMap(new DoubleDoubleHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2)
    {
        return new SynchronizedDoubleDoubleMap(new DoubleDoubleHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3)
    {
        return new SynchronizedDoubleDoubleMap(new DoubleDoubleHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedDoubleDoubleMap newWithKeysValues(double key1, double value1, double key2, double value2, double key3, double value3, double key4, double value4)
    {
        return new SynchronizedDoubleDoubleMap(new DoubleDoubleHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedDoubleDoubleMap getEmptyMap()
    {
        return new SynchronizedDoubleDoubleMap(new DoubleDoubleHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
