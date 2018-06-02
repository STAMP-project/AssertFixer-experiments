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

import org.eclipse.collections.api.map.primitive.MutableObjectLongMap;

/**
 * JUnit test for {@link ObjectLongHashMap#keySet()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeySetTest.stg.
 */
public class ObjectLongHashMapKeySetTest extends ObjectLongHashMapKeySetTestCase
{
    @Override
    public ObjectLongHashMap<String> newMapWithKeysValues(String key1, long value1)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectLongHashMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectLongHashMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2, String key3, long value3)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectLongHashMap<String> newMapWithKeysValues(String key1, long value1, String key2, long value2, String key3, long value3, String key4, long value4)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectLongMap<String> newEmptyMap()
    {
        return ObjectLongHashMap.newMap();
    }
}
