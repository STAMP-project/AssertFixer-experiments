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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortLongMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableShortLongMap;
import org.eclipse.collections.api.map.primitive.ShortLongMap;

/**
 * ImmutableShortLongMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableShortLongMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableShortLongMapFactoryImpl implements ImmutableShortLongMapFactory
{
    INSTANCE;

    @Override
    public ImmutableShortLongMap empty()
    {
        return ImmutableShortLongEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableShortLongMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortLongMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortLongMap of(short key, long value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableShortLongMap with(short key, long value)
    {
        return new ImmutableShortLongSingletonMap(key, value);
    }

    @Override
    public ImmutableShortLongMap ofAll(ShortLongMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableShortLongMap withAll(ShortLongMap map)
    {
        if (map instanceof ImmutableShortLongMap)
        {
            return (ImmutableShortLongMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            short key = map.keysView().shortIterator().next();
            return new ImmutableShortLongSingletonMap(key, map.get(key));
        }
        return new ImmutableShortLongHashMap(map);
    }
}
