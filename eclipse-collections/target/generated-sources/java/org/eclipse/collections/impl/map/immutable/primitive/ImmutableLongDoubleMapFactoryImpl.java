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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongDoubleMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableLongDoubleMap;
import org.eclipse.collections.api.map.primitive.LongDoubleMap;

/**
 * ImmutableLongDoubleMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableLongDoubleMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableLongDoubleMapFactoryImpl implements ImmutableLongDoubleMapFactory
{
    INSTANCE;

    @Override
    public ImmutableLongDoubleMap empty()
    {
        return ImmutableLongDoubleEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableLongDoubleMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongDoubleMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongDoubleMap of(long key, double value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableLongDoubleMap with(long key, double value)
    {
        return new ImmutableLongDoubleSingletonMap(key, value);
    }

    @Override
    public ImmutableLongDoubleMap ofAll(LongDoubleMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableLongDoubleMap withAll(LongDoubleMap map)
    {
        if (map instanceof ImmutableLongDoubleMap)
        {
            return (ImmutableLongDoubleMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            long key = map.keysView().longIterator().next();
            return new ImmutableLongDoubleSingletonMap(key, map.get(key));
        }
        return new ImmutableLongDoubleHashMap(map);
    }
}
