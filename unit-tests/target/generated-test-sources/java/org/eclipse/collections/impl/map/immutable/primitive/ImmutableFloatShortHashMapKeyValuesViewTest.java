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

import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.impl.map.mutable.primitive.FloatShortHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractFloatShortMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableFloatShortHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableFloatShortHashMapKeyValuesViewTest extends AbstractFloatShortMapKeyValuesViewTestCase
{
    @Override
    public ImmutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2, float key3, short value3)
    {
        return FloatShortHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableFloatShortMap newWithKeysValues(float key1, short value1, float key2, short value2)
    {
        return FloatShortHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableFloatShortMap newWithKeysValues(float key1, short value1)
    {
        return FloatShortHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableFloatShortMap newEmpty()
    {
        return new FloatShortHashMap().toImmutable();
    }
}
