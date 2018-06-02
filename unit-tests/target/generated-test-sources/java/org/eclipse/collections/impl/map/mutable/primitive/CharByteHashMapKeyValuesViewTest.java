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

import org.eclipse.collections.impl.map.primitive.AbstractCharByteMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link CharByteHashMap#keyValuesView()}.
 * This file was automatically generated from template file primitivePrimitiveHashMapKeyValuesViewTest.stg.
 */
public class CharByteHashMapKeyValuesViewTest extends AbstractCharByteMapKeyValuesViewTestCase
{
    @Override
    public CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2, char key3, byte value3)
    {
        return CharByteHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public CharByteHashMap newWithKeysValues(char key1, byte value1, char key2, byte value2)
    {
        return CharByteHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public CharByteHashMap newWithKeysValues(char key1, byte value1)
    {
        return CharByteHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public CharByteHashMap newEmpty()
    {
        return new CharByteHashMap();
    }
}
