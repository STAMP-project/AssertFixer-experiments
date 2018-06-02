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
 * JUnit test for {@link SynchronizedCharShortMap}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapTest.stg.
 */
public class SynchronizedCharShortMapTest extends AbstractMutableCharShortMapTestCase
{
    private final SynchronizedCharShortMap map = this.classUnderTest();

    @Override
    protected SynchronizedCharShortMap classUnderTest()
    {
        return new SynchronizedCharShortMap(CharShortHashMap.newWithKeysValues((char) 0, (short) 0, (char) 31, (short) 31, (char) 32, (short) 32));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1)
    {
        return new SynchronizedCharShortMap(new CharShortHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2)
    {
        return new SynchronizedCharShortMap(new CharShortHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3)
    {
        return new SynchronizedCharShortMap(new CharShortHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharShortMap newWithKeysValues(char key1, short value1, char key2, short value2, char key3, short value3, char key4, short value4)
    {
        return new SynchronizedCharShortMap(new CharShortHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharShortMap getEmptyMap()
    {
        return new SynchronizedCharShortMap(new CharShortHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        Assert.assertSame(this.map, this.map.asSynchronized());
    }
}
