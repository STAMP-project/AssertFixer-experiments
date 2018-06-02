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

import org.eclipse.collections.api.map.primitive.ImmutableCharIntMap;
import org.eclipse.collections.impl.map.mutable.primitive.CharIntHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ImmutableCharIntHashMap#keyValuesView()}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ImmutableCharIntHashMapKeyValuesViewTest extends AbstractCharIntMapKeyValuesViewTestCase
{
    @Override
    public ImmutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2, char key3, int value3)
    {
        return CharIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    public ImmutableCharIntMap newWithKeysValues(char key1, int value1, char key2, int value2)
    {
        return CharIntHashMap.newWithKeysValues(key1, value1, key2, value2).toImmutable();
    }

    @Override
    public ImmutableCharIntMap newWithKeysValues(char key1, int value1)
    {
        return CharIntHashMap.newWithKeysValues(key1, value1).toImmutable();
    }

    @Override
    public ImmutableCharIntMap newEmpty()
    {
        return new CharIntHashMap().toImmutable();
    }
}
