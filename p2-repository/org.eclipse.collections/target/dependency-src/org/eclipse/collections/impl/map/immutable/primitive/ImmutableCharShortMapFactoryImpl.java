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

import org.eclipse.collections.api.factory.map.primitive.ImmutableCharShortMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableCharShortMap;
import org.eclipse.collections.api.map.primitive.CharShortMap;

/**
 * ImmutableCharShortMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableCharShortMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableCharShortMapFactoryImpl implements ImmutableCharShortMapFactory
{
    INSTANCE;

    @Override
    public ImmutableCharShortMap empty()
    {
        return ImmutableCharShortEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableCharShortMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharShortMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableCharShortMap of(char key, short value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableCharShortMap with(char key, short value)
    {
        return new ImmutableCharShortSingletonMap(key, value);
    }

    @Override
    public ImmutableCharShortMap ofAll(CharShortMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableCharShortMap withAll(CharShortMap map)
    {
        if (map instanceof ImmutableCharShortMap)
        {
            return (ImmutableCharShortMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            char key = map.keysView().charIterator().next();
            return new ImmutableCharShortSingletonMap(key, map.get(key));
        }
        return new ImmutableCharShortHashMap(map);
    }
}
