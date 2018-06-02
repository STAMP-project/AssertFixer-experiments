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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteLongMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableByteLongMap;
import org.eclipse.collections.api.map.primitive.ByteLongMap;

/**
 * ImmutableByteLongMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableByteLongMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableByteLongMapFactoryImpl implements ImmutableByteLongMapFactory
{
    INSTANCE;

    @Override
    public ImmutableByteLongMap empty()
    {
        return ImmutableByteLongEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableByteLongMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteLongMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteLongMap of(byte key, long value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableByteLongMap with(byte key, long value)
    {
        return new ImmutableByteLongSingletonMap(key, value);
    }

    @Override
    public ImmutableByteLongMap ofAll(ByteLongMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableByteLongMap withAll(ByteLongMap map)
    {
        if (map instanceof ImmutableByteLongMap)
        {
            return (ImmutableByteLongMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            byte key = map.keysView().byteIterator().next();
            return new ImmutableByteLongSingletonMap(key, map.get(key));
        }
        return new ImmutableByteLongHashMap(map);
    }
}
