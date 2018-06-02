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
 * JUnit test for {@link SynchronizedCharBooleanMap}.
 * This file was automatically generated from template file synchronizedPrimitiveBooleanMapTest.stg.
 */
public class SynchronizedCharBooleanMapTest extends AbstractMutableCharBooleanMapTestCase
{
    @Override
    protected SynchronizedCharBooleanMap classUnderTest()
    {
        return new SynchronizedCharBooleanMap(CharBooleanHashMap.newWithKeysValues((char) 0, true, (char) 31, false, (char) 32, true));
    }

    @Override
    protected SynchronizedCharBooleanMap newWithKeysValues(char key1, boolean value1)
    {
        return new SynchronizedCharBooleanMap(new CharBooleanHashMap(1).withKeyValue(key1, value1));
    }

    @Override
    protected SynchronizedCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2)
    {
        return new SynchronizedCharBooleanMap(new CharBooleanHashMap(2).withKeysValues(key1, value1, key2, value2));
    }

    @Override
    protected SynchronizedCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3)
    {
        return new SynchronizedCharBooleanMap(new CharBooleanHashMap(3).withKeysValues(key1, value1, key2, value2, key3, value3));
    }

    @Override
    protected SynchronizedCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3, char key4, boolean value4)
    {
        return new SynchronizedCharBooleanMap(new CharBooleanHashMap(4).withKeysValues(key1, value1, key2, value2, key3, value3, key4, value4));
    }

    @Override
    protected SynchronizedCharBooleanMap getEmptyMap()
    {
        return new SynchronizedCharBooleanMap(new CharBooleanHashMap());
    }

    @Override
    @Test
    public void asSynchronized()
    {
        super.asSynchronized();
        SynchronizedCharBooleanMap map1 = this.classUnderTest();
        Assert.assertSame(map1, map1.asSynchronized());
    }
}
