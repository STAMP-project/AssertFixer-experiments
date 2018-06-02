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

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatShortMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableFloatShortMap;
import org.eclipse.collections.api.map.primitive.FloatShortMap;

/**
 * ImmutableFloatShortMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableFloatShortMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableFloatShortMapFactoryImpl implements ImmutableFloatShortMapFactory
{
    INSTANCE;

    @Override
    public ImmutableFloatShortMap empty()
    {
        return ImmutableFloatShortEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableFloatShortMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatShortMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatShortMap of(float key, short value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableFloatShortMap with(float key, short value)
    {
        return new ImmutableFloatShortSingletonMap(key, value);
    }

    @Override
    public ImmutableFloatShortMap ofAll(FloatShortMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableFloatShortMap withAll(FloatShortMap map)
    {
        if (map instanceof ImmutableFloatShortMap)
        {
            return (ImmutableFloatShortMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            float key = map.keysView().floatIterator().next();
            return new ImmutableFloatShortSingletonMap(key, map.get(key));
        }
        return new ImmutableFloatShortHashMap(map);
    }
}
