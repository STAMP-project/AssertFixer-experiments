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

import org.eclipse.collections.api.factory.map.primitive.MutableByteObjectMapFactory;
import org.eclipse.collections.api.map.primitive.MutableByteObjectMap;
import org.eclipse.collections.api.map.primitive.ByteObjectMap;

/**
 * MutableByteObjectMapFactoryImpl is a factory implementation which creates instances of type {@link MutableByteObjectMap}.
 * This file was automatically generated from template file mutablePrimitiveObjectMapFactoryImpl.stg.
 *
 * @since 6.0.
 */
public enum MutableByteObjectMapFactoryImpl implements MutableByteObjectMapFactory
{
   INSTANCE;

    @Override
    public <V> MutableByteObjectMap<V> empty()
    {
        return new ByteObjectHashMap(0);
    }

    @Override
    public <V> MutableByteObjectMap<V> of()
    {
        return this.empty();
    }

    @Override
    public <V> MutableByteObjectMap<V> with()
    {
        return this.empty();
    }

    @Override
    public <V> MutableByteObjectMap<V> ofAll(ByteObjectMap<? extends V> map)
    {
        return this.withAll(map);
    }

    @Override
    public <V> MutableByteObjectMap<V> withAll(ByteObjectMap<? extends V> map)
    {
        if (map.isEmpty())
        {
            return this.empty();
        }
        return new ByteObjectHashMap<>(map);
    }
}
