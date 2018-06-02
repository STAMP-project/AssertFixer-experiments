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
 * JUnit test for {@link SynchronizedShortFloatMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedShortFloatMapTest extends AbstractMutableShortFloatMapTestCase
{
    private final SynchronizedShortFloatMap map = this.classUnderTest();

    @Override
    protected SynchronizedShortFloatMap classUnderTest()
    {
        return new SynchronizedShortFloatMap(ShortFloatHashMap.newWithKeysValues((short) 0, 0.0f, (short) 31, 31.0f, (short) 32, 32.0f));
    }

    @Override
    protected SynchronizedShortFloatMap newWithKeysValues(short key1, float value1)
    {
        return new SynchronizedShortFloatMap(new ShortFloatHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2)
    {
        return new SynchronizedShortFloatMap(new ShortFloatHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3)
    {
        return new SynchronizedShortFloatMap(new ShortFloatHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedShortFloatMap newWithKeysValues(short key1, float value1, short key2, float value2, short key3, float value3, short key4, float value4)
    {
        return new SynchronizedShortFloatMap(new ShortFloatHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedShortFloatMap getEmptyMap()
    {
        return new SynchronizedShortFloatMap(new ShortFloatHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
