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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongCharMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableLongCharMap;
import org.eclipse.collections.api.map.primitive.LongCharMap;

/**
 * ImmutableLongCharMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableLongCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableLongCharMapFactoryImpl implements ImmutableLongCharMapFactory
{
    INSTANCE;

    @Override
    public ImmutableLongCharMap empty()
    {
        return ImmutableLongCharEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableLongCharMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongCharMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongCharMap of(long key, char value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableLongCharMap with(long key, char value)
    {
        return new ImmutableLongCharSingletonMap(key, value);
    }

    @Override
    public ImmutableLongCharMap ofAll(LongCharMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableLongCharMap withAll(LongCharMap map)
    {
        if (map instanceof ImmutableLongCharMap)
        {
            return (ImmutableLongCharMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            long key = map.keysView().longIterator().next();
            return new ImmutableLongCharSingletonMap(key, map.get(key));
        }
        return new ImmutableLongCharHashMap(map);
    }
}
