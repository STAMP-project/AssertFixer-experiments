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

import org.eclipse.collections.api.factory.map.primitive.MutableIntObjectMapFactory;
import org.eclipse.collections.api.map.primitive.MutableIntObjectMap;
import org.eclipse.collections.api.map.primitive.IntObjectMap;

/**
 * MutableIntObjectMapFactoryImpl is a factory implementation which creates instances of type {@link MutableIntObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableIntObjectMapFactoryImpl implements MutableIntObjectMapFactory
{
   INSTANCE;

    @Override
    public <V> MutableIntObjectMap<V> empty()
    {
        return new IntObjectHashMap(0);
    }

    @Override
    public <V> MutableIntObjectMap<V> of()
    {
        return this.empty();
    }

    @Override
    public <V> MutableIntObjectMap<V> with()
    {
        return this.empty();
    }

    @Override
    public <V> MutableIntObjectMap<V> ofAll(IntObjectMap<? extends V> map)
    {
        return this.withAll(map);
    }

    @Override
    public <V> MutableIntObjectMap<V> withAll(IntObjectMap<? extends V> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new IntObjectHashMap<>(map);
    }
}
