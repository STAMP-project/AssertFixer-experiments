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

import org.eclipse.collections.api.map.primitive.MutableCharBooleanMap;
import org.eclipse.collections.impl.map.primitive.AbstractCharBooleanMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link SynchronizedCharBooleanMap#keyValuesView()}.
 * This file was automatically generated from template file synchronizedPrimitivePrimitiveMapKeyValuesViewTest.stg.
 */
public class SynchronizedCharBooleanMapKeyValuesViewTest extends AbstractCharBooleanMapKeyValuesViewTestCase
{
    @Override
    public MutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2, char key3, boolean value3)
    {
        return CharBooleanHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    public MutableCharBooleanMap newWithKeysValues(char key1, boolean value1, char key2, boolean value2)
    {
        return CharBooleanHashMap.newWithKeysValues(key1, value1, key2, value2).asSynchronized();
    }

    @Override
    public MutableCharBooleanMap newWithKeysValues(char key1, boolean value1)
    {
        return CharBooleanHashMap.newWithKeysValues(key1, value1).asSynchronized();
    }

    @Override
    public MutableCharBooleanMap newEmpty()
    {
        return new CharBooleanHashMap().asSynchronized();
    }
}
