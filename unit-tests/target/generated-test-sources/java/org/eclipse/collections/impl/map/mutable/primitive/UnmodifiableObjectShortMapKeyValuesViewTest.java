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
import org.eclipse.collections.impl.map.primitive.AbstractObjectShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableObjectShortMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiableObjectPrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableObjectShortMapKeyValuesViewTest extends AbstractObjectShortMapKeyValuesViewTestCase
{
    @Override
    public <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2, T key3, short value3)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1, T key2, short value2)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public <T> MutableObjectShortMap<T> newWithKeysValues(T key1, short value1)
    {
        return ObjectShortHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableObjectShortMap<Object> newEmpty()
    {
        return ObjectShortHashMap.newMap().asUnmodifiable();
    }
}
