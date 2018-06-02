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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntLongMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableIntLongMap;
import org.eclipse.collections.api.map.primitive.IntLongMap;

/**
 * ImmutableIntLongMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableIntLongMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableIntLongMapFactoryImpl implements ImmutableIntLongMapFactory
{
    INSTANCE;

    @Override
    public ImmutableIntLongMap empty()
    {
        return ImmutableIntLongEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableIntLongMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntLongMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntLongMap of(int key, long value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableIntLongMap with(int key, long value)
    {
        return new ImmutableIntLongSingletonMap(key, value);
    }

    @Override
    public ImmutableIntLongMap ofAll(IntLongMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableIntLongMap withAll(IntLongMap map)
    {
        if (map instanceof ImmutableIntLongMap)
        {
            return (ImmutableIntLongMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            int key = map.keysView().intIterator().next();
            return new ImmutableIntLongSingletonMap(key, map.get(key));
        }
        return new ImmutableIntLongHashMap(map);
    }
}
