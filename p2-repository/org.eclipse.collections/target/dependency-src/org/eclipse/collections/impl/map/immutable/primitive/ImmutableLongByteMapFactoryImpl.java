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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongByteMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableLongByteMap;
import org.eclipse.collections.api.map.primitive.LongByteMap;

/**
 * ImmutableLongByteMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableLongByteMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableLongByteMapFactoryImpl implements ImmutableLongByteMapFactory
{
    INSTANCE;

    @Override
    public ImmutableLongByteMap empty()
    {
        return ImmutableLongByteEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableLongByteMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongByteMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongByteMap of(long key, byte value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableLongByteMap with(long key, byte value)
    {
        return new ImmutableLongByteSingletonMap(key, value);
    }

    @Override
    public ImmutableLongByteMap ofAll(LongByteMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableLongByteMap withAll(LongByteMap map)
    {
        if (map instanceof ImmutableLongByteMap)
        {
            return (ImmutableLongByteMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            long key = map.keysView().longIterator().next();
            return new ImmutableLongByteSingletonMap(key, map.get(key));
        }
        return new ImmutableLongByteHashMap(map);
    }
}
