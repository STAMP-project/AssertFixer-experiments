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
 * JUnit test for {@link SynchronizedObjectCharMap}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapTest.stg.
 */
public class SynchronizedObjectCharMapTest extends AbstractMutableObjectCharMapTestCase
{
    private final SynchronizedObjectCharMap<String> map = this.classUnderTest();

    @Override
    protected SynchronizedObjectCharMap<String> classUnderTest()
    {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues("0", (char) 0, "1", (char) 1, "2", (char) 2));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1)
    {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2)
    {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3)
    {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3, T key4, char value4)
    {
        return new SynchronizedObjectCharMap<>(ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected <T> SynchronizedObjectCharMap<T> getEmptyMap()
    {
        return new SynchronizedObjectCharMap<>(new ObjectCharHashMap<>());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
