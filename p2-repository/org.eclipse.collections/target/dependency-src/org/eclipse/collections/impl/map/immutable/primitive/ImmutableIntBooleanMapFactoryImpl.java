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

import org.eclipse.collections.api.factory.map.primitive.ImmutableIntBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableIntBooleanMap;
import org.eclipse.collections.api.map.primitive.IntBooleanMap;

/**
 * ImmutableIntBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableIntBooleanMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableIntBooleanMapFactoryImpl implements ImmutableIntBooleanMapFactory
{
    INSTANCE;

    @Override
    public ImmutableIntBooleanMap empty()
    {
        return ImmutableIntBooleanEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableIntBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableIntBooleanMap of(int key, boolean value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableIntBooleanMap with(int key, boolean value)
    {
        return new ImmutableIntBooleanSingletonMap(key, value);
    }

    @Override
    public ImmutableIntBooleanMap ofAll(IntBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableIntBooleanMap withAll(IntBooleanMap map)
    {
        if (map instanceof ImmutableIntBooleanMap)
        {
            return (ImmutableIntBooleanMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            int key = map.keysView().intIterator().next();
            return new ImmutableIntBooleanSingletonMap(key, map.get(key));
        }
        return new ImmutableIntBooleanHashMap(map);
    }
}
