/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.immutable.primitive;

import org.eclipse.collections.api.map.primitive.ImmutableLongByteMap;
import org.eclipse.collections.impl.map.mutable.primitive.LongByteHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractLongByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableLongByteHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableLongByteHashMapKeyValuesViewTest extends AbstractLongByteMapKeyValuesViewTestCase
{
    @Override
    public ImmutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2, long key3, byte value3)
    {
        return LongByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableLongByteMap newWithKeysValues(long key1, byte value1, long key2, byte value2)
    {
        return LongByteHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableLongByteMap newWithKeysValues(long key1, byte value1)
    {
        return LongByteHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableLongByteMap newEmpty()
    {
        return new LongByteHashMap().toImmutable();
    }
}
