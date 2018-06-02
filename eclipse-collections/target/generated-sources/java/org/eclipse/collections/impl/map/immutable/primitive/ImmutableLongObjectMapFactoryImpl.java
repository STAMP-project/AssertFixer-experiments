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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongObjectMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableLongObjectMap;
import org.eclipse.collections.api.map.primitive.LongObjectMap;

/**
 * ImmutableLongObjectMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableLongObjectMap}.
 * This file was automatically generated from template file immutablePrimitiveObjectMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableLongObjectMapFactoryImpl implements ImmutableLongObjectMapFactory
{
    INSTANCE;

    @Override
    public <V> ImmutableLongObjectMap<V> empty()
    {
        return (ImmutableLongObjectMap<V>) ImmutableLongObjectEmptyMap.INSTANCE;
    }

    @Override
    public <V> ImmutableLongObjectMap<V> of()
    {
        return this.empty();
    }

    @Override
    public <V> ImmutableLongObjectMap<V> with()
    {
        return this.empty();
    }

    @Override
    public <V> ImmutableLongObjectMap<V> of(long key, V value)
    {
        return this.with(key, value);
    }

    @Override
    public <V> ImmutableLongObjectMap<V> with(long key, V value)
    {
        return new ImmutableLongObjectSingletonMap<>(key, value);
    }

    @Override
    public <V> ImmutableLongObjectMap<V> ofAll(LongObjectMap<? extends V> map)
    {
        return this.withAll(map);
    }

    @Override
    public <V> ImmutableLongObjectMap<V> withAll(LongObjectMap<? extends V> map)
    {
        if (map instanceof ImmutableLongObjectMap)
        {
            return (ImmutableLongObjectMap<V>) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            //TODO use keysView() when available.
            final long[] array = new long[1];
            map.forEachKey((long each) -> array[0] = each);
            return new ImmutableLongObjectSingletonMap<>(array[0], map.get(array[0]));
        }
        return new ImmutableLongObjectHashMap<>(map);
    }
}
