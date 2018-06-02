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
 * JUnit test for {@link SynchronizedIntBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedIntBooleanMapTest extends AbstractMutableIntBooleanMapTestCase
{
    @Override
    protected SynchronizedIntBooleanMap classUnderTest()
    {
        return new SynchronizedIntBooleanMap(IntBooleanHashMap.newWithKeysValues(0, true, 31, false, 32, true));
    }

    @Override
    protected SynchronizedIntBooleanMap newWithKeysValues(int key1, boolean value1)
    {
        return new SynchronizedIntBooleanMap(new IntBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2)
    {
        return new SynchronizedIntBooleanMap(new IntBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3)
    {
        return new SynchronizedIntBooleanMap(new IntBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3, int key4, boolean value4)
    {
        return new SynchronizedIntBooleanMap(new IntBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedIntBooleanMap getEmptyMap()
    {
        return new SynchronizedIntBooleanMap(new IntBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedIntBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }
}
