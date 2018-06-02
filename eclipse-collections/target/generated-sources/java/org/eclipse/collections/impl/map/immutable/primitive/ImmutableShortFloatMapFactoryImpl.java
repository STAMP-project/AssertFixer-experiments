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

import org.eclipse.collections.api.factory.map.primitive.ImmutableShortFloatMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableShortFloatMap;
import org.eclipse.collections.api.map.primitive.ShortFloatMap;

/**
 * ImmutableShortFloatMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableShortFloatMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableShortFloatMapFactoryImpl implements ImmutableShortFloatMapFactory
{
    INSTANCE;

    @Override
    public ImmutableShortFloatMap empty()
    {
        return ImmutableShortFloatEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableShortFloatMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortFloatMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableShortFloatMap of(short key, float value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableShortFloatMap with(short key, float value)
    {
        return new ImmutableShortFloatSingletonMap(key, value);
    }

    @Override
    public ImmutableShortFloatMap ofAll(ShortFloatMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableShortFloatMap withAll(ShortFloatMap map)
    {
        if (map instanceof ImmutableShortFloatMap)
        {
            return (ImmutableShortFloatMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            short key = map.keysView().shortIterator().next();
            return new ImmutableShortFloatSingletonMap(key, map.get(key));
        }
        return new ImmutableShortFloatHashMap(map);
    }
}
