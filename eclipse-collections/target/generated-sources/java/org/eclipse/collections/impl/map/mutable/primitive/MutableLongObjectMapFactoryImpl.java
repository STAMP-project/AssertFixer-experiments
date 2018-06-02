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

import org.eclipse.collections.api.factory.map.primitive.MutableLongObjectMapFactory;
import org.eclipse.collections.api.map.primitive.MutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.LongObjectMap;

/**
 * MutableLongObjectMapFactoryImpl is a factory implementation which creates instances of type {@link MutableLongObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableLongObjectMapFactoryImpl implements MutableLongObjectMapFactory
{
   INSTANCE;

    @Override
    public <V> MutableLongObjectMap<V> empty()
    {
        return new LongObjectHashMap(0);
    }

    @Override
    public <V> MutableLongObjectMap<V> of()
    {
        return this.empty();
    }

    @Override
    public <V> MutableLongObjectMap<V> with()
    {
        return this.empty();
    }

    @Override
    public <V> MutableLongObjectMap<V> ofAll(LongObjectMap<? extends V> map)
    {
        return this.withAll(map);
    }

    @Override
    public <V> MutableLongObjectMap<V> withAll(LongObjectMap<? extends V> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new LongObjectHashMap<>(map);
    }
}
