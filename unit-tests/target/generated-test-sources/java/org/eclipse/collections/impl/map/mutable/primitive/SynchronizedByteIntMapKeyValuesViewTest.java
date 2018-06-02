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

import org.eclipse.collections.api.map.primitive.MutableByteIntMap;
import org.eclipse.collections.impl.map.primitive.AbstractByteIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedByteIntMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedByteIntMapKeyValuesViewTest extends AbstractByteIntMapKeyValuesViewTestCase
{
    @Override
    public MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2, byte key3, int value3)
    {
        return ByteIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableByteIntMap newWithKeysValues(byte key1, int value1, byte key2, int value2)
    {
        return ByteIntHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableByteIntMap newWithKeysValues(byte key1, int value1)
    {
        return ByteIntHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableByteIntMap newEmpty()
    {
        return new ByteIntHashMap().asSynchronized();
    }
}
