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

import org.eclipse.collections.api.map.primitive.MutableObjectDoubleMap;

/**
 * JUnit test for {@link ObjectDoubleHashMap}.
 * This file was automatically generated from template file objectPrimitiveHashMapTest.stg.
 */
public class ObjectDoubleHashMapTest extends ObjectDoubleHashMapTestCase
{
    @Override
    protected ObjectDoubleHashMap<String> classUnderTest()
    {
        return ObjectDoubleHashMap.newWithKeysValues("0", 0.0, "1", 1.0, "2", 2.0);
    }

    @Override
    protected <T> ObjectDoubleHashMap<T> newWithKeysValues(T key1, double value1)
    {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    protected <T> ObjectDoubleHashMap<T> newWithKeysValues(T key1, double value1, T key2, double value2)
    {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    protected <T> ObjectDoubleHashMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3)
    {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected <T> ObjectDoubleHashMap<T> newWithKeysValues(T key1, double value1, T key2, double value2, T key3, double value3, T key4, double value4)
    {
        return ObjectDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected <T> ObjectDoubleHashMap<T> getEmptyMap()
    {
        return new ObjectDoubleHashMap<>();
    }

    @Override
    protected MutableObjectDoubleMap newMapWithInitialCapacity(int size)
    {
        return new ObjectDoubleHashMap<>(size);
    }

    @Override
    protected Class getTargetClass()
    {
        return ObjectDoubleHashMap.class;
    }
}
