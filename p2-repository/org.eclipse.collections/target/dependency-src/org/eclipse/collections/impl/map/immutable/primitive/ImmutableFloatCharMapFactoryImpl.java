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

import org.eclipse.collections.api.factory.map.primitive.ImmutableFloatCharMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableFloatCharMap;
import org.eclipse.collections.api.map.primitive.FloatCharMap;

/**
 * ImmutableFloatCharMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableFloatCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableFloatCharMapFactoryImpl implements ImmutableFloatCharMapFactory
{
    INSTANCE;

    @Override
    public ImmutableFloatCharMap empty()
    {
        return ImmutableFloatCharEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableFloatCharMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatCharMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableFloatCharMap of(float key, char value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableFloatCharMap with(float key, char value)
    {
        return new ImmutableFloatCharSingletonMap(key, value);
    }

    @Override
    public ImmutableFloatCharMap ofAll(FloatCharMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableFloatCharMap withAll(FloatCharMap map)
    {
        if (map instanceof ImmutableFloatCharMap)
        {
            return (ImmutableFloatCharMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            float key = map.keysView().floatIterator().next();
            return new ImmutableFloatCharSingletonMap(key, map.get(key));
        }
        return new ImmutableFloatCharHashMap(map);
    }
}
