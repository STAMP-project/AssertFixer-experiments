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
 * JUnit test for {@link SynchronizedDoubleObjectMap}.
 * This file was automatically generated from template file synchronizedPrimitiveObjectMapTest.stg.
 */
public class SynchronizedDoubleObjectMapTest extends AbstractMutableDoubleObjectMapTestCase
{
    private final SynchronizedDoubleObjectMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedDoubleObjectMap<String> classUnderTest()
    {
        return new SynchronizedDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(0.0, "zero", 31.0, "thirtyOne", 32.0, "thirtyTwo"));
    }

    @Override
    protected <T> SynchronizedDoubleObjectMap<T> newWithKeysValues(double key1, T value1)
    {
        return new SynchronizedDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedDoubleObjectMap<T> newWithKeysValues(double key1, T value1, double key2, T value2)
    {
        return new SynchronizedDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedDoubleObjectMap<T> newWithKeysValues(double key1, T value1, double key2, T value2, double key3, T value3)
    {
        return new SynchronizedDoubleObjectMap<>(DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedDoubleObjectMap<T> getEmptyMap()
    {
        return new SynchronizedDoubleObjectMap<>(new DoubleObjectHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
