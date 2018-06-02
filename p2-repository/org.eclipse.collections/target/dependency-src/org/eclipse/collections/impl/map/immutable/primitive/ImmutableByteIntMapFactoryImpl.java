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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteIntMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableByteIntMap;
import org.eclipse.collections.api.map.primitive.ByteIntMap;

/**
 * ImmutableByteIntMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableByteIntMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableByteIntMapFactoryImpl implements ImmutableByteIntMapFactory
{
    INSTANCE;

    @Override
    public ImmutableByteIntMap empty()
    {
        return ImmutableByteIntEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableByteIntMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteIntMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteIntMap of(byte key, int value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableByteIntMap with(byte key, int value)
    {
        return new ImmutableByteIntSingletonMap(key, value);
    }

    @Override
    public ImmutableByteIntMap ofAll(ByteIntMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableByteIntMap withAll(ByteIntMap map)
    {
        if (map instanceof ImmutableByteIntMap)
        {
            return (ImmutableByteIntMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            byte key = map.keysView().byteIterator().next();
            return new ImmutableByteIntSingletonMap(key, map.get(key));
        }
        return new ImmutableByteIntHashMap(map);
    }
}
