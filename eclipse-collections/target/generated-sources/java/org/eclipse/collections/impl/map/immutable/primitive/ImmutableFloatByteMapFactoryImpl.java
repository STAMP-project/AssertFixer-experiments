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

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatByteMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableFloatByteMap;
import org.eclipse.collections.api.map.primitive.FloatByteMap;

/**
 * ImmutableFloatByteMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableFloatByteMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableFloatByteMapFactoryImpl implements ImmutableFloatByteMapFactory
{
    INSTANCE;

    @Override
    public ImmutableFloatByteMap empty()
    {
        return ImmutableFloatByteEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableFloatByteMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatByteMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatByteMap of(float key, byte value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableFloatByteMap with(float key, byte value)
    {
        return new ImmutableFloatByteSingletonMap(key, value);
    }

    @Override
    public ImmutableFloatByteMap ofAll(FloatByteMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableFloatByteMap withAll(FloatByteMap map)
    {
        if (map instanceof ImmutableFloatByteMap)
        {
            return (ImmutableFloatByteMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            float key = map.keysView().floatIterator().next();
            return new ImmutableFloatByteSingletonMap(key, map.get(key));
        }
        return new ImmutableFloatByteHashMap(map);
    }
}
