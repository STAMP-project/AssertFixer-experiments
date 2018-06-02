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

import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedObjectCharMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedObjectCharMapKeyValuesViewTest extends AbstractObjectCharMapKeyValuesViewTestCase
{
    @Override
    public <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3)
    {
        return ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2)
    {
        return ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1)
    {
        return ObjectCharHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableObjectCharMap<Object> newEmpty()
    {
        return ObjectCharHashMap.newMap().asSynchronized();
    }
}
