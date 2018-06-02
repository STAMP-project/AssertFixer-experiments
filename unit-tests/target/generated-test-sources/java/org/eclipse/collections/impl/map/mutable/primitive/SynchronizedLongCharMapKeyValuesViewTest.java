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

import org.eclipse.collections.api.map.primitive.MutableLongCharMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedLongCharMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedLongCharMapKeyValuesViewTest extends AbstractLongCharMapKeyValuesViewTestCase
{
    @Override
    public MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3)
    {
        return LongCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableLongCharMap newWithKeysValues(long key1, char value1, long key2, char value2)
    {
        return LongCharHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableLongCharMap newWithKeysValues(long key1, char value1)
    {
        return LongCharHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableLongCharMap newEmpty()
    {
        return new LongCharHashMap().asSynchronized();
    }
}
