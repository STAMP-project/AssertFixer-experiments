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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntCharMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableIntCharMap;
import org.eclipse.collections.api.map.primitive.IntCharMap;

/**
 * ImmutableIntCharMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableIntCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableIntCharMapFactoryImpl implements ImmutableIntCharMapFactory
{
    INSTANCE;

    @Override
    public ImmutableIntCharMap empty()
    {
        return ImmutableIntCharEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableIntCharMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntCharMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntCharMap of(int key, char value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableIntCharMap with(int key, char value)
    {
        return new ImmutableIntCharSingletonMap(key, value);
    }

    @Override
    public ImmutableIntCharMap ofAll(IntCharMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableIntCharMap withAll(IntCharMap map)
    {
        if (map instanceof ImmutableIntCharMap)
        {
            return (ImmutableIntCharMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            int key = map.keysView().intIterator().next();
            return new ImmutableIntCharSingletonMap(key, map.get(key));
        }
        return new ImmutableIntCharHashMap(map);
    }
}
