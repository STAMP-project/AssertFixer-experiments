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

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.map.primitive.ImmutableObjectFloatMap;
import org.eclipse.collections.impl.map.mutable.primitive.ObjectFloatHashMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectFloatMapKeysViewTestCase;

/**
 * JUnit test for {@link ImmutableObjectFloatHashMap#keysView()}.
 * This file was automatically generated from template file immutableObjectPrimitiveHashMapKeysViewTest.stg.
 */
public class ImmutableObjectFloatHashMapKeysViewTest extends AbstractObjectFloatMapKeysViewTestCase
{
    @Override
    public <T> ImmutableObjectFloatMap<T> newWithKeysValues(T key1, float value1, T key2, float value2, T key3, float value3)
    {
        return ObjectFloatHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).toImmutable();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements)
    {
        ObjectFloatHashMap<T> map = new ObjectFloatHashMap<>();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], i);
        }
        return map.toImmutable().keysView();
    }
}
