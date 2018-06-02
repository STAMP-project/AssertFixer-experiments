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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableIntDoubleMap;
import org.eclipse.collections.api.map.primitive.IntDoubleMap;

/**
 * ImmutableIntDoubleMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableIntDoubleMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableIntDoubleMapFactoryImpl implements ImmutableIntDoubleMapFactory
{
    INSTANCE;

    @Override
    public ImmutableIntDoubleMap empty()
    {
        return ImmutableIntDoubleEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableIntDoubleMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntDoubleMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntDoubleMap of(int key, double value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableIntDoubleMap with(int key, double value)
    {
        return new ImmutableIntDoubleSingletonMap(key, value);
    }

    @Override
    public ImmutableIntDoubleMap ofAll(IntDoubleMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableIntDoubleMap withAll(IntDoubleMap map)
    {
        if (map instanceof ImmutableIntDoubleMap)
        {
            return (ImmutableIntDoubleMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            int key = map.keysView().intIterator().next();
            return new ImmutableIntDoubleSingletonMap(key, map.get(key));
        }
        return new ImmutableIntDoubleHashMap(map);
    }
}
