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

import org.eclipse.collections.api.factory.map.primitive.MutableShortObjectMapFactory;
import org.eclipse.collections.api.map.primitive.MutableShortObjectMap;
import org.eclipse.collections.api.map.primitive.ShortObjectMap;

/**
 * MutableShortObjectMapFactoryImpl is a factory implementation which creates instances of type {@link MutableShortObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableShortObjectMapFactoryImpl implements MutableShortObjectMapFactory
{
   INSTANCE;

    @Override
    public <V> MutableShortObjectMap<V> empty()
    {
        return new ShortObjectHashMap(0);
    }

    @Override
    public <V> MutableShortObjectMap<V> of()
    {
        return this.empty();
    }

    @Override
    public <V> MutableShortObjectMap<V> with()
    {
        return this.empty();
    }

    @Override
    public <V> MutableShortObjectMap<V> ofAll(ShortObjectMap<? extends V> map)
    {
        return this.withAll(map);
    }

    @Override
    public <V> MutableShortObjectMap<V> withAll(ShortObjectMap<? extends V> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ShortObjectHashMap<>(map);
    }
}
