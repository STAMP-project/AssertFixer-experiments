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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntShortMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableIntShortMap;
import org.eclipse.collections.api.map.primitive.IntShortMap;

/**
 * ImmutableIntShortMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableIntShortMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableIntShortMapFactoryImpl implements ImmutableIntShortMapFactory
{
    INSTANCE;

    @Override
    public ImmutableIntShortMap empty()
    {
        return ImmutableIntShortEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableIntShortMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntShortMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntShortMap of(int key, short value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableIntShortMap with(int key, short value)
    {
        return new ImmutableIntShortSingletonMap(key, value);
    }

    @Override
    public ImmutableIntShortMap ofAll(IntShortMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableIntShortMap withAll(IntShortMap map)
    {
        if (map instanceof ImmutableIntShortMap)
        {
            return (ImmutableIntShortMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            int key = map.keysView().intIterator().next();
            return new ImmutableIntShortSingletonMap(key, map.get(key));
        }
        return new ImmutableIntShortHashMap(map);
    }
}
