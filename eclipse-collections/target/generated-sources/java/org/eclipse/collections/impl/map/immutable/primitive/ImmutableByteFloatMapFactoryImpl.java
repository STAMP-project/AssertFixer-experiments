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

import org.eclipse.collections.api.factory.map.primitive.ImmutableByteFloatMapFactory;
import org.eclipse.collections.api.map.primitive.ImmutableByteFloatMap;
import org.eclipse.collections.api.map.primitive.ByteFloatMap;

/**
 * ImmutableByteFloatMapFactoryImpl is a factory implementation which creates instances of type {@link ImmutableByteFloatMap}.
 * This file was automatically generated from template file immutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 4.0.
 */
public enum ImmutableByteFloatMapFactoryImpl implements ImmutableByteFloatMapFactory
{
    INSTANCE;

    @Override
    public ImmutableByteFloatMap empty()
    {
        return ImmutableByteFloatEmptyMap.INSTANCE;
    }

    @Override
    public ImmutableByteFloatMap of()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteFloatMap with()
    {
        return this.empty();
    }

    @Override
    public ImmutableByteFloatMap of(byte key, float value)
    {
        return this.with(key, value);
    }

    @Override
    public ImmutableByteFloatMap with(byte key, float value)
    {
        return new ImmutableByteFloatSingletonMap(key, value);
    }

    @Override
    public ImmutableByteFloatMap ofAll(ByteFloatMap map)
    {
        return this.withAll(map);
    }

    @Override
    public ImmutableByteFloatMap withAll(ByteFloatMap map)
    {
        if (map instanceof ImmutableByteFloatMap)
        {
            return (ImmutableByteFloatMap) map;
        }
        if (map.isEmpty())
        {
            return this.with();
        }
        if (map.size() == 1)
        {
            byte key = map.keysView().byteIterator().next();
            return new ImmutableByteFloatSingletonMap(key, map.get(key));
        }
        return new ImmutableByteFloatHashMap(map);
    }
}
