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
import org.eclipse.collections.impl.map.primitive.AbstractObjectLongMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedObjectLongMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedObjectLongMapKeyValuesViewTest extends AbstractObjectLongMapKeyValuesViewTestCase
{
    @Override
    public <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2, T key3, long value3)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1, T key2, long value2)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public <T> MutableObjectLongMap<T> newWithKeysValues(T key1, long value1)
    {
        return ObjectLongHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableObjectLongMap<Object> newEmpty()
    {
        return ObjectLongHashMap.newMap().asSynchronized();
    }
}
