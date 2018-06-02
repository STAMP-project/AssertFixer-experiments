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

import org.eclipse.collections.api.factory.map.primitive.MutableCharObjectMapFactory;
import org.eclipse.collections.api.map.primitive.MutableCharObjectMap;
import org.eclipse.collections.api.map.primitive.CharObjectMap;

/**
 * MutableCharObjectMapFactoryImpl is a factory implementation which creates instances of type {@link MutableCharObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableCharObjectMapFactoryImpl implements MutableCharObjectMapFactory
{
   INSTANCE;

    @Override
    public <V> MutableCharObjectMap<V> empty()
    {
        return new CharObjectHashMap(0);
    }

    @Override
    public <V> MutableCharObjectMap<V> of()
    {
        return this.empty();
    }

    @Override
    public <V> MutableCharObjectMap<V> with()
    {
        return this.empty();
    }

    @Override
    public <V> MutableCharObjectMap<V> ofAll(CharObjectMap<? extends V> map)
    {
        return this.withAll(map);
    }

    @Override
    public <V> MutableCharObjectMap<V> withAll(CharObjectMap<? extends V> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new CharObjectHashMap<>(map);
    }
}
