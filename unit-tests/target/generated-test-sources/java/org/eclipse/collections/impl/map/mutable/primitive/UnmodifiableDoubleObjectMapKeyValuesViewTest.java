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

import org.eclipse.collections.api.map.primitive.MutableDoubleObjectMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleObjectMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableDoubleObjectMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitiveObjectMapKeyValuesViewTest.stg.
 */
public class UnmodifiableDoubleObjectMapKeyValuesViewTest extends AbstractDoubleObjectMapKeyValuesViewTestCase
{
    @Override
    public MutableDoubleObjectMap<Integer> newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3)
    {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableDoubleObjectMap<Integer> newWithKeysValues(double key1, int value1, double key2, int value2)
    {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableDoubleObjectMap<Integer> newWithKeysValues(double key1, int value1)
    {
        return DoubleObjectHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableDoubleObjectMap<Integer> newEmpty()
    {
        return DoubleObjectHashMap.<Integer>newMap().asUnmodifiable();
    }
}
