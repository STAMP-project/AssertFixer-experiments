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

import org.eclipse.collections.api.map.primitive.MutableDoubleBooleanMap;
import org.eclipse.collections.impl.map.primitive.AbstractDoubleBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link UnmodifiableDoubleBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file unmodifiablePrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class UnmodifiableDoubleBooleanMapKeyValuesViewTest extends AbstractDoubleBooleanMapKeyValuesViewTestCase
{
    @Override
    public MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2, double key3, boolean value3)
    {
        return DoubleBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asUnmodifiable();
    }

    @Override
    public MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1, double key2, boolean value2)
    {
        return DoubleBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).asUnmodifiable();
    }

    @Override
    public MutableDoubleBooleanMap newWithKeysValues(double key1, boolean value1)
    {
        return DoubleBooleanHashMap.newWithKeysValues(key1, value1).asUnmodifiable();
    }

    @Override
    public MutableDoubleBooleanMap newEmpty()
    {
        return new DoubleBooleanHashMap().asUnmodifiable();
    }
}
