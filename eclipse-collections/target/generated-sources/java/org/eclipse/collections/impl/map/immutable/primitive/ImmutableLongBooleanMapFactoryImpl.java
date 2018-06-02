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

import org.eclipse.collections.api.factory.map.primitive.ImmutableLongBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableLongBooleanMap;
import org.eclipse.collections.api.map.primitive.LongBooleanMap;

/**
 * ImmutableLongBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableLongBooleanMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableLongBooleanMapFactoryImpl implements ImmutableLongBooleanMapFactory
{
    INSTANCE;

    @Override
    public ImmutableLongBooleanMap empty()
    {
        return ImmutableLongBooleanEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableLongBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableLongBooleanMap of(long key, boolean value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableLongBooleanMap with(long key, boolean value)
    {
        return new ImmutableLongBooleanSingletonMap(key, value);
    }

    @Override
    public ImmutableLongBooleanMap ofAll(LongBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableLongBooleanMap withAll(LongBooleanMap map)
    {
        if (map instanceof ImmutableLongBooleanMap)
        {
            return (ImmutableLongBooleanMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            long key = map.keysView().longIterator().next();
            return new ImmutableLongBooleanSingletonMap(key, map.get(key));
        }
        return new ImmutableLongBooleanHashMap(map);
    }
}
