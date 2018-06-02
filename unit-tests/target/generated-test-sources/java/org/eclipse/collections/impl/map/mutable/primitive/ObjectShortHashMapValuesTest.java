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

import org.eclipse.collections.api.map.primitive.MutableObjectShortMap;

/**
 * JUnit test for {@link ObjectShortHashMap#values()}.
 * This file was automatically generated from template file objectPrimitiveHashMapValuesTest.stg.
 */
public class ObjectShortHashMapValuesTest extends ObjectShortHashMapValuesTestCase
{
    @Override
    public ObjectShortHashMap<String> newMapWithKeysValues(String key1, short value1)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectShortHashMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public ObjectShortHashMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public ObjectShortHashMap<String> newMapWithKeysValues(String key1, short value1, String key2, short value2, String key3, short value3, String key4, short value4)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    public MutableObjectShortMap<String> newEmptyMap()
    {
        return ObjectShortHashMap.newMap();
    }
}
