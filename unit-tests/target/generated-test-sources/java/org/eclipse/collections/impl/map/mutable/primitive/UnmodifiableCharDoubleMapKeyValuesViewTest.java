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

import org.eclipse.collections.api.map.primitive.MutableCharDoubleMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharDoubleMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableCharDoubleMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableCharDoubleMapKeyValuesViewTest extends AbstractCharDoubleMapKeyValuesViewTestCase
{
    @Override
    public MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2, char key3, double value3)
    {
        return CharDoubleHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableCharDoubleMap newWithKeysValues(char key1, double value1, char key2, double value2)
    {
        return CharDoubleHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableCharDoubleMap newWithKeysValues(char key1, double value1)
    {
        return CharDoubleHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableCharDoubleMap newEmpty()
    {
        return new CharDoubleHashMap().asUnmodifiable();
    }
}
