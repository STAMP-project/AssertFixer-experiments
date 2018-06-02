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

import org.eclipse.collections.api.map.primitive.MutableLongBooleanMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedLongBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedLongBooleanMapKeyValuesViewTest extends AbstractLongBooleanMapKeyValuesViewTestCase
{
    @Override
    public MutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2, long key3, boolean value3)
    {
        return LongBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableLongBooleanMap newWithKeysValues(long key1, boolean value1, long key2, boolean value2)
    {
        return LongBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableLongBooleanMap newWithKeysValues(long key1, boolean value1)
    {
        return LongBooleanHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableLongBooleanMap newEmpty()
    {
        return new LongBooleanHashMap().asSynchronized();
    }
}
