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

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.map.primitive.MutableObjectCharMap;
import org.eclipse.collections.impl.map.primitive.AbstractObjectCharMapKeysViewTestCase;

/**
 * JUnit test for {@link SynchronizedObjectCharMap#keysView()}.
 * This file was automatically generated from template file synchronizedObjectPrimitiveMapKeysViewTest.stg.
 */
public class SynchronizedObjectCharMapKeysViewTest extends AbstractObjectCharMapKeysViewTestCase
{
    @Override
    public <T> MutableObjectCharMap<T> newWithKeysValues(T key1, char value1, T key2, char value2, T key3, char value3)
    {
        return ObjectCharHashMap.newWithKeysValues(key1, value1, key2, value2, key3, value3).asSynchronized();
    }

    @Override
    protected <T> LazyIterable<T> newWith(T... elements)
    {
        MutableObjectCharMap<T> map = ObjectCharHashMap.newMap();
        for (int i = 0; i < elements.length; i++)
        {
            map.put(elements[i], (char) i);
        }
        return map.asSynchronized().keysView();
    }
}
