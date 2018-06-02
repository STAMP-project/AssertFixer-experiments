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
 * JUnit test for {@link SynchronizedByteBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedByteBooleanMapTest extends AbstractMutableByteBooleanMapTestCase
{
    @Override
    protected SynchronizedByteBooleanMap classUnderTest()
    {
        return new SynchronizedByteBooleanMap(ByteBooleanHashMap.newWithKeysValues((byte) 0, true, (byte) 31, false, (byte) 32, true));
    }

    @Override
    protected SynchronizedByteBooleanMap newWithKeysValues(byte key1, boolean value1)
    {
        return new SynchronizedByteBooleanMap(new ByteBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2)
    {
        return new SynchronizedByteBooleanMap(new ByteBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3)
    {
        return new SynchronizedByteBooleanMap(new ByteBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedByteBooleanMap newWithKeysValues(byte key1, boolean value1, byte key2, boolean value2, byte key3, boolean value3, byte key4, boolean value4)
    {
        return new SynchronizedByteBooleanMap(new ByteBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedByteBooleanMap getEmptyMap()
    {
        return new SynchronizedByteBooleanMap(new ByteBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedByteBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }
}
