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

import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.impl.map.mutable.primitive.IntBooleanHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractIntBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableIntBooleanHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableIntBooleanHashMapKeyValuesViewTest extends AbstractIntBooleanMapKeyValuesViewTestCase
{
    @Override
    public ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2, int key3, boolean value3)
    {
        return IntBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1, int key2, boolean value2)
    {
        return IntBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableIntBooleanMap newWithKeysValues(int key1, boolean value1)
    {
        return IntBooleanHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableIntBooleanMap newEmpty()
    {
        return new IntBooleanHashMap().toImmutable();
    }
}
