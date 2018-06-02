/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.impl.map.mutable.primitive;

import org.eclipse.collections.api.factory.map.primitive.MutableByteIntMapFactory;
import org.eclipse.collections.api.map.primitive.MutableByteIntMap;
import org.eclipse.collections.api.map.primitive.ByteIntMap;

/**
 * MutableByteIntMapFactoryImpl is a factory implementation which creates instances of type {@link MutableByteIntMap}.
 * This file was automatically generated from template file mutablePrimitivePrimitiveMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableByteIntMapFactoryImpl implements MutableByteIntMapFactory
{
    INSTANCE;

    @Override
    public MutableByteIntMap empty()
    {
        return new ByteIntHashMap(0);
    }

    @Override
    public MutableByteIntMap of()
    {
        return this.empty();
    }

    @Override
    public MutableByteIntMap with()
    {
        return this.empty();
    }

    @Override
    public MutableByteIntMap ofAll(ByteIntMap map)
    {
        return this.withAll(map);
    }

    @Override
    public MutableByteIntMap withAll(ByteIntMap map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ByteIntHashMap(map);
    }
}
