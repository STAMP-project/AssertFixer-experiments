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

import org.eclipse.collections.api.map.primitive.MutableFloatCharMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatCharMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedFloatCharMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedFloatCharMapKeyValuesViewTest extends AbstractFloatCharMapKeyValuesViewTestCase
{
    @Override
    public MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2, float key3, char value3)
    {
        return FloatCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableFloatCharMap newWithKeysValues(float key1, char value1, float key2, char value2)
    {
        return FloatCharHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableFloatCharMap newWithKeysValues(float key1, char value1)
    {
        return FloatCharHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableFloatCharMap newEmpty()
    {
        return new FloatCharHashMap().asSynchronized();
    }
}
