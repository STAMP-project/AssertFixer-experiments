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

import org.eclipse.collections.api.map.primitive.ImmutableByteObjectMap;
import org.eclipse.collections.impl.map.mutable.primitive.ByteObjectHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableByteObjectHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitiveObjectHashMapKeyValuesViewTest.stg.
 */
public class ImmutableByteObjectMapKeyValuesViewTest extends AbstractByteObjectMapKeyValuesViewTestCase
{
    @Override
    public ImmutableByteObjectMap<Integer> newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3)
    {
        return ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableByteObjectMap<Integer> newWithKeysValues(byte key1, int value1, byte key2, int value2)
    {
        return ByteObjectHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableByteObjectMap<Integer> newWithKeysValues(byte key1, int value1)
    {
        return ByteObjectHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableByteObjectMap<Integer> newEmpty()
    {
        return ByteObjectHashMap.<Integer>newMap().toImmutable();
    }
}
