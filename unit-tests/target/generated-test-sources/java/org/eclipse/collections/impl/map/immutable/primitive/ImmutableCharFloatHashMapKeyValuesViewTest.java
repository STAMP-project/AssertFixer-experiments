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

import org.eclipse.collections.api.map.primitive.ImmutableCharFloatMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableCharFloatHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableCharFloatHashMapKeyValuesViewTest extends AbstractCharFloatMapKeyValuesViewTestCase
{
    @Override
    public ImmutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2, char key3, float value3)
    {
        return CharFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableCharFloatMap newWithKeysValues(char key1, float value1, char key2, float value2)
    {
        return CharFloatHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableCharFloatMap newWithKeysValues(char key1, float value1)
    {
        return CharFloatHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableCharFloatMap newEmpty()
    {
        return new CharFloatHashMap().toImmutable();
    }
}
