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

import org.eclipse.collections.impl.map.primitive.AbstractIntFloatMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link IntFloatHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class IntFloatHashMapKeyValuesViewTest extends AbstractIntFloatMapKeyValuesViewTestCase
{
    @Override
    public IntFloatHashMap newWithKeysValues(int key1, float value1, int key2, float value2, int key3, float value3)
    {
        return IntFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public IntFloatHashMap newWithKeysValues(int key1, float value1, int key2, float value2)
    {
        return IntFloatHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public IntFloatHashMap newWithKeysValues(int key1, float value1)
    {
        return IntFloatHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public IntFloatHashMap newEmpty()
    {
        return new IntFloatHashMap();
    }
}
