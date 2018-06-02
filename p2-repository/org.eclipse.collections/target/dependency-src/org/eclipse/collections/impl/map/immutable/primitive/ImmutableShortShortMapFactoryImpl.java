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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortShortMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableShortShortMap;
import org.eclipse.collections.api.map.primitive.ShortShortMap;

/**
 * ImmutableShortShortMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableShortShortMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableShortShortMapFactoryImpl implements ImmutableShortShortMapFactory
{
    INSTANCE;

    @Override
    public ImmutableShortShortMap empty()
    {
        return ImmutableShortShortEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableShortShortMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortShortMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortShortMap of(short key, short value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableShortShortMap with(short key, short value)
    {
        return new ImmutableShortShortSingletonMap(key, value);
    }

    @Override
    public ImmutableShortShortMap ofAll(ShortShortMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableShortShortMap withAll(ShortShortMap map)
    {
        if (map instanceof ImmutableShortShortMap)
        {
            return (ImmutableShortShortMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            short key = map.keysView().shortIterator().next();
            return new ImmutableShortShortSingletonMap(key, map.get(key));
        }
        return new ImmutableShortShortHashMap(map);
    }
}
