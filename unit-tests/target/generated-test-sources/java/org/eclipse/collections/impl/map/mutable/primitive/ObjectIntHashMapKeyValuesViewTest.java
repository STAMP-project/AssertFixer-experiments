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

import org.eclipse.collections.api.map.primitive.ObjectIntMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectIntMapKeyValuesViewTestCase;

/**
 * JUnit test for {@link ObjectIntHashMap#keyValuesView()}.
 * This file was automatically generated from template file objectPrimitiveHashMapKeyValuesViewTest.stg.
 */
public class ObjectIntHashMapKeyValuesViewTest extends AbstractObjectIntMapKeyValuesViewTestCase
{
    @Override
    public <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2, T key3, int value3)
    {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3);
    }

    @Override
    public <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1, T key2, int value2)
    {
        return ObjectIntHashMap.newWithKeysValues(key1, value1, key2, value2);
    }

    @Override
    public <T> ObjectIntMap<T> newWithKeysValues(T key1, int value1)
    {
        return ObjectIntHashMap.newWithKeysValues(key1, value1);
    }

    @Override
    public ObjectIntMap<Integer> newEmpty()
    {
        return ObjectIntHashMap.newMap();
    }
}
