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

import org.eclipse.collections.api.factory.map.primitive.ImmutableDoubleCharMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableDoubleCharMap;
import org.eclipse.collections.api.map.primitive.DoubleCharMap;

/**
 * ImmutableDoubleCharMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableDoubleCharMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableDoubleCharMapFactoryImpl implements ImmutableDoubleCharMapFactory
{
    INSTANCE;

    @Override
    public ImmutableDoubleCharMap empty()
    {
        return ImmutableDoubleCharEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableDoubleCharMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleCharMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableDoubleCharMap of(double key, char value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableDoubleCharMap with(double key, char value)
    {
        return new ImmutableDoubleCharSingletonMap(key, value);
    }

    @Override
    public ImmutableDoubleCharMap ofAll(DoubleCharMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableDoubleCharMap withAll(DoubleCharMap map)
    {
        if (map instanceof ImmutableDoubleCharMap)
        {
            return (ImmutableDoubleCharMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            double key = map.keysView().doubleIterator().next();
            return new ImmutableDoubleCharSingletonMap(key, map.get(key));
        }
        return new ImmutableDoubleCharHashMap(map);
    }
}
