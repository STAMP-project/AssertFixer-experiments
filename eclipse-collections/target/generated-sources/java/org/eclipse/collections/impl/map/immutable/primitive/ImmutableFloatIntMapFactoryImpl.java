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

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatIntMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableFloatIntMap;
import org.eclipse.collections.api.map.primitive.FloatIntMap;

/**
 * ImmutableFloatIntMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableFloatIntMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableFloatIntMapFactoryImpl implements ImmutableFloatIntMapFactory
{
    INSTANCE;

    @Override
    public ImmutableFloatIntMap empty()
    {
        return ImmutableFloatIntEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableFloatIntMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatIntMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatIntMap of(float key, int value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableFloatIntMap with(float key, int value)
    {
        return new ImmutableFloatIntSingletonMap(key, value);
    }

    @Override
    public ImmutableFloatIntMap ofAll(FloatIntMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableFloatIntMap withAll(FloatIntMap map)
    {
        if (map instanceof ImmutableFloatIntMap)
        {
            return (ImmutableFloatIntMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            float key = map.keysView().floatIterator().next();
            return new ImmutableFloatIntSingletonMap(key, map.get(key));
        }
        return new ImmutableFloatIntHashMap(map);
    }
}
