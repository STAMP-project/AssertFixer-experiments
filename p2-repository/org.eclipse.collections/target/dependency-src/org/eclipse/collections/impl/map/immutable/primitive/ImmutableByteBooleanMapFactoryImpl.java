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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteBooleanMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableByteBooleanMap;
import org.eclipse.collections.api.map.primitive.ByteBooleanMap;

/**
 * ImmutableByteBooleanMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableByteBooleanMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableByteBooleanMapFactoryImpl implements ImmutableByteBooleanMapFactory
{
    INSTANCE;

    @Override
    public ImmutableByteBooleanMap empty()
    {
        return ImmutableByteBooleanEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableByteBooleanMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteBooleanMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteBooleanMap of(byte key, boolean value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableByteBooleanMap with(byte key, boolean value)
    {
        return new ImmutableByteBooleanSingletonMap(key, value);
    }

    @Override
    public ImmutableByteBooleanMap ofAll(ByteBooleanMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableByteBooleanMap withAll(ByteBooleanMap map)
    {
        if (map instanceof ImmutableByteBooleanMap)
        {
            return (ImmutableByteBooleanMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            byte key = map.keysView().byteIterator().next();
            return new ImmutableByteBooleanSingletonMap(key, map.get(key));
        }
        return new ImmutableByteBooleanHashMap(map);
    }
}
