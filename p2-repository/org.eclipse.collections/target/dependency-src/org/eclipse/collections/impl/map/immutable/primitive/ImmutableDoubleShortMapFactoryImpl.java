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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleShortMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleShortMap;
import org.eclipse.collections.api.map.primitive.DoubleShortMap;

/**
 * ImmutableDoubleShortMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableDoubleShortMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableDoubleShortMapFactoryImpl implements ImmutableDoubleShortMapFactory
{
    INSTANCE;

    @Override
    public ImmutableDoubleShortMap empty()
    {
        return ImmutableDoubleShortEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableDoubleShortMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleShortMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleShortMap of(double key, short value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableDoubleShortMap with(double key, short value)
    {
        return new ImmutableDoubleShortSingletonMap(key, value);
    }

    @Override
    public ImmutableDoubleShortMap ofAll(DoubleShortMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableDoubleShortMap withAll(DoubleShortMap map)
    {
        if (map instanceof ImmutableDoubleShortMap)
        {
            return (ImmutableDoubleShortMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            double key = map.keysView().doubleIterator().next();
            return new ImmutableDoubleShortSingletonMap(key, map.get(key));
        }
        return new ImmutableDoubleShortHashMap(map);
    }
}
