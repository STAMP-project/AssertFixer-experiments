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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleFloatMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleFloatMap;
import org.eclipse.collections.api.map.primitive.DoubleFloatMap;

/**
 * ImmutableDoubleFloatMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableDoubleFloatMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableDoubleFloatMapFactoryImpl implements ImmutableDoubleFloatMapFactory
{
    INSTANCE;

    @Override
    public ImmutableDoubleFloatMap empty()
    {
        return ImmutableDoubleFloatEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableDoubleFloatMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleFloatMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleFloatMap of(double key, float value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableDoubleFloatMap with(double key, float value)
    {
        return new ImmutableDoubleFloatSingletonMap(key, value);
    }

    @Override
    public ImmutableDoubleFloatMap ofAll(DoubleFloatMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableDoubleFloatMap withAll(DoubleFloatMap map)
    {
        if (map instanceof ImmutableDoubleFloatMap)
        {
            return (ImmutableDoubleFloatMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            double key = map.keysView().doubleIterator().next();
            return new ImmutableDoubleFloatSingletonMap(key, map.get(key));
        }
        return new ImmutableDoubleFloatHashMap(map);
    }
}
